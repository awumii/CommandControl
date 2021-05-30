package me.xneox.commandcontrol.velocity.command;

import com.velocitypowered.api.command.SimpleCommand;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.command.CommandExecutor;

import java.util.List;

public class VelocityCommandExecutor extends CommandExecutor implements SimpleCommand {
    public VelocityCommandExecutor(CommandControl commandControl) {
        super(commandControl);
    }

    @Override
    public void execute(Invocation invocation) {
        this.handle(invocation.arguments(), new VelocitySender(invocation.source()));
    }

    @Override
    public List<String> suggest(Invocation invocation) {
        return this.suggestions(invocation.arguments());
    }

    @Override
    public boolean hasPermission(Invocation invocation) {
        return invocation.source().hasPermission("commandcontrol.admin");
    }
}
