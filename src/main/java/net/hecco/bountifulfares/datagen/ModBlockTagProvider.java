package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.block.ModTrellises;
import net.hecco.bountifulfares.block.TrellisUtil;
import net.hecco.bountifulfares.block.TrellisVariants;
import net.hecco.bountifulfares.block.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.hecco.bountifulfares.util.ModBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.FELDSPAR_BLOCK)
                .add(ModBlocks.CUT_FELDSPAR_BLOCK)
                .add(ModBlocks.FELDSPAR_BRICKS)
                .add(ModBlocks.FELDSPAR_BRICK_STAIRS)
                .add(ModBlocks.FELDSPAR_BRICK_SLAB)
                .add(ModBlocks.FELDSPAR_LANTERN)
                .add(ModBlocks.CERAMIC_TILES)
                .add(ModBlocks.CERAMIC_TILE_STAIRS)
                .add(ModBlocks.CERAMIC_TILE_SLAB)
                .add(ModBlocks.CRACKED_CERAMIC_TILES)
                .add(ModBlocks.CHECKERED_CERAMIC_TILES)
                .add(ModBlocks.CHECKERED_CERAMIC_TILE_STAIRS)
                .add(ModBlocks.CHECKERED_CERAMIC_TILE_SLAB)
                .add(ModBlocks.CRACKED_CHECKERED_CERAMIC_TILES)
                .add(ModBlocks.CERAMIC_TILE_PILLAR)
                .add(ModBlocks.CERAMIC_MOSAIC)
                .add(ModBlocks.CERAMIC_MOSAIC_STAIRS)
                .add(ModBlocks.CERAMIC_MOSAIC_SLAB)
                .add(ModBlocks.CHECKERED_CERAMIC_MOSAIC)
                .add(ModBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS)
                .add(ModBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB)
                .add(ModBlocks.CERAMIC_PRESSURE_PLATE)
                .add(ModBlocks.CERAMIC_DOOR)
                .add(ModBlocks.CERAMIC_TRAPDOOR)
                .add(ModBlocks.CERAMIC_BUTTON)
                .add(ModBlocks.CERAMIC_DISH)
                .add(ModBlocks.FERMENTATION_VESSEL)
                .add(ModBlocks.GOLDEN_APPLE_BLOCK)
        ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.APPLE_LOG)
                .add(ModBlocks.APPLE_WOOD)
                .add(ModBlocks.STRIPPED_APPLE_LOG)
                .add(ModBlocks.STRIPPED_APPLE_WOOD)
                .add(ModBlocks.APPLE_BLOCK)
                .add(ModBlocks.ORANGE_LOG)
                .add(ModBlocks.ORANGE_WOOD)
                .add(ModBlocks.STRIPPED_ORANGE_LOG)
                .add(ModBlocks.STRIPPED_ORANGE_WOOD)
                .add(ModBlocks.ORANGE_BLOCK)
                .add(ModBlocks.LEMON_LOG)
                .add(ModBlocks.LEMON_WOOD)
                .add(ModBlocks.STRIPPED_LEMON_LOG)
                .add(ModBlocks.STRIPPED_LEMON_WOOD)
                .add(ModBlocks.LEMON_BLOCK)
                .add(ModBlocks.PLUM_LOG)
                .add(ModBlocks.PLUM_WOOD)
                .add(ModBlocks.STRIPPED_PLUM_LOG)
                .add(ModBlocks.STRIPPED_PLUM_WOOD)
                .add(ModBlocks.PLUM_BLOCK)
                .add(ModBlocks.HOARY_LOG)
                .add(ModBlocks.HOARY_WOOD)
                .add(ModBlocks.STRIPPED_HOARY_LOG)
                .add(ModBlocks.STRIPPED_HOARY_WOOD)
                .add(ModBlocks.HOARY_PLANKS)
                .add(ModBlocks.HOARY_STAIRS)
                .add(ModBlocks.HOARY_SLAB)
                .add(ModBlocks.HOARY_FENCE)
                .add(ModBlocks.HOARY_FENCE_GATE)
                .add(ModBlocks.HOARY_DOOR)
                .add(ModBlocks.HOARY_TRAPDOOR)
                .add(ModBlocks.HOARY_PRESSURE_PLATE)
                .add(ModBlocks.HOARY_BUTTON)
                .add(ModBlocks.HOARY_SIGN)
                .add(ModBlocks.HOARY_WALL_SIGN)
                .add(ModBlocks.HOARY_HANGING_SIGN)
                .add(ModBlocks.HOARY_WALL_HANGING_SIGN)
                .add(ModBlocks.WALNUT_LOG)
                .add(ModBlocks.WALNUT_WOOD)
                .add(ModBlocks.STRIPPED_WALNUT_LOG)
                .add(ModBlocks.STRIPPED_WALNUT_WOOD)
                .add(ModBlocks.WALNUT_PLANKS)
                .add(ModBlocks.WALNUT_STAIRS)
                .add(ModBlocks.WALNUT_SLAB)
                .add(ModBlocks.WALNUT_FENCE)
                .add(ModBlocks.WALNUT_FENCE_GATE)
                .add(ModBlocks.WALNUT_DOOR)
                .add(ModBlocks.WALNUT_TRAPDOOR)
                .add(ModBlocks.WALNUT_PRESSURE_PLATE)
                .add(ModBlocks.WALNUT_BUTTON)
                .add(ModBlocks.WALNUT_SIGN)
                .add(ModBlocks.WALNUT_WALL_SIGN)
                .add(ModBlocks.WALNUT_HANGING_SIGN)
                .add(ModBlocks.WALNUT_WALL_HANGING_SIGN)
                .add(ModBlocks.OAK_PICKETS)
                .add(ModBlocks.SPRUCE_PICKETS)
                .add(ModBlocks.BIRCH_PICKETS)
                .add(ModBlocks.JUNGLE_PICKETS)
                .add(ModBlocks.ACACIA_PICKETS)
                .add(ModBlocks.DARK_OAK_PICKETS)
                .add(ModBlocks.MANGROVE_PICKETS)
                .add(ModBlocks.CHERRY_PICKETS)
                .add(ModBlocks.BAMBOO_PICKETS)
                .add(ModBlocks.WALNUT_PICKETS)
                .add(ModBlocks.HOARY_PICKETS)
                .add(ModBlocks.CRIMSON_PICKETS)
                .add(ModBlocks.WARPED_PICKETS)
                .add(ModBlocks.GRISTMILL)
                .add(ModBlocks.SPONGEKIN)
                .add(ModBlocks.APPLE_BLOCK)
                .add(ModBlocks.ORANGE_BLOCK)
                .add(ModBlocks.LEMON_BLOCK)
                .add(ModBlocks.PLUM_BLOCK)
                .add(ModBlocks.HOARY_APPLE_BLOCK)
                .add(ModBlocks.WHITE_JACK_O_STRAW)
                .add(ModBlocks.LIGHT_GRAY_JACK_O_STRAW)
                .add(ModBlocks.GRAY_JACK_O_STRAW)
                .add(ModBlocks.BLACK_JACK_O_STRAW)
                .add(ModBlocks.BROWN_JACK_O_STRAW)
                .add(ModBlocks.RED_JACK_O_STRAW)
                .add(ModBlocks.ORANGE_JACK_O_STRAW)
                .add(ModBlocks.YELLOW_JACK_O_STRAW)
                .add(ModBlocks.LIME_JACK_O_STRAW)
                .add(ModBlocks.GREEN_JACK_O_STRAW)
                .add(ModBlocks.CYAN_JACK_O_STRAW)
                .add(ModBlocks.LIGHT_BLUE_JACK_O_STRAW)
                .add(ModBlocks.BLUE_JACK_O_STRAW)
                .add(ModBlocks.PURPLE_JACK_O_STRAW)
                .add(ModBlocks.MAGENTA_JACK_O_STRAW)
                .add(ModBlocks.PINK_JACK_O_STRAW)
        ;

        registerTrellisBlockTags(ModTrellises.OAK);
        registerTrellisBlockTags(ModTrellises.SPRUCE);
        registerTrellisBlockTags(ModTrellises.BIRCH);
        registerTrellisBlockTags(ModTrellises.JUNGLE);
        registerTrellisBlockTags(ModTrellises.ACACIA);
        registerTrellisBlockTags(ModTrellises.DARK_OAK);
        registerTrellisBlockTags(ModTrellises.MANGROVE);
        registerTrellisBlockTags(ModTrellises.CHERRY);
        registerTrellisBlockTags(ModTrellises.BAMBOO);
        registerTrellisBlockTags(ModTrellises.WALNUT);
        registerTrellisBlockTags(ModTrellises.HOARY);
        registerTrellisBlockTags(ModTrellises.CRIMSON);
        registerTrellisBlockTags(ModTrellises.WARPED);
