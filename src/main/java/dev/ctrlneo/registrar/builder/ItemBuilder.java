package dev.ctrlneo.registrar.builder;

import dev.ctrlneo.registrar.entry.ItemEntry;
import dev.ctrlneo.registrar.entry.RegistrarEntry;
import dev.ctrlneo.registrar.tool.RegistrarTool;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ItemBuilder<T extends Item> {
    protected final String name;
    protected final Function<Item.Settings, T> factory;
    protected Item.Settings itemSettings;

    public ItemBuilder(String name, Function<Item.Settings, T> factory) {
        this.name = name;
        this.factory = factory;
        this.itemSettings = new Item.Settings();
    }

    /**
     * Configure item food properties.
     */
    public ItemBuilder<T> food(FoodComponent foodComponent) {
        this.itemSettings.food(foodComponent);
        return this;
    }

    /**
     * Sets the maximum stack count of any ItemStack with this Item.
     */
    public ItemBuilder<T> maxCount(int maxCount) {
        this.itemSettings.maxCount(maxCount);
        return this;
    }

    /**
     * Sets the maximum durability of this item.
     */
    public ItemBuilder<T> maxDamage(int maxDamage) {
        this.itemSettings.maxDamage(maxDamage);
        return this;
    }

    /**
     * Sets the recipe remainder for this item.
     */
    public ItemBuilder<T> recipeRemainder(Item recipeRemainder) {
        this.itemSettings.recipeRemainder(recipeRemainder);
        return this;
    }

    /**
     * Sets the rarity of this item.
     */
    public ItemBuilder<T> rarity(Rarity rarity) {
        this.itemSettings.rarity(rarity);
        return this;
    }

    /**
     * Makes this item fireproof.
     */
    public ItemBuilder<T> fireproof() {
        this.itemSettings.fireproof();
        return this;
    }

    /**
     * Adds feature flag requirements to this item.
     */
    public ItemBuilder<T> requires(FeatureFlag... features) {
        this.itemSettings.requires(features);
        return this;
    }

    /**
     * Registers the item and returns an entry that can be used to access it.
     */
    public ItemEntry<T> register() {
        T itemInstance = factory.apply(itemSettings);
        T registeredItem = Registry.register(Registries.ITEM, RegistrarTool.id(name), itemInstance);
        ItemEntry<T> entry = new ItemEntry<>(name, registeredItem);
        RegistrarTool.get().addEntry(entry);
        return entry;
    }
}
