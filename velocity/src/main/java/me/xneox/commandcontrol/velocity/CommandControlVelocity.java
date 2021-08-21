package me.xneox.commandcontrol.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.EventManager;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import java.util.UUID;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.Platform;
import me.xneox.commandcontrol.velocity.command.VelocityCommandHandler;
import me.xneox.commandcontrol.velocity.listener.CommandListener;
import me.xneox.commandcontrol.velocity.listener.TabCompleteListener;
import org.bstats.velocity.Metrics;
import org.jetbrains.annotations.NotNull;

@Plugin(
    id = "commandcontrol",
    name = "CommandControl",
    version = "{version}",
    description = "Command whitelist, blacklist, custom tab completion and operator protection!",
    authors = "xNeox")
public class CommandControlVelocity implements Platform {
  private final ProxyServer server;
  private final Metrics.Factory metricsFactory;

  @Inject
  public CommandControlVelocity(ProxyServer server, Metrics.Factory metricsFactory) {
    this.server = server;
    this.metricsFactory = metricsFactory;
  }

  @Subscribe
  public void onEnable(ProxyInitializeEvent event) {
    CommandControl commandControl = new CommandControl(this);

    this.server.getCommandManager().register("commandcontrol",
        new VelocityCommandHandler(commandControl), "cmc", "cmdcontrol");

    EventManager eventManager = this.server.getEventManager();
    eventManager.register(this, new CommandListener(commandControl));
    eventManager.register(this, new TabCompleteListener(commandControl));

    this.metricsFactory.make(this, 11523);
  }

  @Override
  public boolean hasPermission(@NotNull UUID uuid, @NotNull String permission) {
    return this.server.getPlayer(uuid)
        .map(player -> player.hasPermission(permission))
        .orElse(false);
  }
}
