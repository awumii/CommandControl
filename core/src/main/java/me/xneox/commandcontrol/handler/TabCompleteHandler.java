package me.xneox.commandcontrol.handler;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.command.Sender;
import me.xneox.commandcontrol.config.PluginConfiguration;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Collection;

public class TabCompleteHandler {
    private final CommandControl commandControl;

    public TabCompleteHandler(CommandControl commandControl) {
        this.commandControl = commandControl;
    }

    public void handle(@NonNull Sender<?> sender, @NonNull Collection<String> commands) {
        PluginConfiguration.CustomTabComplete config = this.commandControl.config().customTabComplete();
        if (!config.enabled()) {
            return;
        }

        if (config.useBypassPermission() && sender.hasPermission("commandcontrol.bypass.custom-tab-complete")) {
            return;
        }

        // Replace default tab completion with custom values.
        // Must be done this way because Bukkit :/
        commands.clear();
        commands.addAll(config.commands());
    }
}
