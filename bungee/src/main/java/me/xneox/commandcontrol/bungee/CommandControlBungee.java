package me.xneox.commandcontrol.bungee;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.bungee.command.BungeeCommandExecutor;
import me.xneox.commandcontrol.bungee.listener.CommandListener;
import me.xneox.commandcontrol.bungee.listener.TabCompleteListener;
import me.xneox.commandcontrol.command.CommandExecutor;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import org.bstats.bungeecord.Metrics;

public class CommandControlBungee extends Plugin {
    @Override
    public void onEnable() {
        CommandControl commandControl = new CommandControl();

        PluginManager pm = this.getProxy().getPluginManager();
        pm.registerListener(this, new CommandListener(commandControl));
        pm.registerListener(this, new TabCompleteListener(commandControl));

        pm.registerCommand(this, new BungeeCommandExecutor(new CommandExecutor(commandControl)));

        new Metrics(this, 11525);
    }
}
