package me.xneox.commandcontrol.bungee.listener;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.bungee.command.BungeeSender;
import me.xneox.commandcontrol.command.Sender;
import me.xneox.commandcontrol.handler.TabCompleteHandler;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class TabCompleteListener extends TabCompleteHandler implements Listener {
    public TabCompleteListener(CommandControl commandControl) {
        super(commandControl);
    }

    @EventHandler
    public void onTabComplete(TabCompleteEvent event) {
        ProxiedPlayer player = (ProxiedPlayer) event.getSender(); // oh god... sender is an Connection again...
        Sender<CommandSender> sender = new BungeeSender(player);

        this.handle(sender, event.getSuggestions());
    }
}
