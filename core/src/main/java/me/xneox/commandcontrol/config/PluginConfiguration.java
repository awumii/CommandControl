package me.xneox.commandcontrol.config;

import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Comment;

import java.util.Arrays;
import java.util.List;

@ConfigSerializable
public class PluginConfiguration {

    @Comment("This module will allow players to execute only these commands that are specified here.")
    private final AllowedCommands allowedCommands = new AllowedCommands();

    @Comment("This module is the opposite of the allowed-command module and will block players from using specified commands.")
    private final BlockedCommands blockedCommands = new BlockedCommands();

    @Comment("This module will block commands which contain the ':' symbol (example: /bukkit:plugins)")
    private final NamespacedCommands namespacedCommands = new NamespacedCommands();

    @Comment("This module will replace the default command completions with your own list.\n" + "" +
            "(!) Currently not working on the Velocity proxy.")
    private final CustomTabComplete customTabComplete = new CustomTabComplete();

    @Comment("This module will execute the specified commands if someone has OP but is not listed here.\n" +
            "(!) Obviously, requires a Spigot/Paper server.")
    private final OperatorProtection operatorProtection = new OperatorProtection();

    @ConfigSerializable
    public static final class AllowedCommands {
        @Comment("Enable or disable this moodule.")
        private final boolean enabled = false;

        @Comment("If you enable this, people with the 'commandcontrol.bypass.allowed-commands' permission\n" +
                "won't be affected by this module (they will be able to use commands not listed there).")
        private final boolean useBypassPermission = true;

        @Comment("The list of the allowed commands.")
        private final List<String> commands = Arrays.asList("/spawn", "/msg", "/reply");

        @Comment("Message sent to the player when he tries to execute other command that is not allowed.")
        private final String failMessage = "&cCommand not found, use /help.";

        public boolean enabled() {
            return this.enabled;
        }

        public boolean useBypassPermission() {
            return this.useBypassPermission;
        }

        public List<String> commands() {
            return this.commands;
        }

        public String failMessage() {
            return this.failMessage;
        }
    }

    @ConfigSerializable
    public static final class BlockedCommands {
        @Comment("Enable or disable this moodule.")
        private final boolean enabled = false;

        @Comment("If you enable this, people with the 'commandcontrol.bypass.blocked-commands' permission\n" +
                "won't be affected by this module (they will be able to use commands listed there).")
        private final boolean useBypassPermission = true;

        @Comment("The list of blocked commands.")
        private final List<String> commands = Arrays.asList("/op", "/deop", "/minecraft:op", "/minecraft:deop");

        @Comment("Message sent to the player when he tries to execute other command that is not allowed.")
        private final String failMessage = "&cYou're not allowed to execute this command.";

        public boolean enabled() {
            return this.enabled;
        }

        public boolean isUseBypassPermission() {
            return this.useBypassPermission;
        }

        public List<String> commands() {
            return this.commands;
        }

        public String failMessage() {
            return this.failMessage;
        }
    }

    @ConfigSerializable
    public static final class NamespacedCommands {
        @Comment("Enable or disable this moodule.")
        private final boolean enabled = false;

        @Comment("If you enable this, people with the 'commandcontrol.bypass.namespaced-commands' permission\n" +
                "won't be affected by this module (they will be able to use commands containing the ':' symbol).")
        private final boolean useBypassPermission = false;

        @Comment("Enable to specify commands allowed to execute even if they contain the ':' symbol.")
        private final boolean useWhitelist = false;

        @Comment("Whitelisted commands, you need to enable 'use-whitelist' of this module.")
        private final List<String> whitelistedCommands = Arrays.asList("/minecraft:tp", "/minecraft:kill");

        @Comment("Message sent to the player when he tries to execute other command that is not allowed.")
        private final String failMessage = "&cYou're not allowed to execute this command.";

        public boolean enabled() {
            return this.enabled;
        }

        public boolean useBypassPermission() {
            return this.useBypassPermission;
        }

        public boolean useWhitelist() {
            return this.useWhitelist;
        }

        public List<String> whitelistedCommands() {
            return this.whitelistedCommands;
        }

        public String failMessage() {
            return this.failMessage;
        }
    }

    @ConfigSerializable
    public static final class CustomTabComplete {
        @Comment("Enable or disable this moodule.")
        private final boolean enabled = false;

        @Comment("If you enable this, people with the 'commandcontrol.bypass.custom-tab-complete' permission\n" +
                "won't be affected by this module (they will be able to tab complete all commands on the server).")
        private final boolean useBypassPermission = false;

        @Comment("Custom commands displayed for players when tab completing on '/'")
        private final List<String> commands = Arrays.asList("spawn", "msg", "reply");

        public boolean enabled() {
            return this.enabled;
        }

        public boolean useBypassPermission() {
            return this.useBypassPermission;
        }

        public List<String> commands() {
            return this.commands;
        }
    }

    @ConfigSerializable
    public static final class OperatorProtection {
        @Comment("Enable or disable this moodule.")
        private final boolean enabled = false;

        @Comment("How often (in seconds) should we check online players if they have operator?\n" + "" +
                "(!) Requires restart to apply.")
        private final int checkInterval = 2;

        @Comment("List of the players who are allowed to be operators.")
        private final List<String> allowedPlayers = Arrays.asList("your_nickname", "another_moderator");

        @Comment("Commands executed when a player is detected to have operator but is not allowed to.")
        private final List<String> punishCommands = Arrays.asList("deop %player%", "ban %player% You are not allowed to have OP!");

        public boolean enabled() {
            return this.enabled;
        }

        public long checkInterval() {
            return this.checkInterval;
        }

        public List<String> allowedPlayers() {
            return this.allowedPlayers;
        }

        public List<String> punishCommands() {
            return this.punishCommands;
        }
    }

    public AllowedCommands allowedCommands() {
        return this.allowedCommands;
    }

    public BlockedCommands blockedCommands() {
        return this.blockedCommands;
    }

    public NamespacedCommands namespacedCommands() {
        return this.namespacedCommands;
    }

    public CustomTabComplete customTabComplete() {
        return this.customTabComplete;
    }

    public OperatorProtection operatorProtection() {
        return this.operatorProtection;
    }
}
