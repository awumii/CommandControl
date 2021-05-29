package me.xneox.commandcontrol.bukkit;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.Platform;
import me.xneox.commandcontrol.bukkit.listener.CommandPreprocessListener;
import me.xneox.commandcontrol.bukkit.listener.TabCompleteListener;
import me.xneox.commandcontrol.bukkit.task.OperatorProtectionTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandControlBukkit extends JavaPlugin implements Platform {
    @Override
    public void onEnable() {
        CommandControl commandControl = new CommandControl(this);

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new CommandPreprocessListener(commandControl), this);
        pm.registerEvents(new TabCompleteListener(commandControl), this);

        // Spigot-exclusive feature: Operator Protection.
        Bukkit.getScheduler().runTaskTimer(this,
                new OperatorProtectionTask(commandControl), 0L, commandControl.config().operatorProtection().checkInterval());
    }
}
