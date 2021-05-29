package me.xneox.commandcontrol.velocity.listener;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.command.PlayerAvailableCommandsEvent;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.command.Sender;
import me.xneox.commandcontrol.handler.TabCompleteHandler;
import me.xneox.commandcontrol.velocity.command.VelocitySender;

public class TabCompleteListener extends TabCompleteHandler {
    public TabCompleteListener(CommandControl commandControl) {
        super(commandControl);
    }

    @Subscribe
    public void onTabComplete(PlayerAvailableCommandsEvent event) {
        Sender<CommandSource> sender = new VelocitySender(event.getPlayer());
        this.handle(sender, event.getRootNode().getExamples());

        // i have no idea how to modify tab completion in velocity.
        // if anyone knows please open a PR :D
    }
}
