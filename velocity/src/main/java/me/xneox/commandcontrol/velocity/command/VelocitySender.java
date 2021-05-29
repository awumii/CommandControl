package me.xneox.commandcontrol.velocity.command;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.Player;
import me.xneox.commandcontrol.command.Sender;
import me.xneox.commandcontrol.velocity.AdventureUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class VelocitySender extends Sender<CommandSource> {
    public VelocitySender(CommandSource sender) {
        super(sender);
    }

    @Override
    public void sendMessage(@NotNull String message) {
        this.sender.sendMessage(AdventureUtils.createComponent(message));
    }

    @Override
    public boolean isPlayer() {
        return this.sender instanceof Player;
    }

    @Override
    public boolean hasPermission(@NonNull String permission) {
        return this.sender.hasPermission(permission);
    }

    @Override
    public UUID uuid() {
        return this.isPlayer() ? ((Player) this.sender).getUniqueId() : null;
    }
}
