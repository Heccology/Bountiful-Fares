package net.hecco.bountifulfares.datagen;

import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

import static net.hecco.bountifulfares.BountifulFares.*;


public class DatagenOnlyItems {
    private static void registerDatagenOnlyItem(String modId, String name) {
        if (NLServices.PLATFORM.isDatagen()) {
            Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(modId, name), new Item(new Item.Properties()));
        }
    }
    public static void registerDatagenItems() {
        for (DyeColor color : DyeColor.values()) {
            registerDatagenOnlyItem(MOD_ID, color.getName() + "_shulker_tiffin_back");
            registerDatagenOnlyItem(MOD_ID, color.getName() + "_shulker_tiffin_front");
        }
    }

}
