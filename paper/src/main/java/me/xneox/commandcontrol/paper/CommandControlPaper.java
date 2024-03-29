package me.xneox.commandcontrol.paper;

import java.util.UUID;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.Platform;
import me.xneox.commandcontrol.paper.command.PaperCommandHandler;
import me.xneox.commandcontrol.paper.listener.CommandListener;
import me.xneox.commandcontrol.paper.listener.TabCompleteListener;
import me.xneox.commandcontrol.paper.task.OperatorProtectionTask;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CommandControlPaper extends JavaPlugin implements Platform {
  @Override
  public void onEnable() {
    CommandControl commandControl = new CommandControl(this);

    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new CommandListener(commandControl), this);
    pm.registerEvents(new TabCompleteListener(commandControl), this);

    PluginCommand command = this.getCommand("commandcontrol");
    if (command != null) {
      PaperCommandHandler handler = new PaperCommandHandler(commandControl);
      command.setExecutor(handler);
      command.setTabCompleter(handler);
    }

    // Spigot-exclusive feature: Operator Protection.
    Bukkit.getScheduler().runTaskTimer(this,
        new OperatorProtectionTask(commandControl), 0L, commandControl.config().operatorProtection().checkInterval() * 20L);

    new Metrics(this, 11524);
  }

  @Override
  public boolean hasPermission(@NotNull UUID uuid, @NotNull String permission) {
    Player player = Bukkit.getPlayer(uuid);
    if (player != null) {
      return player.hasPermission(permission);
    }
    return false;
  }
}
