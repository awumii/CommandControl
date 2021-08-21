package me.xneox.commandcontrol.module;

import java.util.UUID;
import me.xneox.commandcontrol.CommandControl;
import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;

public abstract class Module {
  protected final CommandControl commandControl;

  public Module(CommandControl commandControl) {
    this.commandControl = commandControl;
  }

  /**
   * @param sender The executor of the command.
   * @param command The executed command.
   * @return true if the event should be cancelled, false if allowed.
   */
  public abstract boolean handle(@NotNull Audience sender, @NotNull UUID uuid, @NotNull String command);
}
