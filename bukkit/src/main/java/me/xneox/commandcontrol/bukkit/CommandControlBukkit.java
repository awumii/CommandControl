package me.xneox.commandcontrol.bukkit;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.bukkit.listener.CommandListener;
import me.xneox.commandcontrol.bukkit.listener.TabCompleteListener;
import me.xneox.commandcontrol.bukkit.task.OperatorProtectionTask;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandControlBukkit extends JavaPlugin {
    @Override
    public void onEnable() {
        CommandControl commandControl = new CommandControl();

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new CommandListener(commandControl), this);
        pm.registerEvents(new TabCompleteListener(commandControl), this);

        // Spigot-exclusive feature: Operator Protection.
        Bukkit.getScheduler().runTaskTimer(this,
                new OperatorProtectionTask(commandControl), 0L, commandControl.config().operatorProtection().checkInterval());

        new Metrics(this, 11524);
    }
}
