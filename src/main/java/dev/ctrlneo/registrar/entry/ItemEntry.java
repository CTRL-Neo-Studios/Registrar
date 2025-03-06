package dev.ctrlneo.registrar.entry;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ItemEntry<T extends Item> extends RegistrarEntry<T> {

    public ItemEntry(String name, T registeredItem) {
        super(name, registeredItem);
    }

    /**
     * Get the item instance.
     */
    @Override
    public T get() {
        return value;
    }
}
