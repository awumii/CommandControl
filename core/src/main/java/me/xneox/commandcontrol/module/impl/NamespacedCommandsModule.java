package me.xneox.commandcontrol.module.impl;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.command.Sender;
import me.xneox.commandcontrol.config.PluginConfiguration;
import me.xneox.commandcontrol.module.Module;
import org.checkerframework.checker.nullness.qual.NonNull;

public class NamespacedCommandsModule extends Module {
    public NamespacedCommandsModule(CommandControl commandControl) {
        super(commandControl);
    }

    @Override
    public boolean handle(@NonNull Sender<?> sender, @NonNull String[] command) {
        PluginConfiguration.NamespacedCommands config = this.commandControl.config().namespacedCommands();
        if (!config.enabled()) {
            return false;
        }

        if (command[0].contains(":")) {
            if (config.useBypassPermission() && sender.hasPermission("commandcontrol.bypass.namespaced-commands")) {
                return false; // Player has bypass permission, skipping...
            }

            if (config.useWhitelist() && config.whitelistedCommands().stream().anyMatch(command[0]::startsWith)) {
                return false; // Command is whitelisted, skipping...
            }

            sender.sendMessage(config.failMessage());
            return true;
        }
        return false;
    }
}
