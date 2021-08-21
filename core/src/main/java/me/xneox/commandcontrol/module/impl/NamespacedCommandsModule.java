package me.xneox.commandcontrol.module.impl;

import java.util.UUID;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.config.PluginConfiguration;
import me.xneox.commandcontrol.module.Module;
import me.xneox.commandcontrol.util.AdventureUtils;
import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;

public class NamespacedCommandsModule extends Module {
  public NamespacedCommandsModule(CommandControl commandControl) {
    super(commandControl);
  }

  @Override
  public boolean handle(@NotNull Audience sender, @NotNull UUID uuid, @NotNull String command) {
    PluginConfiguration.NamespacedCommands config = this.commandControl.config().namespacedCommands();
    if (!config.enabled()) {
      return false;
    }

    if (command.contains(":")) {
      if (config.useBypassPermission() && this.commandControl.platform().hasPermission(uuid, "commandcontrol.bypass.namespaced-commands")) {
        return false; // Player has bypass permission, skipping...
      }

      if (config.useWhitelist() && config.whitelistedCommands().stream().anyMatch(command::startsWith)) {
        return false; // Command is whitelisted, skipping...
      }

      sender.sendMessage(AdventureUtils.color(config.failMessage()));
      return true;
    }
    return false;
  }
}
