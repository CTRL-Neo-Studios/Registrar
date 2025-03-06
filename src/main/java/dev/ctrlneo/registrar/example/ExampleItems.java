package dev.ctrlneo.registrar.example;

import dev.ctrlneo.registrar.Registrar;
import dev.ctrlneo.registrar.entry.ItemEntry;
import net.minecraft.item.Item;

public class ExampleItems {
    public ItemEntry<Item> EXAMPLE_ITEM = Registrar.REGISTRAR.item("example_item", Item::new).register();
}
