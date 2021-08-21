package me.xneox.commandcontrol.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.module.Module;
import me.xneox.commandcontrol.module.impl.AllowedCommandsModule;
import me.xneox.commandcontrol.module.impl.BlockedCommandsModule;
import me.xneox.commandcontrol.module.impl.NamespacedCommandsModule;
import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;

public class CommandListener {
  private final List<Module> modules = new ArrayList<>();

  public CommandListener(CommandControl commandControl) {
    this.modules.add(new AllowedCommandsModule(commandControl));
    this.modules.add(new BlockedCommandsModule(commandControl));
    this.modules.add(new NamespacedCommandsModule(commandControl));
  }

  public boolean handle(@NotNull Audience sender, @NotNull UUID uuid, @NotNull String command) {
    for (Module module : this.modules) {
      if (module.handle(sender, uuid, command)) {
        return true;
      }
    }
    return false;
  }
}
