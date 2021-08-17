package me.xneox.commandcontrol.velocity.listener;

import com.mojang.brigadier.tree.CommandNode;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.command.PlayerAvailableCommandsEvent;
import java.util.List;
import java.util.stream.Collectors;
import me.xneox.commandcontrol.CommandControl;

@SuppressWarnings("UnstableApiUsage")
public class TabCompleteListener {
  private final CommandControl commandControl;

  public TabCompleteListener(CommandControl commandControl) {
    this.commandControl = commandControl;
  }

  @Subscribe
  public void onTabComplete(PlayerAvailableCommandsEvent event) {
    // TODO: Test if this even works (probably not).
    List<String> originalSuggestions =
        event.getRootNode().getChildren().stream()
            .map(CommandNode::getName)
            .collect(Collectors.toList());

    this.commandControl.tabCompleteListener().handle(event.getPlayer(), originalSuggestions);
  }
}
