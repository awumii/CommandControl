package me.xneox.commandcontrol.bukkit.listener;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.bukkit.command.BukkitSender;
import me.xneox.commandcontrol.command.Sender;
import me.xneox.commandcontrol.handler.TabCompleteHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class TabCompleteListener extends TabCompleteHandler implements Listener {
    public TabCompleteListener(CommandControl commandControl) {
        super(commandControl);
    }

    @EventHandler
    public void onPlayerCommandSend(PlayerCommandSendEvent event) {
        Sender<CommandSender> sender = new BukkitSender(event.getPlayer());
        this.handle(sender, event.getCommands());
    }
}
