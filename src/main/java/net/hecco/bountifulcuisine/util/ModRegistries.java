package net.hecco.bountifulcuisine.util;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.potion.ModPotions;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;

import static net.fabricmc.fabric.api.registry.StrippableBlockRegistry.register;
import static net.hecco.bountifulcuisine.mixin.BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe;
import static net.minecraft.block.ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE;

public class ModRegistries {
    public static void RegisterModStuffs() {
        registerStrippables();
        registerModCompostables();
        registerPotionRecipes();
    }

    public static void registerStrippables() {
        register(ModBlocks.APPLE_LOG, ModBlocks.STRIPPED_APPLE_LOG);
        register(ModBlocks.APPLE_WOOD, ModBlocks.STRIPPED_APPLE_WOOD);
        register(ModBlocks.ORANGE_LOG, ModBlocks.STRIPPED_ORANGE_LOG);
        register(ModBlocks.ORANGE_WOOD, ModBlocks.STRIPPED_ORANGE_WOOD);
        register(ModBlocks.LEMON_LOG, ModBlocks.STRIPPED_LEMON_LOG);
        register(ModBlocks.LEMON_WOOD, ModBlocks.STRIPPED_LEMON_WOOD);
        register(ModBlocks.PLUM_LOG, ModBlocks.STRIPPED_PLUM_LOG);
        register(ModBlocks.PLUM_WOOD, ModBlocks.STRIPPED_PLUM_WOOD);
        register(ModBlocks.HOARY_LOG, ModBlocks.STRIPPED_HOARY_LOG);
        register(ModBlocks.HOARY_WOOD, ModBlocks.STRIPPED_HOARY_WOOD);
    }

    private static void registerModCompostables() {
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.APPLE_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWERING_APPLE_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.APPLE_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.APPLE_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWERING_ORANGE_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.ORANGE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.LEMON_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWERING_LEMON_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.LEMON_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.LEMON_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LEMON, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.PLUM_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.FLOWERING_PLUM_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.PLUM_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.PLUM_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.PLUM, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.HOARY_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.HOARY_LEAVES.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.HOARY_APPLE_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.HOARY_APPLE_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.HOARY_APPLE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.PASSION_FRUIT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ELDERBERRIES, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LAPISBERRY_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.LAPISBERRIES, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MAIZE_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MAIZE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LEEK_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LEEK, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.FLOUR, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SPONGEKIN_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.SPONGEKIN.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SPONGEKIN_SLICE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TEA_BERRIES, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TEA_LEAVES, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.DRIED_TEA_LEAVES, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.CHAMOMILE_FLOWERS.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.HONEYSUCKLE.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.VIOLET_BELLFLOWER.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GREEN_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BLACK_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CHAMOMILE_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.HONEYSUCKLE_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BELLFLOWER_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TORCHFLOWER_TEA_BLEND, 0.3f);
    }


    private static void registerPotionRecipes() {
        invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.CITRIC_ACID, ModPotions.ACIDIC);
        invokeRegisterPotionRecipe(ModPotions.ACIDIC, Items.REDSTONE, ModPotions.LONG_ACIDIC);
        invokeRegisterPotionRecipe(Potions.AWKWARD, Items.GLOWSTONE_DUST, ModPotions.STRONG_ACIDIC);
        invokeRegisterPotionRecipe(ModPotions.ACIDIC, Items.FERMENTED_SPIDER_EYE, ModPotions.STUPOR);
        invokeRegisterPotionRecipe(ModPotions.LONG_ACIDIC, Items.FERMENTED_SPIDER_EYE, ModPotions.LONG_STUPOR);
        invokeRegisterPotionRecipe(ModPotions.STUPOR, Items.REDSTONE, ModPotions.LONG_STUPOR);
    }
}
