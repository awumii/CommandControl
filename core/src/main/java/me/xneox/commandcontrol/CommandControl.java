package me.xneox.commandcontrol;

import java.io.File;
import me.xneox.commandcontrol.command.CommandHandler;
import me.xneox.commandcontrol.config.PluginConfiguration;
import me.xneox.commandcontrol.listener.CommandListener;
import me.xneox.commandcontrol.listener.TabCompleteListener;
import me.xneox.commandcontrol.util.ConfigurationLoader;
import org.spongepowered.configurate.ConfigurateException;

public class CommandControl {
  private final CommandHandler commandHandler;
  private final CommandListener commandListener;
  private final TabCompleteListener tabCompleteListener;

  private final Platform platform;
  private PluginConfiguration config;

  public CommandControl(Platform platform) {
    this.platform = platform;

    this.commandHandler = new CommandHandler(this);
    this.commandListener = new CommandListener(this);
    this.tabCompleteListener = new TabCompleteListener(this);

    this.loadConfig();
    platform.logger().info("CommandControl has been succesfully loaded!");
  }

  public void loadConfig() {
    File configFile = new File("plugins/CommandControl", "config.conf");
    try {
      this.config = new ConfigurationLoader<>(configFile, PluginConfiguration.class).load();
    } catch (ConfigurateException exception) {
      platform.logger().error("Could not load the plugin's configuration: ", exception);
    }
  }

  public PluginConfiguration config() {
    return this.config;
  }

  public CommandHandler commandHandler() {
    return this.commandHandler;
  }

  public CommandListener commandListener() {
    return this.commandListener;
  }

  public TabCompleteListener tabCompleteListener() {
    return this.tabCompleteListener;
  }
}
