package me.xneox.commandcontrol;

import me.xneox.commandcontrol.config.PluginConfiguration;
import me.xneox.commandcontrol.util.ConfigUtils;

import java.io.File;

public class CommandControl {
    private PluginConfiguration config;

    private final Platform platform;

    public CommandControl(Platform platform) {
        this.platform = platform;

        File dataFolder = new File("plugins/CommandControl");
        dataFolder.mkdir();

        this.config = ConfigUtils.loadConfig(new File(dataFolder, "config.conf"), PluginConfiguration.class);
    }

    public Platform platform() {
        return this.platform;
    }

    public PluginConfiguration config() {
        return this.config;
    }
}
