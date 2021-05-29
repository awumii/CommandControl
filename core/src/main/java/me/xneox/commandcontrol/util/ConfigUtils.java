package me.xneox.commandcontrol.util;

import me.xneox.commandcontrol.config.ConfigLoader;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.File;
import java.util.logging.Logger;

public final class ConfigUtils {
    private static final Logger LOGGER = Logger.getLogger(ConfigUtils.class.getName());

    /**
     * Loads the configuration from provided file, based on the implementation class.
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Nullable
    public static <C> C loadConfig(@NonNull File file, Class<C> implementation) {
        try {
            file.createNewFile(); // create new file if it doesn't exist.

            ConfigLoader<C> configLoader = new ConfigLoader<>(file, implementation);
            C configuration = configLoader.load(); // load the configuration.

            configLoader.save(configuration); // on first load the config file will be empty, so we write the default values.
            return configuration;
        } catch (Exception e) {
            LOGGER.severe("Could load configuration for " + file.getName());
            e.printStackTrace();
        }
        return null;
    }

    private ConfigUtils() {}
}
