package net.hecco.bountifulfares.util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.item.BFItems;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class BFItemGroupAdditions {
    public static void registerItemGroupAdditions() {
//        BountifulFares.LOGGER.info("Adding Items to Vanilla Tabs from " + BountifulFares.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.OAK_FENCE_GATE, BFBlocks.OAK_PICKETS);
            entries.addAfter(Items.SPRUCE_FENCE_GATE, BFBlocks.SPRUCE_PICKETS);
            entries.addAfter(Items.BIRCH_FENCE_GATE, BFBlocks.BIRCH_PICKETS);
            entries.addAfter(Items.JUNGLE_FENCE_GATE, BFBlocks.JUNGLE_PICKETS);
            entries.addAfter(Items.ACACIA_FENCE_GATE, BFBlocks.ACACIA_PICKETS);
            entries.addAfter(Items.DARK_OAK_FENCE_GATE, BFBlocks.DARK_OAK_PICKETS);
            entries.addAfter(Items.MANGROVE_FENCE_GATE, BFBlocks.MANGROVE_PICKETS);
            entries.addAfter(Items.CHERRY_FENCE_GATE, BFBlocks.CHERRY_PICKETS);
            entries.addAfter(Items.BAMBOO_FENCE_GATE, BFBlocks.BAMBOO_PICKETS);
            entries.addAfter(Items.BAMBOO_BUTTON, BFBlocks.WALNUT_LOG);
            entries.addAfter(BFBlocks.WALNUT_LOG, BFBlocks.WALNUT_WOOD);
            entries.addAfter(BFBlocks.WALNUT_WOOD, BFBlocks.STRIPPED_WALNUT_LOG);
            entries.addAfter(BFBlocks.STRIPPED_WALNUT_LOG, BFBlocks.STRIPPED_WALNUT_WOOD);
            entries.addAfter(BFBlocks.STRIPPED_WALNUT_WOOD, BFBlocks.WALNUT_PLANKS);
            entries.addAfter(BFBlocks.WALNUT_PLANKS, BFBlocks.WALNUT_STAIRS);
            entries.addAfter(BFBlocks.WALNUT_STAIRS, BFBlocks.WALNUT_SLAB);
            entries.addAfter(BFBlocks.WALNUT_SLAB, BFBlocks.WALNUT_FENCE);
            entries.addAfter(BFBlocks.WALNUT_FENCE, BFBlocks.WALNUT_FENCE_GATE);
            entries.addAfter(BFBlocks.WALNUT_FENCE_GATE, BFBlocks.WALNUT_PICKETS);
            entries.addAfter(BFBlocks.WALNUT_PICKETS, BFBlocks.WALNUT_DOOR);
            entries.addAfter(BFBlocks.WALNUT_DOOR, BFBlocks.WALNUT_TRAPDOOR);
            entries.addAfter(BFBlocks.WALNUT_TRAPDOOR, BFBlocks.WALNUT_PRESSURE_PLATE);
            entries.addAfter(BFBlocks.WALNUT_PRESSURE_PLATE, BFBlocks.WALNUT_BUTTON);
            entries.addAfter(BFBlocks.WALNUT_BUTTON, BFBlocks.HOARY_LOG);
            entries.addAfter(BFBlocks.HOARY_LOG, BFBlocks.HOARY_WOOD);
            entries.addAfter(BFBlocks.HOARY_WOOD, BFBlocks.STRIPPED_HOARY_LOG);
            entries.addAfter(BFBlocks.STRIPPED_HOARY_LOG, BFBlocks.STRIPPED_HOARY_WOOD);
            entries.addAfter(BFBlocks.STRIPPED_HOARY_WOOD, BFBlocks.HOARY_PLANKS);
            entries.addAfter(BFBlocks.HOARY_PLANKS, BFBlocks.HOARY_STAIRS);
            entries.addAfter(BFBlocks.HOARY_STAIRS, BFBlocks.HOARY_SLAB);
            entries.addAfter(BFBlocks.HOARY_SLAB, BFBlocks.HOARY_FENCE);
            entries.addAfter(BFBlocks.HOARY_FENCE, BFBlocks.HOARY_FENCE_GATE);
            entries.addAfter(BFBlocks.HOARY_FENCE_GATE, BFBlocks.HOARY_PICKETS);
            entries.addAfter(BFBlocks.HOARY_PICKETS, BFBlocks.HOARY_DOOR);
            entries.addAfter(BFBlocks.HOARY_DOOR, BFBlocks.HOARY_TRAPDOOR);
            entries.addAfter(BFBlocks.HOARY_TRAPDOOR, BFBlocks.HOARY_PRESSURE_PLATE);
            entries.addAfter(BFBlocks.HOARY_PRESSURE_PLATE, BFBlocks.HOARY_BUTTON);
            entries.addAfter(Items.CRIMSON_FENCE_GATE, BFBlocks.CRIMSON_PICKETS);
            entries.addAfter(Items.WARPED_FENCE_GATE, BFBlocks.WARPED_PICKETS);
            entries.addAfter(Items.WARPED_BUTTON, BFBlocks.APPLE_LOG);
            entries.addAfter(BFBlocks.APPLE_LOG, BFBlocks.APPLE_WOOD);
            entries.addAfter(BFBlocks.APPLE_WOOD, BFBlocks.STRIPPED_APPLE_LOG);
            entries.addAfter(BFBlocks.STRIPPED_APPLE_LOG, BFBlocks.STRIPPED_APPLE_WOOD);
            entries.addAfter(BFBlocks.STRIPPED_APPLE_WOOD, BFBlocks.ORANGE_LOG);
            entries.addAfter(BFBlocks.ORANGE_LOG, BFBlocks.ORANGE_WOOD);
            entries.addAfter(BFBlocks.ORANGE_WOOD, BFBlocks.STRIPPED_ORANGE_LOG);
            entries.addAfter(BFBlocks.STRIPPED_ORANGE_LOG, BFBlocks.STRIPPED_ORANGE_WOOD);
            entries.addAfter(BFBlocks.STRIPPED_ORANGE_WOOD, BFBlocks.LEMON_LOG);
            entries.addAfter(BFBlocks.LEMON_LOG, BFBlocks.LEMON_WOOD);
            entries.addAfter(BFBlocks.LEMON_WOOD, BFBlocks.STRIPPED_LEMON_LOG);
            entries.addAfter(BFBlocks.STRIPPED_LEMON_LOG, BFBlocks.STRIPPED_LEMON_WOOD);
            entries.addAfter(BFBlocks.STRIPPED_LEMON_WOOD, BFBlocks.PLUM_LOG);
            entries.addAfter(BFBlocks.PLUM_LOG, BFBlocks.PLUM_WOOD);
            entries.addAfter(BFBlocks.PLUM_WOOD, BFBlocks.STRIPPED_PLUM_LOG);
            entries.addAfter(BFBlocks.STRIPPED_PLUM_LOG, BFBlocks.STRIPPED_PLUM_WOOD);
//            entries.addAfter(ModBlocks.STRIPPED_PLUM_WOOD, TrellisUtil.getTrellisFromVariant(ModTrellises.OAK));
//            TrellisVariant prevTrellis = ModTrellises.OAK;
//            for (TrellisVariant trellis : TrellisVariants.TrellisVariants) {
//                if (Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
//                    if (trellis == ModTrellises.OAK) {
//                        continue;
//                    }
//                    if (TrellisUtil.getTrellisFromVariant(trellis) != null) {
//                        entries.addAfter(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(trellis));
//                        prevTrellis = trellis;
//                    }
//                }
//            }
            entries.addAfter(BFBlocks.STRIPPED_PLUM_WOOD, BFBlocks.WALNUT_MULCH);
            entries.addAfter(BFBlocks.WALNUT_MULCH, BFBlocks.WALNUT_MULCH_BLOCK);
            entries.addAfter(Items.DARK_PRISMARINE, BFBlocks.PRISMARINE_BLOSSOM);
            entries.addAfter(Items.PURPUR_SLAB, BFBlocks.FELDSPAR_BLOCK);
            entries.addAfter(BFBlocks.FELDSPAR_BLOCK, BFBlocks.CUT_FELDSPAR_BLOCK);
            entries.addAfter(BFBlocks.CUT_FELDSPAR_BLOCK, BFBlocks.FELDSPAR_BRICKS);
            entries.addAfter(BFBlocks.FELDSPAR_BRICKS, BFBlocks.FELDSPAR_BRICK_STAIRS);
            entries.addAfter(BFBlocks.FELDSPAR_BRICK_STAIRS, BFBlocks.FELDSPAR_BRICK_SLAB);
            entries.addAfter(BFBlocks.FELDSPAR_BRICK_SLAB, BFBlocks.CERAMIC_CLAY_BLOCK);
            entries.addAfter(BFBlocks.CERAMIC_CLAY_BLOCK, BFBlocks.CERAMIC_TILES);
            entries.addAfter(BFBlocks.CERAMIC_TILES, BFBlocks.CERAMIC_TILE_STAIRS);
            entries.addAfter(BFBlocks.CERAMIC_TILE_STAIRS, BFBlocks.CERAMIC_TILE_SLAB);
            entries.addAfter(BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CRACKED_CERAMIC_TILES);
            entries.addAfter(BFBlocks.CRACKED_CERAMIC_TILES, BFBlocks.CERAMIC_TILE_PILLAR);
            entries.addAfter(BFBlocks.CERAMIC_TILE_PILLAR, BFBlocks.CERAMIC_MOSAIC);
            entries.addAfter(BFBlocks.CERAMIC_MOSAIC, BFBlocks.CERAMIC_MOSAIC_STAIRS);
            entries.addAfter(BFBlocks.CERAMIC_MOSAIC_STAIRS, BFBlocks.CERAMIC_MOSAIC_SLAB);
            entries.addAfter(BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_DOOR);
            entries.addAfter(BFBlocks.CERAMIC_DOOR, BFBlocks.CERAMIC_TRAPDOOR);
            entries.addAfter(BFBlocks.CERAMIC_TRAPDOOR, BFBlocks.CERAMIC_PRESSURE_PLATE);
            entries.addAfter(BFBlocks.CERAMIC_PRESSURE_PLATE, BFBlocks.CERAMIC_BUTTON);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Items.GRASS_BLOCK, BFBlocks.GRASSY_DIRT);
            entries.addAfter(Items.CHERRY_LOG, BFBlocks.APPLE_LOG);
            entries.addAfter(BFBlocks.APPLE_LOG, BFBlocks.ORANGE_LOG);
            entries.addAfter(BFBlocks.ORANGE_LOG, BFBlocks.LEMON_LOG);
            entries.addAfter(BFBlocks.LEMON_LOG, BFBlocks.PLUM_LOG);
            entries.addAfter(Items.CHERRY_LOG, BFBlocks.WALNUT_LOG);
            entries.addAfter(BFBlocks.WALNUT_LOG, BFBlocks.HOARY_LOG);
            entries.addAfter(Items.FLOWERING_AZALEA_LEAVES, BFBlocks.APPLE_LEAVES);
            entries.addAfter(BFBlocks.APPLE_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES);
            entries.addAfter(BFBlocks.FLOWERING_APPLE_LEAVES, BFBlocks.ORANGE_LEAVES);
            entries.addAfter(BFBlocks.ORANGE_LEAVES, BFBlocks.FLOWERING_ORANGE_LEAVES);
            entries.addAfter( BFBlocks.FLOWERING_ORANGE_LEAVES, BFBlocks.LEMON_LEAVES);
            entries.addAfter(BFBlocks.LEMON_LEAVES, BFBlocks.FLOWERING_LEMON_LEAVES);
            entries.addAfter(BFBlocks.FLOWERING_LEMON_LEAVES, BFBlocks.PLUM_LEAVES);
            entries.addAfter(BFBlocks.PLUM_LEAVES, BFBlocks.FLOWERING_PLUM_LEAVES);
            entries.addAfter(BFBlocks.FLOWERING_PLUM_LEAVES, BFBlocks.WALNUT_LEAVES);
            entries.addAfter(BFBlocks.WALNUT_LEAVES, BFBlocks.HOARY_LEAVES);
            entries.addAfter(Items.CHERRY_SAPLING, BFBlocks.APPLE_SAPLING);
            entries.addAfter(BFBlocks.APPLE_SAPLING, BFBlocks.ORANGE_SAPLING);
            entries.addAfter(BFBlocks.ORANGE_SAPLING, BFBlocks.LEMON_SAPLING);
            entries.addAfter(BFBlocks.LEMON_SAPLING, BFBlocks.PLUM_SAPLING);
            entries.addAfter(BFBlocks.PLUM_SAPLING, BFBlocks.HOARY_APPLE_SAPLING);
            entries.addAfter(BFBlocks.HOARY_APPLE_SAPLING, BFBlocks.WALNUT_SAPLING);
            entries.addAfter(Items.SNIFFER_EGG, BFBlocks.WILD_WHEAT);
            entries.addAfter(BFBlocks.WILD_WHEAT, BFBlocks.WILD_CARROTS);
            entries.addAfter(BFBlocks.WILD_CARROTS, BFBlocks.WILD_POTATOES);
            entries.addAfter(BFBlocks.WILD_POTATOES, BFBlocks.WILD_BEETROOTS);
            entries.addAfter(BFBlocks.WILD_BEETROOTS, BFBlocks.WILD_LEEKS);
            entries.addAfter(BFBlocks.WILD_LEEKS, BFBlocks.WILD_MAIZE);
            entries.addAfter(BFBlocks.WILD_MAIZE, BFBlocks.WILD_PASSION_FRUIT_VINE);
            entries.addAfter(BFBlocks.WILD_PASSION_FRUIT_VINE, BFBlocks.WILD_ELDERBERRY_VINE);
            entries.addAfter(BFBlocks.WILD_ELDERBERRY_VINE, BFItems.GRASS_SEEDS);
            entries.addAfter(Items.KELP, BFBlocks.SPONGEKIN);
            entries.addAfter(BFBlocks.SPONGEKIN, BFBlocks.PRISMARINE_BLOSSOM);
            entries.addAfter(Items.LILY_OF_THE_VALLEY, BFBlocks.CHAMOMILE_FLOWERS);
            entries.addAfter(BFBlocks.CHAMOMILE_FLOWERS, BFBlocks.HONEYSUCKLE);
            entries.addAfter(BFBlocks.HONEYSUCKLE, BFBlocks.VIOLET_BELLFLOWER);
            entries.addAfter(Items.BEETROOT_SEEDS, BFItems.MAIZE_SEEDS);
            entries.addAfter(BFItems.MAIZE_SEEDS, BFItems.LEEK_SEEDS);
            entries.addAfter(BFItems.LEEK_SEEDS, BFItems.TEA_BERRIES);
            entries.addAfter(BFItems.TEA_BERRIES, BFItems.SPONGEKIN_SEEDS);
            entries.addAfter(Items.PITCHER_POD, BFItems.LAPISBERRY_SEEDS);
            entries.addAfter(BFItems.LAPISBERRY_SEEDS, BFItems.HOARY_SEEDS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.LANTERN, BFBlocks.FELDSPAR_LANTERN);
            entries.addAfter(Items.GRINDSTONE, BFBlocks.GRISTMILL);
            entries.addAfter(Items.SOUL_CAMPFIRE, BFBlocks.GREEN_TEA_CANDLE);
            entries.addAfter(BFBlocks.GREEN_TEA_CANDLE, BFBlocks.BLACK_TEA_CANDLE);
            entries.addAfter(BFBlocks.BLACK_TEA_CANDLE, BFBlocks.CHAMOMILE_CANDLE);
            entries.addAfter(BFBlocks.CHAMOMILE_CANDLE, BFBlocks.HONEYSUCKLE_CANDLE);
            entries.addAfter(BFBlocks.HONEYSUCKLE_CANDLE, BFBlocks.BELLFLOWER_CANDLE);
            entries.addAfter(BFBlocks.BELLFLOWER_CANDLE, BFBlocks.TORCHFLOWER_CANDLE);
            entries.addAfter(BFBlocks.TORCHFLOWER_CANDLE, BFBlocks.WALNUT_CANDLE);
            entries.addAfter(BFBlocks.WALNUT_CANDLE, BFBlocks.FERMENTATION_VESSEL);
//            entries.addAfter(Blocks.COMPOSTER, TrellisUtil.getTrellisFromVariant(ModTrellises.OAK));
//            TrellisVariant prevTrellis = ModTrellises.OAK;
//            for (TrellisVariant trellis : TrellisVariants.TrellisVariants) {
//                if (Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
//                    if (trellis == ModTrellises.OAK) {
//                        continue;
//                    }
//                    if (TrellisUtil.getTrellisFromVariant(trellis) != null) {
//                        entries.addAfter(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(trellis));
//                        prevTrellis = trellis;
//                    }
//                }
//            }
            entries.addAfter(Items.TINTED_GLASS, BFBlocks.TINGED_GLASS);
            entries.addAfter(Items.BAMBOO_HANGING_SIGN, BFItems.WALNUT_SIGN);
            entries.addAfter(BFItems.WALNUT_SIGN, BFItems.WALNUT_HANGING_SIGN);
            entries.addAfter(BFItems.WALNUT_HANGING_SIGN, BFItems.HOARY_SIGN);
            entries.addAfter(BFItems.HOARY_SIGN, BFItems.HOARY_HANGING_SIGN);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(rEntries -> {
            rEntries.addAfter(Items.LEVER, BFBlocks.CERAMIC_LEVER);
            rEntries.addAfter(Items.STONE_BUTTON, BFBlocks.CERAMIC_BUTTON);
            rEntries.addAfter(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, BFBlocks.CERAMIC_PRESSURE_PLATE);
            rEntries.addAfter(Items.WHITE_WOOL, BFBlocks.CERAMIC_TILES);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.LEAD, BFItems.SUN_HAT);
            entries.addAfter(Items.BRUSH, BFItems.ARTISAN_BRUSH);
            entries.addAfter(Items.BAMBOO_CHEST_RAFT, BFItems.WALNUT_BOAT);
            entries.addAfter(BFItems.WALNUT_BOAT, BFItems.WALNUT_CHEST_BOAT);
            entries.addAfter(BFItems.WALNUT_CHEST_BOAT, BFItems.HOARY_BOAT);
            entries.addAfter(BFItems.HOARY_BOAT, BFItems.HOARY_CHEST_BOAT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter(Items.EGG, BFItems.FLOUR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.APPLE, BFItems.APPLE_COMPOTE_JAR);
            entries.addAfter(BFItems.APPLE_COMPOTE_JAR, BFItems.APPLE_CIDER_JAR);
            entries.addAfter(BFItems.APPLE_CIDER_JAR, BFBlocks.APPLE_BLOCK);
            entries.addAfter(BFBlocks.APPLE_BLOCK, BFItems.ORANGE);
            entries.addAfter(BFItems.ORANGE, BFItems.ORANGE_COMPOTE_JAR);
            entries.addAfter(BFItems.ORANGE_COMPOTE_JAR, BFBlocks.ORANGE_BLOCK);
            entries.addAfter(BFBlocks.ORANGE_BLOCK, BFItems.LEMON);
            entries.addAfter(BFItems.LEMON, BFItems.LEMON_COMPOTE_JAR);
            entries.addAfter(BFItems.LEMON_COMPOTE_JAR, BFBlocks.LEMON_BLOCK);
            entries.addAfter(BFBlocks.LEMON_BLOCK, BFItems.PLUM);
            entries.addAfter(BFItems.PLUM, BFItems.PLUM_COMPOTE_JAR);
            entries.addAfter(BFItems.PLUM_COMPOTE_JAR, BFItems.PLUM_CIDER_JAR);
            entries.addAfter(BFItems.PLUM_CIDER_JAR, BFBlocks.PLUM_BLOCK);
            entries.addAfter(BFBlocks.PLUM_BLOCK, BFItems.HOARY_APPLE);
            entries.addAfter(BFItems.HOARY_APPLE, BFItems.HOARY_COMPOTE_JAR);
            entries.addAfter(BFItems.HOARY_COMPOTE_JAR, BFItems.HOARY_CIDER_JAR);
            entries.addAfter(BFItems.HOARY_CIDER_JAR, BFBlocks.HOARY_APPLE_BLOCK);
            entries.addAfter(Items.ENCHANTED_GOLDEN_APPLE, BFBlocks.GOLDEN_APPLE_BLOCK);
            entries.addAfter(Items.MELON_SLICE, BFItems.SPONGEKIN_SLICE);
            entries.addAfter(Items.SWEET_BERRIES, BFItems.PASSION_FRUIT);
            entries.addAfter(BFItems.PASSION_FRUIT, BFItems.ELDERBERRIES);
            entries.addAfter(BFItems.ELDERBERRIES, BFItems.ELDERBERRY_WINE_BOTTLE);
            entries.addAfter(Items.GLOW_BERRIES, BFItems.LAPISBERRIES);
            entries.addAfter(BFItems.LAPISBERRIES, BFItems.LAPISBERRY_WINE_BOTTLE);
            entries.addAfter(Items.MILK_BUCKET, BFItems.GREEN_TEA_BOTTLE);
            entries.addAfter(Items.MILK_BUCKET, BFItems.GREEN_TEA_BOTTLE);
            entries.addAfter(BFItems.GREEN_TEA_BOTTLE, BFItems.BLACK_TEA_BOTTLE);
            entries.addAfter(BFItems.BLACK_TEA_BOTTLE, BFItems.CHAMOMILE_TEA_BOTTLE);
            entries.addAfter(BFItems.CHAMOMILE_TEA_BOTTLE, BFItems.HONEYSUCKLE_TEA_BOTTLE);
            entries.addAfter(BFItems.HONEYSUCKLE_TEA_BOTTLE, BFItems.BELLFLOWER_TEA_BOTTLE);
            entries.addAfter(BFItems.BELLFLOWER_TEA_BOTTLE, BFItems.TORCHFLOWER_TEA_BOTTLE);
            entries.addAfter(Items.HONEY_BOTTLE, BFItems.MEAD_BOTTLE);
            entries.addAfter(Items.BAKED_POTATO, BFItems.MUSHROOM_STUFFED_POTATO);
            entries.addAfter(BFItems.MUSHROOM_STUFFED_POTATO, BFItems.BERRY_STUFFED_POTATO);
            entries.addAfter(BFItems.BERRY_STUFFED_POTATO, BFItems.MAIZE_STUFFED_POTATO);
            entries.addAfter(Items.BEETROOT, BFItems.MAIZE);
            entries.addAfter(BFItems.MAIZE, BFItems.LEEK);
            entries.addAfter(BFItems.LEEK, BFItems.WALNUT);
            entries.addAfter(Items.BREAD, BFItems.MAIZE_BREAD);
            entries.addAfter(BFItems.MAIZE_BREAD, BFBlocks.ARTISAN_BREAD);
            entries.addAfter(Items.COOKIE, BFItems.WALNUT_COOKIE);
            entries.addAfter(BFItems.WALNUT_COOKIE, BFItems.ARTISAN_COOKIE);
            entries.addAfter(BFItems.ARTISAN_COOKIE, BFBlocks.PASSION_FRUIT_TART);
            entries.addAfter(BFBlocks.PASSION_FRUIT_TART, BFBlocks.ELDERBERRY_TART);
            entries.addAfter(BFBlocks.ELDERBERRY_TART, BFBlocks.GLOW_BERRY_TART);
            entries.addAfter(BFBlocks.GLOW_BERRY_TART, BFBlocks.SWEET_BERRY_TART);
            entries.addAfter(BFBlocks.SWEET_BERRY_TART, BFBlocks.LAPISBERRY_TART);
            entries.addAfter(Items.CAKE, BFBlocks.COCOA_CAKE);
            entries.addAfter(Items.PUMPKIN_PIE, BFBlocks.APPLE_PIE);
            entries.addAfter(BFBlocks.APPLE_PIE, BFBlocks.ORANGE_PIE);
            entries.addAfter(BFBlocks.ORANGE_PIE, BFBlocks.LEMON_PIE);
            entries.addAfter(BFBlocks.LEMON_PIE, BFBlocks.PLUM_PIE);
            entries.addAfter(BFBlocks.PLUM_PIE, BFBlocks.HOARY_PIE);
            entries.addAfter(Items.SPIDER_EYE, BFItems.CITRUS_ESSENCE);
            entries.addAfter(BFItems.CITRUS_ESSENCE, BFItems.CANDY);
            entries.addAfter(BFItems.CANDY, BFItems.PIQUANT_CANDY);
            entries.addAfter(BFItems.PIQUANT_CANDY, BFItems.SOUR_CANDY);
            entries.addAfter(BFItems.SOUR_CANDY, BFItems.BITTER_CANDY);
            entries.addAfter(BFItems.BITTER_CANDY, BFItems.CANDIED_APPLE);
            entries.addAfter(BFItems.CANDIED_APPLE, BFItems.CANDIED_PLUM);
            entries.addAfter(BFItems.CANDIED_PLUM, BFItems.CANDIED_ORANGE);
            entries.addAfter(BFItems.CANDIED_ORANGE, BFItems.CANDIED_LEMON);
            entries.addAfter(BFItems.CANDIED_LEMON, BFItems.FOREST_MEDLEY);
            entries.addAfter(BFItems.FOREST_MEDLEY, BFItems.ARID_MEDLEY);
            entries.addAfter(BFItems.ARID_MEDLEY, BFItems.MEADOW_MEDLEY);
            entries.addAfter(BFItems.MEADOW_MEDLEY, BFItems.COASTAL_MEDLEY);
            entries.addAfter(Items.RABBIT_STEW, BFItems.LEEK_STEW);
            entries.addAfter(BFItems.LEEK_STEW, BFItems.FISH_STEW);
            entries.addAfter(BFItems.FISH_STEW, BFItems.APPLE_STEW);
            entries.addAfter(BFItems.APPLE_STEW, BFItems.STONE_STEW);
            entries.addAfter(BFItems.STONE_STEW, BFItems.BOUNTIFUL_STEW);
            entries.addAfter(BFItems.BOUNTIFUL_STEW, BFItems.PASSION_GLAZED_SALMON);
            entries.addAfter(BFItems.PASSION_GLAZED_SALMON, BFItems.CRUSTED_BEEF);
            entries.addAfter(BFItems.CRUSTED_BEEF, BFItems.CRIMSON_CHOW);
            entries.addAfter(BFItems.CRIMSON_CHOW, BFItems.WARPED_CHOW);
            entries.addAfter(BFItems.WARPED_CHOW, BFItems.CUSTARD);
            entries.addAfter(BFItems.CUSTARD, BFItems.PIQUANT_CUSTARD);
            entries.addAfter(BFItems.PIQUANT_CUSTARD, BFItems.PASSION_CUSTARD);
            entries.addAfter(BFItems.PASSION_CUSTARD, BFItems.COCOA_CUSTARD);
            entries.addAfter(BFItems.COCOA_CUSTARD, BFItems.ANCIENT_CUSTARD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.WHEAT, BFItems.MAIZE);
            entries.addAfter(BFItems.MAIZE, BFItems.FLOUR);
            entries.addAfter(Items.SLIME_BALL, BFItems.FELDSPAR);
            entries.addAfter(BFItems.FELDSPAR, BFItems.CERAMIC_CLAY);
            entries.addAfter(BFItems.CERAMIC_CLAY, BFItems.CERAMIC_TILE);
            entries.addAfter(Items.BOWL, BFBlocks.CERAMIC_DISH);
            entries.addAfter(BFBlocks.CERAMIC_DISH, BFItems.JAR);
            entries.addAfter(Items.FIREWORK_STAR, BFItems.TEA_LEAVES);
            entries.addAfter(BFItems.TEA_LEAVES, BFItems.DRIED_TEA_LEAVES);
            entries.addAfter(BFItems.DRIED_TEA_LEAVES, BFItems.GREEN_TEA_BLEND);
            entries.addAfter(BFItems.GREEN_TEA_BLEND, BFItems.BLACK_TEA_BLEND);
            entries.addAfter(BFItems.BLACK_TEA_BLEND, BFItems.CHAMOMILE_TEA_BLEND);
            entries.addAfter(BFItems.CHAMOMILE_TEA_BLEND, BFItems.HONEYSUCKLE_TEA_BLEND);
            entries.addAfter(BFItems.HONEYSUCKLE_TEA_BLEND, BFItems.BELLFLOWER_TEA_BLEND);
            entries.addAfter(BFItems.BELLFLOWER_TEA_BLEND, BFItems.TORCHFLOWER_TEA_BLEND);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(BFBlocks.WHITE_JACK_O_STRAW);
            entries.add(BFBlocks.LIGHT_GRAY_JACK_O_STRAW);
            entries.add(BFBlocks.GRAY_JACK_O_STRAW);
            entries.add(BFBlocks.BLACK_JACK_O_STRAW);
            entries.add(BFBlocks.BROWN_JACK_O_STRAW);
            entries.add(BFBlocks.RED_JACK_O_STRAW);
            entries.add(BFBlocks.ORANGE_JACK_O_STRAW);
            entries.add(BFBlocks.YELLOW_JACK_O_STRAW);
            entries.add(BFBlocks.LIME_JACK_O_STRAW);
            entries.add(BFBlocks.GREEN_JACK_O_STRAW);
            entries.add(BFBlocks.CYAN_JACK_O_STRAW);
            entries.add(BFBlocks.LIGHT_BLUE_JACK_O_STRAW);
            entries.add(BFBlocks.BLUE_JACK_O_STRAW);
            entries.add(BFBlocks.PURPLE_JACK_O_STRAW);
            entries.add(BFBlocks.MAGENTA_JACK_O_STRAW);
            entries.add(BFBlocks.PINK_JACK_O_STRAW);
        });
//        if (BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
//            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
//                entries.addAfter(ModBlocks.BLACK_JACK_O_STRAW, ModBlocks.ACORN_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.BROWN_JACK_O_STRAW,ModBlocks.MAROON_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.RED_JACK_O_STRAW,ModBlocks.PEACH_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.PEACH_JACK_O_STRAW,ModBlocks.VERMILION_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.ORANGE_JACK_O_STRAW,ModBlocks.AMBER_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.YELLOW_JACK_O_STRAW,ModBlocks.BANANA_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.BANANA_JACK_O_STRAW,ModBlocks.ARTICHOKE_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.ARTICHOKE_JACK_O_STRAW,ModBlocks.MOLD_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.LIME_JACK_O_STRAW,ModBlocks.SAGE_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.SAGE_JACK_O_STRAW,ModBlocks.SAP_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.GREEN_JACK_O_STRAW,ModBlocks.SHAMROCK_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.SHAMROCK_JACK_O_STRAW,ModBlocks.MINT_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.CYAN_JACK_O_STRAW,ModBlocks.CERULEAN_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.LIGHT_BLUE_JACK_O_STRAW,ModBlocks.NAVY_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.BLUE_JACK_O_STRAW,ModBlocks.PERIWINKLE_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.PERIWINKLE_JACK_O_STRAW,ModBlocks.GRAPE_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.PURPLE_JACK_O_STRAW,ModBlocks.INDIGO_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.MAGENTA_JACK_O_STRAW,ModBlocks.MAUVE_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.MAUVE_JACK_O_STRAW,ModBlocks.VELVET_JACK_O_STRAW);
//                entries.addAfter(ModBlocks.VELVET_JACK_O_STRAW,ModBlocks.FUCHSIA_JACK_O_STRAW);
//            });
//        }
    }
}
