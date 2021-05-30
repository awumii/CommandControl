package me.xneox.commandcontrol.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.EventManager;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.velocity.command.VelocityCommandExecutor;
import me.xneox.commandcontrol.velocity.listener.CommandListener;
import org.bstats.velocity.Metrics;

@Plugin(
        id = "commandcontrol",
        name = "CommandControl",
        version = "{version}",
        description = "Command whitelist, blacklist, custom tab completion and operator protection!",
        authors = "xNeox")
public class CommandControlVelocity {
    private final ProxyServer server;
    private final Metrics.Factory metricsFactory;

    @Inject
    public CommandControlVelocity(ProxyServer server, Metrics.Factory metricsFactory) {
        this.server = server;
        this.metricsFactory = metricsFactory;
    }

    @Subscribe
    public void onEnable(ProxyInitializeEvent event) {
        CommandControl commandControl = new CommandControl();

        this.server.getCommandManager().register("commandcontrol",
                new VelocityCommandExecutor(commandControl),
                "cmc", "cmdcontrol");

        EventManager eventManager = this.server.getEventManager();
        eventManager.register(this, new CommandListener(commandControl));

        this.metricsFactory.make(this, 11523);
    }
}
