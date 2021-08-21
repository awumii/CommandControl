package me.xneox.commandcontrol.module.impl;

import java.util.UUID;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.config.PluginConfiguration;
import me.xneox.commandcontrol.module.Module;
import me.xneox.commandcontrol.util.AdventureUtils;
import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;

public class AllowedCommandsModule extends Module {
  public AllowedCommandsModule(CommandControl commandControl) {
    super(commandControl);
  }

  @Override
  public boolean handle(@NotNull Audience sender, @NotNull UUID uuid, @NotNull String command) {
    PluginConfiguration.AllowedCommands config = this.commandControl.config().allowedCommands();
    if (!config.enabled()) {
      return false;
    }

    if (!config.commands().contains(command)) {
      if (config.useBypassPermission() && this.commandControl.platform().hasPermission(uuid, "commandcontrol.bypass.allowed-commands")) {
        return false;
      }

      sender.sendMessage(AdventureUtils.color(config.failMessage()));
      return true;
    }
    return false;
  }
}
