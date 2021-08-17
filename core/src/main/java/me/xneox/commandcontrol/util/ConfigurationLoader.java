package me.xneox.commandcontrol.util;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import org.spongepowered.configurate.objectmapping.ObjectMapper;
import org.spongepowered.configurate.serialize.SerializationException;

import java.io.File;

public class ConfigurationLoader<C> {
    private final HoconConfigurationLoader loader;
    private ObjectMapper<C> mapper;

    public ConfigurationLoader(@NotNull File file, @NotNull Class<C> implementation) {
        this.loader = HoconConfigurationLoader.builder()
            .file(file)
            .build();

        try {
            this.mapper = ObjectMapper.factory().get(implementation);
        } catch (SerializationException e) {
            e.printStackTrace();
        }
    }

    @NotNull
    public C load() throws ConfigurateException {
        C configuration = this.mapper.load(this.loader.load());

        this.save(configuration); // write default values
        return configuration;
    }

    public void save(@NotNull C config) throws ConfigurateException {
        CommentedConfigurationNode node = this.loader.createNode();
        this.mapper.save(config, node);
        this.loader.save(node);
    }
}
