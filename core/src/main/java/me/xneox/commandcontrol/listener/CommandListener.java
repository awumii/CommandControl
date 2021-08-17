package me.xneox.commandcontrol.listener;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.module.Module;
import me.xneox.commandcontrol.module.impl.AllowedCommandsModule;
import me.xneox.commandcontrol.module.impl.BlockedCommandsModule;
import me.xneox.commandcontrol.module.impl.NamespacedCommandsModule;
import net.kyori.adventure.audience.Audience;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CommandListener {
    private final List<Module> modules = new ArrayList<>();

    public CommandListener(CommandControl commandControl) {
        this.modules.add(new AllowedCommandsModule(commandControl));
        this.modules.add(new BlockedCommandsModule(commandControl));
        this.modules.add(new NamespacedCommandsModule(commandControl));
    }

    public boolean handle(@NonNull Audience sender, @NonNull String command) {
        for (Module module : this.modules) {
            if (module.handle(sender, command.split(" "))) {
                return true;
            }
        }
        return false;
    }
}
