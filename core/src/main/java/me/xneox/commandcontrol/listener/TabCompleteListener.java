package me.xneox.commandcontrol.listener;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.config.PluginConfiguration;
import me.xneox.commandcontrol.util.AdventureUtils;
import net.kyori.adventure.audience.Audience;
import org.checkerframework.checker.nullness.qual.NonNull;

public class TabCompleteListener {
  private final CommandControl commandControl;

  public TabCompleteListener(CommandControl commandControl) {
    this.commandControl = commandControl;
  }

  public void handle(@NonNull Audience sender, @NonNull Collection<String> originalSuggestions) {
    PluginConfiguration.CustomTabComplete config = this.commandControl.config().customTabComplete();
    if (!config.enabled()) {
      return;
    }

    if (config.useBypassPermission()
        && AdventureUtils.hasPermission(sender, "commandcontrol.bypass.custom-tab-complete")) {
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
