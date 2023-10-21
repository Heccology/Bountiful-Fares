package net.hecco.bountifulcuisine.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.mixin.BrewingRecipeRegistryMixin;
import net.hecco.bountifulcuisine.potion.ModPotions;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;

public class ModRegistries {
    public static void RegisterModStuffs() {
        registerStrippables();
        registerPotionRecipes();
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.APPLE_LOG, ModBlocks.STRIPPED_APPLE_LOG);
        StrippableBlockRegistry.register(ModBlocks.APPLE_WOOD, ModBlocks.STRIPPED_APPLE_WOOD);
        StrippableBlockRegistry.register(ModBlocks.ORANGE_LOG, ModBlocks.STRIPPED_ORANGE_LOG);
        StrippableBlockRegistry.register(ModBlocks.ORANGE_WOOD, ModBlocks.STRIPPED_ORANGE_WOOD);
        StrippableBlockRegistry.register(ModBlocks.LEMON_LOG, ModBlocks.STRIPPED_LEMON_LOG);
        StrippableBlockRegistry.register(ModBlocks.LEMON_WOOD, ModBlocks.STRIPPED_LEMON_WOOD);
        StrippableBlockRegistry.register(ModBlocks.PLUM_LOG, ModBlocks.STRIPPED_PLUM_LOG);
        StrippableBlockRegistry.register(ModBlocks.PLUM_WOOD, ModBlocks.STRIPPED_PLUM_WOOD);
        StrippableBlockRegistry.register(ModBlocks.HOARY_LOG, ModBlocks.STRIPPED_HOARY_LOG);
        StrippableBlockRegistry.register(ModBlocks.HOARY_WOOD, ModBlocks.STRIPPED_HOARY_WOOD);
    }


    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.CITRIC_ACID, ModPotions.ACIDIC);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.ACIDIC, Items.REDSTONE, ModPotions.LONG_ACIDIC);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.GLOWSTONE_DUST, ModPotions.STRONG_ACIDIC);
    }
}
