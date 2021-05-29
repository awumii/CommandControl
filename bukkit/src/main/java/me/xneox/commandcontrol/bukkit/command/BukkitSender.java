package me.xneox.commandcontrol.bukkit.command;

import me.xneox.commandcontrol.bukkit.ChatUtils;
import me.xneox.commandcontrol.command.Sender;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class BukkitSender extends Sender<CommandSender> {
    public BukkitSender(CommandSender sender) {
        super(sender);
    }

    @Override
    public void sendMessage(@NotNull String message) {
        this.sender.sendMessage(ChatUtils.colored(message));
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
