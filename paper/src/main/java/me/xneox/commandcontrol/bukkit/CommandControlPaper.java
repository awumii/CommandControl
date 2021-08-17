package me.xneox.commandcontrol.bukkit;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.Platform;
import me.xneox.commandcontrol.bukkit.command.BukkitCommandHandler;
import me.xneox.commandcontrol.bukkit.listener.CommandListener;
import me.xneox.commandcontrol.bukkit.listener.TabCompleteListener;
import me.xneox.commandcontrol.bukkit.task.OperatorProtectionTask;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

public class CommandControlPaper extends JavaPlugin implements Platform {
  @Override
  public void onEnable() {
    CommandControl commandControl = new CommandControl(this);

    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new CommandListener(commandControl), this);
    pm.registerEvents(new TabCompleteListener(commandControl), this);

    PluginCommand command = this.getCommand("commandcontrol");
    if (command != null) {
      BukkitCommandHandler handler = new BukkitCommandHandler(commandControl);
      command.setExecutor(handler);
      command.setTabCompleter(handler);
    }

    // Spigot-exclusive feature: Operator Protection.
    Bukkit.getScheduler().runTaskTimer(this,
        new OperatorProtectionTask(commandControl), 0L, commandControl.config().operatorProtection().checkInterval() * 20L);

    new Metrics(this, 11524);
  }

  @Override
  public Logger logger() {
    return this.getSLF4JLogger();
  }
}
