package me.xneox.commandcontrol.paper.listener;

import me.xneox.commandcontrol.CommandControl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class TabCompleteListener implements Listener {
  private final CommandControl commandControl;

  public TabCompleteListener(CommandControl commandControl) {
    this.commandControl = commandControl;
  }

  @EventHandler
  public void onPlayerCommandSend(PlayerCommandSendEvent event) {
    this.commandControl.tabCompleteListener().handle(event.getPlayer(), event.getPlayer().getUniqueId(), event.getCommands());
  }
}
