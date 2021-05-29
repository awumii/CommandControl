package me.xneox.commandcontrol;

import me.xneox.commandcontrol.config.PluginConfiguration;
import me.xneox.commandcontrol.util.ConfigUtils;

import java.io.File;

public class CommandControl {
    private PluginConfiguration config;

    public CommandControl() {
        this.loadConfig();
    }

    public void loadConfig() {
        File dataFolder = new File("plugins/CommandControl");
        dataFolder.mkdir();

        this.config = ConfigUtils.loadConfig(new File(dataFolder, "config.conf"), PluginConfiguration.class);
    }

    public PluginConfiguration config() {
        return this.config;
    }
}
