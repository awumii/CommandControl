package me.xneox.commandcontrol.bungee;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.bungee.listener.CommandListener;
import me.xneox.commandcontrol.bungee.listener.TabCompleteListener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class CommandControlBungee extends Plugin {
    @Override
    public void onEnable() {
        CommandControl commandControl = new CommandControl();

        PluginManager pm = this.getProxy().getPluginManager();
        pm.registerListener(this, new CommandListener(commandControl));
        pm.registerListener(this, new TabCompleteListener(commandControl));
    }
}
