package me.xneox.commandcontrol.bungee.listener;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.bungee.command.BungeeSender;
import me.xneox.commandcontrol.command.Sender;
import me.xneox.commandcontrol.handler.CommandHandler;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class CommandListener extends CommandHandler implements Listener {
    public CommandListener(CommandControl commandControl) {
        super(commandControl);
    }

    @EventHandler
    public void onCommand(ChatEvent event) {
        if (!event.isCommand()) return; // of course both chat and commands are in one event...

        ProxiedPlayer player = (ProxiedPlayer) event.getSender(); // what the fuck bungee... getSender returns a Connection (???)
        Sender<CommandSender> sender = new BungeeSender(player);

        if (this.handle(sender, event.getMessage())) {
            event.setCancelled(true);
        }
    }

    // there should be a console command event but it doesn't exist in bungee.....
}
