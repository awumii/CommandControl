package me.xneox.commandcontrol.module;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.command.Sender;
import org.checkerframework.checker.nullness.qual.NonNull;

public abstract class Module {
    protected final CommandControl commandControl;

    public Module(CommandControl commandControl) {
        this.commandControl = commandControl;
    }

    /**
     * @param sender The executor of the command.
     * @param command The executed command, including arguments.
     * @return true if the event should be cancelled, false if allowed.
     */
    public abstract boolean handle(@NonNull Sender<?> sender, @NonNull String[] command);
}
