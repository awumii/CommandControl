package me.xneox.commandcontrol.velocity.command;

import com.velocitypowered.api.command.SimpleCommand;
import me.xneox.commandcontrol.CommandControl;

import java.util.List;

public class VelocityCommandHandler implements SimpleCommand {
    private final CommandControl commandControl;

    public VelocityCommandHandler(CommandControl commandControl) {
        this.commandControl = commandControl;
    }

    @Override
    public void execute(Invocation invocation) {
        this.commandControl.commandHandler().handle(invocation.source(), invocation.arguments());
    }

    @Override
    public List<String> suggest(Invocation invocation) {
        return this.commandControl.commandHandler().suggest(invocation.arguments());
    }

    @Override
    public boolean hasPermission(Invocation invocation) {
        return invocation.source().hasPermission("commandcontrol.admin");
    }
}
