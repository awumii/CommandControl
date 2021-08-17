package me.xneox.commandcontrol.bukkit.listener;

import me.xneox.commandcontrol.CommandControl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    private final CommandControl commandControl;

    public CommandListener(CommandControl commandControl) {
        this.commandControl = commandControl;
    }

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (this.commandControl.commandListener().handle(event.getPlayer(), event.getMessage())) {
            event.setCancelled(true);
        }
    }
}
