package me.xneox.commandcontrol.bungee.command;

import me.xneox.commandcontrol.bungee.BungeeUtils;
import me.xneox.commandcontrol.command.Sender;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public class BungeeSender extends Sender<CommandSender> {
    public BungeeSender(CommandSender sender) {
        super(sender);
    }

    @Override
    public void sendMessage(@NonNull String message) {
        this.sender.sendMessage(BungeeUtils.createComponent(message));
    }

    @Override
    public boolean isPlayer() {
        return this.sender instanceof ProxiedPlayer;
    }

    @Override
    public boolean hasPermission(@NonNull String permission) {
        return this.sender.hasPermission(permission);
    }

    @Override
    public UUID uuid() {
        return this.isPlayer() ? ((ProxiedPlayer) this.sender).getUniqueId() : null;
    }
}
