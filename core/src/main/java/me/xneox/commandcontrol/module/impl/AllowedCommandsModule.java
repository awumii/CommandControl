package me.xneox.commandcontrol.module.impl;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.config.PluginConfiguration;
import me.xneox.commandcontrol.module.Module;
import me.xneox.commandcontrol.util.AdventureUtils;
import net.kyori.adventure.audience.Audience;
import org.checkerframework.checker.nullness.qual.NonNull;

public class AllowedCommandsModule extends Module {
  public AllowedCommandsModule(CommandControl commandControl) {
    super(commandControl);
  }

  @Override
  public boolean handle(@NonNull Audience sender, @NonNull String[] command) {
    PluginConfiguration.AllowedCommands config = this.commandControl.config().allowedCommands();
    if (!config.enabled()) {
      return false;
    }

    if (!config.commands().contains(command[0])) {
      if (config.useBypassPermission()
          && AdventureUtils.hasPermission(sender, "commandcontrol.bypass.allowed-commands")) {
        return false;
      }

      sender.sendMessage(AdventureUtils.color(config.failMessage()));
      return true;
    }
    return false;
  }
}
