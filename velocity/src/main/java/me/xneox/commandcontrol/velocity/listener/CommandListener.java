package me.xneox.commandcontrol.velocity.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.command.CommandExecuteEvent;
import com.velocitypowered.api.proxy.Player;
import me.xneox.commandcontrol.CommandControl;

public class CommandListener {
  private final CommandControl commandControl;

  public CommandListener(CommandControl commandControl) {
    this.commandControl = commandControl;
  }

  @Subscribe
  public void onCommand(CommandExecuteEvent event) {
    if (event.getCommandSource() instanceof Player player) {
      if (this.commandControl.commandListener().handle(player, player.getUniqueId(), event.getCommand())) {
        event.setResult(CommandExecuteEvent.CommandResult.denied());
      }
    }
  }
}
