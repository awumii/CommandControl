package me.xneox.commandcontrol;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;

public interface Platform {
  // TODO: use Adventure after Paper implements Pointers.
  boolean hasPermission(@NotNull UUID uuid, @NotNull String permission);
}
