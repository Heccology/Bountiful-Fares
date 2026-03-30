package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.integration.AppledogIntegration;
import net.hecco.bountifulfares.registry.integration.FarmersDelightIntegration;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class BFBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BFBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BFBlocks.FELDSPAR_BLOCK.get())
                .add(BFBlocks.CUT_FELDSPAR_BLOCK.get())
                .add(BFBlocks.FELDSPAR_BRICKS.get())
                .add(BFBlocks.FELDSPAR_BRICK_STAIRS.get())
                .add(BFBlocks.FELDSPAR_BRICK_SLAB.get())
                .add(BFBlocks.FELDSPAR_BRICK_WALL.get())
                .add(BFBlocks.FELDSPAR_LANTERN.get())
                .add(BFBlocks.CERAMIC_TILES.get())
                .add(BFBlocks.CERAMIC_TILE_STAIRS.get())
                .add(BFBlocks.CERAMIC_TILE_SLAB.get())
                //.add(BFBlocks.CERAMIC_TILE_WALL)
                .add(BFBlocks.CRACKED_CERAMIC_TILES.get())
                .add(BFBlocks.CHECKERED_CERAMIC_TILES.get())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get())
                //.add(BFBlocks.CHECKERED_CERAMIC_TILE_WALL)
                .add(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get())
                .add(BFBlocks.CERAMIC_TILE_PILLAR.get())
                .add(BFBlocks.CERAMIC_MOSAIC.get())
                .add(BFBlocks.CERAMIC_MOSAIC_STAIRS.get())
                .add(BFBlocks.CERAMIC_MOSAIC_SLAB.get())
                //.add(BFBlocks.CERAMIC_MOSAIC_WALL)
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC.get())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get())
                //.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL)
                .add(BFBlocks.CERAMIC_PRESSURE_PLATE.get())
                .add(BFBlocks.CERAMIC_DOOR.get())
                .add(BFBlocks.CERAMIC_TRAPDOOR.get())
                .add(BFBlocks.CERAMIC_BUTTON.get())
                .add(BFBlocks.CERAMIC_DISH.get())
                .add(BFBlocks.FERMENTATION_VESSEL.get())
                .add(BFBlocks.GOLDEN_APPLE_BLOCK.get())
                .add(BFBlocks.PACKED_COCONUT_COIR.get())
                .add(BFBlocks.COIR_BRICKS.get())
                .add(BFBlocks.COIR_BRICK_SLAB.get())
                .add(BFBlocks.COIR_BRICK_STAIRS.get())
                .add(BFBlocks.COIR_BRICK_WALL.get())
                .add(BFBlocks.IRON_RAILING.get())
        ;

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(BFBlocks.APPLE_LOG.get())
                .add(BFBlocks.APPLE_WOOD.get())
                .add(BFBlocks.STRIPPED_APPLE_LOG.get())
                .add(BFBlocks.STRIPPED_APPLE_WOOD.get())
                .add(BFBlocks.GOLDEN_APPLE_LOG.get())
                .add(BFBlocks.GOLDEN_APPLE_WOOD.get())
                .add(BFBlocks.APPLE_BLOCK.get())
                .add(BFBlocks.ORANGE_LOG.get())
                .add(BFBlocks.ORANGE_WOOD.get())
                .add(BFBlocks.STRIPPED_ORANGE_LOG.get())
                .add(BFBlocks.STRIPPED_ORANGE_WOOD.get())
                .add(BFBlocks.ORANGE_BLOCK.get())
                .add(BFBlocks.LEMON_LOG.get())
                .add(BFBlocks.LEMON_WOOD.get())
                .add(BFBlocks.STRIPPED_LEMON_LOG.get())
                .add(BFBlocks.STRIPPED_LEMON_WOOD.get())
                .add(BFBlocks.LEMON_BLOCK.get())
                .add(BFBlocks.PLUM_LOG.get())
                .add(BFBlocks.PLUM_WOOD.get())
                .add(BFBlocks.STRIPPED_PLUM_LOG.get())
                .add(BFBlocks.STRIPPED_PLUM_WOOD.get())
                .add(BFBlocks.PLUM_BLOCK.get())
                .add(BFBlocks.HOARY_LOG.get())
                .add(BFBlocks.HOARY_WOOD.get())
                .add(BFBlocks.STRIPPED_HOARY_LOG.get())
                .add(BFBlocks.STRIPPED_HOARY_WOOD.get())
                .add(BFBlocks.HOARY_PLANKS.get())
                .add(BFBlocks.HOARY_STAIRS.get())
                .add(BFBlocks.HOARY_SLAB.get())
                .add(BFBlocks.HOARY_FENCE.get())
                .add(BFBlocks.HOARY_FENCE_GATE.get())
                .add(BFBlocks.HOARY_DOOR.get())
                .add(BFBlocks.HOARY_TRAPDOOR.get())
                .add(BFBlocks.HOARY_PRESSURE_PLATE.get())
                .add(BFBlocks.HOARY_BUTTON.get())
                .add(BFBlocks.HOARY_SIGN.get())
                .add(BFBlocks.HOARY_WALL_SIGN.get())
                .add(BFBlocks.HOARY_HANGING_SIGN.get())
                .add(BFBlocks.HOARY_WALL_HANGING_SIGN.get())
                .add(BFBlocks.WALNUT_LOG.get())
                .add(BFBlocks.WALNUT_WOOD.get())
                .add(BFBlocks.STRIPPED_WALNUT_LOG.get())
                .add(BFBlocks.STRIPPED_WALNUT_WOOD.get())
                .add(BFBlocks.WALNUT_PLANKS.get())
                .add(BFBlocks.WALNUT_STAIRS.get())
                .add(BFBlocks.WALNUT_SLAB.get())
                .add(BFBlocks.WALNUT_FENCE.get())
                .add(BFBlocks.WALNUT_FENCE_GATE.get())
                .add(BFBlocks.WALNUT_DOOR.get())
                .add(BFBlocks.WALNUT_TRAPDOOR.get())
                .add(BFBlocks.WALNUT_PRESSURE_PLATE.get())
                .add(BFBlocks.WALNUT_BUTTON.get())
                .add(BFBlocks.WALNUT_SIGN.get())
                .add(BFBlocks.WALNUT_WALL_SIGN.get())
                .add(BFBlocks.WALNUT_HANGING_SIGN.get())
                .add(BFBlocks.WALNUT_WALL_HANGING_SIGN.get())
                .add(BFBlocks.PALM_LOG.get())
                .add(BFBlocks.PALM_WOOD.get())
                .add(BFBlocks.STRIPPED_PALM_LOG.get())
                .add(BFBlocks.STRIPPED_PALM_WOOD.get())
                .add(BFBlocks.PALM_CROWN.get())
                .add(BFBlocks.GRISTMILL.get())
                .add(BFBlocks.SPONGEKIN.get())
                .add(BFBlocks.APPLE_BLOCK.get())
                .add(BFBlocks.ORANGE_BLOCK.get())
                .add(BFBlocks.LEMON_BLOCK.get())
                .add(BFBlocks.PLUM_BLOCK.get())
                .add(BFBlocks.HOARY_APPLE_BLOCK.get())
                .add(FarmersDelightIntegration.WALNUT_CABINET.get())
                .add(FarmersDelightIntegration.HOARY_CABINET.get())
                .add(AppledogIntegration.APPLEDOG_BLOCK.get())

                .addTag(BFBlockTags.JACK_O_STRAWS)
        ;

        for (Supplier<Block> block : BFBlocks.PICKETS.values()) {
            getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE).add(block.get());
        }

        for (Supplier<Block> block : BFBlocks.TRELLISES.values()) {
            getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE).add(block.get());
        }


        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_HOE)
                .add(BFBlocks.APPLE_LEAVES.get())
                .add(BFBlocks.FLOWERING_APPLE_LEAVES.get())
                .add(BFBlocks.GOLDEN_APPLE_LEAVES.get())
                .add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get())
                .add(BFBlocks.ORANGE_LEAVES.get())
                .add(BFBlocks.FLOWERING_ORANGE_LEAVES.get())
                .add(BFBlocks.LEMON_LEAVES.get())
                .add(BFBlocks.FLOWERING_LEMON_LEAVES.get())
                .add(BFBlocks.PLUM_LEAVES.get())
                .add(BFBlocks.FLOWERING_PLUM_LEAVES.get())
                .add(BFBlocks.HOARY_LEAVES.get())
                .add(BFBlocks.WALNUT_LEAVES.get())
                .add(BFBlocks.TEA_SHRUB.get())
        ;
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BFBlocks.WALNUT_MULCH.get())
                .add(BFBlocks.WALNUT_MULCH_BLOCK.get())
                .add(BFBlocks.PALM_MULCH.get())
                .add(BFBlocks.PALM_MULCH_BLOCK.get())
                .add(BFBlocks.CERAMIC_CLAY_BLOCK.get())
                .add(BFBlocks.GRASSY_DIRT.get())
                .add(BFBlocks.FLOUR_BLOCK.get())
        ;

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(BFBlocks.FLOWERING_APPLE_LEAVES.get())
                .add(BFBlocks.FLOWERING_ORANGE_LEAVES.get())
                .add(BFBlocks.FLOWERING_LEMON_LEAVES.get())
                .add(BFBlocks.FLOWERING_PLUM_LEAVES.get())
        ;
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(BFBlocks.GOLDEN_APPLE_BLOCK.get());
        getOrCreateTagBuilder(BlockTags.CROPS).add(BFBlocks.HOARY_APPLE_SAPLING_CROP.get(), BFBlocks.MAIZE_CROP.get(), BFBlocks.LEEKS.get());

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(BFBlocks.POTTED_HOARY_APPLE_SAPLING.get(),
                        BFBlocks.POTTED_APPLE_SAPLING.get(),
                        BFBlocks.POTTED_GOLDEN_APPLE_SAPLING.get(),
                        BFBlocks.POTTED_ORANGE_SAPLING.get(),
                        BFBlocks.POTTED_LEMON_SAPLING.get(),
                        BFBlocks.POTTED_PLUM_SAPLING.get(),
                        BFBlocks.POTTED_GOLDEN_APPLE_SAPLING.get(),
                        BFBlocks.POTTED_WALNUT_SAPLING.get(),
                        BFBlocks.POTTED_PALM_FROND.get(),
                        BFBlocks.POTTED_HONEYSUCKLE.get(),
                        BFBlocks.POTTED_VIOLET_BELLFLOWER.get());

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(BFBlocks.HONEYSUCKLE.get(), BFBlocks.VIOLET_BELLFLOWER.get());

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .addTag(BFBlockTags.APPLE_LEAVES)
                .add(BFBlocks.GOLDEN_APPLE_LEAVES.get())
                .add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get())
                .addTag(BFBlockTags.ORANGE_LEAVES)
                .addTag(BFBlockTags.LEMON_LEAVES)
                .addTag(BFBlockTags.PLUM_LEAVES)
                .add(BFBlocks.HOARY_LEAVES.get())
                .add(BFBlocks.WALNUT_LEAVES.get());
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
                .add(BFBlocks.WALNUT_LOG.get());
        getOrCreateTagBuilder(BlockTags.PLANKS).add(BFBlocks.WALNUT_PLANKS.get(), BFBlocks.HOARY_PLANKS.get());
        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(BFBlocks.WALNUT_SIGN.get(), BFBlocks.HOARY_SIGN.get());
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(BFBlocks.WALNUT_HANGING_SIGN.get(), BFBlocks.HOARY_HANGING_SIGN.get());
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(BFBlocks.WALNUT_WALL_HANGING_SIGN.get(), BFBlocks.HOARY_WALL_HANGING_SIGN.get());
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(BFBlocks.WALNUT_WALL_SIGN.get(), BFBlocks.HOARY_WALL_SIGN.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(BFBlocks.WALNUT_BUTTON.get(), BFBlocks.HOARY_BUTTON.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(BFBlocks.WALNUT_DOOR.get(), BFBlocks.HOARY_DOOR.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(BFBlocks.WALNUT_FENCE.get(), BFBlocks.HOARY_FENCE.get());
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(BFBlocks.WALNUT_FENCE_GATE.get(), BFBlocks.HOARY_FENCE_GATE.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(BFBlocks.WALNUT_PRESSURE_PLATE.get(), BFBlocks.HOARY_PRESSURE_PLATE.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(BFBlocks.WALNUT_SLAB.get(), BFBlocks.HOARY_SLAB.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(BFBlocks.WALNUT_STAIRS.get(), BFBlocks.HOARY_STAIRS.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(BFBlocks.WALNUT_TRAPDOOR.get(), BFBlocks.HOARY_TRAPDOOR.get());
        getOrCreateTagBuilder(BlockTags.DOORS).add(BFBlocks.CERAMIC_DOOR.get());
        getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(BFBlocks.CERAMIC_TRAPDOOR.get());
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(BFBlocks.CERAMIC_PRESSURE_PLATE.get());
        getOrCreateTagBuilder(BlockTags.BUTTONS).add(BFBlocks.CERAMIC_BUTTON.get());

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(BFBlocks.COIR_BRICK_STAIRS.get())
                .add(BFBlocks.FELDSPAR_BRICK_STAIRS.get())
                .add(BFBlocks.CERAMIC_TILE_STAIRS.get())
                .add(BFBlocks.CERAMIC_MOSAIC_STAIRS.get())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get())
        ;
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(BFBlocks.COIR_BRICK_SLAB.get())
                .add(BFBlocks.FELDSPAR_BRICK_SLAB.get())
                .add(BFBlocks.CERAMIC_TILE_SLAB.get())
                .add(BFBlocks.CERAMIC_MOSAIC_SLAB.get())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get())
        ;
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(BFBlocks.COIR_BRICK_WALL.get())
                .add(BFBlocks.FELDSPAR_BRICK_WALL.get())
                //.add(BFBlocks.CERAMIC_TILE_WALL)
                //.add(BFBlocks.CERAMIC_MOSAIC_WALL)
                //.add(BFBlocks.CHECKERED_CERAMIC_TILE_WALL)
                //.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL)
        ;

        getOrCreateTagBuilder(BFBlockTags.INFUSED_CANDLES)
                .add(BFBlocks.GREEN_TEA_CANDLE.get())
                .add(BFBlocks.BLACK_TEA_CANDLE.get())
                .add(BFBlocks.CHAMOMILE_CANDLE.get())
                .add(BFBlocks.HONEYSUCKLE_CANDLE.get())
                .add(BFBlocks.BELLFLOWER_CANDLE.get())
                .add(BFBlocks.TORCHFLOWER_CANDLE.get())
                .add(BFBlocks.WALNUT_CANDLE.get());

        getOrCreateTagBuilder(BFBlockTags.APPLE_LEAVES).add(BFBlocks.APPLE_LEAVES.get(), BFBlocks.FLOWERING_APPLE_LEAVES.get());
        getOrCreateTagBuilder(BFBlockTags.ORANGE_LEAVES).add(BFBlocks.ORANGE_LEAVES.get(), BFBlocks.FLOWERING_ORANGE_LEAVES.get());
        getOrCreateTagBuilder(BFBlockTags.LEMON_LEAVES).add(BFBlocks.LEMON_LEAVES.get(), BFBlocks.FLOWERING_LEMON_LEAVES.get());
        getOrCreateTagBuilder(BFBlockTags.PLUM_LEAVES).add(BFBlocks.PLUM_LEAVES.get(), BFBlocks.FLOWERING_PLUM_LEAVES.get());
        getOrCreateTagBuilder(BFBlockTags.GOLDEN_APPLE_LEAVES).add(BFBlocks.GOLDEN_APPLE_LEAVES.get(), BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get());
        getOrCreateTagBuilder(BFBlockTags.APPLE_LOGS)
                .add(BFBlocks.APPLE_LOG.get())
                .add(BFBlocks.STRIPPED_APPLE_LOG.get())
                .add(BFBlocks.APPLE_WOOD.get())
                .add(BFBlocks.STRIPPED_APPLE_WOOD.get())
        ;
        getOrCreateTagBuilder(BFBlockTags.GOLDEN_APPLE_LOGS)
                .add(BFBlocks.GOLDEN_APPLE_LOG.get())
                .add(BFBlocks.GOLDEN_APPLE_WOOD.get())
        ;
        getOrCreateTagBuilder(BFBlockTags.ORANGE_LOGS)
                .add(BFBlocks.ORANGE_LOG.get())
                .add(BFBlocks.STRIPPED_ORANGE_LOG.get())
                .add(BFBlocks.ORANGE_WOOD.get())
                .add(BFBlocks.STRIPPED_ORANGE_WOOD.get())
        ;
        getOrCreateTagBuilder(BFBlockTags.LEMON_LOGS)
                .add(BFBlocks.LEMON_LOG.get())
                .add(BFBlocks.STRIPPED_LEMON_LOG.get())
                .add(BFBlocks.LEMON_WOOD.get())
                .add(BFBlocks.STRIPPED_LEMON_WOOD.get())
        ;
        getOrCreateTagBuilder(BFBlockTags.PLUM_LOGS)
                .add(BFBlocks.PLUM_LOG.get())
                .add(BFBlocks.STRIPPED_PLUM_LOG.get())
                .add(BFBlocks.PLUM_WOOD.get())
                .add(BFBlocks.STRIPPED_PLUM_WOOD.get())
        ;
        getOrCreateTagBuilder(BFBlockTags.PALM_LOGS)
                .add(BFBlocks.PALM_LOG.get())
                .add(BFBlocks.STRIPPED_PALM_LOG.get())
                .add(BFBlocks.PALM_WOOD.get())
                .add(BFBlocks.STRIPPED_PALM_WOOD.get())
        ;
        getOrCreateTagBuilder(BFBlockTags.WALNUT_LOGS)
                .add(BFBlocks.WALNUT_LOG.get())
                .add(BFBlocks.STRIPPED_WALNUT_LOG.get())
                .add(BFBlocks.WALNUT_WOOD.get())
                .add(BFBlocks.STRIPPED_WALNUT_WOOD.get())
        ;
        getOrCreateTagBuilder(BFBlockTags.HOARY_LOGS)
                .add(BFBlocks.HOARY_LOG.get())
                .add(BFBlocks.STRIPPED_HOARY_LOG.get())
                .add(BFBlocks.HOARY_WOOD.get())
                .add(BFBlocks.STRIPPED_HOARY_WOOD.get())
        ;

        for (Supplier<Block> block : BFBlocks.JACK_O_STRAWS.values()) {
            getOrCreateTagBuilder(BFBlockTags.JACK_O_STRAWS).add(block.get());
        }
        getOrCreateTagBuilder(BFBlockTags.JACK_O_STRAWS)
                .addOptional(BountifulFares.id("coral_jack_o_straw"))
                .addOptional(BountifulFares.id("umber_jack_o_straw"))
                .addOptional(BountifulFares.id("canary_jack_o_straw"))
                .addOptional(BountifulFares.id("wasabi_jack_o_straw"))
                .addOptional(BountifulFares.id("sacramento_jack_o_straw"))
                .addOptional(BountifulFares.id("sky_jack_o_straw"))
                .addOptional(BountifulFares.id("blurple_jack_o_straw"))
                .addOptional(BountifulFares.id("lavender_jack_o_straw"))
                .addOptional(BountifulFares.id("sangria_jack_o_straw"))
                .addOptional(BountifulFares.id("rose_jack_o_straw"))
        ;


        getOrCreateTagBuilder(BFBlockTags.HANGING_FRUIT)
                .add(BFBlocks.HANGING_APPLE.get())
                .add(BFBlocks.HANGING_ORANGE.get())
                .add(BFBlocks.HANGING_LEMON.get())
                .add(BFBlocks.HANGING_PLUM.get())
                .add(BFBlocks.HANGING_HOARY_APPLE.get())
                .add(BFBlocks.HANGING_GOLDEN_APPLE.get())
                .add(BFBlocks.HANGING_WITHERED_GOLDEN_APPLE.get())
                .add(BFBlocks.HANGING_WALNUTS.get())
        ;

        getOrCreateTagBuilder(BlockTags.BEE_GROWABLES)
                .addTag(BFBlockTags.HANGING_FRUIT)
        ;

        getOrCreateTagBuilder(BFBlockTags.CERAMIC_TILES)
                .add(BFBlocks.CERAMIC_TILES.get())
                .add(BFBlocks.CERAMIC_TILE_STAIRS.get())
                .add(BFBlocks.CERAMIC_TILE_SLAB.get())
                //.add(BFBlocks.CERAMIC_TILE_WALL)
                .add(BFBlocks.CRACKED_CERAMIC_TILES.get())
                .add(BFBlocks.CHECKERED_CERAMIC_TILES.get())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get())
                //.add(BFBlocks.CHECKERED_CERAMIC_TILE_WALL)
                .add(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get())
                .add(BFBlocks.CERAMIC_TILE_PILLAR.get())
                .add(BFBlocks.CERAMIC_MOSAIC.get())
                .add(BFBlocks.CERAMIC_MOSAIC_STAIRS.get())
                .add(BFBlocks.CERAMIC_MOSAIC_SLAB.get())
                //.add(BFBlocks.CERAMIC_MOSAIC_WALL)
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC.get())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get())
                //.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL)
        ;
        getOrCreateTagBuilder(BFBlockTags.DYEABLE_CERAMIC_BLOCKS)
                .addTag(BFBlockTags.CERAMIC_TILES)
                .add(BFBlocks.CERAMIC_DOOR.get())
                .add(BFBlocks.CERAMIC_TRAPDOOR.get())
                .add(BFBlocks.CERAMIC_PRESSURE_PLATE.get())
                .add(BFBlocks.CERAMIC_BUTTON.get())
                .add(BFBlocks.CERAMIC_LEVER.get())
                .add(BFBlocks.CERAMIC_DISH.get())
                .add(BFBlocks.SOLID_CERAMIC.get())
        ;

        getOrCreateTagBuilder(BFBlockTags.FELSIC_STONES)
                .add(Blocks.ANDESITE)
                .add(Blocks.GRANITE)
                .add(Blocks.DIORITE)
                .add(Blocks.TUFF)
        ;
        getOrCreateTagBuilder(BFBlockTags.PICKETS)
                .add(BFBlocks.IRON_RAILING.get())
        ;
        for (Supplier<Block> block : BFBlocks.PICKETS.values()) {
            getOrCreateTagBuilder(BFBlockTags.PICKETS).add(block.get());
        }
        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(BFBlocks.APPLE_SAPLING.get())
                .add(BFBlocks.GOLDEN_APPLE_SAPLING.get())
                .add(BFBlocks.ORANGE_SAPLING.get())
                .add(BFBlocks.LEMON_SAPLING.get())
                .add(BFBlocks.PLUM_SAPLING.get())
                .add(BFBlocks.GOLDEN_APPLE_SAPLING.get())
                .add(BFBlocks.HOARY_APPLE_SAPLING.get())
                .add(BFBlocks.WALNUT_SAPLING.get())
        ;
        getOrCreateTagBuilder(BFBlockTags.GRASS_SEEDS_PLANTABLE_ON)
                .add(Blocks.DIRT)
                .add(Blocks.COARSE_DIRT)
                .add(Blocks.ROOTED_DIRT)
                .add(Blocks.PODZOL)
                .add(Blocks.MYCELIUM)
        ;
        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(BFBlocks.GRASSY_DIRT.get())
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
                .add(BFBlocks.GRASSY_DIRT.get())
                .add(BFBlocks.APPLE_LOG.get())
                .add(BFBlocks.APPLE_WOOD.get())
                .add(BFBlocks.ORANGE_LOG.get())
                .add(BFBlocks.ORANGE_WOOD.get())
                .add(BFBlocks.LEMON_LOG.get())
                .add(BFBlocks.LEMON_WOOD.get())
                .add(BFBlocks.PLUM_LOG.get())
                .add(BFBlocks.PLUM_WOOD.get())
        ;

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(BFBlocks.WALNUT_MULCH_BLOCK.get())
                .add(BFBlocks.PALM_MULCH_BLOCK.get());

        getOrCreateTagBuilder(BlockTags.OCCLUDES_VIBRATION_SIGNALS).add(BFBlocks.PACKED_COCONUT_COIR.get()).add(BFBlocks.COIR_CARPET.get());

        getOrCreateTagBuilder(BFBlockTags.PRISMARINE_PROPAGATION_SUBSTRATE)
                .add(Blocks.SEA_LANTERN);
    }
}
