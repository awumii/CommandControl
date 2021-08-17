package me.xneox.commandcontrol.command;

import java.util.Collections;
import java.util.List;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.util.AdventureUtils;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

// TODO: get rid of the legacy colors
public class CommandHandler {
  private final CommandControl commandControl;

  public CommandHandler(CommandControl commandControl) {
    this.commandControl = commandControl;
  }

  public void handle(@NonNull Audience sender, @NonNull String[] args) {
    if (args.length < 1) {
      sender.sendMessage(AdventureUtils.color("&b&lCommandControl &bby xNeox"));
      sender.sendMessage(AdventureUtils.color("&7&o&nhttps://github.com/xxneox/CommandControl"));
      sender.sendMessage(Component.empty());
      sender.sendMessage(AdventureUtils.color("&bModule status:"));
      sender.sendMessage(
          AdventureUtils.color(
              "  &7AllowedCommands: &f"
                  + this.commandControl.config().allowedCommands().enabled()));
      sender.sendMessage(
          AdventureUtils.color(
              "  &7BlockedCommands: &f"
                  + this.commandControl.config().blockedCommands().enabled()));
      sender.sendMessage(
          AdventureUtils.color(
              "  &7CustomTabComplete: &f"
                  + this.commandControl.config().customTabComplete().enabled()));
      sender.sendMessage(
          AdventureUtils.color(
              "  &7NamespacedCommands: &f"
                  + this.commandControl.config().namespacedCommands().enabled()));
      sender.sendMessage(
          AdventureUtils.color(
              "  &7OperatorProtection: &f"
                  + this.commandControl.config().operatorProtection().enabled()));
      sender.sendMessage(Component.empty());
      sender.sendMessage(
          AdventureUtils.color("&7Use &f/commandcontrol reload &7to reload the configuration."));
      return;
    }

    if (args[0].equalsIgnoreCase("reload")) {
      this.commandControl.loadConfig();
      sender.sendMessage(AdventureUtils.color("&aConfiguration reloaded!"));
    } else {
      sender.sendMessage(AdventureUtils.color("&cCommand not found. Use /commancontrol for help."));
    }
  }

  @Nullable
  public List<String> suggest(@NonNull String[] args) {
    if (args.length == 1) {
      return Collections.singletonList("reload");
    }
    return null;
  }
}
