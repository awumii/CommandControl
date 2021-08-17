package me.xneox.commandcontrol.bukkit.command;

import java.util.List;
import me.xneox.commandcontrol.CommandControl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BukkitCommandHandler implements CommandExecutor, TabCompleter {
  private final CommandControl commandControl;

  public BukkitCommandHandler(CommandControl commandControl) {
    this.commandControl = commandControl;
  }

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
    this.commandControl.commandHandler().handle(sender, args);
    return true;
  }

  @Override
  public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
    return this.commandControl.commandHandler().suggest(args);
  }
}
