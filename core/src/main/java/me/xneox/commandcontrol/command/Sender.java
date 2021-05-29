package me.xneox.commandcontrol.command;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

public abstract class Sender<C> {
    protected final C sender;

    protected Sender(C sender) {
        this.sender = sender;
    }

    public abstract void sendMessage(@NonNull String message);

    public abstract boolean isPlayer();

    public abstract boolean hasPermission(@NonNull String permission);

    @Nullable
    public abstract UUID uuid();
}
