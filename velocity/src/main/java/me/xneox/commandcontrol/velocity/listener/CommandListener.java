package me.xneox.commandcontrol.velocity.listener;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.command.CommandExecuteEvent;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.command.Sender;
import me.xneox.commandcontrol.handler.CommandHandler;
import me.xneox.commandcontrol.velocity.command.VelocitySender;

public class CommandListener extends CommandHandler {
    public CommandListener(CommandControl commandControl) {
        super(commandControl);
    }

    @Subscribe
    public void onCommand(CommandExecuteEvent event) {
        Sender<CommandSource> sender = new VelocitySender(event.getCommandSource());

        if (this.handle(sender, event.getCommand())) {
            event.setResult(CommandExecuteEvent.CommandResult.denied());
        }
    }
}
