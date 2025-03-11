package net.hecco.bountifulfares.datagen.bountifulfares;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class BFItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public BFItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BFItemTags.C_FLOUR)
                .add(BFItems.FLOUR)
        ;
        getOrCreateTagBuilder(BFItemTags.C_MILKS)
                .add(Items.MILK_BUCKET)
                .add(BFItems.COCONUT_MILK_BOTTLE)
        ;
        getOrCreateTagBuilder(BFItemTags.C_COCONUT_HALVES)
                .add(BFItems.COCONUT_HALF)
        ;

        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(BFBlocks.FLOWERING_APPLE_LEAVES.asItem())
                .add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.asItem())
                .add(BFBlocks.FLOWERING_ORANGE_LEAVES.asItem())
                .add(BFBlocks.FLOWERING_LEMON_LEAVES.asItem())
                .add(BFBlocks.FLOWERING_PLUM_LEAVES.asItem())
        ;
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(BFBlocks.HOARY_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS).add(BFBlocks.HONEYSUCKLE.asItem(), BFBlocks.VIOLET_BELLFLOWER.asItem());
        getOrCreateTagBuilder(ItemTags.LEAVES)
                .addTag(BFItemTags.APPLE_LEAVES)
                .add(BFBlocks.GOLDEN_APPLE_LEAVES.asItem())
                .add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.asItem())
                .addTag(BFItemTags.ORANGE_LEAVES)
                .addTag(BFItemTags.LEMON_LEAVES)
                .addTag(BFItemTags.PLUM_LEAVES)
                .addTag(BFItemTags.GOLDEN_APPLE_LEAVES)
                .add(BFBlocks.HOARY_LEAVES.asItem())
                .add(BFBlocks.WALNUT_LEAVES.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .addTag(BFItemTags.APPLE_LOGS)
                .addTag(BFItemTags.ORANGE_LOGS)
                .addTag(BFItemTags.LEMON_LOGS)
                .addTag(BFItemTags.PLUM_LOGS)
                .addTag(BFItemTags.HOARY_LOGS)
                .addTag(BFItemTags.WALNUT_LOGS)
                .addTag(BFItemTags.PALM_LOGS)
                .addTag(BFItemTags.GOLDEN_APPLE_LOGS);
        getOrCreateTagBuilder(ItemTags.PLANKS).add(BFBlocks.HOARY_PLANKS.asItem(), BFBlocks.WALNUT_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(BFBlocks.HOARY_BUTTON.asItem(), BFBlocks.WALNUT_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(BFBlocks.HOARY_DOOR.asItem(), BFBlocks.WALNUT_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(BFBlocks.HOARY_FENCE.asItem(), BFBlocks.WALNUT_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(BFBlocks.HOARY_PRESSURE_PLATE.asItem(), BFBlocks.WALNUT_PRESSURE_PLATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(BFBlocks.HOARY_SLAB.asItem(), BFBlocks.WALNUT_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(BFBlocks.HOARY_STAIRS.asItem(), BFBlocks.WALNUT_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(BFBlocks.HOARY_TRAPDOOR.asItem(), BFBlocks.WALNUT_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.BUTTONS).add(BFBlocks.CERAMIC_BUTTON.asItem());


        getOrCreateTagBuilder(ItemTags.CANDLES)
                .add(BFBlocks.GREEN_TEA_CANDLE.asItem())
                .add(BFBlocks.BLACK_TEA_CANDLE.asItem())
                .add(BFBlocks.CHAMOMILE_CANDLE.asItem())
                .add(BFBlocks.HONEYSUCKLE_CANDLE.asItem())
                .add(BFBlocks.BELLFLOWER_CANDLE.asItem())
                .add(BFBlocks.TORCHFLOWER_CANDLE.asItem())
                .add(BFBlocks.WALNUT_CANDLE.asItem())
                .add(BFBlocks.COCONUT_CANDLE.asItem());

        getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
                .add(BFBlocks.GOLDEN_APPLE_BLOCK.asItem())
                .add(BFBlocks.GOLDEN_APPLE_LEAVES.asItem())
                .add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.asItem());

        getOrCreateTagBuilder(ItemTags.DYEABLE)
                .add(BFBlocks.CERAMIC_TILES.asItem())
                .add(BFBlocks.CERAMIC_TILE_STAIRS.asItem())
                .add(BFBlocks.CERAMIC_TILE_SLAB.asItem())
                .add(BFBlocks.CRACKED_CERAMIC_TILES.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILES.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.asItem())
                .add(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.asItem())
                .add(BFBlocks.CERAMIC_TILE_PILLAR.asItem())
                .add(BFBlocks.CERAMIC_MOSAIC.asItem())
                .add(BFBlocks.CERAMIC_MOSAIC_STAIRS.asItem())
                .add(BFBlocks.CERAMIC_MOSAIC_SLAB.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.asItem())
                .add(BFBlocks.CERAMIC_DOOR.asItem())
                .add(BFBlocks.CERAMIC_TRAPDOOR.asItem())
                .add(BFBlocks.CERAMIC_BUTTON.asItem())
                .add(BFBlocks.CERAMIC_PRESSURE_PLATE.asItem())
                .add(BFBlocks.CERAMIC_LEVER.asItem())
                .add(BFBlocks.CERAMIC_DISH.asItem())
                .add(BFItems.ARTISAN_BRUSH.asItem())
        ;

        getOrCreateTagBuilder(BFItemTags.APPLE_LEAVES).add(BFBlocks.APPLE_LEAVES.asItem(), BFBlocks.FLOWERING_APPLE_LEAVES.asItem());
        getOrCreateTagBuilder(BFItemTags.ORANGE_LEAVES).add(BFBlocks.ORANGE_LEAVES.asItem(), BFBlocks.FLOWERING_ORANGE_LEAVES.asItem());
        getOrCreateTagBuilder(BFItemTags.LEMON_LEAVES).add(BFBlocks.LEMON_LEAVES.asItem(), BFBlocks.FLOWERING_LEMON_LEAVES.asItem());
        getOrCreateTagBuilder(BFItemTags.PLUM_LEAVES).add(BFBlocks.PLUM_LEAVES.asItem(), BFBlocks.FLOWERING_PLUM_LEAVES.asItem());
        getOrCreateTagBuilder(BFItemTags.GOLDEN_APPLE_LEAVES).add(BFBlocks.GOLDEN_APPLE_LEAVES.asItem(), BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.asItem());
        getOrCreateTagBuilder(BFItemTags.APPLE_LOGS)
                .add(BFBlocks.APPLE_LOG.asItem())
                .add(BFBlocks.STRIPPED_APPLE_LOG.asItem())
                .add(BFBlocks.APPLE_WOOD.asItem())
                .add(BFBlocks.STRIPPED_APPLE_WOOD.asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.ORANGE_LOGS)
                .add(BFBlocks.ORANGE_LOG.asItem())
                .add(BFBlocks.STRIPPED_ORANGE_LOG.asItem())
                .add(BFBlocks.ORANGE_WOOD.asItem())
                .add(BFBlocks.STRIPPED_ORANGE_WOOD.asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.LEMON_LOGS)
                .add(BFBlocks.LEMON_LOG.asItem())
                .add(BFBlocks.STRIPPED_LEMON_LOG.asItem())
                .add(BFBlocks.LEMON_WOOD.asItem())
                .add(BFBlocks.STRIPPED_LEMON_WOOD.asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.PLUM_LOGS)
                .add(BFBlocks.PLUM_LOG.asItem())
                .add(BFBlocks.STRIPPED_PLUM_LOG.asItem())
                .add(BFBlocks.PLUM_WOOD.asItem())
                .add(BFBlocks.STRIPPED_PLUM_WOOD.asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.HOARY_LOGS)
                .add(BFBlocks.HOARY_LOG.asItem())
                .add(BFBlocks.STRIPPED_HOARY_LOG.asItem())
                .add(BFBlocks.HOARY_WOOD.asItem())
                .add(BFBlocks.STRIPPED_HOARY_WOOD.asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.PALM_LOGS)
                .add(BFBlocks.PALM_LOG.asItem())
                .add(BFBlocks.STRIPPED_PALM_LOG.asItem())
                .add(BFBlocks.PALM_WOOD.asItem())
                .add(BFBlocks.STRIPPED_PALM_WOOD.asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.GOLDEN_APPLE_LOGS)
                .add(BFBlocks.GOLDEN_APPLE_LOG.asItem())
                .add(BFBlocks.GOLDEN_APPLE_WOOD.asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.WALNUT_LOGS)
                .add(BFBlocks.WALNUT_LOG.asItem())
                .add(BFBlocks.STRIPPED_WALNUT_LOG.asItem())
                .add(BFBlocks.WALNUT_WOOD.asItem())
                .add(BFBlocks.STRIPPED_WALNUT_WOOD.asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.FRUIT_LOGS)
                .addTag(BFItemTags.APPLE_LOGS)
                .addTag(BFItemTags.GOLDEN_APPLE_LOGS)
                .addTag(BFItemTags.ORANGE_LOGS)
                .addTag(BFItemTags.LEMON_LOGS)
                .addTag(BFItemTags.PLUM_LOGS)
                .addTag(BFItemTags.PALM_LOGS)
        ;
        getOrCreateTagBuilder(BFItemTags.DYEABLE_CERAMIC_BLOCKS)
                .add(BFBlocks.CERAMIC_TILES.asItem())
                .add(BFBlocks.CERAMIC_TILE_STAIRS.asItem())
                .add(BFBlocks.CERAMIC_TILE_SLAB.asItem())
                .add(BFBlocks.CRACKED_CERAMIC_TILES.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILES.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.asItem())
                .add(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.asItem())
                .add(BFBlocks.CERAMIC_TILE_PILLAR.asItem())
                .add(BFBlocks.CERAMIC_MOSAIC.asItem())
                .add(BFBlocks.CERAMIC_MOSAIC_STAIRS.asItem())
                .add(BFBlocks.CERAMIC_MOSAIC_SLAB.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.asItem())
                .add(BFBlocks.CERAMIC_DOOR.asItem())
                .add(BFBlocks.CERAMIC_TRAPDOOR.asItem())
                .add(BFBlocks.CERAMIC_PRESSURE_PLATE.asItem())
                .add(BFBlocks.CERAMIC_BUTTON.asItem())
                .add(BFBlocks.CERAMIC_LEVER.asItem())
                .add(BFBlocks.CERAMIC_DISH.asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.FELSIC_STONES)
                .add(Items.ANDESITE)
                .add(Items.GRANITE)
                .add(Items.DIORITE)
                .add(Items.TUFF)
        ;
        getOrCreateTagBuilder(BFItemTags.JACK_O_STRAW_LIGHTABLE)
                .addTag(ItemTags.CANDLES)
                .add(Items.TORCH)
        ;

        getOrCreateTagBuilder(BFItemTags.VINE_CROP_SEEDS)
                .add(BFItems.PASSION_FRUIT)
                .add(BFItems.ELDERBERRIES)
                .add(Items.GLOW_BERRIES)
                .add(BFItems.LAPISBERRY_SEEDS)
        ;
        getOrCreateTagBuilder(BFItemTags.COOKED_FISHES)
                .add(Items.COOKED_COD)
                .add(Items.COOKED_SALMON)
        ;
        getOrCreateTagBuilder(BFItemTags.MEALS)
                .add(BFItems.MUSHROOM_STUFFED_POTATO)
                .add(BFItems.BERRY_STUFFED_POTATO)
                .add(BFItems.MAIZE_STUFFED_POTATO)
                .add(BFItems.STUFFED_HOARY_APPLE)
                .add(BFItems.COCONUT_CRUSTED_COD)
                .add(BFItems.PASSION_GLAZED_SALMON)
                .add(BFItems.LEEK_STEW)
                .add(BFItems.FISH_STEW)
                .add(BFItems.APPLE_STEW)
                .add(BFItems.COCONUT_STEW)
                .add(BFItems.STONE_STEW)
                .add(BFItems.BOUNTIFUL_STEW)
                .add(BFItems.SEA_SALAD)
                .add(BFItems.FOREST_MEDLEY)
                .add(BFItems.ARID_MEDLEY)
                .add(BFItems.MEADOW_MEDLEY)
                .add(BFItems.MIRE_MEDLEY)
                .add(BFItems.COASTAL_MEDLEY)
                .add(BFItems.TROPICAL_MEDLEY)
                .add(BFItems.CRUSTED_BEEF)
                .add(BFItems.CRIMSON_CHOW)
                .add(BFItems.WARPED_CHOW)
                .add(BFItems.CUSTARD)
                .add(BFItems.PIQUANT_CUSTARD)
                .add(BFItems.PASSION_CUSTARD)
                .add(BFItems.COCOA_CUSTARD)
                .add(BFItems.ANCIENT_CUSTARD)
        ;
        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(BFBlocks.APPLE_SAPLING.asItem())
                .add(BFBlocks.GOLDEN_APPLE_SAPLING.asItem())
                .add(BFBlocks.ORANGE_SAPLING.asItem())
                .add(BFBlocks.LEMON_SAPLING.asItem())
                .add(BFBlocks.PLUM_SAPLING.asItem())
                .add(BFBlocks.HOARY_APPLE_SAPLING.asItem())
                .add(BFBlocks.WALNUT_SAPLING.asItem())
        ;
        getOrCreateTagBuilder(ItemTags.DIRT)
                .add(BFBlocks.GRASSY_DIRT.asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.GRASS_SEEDS_PLANTABLE_ON)
                .add(Items.DIRT)
                .add(Items.COARSE_DIRT)
                .add(Items.ROOTED_DIRT)
                .add(Items.PODZOL)
                .add(Items.MYCELIUM)
        ;

        getOrCreateTagBuilder(BFItemTags.PICKETS)
                .add(BFBlocks.ACACIA_PICKETS.asItem())
                .add(BFBlocks.BAMBOO_PICKETS.asItem())
                .add(BFBlocks.BIRCH_PICKETS.asItem())
                .add(BFBlocks.CHERRY_PICKETS.asItem())
                .add(BFBlocks.CRIMSON_PICKETS.asItem())
                .add(BFBlocks.DARK_OAK_PICKETS.asItem())
                .add(BFBlocks.HOARY_PICKETS.asItem())
                .add(BFBlocks.JUNGLE_PICKETS.asItem())
                .add(BFBlocks.MANGROVE_PICKETS.asItem())
                .add(BFBlocks.OAK_PICKETS.asItem())
                .add(BFBlocks.SPRUCE_PICKETS.asItem())
                .add(BFBlocks.WALNUT_PICKETS.asItem())
                .add(BFBlocks.WARPED_PICKETS.asItem())
        ;

        getOrCreateTagBuilder(BFItemTags.MULCH)
                .add(BFBlocks.WALNUT_MULCH.asItem())
                .add(BFBlocks.WALNUT_MULCH_BLOCK.asItem())
                .add(BFBlocks.PALM_MULCH.asItem())
                .add(BFBlocks.PALM_MULCH_BLOCK.asItem())
        ;

        getOrCreateTagBuilder(BFItemTags.SUGAR_INGREDIENTS)
                .add(Items.SUGAR)
                .add(Items.HONEY_BOTTLE)
        ;

        getOrCreateTagBuilder(ItemTags.DIRT)
                .add(BFBlocks.WALNUT_MULCH_BLOCK.asItem())
                .add(BFBlocks.PALM_MULCH_BLOCK.asItem());
    }
}
