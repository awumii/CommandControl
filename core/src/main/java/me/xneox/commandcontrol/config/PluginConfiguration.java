package me.xneox.commandcontrol.config;

import org.spongepowered.configurate.objectmapping.ConfigSerializable;

import java.util.Arrays;
import java.util.List;

@ConfigSerializable
public class PluginConfiguration {
    // Configuration sections.
    private final AllowedCommands allowedCommands = new AllowedCommands();
    private final BlockedCommands blockedCommands = new BlockedCommands();
    private final NamespacedCommands namespacedCommands = new NamespacedCommands();
    private final CustomTabComplete customTabComplete = new CustomTabComplete();
    private final OperatorProtection operatorProtection = new OperatorProtection();

    @ConfigSerializable
    public static final class AllowedCommands {
        private final boolean enabled = false;
        private final boolean useBypassPermission = true;
        private final List<String> commands = Arrays.asList("/spawn", "/msg", "/reply");
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
        private final boolean enabled = false;
        private final boolean useBypassPermission = true;
        private final List<String> commands = Arrays.asList("/op", "/deop", "/minecraft:op", "/minecraft:deop");
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
        private final boolean enabled = false;
        private final boolean useBypassPermission = false;
        private final boolean useWhitelist = false;
        private final List<String> whitelistedCommands = Arrays.asList("/minecraft:tp", "/minecraft:kill");
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

    public static final class CustomTabComplete {
        private final boolean enabled = false;
        private final boolean useBypassPermission = false;
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
        private final boolean enabled = false;
        private final long checkInterval = 40L;
        private final List<String> allowedPlayers = Arrays.asList("your_nickname");
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
