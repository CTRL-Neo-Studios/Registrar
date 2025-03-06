package dev.ctrlneo.registrar.entry;

import dev.ctrlneo.registrar.tool.RegistrarTool;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class RegistrarEntry<T> implements Supplier<T> {
    protected final String name;
    protected final T value;
    protected final boolean isRegistered;

    protected RegistrarEntry(String name, T value) {
        this.name = name;
        this.value = value;
        this.isRegistered = true;
    }

    /**
     * Get the registered value.
     */
    @Override
    public T get() {
        return value;
    }

    /**
     * Get the identifier of this entry.
     */
    public Identifier getId() {
        return RegistrarTool.id(name);
    }

    /**
     * Check if this entry has been registered.
     */
    public boolean isRegistered() {
        return isRegistered;
    }
}
