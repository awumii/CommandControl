package me.xneox.commandcontrol.bungee.command;

import me.xneox.commandcontrol.command.CommandExecutor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

public class BungeeCommandExecutor extends Command implements TabExecutor {
    private final CommandExecutor command; // of course command has to be an abstract class in bungee...

    public BungeeCommandExecutor(CommandExecutor command) {
        super("commandcontrol", "commandcontrol.admin", "cmc", "cmdcontrol");
        this.command = command;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        this.command.handle(args, new BungeeSender(sender));
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        return this.command.suggestions(args);
    }
}
