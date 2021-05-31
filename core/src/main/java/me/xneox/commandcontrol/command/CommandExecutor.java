package me.xneox.commandcontrol.command;

import me.xneox.commandcontrol.CommandControl;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collections;
import java.util.List;

public class CommandExecutor {
    private final CommandControl commandControl;

    public CommandExecutor(CommandControl commandControl) {
        this.commandControl = commandControl;
    }

    public void handle(@NonNull String[] args, @NonNull Sender<?> sender) {
        if (args.length < 1) {
            sender.sendMessage("&b&lCommandControl &bby xNeox");
            sender.sendMessage("&7&o&nhttps://github.com/xxneox/CommandControl");
            sender.sendMessage("");
            sender.sendMessage("&bModule status:");
            sender.sendMessage("  &7AllowedCommands: &f" + this.commandControl.config().allowedCommands().enabled());
            sender.sendMessage("  &7BlockedCommands: &f" + this.commandControl.config().blockedCommands().enabled());
            sender.sendMessage("  &7CustomTabComplete: &f" + this.commandControl.config().customTabComplete().enabled());
            sender.sendMessage("  &7NamespacedCommands: &f" + this.commandControl.config().namespacedCommands().enabled());
            sender.sendMessage("  &7OperatorProtection: &f" + this.commandControl.config().operatorProtection().enabled());
            sender.sendMessage("");
            sender.sendMessage("&7Use &f/commandcontrol reload &7to reload the configuration.");
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            this.commandControl.loadConfig();
            sender.sendMessage("&aConfiguration reloaded!");
        } else {
            sender.sendMessage("&cCommand not found. Use /commancontrol for help.");
        }
    }

    @Nullable
    public List<String> suggestions(@NonNull String[] args) {
        if (args.length == 1) {
            return Collections.singletonList("reload");
        }
        return null;
    }
}
