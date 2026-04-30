package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class BFItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public BFItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {

        getOrCreateTagBuilder(BFItemTags.C_FLOUR)
                .add(BFItems.FLOUR.get())
        ;
        getOrCreateTagBuilder(BFItemTags.C_MILKS)
                .add(Items.MILK_BUCKET)
                .add(BFItems.COCONUT_MILK_BOTTLE.get())
        ;
        getOrCreateTagBuilder(BFItemTags.C_COCONUTS)
                .add(BFItems.COCONUT.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("wilderwild", "coconut"))
        ;

        getOrCreateTagBuilder(BFItemTags.C_COCONUT_HALVES)
                .add(BFItems.COCONUT_HALF.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut_half"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("wilderwild", "split_coconut"))
        ;


        getOrCreateTagBuilder(BFItemTags.C_WALNUTS)
                .add(BFItems.WALNUT.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("nomansland", "walnuts"))
        ;

        getOrCreateTagBuilder(BFItemTags.C_ORANGES)
                .add(BFItems.ORANGE.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("atmospheric", "orange"))
                .addOptional(ResourceLocation.fromNamespaceAndPath("atmospheric", "blood_orange"))
        ;

        getOrCreateTagBuilder(BFItemTags.C_LEMONS)
                .add(BFItems.LEMON.get())
        ;

        getOrCreateTagBuilder(BFItemTags.C_PLUMS)
                .add(BFItems.PLUM.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("environmental", "plum"))
        ;

        getOrCreateTagBuilder(BFItemTags.C_PASSION_FRUIT)
                .add(BFItems.PASSION_FRUIT.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("atmospheric", "passion_fruit"))
        ;

        getOrCreateTagBuilder(BFItemTags.C_ELDERBERRIES)
                .add(BFItems.ELDERBERRIES.get())
        ;

        getOrCreateTagBuilder(BFItemTags.C_CORN)
                .add(BFItems.MAIZE.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("hauntedharvest", "corn"))
        ;

        getOrCreateTagBuilder(ItemTags.CHICKEN_FOOD)
                .add(BFItems.GRASS_SEEDS.get())
                .add(BFItems.SWEET_BERRY_PIPS.get())
                .add(BFItems.HOARY_SEEDS.get())
                .add(BFItems.LAPISBERRY_SEEDS.get())
                .add(BFItems.LEEK_SEEDS.get())
                .add(BFItems.MAIZE_SEEDS.get())
                .add(BFItems.SPONGEKIN_SEEDS.get())
        ;

        getOrCreateTagBuilder(ItemTags.PARROT_FOOD)
                .add(BFItems.GRASS_SEEDS.get())
                .add(BFItems.SWEET_BERRY_PIPS.get())
                .add(BFItems.HOARY_SEEDS.get())
                .add(BFItems.LAPISBERRY_SEEDS.get())
                .add(BFItems.LEEK_SEEDS.get())
                .add(BFItems.MAIZE_SEEDS.get())
                .add(BFItems.SPONGEKIN_SEEDS.get())
                .add(BFItems.WALNUT.get())
                .add(BFItems.ARTISAN_COOKIE.get())
                .add(BFItems.WALNUT_COOKIE.get())
        ;

        getOrCreateTagBuilder(ItemTags.PIG_FOOD)
                .add(BFItems.MAIZE.get())
                .add(BFItems.LEEK.get())
        ;

        getOrCreateTagBuilder(ItemTags.SNIFFER_FOOD)
                .add(Items.PITCHER_POD)
                .add(BFItems.HOARY_SEEDS.get())
                .add(BFItems.LAPISBERRY_SEEDS.get())
        ;

        getOrCreateTagBuilder(ItemTags.FOX_FOOD)
                .add(BFItems.ELDERBERRIES.get())
                .add(BFItems.LAPISBERRIES.get())
        ;

        getOrCreateTagBuilder(ItemTags.COW_FOOD)
                .add(BFItems.MAIZE.get())
        ;

        getOrCreateTagBuilder(ItemTags.SHEEP_FOOD)
                .add(BFItems.MAIZE.get())
        ;

        getOrCreateTagBuilder(ItemTags.GOAT_FOOD)
                .add(BFItems.MAIZE.get())
        ;

        getOrCreateTagBuilder(ItemTags.WOLF_FOOD)
                .addTag(BFItemTags.MULCH)
        ;

        getOrCreateTagBuilder(ItemTags.HORSE_FOOD)
                .add(BFItems.ORANGE.get())
                .add(BFItems.LEMON.get())
                .add(BFItems.PLUM.get())
                .add(BFItems.HOARY_APPLE.get())
                .add(BFItems.MAIZE.get())
        ;

        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(BFBlocks.FLOWERING_APPLE_LEAVES.get().asItem())
                .add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get().asItem())
                .add(BFBlocks.FLOWERING_ORANGE_LEAVES.get().asItem())
                .add(BFBlocks.FLOWERING_LEMON_LEAVES.get().asItem())
                .add(BFBlocks.FLOWERING_PLUM_LEAVES.get().asItem())
        ;
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(BFBlocks.HOARY_FENCE_GATE.get().asItem());
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS).add(BFBlocks.HONEYSUCKLE.get().asItem(), BFBlocks.VIOLET_BELLFLOWER.get().asItem());
        getOrCreateTagBuilder(ItemTags.LEAVES)
                .addTag(BFItemTags.APPLE_LEAVES)
                .add(BFBlocks.GOLDEN_APPLE_LEAVES.get().asItem())
                .add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get().asItem())
                .addTag(BFItemTags.ORANGE_LEAVES)
                .addTag(BFItemTags.LEMON_LEAVES)
                .addTag(BFItemTags.PLUM_LEAVES)
                .addTag(BFItemTags.GOLDEN_APPLE_LEAVES)
                .add(BFBlocks.HOARY_LEAVES.get().asItem())
                .add(BFBlocks.WALNUT_LEAVES.get().asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .addTag(BFItemTags.APPLE_LOGS)
                .addTag(BFItemTags.ORANGE_LOGS)
                .addTag(BFItemTags.LEMON_LOGS)
                .addTag(BFItemTags.PLUM_LOGS)
                .addTag(BFItemTags.HOARY_LOGS)
                .addTag(BFItemTags.WALNUT_LOGS)
                .addTag(BFItemTags.PALM_LOGS)
                .addTag(BFItemTags.GOLDEN_APPLE_LOGS);
        getOrCreateTagBuilder(ItemTags.PLANKS).add(BFBlocks.HOARY_PLANKS.get().asItem(), BFBlocks.WALNUT_PLANKS.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(BFBlocks.HOARY_BUTTON.get().asItem(), BFBlocks.WALNUT_BUTTON.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(BFBlocks.HOARY_DOOR.get().asItem(), BFBlocks.WALNUT_DOOR.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(BFBlocks.HOARY_FENCE.get().asItem(), BFBlocks.WALNUT_FENCE.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(BFBlocks.HOARY_PRESSURE_PLATE.get().asItem(), BFBlocks.WALNUT_PRESSURE_PLATE.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(BFBlocks.HOARY_SLAB.get().asItem(), BFBlocks.WALNUT_SLAB.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(BFBlocks.HOARY_STAIRS.get().asItem(), BFBlocks.WALNUT_STAIRS.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(BFBlocks.HOARY_TRAPDOOR.get().asItem(), BFBlocks.WALNUT_TRAPDOOR.get().asItem());
        getOrCreateTagBuilder(ItemTags.BUTTONS).add(BFBlocks.CERAMIC_BUTTON.get().asItem());

        getOrCreateTagBuilder(ItemTags.STAIRS)
                .add(BFBlocks.COIR_BRICK_STAIRS.get().asItem())
                .add(BFBlocks.FELDSPAR_BRICK_STAIRS.get().asItem())
                .add(BFBlocks.CERAMIC_TILE_STAIRS.get().asItem())
                .add(BFBlocks.CERAMIC_MOSAIC_STAIRS.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get().asItem())
        ;
        getOrCreateTagBuilder(ItemTags.SLABS)
                .add(BFBlocks.COIR_BRICK_SLAB.get().asItem())
                .add(BFBlocks.FELDSPAR_BRICK_SLAB.get().asItem())
                .add(BFBlocks.CERAMIC_TILE_SLAB.get().asItem())
                .add(BFBlocks.CERAMIC_MOSAIC_SLAB.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get().asItem())
        ;
        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(BFBlocks.COIR_BRICK_WALL.get().asItem())
                .add(BFBlocks.FELDSPAR_BRICK_WALL.get().asItem())
        //.add(BFBlocks.CERAMIC_TILE_WALL.asItem())
        //.add(BFBlocks.CERAMIC_MOSAIC_WALL.asItem())
        //.add(BFBlocks.CHECKERED_CERAMIC_TILE_WALL.asItem())
        //.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.CANDLES)
                .add(BFBlocks.GREEN_TEA_CANDLE.get().asItem())
                .add(BFBlocks.BLACK_TEA_CANDLE.get().asItem())
                .add(BFBlocks.CHAMOMILE_CANDLE.get().asItem())
                .add(BFBlocks.HONEYSUCKLE_CANDLE.get().asItem())
                .add(BFBlocks.BELLFLOWER_CANDLE.get().asItem())
                .add(BFBlocks.TORCHFLOWER_CANDLE.get().asItem())
                .add(BFBlocks.WALNUT_CANDLE.get().asItem())
                .add(BFBlocks.COCONUT_CANDLE.get().asItem());

        getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
                .add(BFBlocks.GOLDEN_APPLE_BLOCK.get().asItem())
                .add(BFBlocks.GOLDEN_APPLE_LEAVES.get().asItem())
                .add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get().asItem());

        getOrCreateTagBuilder(ItemTags.DYEABLE)
                .add(BFBlocks.CERAMIC_TILES.get().asItem())
                .add(BFBlocks.CERAMIC_TILE_STAIRS.get().asItem())
                .add(BFBlocks.CERAMIC_TILE_SLAB.get().asItem())
                //.add(BFBlocks.CERAMIC_TILE_WALL.asItem())
                .add(BFBlocks.CRACKED_CERAMIC_TILES.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILES.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get().asItem())
                //.add(BFBlocks.CHECKERED_CERAMIC_TILE_WALL.asItem())
                .add(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get().asItem())
                .add(BFBlocks.CERAMIC_TILE_PILLAR.get().asItem())
                .add(BFBlocks.CERAMIC_MOSAIC.get().asItem())
                .add(BFBlocks.CERAMIC_MOSAIC_STAIRS.get().asItem())
                .add(BFBlocks.CERAMIC_MOSAIC_SLAB.get().asItem())
                //.add(BFBlocks.CERAMIC_MOSAIC_WALL.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get().asItem())
                //.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL.asItem())
                .add(BFBlocks.CERAMIC_DOOR.get().asItem())
                .add(BFBlocks.CERAMIC_TRAPDOOR.get().asItem())
                .add(BFBlocks.CERAMIC_BUTTON.get().asItem())
                .add(BFBlocks.CERAMIC_PRESSURE_PLATE.get().asItem())
                .add(BFBlocks.CERAMIC_LEVER.get().asItem())
                .add(BFBlocks.CERAMIC_DISH.get().asItem())
                .add(BFBlocks.CERAMIC_CHEST.get().asItem())
                .add(BFBlocks.SOLID_CERAMIC.get().asItem())
                .add(BFItems.ARTISAN_BRUSH.get().asItem())
        ;

        getOrCreateTagBuilder(BFItemTags.APPLE_LEAVES).add(BFBlocks.APPLE_LEAVES.get().asItem(), BFBlocks.FLOWERING_APPLE_LEAVES.get().asItem());
        getOrCreateTagBuilder(BFItemTags.ORANGE_LEAVES).add(BFBlocks.ORANGE_LEAVES.get().asItem(), BFBlocks.FLOWERING_ORANGE_LEAVES.get().asItem());
        getOrCreateTagBuilder(BFItemTags.LEMON_LEAVES).add(BFBlocks.LEMON_LEAVES.get().asItem(), BFBlocks.FLOWERING_LEMON_LEAVES.get().asItem());
        getOrCreateTagBuilder(BFItemTags.PLUM_LEAVES).add(BFBlocks.PLUM_LEAVES.get().asItem(), BFBlocks.FLOWERING_PLUM_LEAVES.get().asItem());
        getOrCreateTagBuilder(BFItemTags.GOLDEN_APPLE_LEAVES).add(BFBlocks.GOLDEN_APPLE_LEAVES.get().asItem(), BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get().asItem());
        getOrCreateTagBuilder(BFItemTags.APPLE_LOGS)
                .add(BFBlocks.APPLE_LOG.get().asItem())
                .add(BFBlocks.STRIPPED_APPLE_LOG.get().asItem())
                .add(BFBlocks.APPLE_WOOD.get().asItem())
                .add(BFBlocks.STRIPPED_APPLE_WOOD.get().asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.ORANGE_LOGS)
                .add(BFBlocks.ORANGE_LOG.get().asItem())
                .add(BFBlocks.STRIPPED_ORANGE_LOG.get().asItem())
                .add(BFBlocks.ORANGE_WOOD.get().asItem())
                .add(BFBlocks.STRIPPED_ORANGE_WOOD.get().asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.LEMON_LOGS)
                .add(BFBlocks.LEMON_LOG.get().asItem())
                .add(BFBlocks.STRIPPED_LEMON_LOG.get().asItem())
                .add(BFBlocks.LEMON_WOOD.get().asItem())
                .add(BFBlocks.STRIPPED_LEMON_WOOD.get().asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.PLUM_LOGS)
                .add(BFBlocks.PLUM_LOG.get().asItem())
                .add(BFBlocks.STRIPPED_PLUM_LOG.get().asItem())
                .add(BFBlocks.PLUM_WOOD.get().asItem())
                .add(BFBlocks.STRIPPED_PLUM_WOOD.get().asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.HOARY_LOGS)
                .add(BFBlocks.HOARY_LOG.get().asItem())
                .add(BFBlocks.STRIPPED_HOARY_LOG.get().asItem())
                .add(BFBlocks.HOARY_WOOD.get().asItem())
                .add(BFBlocks.STRIPPED_HOARY_WOOD.get().asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.PALM_LOGS)
                .add(BFBlocks.PALM_LOG.get().asItem())
                .add(BFBlocks.STRIPPED_PALM_LOG.get().asItem())
                .add(BFBlocks.PALM_WOOD.get().asItem())
                .add(BFBlocks.STRIPPED_PALM_WOOD.get().asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.GOLDEN_APPLE_LOGS)
                .add(BFBlocks.GOLDEN_APPLE_LOG.get().asItem())
                .add(BFBlocks.GOLDEN_APPLE_WOOD.get().asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.WALNUT_LOGS)
                .add(BFBlocks.WALNUT_LOG.get().asItem())
                .add(BFBlocks.STRIPPED_WALNUT_LOG.get().asItem())
                .add(BFBlocks.WALNUT_WOOD.get().asItem())
                .add(BFBlocks.STRIPPED_WALNUT_WOOD.get().asItem())
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
                .add(BFBlocks.CERAMIC_TILES.get().asItem())
                .add(BFBlocks.CERAMIC_TILE_STAIRS.get().asItem())
                .add(BFBlocks.CERAMIC_TILE_SLAB.get().asItem())
                //.add(BFBlocks.CERAMIC_TILE_WALL.asItem())
                .add(BFBlocks.CRACKED_CERAMIC_TILES.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILES.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get().asItem())
                //.add(BFBlocks.CHECKERED_CERAMIC_TILE_WALL.asItem())
                .add(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get().asItem())
                .add(BFBlocks.CERAMIC_TILE_PILLAR.get().asItem())
                .add(BFBlocks.CERAMIC_MOSAIC.get().asItem())
                .add(BFBlocks.CERAMIC_MOSAIC_STAIRS.get().asItem())
                .add(BFBlocks.CERAMIC_MOSAIC_SLAB.get().asItem())
                //.add(BFBlocks.CERAMIC_MOSAIC_WALL.asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get().asItem())
                .add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get().asItem())
                //.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL.asItem())
                .add(BFBlocks.CERAMIC_DOOR.get().asItem())
                .add(BFBlocks.CERAMIC_TRAPDOOR.get().asItem())
                .add(BFBlocks.CERAMIC_PRESSURE_PLATE.get().asItem())
                .add(BFBlocks.CERAMIC_BUTTON.get().asItem())
                .add(BFBlocks.CERAMIC_LEVER.get().asItem())
                .add(BFBlocks.CERAMIC_DISH.get().asItem())
                .add(BFBlocks.CERAMIC_CHEST.get().asItem())
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
                .add(BFItems.PASSION_FRUIT.get())
                .add(BFItems.ELDERBERRIES.get())
                .add(Items.GLOW_BERRIES)
                .add(BFItems.LAPISBERRY_SEEDS.get())
        ;
        getOrCreateTagBuilder(BFItemTags.COOKED_FISHES)
                .add(Items.COOKED_COD)
                .add(Items.COOKED_SALMON)
                .addOptional(ResourceLocation.fromNamespaceAndPath(BountifulFares.NO_MANS_LAND_MOD_ID, "cooked_billhook_bass"))
        ;
        getOrCreateTagBuilder(BFItemTags.MEALS)
                .add(BFItems.MUSHROOM_STUFFED_POTATO.get())
                .add(BFItems.BERRY_STUFFED_POTATO.get())
                .add(BFItems.MAIZE_STUFFED_POTATO.get())
                .add(BFItems.STUFFED_HOARY_APPLE.get())
                .add(BFItems.COCONUT_CRUSTED_COD.get())
                .add(BFItems.PASSION_GLAZED_SALMON.get())
                .add(BFItems.LEEK_STEW.get())
                .add(BFItems.FISH_STEW.get())
                .add(BFItems.APPLE_STEW.get())
                .add(BFItems.COCONUT_STEW.get())
                .add(BFItems.STONE_STEW.get())
                .add(BFItems.BOUNTIFUL_STEW.get())
                .add(BFItems.SEA_SALAD.get())
                .add(BFItems.FOREST_MEDLEY.get())
                .add(BFItems.ARID_MEDLEY.get())
                .add(BFItems.MEADOW_MEDLEY.get())
                .add(BFItems.MIRE_MEDLEY.get())
                .add(BFItems.COASTAL_MEDLEY.get())
                .add(BFItems.TROPICAL_MEDLEY.get())
                .add(BFItems.CRUSTED_BEEF.get())
                .add(BFItems.CRIMSON_CHOW.get())
                .add(BFItems.WARPED_CHOW.get())
//                .add(BFItems.CUSTARD.get())
//                .add(BFItems.PIQUANT_CUSTARD.get())
//                .add(BFItems.PASSION_CUSTARD.get())
//                .add(BFItems.COCOA_CUSTARD.get())
//                .add(BFItems.ANCIENT_CUSTARD.get())
        ;
        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(BFBlocks.APPLE_SAPLING.get().asItem())
                .add(BFBlocks.GOLDEN_APPLE_SAPLING.get().asItem())
                .add(BFBlocks.ORANGE_SAPLING.get().asItem())
                .add(BFBlocks.LEMON_SAPLING.get().asItem())
                .add(BFBlocks.PLUM_SAPLING.get().asItem())
                .add(BFBlocks.HOARY_APPLE_SAPLING.get().asItem())
                .add(BFBlocks.WALNUT_SAPLING.get().asItem())
        ;
        getOrCreateTagBuilder(ItemTags.DIRT)
                .add(BFBlocks.GRASSY_DIRT.get().asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.GRASS_SEEDS_PLANTABLE_ON)
                .add(Items.DIRT)
                .add(Items.COARSE_DIRT)
                .add(Items.ROOTED_DIRT)
                .add(Items.PODZOL)
                .add(Items.MYCELIUM)
        ;

        getOrCreateTagBuilder(BFItemTags.VINE_CROPS)
                .add(BFItems.PASSION_FRUIT.get())
                .add(BFItems.ELDERBERRIES.get())
                .add(Items.GLOW_BERRIES)
                .add(BFItems.LAPISBERRIES.get())
        ;

        getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(BFItems.LEEK_SEEDS.get())
                .add(BFItems.MAIZE_SEEDS.get())
        ;

        for (Supplier<Block> block : BFBlocks.PICKETS.values()) {
            getOrCreateTagBuilder(BFItemTags.PICKETS).add(block.get().asItem());
        }

        getOrCreateTagBuilder(BFItemTags.MULCH)
                .add(BFBlocks.WALNUT_MULCH.get().asItem())
                .add(BFBlocks.WALNUT_MULCH_BLOCK.get().asItem())
                .add(BFBlocks.PALM_MULCH.get().asItem())
                .add(BFBlocks.PALM_MULCH_BLOCK.get().asItem())
        ;

        getOrCreateTagBuilder(BFItemTags.SUGAR_INGREDIENTS)
                .add(Items.SUGAR)
                .add(Items.HONEY_BOTTLE)
        ;

        getOrCreateTagBuilder(ItemTags.DIRT)
                .add(BFBlocks.WALNUT_MULCH_BLOCK.get().asItem())
                .add(BFBlocks.PALM_MULCH_BLOCK.get().asItem());

        getOrCreateTagBuilder(BFItemTags.FOOD_CONTAINERS_TIFFINS_CAN_HOLD)
                .add(Items.BOWL)
        ;

        getOrCreateTagBuilder(BFItemTags.FERMENTATION_WATER_SOURCES)
                .add(Items.POTION)
                .add(Items.WATER_BUCKET)
                .add(BFItems.WATER_CUP.get())
                .addOptional(ResourceLocation.fromNamespaceAndPath("miners_delight", "water_cup"))
        ;

        // Adds all tiffins automatically
        List<ResourceKey<Item>> tiffins = new ArrayList<>();
        for (Supplier<Item> item : BFItems.TIFFINS.values()) {
            Optional<ResourceKey<Item>> key = BuiltInRegistries.ITEM.getResourceKey(item.get());
            key.ifPresent(tiffins::add);
        }
        getOrCreateTagBuilder(BFItemTags.TIFFINS)
                .addAll(tiffins)
                .addOptional(BountifulFares.id("coral_shulker_tiffin"))
                .addOptional(BountifulFares.id("umber_shulker_tiffin"))
                .addOptional(BountifulFares.id("canary_shulker_tiffin"))
                .addOptional(BountifulFares.id("wasabi_shulker_tiffin"))
                .addOptional(BountifulFares.id("sacramento_shulker_tiffin"))
                .addOptional(BountifulFares.id("sky_shulker_tiffin"))
                .addOptional(BountifulFares.id("blurple_shulker_tiffin"))
                .addOptional(BountifulFares.id("lavender_shulker_tiffin"))
                .addOptional(BountifulFares.id("sangria_shulker_tiffin"))
                .addOptional(BountifulFares.id("rose_shulker_tiffin"))
        ;

        getOrCreateTagBuilder(BFItemTags.CERAMIC_DISH_BLACKLIST)
                .addOptional(ResourceLocation.fromNamespaceAndPath("supplementaries", "lunch_basket"))
        ;

        getOrCreateTagBuilder(BFItemTags.SPONGEKIN_INGREDIENTS)
                .add(BFItems.SPONGEKIN_SLICE.get())
                .add(BFItems.PICKLED_SPONGEKIN.get())
        ;

        getOrCreateTagBuilder(BFItemTags.BEETROOT_INGREDIENTS)
                .add(BFItems.PICKLED_BEETROOT.get())
                .add(Items.BEETROOT)
        ;

        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("dungeonsdelight", "fleshes")))
                .add(BFItems.FOUL_FLESH.get())
        ;

        getOrCreateTagBuilder(TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("supplementaries", "lunch_basket_blacklist")))
                .addTag(BFItemTags.TIFFINS)
        ;
    }
}