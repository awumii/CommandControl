package me.xneox.commandcontrol.config;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import org.spongepowered.configurate.objectmapping.ObjectMapper;
import org.spongepowered.configurate.serialize.SerializationException;

import java.io.File;

public class ConfigLoader<C> {
    private final HoconConfigurationLoader loader;
    private ObjectMapper<C> mapper;

    public ConfigLoader(@NonNull File file, @NonNull Class<C> implementation) {
        this.loader = HoconConfigurationLoader.builder()
                .file(file)
                .build();

        try {
            this.mapper = ObjectMapper.factory().get(implementation);
        } catch (SerializationException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    public C load() throws ConfigurateException {
        return this.mapper.load(this.loader.load());
    }

    public void save(@NonNull C config) throws ConfigurateException {
        CommentedConfigurationNode node = this.loader.createNode();
        this.mapper.save(config, node);
        this.loader.save(node);
    }
}
