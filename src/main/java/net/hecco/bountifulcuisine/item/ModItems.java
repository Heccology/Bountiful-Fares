package net.hecco.bountifulcuisine.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item ORANGE = registerItem("orange", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0).build())));
    public static final Item LEMON = registerItem("lemon", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0).build())));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BountifulCuisine.LOGGER.info("Registering Mod Items for ", BountifulCuisine.MOD_ID);
    }
}
