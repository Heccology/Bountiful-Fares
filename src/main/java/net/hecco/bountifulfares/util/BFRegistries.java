package net.hecco.bountifulfares.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.hecco.bountifulfares.potion.BFPotions;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

import static net.fabricmc.fabric.api.registry.StrippableBlockRegistry.register;
import static net.hecco.bountifulfares.mixin.BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe;
import static net.minecraft.block.ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE;

public class BFRegistries {
    public static void RegisterModStuffs() {
        registerStrippables();
        registerCeramicCheckeredConversions();
        registerFuels();
        registerModCompostables();
        registerPotionRecipes();
        registerFermentationRecipes();
        DispenserBlock.registerBehavior(BFItems.FLOUR, new FlourDispenserBehavior() {
            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return new FlourProjectileEntity(world, position.getX(), position.getY(), position.getZ());
            }
        });
        DispenserBlock.registerBehavior(BFItems.GRASS_SEEDS, new GrassSeedsDispenserBehavior() {
            @Override
            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                return super.dispenseSilently(pointer, stack);
            }
        });
    }

    public static void registerFermentationRecipes() {
        FermentationRecipes.addRecipe(BFItems.ELDERBERRIES, null, BFItems.ELDERBERRY_WINE_BOTTLE, Items.GLASS_BOTTLE, null);
        FermentationRecipes.addRecipe(BFItems.LAPISBERRIES, null, BFItems.LAPISBERRY_WINE_BOTTLE, Items.GLASS_BOTTLE, null);
        FermentationRecipes.addRecipe(Items.HONEY_BOTTLE, Items.GLASS_BOTTLE, BFItems.MEAD_BOTTLE, Items.GLASS_BOTTLE, null);
        FermentationRecipes.addRecipe(Items.APPLE, null, BFItems.APPLE_CIDER_JAR, BFItems.JAR, null);
        FermentationRecipes.addRecipe(BFItems.PLUM, null, BFItems.PLUM_CIDER_JAR, BFItems.JAR, null);
        FermentationRecipes.addRecipe(BFItems.HOARY_APPLE, null, BFItems.HOARY_CIDER_JAR, BFItems.JAR, null);
        FermentationRecipes.addRecipe(BFItems.ORANGE, null, BFItems.CITRUS_ESSENCE, null, 4);
        FermentationRecipes.addRecipe(BFItems.LEMON, null, BFItems.CITRUS_ESSENCE, null, 4);
        FermentationRecipes.addRecipe(Items.SPIDER_EYE, null, Items.FERMENTED_SPIDER_EYE, null, null);
    }

    public static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(BFItemTags.FRUIT_LOGS, 200);
        registry.add(BFItemTags.HOARY_LOGS, 300);
        registry.add(BFItemTags.WALNUT_LOGS, 300);
        registry.add(BFItemTags.PICKETS, 200);
        for (TrellisVariant trellis : TrellisUtil.TrellisVariants) {
            registry.add(TrellisUtil.getTrellisFromVariant(trellis), 300);
        }
        registry.add(BFBlocks.GRISTMILL, 300);
        registry.add(BFBlocks.WHITE_JACK_O_STRAW, 400);
        registry.add(BFBlocks.LIGHT_GRAY_JACK_O_STRAW, 400);
        registry.add(BFBlocks.GRAY_JACK_O_STRAW, 400);
        registry.add(BFBlocks.BLACK_JACK_O_STRAW, 400);
        registry.add(BFBlocks.BROWN_JACK_O_STRAW, 400);
        registry.add(BFBlocks.RED_JACK_O_STRAW, 400);
        registry.add(BFBlocks.ORANGE_JACK_O_STRAW, 400);
        registry.add(BFBlocks.YELLOW_JACK_O_STRAW, 400);
        registry.add(BFBlocks.LIME_JACK_O_STRAW, 400);
        registry.add(BFBlocks.GREEN_JACK_O_STRAW, 400);
        registry.add(BFBlocks.CYAN_JACK_O_STRAW, 400);
        registry.add(BFBlocks.LIGHT_BLUE_JACK_O_STRAW, 400);
        registry.add(BFBlocks.BLUE_JACK_O_STRAW, 400);
        registry.add(BFBlocks.PURPLE_JACK_O_STRAW, 400);
        registry.add(BFBlocks.MAGENTA_JACK_O_STRAW, 400);
        registry.add(BFBlocks.PINK_JACK_O_STRAW, 400);
        registry.add(BFBlocks.PALM_FROND, 100);
        registry.add(BFItems.COCONUT_COIR, 100);
        registry.add(BFBlocks.PACKED_COCONUT_COIR, 400);
        registry.add(BFBlocks.COIR_CARPET, 200);
        registry.add(BFBlocks.COIR_BRICKS, 400);
        registry.add(BFBlocks.COIR_BRICK_SLAB, 400);
        registry.add(BFBlocks.COIR_BRICK_STAIRS, 400);
        registry.add(BFBlocks.COIR_BRICK_WALL, 400);
        if (BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
            registry.add(BFBlocks.ACORN_JACK_O_STRAW, 400);
            registry.add(BFBlocks.AMBER_JACK_O_STRAW, 400);
            registry.add(BFBlocks.ARTICHOKE_JACK_O_STRAW, 400);
            registry.add(BFBlocks.BANANA_JACK_O_STRAW, 400);
            registry.add(BFBlocks.CERULEAN_JACK_O_STRAW, 400);
            registry.add(BFBlocks.FUCHSIA_JACK_O_STRAW, 400);
            registry.add(BFBlocks.GRAPE_JACK_O_STRAW, 400);
            registry.add(BFBlocks.INDIGO_JACK_O_STRAW, 400);
            registry.add(BFBlocks.MAROON_JACK_O_STRAW, 400);
            registry.add(BFBlocks.MAUVE_JACK_O_STRAW, 400);
            registry.add(BFBlocks.MINT_JACK_O_STRAW, 400);
            registry.add(BFBlocks.MOLD_JACK_O_STRAW, 400);
            registry.add(BFBlocks.NAVY_JACK_O_STRAW, 400);
            registry.add(BFBlocks.PEACH_JACK_O_STRAW, 400);
            registry.add(BFBlocks.PERIWINKLE_JACK_O_STRAW, 400);
            registry.add(BFBlocks.SAGE_JACK_O_STRAW, 400);
            registry.add(BFBlocks.SAP_JACK_O_STRAW, 400);
            registry.add(BFBlocks.SHAMROCK_JACK_O_STRAW, 400);
            registry.add(BFBlocks.VELVET_JACK_O_STRAW, 400);
            registry.add(BFBlocks.VERMILION_JACK_O_STRAW, 400);
        }
        if (BountifulFares.isModLoaded(BountifulFares.DYE_DEPOT_MOD_ID)) {
            registry.add(BFBlocks.MAROON_JACK_O_STRAW, 400);
            registry.add(BFBlocks.ROSE_JACK_O_STRAW, 400);
            registry.add(BFBlocks.CORAL_JACK_O_STRAW, 400);
            registry.add(BFBlocks.GINGER_JACK_O_STRAW, 400);
            registry.add(BFBlocks.TAN_JACK_O_STRAW, 400);
            registry.add(BFBlocks.BEIGE_JACK_O_STRAW, 400);
            registry.add(BFBlocks.AMBER_JACK_O_STRAW, 400);
            registry.add(BFBlocks.OLIVE_JACK_O_STRAW, 400);
            registry.add(BFBlocks.FOREST_JACK_O_STRAW, 400);
            registry.add(BFBlocks.VERDANT_JACK_O_STRAW, 400);
            registry.add(BFBlocks.TEAL_JACK_O_STRAW, 400);
            registry.add(BFBlocks.MINT_JACK_O_STRAW, 400);
            registry.add(BFBlocks.AQUA_JACK_O_STRAW, 400);
            registry.add(BFBlocks.SLATE_JACK_O_STRAW, 400);
            registry.add(BFBlocks.NAVY_JACK_O_STRAW, 400);
            registry.add(BFBlocks.INDIGO_JACK_O_STRAW, 400);
        }
        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
            registry.add(BFBlocks.WALNUT_VERTICAL_STAIRS, 300);
            registry.add(BFBlocks.CHISELED_WALNUT_PLANKS, 300);
            registry.add(BFBlocks.WALNUT_MOSAIC, 300);
            registry.add(BFBlocks.WALNUT_MOSAIC_SLAB, 300);
            registry.add(BFBlocks.WALNUT_MOSAIC_STAIRS, 300);
            registry.add(BFBlocks.WALNUT_MOSAIC_VERTICAL_STAIRS, 300);
            registry.add(BFBlocks.WALNUT_LADDER, 300);
            registry.add(BFBlocks.HOARY_VERTICAL_STAIRS, 300);
            registry.add(BFBlocks.CHISELED_HOARY_PLANKS, 300);
            registry.add(BFBlocks.HOARY_MOSAIC, 300);
            registry.add(BFBlocks.HOARY_MOSAIC_SLAB, 300);
            registry.add(BFBlocks.HOARY_MOSAIC_STAIRS, 300);
            registry.add(BFBlocks.HOARY_MOSAIC_VERTICAL_STAIRS, 300);
            registry.add(BFBlocks.HOARY_LADDER, 300);
        }

        }

    public static void registerCeramicCheckeredConversions() {
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILES, BFBlocks.CHECKERED_CERAMIC_TILES);
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILE_STAIRS, BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS);
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CHECKERED_CERAMIC_TILE_SLAB);
        registerCheckeredCeramic(BFBlocks.CRACKED_CERAMIC_TILES, BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES);
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC, BFBlocks.CHECKERED_CERAMIC_MOSAIC);
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC_STAIRS, BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS);
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB);
        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
            registerCheckeredCeramic(BFBlocks.CERAMIC_TILE_VERTICAL_STAIRS, BFBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS);
            registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS, BFBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS);
        }
    }

    public static void registerCheckeredCeramic(Block normal, Block checkered) {
        BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.put(normal, checkered);
        BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.put(checkered, normal);
    }

    public static void registerStrippables() {
        register(BFBlocks.APPLE_LOG, BFBlocks.STRIPPED_APPLE_LOG);
        register(BFBlocks.APPLE_WOOD, BFBlocks.STRIPPED_APPLE_WOOD);
        register(BFBlocks.ORANGE_LOG, BFBlocks.STRIPPED_ORANGE_LOG);
        register(BFBlocks.ORANGE_WOOD, BFBlocks.STRIPPED_ORANGE_WOOD);
        register(BFBlocks.LEMON_LOG, BFBlocks.STRIPPED_LEMON_LOG);
        register(BFBlocks.LEMON_WOOD, BFBlocks.STRIPPED_LEMON_WOOD);
        register(BFBlocks.PLUM_LOG, BFBlocks.STRIPPED_PLUM_LOG);
        register(BFBlocks.PLUM_WOOD, BFBlocks.STRIPPED_PLUM_WOOD);
        register(BFBlocks.HOARY_LOG, BFBlocks.STRIPPED_HOARY_LOG);
        register(BFBlocks.HOARY_WOOD, BFBlocks.STRIPPED_HOARY_WOOD);
        register(BFBlocks.WALNUT_LOG, BFBlocks.STRIPPED_WALNUT_LOG);
        register(BFBlocks.WALNUT_WOOD, BFBlocks.STRIPPED_WALNUT_WOOD);
        register(BFBlocks.PALM_LOG, BFBlocks.STRIPPED_PALM_LOG);
        register(BFBlocks.PALM_WOOD, BFBlocks.STRIPPED_PALM_WOOD);
    }

    private static void registerModCompostables() {
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.APPLE_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.FLOWERING_APPLE_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.APPLE_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.APPLE_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.ORANGE_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.FLOWERING_ORANGE_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.ORANGE_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.ORANGE_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.ORANGE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.LEMON_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.FLOWERING_LEMON_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.LEMON_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.LEMON_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.LEMON, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.PLUM_LEAVES.asItem(), 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.FLOWERING_PLUM_LEAVES.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.PLUM_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.PLUM_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.PLUM, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.HOARY_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.HOARY_LEAVES.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.HOARY_APPLE_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.HOARY_APPLE_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.HOARY_APPLE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.WALNUT_LEAVES.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.WALNUT_SAPLING.asItem(), 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.WALNUT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.WALNUT_MULCH.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.WALNUT_MULCH_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.COCONUT, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.COCONUT_HALF, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.PALM_FROND, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.COCONUT_COIR, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.PACKED_COCONUT_COIR, 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.COIR_CARPET, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.COCONUT_MULCH.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.COCONUT_MULCH_BLOCK.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.PASSION_FRUIT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.ELDERBERRIES, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.LAPISBERRY_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.LAPISBERRIES, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.WILD_WHEAT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.WILD_POTATOES, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.WILD_CARROTS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.WILD_BEETROOTS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.WILD_MAIZE, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.WILD_LEEKS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.GRASS_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.MAIZE_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.MAIZE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.LEEK_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.LEEK, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.FLOUR, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.SPONGEKIN_SEEDS, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.SPONGEKIN.asItem(), 1f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.SPONGEKIN_SLICE, 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.TEA_BERRIES, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.TEA_LEAVES, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.DRIED_TEA_LEAVES, 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.CHAMOMILE_FLOWERS.asItem(), 0.5f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.HONEYSUCKLE.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFBlocks.VIOLET_BELLFLOWER.asItem(), 0.65f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.GREEN_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.BLACK_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.CHAMOMILE_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.HONEYSUCKLE_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.BELLFLOWER_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.TORCHFLOWER_TEA_BLEND, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.MAIZE_BREAD, 0.85f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(BFItems.WALNUT_COOKIE, 0.85f);
    }


    private static void registerPotionRecipes() {
        invokeRegisterPotionRecipe(Potions.AWKWARD, BFItems.CITRUS_ESSENCE, BFPotions.ACIDIC);
        invokeRegisterPotionRecipe(BFPotions.ACIDIC, Items.REDSTONE, BFPotions.LONG_ACIDIC);
        invokeRegisterPotionRecipe(BFPotions.ACIDIC, Items.GLOWSTONE_DUST, BFPotions.STRONG_ACIDIC);
        invokeRegisterPotionRecipe(BFPotions.ACIDIC, Items.FERMENTED_SPIDER_EYE, BFPotions.STUPOR);
        invokeRegisterPotionRecipe(BFPotions.LONG_ACIDIC, Items.FERMENTED_SPIDER_EYE, BFPotions.LONG_STUPOR);
        invokeRegisterPotionRecipe(BFPotions.STUPOR, Items.REDSTONE, BFPotions.LONG_STUPOR);
    }
}
