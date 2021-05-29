package me.xneox.commandcontrol.handler;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.command.Sender;
import me.xneox.commandcontrol.module.Module;
import me.xneox.commandcontrol.module.impl.AllowedCommandsModule;
import me.xneox.commandcontrol.module.impl.BlockedCommandsModule;
import me.xneox.commandcontrol.module.impl.NamespacedCommandsModule;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler {
    private final List<Module> modules = new ArrayList<>();

    public CommandHandler(CommandControl commandControl) {
        this.modules.add(new AllowedCommandsModule(commandControl));
        this.modules.add(new BlockedCommandsModule(commandControl));
        this.modules.add(new NamespacedCommandsModule(commandControl));
    }

    public boolean handle(@NonNull Sender<?> sender, @NonNull String command) {
        return this.modules.stream().anyMatch(module -> module.handle(sender, command.split(" ")));
    }
}
