package me.xneox.commandcontrol.bukkit;

import org.bukkit.ChatColor;

public final class ChatUtils {
    public static String colored(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    private ChatUtils() {}
}
