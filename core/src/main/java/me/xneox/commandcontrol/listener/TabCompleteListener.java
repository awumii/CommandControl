package me.xneox.commandcontrol.listener;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.config.PluginConfiguration;
import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;

public class TabCompleteListener {
  private final CommandControl commandControl;

  public TabCompleteListener(CommandControl commandControl) {
    this.commandControl = commandControl;
  }

  public void handle(@NotNull Audience sender, @NotNull UUID uuid, @NotNull Collection<String> originalSuggestions) {
    PluginConfiguration.CustomTabComplete config = this.commandControl.config().customTabComplete();
    if (!config.enabled()) {
      return;
    }

    if (config.useBypassPermission() && this.commandControl.platform().hasPermission(uuid, "commandcontrol.bypass.custom-tab-complete")) {
      return;
    }

    List<String> newCompletions = config.commands().stream()
        .map(s -> s.replace("/", ""))
        .collect(Collectors.toList());

    // Replace default tab completion with custom values.
    // There is probably a better way to achieve this... But hey, it works!
    originalSuggestions.clear();
    originalSuggestions.addAll(newCompletions);
  }
}
