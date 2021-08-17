package me.xneox.commandcontrol.bukkit.task;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.config.PluginConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class OperatorProtectionTask implements Runnable {
    private final CommandControl commandControl;

    public OperatorProtectionTask(CommandControl commandControl) {
        this.commandControl = commandControl;
    }

    @Override
    public void run() {
        PluginConfiguration.OperatorProtection config = this.commandControl.config().operatorProtection();
        if (!config.enabled()) {
            return;
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.isOp() && !config.allowedPlayers().contains(player.getName())) {
                config.punishCommands().forEach(punishCommand -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                        punishCommand.replace("%player%", player.getName())));
            }
        }
    }
}
