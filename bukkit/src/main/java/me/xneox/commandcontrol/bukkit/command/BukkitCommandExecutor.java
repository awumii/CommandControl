package me.xneox.commandcontrol.bukkit.command;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BukkitCommandExecutor extends CommandExecutor implements org.bukkit.command.CommandExecutor, TabCompleter {
    public BukkitCommandExecutor(CommandControl commandControl) {
        super(commandControl);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        this.handle(args, new BukkitSender(sender));
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return this.suggestions(args);
    }
}
