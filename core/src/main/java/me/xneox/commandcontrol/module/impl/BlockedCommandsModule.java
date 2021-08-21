package me.xneox.commandcontrol.module.impl;

import java.util.UUID;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.config.PluginConfiguration;
import me.xneox.commandcontrol.module.Module;
import me.xneox.commandcontrol.util.AdventureUtils;
import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;

public class BlockedCommandsModule extends Module {
  public BlockedCommandsModule(CommandControl commandControl) {
    super(commandControl);
  }

  @Override
  public boolean handle(@NotNull Audience sender, @NotNull UUID uuid, @NotNull String command) {
    PluginConfiguration.BlockedCommands config = this.commandControl.config().blockedCommands();
    if (!config.enabled()) {
      return false;
    }

    if (config.commands().contains(command.toLowerCase())) {
      if (config.isUseBypassPermission() && this.commandControl.platform().hasPermission(uuid, "commandcontrol.bypass.blocked-commands")) {
        return false;
      }

      sender.sendMessage(AdventureUtils.color(config.failMessage()));
      return true;
    }
    return false;
  }
}
