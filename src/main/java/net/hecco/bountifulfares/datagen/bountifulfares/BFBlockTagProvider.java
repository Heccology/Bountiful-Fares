package net.hecco.bountifulfares.datagen.bountifulfares;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class BFBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BFBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(BFBlocks.FELDSPAR_BLOCK)
                .add(BFBlocks.CUT_FELDSPAR_BLOCK)
                .add(BFBlocks.FELDSPAR_BRICKS)
                .add(BFBlocks.FELDSPAR_BRICK_STAIRS)
                .add(BFBlocks.FELDSPAR_BRICK_SLAB)
                .add(BFBlocks.FELDSPAR_LANTERN)
                .add(BFBlocks.CERAMIC_TILES)
                .add(BFBlocks.CERAMIC_TILE_STAIRS)
                .add(BFBlocks.CERAMIC_TILE_SLAB)
                .add(BFBlocks.CRACKED_CERAMIC_TILES)
                .add(BFBlocks.CHECKERED_CERAMIC_TILES)
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS)
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB)
                .add(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES)
                .add(BFBlocks.CERAMIC_TILE_PILLAR)
                .add(BFBlocks.CERAMIC_MOSAIC)
                .add(BFBlocks.CERAMIC_MOSAIC_STAIRS)
                .add(BFBlocks.CERAMIC_MOSAIC_SLAB)
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC)
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS)
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB)
                .add(BFBlocks.CERAMIC_PRESSURE_PLATE)
                .add(BFBlocks.CERAMIC_DOOR)
                .add(BFBlocks.CERAMIC_TRAPDOOR)
                .add(BFBlocks.CERAMIC_BUTTON)
                .add(BFBlocks.CERAMIC_DISH)
                .add(BFBlocks.FERMENTATION_VESSEL)
                .add(BFBlocks.GOLDEN_APPLE_BLOCK)
                .add(BFBlocks.PACKED_COCONUT_COIR)
                .add(BFBlocks.COIR_BRICKS)
                .add(BFBlocks.COIR_BRICK_SLAB)
                .add(BFBlocks.COIR_BRICK_STAIRS)
                .add(BFBlocks.COIR_BRICK_WALL)
                .add(BFBlocks.IRON_RAILING)
        ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(BFBlocks.APPLE_LOG)
                .add(BFBlocks.APPLE_WOOD)
                .add(BFBlocks.STRIPPED_APPLE_LOG)
                .add(BFBlocks.STRIPPED_APPLE_WOOD)
                .add(BFBlocks.GOLDEN_APPLE_LOG)
                .add(BFBlocks.GOLDEN_APPLE_WOOD)
                .add(BFBlocks.APPLE_BLOCK)
                .add(BFBlocks.ORANGE_LOG)
                .add(BFBlocks.ORANGE_WOOD)
                .add(BFBlocks.STRIPPED_ORANGE_LOG)
                .add(BFBlocks.STRIPPED_ORANGE_WOOD)
                .add(BFBlocks.ORANGE_BLOCK)
                .add(BFBlocks.LEMON_LOG)
                .add(BFBlocks.LEMON_WOOD)
                .add(BFBlocks.STRIPPED_LEMON_LOG)
                .add(BFBlocks.STRIPPED_LEMON_WOOD)
                .add(BFBlocks.LEMON_BLOCK)
                .add(BFBlocks.PLUM_LOG)
                .add(BFBlocks.PLUM_WOOD)
                .add(BFBlocks.STRIPPED_PLUM_LOG)
                .add(BFBlocks.STRIPPED_PLUM_WOOD)
                .add(BFBlocks.PLUM_BLOCK)
                .add(BFBlocks.HOARY_LOG)
                .add(BFBlocks.HOARY_WOOD)
                .add(BFBlocks.STRIPPED_HOARY_LOG)
                .add(BFBlocks.STRIPPED_HOARY_WOOD)
                .add(BFBlocks.HOARY_PLANKS)
                .add(BFBlocks.HOARY_STAIRS)
                .add(BFBlocks.HOARY_SLAB)
                .add(BFBlocks.HOARY_FENCE)
                .add(BFBlocks.HOARY_FENCE_GATE)
                .add(BFBlocks.HOARY_DOOR)
                .add(BFBlocks.HOARY_TRAPDOOR)
                .add(BFBlocks.HOARY_PRESSURE_PLATE)
                .add(BFBlocks.HOARY_BUTTON)
                .add(BFBlocks.HOARY_SIGN)
                .add(BFBlocks.HOARY_WALL_SIGN)
                .add(BFBlocks.HOARY_HANGING_SIGN)
                .add(BFBlocks.HOARY_WALL_HANGING_SIGN)
                .add(BFBlocks.WALNUT_LOG)
                .add(BFBlocks.WALNUT_WOOD)
                .add(BFBlocks.STRIPPED_WALNUT_LOG)
                .add(BFBlocks.STRIPPED_WALNUT_WOOD)
                .add(BFBlocks.WALNUT_PLANKS)
                .add(BFBlocks.WALNUT_STAIRS)
                .add(BFBlocks.WALNUT_SLAB)
                .add(BFBlocks.WALNUT_FENCE)
                .add(BFBlocks.WALNUT_FENCE_GATE)
                .add(BFBlocks.WALNUT_DOOR)
                .add(BFBlocks.WALNUT_TRAPDOOR)
                .add(BFBlocks.WALNUT_PRESSURE_PLATE)
                .add(BFBlocks.WALNUT_BUTTON)
                .add(BFBlocks.WALNUT_SIGN)
                .add(BFBlocks.WALNUT_WALL_SIGN)
                .add(BFBlocks.WALNUT_HANGING_SIGN)
                .add(BFBlocks.WALNUT_WALL_HANGING_SIGN)
                .add(BFBlocks.PALM_LOG)
                .add(BFBlocks.PALM_WOOD)
                .add(BFBlocks.STRIPPED_PALM_LOG)
                .add(BFBlocks.STRIPPED_PALM_WOOD)
                .add(BFBlocks.PALM_CROWN)
                .add(BFBlocks.OAK_PICKETS)
                .add(BFBlocks.SPRUCE_PICKETS)
                .add(BFBlocks.BIRCH_PICKETS)
                .add(BFBlocks.JUNGLE_PICKETS)
                .add(BFBlocks.ACACIA_PICKETS)
                .add(BFBlocks.DARK_OAK_PICKETS)
                .add(BFBlocks.MANGROVE_PICKETS)
                .add(BFBlocks.CHERRY_PICKETS)
                .add(BFBlocks.BAMBOO_PICKETS)
                .add(BFBlocks.WALNUT_PICKETS)
                .add(BFBlocks.HOARY_PICKETS)
                .add(BFBlocks.CRIMSON_PICKETS)
                .add(BFBlocks.WARPED_PICKETS)
                .add(BFBlocks.GRISTMILL)
                .add(BFBlocks.SPONGEKIN)
                .add(BFBlocks.APPLE_BLOCK)
                .add(BFBlocks.ORANGE_BLOCK)
                .add(BFBlocks.LEMON_BLOCK)
                .add(BFBlocks.PLUM_BLOCK)
                .add(BFBlocks.HOARY_APPLE_BLOCK)
                .add(BFBlocks.WHITE_JACK_O_STRAW)
                .add(BFBlocks.LIGHT_GRAY_JACK_O_STRAW)
                .add(BFBlocks.GRAY_JACK_O_STRAW)
                .add(BFBlocks.BLACK_JACK_O_STRAW)
                .add(BFBlocks.BROWN_JACK_O_STRAW)
                .add(BFBlocks.RED_JACK_O_STRAW)
                .add(BFBlocks.ORANGE_JACK_O_STRAW)
                .add(BFBlocks.YELLOW_JACK_O_STRAW)
                .add(BFBlocks.LIME_JACK_O_STRAW)
                .add(BFBlocks.GREEN_JACK_O_STRAW)
                .add(BFBlocks.CYAN_JACK_O_STRAW)
                .add(BFBlocks.LIGHT_BLUE_JACK_O_STRAW)
                .add(BFBlocks.BLUE_JACK_O_STRAW)
                .add(BFBlocks.PURPLE_JACK_O_STRAW)
                .add(BFBlocks.MAGENTA_JACK_O_STRAW)
                .add(BFBlocks.PINK_JACK_O_STRAW)
        ;

        registerTrellisBlockTags(BFTrellises.OAK);
        registerTrellisBlockTags(BFTrellises.SPRUCE);
        registerTrellisBlockTags(BFTrellises.BIRCH);
        registerTrellisBlockTags(BFTrellises.JUNGLE);
        registerTrellisBlockTags(BFTrellises.ACACIA);
        registerTrellisBlockTags(BFTrellises.DARK_OAK);
        registerTrellisBlockTags(BFTrellises.MANGROVE);
        registerTrellisBlockTags(BFTrellises.CHERRY);
        registerTrellisBlockTags(BFTrellises.BAMBOO);
        registerTrellisBlockTags(BFTrellises.WALNUT);
        registerTrellisBlockTags(BFTrellises.HOARY);
        registerTrellisBlockTags(BFTrellises.CRIMSON);
        registerTrellisBlockTags(BFTrellises.WARPED);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(BFBlocks.APPLE_LEAVES)
                .add(BFBlocks.FLOWERING_APPLE_LEAVES)
                .add(BFBlocks.GOLDEN_APPLE_LEAVES)
                .add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES)
                .add(BFBlocks.ORANGE_LEAVES)
                .add(BFBlocks.FLOWERING_ORANGE_LEAVES)
                .add(BFBlocks.LEMON_LEAVES)
                .add(BFBlocks.FLOWERING_LEMON_LEAVES)
                .add(BFBlocks.PLUM_LEAVES)
                .add(BFBlocks.FLOWERING_PLUM_LEAVES)
                .add(BFBlocks.HOARY_LEAVES)
                .add(BFBlocks.WALNUT_LEAVES)
                .add(BFBlocks.TEA_SHRUB)
        ;
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(BFBlocks.WALNUT_MULCH)
                .add(BFBlocks.WALNUT_MULCH_BLOCK)
                .add(BFBlocks.PALM_MULCH)
                .add(BFBlocks.PALM_MULCH_BLOCK)
                .add(BFBlocks.CERAMIC_CLAY_BLOCK)
                .add(BFBlocks.GRASSY_DIRT)
        ;

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(BFBlocks.FLOWERING_APPLE_LEAVES)
                .add(BFBlocks.FLOWERING_ORANGE_LEAVES)
                .add(BFBlocks.FLOWERING_LEMON_LEAVES)
                .add(BFBlocks.FLOWERING_PLUM_LEAVES)
        ;
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(BFBlocks.GOLDEN_APPLE_BLOCK);
        getOrCreateTagBuilder(BlockTags.CROPS).add(BFBlocks.HOARY_APPLE_SAPLING_CROP, BFBlocks.MAIZE_CROP, BFBlocks.LEEKS);

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(BFBlocks.POTTED_HOARY_APPLE_SAPLING,
                        BFBlocks.POTTED_APPLE_SAPLING,
                        BFBlocks.POTTED_GOLDEN_APPLE_SAPLING,
                        BFBlocks.POTTED_ORANGE_SAPLING,
                        BFBlocks.POTTED_LEMON_SAPLING,
                        BFBlocks.POTTED_PLUM_SAPLING,
                        BFBlocks.POTTED_GOLDEN_APPLE_SAPLING,
                        BFBlocks.WALNUT_SAPLING,
                        BFBlocks.POTTED_PALM_FROND,
                        BFBlocks.POTTED_HONEYSUCKLE,
                        BFBlocks.POTTED_VIOLET_BELLFLOWER);

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(BFBlocks.HONEYSUCKLE, BFBlocks.VIOLET_BELLFLOWER);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .addTag(BFBlockTags.APPLE_LEAVES)
                .add(BFBlocks.GOLDEN_APPLE_LEAVES)
                .add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES)
                .addTag(BFBlockTags.ORANGE_LEAVES)
                .addTag(BFBlockTags.LEMON_LEAVES)
                .addTag(BFBlockTags.PLUM_LEAVES)
                .add(BFBlocks.HOARY_LEAVES)
                .add(BFBlocks.WALNUT_LEAVES);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(BFBlockTags.APPLE_LOGS)
                .addTag(BFBlockTags.GOLDEN_APPLE_LOGS)
                .addTag(BFBlockTags.ORANGE_LOGS)
                .addTag(BFBlockTags.LEMON_LOGS)
                .addTag(BFBlockTags.PLUM_LOGS)
                .addTag(BFBlockTags.PALM_LOGS)
                .addTag(BFBlockTags.WALNUT_LOGS)
                .addTag(BFBlockTags.HOARY_LOGS);
        getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
                .add(BFBlocks.WALNUT_LOG);
        getOrCreateTagBuilder(BlockTags.PLANKS).add(BFBlocks.WALNUT_PLANKS, BFBlocks.HOARY_PLANKS);
        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(BFBlocks.WALNUT_SIGN, BFBlocks.HOARY_SIGN);
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(BFBlocks.WALNUT_HANGING_SIGN, BFBlocks.HOARY_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(BFBlocks.WALNUT_WALL_HANGING_SIGN, BFBlocks.HOARY_WALL_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(BFBlocks.WALNUT_WALL_SIGN, BFBlocks.HOARY_WALL_SIGN);
        getOrCreateTagBuilder(BlockTags.WALLS).add(BFBlocks.COIR_BRICK_WALL);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(BFBlocks.WALNUT_BUTTON, BFBlocks.HOARY_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(BFBlocks.WALNUT_DOOR, BFBlocks.HOARY_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(BFBlocks.WALNUT_FENCE, BFBlocks.HOARY_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(BFBlocks.WALNUT_FENCE_GATE, BFBlocks.HOARY_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(BFBlocks.WALNUT_PRESSURE_PLATE, BFBlocks.HOARY_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(BFBlocks.WALNUT_SLAB, BFBlocks.HOARY_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(BFBlocks.WALNUT_STAIRS, BFBlocks.HOARY_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(BFBlocks.WALNUT_TRAPDOOR, BFBlocks.HOARY_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.DOORS).add(BFBlocks.CERAMIC_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(BFBlocks.CERAMIC_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(BFBlocks.CERAMIC_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.BUTTONS).add(BFBlocks.CERAMIC_BUTTON);


        getOrCreateTagBuilder(BFBlockTags.INFUSED_CANDLES)
                .add(BFBlocks.GREEN_TEA_CANDLE)
                .add(BFBlocks.BLACK_TEA_CANDLE)
                .add(BFBlocks.CHAMOMILE_CANDLE)
                .add(BFBlocks.HONEYSUCKLE_CANDLE)
                .add(BFBlocks.BELLFLOWER_CANDLE)
                .add(BFBlocks.TORCHFLOWER_CANDLE)
                .add(BFBlocks.WALNUT_CANDLE);

        getOrCreateTagBuilder(BFBlockTags.APPLE_LEAVES).add(BFBlocks.APPLE_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES);
        getOrCreateTagBuilder(BFBlockTags.ORANGE_LEAVES).add(BFBlocks.ORANGE_LEAVES, BFBlocks.FLOWERING_ORANGE_LEAVES);
        getOrCreateTagBuilder(BFBlockTags.LEMON_LEAVES).add(BFBlocks.LEMON_LEAVES, BFBlocks.FLOWERING_LEMON_LEAVES);
        getOrCreateTagBuilder(BFBlockTags.PLUM_LEAVES).add(BFBlocks.PLUM_LEAVES, BFBlocks.FLOWERING_PLUM_LEAVES);
        getOrCreateTagBuilder(BFBlockTags.GOLDEN_APPLE_LEAVES).add(BFBlocks.GOLDEN_APPLE_LEAVES, BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES);
        getOrCreateTagBuilder(BFBlockTags.APPLE_LOGS)
                .add(BFBlocks.APPLE_LOG)
                .add(BFBlocks.STRIPPED_APPLE_LOG)
                .add(BFBlocks.APPLE_WOOD)
                .add(BFBlocks.STRIPPED_APPLE_WOOD)
        ;
        getOrCreateTagBuilder(BFBlockTags.GOLDEN_APPLE_LOGS)
                .add(BFBlocks.GOLDEN_APPLE_LOG)
                .add(BFBlocks.GOLDEN_APPLE_WOOD)
        ;
        getOrCreateTagBuilder(BFBlockTags.ORANGE_LOGS)
                .add(BFBlocks.ORANGE_LOG)
                .add(BFBlocks.STRIPPED_ORANGE_LOG)
                .add(BFBlocks.ORANGE_WOOD)
                .add(BFBlocks.STRIPPED_ORANGE_WOOD)
        ;
        getOrCreateTagBuilder(BFBlockTags.LEMON_LOGS)
                .add(BFBlocks.LEMON_LOG)
                .add(BFBlocks.STRIPPED_LEMON_LOG)
                .add(BFBlocks.LEMON_WOOD)
                .add(BFBlocks.STRIPPED_LEMON_WOOD)
        ;
        getOrCreateTagBuilder(BFBlockTags.PLUM_LOGS)
                .add(BFBlocks.PLUM_LOG)
                .add(BFBlocks.STRIPPED_PLUM_LOG)
                .add(BFBlocks.PLUM_WOOD)
                .add(BFBlocks.STRIPPED_PLUM_WOOD)
        ;
        getOrCreateTagBuilder(BFBlockTags.PALM_LOGS)
                .add(BFBlocks.PALM_LOG)
                .add(BFBlocks.STRIPPED_PALM_LOG)
                .add(BFBlocks.PALM_WOOD)
                .add(BFBlocks.STRIPPED_PALM_WOOD)
        ;
        getOrCreateTagBuilder(BFBlockTags.WALNUT_LOGS)
                .add(BFBlocks.WALNUT_LOG)
                .add(BFBlocks.STRIPPED_WALNUT_LOG)
                .add(BFBlocks.WALNUT_WOOD)
                .add(BFBlocks.STRIPPED_WALNUT_WOOD)
        ;
        getOrCreateTagBuilder(BFBlockTags.HOARY_LOGS)
                .add(BFBlocks.HOARY_LOG)
                .add(BFBlocks.STRIPPED_HOARY_LOG)
                .add(BFBlocks.HOARY_WOOD)
                .add(BFBlocks.STRIPPED_HOARY_WOOD)
        ;
        getOrCreateTagBuilder(BFBlockTags.JACK_O_STRAWS)
                .add(BFBlocks.WHITE_JACK_O_STRAW)
                .add(BFBlocks.LIGHT_GRAY_JACK_O_STRAW)
                .add(BFBlocks.GRAY_JACK_O_STRAW)
                .add(BFBlocks.BLACK_JACK_O_STRAW)
                .add(BFBlocks.BROWN_JACK_O_STRAW)
                .add(BFBlocks.RED_JACK_O_STRAW)
                .add(BFBlocks.ORANGE_JACK_O_STRAW)
                .add(BFBlocks.YELLOW_JACK_O_STRAW)
                .add(BFBlocks.LIME_JACK_O_STRAW)
                .add(BFBlocks.GREEN_JACK_O_STRAW)
                .add(BFBlocks.CYAN_JACK_O_STRAW)
                .add(BFBlocks.BLUE_JACK_O_STRAW)
                .add(BFBlocks.LIGHT_BLUE_JACK_O_STRAW)
                .add(BFBlocks.PURPLE_JACK_O_STRAW)
                .add(BFBlocks.MAGENTA_JACK_O_STRAW)
                .add(BFBlocks.PINK_JACK_O_STRAW)
        ;
        getOrCreateTagBuilder(BFBlockTags.CERAMIC_TILES)
                .add(BFBlocks.CERAMIC_TILES)
                .add(BFBlocks.CERAMIC_TILE_STAIRS)
                .add(BFBlocks.CERAMIC_TILE_SLAB)
                .add(BFBlocks.CRACKED_CERAMIC_TILES)
                .add(BFBlocks.CHECKERED_CERAMIC_TILES)
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS)
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB)
                .add(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES)
                .add(BFBlocks.CERAMIC_TILE_PILLAR)
                .add(BFBlocks.CERAMIC_MOSAIC)
                .add(BFBlocks.CERAMIC_MOSAIC_STAIRS)
                .add(BFBlocks.CERAMIC_MOSAIC_SLAB)
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC)
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS)
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB)
        ;
        getOrCreateTagBuilder(BFBlockTags.DYEABLE_CERAMIC_BLOCKS)
                .addTag(BFBlockTags.CERAMIC_TILES)
                .add(BFBlocks.CERAMIC_DOOR)
                .add(BFBlocks.CERAMIC_TRAPDOOR)
                .add(BFBlocks.CERAMIC_PRESSURE_PLATE)
                .add(BFBlocks.CERAMIC_BUTTON)
                .add(BFBlocks.CERAMIC_LEVER)
                .add(BFBlocks.CERAMIC_DISH)
        ;

        getOrCreateTagBuilder(BFBlockTags.FELSIC_STONES)
                .add(Blocks.ANDESITE)
                .add(Blocks.GRANITE)
                .add(Blocks.DIORITE)
                .add(Blocks.TUFF)
        ;
        getOrCreateTagBuilder(BFBlockTags.PICKETS)
                .add(BFBlocks.OAK_PICKETS)
                .add(BFBlocks.SPRUCE_PICKETS)
                .add(BFBlocks.BIRCH_PICKETS)
                .add(BFBlocks.JUNGLE_PICKETS)
                .add(BFBlocks.ACACIA_PICKETS)
                .add(BFBlocks.DARK_OAK_PICKETS)
                .add(BFBlocks.MANGROVE_PICKETS)
                .add(BFBlocks.CHERRY_PICKETS)
                .add(BFBlocks.BAMBOO_PICKETS)
                .add(BFBlocks.WALNUT_PICKETS)
                .add(BFBlocks.HOARY_PICKETS)
                .add(BFBlocks.CRIMSON_PICKETS)
                .add(BFBlocks.WARPED_PICKETS)
        ;
        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(BFBlocks.APPLE_SAPLING)
                .add(BFBlocks.GOLDEN_APPLE_SAPLING)
                .add(BFBlocks.ORANGE_SAPLING)
                .add(BFBlocks.LEMON_SAPLING)
                .add(BFBlocks.PLUM_SAPLING)
                .add(BFBlocks.GOLDEN_APPLE_SAPLING)
                .add(BFBlocks.HOARY_APPLE_SAPLING)
                .add(BFBlocks.WALNUT_SAPLING)
        ;
        getOrCreateTagBuilder(BFBlockTags.GRASS_SEEDS_PLANTABLE_ON)
                .add(Blocks.DIRT)
                .add(Blocks.COARSE_DIRT)
                .add(Blocks.ROOTED_DIRT)
                .add(Blocks.PODZOL)
                .add(Blocks.MYCELIUM)
        ;
        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(BFBlocks.GRASSY_DIRT)
        ;

        getOrCreateTagBuilder(BFBlockTags.WILD_ELDERBERRY_PLACEABLE_ON)
                .addTag(BlockTags.OVERWORLD_NATURAL_LOGS)
                .add(Blocks.MANGROVE_ROOTS)
                ;

        getOrCreateTagBuilder(BFBlockTags.PALM_SAPLINGS_PLANTABLE_ON)
                .addTag(BlockTags.DIRT)
                .add(Blocks.SAND)
                .add(Blocks.RED_SAND)
                .add(Blocks.GRAVEL)
        ;

        getOrCreateTagBuilder(BFBlockTags.SPLITS_COCONUTS)
                .add(Blocks.POINTED_DRIPSTONE);


        getOrCreateTagBuilder(BFBlockTags.IGNORE_PARTICLE_TINT)
                .add(BFBlocks.GRASSY_DIRT)
                .add(BFBlocks.APPLE_LOG)
                .add(BFBlocks.APPLE_WOOD)
                .add(BFBlocks.ORANGE_LOG)
                .add(BFBlocks.ORANGE_WOOD)
                .add(BFBlocks.LEMON_LOG)
                .add(BFBlocks.LEMON_WOOD)
                .add(BFBlocks.PLUM_LOG)
                .add(BFBlocks.PLUM_WOOD)
        ;

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(BFBlocks.WALNUT_MULCH_BLOCK)
                .add(BFBlocks.PALM_MULCH_BLOCK);

        getOrCreateTagBuilder(BlockTags.OCCLUDES_VIBRATION_SIGNALS).add(BFBlocks.PACKED_COCONUT_COIR).add(BFBlocks.COIR_CARPET);

        getOrCreateTagBuilder(BFBlockTags.PRISMARINE_PROPAGATION_SUBSTRATE)
                .add(Blocks.SEA_LANTERN);
    }

    public void registerTrellisBlockTags(TrellisVariant trellis) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .addOptional(Identifier.of(trellis.getModId(), trellis.getBlockName()))
        ;
        for (VineCrop crop : TrellisUtil.VineCrops) {
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                    .addOptional(Identifier.of(trellis.getModId(), crop.getName() + "_" + trellis.getBlockName()))
            ;
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                    .addOptional(Identifier.of(trellis.getModId(), vine.getName() + "_" + trellis.getBlockName()))
            ;
        }
    }
}
