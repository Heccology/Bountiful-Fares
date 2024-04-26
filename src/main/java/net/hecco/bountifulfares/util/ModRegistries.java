package net.hecco.bountifulfares.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.hecco.bountifulfares.item.ModItems;
import net.hecco.bountifulfares.potion.ModPotions;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

import static net.fabricmc.fabric.api.registry.StrippableBlockRegistry.register;
import static net.hecco.bountifulfares.mixin.BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe;
import static net.minecraft.block.ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE;

public class ModRegistries {
    public static void RegisterModStuffs() {
        registerStrippables();
        registerCeramicCheckeredConversions();
        registerFuels();
        registerModCompostables();
        registerPotionRecipes();
        registerFermentationRecipes();
        DispenserBlock.registerBehavior(ModItems.FLOUR, new FlourDispenserBehavior() {
            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return new FlourProjectileEntity(world, position.getX(), position.getY(), position.getZ());
            }
        });
        DispenserBlock.registerBehavior(ModItems.GRASS_SEEDS, new GrassSeedsDispenserBehavior() {
            @Override
            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                return super.dispenseSilently(pointer, stack);
            }
        });
    }

    public static void registerFermentationRecipes() {
        FermentationRecipes.addRecipe(ModItems.ELDERBERRIES, null, ModItems.ELDERBERRY_WINE_BOTTLE, Items.GLASS_BOTTLE, null);
        FermentationRecipes.addRecipe(ModItems.LAPISBERRIES, null, ModItems.LAPISBERRY_WINE_BOTTLE, Items.GLASS_BOTTLE, null);
        FermentationRecipes.addRecipe(Items.HONEY_BOTTLE, Items.GLASS_BOTTLE, ModItems.MEAD_BOTTLE, Items.GLASS_BOTTLE, null);
        FermentationRecipes.addRecipe(Items.APPLE, null, ModItems.APPLE_CIDER_JAR, ModItems.JAR, null);
        FermentationRecipes.addRecipe(ModItems.PLUM, null, ModItems.PLUM_CIDER_JAR, ModItems.JAR, null);
        FermentationRecipes.addRecipe(ModItems.HOARY_APPLE, null, ModItems.HOARY_CIDER_JAR, ModItems.JAR, null);
        FermentationRecipes.addRecipe(ModItems.ORANGE, null, ModItems.CITRUS_ESSENCE, null, 4);
        FermentationRecipes.addRecipe(ModItems.LEMON, null, ModItems.CITRUS_ESSENCE, null, 4);
        FermentationRecipes.addRecipe(Items.SPIDER_EYE, null, Items.FERMENTED_SPIDER_EYE, null, null);
    }

    public static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(ModItemTags.FRUIT_LOGS, 200);
        registry.add(ModItemTags.HOARY_LOGS, 300);
        registry.add(ModItemTags.WALNUT_LOGS, 300);
        registry.add(ModItemTags.PICKETS, 200);
        registry.add(ModBlocks.TRELLIS, 300);
        registry.add(ModBlocks.GRISTMILL, 300);
        registry.add(ModBlocks.WHITE_JACK_O_STRAW, 400);
        registry.add(ModBlocks.LIGHT_GRAY_JACK_O_STRAW, 400);
        registry.add(ModBlocks.GRAY_JACK_O_STRAW, 400);
        registry.add(ModBlocks.BLACK_JACK_O_STRAW, 400);
        registry.add(ModBlocks.BROWN_JACK_O_STRAW, 400);
        registry.add(ModBlocks.RED_JACK_O_STRAW, 400);
        registry.add(ModBlocks.ORANGE_JACK_O_STRAW, 400);
        registry.add(ModBlocks.YELLOW_JACK_O_STRAW, 400);
        registry.add(ModBlocks.LIME_JACK_O_STRAW, 400);
        registry.add(ModBlocks.GREEN_JACK_O_STRAW, 400);
        registry.add(ModBlocks.CYAN_JACK_O_STRAW, 400);
        registry.add(ModBlocks.LIGHT_BLUE_JACK_O_STRAW, 400);
        registry.add(ModBlocks.BLUE_JACK_O_STRAW, 400);
        registry.add(ModBlocks.PURPLE_JACK_O_STRAW, 400);
        registry.add(ModBlocks.MAGENTA_JACK_O_STRAW, 400);
        registry.add(ModBlocks.PINK_JACK_O_STRAW, 400);
        if (FabricLoader.getInstance().isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
            registry.add(ModBlocks.ACORN_JACK_O_STRAW, 400);
            registry.add(ModBlocks.AMBER_JACK_O_STRAW, 400);
            registry.add(ModBlocks.ARTICHOKE_JACK_O_STRAW, 400);
            registry.add(ModBlocks.BANANA_JACK_O_STRAW, 400);
            registry.add(ModBlocks.CERULEAN_JACK_O_STRAW, 400);
            registry.add(ModBlocks.FUCHSIA_JACK_O_STRAW, 400);
            registry.add(ModBlocks.GRAPE_JACK_O_STRAW, 400);
            registry.add(ModBlocks.INDIGO_JACK_O_STRAW, 400);
            registry.add(ModBlocks.MAROON_JACK_O_STRAW, 400);
            registry.add(ModBlocks.MAUVE_JACK_O_STRAW, 400);
            registry.add(ModBlocks.MINT_JACK_O_STRAW, 400);
            registry.add(ModBlocks.MOLD_JACK_O_STRAW, 400);
            registry.add(ModBlocks.NAVY_JACK_O_STRAW, 400);
            registry.add(ModBlocks.PEACH_JACK_O_STRAW, 400);
            registry.add(ModBlocks.PERIWINKLE_JACK_O_STRAW, 400);
            registry.add(ModBlocks.SAGE_JACK_O_STRAW, 400);
            registry.add(ModBlocks.SAP_JACK_O_STRAW, 400);
            registry.add(ModBlocks.SHAMROCK_JACK_O_STRAW, 400);
            registry.add(ModBlocks.VELVET_JACK_O_STRAW, 400);
            registry.add(ModBlocks.VERMILION_JACK_O_STRAW, 400);
        }
        if (FabricLoader.getInstance().isModLoaded(BountifulFares.DYE_DEPOT_MOD_ID)) {
            registry.add(ModBlocks.MAROON_JACK_O_STRAW, 400);
            registry.add(ModBlocks.ROSE_JACK_O_STRAW, 400);
            registry.add(ModBlocks.CORAL_JACK_O_STRAW, 400);
            registry.add(ModBlocks.GINGER_JACK_O_STRAW, 400);
            registry.add(ModBlocks.TAN_JACK_O_STRAW, 400);
            registry.add(ModBlocks.BEIGE_JACK_O_STRAW, 400);
            registry.add(ModBlocks.AMBER_JACK_O_STRAW, 400);
            registry.add(ModBlocks.OLIVE_JACK_O_STRAW, 400);
            registry.add(ModBlocks.FOREST_JACK_O_STRAW, 400);
            registry.add(ModBlocks.VERDANT_JACK_O_STRAW, 400);
            registry.add(ModBlocks.TEAL_JACK_O_STRAW, 400);
            registry.add(ModBlocks.MINT_JACK_O_STRAW, 400);
            registry.add(ModBlocks.AQUA_JACK_O_STRAW, 400);
            registry.add(ModBlocks.SLATE_JACK_O_STRAW, 400);
            registry.add(ModBlocks.NAVY_JACK_O_STRAW, 400);
            registry.add(ModBlocks.INDIGO_JACK_O_STRAW, 400);
        }

        }

    public static void registerCeramicCheckeredConversions() {
        registerCheckeredCeramic(ModBlocks.CERAMIC_TILES, ModBlocks.CHECKERED_CERAMIC_TILES);
        registerCheckeredCeramic(ModBlocks.CERAMIC_TILE_STAIRS, ModBlocks.CHECKERED_CERAMIC_TILE_STAIRS);
        registerCheckeredCeramic(ModBlocks.CERAMIC_TILE_SLAB, ModBlocks.CHECKERED_CERAMIC_TILE_SLAB);
        registerCheckeredCeramic(ModBlocks.CRACKED_CERAMIC_TILES, ModBlocks.CRACKED_CHECKERED_CERAMIC_TILES);
        registerCheckeredCeramic(ModBlocks.CERAMIC_MOSAIC, ModBlocks.CHECKERED_CERAMIC_MOSAIC);
        registerCheckeredCeramic(ModBlocks.CERAMIC_MOSAIC_STAIRS, ModBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS);
        registerCheckeredCeramic(ModBlocks.CERAMIC_MOSAIC_SLAB, ModBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB);
    }

    public static void registerCheckeredCeramic(Block normal, Block checkered) {
        ModBlocks.CERAMIC_TO_CHECKERED_CERAMIC.put(normal, checkered);
        ModBlocks.CERAMIC_TO_CHECKERED_CERAMIC.put(checkered, normal);
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
        register(ModBlocks.WALNUT_LOG, ModBlocks.STRIPPED_WALNUT_LOG);
        register(ModBlocks.WALNUT_WOOD, ModBlocks.STRIPPED_WALNUT_WOOD);
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
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WALNUT_LEAVES.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WALNUT_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.WALNUT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WALNUT_MULCH.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WALNUT_MULCH_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.PASSION_FRUIT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.ELDERBERRIES, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LAPISBERRY_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LAPISBERRIES, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_WHEAT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_POTATOES, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_CARROTS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_BEETROOTS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_MAIZE, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_LEEKS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GRASS_SEEDS, 0.3f);
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
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MAIZE_BREAD, 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.WALNUT_COOKIE, 0.85f);
    }


    private static void registerPotionRecipes() {
        invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.CITRUS_ESSENCE, ModPotions.ACIDIC);
        invokeRegisterPotionRecipe(ModPotions.ACIDIC, Items.REDSTONE, ModPotions.LONG_ACIDIC);
        invokeRegisterPotionRecipe(Potions.AWKWARD, Items.GLOWSTONE_DUST, ModPotions.STRONG_ACIDIC);
        invokeRegisterPotionRecipe(ModPotions.ACIDIC, Items.FERMENTED_SPIDER_EYE, ModPotions.STUPOR);
        invokeRegisterPotionRecipe(ModPotions.LONG_ACIDIC, Items.FERMENTED_SPIDER_EYE, ModPotions.LONG_STUPOR);
        invokeRegisterPotionRecipe(ModPotions.STUPOR, Items.REDSTONE, ModPotions.LONG_STUPOR);
    }
}
