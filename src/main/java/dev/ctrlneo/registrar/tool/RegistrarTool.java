package dev.ctrlneo.registrar.tool;

import dev.ctrlneo.registrar.builder.ItemBuilder;
import dev.ctrlneo.registrar.entry.RegistrarEntry;
import dev.ctrlneo.registrar.exception.NullRegistrarToolInstanceException;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class RegistrarTool {
    public final String ID;
    protected static RegistrarTool instance;
    protected final RegistrationHandler handler;

    protected RegistrarTool(String id) {
        this.ID = id;
        this.handler = new RegistrationHandler();
    }

    public static RegistrarTool create(String id) {
        if(instance != null) return instance;
        instance = new RegistrarTool(id);
        return instance;
    }

    public static RegistrarTool get() {
        if(instance == null) throw new NullRegistrarToolInstanceException();
        return instance;
    }

    public String getId() {
        return ID;
    }

    public static Identifier id(String path) {
        if(instance == null) throw new NullRegistrarToolInstanceException();
        return new Identifier(instance.getId(), path);
    }

    /**
     * Create an item builder for a regular item
     */
    public ItemBuilder<Item> item(String name) {
        return item(name, Item::new);
    }

    /**
     * Create an item builder with a custom item factory
     */
    public <T extends Item> ItemBuilder<T> item(String name, Function<Item.Settings, T> factory) {
        return new ItemBuilder<>(name, factory);
    }

    /**
     * Add a registry entry to track
     */
    public void addEntry(RegistrarEntry<?> entry) {
        handler.addEntry(entry);
    }

    /**
     * Register all pending entries
     */
    public void register() {
        handler.register();
    }
}
