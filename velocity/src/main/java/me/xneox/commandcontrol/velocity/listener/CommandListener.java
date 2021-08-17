package me.xneox.commandcontrol.velocity.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.command.CommandExecuteEvent;
import me.xneox.commandcontrol.CommandControl;

public class CommandListener {
    private final CommandControl commandControl;

    public CommandListener(CommandControl commandControl) {
        this.commandControl = commandControl;
    }

    @Subscribe
    public void onCommand(CommandExecuteEvent event) {
        if (this.commandControl.commandListener().handle(event.getCommandSource(), event.getCommand())) {
            event.setResult(CommandExecuteEvent.CommandResult.denied());
        }
    }
}
