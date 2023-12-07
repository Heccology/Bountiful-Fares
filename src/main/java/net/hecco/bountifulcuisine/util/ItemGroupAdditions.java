package net.hecco.bountifulcuisine.util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class ItemGroupAdditions {
    public static void registerItemGroupAdditions() {
        BountifulCuisine.LOGGER.info("Adding Items to Vanilla Tabs from " + BountifulCuisine.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.BAMBOO_BUTTON, ModBlocks.HOARY_LOG.asItem());
            entries.addAfter(ModBlocks.HOARY_LOG.asItem(), ModBlocks.HOARY_WOOD.asItem());
            entries.addAfter(ModBlocks.HOARY_WOOD.asItem(), ModBlocks.STRIPPED_HOARY_LOG.asItem());
            entries.addAfter(ModBlocks.STRIPPED_HOARY_LOG.asItem(), ModBlocks.STRIPPED_HOARY_WOOD.asItem());
            entries.addAfter(ModBlocks.STRIPPED_HOARY_WOOD.asItem(), ModBlocks.HOARY_PLANKS.asItem());
            entries.addAfter(ModBlocks.HOARY_PLANKS.asItem(), ModBlocks.HOARY_STAIRS.asItem());
            entries.addAfter(ModBlocks.HOARY_STAIRS.asItem(), ModBlocks.HOARY_SLAB.asItem());
            entries.addAfter(ModBlocks.HOARY_SLAB.asItem(), ModBlocks.HOARY_FENCE.asItem());
            entries.addAfter(ModBlocks.HOARY_FENCE.asItem(), ModBlocks.HOARY_FENCE_GATE.asItem());
            entries.addAfter(ModBlocks.HOARY_FENCE_GATE.asItem(), ModBlocks.HOARY_DOOR.asItem());
            entries.addAfter(ModBlocks.HOARY_DOOR.asItem(), ModBlocks.HOARY_TRAPDOOR.asItem());
            entries.addAfter(ModBlocks.HOARY_TRAPDOOR.asItem(), ModBlocks.HOARY_PRESSURE_PLATE.asItem());
            entries.addAfter(ModBlocks.HOARY_PRESSURE_PLATE.asItem(), ModBlocks.HOARY_BUTTON.asItem());
            entries.addAfter(Items.WARPED_BUTTON, ModBlocks.APPLE_LOG.asItem());
            entries.addAfter(ModBlocks.APPLE_LOG.asItem(), ModBlocks.APPLE_WOOD.asItem());
            entries.addAfter(ModBlocks.APPLE_WOOD.asItem(), ModBlocks.STRIPPED_APPLE_LOG.asItem());
            entries.addAfter(ModBlocks.STRIPPED_APPLE_LOG.asItem(), ModBlocks.STRIPPED_APPLE_WOOD.asItem());
            entries.addAfter(ModBlocks.STRIPPED_APPLE_WOOD.asItem(), ModBlocks.ORANGE_LOG.asItem());
            entries.addAfter(ModBlocks.ORANGE_LOG.asItem(), ModBlocks.ORANGE_WOOD.asItem());
            entries.addAfter(ModBlocks.ORANGE_WOOD.asItem(), ModBlocks.STRIPPED_ORANGE_LOG.asItem());
            entries.addAfter(ModBlocks.STRIPPED_ORANGE_LOG.asItem(), ModBlocks.STRIPPED_ORANGE_WOOD.asItem());
            entries.addAfter(ModBlocks.STRIPPED_ORANGE_WOOD.asItem(), ModBlocks.LEMON_LOG.asItem());
            entries.addAfter(ModBlocks.LEMON_LOG.asItem(), ModBlocks.LEMON_WOOD.asItem());
            entries.addAfter(ModBlocks.LEMON_WOOD.asItem(), ModBlocks.STRIPPED_LEMON_LOG.asItem());
            entries.addAfter(ModBlocks.STRIPPED_LEMON_LOG.asItem(), ModBlocks.STRIPPED_LEMON_WOOD.asItem());
            entries.addAfter(ModBlocks.STRIPPED_LEMON_WOOD.asItem(), ModBlocks.PLUM_LOG.asItem());
            entries.addAfter(ModBlocks.PLUM_LOG.asItem(), ModBlocks.PLUM_WOOD.asItem());
            entries.addAfter(ModBlocks.PLUM_WOOD.asItem(), ModBlocks.STRIPPED_PLUM_LOG.asItem());
            entries.addAfter(ModBlocks.STRIPPED_PLUM_LOG.asItem(), ModBlocks.STRIPPED_PLUM_WOOD.asItem());
            entries.addAfter(ModBlocks.STRIPPED_PLUM_WOOD.asItem(), ModBlocks.TRELLIS.asItem());
            entries.addAfter(Items.DARK_PRISMARINE, ModBlocks.PRISMARINE_BLOSSOM.asItem());
            entries.addAfter(Items.PURPUR_SLAB, ModBlocks.FELDSPAR_BLOCK.asItem());
            entries.addAfter(ModBlocks.FELDSPAR_BLOCK.asItem(), ModBlocks.CERAMIC_CLAY_BLOCK.asItem());
            entries.addAfter(ModBlocks.CERAMIC_CLAY_BLOCK.asItem(), ModBlocks.CERAMIC_TILES.asItem());
            entries.addAfter(ModBlocks.CERAMIC_TILES.asItem(), ModBlocks.CERAMIC_TILE_STAIRS.asItem());
            entries.addAfter(ModBlocks.CERAMIC_TILE_STAIRS.asItem(), ModBlocks.CERAMIC_TILE_SLAB.asItem());
            entries.addAfter(ModBlocks.CERAMIC_TILE_SLAB.asItem(), ModBlocks.CERAMIC_PRESSURE_PLATE.asItem());
            entries.addAfter(ModBlocks.CERAMIC_PRESSURE_PLATE.asItem(), ModBlocks.CERAMIC_BUTTON.asItem());
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Items.CHERRY_LOG, ModBlocks.APPLE_LOG.asItem());
            entries.addAfter(ModBlocks.APPLE_LOG.asItem(), ModBlocks.ORANGE_LOG.asItem());
            entries.addAfter(ModBlocks.ORANGE_LOG.asItem(), ModBlocks.LEMON_LOG.asItem());
            entries.addAfter(ModBlocks.LEMON_LOG.asItem(), ModBlocks.PLUM_BLOCK.asItem());
            entries.addAfter(Items.CHERRY_LOG, ModBlocks.HOARY_LOG.asItem());
            entries.addAfter(Items.FLOWERING_AZALEA_LEAVES, ModBlocks.APPLE_LEAVES.asItem());
            entries.addAfter(ModBlocks.APPLE_LEAVES.asItem(), ModBlocks.FLOWERING_APPLE_LEAVES.asItem());
            entries.addAfter(ModBlocks.FLOWERING_APPLE_LEAVES.asItem(), ModBlocks.ORANGE_LEAVES.asItem());
            entries.addAfter(ModBlocks.ORANGE_LEAVES.asItem(), ModBlocks.FLOWERING_ORANGE_LEAVES.asItem());
            entries.addAfter( ModBlocks.FLOWERING_ORANGE_LEAVES.asItem(), ModBlocks.LEMON_LEAVES.asItem());
            entries.addAfter(ModBlocks.LEMON_LEAVES.asItem(), ModBlocks.FLOWERING_LEMON_LEAVES.asItem());
            entries.addAfter(ModBlocks.FLOWERING_LEMON_LEAVES.asItem(), ModBlocks.PLUM_LEAVES.asItem());
            entries.addAfter(ModBlocks.PLUM_LEAVES.asItem(), ModBlocks.FLOWERING_PLUM_LEAVES.asItem());
            entries.addAfter(ModBlocks.FLOWERING_PLUM_LEAVES.asItem(), ModBlocks.HOARY_LEAVES.asItem());
            entries.addAfter(Items.FLOWERING_AZALEA, ModBlocks.APPLE_SAPLING.asItem());
            entries.addAfter(ModBlocks.APPLE_SAPLING.asItem(), ModBlocks.ORANGE_SAPLING.asItem());
            entries.addAfter(ModBlocks.ORANGE_SAPLING.asItem(), ModBlocks.LEMON_SAPLING.asItem());
            entries.addAfter(ModBlocks.LEMON_SAPLING.asItem(), ModBlocks.PLUM_SAPLING.asItem());
            entries.addAfter(ModBlocks.PLUM_SAPLING.asItem(), ModBlocks.HOARY_APPLE_SAPLING.asItem());
            entries.addAfter(Items.DEAD_BUSH, ModBlocks.WILD_WHEAT.asItem());
            entries.addAfter(ModBlocks.WILD_WHEAT.asItem(), ModBlocks.WILD_CARROTS.asItem());
            entries.addAfter(ModBlocks.WILD_CARROTS.asItem(), ModBlocks.WILD_POTATOES.asItem());
            entries.addAfter(ModBlocks.WILD_POTATOES.asItem(), ModBlocks.WILD_BEETROOTS.asItem());
            entries.addAfter(ModBlocks.WILD_BEETROOTS.asItem(), ModBlocks.WILD_GOOSEBERRIES.asItem());
            entries.addAfter(Items.KELP, ModBlocks.SPONGEKIN_SPROUT.asItem());
            entries.addAfter(ModBlocks.SPONGEKIN_SPROUT.asItem(), ModBlocks.SPONGEKIN.asItem());
            entries.addAfter(ModBlocks.SPONGEKIN.asItem(), ModBlocks.PRISMARINE_BLOSSOM.asItem());
            entries.addAfter(Items.LILY_OF_THE_VALLEY, ModBlocks.CHAMOMILE_FLOWERS.asItem());
            entries.addAfter(ModBlocks.CHAMOMILE_FLOWERS.asItem(), ModBlocks.HONEYSUCKLE.asItem());
            entries.addAfter(ModBlocks.HONEYSUCKLE.asItem(), ModBlocks.VIOLET_BELLFLOWER.asItem());
            entries.addAfter(Items.BEETROOT_SEEDS, ModItems.MAIZE_SEEDS);
            entries.addAfter(ModItems.MAIZE_SEEDS, ModItems.GOOSEBERRY_SEEDS);
            entries.addAfter(ModItems.GOOSEBERRY_SEEDS, ModItems.TEA_BERRIES);
            entries.addAfter(ModItems.TEA_BERRIES, ModItems.SPONGEKIN_SEEDS);
            entries.addAfter(Items.PITCHER_POD, ModItems.LAPISBERRY_SEEDS);
            entries.addAfter(ModItems.LAPISBERRY_SEEDS, ModItems.HOARY_SEEDS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.LANTERN, ModBlocks.FELDSPAR_LANTERN.asItem());
            entries.addAfter(Items.GRINDSTONE, ModBlocks.GRISTMILL.asItem());
            entries.addAfter(Items.SOUL_CAMPFIRE, ModBlocks.FERMENTATION_VESSEL.asItem());
            entries.addAfter(Items.GLOW_LICHEN, ModBlocks.GREEN_TEA_CANDLE.asItem());
            entries.addAfter(ModBlocks.GREEN_TEA_CANDLE.asItem(), ModBlocks.BLACK_TEA_CANDLE.asItem());
            entries.addAfter(ModBlocks.BLACK_TEA_CANDLE.asItem(), ModBlocks.CHAMOMILE_CANDLE.asItem());
            entries.addAfter(ModBlocks.CHAMOMILE_CANDLE.asItem(), ModBlocks.HONEYSUCKLE_CANDLE.asItem());
            entries.addAfter(ModBlocks.HONEYSUCKLE_CANDLE.asItem(), ModBlocks.BELLFLOWER_CANDLE.asItem());
            entries.addAfter(ModBlocks.BELLFLOWER_CANDLE.asItem(), ModBlocks.TORCHFLOWER_CANDLE.asItem());
            entries.addAfter(Items.TINTED_GLASS, ModBlocks.TINGED_GLASS.asItem());
            entries.addAfter(Items.WARPED_HANGING_SIGN, ModItems.HOARY_SIGN);
            entries.addAfter(ModItems.HOARY_SIGN, ModItems.HOARY_HANGING_SIGN);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.addAfter(Items.STONE_BUTTON, ModBlocks.CERAMIC_BUTTON.asItem());
            entries.addAfter(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, ModBlocks.CERAMIC_PRESSURE_PLATE.asItem());
            entries.addAfter(Items.WHITE_WOOL, ModBlocks.CERAMIC_TILES.asItem());
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.LEAD, ModItems.SUN_HAT);
            entries.addAfter(Items.BAMBOO_CHEST_RAFT, ModItems.HOARY_BOAT);
            entries.addAfter(ModItems.HOARY_BOAT, ModItems.HOARY_CHEST_BOAT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter(Items.EGG, ModItems.FLOUR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.APPLE, ModBlocks.APPLE_BLOCK.asItem());
            entries.addAfter(ModBlocks.APPLE_BLOCK.asItem(), ModItems.ORANGE);
            entries.addAfter(ModItems.ORANGE, ModItems.CANDIED_ORANGE);
            entries.addAfter(ModItems.CANDIED_ORANGE, ModBlocks.ORANGE_BLOCK.asItem());
            entries.addAfter(ModBlocks.ORANGE_BLOCK.asItem(), ModItems.LEMON);
            entries.addAfter(ModItems.LEMON, ModItems.CANDIED_LEMON);
            entries.addAfter(ModItems.CANDIED_LEMON, ModBlocks.LEMON_BLOCK.asItem());
            entries.addAfter(ModBlocks.LEMON_BLOCK.asItem(), ModItems.PLUM);
            entries.addAfter(ModItems.PLUM, ModBlocks.PLUM_BLOCK.asItem());
            entries.addAfter(ModBlocks.PLUM_BLOCK.asItem(), ModItems.HOARY_APPLE);
            entries.addAfter(ModItems.HOARY_APPLE, ModBlocks.HOARY_APPLE_BLOCK.asItem());
            entries.addAfter(Items.ENCHANTED_GOLDEN_APPLE, ModBlocks.GOLDEN_APPLE_BLOCK.asItem());
            entries.addAfter(Items.MELON_SLICE, ModItems.SPONGEKIN_SLICE);
            entries.addAfter(Items.SWEET_BERRIES, ModBlocks.PASSION_FRUIT);
            entries.addAfter(ModBlocks.PASSION_FRUIT, ModBlocks.ELDERBERRIES);
            entries.addAfter(ModBlocks.ELDERBERRIES, ModItems.ELDERBERRY_WINE_BOTTLE);
            entries.addAfter(Items.GLOW_BERRIES, ModBlocks.LAPISBERRIES);
            entries.addAfter(Items.MILK_BUCKET, ModItems.GREEN_TEA_BOTTLE);
            entries.addAfter(ModItems.GREEN_TEA_BOTTLE, ModItems.BLACK_TEA_BOTTLE);
            entries.addAfter(ModItems.BLACK_TEA_BOTTLE, ModItems.CHAMOMILE_TEA_BOTTLE);
            entries.addAfter(ModItems.CHAMOMILE_TEA_BOTTLE, ModItems.HONEYSUCKLE_TEA_BOTTLE);
            entries.addAfter(ModItems.HONEYSUCKLE_TEA_BOTTLE, ModItems.BELLFLOWER_TEA_BOTTLE);
            entries.addAfter(ModItems.BELLFLOWER_TEA_BOTTLE, ModItems.TORCHFLOWER_TEA_BOTTLE);
            entries.addAfter(Items.BEETROOT, ModItems.MAIZE);
            entries.addAfter(ModItems.MAIZE, ModItems.GOOSEBERRIES);
            entries.addAfter(Items.BREAD, ModBlocks.ARTISAN_BREAD.asItem());
            entries.addAfter(Items.COOKIE, ModItems.ARTISAN_COOKIE);
            entries.addAfter(ModItems.ARTISAN_COOKIE, ModBlocks.PASSION_FRUIT_TART.asItem());
            entries.addAfter(ModBlocks.PASSION_FRUIT_TART.asItem(), ModBlocks.ELDERBERRY_TART.asItem());
            entries.addAfter(ModBlocks.ELDERBERRY_TART.asItem(), ModBlocks.GLOW_BERRY_TART.asItem());
            entries.addAfter(ModBlocks.GLOW_BERRY_TART.asItem(), ModBlocks.SWEET_BERRY_TART.asItem());
            entries.addAfter(ModBlocks.SWEET_BERRY_TART.asItem(), ModBlocks.LAPISBERRY_TART.asItem());
            entries.addAfter(Items.PUMPKIN_PIE, ModBlocks.APPLE_PIE.asItem());
            entries.addAfter(ModBlocks.APPLE_PIE.asItem(), ModBlocks.ORANGE_PIE.asItem());
            entries.addAfter(ModBlocks.ORANGE_PIE.asItem(), ModBlocks.LEMON_PIE.asItem());
            entries.addAfter(ModBlocks.LEMON_PIE.asItem(), ModBlocks.PLUM_PIE.asItem());
            entries.addAfter(Items.SPIDER_EYE, ModItems.CITRIC_ACID);
            entries.addAfter(ModItems.CITRIC_ACID, ModItems.CANDY);
            entries.addAfter(ModItems.CANDY, ModItems.PIQUANT_CANDY);
            entries.addAfter(ModItems.PIQUANT_CANDY, ModItems.SOUR_CANDY);
            entries.addAfter(ModItems.SOUR_CANDY, ModItems.BITTER_CANDY);
            entries.addAfter(Items.RABBIT_STEW, ModItems.PASSION_GLAZED_SALMON);
            entries.addAfter(ModItems.PASSION_GLAZED_SALMON, ModItems.BOUNTIFUL_STEW);
            entries.addAfter(ModItems.BOUNTIFUL_STEW, ModItems.WILD_ROAST);
            entries.addAfter(ModItems.WILD_ROAST, ModItems.CRIMSON_CHOW);
            entries.addAfter(ModItems.CRIMSON_CHOW, ModItems.WARPED_CHOW);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.WHEAT, ModItems.MAIZE);
            entries.addAfter(ModItems.MAIZE, ModItems.FLOUR);
            entries.addAfter(Items.SLIME_BALL, ModItems.FELDSPAR);
            entries.addAfter(ModItems.FELDSPAR, ModItems.CERAMIC_CLAY);
            entries.addAfter(ModItems.CERAMIC_CLAY, ModItems.CERAMIC_TILE);
            entries.addAfter(Items.FIREWORK_STAR, ModItems.TEA_LEAVES);
            entries.addAfter(ModItems.TEA_LEAVES, ModItems.DRIED_TEA_LEAVES);
            entries.addAfter(ModItems.DRIED_TEA_LEAVES, ModItems.GREEN_TEA_BLEND);
            entries.addAfter(ModItems.GREEN_TEA_BLEND, ModItems.BLACK_TEA_BLEND);
            entries.addAfter(ModItems.BLACK_TEA_BLEND, ModItems.CHAMOMILE_TEA_BLEND);
            entries.addAfter(ModItems.CHAMOMILE_TEA_BLEND, ModItems.HONEYSUCKLE_TEA_BLEND);
            entries.addAfter(ModItems.HONEYSUCKLE_TEA_BLEND, ModItems.BELLFLOWER_TEA_BLEND);
            entries.addAfter(ModItems.BELLFLOWER_TEA_BLEND, ModItems.TORCHFLOWER_TEA_BLEND);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(ModBlocks.WHITE_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.LIGHT_GRAY_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.GRAY_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.BLACK_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.BROWN_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.RED_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.ORANGE_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.YELLOW_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.LIME_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.GREEN_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.CYAN_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.LIGHT_BLUE_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.BLUE_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.PURPLE_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.MAGENTA_JACK_O_STRAW.asItem());
            entries.add(ModBlocks.PINK_JACK_O_STRAW.asItem());
        });
        if (FabricLoader.getInstance().isModLoaded(BountifulCuisine.ELS_AND_LS_DYES_MOD_ID)) {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
                entries.addAfter(ModBlocks.BLACK_JACK_O_STRAW.asItem(), ModBlocks.ACORN_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.BROWN_JACK_O_STRAW.asItem(),ModBlocks.MAROON_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.RED_JACK_O_STRAW.asItem(),ModBlocks.PEACH_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.PEACH_JACK_O_STRAW.asItem(),ModBlocks.VERMILION_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.ORANGE_JACK_O_STRAW.asItem(),ModBlocks.AMBER_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.YELLOW_JACK_O_STRAW.asItem(),ModBlocks.BANANA_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.BANANA_JACK_O_STRAW.asItem(),ModBlocks.ARTICHOKE_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.ARTICHOKE_JACK_O_STRAW.asItem(),ModBlocks.MOLD_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.LIME_JACK_O_STRAW.asItem(),ModBlocks.SAGE_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.SAGE_JACK_O_STRAW.asItem(),ModBlocks.SAP_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.GREEN_JACK_O_STRAW.asItem(),ModBlocks.SHAMROCK_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.SHAMROCK_JACK_O_STRAW.asItem(),ModBlocks.MINT_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.CYAN_JACK_O_STRAW.asItem(),ModBlocks.CERULEAN_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.LIGHT_BLUE_JACK_O_STRAW.asItem(),ModBlocks.NAVY_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.BLUE_JACK_O_STRAW.asItem(),ModBlocks.PERIWINKLE_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.PERIWINKLE_JACK_O_STRAW.asItem(),ModBlocks.GRAPE_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.PURPLE_JACK_O_STRAW.asItem(),ModBlocks.INDIGO_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.MAGENTA_JACK_O_STRAW.asItem(),ModBlocks.MAUVE_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.MAUVE_JACK_O_STRAW.asItem(),ModBlocks.VELVET_JACK_O_STRAW.asItem());
                entries.addAfter(ModBlocks.VELVET_JACK_O_STRAW.asItem(),ModBlocks.FUCHSIA_JACK_O_STRAW.asItem());
            });
        }
    }
}