//        registerTrellisBlockTags(ModTrellises.ASPEN);
//        registerTrellisBlockTags(ModTrellises.CEDAR);
//        registerTrellisBlockTags(ModTrellises.COCONUT);
//        registerTrellisBlockTags(ModTrellises.CYPRESS);
//        registerTrellisBlockTags(ModTrellises.FIR);
//        registerTrellisBlockTags(ModTrellises.GHAF);
//        registerTrellisBlockTags(ModTrellises.JOSHUA);
//        registerTrellisBlockTags(ModTrellises.LARCH);
//        registerTrellisBlockTags(ModTrellises.MAHOGANY);
//        registerTrellisBlockTags(ModTrellises.MAPLE);
//        registerTrellisBlockTags(ModTrellises.OLIVE);
//        registerTrellisBlockTags(ModTrellises.PALO_VERDE);
//        registerTrellisBlockTags(ModTrellises.SAXAUL);
//        registerTrellisBlockTags(ModTrellises.SUGI);
//        registerTrellisBlockTags(ModTrellises.WILLOW);
//        registerTrellisBlockTags(ModTrellises.WISTERIA);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.APPLE_LEAVES)
                .add(ModBlocks.FLOWERING_APPLE_LEAVES)
                .add(ModBlocks.ORANGE_LEAVES)
                .add(ModBlocks.FLOWERING_ORANGE_LEAVES)
                .add(ModBlocks.LEMON_LEAVES)
                .add(ModBlocks.FLOWERING_LEMON_LEAVES)
                .add(ModBlocks.PLUM_LEAVES)
                .add(ModBlocks.FLOWERING_PLUM_LEAVES)
                .add(ModBlocks.HOARY_LEAVES)
                .add(ModBlocks.WALNUT_LEAVES)
                .add(ModBlocks.TEA_SHRUB)
        ;
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.WALNUT_MULCH)
                .add(ModBlocks.WALNUT_MULCH_BLOCK)
                .add(ModBlocks.CERAMIC_CLAY_BLOCK)
        ;


        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.FLOWERING_APPLE_LEAVES)
                .add(ModBlocks.FLOWERING_ORANGE_LEAVES)
                .add(ModBlocks.FLOWERING_LEMON_LEAVES)
                .add(ModBlocks.FLOWERING_PLUM_LEAVES)
        ;
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.GOLDEN_APPLE_BLOCK);
        getOrCreateTagBuilder(BlockTags.CROPS).add(ModBlocks.HOARY_APPLE_SAPLING_CROP, ModBlocks.MAIZE_CROP, ModBlocks.LEEKS);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_HOARY_APPLE_SAPLING,
                ModBlocks.POTTED_APPLE_SAPLING,
                ModBlocks.POTTED_ORANGE_SAPLING,
                ModBlocks.POTTED_LEMON_SAPLING,
                ModBlocks.POTTED_PLUM_SAPLING,
                ModBlocks.POTTED_HONEYSUCKLE,
                ModBlocks.POTTED_VIOLET_BELLFLOWER);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(ModBlocks.HONEYSUCKLE, ModBlocks.VIOLET_BELLFLOWER);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .addTag(ModBlockTags.APPLE_LEAVES)
                .addTag(ModBlockTags.ORANGE_LEAVES)
                .addTag(ModBlockTags.LEMON_LEAVES)
                .addTag(ModBlockTags.PLUM_LEAVES)
                .add(ModBlocks.HOARY_LEAVES)
                .add(ModBlocks.WALNUT_LEAVES);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(ModBlockTags.APPLE_LOGS)
                .addTag(ModBlockTags.ORANGE_LOGS)
                .addTag(ModBlockTags.LEMON_LOGS)
                .addTag(ModBlockTags.PLUM_LOGS)
                .addTag(ModBlockTags.WALNUT_LOGS)
                .addTag(ModBlockTags.HOARY_LOGS);
        getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
                .add(ModBlocks.APPLE_LOG)
                .add(ModBlocks.ORANGE_LOG)
                .add(ModBlocks.LEMON_LOG)
                .add(ModBlocks.PLUM_LOG)
                .add(ModBlocks.WALNUT_LOG)
                .add(ModBlocks.HOARY_LOG);
        getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.WALNUT_PLANKS, ModBlocks.HOARY_PLANKS);
        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(ModBlocks.WALNUT_SIGN, ModBlocks.HOARY_SIGN);
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.WALNUT_HANGING_SIGN, ModBlocks.HOARY_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.WALNUT_WALL_HANGING_SIGN, ModBlocks.HOARY_WALL_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(ModBlocks.WALNUT_WALL_SIGN, ModBlocks.HOARY_WALL_SIGN);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.WALNUT_BUTTON, ModBlocks.HOARY_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.WALNUT_DOOR, ModBlocks.HOARY_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.WALNUT_FENCE, ModBlocks.HOARY_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.WALNUT_FENCE_GATE, ModBlocks.HOARY_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.WALNUT_PRESSURE_PLATE, ModBlocks.HOARY_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.WALNUT_SLAB, ModBlocks.HOARY_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.WALNUT_STAIRS, ModBlocks.HOARY_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.WALNUT_TRAPDOOR, ModBlocks.HOARY_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.DOORS).add(ModBlocks.CERAMIC_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(ModBlocks.CERAMIC_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(ModBlocks.CERAMIC_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.BUTTONS).add(ModBlocks.CERAMIC_BUTTON);


        getOrCreateTagBuilder(ModBlockTags.INFUSED_CANDLES)
                .add(ModBlocks.GREEN_TEA_CANDLE)
                .add(ModBlocks.BLACK_TEA_CANDLE)
                .add(ModBlocks.CHAMOMILE_CANDLE)
                .add(ModBlocks.HONEYSUCKLE_CANDLE)
                .add(ModBlocks.BELLFLOWER_CANDLE)
                .add(ModBlocks.TORCHFLOWER_CANDLE)
                .add(ModBlocks.WALNUT_CANDLE);

        getOrCreateTagBuilder(ModBlockTags.APPLE_LEAVES).add(ModBlocks.APPLE_LEAVES, ModBlocks.FLOWERING_APPLE_LEAVES);
        getOrCreateTagBuilder(ModBlockTags.ORANGE_LEAVES).add(ModBlocks.ORANGE_LEAVES, ModBlocks.FLOWERING_ORANGE_LEAVES);
        getOrCreateTagBuilder(ModBlockTags.LEMON_LEAVES).add(ModBlocks.LEMON_LEAVES, ModBlocks.FLOWERING_LEMON_LEAVES);
        getOrCreateTagBuilder(ModBlockTags.PLUM_LEAVES).add(ModBlocks.PLUM_LEAVES, ModBlocks.FLOWERING_PLUM_LEAVES);
        getOrCreateTagBuilder(ModBlockTags.APPLE_LOGS)
                .add(ModBlocks.APPLE_LOG)
                .add(ModBlocks.STRIPPED_APPLE_LOG)
                .add(ModBlocks.APPLE_WOOD)
                .add(ModBlocks.STRIPPED_APPLE_WOOD)
        ;
        getOrCreateTagBuilder(ModBlockTags.ORANGE_LOGS)
                .add(ModBlocks.ORANGE_LOG)
                .add(ModBlocks.STRIPPED_ORANGE_LOG)
                .add(ModBlocks.ORANGE_WOOD)
                .add(ModBlocks.STRIPPED_ORANGE_WOOD)
        ;
        getOrCreateTagBuilder(ModBlockTags.LEMON_LOGS)
                .add(ModBlocks.LEMON_LOG)
                .add(ModBlocks.STRIPPED_LEMON_LOG)
                .add(ModBlocks.LEMON_WOOD)
                .add(ModBlocks.STRIPPED_LEMON_WOOD)
        ;
        getOrCreateTagBuilder(ModBlockTags.PLUM_LOGS)
                .add(ModBlocks.PLUM_LOG)
                .add(ModBlocks.STRIPPED_PLUM_LOG)
                .add(ModBlocks.PLUM_WOOD)
                .add(ModBlocks.STRIPPED_PLUM_WOOD)
        ;
        getOrCreateTagBuilder(ModBlockTags.WALNUT_LOGS)
                .add(ModBlocks.WALNUT_LOG)
                .add(ModBlocks.STRIPPED_WALNUT_LOG)
                .add(ModBlocks.WALNUT_WOOD)
                .add(ModBlocks.STRIPPED_WALNUT_WOOD)
        ;
        getOrCreateTagBuilder(ModBlockTags.HOARY_LOGS)
                .add(ModBlocks.HOARY_LOG)
                .add(ModBlocks.STRIPPED_HOARY_LOG)
                .add(ModBlocks.HOARY_WOOD)
                .add(ModBlocks.STRIPPED_HOARY_WOOD)
        ;
        getOrCreateTagBuilder(ModBlockTags.JACK_O_STRAWS)
                .add(ModBlocks.WHITE_JACK_O_STRAW)
                .add(ModBlocks.LIGHT_GRAY_JACK_O_STRAW)
                .add(ModBlocks.GRAY_JACK_O_STRAW)
                .add(ModBlocks.BLACK_JACK_O_STRAW)
//                .add(ModBlocks.ACORN_JACK_O_STRAW)
                .add(ModBlocks.BROWN_JACK_O_STRAW)
//                .add(ModBlocks.MAROON_JACK_O_STRAW)
                .add(ModBlocks.RED_JACK_O_STRAW)
//                .add(ModBlocks.PEACH_JACK_O_STRAW)
//                .add(ModBlocks.VERMILION_JACK_O_STRAW)
                .add(ModBlocks.ORANGE_JACK_O_STRAW)
//                .add(ModBlocks.AMBER_JACK_O_STRAW)
                .add(ModBlocks.YELLOW_JACK_O_STRAW)
//                .add(ModBlocks.BANANA_JACK_O_STRAW)
//                .add(ModBlocks.ARTICHOKE_JACK_O_STRAW)
                .add(ModBlocks.LIME_JACK_O_STRAW)
//                .add(ModBlocks.MINT_JACK_O_STRAW)
//                .add(ModBlocks.SHAMROCK_JACK_O_STRAW)
//                .add(ModBlocks.SAGE_JACK_O_STRAW)
//                .add(ModBlocks.MOLD_JACK_O_STRAW)
                .add(ModBlocks.GREEN_JACK_O_STRAW)
//                .add(ModBlocks.SAP_JACK_O_STRAW)
                .add(ModBlocks.CYAN_JACK_O_STRAW)
//                .add(ModBlocks.NAVY_JACK_O_STRAW)
                .add(ModBlocks.BLUE_JACK_O_STRAW)
                .add(ModBlocks.LIGHT_BLUE_JACK_O_STRAW)
//                .add(ModBlocks.CERULEAN_JACK_O_STRAW)
//                .add(ModBlocks.INDIGO_JACK_O_STRAW)
//                .add(ModBlocks.PERIWINKLE_JACK_O_STRAW)
                .add(ModBlocks.PURPLE_JACK_O_STRAW)
//                .add(ModBlocks.GRAPE_JACK_O_STRAW)
                .add(ModBlocks.MAGENTA_JACK_O_STRAW)
//                .add(ModBlocks.MAUVE_JACK_O_STRAW)
//                .add(ModBlocks.VELVET_JACK_O_STRAW)
//                .add(ModBlocks.FUCHSIA_JACK_O_STRAW)
                .add(ModBlocks.PINK_JACK_O_STRAW)
        ;
        getOrCreateTagBuilder(ModBlockTags.CERAMIC_TILES)
                .add(ModBlocks.CERAMIC_TILES)
                .add(ModBlocks.CERAMIC_TILE_STAIRS)
                .add(ModBlocks.CERAMIC_TILE_SLAB)
                .add(ModBlocks.CRACKED_CERAMIC_TILES)
                .add(ModBlocks.CHECKERED_CERAMIC_TILES)
                .add(ModBlocks.CHECKERED_CERAMIC_TILE_STAIRS)
                .add(ModBlocks.CHECKERED_CERAMIC_TILE_SLAB)
                .add(ModBlocks.CRACKED_CHECKERED_CERAMIC_TILES)
                .add(ModBlocks.CERAMIC_TILE_PILLAR)
                .add(ModBlocks.CERAMIC_MOSAIC)
                .add(ModBlocks.CERAMIC_MOSAIC_STAIRS)
                .add(ModBlocks.CERAMIC_MOSAIC_SLAB)
                .add(ModBlocks.CHECKERED_CERAMIC_MOSAIC)
                .add(ModBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS)
                .add(ModBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB)
        ;
        getOrCreateTagBuilder(ModBlockTags.DYEABLE_CERAMIC_BLOCKS)
                .addTag(ModBlockTags.CERAMIC_TILES)
                .add(ModBlocks.CERAMIC_DOOR)
                .add(ModBlocks.CERAMIC_TRAPDOOR)
                .add(ModBlocks.CERAMIC_PRESSURE_PLATE)
                .add(ModBlocks.CERAMIC_BUTTON)
                .add(ModBlocks.CERAMIC_LEVER)
                .add(ModBlocks.CERAMIC_DISH)
        ;

        getOrCreateTagBuilder(ModBlockTags.FELSIC_STONES)
                .add(Blocks.ANDESITE)
                .add(Blocks.GRANITE)
                .add(Blocks.DIORITE)
                .add(Blocks.TUFF)
        ;
        getOrCreateTagBuilder(ModBlockTags.PICKETS)
                .add(ModBlocks.OAK_PICKETS)
                .add(ModBlocks.SPRUCE_PICKETS)
                .add(ModBlocks.BIRCH_PICKETS)
                .add(ModBlocks.JUNGLE_PICKETS)
                .add(ModBlocks.ACACIA_PICKETS)
                .add(ModBlocks.DARK_OAK_PICKETS)
                .add(ModBlocks.MANGROVE_PICKETS)
                .add(ModBlocks.CHERRY_PICKETS)
                .add(ModBlocks.BAMBOO_PICKETS)
                .add(ModBlocks.WALNUT_PICKETS)
                .add(ModBlocks.HOARY_PICKETS)
                .add(ModBlocks.CRIMSON_PICKETS)
                .add(ModBlocks.WARPED_PICKETS)
        ;
        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.APPLE_SAPLING)
                .add(ModBlocks.ORANGE_SAPLING)
                .add(ModBlocks.LEMON_SAPLING)
                .add(ModBlocks.PLUM_SAPLING)
                .add(ModBlocks.HOARY_APPLE_SAPLING)
                .add(ModBlocks.WALNUT_SAPLING)
        ;
        getOrCreateTagBuilder(ModBlockTags.GRASS_SEEDS_PLANTABLE_ON)
                .add(Blocks.DIRT)
                .add(Blocks.COARSE_DIRT)
                .add(Blocks.ROOTED_DIRT)
                .add(Blocks.PODZOL)
                .add(Blocks.MYCELIUM)
        ;
        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.GRASSY_DIRT)
        ;
    }

    public void registerTrellisBlockTags(TrellisVariant trellis) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(TrellisUtil.getTrellisFromVariant(trellis))
        ;
        for (VineCrop crop : TrellisVariants.VineCrops) {
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                    .add(TrellisUtil.getCropTrellisFromVariant(trellis, crop))
            ;
        }
        for (DecorativeVine vine : TrellisVariants.DecorativeVines) {
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                    .add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine))
            ;
        }
    }
}
