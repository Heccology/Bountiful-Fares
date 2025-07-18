package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;
import java.util.Map;

public class BFItemGroupAdditions {
    public static void registerItemGroupAdditions() {
//        Map<ItemLike, ItemLike> BUILDING_BLOCKS = new HashMap<>(); //TODO: SOMETHING HAPPENED :(
//        BUILDING_BLOCKS.put(Items.OAK_FENCE_GATE, BFBlocks.OAK_PICKETS.get());
//        BUILDING_BLOCKS.put(Items.SPRUCE_FENCE_GATE, BFBlocks.SPRUCE_PICKETS.get());
//        BUILDING_BLOCKS.put(Items.BIRCH_FENCE_GATE, BFBlocks.BIRCH_PICKETS.get());
//        BUILDING_BLOCKS.put(Items.JUNGLE_FENCE_GATE, BFBlocks.JUNGLE_PICKETS.get());
//        BUILDING_BLOCKS.put(Items.ACACIA_FENCE_GATE, BFBlocks.ACACIA_PICKETS.get());
//        BUILDING_BLOCKS.put(Items.DARK_OAK_FENCE_GATE, BFBlocks.DARK_OAK_PICKETS.get());
//        BUILDING_BLOCKS.put(Items.MANGROVE_FENCE_GATE, BFBlocks.MANGROVE_PICKETS.get());
//        BUILDING_BLOCKS.put(Items.CHERRY_FENCE_GATE, BFBlocks.CHERRY_PICKETS.get());
//        BUILDING_BLOCKS.put(Items.BAMBOO_FENCE_GATE, BFBlocks.BAMBOO_PICKETS.get());
//        BUILDING_BLOCKS.put(Items.BAMBOO_BUTTON, BFBlocks.WALNUT_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_LOG.get(), BFBlocks.WALNUT_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_WOOD.get(), BFBlocks.STRIPPED_WALNUT_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_WALNUT_LOG.get(), BFBlocks.STRIPPED_WALNUT_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_WALNUT_WOOD.get(), BFBlocks.WALNUT_PLANKS.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_PLANKS.get(), BFBlocks.WALNUT_STAIRS.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_STAIRS.get(), BFBlocks.WALNUT_SLAB.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_SLAB.get(), BFBlocks.WALNUT_FENCE.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_FENCE.get(), BFBlocks.WALNUT_FENCE_GATE.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_FENCE_GATE.get(), BFBlocks.WALNUT_PICKETS.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_PICKETS.get(), BFBlocks.WALNUT_DOOR.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_DOOR.get(), BFBlocks.WALNUT_TRAPDOOR.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_TRAPDOOR.get(), BFBlocks.WALNUT_PRESSURE_PLATE.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_PRESSURE_PLATE.get(), BFBlocks.WALNUT_BUTTON.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_BUTTON.get(), BFBlocks.HOARY_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.HOARY_LOG.get(), BFBlocks.HOARY_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.HOARY_WOOD.get(), BFBlocks.STRIPPED_HOARY_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_HOARY_LOG.get(), BFBlocks.STRIPPED_HOARY_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_HOARY_WOOD.get(), BFBlocks.HOARY_PLANKS.get());
//        BUILDING_BLOCKS.put(BFBlocks.HOARY_PLANKS.get(), BFBlocks.HOARY_STAIRS.get());
//        BUILDING_BLOCKS.put(BFBlocks.HOARY_STAIRS.get(), BFBlocks.HOARY_SLAB.get());
//        BUILDING_BLOCKS.put(BFBlocks.HOARY_SLAB.get(), BFBlocks.HOARY_FENCE.get());
//        BUILDING_BLOCKS.put(BFBlocks.HOARY_FENCE.get(), BFBlocks.HOARY_FENCE_GATE.get());
//        BUILDING_BLOCKS.put(BFBlocks.HOARY_FENCE_GATE.get(), BFBlocks.HOARY_PICKETS.get());
//        BUILDING_BLOCKS.put(BFBlocks.HOARY_PICKETS.get(), BFBlocks.HOARY_DOOR.get());
//        BUILDING_BLOCKS.put(BFBlocks.HOARY_DOOR.get(), BFBlocks.HOARY_TRAPDOOR.get());
//        BUILDING_BLOCKS.put(BFBlocks.HOARY_TRAPDOOR.get(), BFBlocks.HOARY_PRESSURE_PLATE.get());
//        BUILDING_BLOCKS.put(BFBlocks.HOARY_PRESSURE_PLATE.get(), BFBlocks.HOARY_BUTTON.get());
//        BUILDING_BLOCKS.put(Items.CRIMSON_FENCE_GATE, BFBlocks.CRIMSON_PICKETS.get());
//        BUILDING_BLOCKS.put(Items.WARPED_FENCE_GATE, BFBlocks.WARPED_PICKETS.get());
//        BUILDING_BLOCKS.put(Items.WARPED_BUTTON, BFBlocks.APPLE_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.APPLE_LOG.get(), BFBlocks.APPLE_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.APPLE_WOOD.get(), BFBlocks.STRIPPED_APPLE_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_APPLE_LOG.get(), BFBlocks.STRIPPED_APPLE_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_APPLE_WOOD.get(), BFBlocks.ORANGE_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.ORANGE_LOG.get(), BFBlocks.ORANGE_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.ORANGE_WOOD.get(), BFBlocks.STRIPPED_ORANGE_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_ORANGE_LOG.get(), BFBlocks.STRIPPED_ORANGE_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_ORANGE_WOOD.get(), BFBlocks.LEMON_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.LEMON_LOG.get(), BFBlocks.LEMON_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.LEMON_WOOD.get(), BFBlocks.STRIPPED_LEMON_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_LEMON_LOG.get(), BFBlocks.STRIPPED_LEMON_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_LEMON_WOOD.get(), BFBlocks.PLUM_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.PLUM_LOG.get(), BFBlocks.PLUM_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.PLUM_WOOD.get(), BFBlocks.STRIPPED_PLUM_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_PLUM_LOG.get(), BFBlocks.STRIPPED_PLUM_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_PLUM_WOOD.get(), BFBlocks.PALM_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.PALM_LOG.get(), BFBlocks.PALM_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.PALM_WOOD.get(), BFBlocks.STRIPPED_PALM_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_PALM_LOG.get(), BFBlocks.STRIPPED_PALM_WOOD.get());
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_PALM_WOOD.get(), BFBlocks.GOLDEN_APPLE_LOG.get());
//        BUILDING_BLOCKS.put(BFBlocks.GOLDEN_APPLE_LOG.get(), BFBlocks.GOLDEN_APPLE_WOOD.get());
////        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_PLUM_WOOD, TrellisUtil.getTrellisFromVariant(ModTrellises.OAK).get());
////            TrellisVariant prevTrellis = ModTrellises.OAK;
////            for (TrellisVariant trellis : TrellisVariants.TrellisVariants) {
////                if (Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
////                    if (trellis == ModTrellises.OAK) {
////                        continue;
////                    }
////                    if (TrellisUtil.getTrellisFromVariant(trellis) != null) {
////                    BUILDING_BLOCKS.put(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(trellis).get());
////                        prevTrellis = trellis;
////                    }
////                }
////            }
//        BUILDING_BLOCKS.put(BFBlocks.STRIPPED_PLUM_WOOD.get(), BFBlocks.WALNUT_MULCH.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_MULCH.get(), BFBlocks.WALNUT_MULCH_BLOCK.get());
//        BUILDING_BLOCKS.put(BFBlocks.WALNUT_MULCH_BLOCK.get(), BFBlocks.PALM_MULCH.get());
//        BUILDING_BLOCKS.put(BFBlocks.PALM_MULCH.get(), BFBlocks.PALM_MULCH_BLOCK.get());
//        BUILDING_BLOCKS.put(Blocks.MUD_BRICK_WALL, BFBlocks.PACKED_COCONUT_COIR.get());
//        BUILDING_BLOCKS.put(BFBlocks.PACKED_COCONUT_COIR.get(), BFBlocks.COIR_CARPET.get());
//        BUILDING_BLOCKS.put(BFBlocks.COIR_CARPET.get(), BFBlocks.COIR_BRICKS.get());
//        BUILDING_BLOCKS.put(BFBlocks.COIR_BRICKS.get(), BFBlocks.COIR_BRICK_STAIRS.get());
//        BUILDING_BLOCKS.put(BFBlocks.COIR_BRICK_STAIRS.get(), BFBlocks.COIR_BRICK_SLAB.get());
//        BUILDING_BLOCKS.put(BFBlocks.COIR_BRICK_SLAB.get(), BFBlocks.COIR_BRICK_WALL.get());
//        BUILDING_BLOCKS.put(Items.DARK_PRISMARINE_SLAB, BFBlocks.PRISMARINE_BLOSSOM.get());
//        BUILDING_BLOCKS.put(BFBlocks.PRISMARINE_BLOSSOM.get(), BFBlocks.FELDSPAR_BLOCK.get());
//        BUILDING_BLOCKS.put(BFBlocks.FELDSPAR_BLOCK.get(), BFBlocks.CUT_FELDSPAR_BLOCK.get());
//        BUILDING_BLOCKS.put(BFBlocks.CUT_FELDSPAR_BLOCK.get(), BFBlocks.FELDSPAR_BRICKS.get());
//        BUILDING_BLOCKS.put(BFBlocks.FELDSPAR_BRICKS.get(), BFBlocks.FELDSPAR_BRICK_STAIRS.get());
//        BUILDING_BLOCKS.put(BFBlocks.FELDSPAR_BRICK_STAIRS.get(), BFBlocks.FELDSPAR_BRICK_SLAB.get());
//        BUILDING_BLOCKS.put(BFBlocks.FELDSPAR_BRICK_SLAB.get(), BFBlocks.FELDSPAR_BRICK_WALL.get());
//        BUILDING_BLOCKS.put(BFBlocks.FELDSPAR_BRICK_WALL.get(), BFBlocks.CERAMIC_CLAY_BLOCK.get());
//        BUILDING_BLOCKS.put(BFBlocks.CERAMIC_CLAY_BLOCK.get(), BFBlocks.CERAMIC_TILES.get());
//        BUILDING_BLOCKS.put(BFBlocks.CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_STAIRS.get());
//        BUILDING_BLOCKS.put(BFBlocks.CERAMIC_TILE_STAIRS.get(), BFBlocks.CERAMIC_TILE_SLAB.get());
//            //entries.addAfter(BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CERAMIC_TILE_WALL.get());
//            //entries.addAfter(BFBlocks.CERAMIC_TILE_WALL, BFBlocks.CRACKED_CERAMIC_TILES.get());
//        BUILDING_BLOCKS.put(BFBlocks.CERAMIC_TILE_SLAB.get(), BFBlocks.CRACKED_CERAMIC_TILES.get());
//        BUILDING_BLOCKS.put(BFBlocks.CRACKED_CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_PILLAR.get());
//        BUILDING_BLOCKS.put(BFBlocks.CERAMIC_TILE_PILLAR.get(), BFBlocks.CERAMIC_MOSAIC.get());
//        BUILDING_BLOCKS.put(BFBlocks.CERAMIC_MOSAIC.get(), BFBlocks.CERAMIC_MOSAIC_STAIRS.get());
//        BUILDING_BLOCKS.put(BFBlocks.CERAMIC_MOSAIC_STAIRS.get(), BFBlocks.CERAMIC_MOSAIC_SLAB.get());
//            //entries.addAfter(BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_MOSAIC_WALL.get());
//            //entries.addAfter(BFBlocks.CERAMIC_MOSAIC_WALL, BFBlocks.CERAMIC_DOOR.get());
//        BUILDING_BLOCKS.put(BFBlocks.CERAMIC_MOSAIC_SLAB.get(), BFBlocks.CERAMIC_DOOR.get());
//        BUILDING_BLOCKS.put(BFBlocks.CERAMIC_DOOR.get(), BFBlocks.CERAMIC_TRAPDOOR.get());
//        BUILDING_BLOCKS.put(BFBlocks.CERAMIC_TRAPDOOR.get(), BFBlocks.CERAMIC_PRESSURE_PLATE.get());
//        BUILDING_BLOCKS.put(BFBlocks.CERAMIC_PRESSURE_PLATE.get(), BFBlocks.CERAMIC_BUTTON.get());
//        BUILDING_BLOCKS.put(Blocks.IRON_BARS, BFBlocks.IRON_RAILING.get());
//
//        HLServices.REGISTRY.addItemsToItemGroup(
//                BuiltInRegistries.CREATIVE_MODE_TAB.get(ResourceLocation.fromNamespaceAndPath("minecraft", "building_blocks")),
//                BUILDING_BLOCKS
//        );
//
//
//        Map<ItemLike, ItemLike> NATURAL_BLOCKS = new HashMap<>();
//        NATURAL_BLOCKS.put(Items.GRASS_BLOCK, BFBlocks.GRASSY_DIRT.get());
//        NATURAL_BLOCKS.put(Items.CHERRY_LOG, BFBlocks.APPLE_LOG.get());
//        NATURAL_BLOCKS.put(BFBlocks.APPLE_LOG.get(), BFBlocks.ORANGE_LOG.get());
//        NATURAL_BLOCKS.put(BFBlocks.ORANGE_LOG.get(), BFBlocks.LEMON_LOG.get());
//        NATURAL_BLOCKS.put(BFBlocks.LEMON_LOG.get(), BFBlocks.PLUM_LOG.get());
//        NATURAL_BLOCKS.put(BFBlocks.PLUM_LOG.get(), BFBlocks.PALM_LOG.get());
//        NATURAL_BLOCKS.put(BFBlocks.PALM_LOG.get(), BFBlocks.PALM_CROWN.get());
//        NATURAL_BLOCKS.put(BFBlocks.PALM_CROWN.get(), BFBlocks.WALNUT_LOG.get());
//        NATURAL_BLOCKS.put(BFBlocks.WALNUT_LOG.get(), BFBlocks.HOARY_LOG.get());
//        NATURAL_BLOCKS.put(Items.FLOWERING_AZALEA_LEAVES, BFBlocks.APPLE_LEAVES.get());
//        NATURAL_BLOCKS.put(BFBlocks.APPLE_LEAVES.get(), BFBlocks.FLOWERING_APPLE_LEAVES.get());
//        NATURAL_BLOCKS.put(BFBlocks.FLOWERING_APPLE_LEAVES.get(), BFBlocks.ORANGE_LEAVES.get());
//        NATURAL_BLOCKS.put(BFBlocks.ORANGE_LEAVES.get(), BFBlocks.FLOWERING_ORANGE_LEAVES.get());
//        NATURAL_BLOCKS.put( BFBlocks.FLOWERING_ORANGE_LEAVES.get(), BFBlocks.LEMON_LEAVES.get());
//        NATURAL_BLOCKS.put(BFBlocks.LEMON_LEAVES.get(), BFBlocks.FLOWERING_LEMON_LEAVES.get());
//        NATURAL_BLOCKS.put(BFBlocks.FLOWERING_LEMON_LEAVES.get(), BFBlocks.PLUM_LEAVES.get());
//        NATURAL_BLOCKS.put(BFBlocks.PLUM_LEAVES.get(), BFBlocks.FLOWERING_PLUM_LEAVES.get());
//        NATURAL_BLOCKS.put(BFBlocks.FLOWERING_PLUM_LEAVES.get(), BFBlocks.GOLDEN_APPLE_LEAVES.get());
//        NATURAL_BLOCKS.put(BFBlocks.GOLDEN_APPLE_LEAVES.get(), BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get());
//        NATURAL_BLOCKS.put(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get(), BFBlocks.WALNUT_LEAVES.get());
//        NATURAL_BLOCKS.put(BFBlocks.WALNUT_LEAVES.get(), BFBlocks.HOARY_LEAVES.get());
//        NATURAL_BLOCKS.put(BFBlocks.HOARY_LEAVES.get(), BFItems.PALM_FROND.get());
//        NATURAL_BLOCKS.put(Items.CHERRY_SAPLING, BFBlocks.APPLE_SAPLING.get());
//        NATURAL_BLOCKS.put(BFBlocks.APPLE_SAPLING.get(), BFBlocks.ORANGE_SAPLING.get());
//        NATURAL_BLOCKS.put(BFBlocks.ORANGE_SAPLING.get(), BFBlocks.LEMON_SAPLING.get());
//        NATURAL_BLOCKS.put(BFBlocks.LEMON_SAPLING.get(), BFBlocks.PLUM_SAPLING.get());
//        NATURAL_BLOCKS.put(BFBlocks.PLUM_SAPLING.get(), BFBlocks.HOARY_APPLE_SAPLING.get());
//        NATURAL_BLOCKS.put(BFBlocks.HOARY_APPLE_SAPLING.get(), BFBlocks.WALNUT_SAPLING.get());
//        NATURAL_BLOCKS.put(Blocks.FLOWERING_AZALEA, BFItems.COCONUT.get());
//        NATURAL_BLOCKS.put(Items.SNIFFER_EGG, BFBlocks.WILD_WHEAT.get());
//        NATURAL_BLOCKS.put(BFBlocks.WILD_WHEAT.get(), BFBlocks.WILD_CARROTS.get());
//        NATURAL_BLOCKS.put(BFBlocks.WILD_CARROTS.get(), BFBlocks.WILD_POTATOES.get());
//        NATURAL_BLOCKS.put(BFBlocks.WILD_POTATOES.get(), BFBlocks.WILD_BEETROOTS.get());
//        NATURAL_BLOCKS.put(BFBlocks.WILD_BEETROOTS.get(), BFBlocks.WILD_LEEKS.get());
//        NATURAL_BLOCKS.put(BFBlocks.WILD_LEEKS.get(), BFBlocks.WILD_MAIZE.get());
//        NATURAL_BLOCKS.put(BFBlocks.WILD_MAIZE.get(), BFBlocks.WILD_PASSION_FRUIT_VINE.get());
//        NATURAL_BLOCKS.put(BFBlocks.WILD_PASSION_FRUIT_VINE.get(), BFBlocks.WILD_ELDERBERRY_VINE.get());
//        NATURAL_BLOCKS.put(BFBlocks.WILD_ELDERBERRY_VINE.get(), BFItems.GRASS_SEEDS.get());
//        NATURAL_BLOCKS.put(BFItems.GRASS_SEEDS.get(), BFItems.SWEET_BERRY_PIPS.get());
//        NATURAL_BLOCKS.put(Items.KELP, BFBlocks.SPONGEKIN.get());
//        NATURAL_BLOCKS.put(BFBlocks.SPONGEKIN.get(), BFBlocks.PRISMARINE_BLOSSOM.get());
//        NATURAL_BLOCKS.put(Items.LILY_OF_THE_VALLEY, BFBlocks.CHAMOMILE_FLOWERS.get());
//        NATURAL_BLOCKS.put(BFBlocks.CHAMOMILE_FLOWERS.get(), BFBlocks.HONEYSUCKLE.get());
//        NATURAL_BLOCKS.put(BFBlocks.HONEYSUCKLE.get(), BFBlocks.VIOLET_BELLFLOWER.get());
//        NATURAL_BLOCKS.put(Items.BEETROOT_SEEDS, BFItems.MAIZE_SEEDS.get());
//        NATURAL_BLOCKS.put(BFItems.MAIZE_SEEDS.get(), BFItems.LEEK_SEEDS.get());
//        NATURAL_BLOCKS.put(BFItems.LEEK_SEEDS.get(), BFItems.TEA_BERRIES.get());
//        NATURAL_BLOCKS.put(BFItems.TEA_BERRIES.get(), BFItems.SPONGEKIN_SEEDS.get());
//        NATURAL_BLOCKS.put(Items.PITCHER_POD, BFItems.LAPISBERRY_SEEDS.get());
//        NATURAL_BLOCKS.put(BFItems.LAPISBERRY_SEEDS.get(), BFItems.HOARY_SEEDS.get());
//
//        HLServices.REGISTRY.addItemsToItemGroup(
//                BuiltInRegistries.CREATIVE_MODE_TAB.get(ResourceLocation.fromNamespaceAndPath("minecraft", "natural_blocks")),
//                NATURAL_BLOCKS
//        );
//
//
//        Map<ItemLike, ItemLike> FUNCTIONAL_BLOCKS = new HashMap<>();
//        FUNCTIONAL_BLOCKS.put(Items.LANTERN, BFBlocks.FELDSPAR_LANTERN.get());
//        FUNCTIONAL_BLOCKS.put(Items.GRINDSTONE, BFBlocks.GRISTMILL.get());
//        FUNCTIONAL_BLOCKS.put(Items.SOUL_CAMPFIRE, BFBlocks.GREEN_TEA_CANDLE.get());
//        FUNCTIONAL_BLOCKS.put(BFBlocks.GREEN_TEA_CANDLE.get(), BFBlocks.BLACK_TEA_CANDLE.get());
//        FUNCTIONAL_BLOCKS.put(BFBlocks.BLACK_TEA_CANDLE.get(), BFBlocks.CHAMOMILE_CANDLE.get());
//        FUNCTIONAL_BLOCKS.put(BFBlocks.CHAMOMILE_CANDLE.get(), BFBlocks.HONEYSUCKLE_CANDLE.get());
//        FUNCTIONAL_BLOCKS.put(BFBlocks.HONEYSUCKLE_CANDLE.get(), BFBlocks.BELLFLOWER_CANDLE.get());
//        FUNCTIONAL_BLOCKS.put(BFBlocks.BELLFLOWER_CANDLE.get(), BFBlocks.TORCHFLOWER_CANDLE.get());
//        FUNCTIONAL_BLOCKS.put(BFBlocks.TORCHFLOWER_CANDLE.get(), BFBlocks.WALNUT_CANDLE.get());
//        FUNCTIONAL_BLOCKS.put(BFBlocks.WALNUT_CANDLE.get(), BFBlocks.FERMENTATION_VESSEL.get());
//        FUNCTIONAL_BLOCKS.put(BFBlocks.FERMENTATION_VESSEL.get(), BFBlocks.COCONUT_CANDLE.get());
//        FUNCTIONAL_BLOCKS.put(BFBlocks.COCONUT_CANDLE.get(), BFBlocks.GOLDEN_APPLE_SAPLING.get());
////        FUNCTIONAL_BLOCKS.put(Blocks.COMPOSTER, TrellisUtil.getTrellisFromVariant(BFTrellises.OAK));
////            TrellisVariant prevTrellis = BFTrellises.OAK;
////            for (TrellisVariant trellis : TrellisUtil.TrellisVariants) {
////                if (Objects.equals(trellis.getModId(), BountifulFares.MOD_ID)) {
////                    if (trellis == BFTrellises.OAK) {
////                        continue;
////                    }
////                    if (TrellisUtil.getTrellisFromVariant(trellis) != null) {
////                        entries.addAfter(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(trellis));
////                        prevTrellis = trellis;
////                    }
////                }
////            }
////            if (BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(BFTrellises.WINTERGREEN));
////                prevTrellis = BFTrellises.WINTERGREEN;
////            }
//
//
////            if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.REDWOOD));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.REDWOOD), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SAXAUL));
////                prevTrellis = NaturesSpiritBlocks.SAXAUL;
////            }
////            if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(ExcessiveBuildingBlocks.ANCIENT));
////                prevTrellis = ExcessiveBuildingBlocks.ANCIENT;
////            }
////            if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(SpawnBlocks.ROTTEN));
////                prevTrellis = SpawnBlocks.ROTTEN;
////            }
//        FUNCTIONAL_BLOCKS.put(Items.TINTED_GLASS, BFBlocks.TINGED_GLASS.get());
//        FUNCTIONAL_BLOCKS.put(Items.BAMBOO_HANGING_SIGN, BFItems.WALNUT_SIGN.get());
//        FUNCTIONAL_BLOCKS.put(BFItems.WALNUT_SIGN.get(), BFItems.WALNUT_HANGING_SIGN.get());
//        FUNCTIONAL_BLOCKS.put(BFItems.WALNUT_HANGING_SIGN.get(), BFItems.HOARY_SIGN.get());
//        FUNCTIONAL_BLOCKS.put(BFItems.HOARY_SIGN.get(), BFItems.HOARY_HANGING_SIGN.get());
//
//
//        HLServices.REGISTRY.addItemsToItemGroup(
//                BuiltInRegistries.CREATIVE_MODE_TAB.get(ResourceLocation.fromNamespaceAndPath("minecraft", "functional_blocks")),
//                FUNCTIONAL_BLOCKS
//        );
//
//        Map<ItemLike, ItemLike> REDSTONE_BLOCKS = new HashMap<>();
//        REDSTONE_BLOCKS.put(Items.LEVER, BFBlocks.CERAMIC_LEVER.get());
//        REDSTONE_BLOCKS.put(Items.STONE_BUTTON, BFBlocks.CERAMIC_BUTTON.get());
//        REDSTONE_BLOCKS.put(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, BFBlocks.CERAMIC_PRESSURE_PLATE.get());
//        REDSTONE_BLOCKS.put(Items.WHITE_WOOL, BFBlocks.CERAMIC_TILES.get());
//
//        HLServices.REGISTRY.addItemsToItemGroup(
//                BuiltInRegistries.CREATIVE_MODE_TAB.get(ResourceLocation.fromNamespaceAndPath("minecraft", "redstone_blocks")),
//                REDSTONE_BLOCKS
//        );
//
//        Map<ItemLike, ItemLike> TOOLS_AND_UTILITIES = new HashMap<>();
//        TOOLS_AND_UTILITIES.put(Items.LEAD, BFItems.SUN_HAT.get());
//        TOOLS_AND_UTILITIES.put(Items.BRUSH, BFItems.ARTISAN_BRUSH.get());
////        TOOLS_AND_UTILITIES.put(Items.BAMBOO_CHEST_RAFT, BFItems.WALNUT_BOAT);
////        TOOLS_AND_UTILITIES.put(BFItems.WALNUT_BOAT, BFItems.WALNUT_CHEST_BOAT);
////        TOOLS_AND_UTILITIES.put(BFItems.WALNUT_CHEST_BOAT, BFItems.HOARY_BOAT);
////        TOOLS_AND_UTILITIES.put(BFItems.HOARY_BOAT, BFItems.HOARY_CHEST_BOAT);
//
//        HLServices.REGISTRY.addItemsToItemGroup(
//                BuiltInRegistries.CREATIVE_MODE_TAB.get(ResourceLocation.fromNamespaceAndPath("minecraft", "tools_and_utilities")),
//                TOOLS_AND_UTILITIES
//        );
//
//        Map<ItemLike, ItemLike> COMBAT = new HashMap<>();
//        COMBAT.put(Items.EGG, BFItems.FLOUR.get());
//
//        HLServices.REGISTRY.addItemsToItemGroup(
//                BuiltInRegistries.CREATIVE_MODE_TAB.get(ResourceLocation.fromNamespaceAndPath("minecraft", "combat")),
//                COMBAT
//        );
//
//        Map<ItemLike, ItemLike> FOOD_AND_DRINKS = new HashMap<>();
//        FOOD_AND_DRINKS.put(Items.APPLE, BFItems.APPLE_COMPOTE_JAR.get());
//        FOOD_AND_DRINKS.put(BFItems.APPLE_COMPOTE_JAR.get(), BFItems.APPLE_CIDER_JAR.get());
//        FOOD_AND_DRINKS.put(BFItems.APPLE_CIDER_JAR.get(), BFBlocks.APPLE_BLOCK.get());
//        FOOD_AND_DRINKS.put(BFBlocks.APPLE_BLOCK.get(), BFItems.ORANGE.get());
//        FOOD_AND_DRINKS.put(BFItems.ORANGE.get(), BFItems.ORANGE_COMPOTE_JAR.get());
//        FOOD_AND_DRINKS.put(BFItems.ORANGE_COMPOTE_JAR.get(), BFBlocks.ORANGE_BLOCK.get());
//        FOOD_AND_DRINKS.put(BFBlocks.ORANGE_BLOCK.get(), BFItems.LEMON.get());
//        FOOD_AND_DRINKS.put(BFItems.LEMON.get(), BFItems.LEMON_COMPOTE_JAR.get());
//        FOOD_AND_DRINKS.put(BFItems.LEMON_COMPOTE_JAR.get(), BFBlocks.LEMON_BLOCK.get());
//        FOOD_AND_DRINKS.put(BFBlocks.LEMON_BLOCK.get(), BFItems.PLUM.get());
//        FOOD_AND_DRINKS.put(BFItems.PLUM.get(), BFItems.PLUM_COMPOTE_JAR.get());
//        FOOD_AND_DRINKS.put(BFItems.PLUM_COMPOTE_JAR.get(), BFItems.PLUM_CIDER_JAR.get());
//        FOOD_AND_DRINKS.put(BFItems.PLUM_CIDER_JAR.get(), BFBlocks.PLUM_BLOCK.get());
//        FOOD_AND_DRINKS.put(BFBlocks.PLUM_BLOCK.get(), BFItems.HOARY_APPLE.get());
//        FOOD_AND_DRINKS.put(BFItems.HOARY_APPLE.get(), BFItems.STUFFED_HOARY_APPLE.get());
//        FOOD_AND_DRINKS.put(BFItems.STUFFED_HOARY_APPLE.get(), BFItems.HOARY_COMPOTE_JAR.get());
//        FOOD_AND_DRINKS.put(BFItems.HOARY_COMPOTE_JAR.get(), BFItems.HOARY_CIDER_JAR.get());
//        FOOD_AND_DRINKS.put(BFItems.HOARY_CIDER_JAR.get(), BFBlocks.HOARY_APPLE_BLOCK.get());
//        FOOD_AND_DRINKS.put(BFBlocks.HOARY_APPLE_BLOCK.get(), BFItems.COCONUT_HALF.get());
//        FOOD_AND_DRINKS.put(Items.ENCHANTED_GOLDEN_APPLE, BFBlocks.GOLDEN_APPLE_BLOCK.get());
//        FOOD_AND_DRINKS.put(Items.MELON_SLICE, BFItems.SPONGEKIN_SLICE.get());
//        FOOD_AND_DRINKS.put(BFItems.SPONGEKIN_SLICE.get(), BFItems.PICKLED_SPONGEKIN.get());
//        FOOD_AND_DRINKS.put(Items.SWEET_BERRIES, BFItems.PASSION_FRUIT.get());
//        FOOD_AND_DRINKS.put(BFItems.PASSION_FRUIT.get(), BFItems.ELDERBERRIES.get());
//        FOOD_AND_DRINKS.put(BFItems.ELDERBERRIES.get(), BFItems.ELDERBERRY_WINE_BOTTLE.get());
//        FOOD_AND_DRINKS.put(Items.GLOW_BERRIES, BFItems.LAPISBERRIES.get());
//        FOOD_AND_DRINKS.put(BFItems.LAPISBERRIES.get(), BFItems.LAPISBERRY_WINE_BOTTLE.get());
//        FOOD_AND_DRINKS.put(Items.MILK_BUCKET, BFItems.COCONUT_MILK_BOTTLE.get());
//        FOOD_AND_DRINKS.put(BFItems.COCONUT_MILK_BOTTLE.get(), BFItems.GREEN_TEA_BOTTLE.get());
//        FOOD_AND_DRINKS.put(BFItems.GREEN_TEA_BOTTLE.get(), BFItems.BLACK_TEA_BOTTLE.get());
//        FOOD_AND_DRINKS.put(BFItems.BLACK_TEA_BOTTLE.get(), BFItems.CHAMOMILE_TEA_BOTTLE.get());
//        FOOD_AND_DRINKS.put(BFItems.CHAMOMILE_TEA_BOTTLE.get(), BFItems.HONEYSUCKLE_TEA_BOTTLE.get());
//        FOOD_AND_DRINKS.put(BFItems.HONEYSUCKLE_TEA_BOTTLE.get(), BFItems.BELLFLOWER_TEA_BOTTLE.get());
//        FOOD_AND_DRINKS.put(BFItems.BELLFLOWER_TEA_BOTTLE.get(), BFItems.TORCHFLOWER_TEA_BOTTLE.get());
//        FOOD_AND_DRINKS.put(Items.HONEY_BOTTLE, BFItems.MEAD_BOTTLE.get());
//        FOOD_AND_DRINKS.put(Items.BAKED_POTATO, BFItems.MUSHROOM_STUFFED_POTATO.get());
//        FOOD_AND_DRINKS.put(BFItems.MUSHROOM_STUFFED_POTATO.get(), BFItems.BERRY_STUFFED_POTATO.get());
//        FOOD_AND_DRINKS.put(BFItems.BERRY_STUFFED_POTATO.get(), BFItems.MAIZE_STUFFED_POTATO.get());
//        FOOD_AND_DRINKS.put(Items.BEETROOT, BFItems.MAIZE.get());
//        FOOD_AND_DRINKS.put(BFItems.MAIZE.get(), BFItems.LEEK.get());
//        FOOD_AND_DRINKS.put(BFItems.LEEK.get(), BFItems.WALNUT.get());
//        FOOD_AND_DRINKS.put(BFItems.WALNUT.get(), BFItems.POPPED_MAIZE.get());
//        FOOD_AND_DRINKS.put(Items.BREAD, BFItems.MAIZE_BREAD.get());
//        FOOD_AND_DRINKS.put(BFItems.MAIZE_BREAD.get(), BFBlocks.ARTISAN_BREAD.get());
//        FOOD_AND_DRINKS.put(Items.COOKIE, BFItems.WALNUT_COOKIE.get());
//        FOOD_AND_DRINKS.put(BFItems.WALNUT_COOKIE.get(), BFItems.ARTISAN_COOKIE.get());
//        FOOD_AND_DRINKS.put(BFItems.ARTISAN_COOKIE.get(), BFBlocks.PASSION_FRUIT_TART.get());
//        FOOD_AND_DRINKS.put(BFBlocks.PASSION_FRUIT_TART.get(), BFBlocks.ELDERBERRY_TART.get());
//        FOOD_AND_DRINKS.put(BFBlocks.ELDERBERRY_TART.get(), BFBlocks.GLOW_BERRY_TART.get());
//        FOOD_AND_DRINKS.put(BFBlocks.GLOW_BERRY_TART.get(), BFBlocks.SWEET_BERRY_TART.get());
//        FOOD_AND_DRINKS.put(BFBlocks.SWEET_BERRY_TART.get(), BFBlocks.LAPISBERRY_TART.get());
//        FOOD_AND_DRINKS.put(Items.CAKE, BFBlocks.COCOA_CAKE.get());
//        FOOD_AND_DRINKS.put(BFBlocks.COCOA_CAKE.get(), BFBlocks.COCONUT_CAKE.get());
//        FOOD_AND_DRINKS.put(Items.PUMPKIN_PIE, BFBlocks.MELON_PIE.get());
//        FOOD_AND_DRINKS.put(BFBlocks.MELON_PIE.get(), BFBlocks.APPLE_PIE.get());
//        FOOD_AND_DRINKS.put(BFBlocks.APPLE_PIE.get(), BFBlocks.ORANGE_PIE.get());
//        FOOD_AND_DRINKS.put(BFBlocks.ORANGE_PIE.get(), BFBlocks.LEMON_PIE.get());
//        FOOD_AND_DRINKS.put(BFBlocks.LEMON_PIE.get(), BFBlocks.PLUM_PIE.get());
//        FOOD_AND_DRINKS.put(BFBlocks.PLUM_PIE.get(), BFBlocks.HOARY_PIE.get());
//        FOOD_AND_DRINKS.put(Items.SPIDER_EYE, BFItems.CITRUS_ESSENCE.get());
//        FOOD_AND_DRINKS.put(BFItems.CITRUS_ESSENCE.get(), BFItems.CANDY.get());
//        FOOD_AND_DRINKS.put(BFItems.CANDY.get(), BFItems.PIQUANT_CANDY.get());
//        FOOD_AND_DRINKS.put(BFItems.PIQUANT_CANDY.get(), BFItems.SOUR_CANDY.get());
//        FOOD_AND_DRINKS.put(BFItems.SOUR_CANDY.get(), BFItems.BITTER_CANDY.get());
//        FOOD_AND_DRINKS.put(BFItems.BITTER_CANDY.get(), BFItems.STRANGE_CANDY.get());
//        FOOD_AND_DRINKS.put(BFItems.STRANGE_CANDY.get(), BFItems.CANDIED_APPLE.get());
//        FOOD_AND_DRINKS.put(BFItems.CANDIED_APPLE.get(), BFItems.CANDIED_PLUM.get());
//        FOOD_AND_DRINKS.put(BFItems.CANDIED_PLUM.get(), BFItems.CANDIED_ORANGE.get());
//        FOOD_AND_DRINKS.put(BFItems.CANDIED_ORANGE.get(), BFItems.CANDIED_LEMON.get());
//        FOOD_AND_DRINKS.put(BFItems.CANDIED_LEMON.get(), BFItems.FOREST_MEDLEY.get());
//        FOOD_AND_DRINKS.put(BFItems.FOREST_MEDLEY.get(), BFItems.ARID_MEDLEY.get());
//        FOOD_AND_DRINKS.put(BFItems.ARID_MEDLEY.get(), BFItems.MEADOW_MEDLEY.get());
//        FOOD_AND_DRINKS.put(BFItems.MEADOW_MEDLEY.get(), BFItems.MIRE_MEDLEY.get());
//        FOOD_AND_DRINKS.put(BFItems.MIRE_MEDLEY.get(), BFItems.COASTAL_MEDLEY.get());
//        FOOD_AND_DRINKS.put(BFItems.COASTAL_MEDLEY.get(), BFItems.TROPICAL_MEDLEY.get());
//        FOOD_AND_DRINKS.put(BFItems.TROPICAL_MEDLEY.get(), BFItems.SEA_SALAD.get());
//        FOOD_AND_DRINKS.put(Items.RABBIT_STEW, BFItems.LEEK_STEW.get());
//        FOOD_AND_DRINKS.put(BFItems.LEEK_STEW.get(), BFItems.FISH_STEW.get());
//        FOOD_AND_DRINKS.put(BFItems.FISH_STEW.get(), BFItems.APPLE_STEW.get());
//        FOOD_AND_DRINKS.put(BFItems.APPLE_STEW.get(), BFItems.COCONUT_STEW.get());
//        FOOD_AND_DRINKS.put(BFItems.COCONUT_STEW.get(), BFItems.STONE_STEW.get());
//        FOOD_AND_DRINKS.put(BFItems.STONE_STEW.get(), BFItems.BOUNTIFUL_STEW.get());
//        FOOD_AND_DRINKS.put(BFItems.BOUNTIFUL_STEW.get(), BFItems.COCONUT_CRUSTED_COD.get());
//        FOOD_AND_DRINKS.put(BFItems.COCONUT_CRUSTED_COD.get(), BFItems.PASSION_GLAZED_SALMON.get());
//        FOOD_AND_DRINKS.put(BFItems.PASSION_GLAZED_SALMON.get(), BFItems.CRUSTED_BEEF.get());
//        FOOD_AND_DRINKS.put(BFItems.CRUSTED_BEEF.get(), BFItems.CRIMSON_CHOW.get());
//        FOOD_AND_DRINKS.put(BFItems.CRIMSON_CHOW.get(), BFItems.WARPED_CHOW.get());
//        FOOD_AND_DRINKS.put(BFItems.WARPED_CHOW.get(), BFItems.CUSTARD.get());
//        FOOD_AND_DRINKS.put(BFItems.CUSTARD.get(), BFItems.PIQUANT_CUSTARD.get());
//        FOOD_AND_DRINKS.put(BFItems.PIQUANT_CUSTARD.get(), BFItems.PASSION_CUSTARD.get());
//        FOOD_AND_DRINKS.put(BFItems.PASSION_CUSTARD.get(), BFItems.COCOA_CUSTARD.get());
//        FOOD_AND_DRINKS.put(BFItems.COCOA_CUSTARD.get(), BFItems.ANCIENT_CUSTARD.get());
//
//        HLServices.REGISTRY.addItemsToItemGroup(
//                BuiltInRegistries.CREATIVE_MODE_TAB.get(ResourceLocation.fromNamespaceAndPath("minecraft", "food_and_drinks")),
//                FOOD_AND_DRINKS
//        );
//
//        Map<ItemLike, ItemLike> INGREDIENTS = new HashMap<>();
//        INGREDIENTS.put(Items.WHEAT, BFItems.MAIZE.get());
//        INGREDIENTS.put(BFItems.MAIZE.get(), BFItems.FLOUR.get());
//        INGREDIENTS.put(Items.SLIME_BALL, BFItems.FELDSPAR.get());
//        INGREDIENTS.put(BFItems.FELDSPAR.get(), BFItems.CERAMIC_CLAY.get());
//        INGREDIENTS.put(BFItems.CERAMIC_CLAY.get(), BFItems.CERAMIC_TILE.get());
//        INGREDIENTS.put(Items.BOWL, BFBlocks.CERAMIC_DISH.get());
//        INGREDIENTS.put(BFBlocks.CERAMIC_DISH.get(), BFItems.JAR.get());
//        INGREDIENTS.put(Items.FIREWORK_STAR, BFItems.COCONUT.get());
//        INGREDIENTS.put(BFItems.COCONUT.get(), BFItems.COCONUT_HALF.get());
//        INGREDIENTS.put(BFItems.COCONUT_HALF.get(), BFItems.COCONUT_COIR.get());
//        INGREDIENTS.put(BFItems.COCONUT_COIR.get(), BFItems.TEA_LEAVES.get());
//        INGREDIENTS.put(BFItems.TEA_LEAVES.get(), BFItems.DRIED_TEA_LEAVES.get());
//        INGREDIENTS.put(BFItems.DRIED_TEA_LEAVES.get(), BFItems.GREEN_TEA_BLEND.get());
//        INGREDIENTS.put(BFItems.GREEN_TEA_BLEND.get(), BFItems.BLACK_TEA_BLEND.get());
//        INGREDIENTS.put(BFItems.BLACK_TEA_BLEND.get(), BFItems.CHAMOMILE_TEA_BLEND.get());
//        INGREDIENTS.put(BFItems.CHAMOMILE_TEA_BLEND.get(), BFItems.HONEYSUCKLE_TEA_BLEND.get());
//        INGREDIENTS.put(BFItems.HONEYSUCKLE_TEA_BLEND.get(), BFItems.BELLFLOWER_TEA_BLEND.get());
//        INGREDIENTS.put(BFItems.BELLFLOWER_TEA_BLEND.get(), BFItems.TORCHFLOWER_TEA_BLEND.get());
//
//        HLServices.REGISTRY.addItemsToItemGroup(
//                BuiltInRegistries.CREATIVE_MODE_TAB.get(ResourceLocation.fromNamespaceAndPath("minecraft", "ingredients")),
//                INGREDIENTS
//        );
//
//        Map<ItemLike, ItemLike> COLORED_BLOCKS = new HashMap<>();
//        COLORED_BLOCKS.put(Items.PINK_GLAZED_TERRACOTTA, BFBlocks.CERAMIC_TILES.get());
//        COLORED_BLOCKS.put(BFBlocks.CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_STAIRS.get());
//        COLORED_BLOCKS.put(BFBlocks.CERAMIC_TILE_STAIRS.get(), BFBlocks.CERAMIC_TILE_SLAB.get());
//            //entries.addAfter(BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CERAMIC_TILE_WALL.get());
//            //entries.addAfter(BFBlocks.CERAMIC_TILE_WALL, BFBlocks.CRACKED_CERAMIC_TILES.get());
//        COLORED_BLOCKS.put(BFBlocks.CERAMIC_TILE_SLAB.get(), BFBlocks.CRACKED_CERAMIC_TILES.get());
//        COLORED_BLOCKS.put(BFBlocks.CRACKED_CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_PILLAR.get());
//        COLORED_BLOCKS.put(BFBlocks.CERAMIC_TILE_PILLAR.get(), BFBlocks.CERAMIC_MOSAIC.get());
//        COLORED_BLOCKS.put(BFBlocks.CERAMIC_MOSAIC.get(), BFBlocks.CERAMIC_MOSAIC_STAIRS.get());
//        COLORED_BLOCKS.put(BFBlocks.CERAMIC_MOSAIC_STAIRS.get(), BFBlocks.CERAMIC_MOSAIC_SLAB.get());
//            //entries.addAfter(BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_MOSAIC_WALL.get());
//        COLORED_BLOCKS.put(Items.PINK_BANNER, BFBlocks.WHITE_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.WHITE_JACK_O_STRAW.get(), BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get(), BFBlocks.GRAY_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.GRAY_JACK_O_STRAW.get(), BFBlocks.BLACK_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.BLACK_JACK_O_STRAW.get(), BFBlocks.BROWN_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.BROWN_JACK_O_STRAW.get(), BFBlocks.RED_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.RED_JACK_O_STRAW.get(), BFBlocks.ORANGE_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.ORANGE_JACK_O_STRAW.get(), BFBlocks.YELLOW_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.YELLOW_JACK_O_STRAW.get(), BFBlocks.LIME_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.LIME_JACK_O_STRAW.get(), BFBlocks.GREEN_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.GREEN_JACK_O_STRAW.get(), BFBlocks.CYAN_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.CYAN_JACK_O_STRAW.get(), BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get(), BFBlocks.BLUE_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.BLUE_JACK_O_STRAW.get(), BFBlocks.PURPLE_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.PURPLE_JACK_O_STRAW.get(), BFBlocks.MAGENTA_JACK_O_STRAW.get());
//        COLORED_BLOCKS.put(BFBlocks.MAGENTA_JACK_O_STRAW.get(), BFBlocks.PINK_JACK_O_STRAW.get());
//
//        HLServices.REGISTRY.addItemsToItemGroup(
//                BuiltInRegistries.CREATIVE_MODE_TAB.get(ResourceLocation.fromNamespaceAndPath("minecraft", "colored_blocks")),
//                COLORED_BLOCKS
//        );
//
//        Map<ItemLike, ItemLike> OP_BLOCKS = new HashMap<>();
//        OP_BLOCKS.put(Blocks.BARRIER, BFBlocks.SOLID_CERAMIC.get());
//
//        HLServices.REGISTRY.addItemsToItemGroup(
//                BuiltInRegistries.CREATIVE_MODE_TAB.get(ResourceLocation.fromNamespaceAndPath("minecraft", "op_blocks")),
//                OP_BLOCKS
//        );
//
////        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
////        COLORED_BLOCKS.put(BFBlocks.BLACK_JACK_O_STRAW, MintBlocks.ACORN_JACK_O_STRAW);
////        COLORED_BLOCKS.put(BFBlocks.BROWN_JACK_O_STRAW,MintBlocks.MAROON_JACK_O_STRAW);
////            entries.addAfter(BFBlocks.RED_JACK_O_STRAW,MintBlocks.PEACH_JACK_O_STRAW);
////            entries.addAfter(MintBlocks.PEACH_JACK_O_STRAW,MintBlocks.VERMILION_JACK_O_STRAW);
////            entries.addAfter(BFBlocks.ORANGE_JACK_O_STRAW,MintBlocks.AMBER_JACK_O_STRAW);
////            entries.addAfter(BFBlocks.YELLOW_JACK_O_STRAW,MintBlocks.BANANA_JACK_O_STRAW);
////            entries.addAfter(MintBlocks.BANANA_JACK_O_STRAW,MintBlocks.ARTICHOKE_JACK_O_STRAW);
////            entries.addAfter(MintBlocks.ARTICHOKE_JACK_O_STRAW,MintBlocks.MOLD_JACK_O_STRAW);
////            entries.addAfter(BFBlocks.LIME_JACK_O_STRAW,MintBlocks.SAGE_JACK_O_STRAW);
////            entries.addAfter(MintBlocks.SAGE_JACK_O_STRAW,MintBlocks.SAP_JACK_O_STRAW);
////            entries.addAfter(BFBlocks.GREEN_JACK_O_STRAW,MintBlocks.SHAMROCK_JACK_O_STRAW);
////            entries.addAfter(MintBlocks.SHAMROCK_JACK_O_STRAW,MintBlocks.MINT_JACK_O_STRAW);
////            entries.addAfter(BFBlocks.CYAN_JACK_O_STRAW,MintBlocks.CERULEAN_JACK_O_STRAW);
////            entries.addAfter(BFBlocks.LIGHT_BLUE_JACK_O_STRAW,MintBlocks.NAVY_JACK_O_STRAW);
////            entries.addAfter(BFBlocks.BLUE_JACK_O_STRAW,MintBlocks.PERIWINKLE_JACK_O_STRAW);
////            entries.addAfter(MintBlocks.PERIWINKLE_JACK_O_STRAW,MintBlocks.GRAPE_JACK_O_STRAW);
////            entries.addAfter(BFBlocks.PURPLE_JACK_O_STRAW,MintBlocks.INDIGO_JACK_O_STRAW);
////            entries.addAfter(BFBlocks.MAGENTA_JACK_O_STRAW,MintBlocks.MAUVE_JACK_O_STRAW);
////            entries.addAfter(MintBlocks.MAUVE_JACK_O_STRAW,MintBlocks.VELVET_JACK_O_STRAW);
////            entries.addAfter(MintBlocks.VELVET_JACK_O_STRAW,MintBlocks.FUCHSIA_JACK_O_STRAW);
////        });
//
////        if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
////            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "tab"))).register(entries -> {
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "redwood_fence")), NaturesSpiritBlocks.REDWOOD_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "redwood_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.REDWOOD));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "sugi_fence")), NaturesSpiritBlocks.SUGI_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "sugi_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "wisteria_fence")), NaturesSpiritBlocks.WISTERIA_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "wisteria_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "fir_fence")), NaturesSpiritBlocks.FIR_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "fir_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "willow_fence")), NaturesSpiritBlocks.WILLOW_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "willow_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "aspen_fence")), NaturesSpiritBlocks.ASPEN_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "aspen_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "maple_fence")), NaturesSpiritBlocks.MAPLE_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "maple_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "cypress_fence")), NaturesSpiritBlocks.CYPRESS_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "cypress_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "olive_fence")), NaturesSpiritBlocks.OLIVE_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "olive_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "joshua_fence")), NaturesSpiritBlocks.JOSHUA_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "joshua_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "ghaf_fence")), NaturesSpiritBlocks.GHAF_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "ghaf_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "palo_verde_fence")), NaturesSpiritBlocks.PALO_VERDE_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "palo_verde_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut_fence")), NaturesSpiritBlocks.COCONUT_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "cedar_fence")), NaturesSpiritBlocks.CEDAR_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "cedar_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "larch_fence")), NaturesSpiritBlocks.LARCH_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "larch_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "mahogany_fence")), NaturesSpiritBlocks.MAHOGANY_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "mahogany_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY));
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "saxaul_fence")), NaturesSpiritBlocks.SAXAUL_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "saxaul_hanging_sign")), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SAXAUL));
////            });
////        }
//////        if (BountifulFares.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID)) {
//////            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(BountifulFares.FARMERS_DELIGHT_MOD_ID, "farmersdelight"))).register(entries -> {
//////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.FARMERS_DELIGHT_MOD_ID, "bamboo_cabinet")), FarmersDelightBlocks.WALNUT_CABINET.asItem());
//////                entries.addAfter(FarmersDelightBlocks.WALNUT_CABINET.asItem(), FarmersDelightBlocks.HOARY_CABINET.asItem());
//////            });
//////        }
////        if (BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID)) {
////            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(BountifulFares.TWIGS_MOD_ID, "item_group"))).register(entries -> {
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.TWIGS_MOD_ID, "lamp")), TwigsBlocks.FELDSPAR_LAMP.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.TWIGS_MOD_ID, "bamboo_table")), TwigsBlocks.WALNUT_TABLE.asItem());
////                entries.addAfter(TwigsBlocks.WALNUT_TABLE.asItem(), TwigsBlocks.HOARY_TABLE.asItem());
////            });
////        }
////        if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
////            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(BountifulFares.SPAWN_MOD_ID, "item_group"))).register(entries -> {
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.SPAWN_MOD_ID, "rotten_fence")), SpawnBlocks.ROTTEN_PICKETS.asItem());
////                entries.addAfter(Registries.ITEM.get(Identifier.of(BountifulFares.SPAWN_MOD_ID, "rotten_hanging_sign")), TrellisUtil.getTrellisFromVariant(SpawnBlocks.ROTTEN));
////            });
////        }
    }
}
