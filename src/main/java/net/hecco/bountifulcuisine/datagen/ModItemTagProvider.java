package net.hecco.bountifulcuisine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.util.ModBlockTags;
import net.hecco.bountifulcuisine.util.ModItemTags;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(ModBlocks.FLOWERING_APPLE_LEAVES.asItem())
                .add(ModBlocks.FLOWERING_ORANGE_LEAVES.asItem())
                .add(ModBlocks.FLOWERING_LEMON_LEAVES.asItem())
                .add(ModBlocks.FLOWERING_PLUM_LEAVES.asItem())
        ;
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(ModBlocks.HOARY_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS).add(ModBlocks.HONEYSUCKLE.asItem(), ModBlocks.VIOLET_BELLFLOWER.asItem());
        getOrCreateTagBuilder(ItemTags.LEAVES)
                .addTag(ModItemTags.APPLE_LEAVES)
                .addTag(ModItemTags.ORANGE_LEAVES)
                .addTag(ModItemTags.LEMON_LEAVES)
                .addTag(ModItemTags.PLUM_LEAVES)
                .add(ModBlocks.HOARY_LEAVES.asItem())
                .add(ModBlocks.WALNUT_LEAVES.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .addTag(ModItemTags.APPLE_LOGS)
                .addTag(ModItemTags.ORANGE_LOGS)
                .addTag(ModItemTags.LEMON_LOGS)
                .addTag(ModItemTags.PLUM_LOGS)
                .addTag(ModItemTags.HOARY_LOGS)
                .addTag(ModItemTags.WALNUT_LOGS);
        getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.HOARY_PLANKS.asItem(), ModBlocks.WALNUT_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(ModBlocks.HOARY_BUTTON.asItem(), ModBlocks.WALNUT_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(ModBlocks.HOARY_DOOR.asItem(), ModBlocks.WALNUT_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(ModBlocks.HOARY_FENCE.asItem(), ModBlocks.WALNUT_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.HOARY_PRESSURE_PLATE.asItem(), ModBlocks.WALNUT_PRESSURE_PLATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(ModBlocks.HOARY_SLAB.asItem(), ModBlocks.WALNUT_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(ModBlocks.HOARY_STAIRS.asItem(), ModBlocks.WALNUT_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.HOARY_TRAPDOOR.asItem(), ModBlocks.WALNUT_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.BUTTONS).add(ModBlocks.CERAMIC_BUTTON.asItem());


        getOrCreateTagBuilder(ItemTags.CANDLES)
                .add(ModBlocks.GREEN_TEA_CANDLE.asItem())
                .add(ModBlocks.BLACK_TEA_CANDLE.asItem())
                .add(ModBlocks.CHAMOMILE_CANDLE.asItem())
                .add(ModBlocks.HONEYSUCKLE_CANDLE.asItem())
                .add(ModBlocks.BELLFLOWER_CANDLE.asItem())
                .add(ModBlocks.TORCHFLOWER_CANDLE.asItem())
                .add(ModBlocks.WALNUT_CANDLE.asItem());

        getOrCreateTagBuilder(ModItemTags.APPLE_LEAVES).add(ModBlocks.APPLE_LEAVES.asItem(), ModBlocks.FLOWERING_APPLE_LEAVES.asItem());
        getOrCreateTagBuilder(ModItemTags.ORANGE_LEAVES).add(ModBlocks.ORANGE_LEAVES.asItem(), ModBlocks.FLOWERING_ORANGE_LEAVES.asItem());
        getOrCreateTagBuilder(ModItemTags.LEMON_LEAVES).add(ModBlocks.LEMON_LEAVES.asItem(), ModBlocks.FLOWERING_LEMON_LEAVES.asItem());
        getOrCreateTagBuilder(ModItemTags.PLUM_LEAVES).add(ModBlocks.PLUM_LEAVES.asItem(), ModBlocks.FLOWERING_PLUM_LEAVES.asItem());
        getOrCreateTagBuilder(ModItemTags.APPLE_LOGS)
                .add(ModBlocks.APPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_APPLE_LOG.asItem())
                .add(ModBlocks.APPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_APPLE_WOOD.asItem())
        ;
        getOrCreateTagBuilder(ModItemTags.ORANGE_LOGS)
                .add(ModBlocks.ORANGE_LOG.asItem())
                .add(ModBlocks.STRIPPED_ORANGE_LOG.asItem())
                .add(ModBlocks.ORANGE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_ORANGE_WOOD.asItem())
        ;
        getOrCreateTagBuilder(ModItemTags.LEMON_LOGS)
                .add(ModBlocks.LEMON_LOG.asItem())
                .add(ModBlocks.STRIPPED_LEMON_LOG.asItem())
                .add(ModBlocks.LEMON_WOOD.asItem())
                .add(ModBlocks.STRIPPED_LEMON_WOOD.asItem())
        ;
        getOrCreateTagBuilder(ModItemTags.PLUM_LOGS)
                .add(ModBlocks.PLUM_LOG.asItem())
                .add(ModBlocks.STRIPPED_PLUM_LOG.asItem())
                .add(ModBlocks.PLUM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PLUM_WOOD.asItem())
        ;
        getOrCreateTagBuilder(ModItemTags.HOARY_LOGS)
                .add(ModBlocks.HOARY_LOG.asItem())
                .add(ModBlocks.STRIPPED_HOARY_LOG.asItem())
                .add(ModBlocks.HOARY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_HOARY_WOOD.asItem())
        ;
        getOrCreateTagBuilder(ModItemTags.WALNUT_LOGS)
                .add(ModBlocks.WALNUT_LOG.asItem())
                .add(ModBlocks.STRIPPED_WALNUT_LOG.asItem())
                .add(ModBlocks.WALNUT_WOOD.asItem())
                .add(ModBlocks.STRIPPED_WALNUT_WOOD.asItem())
        ;
        getOrCreateTagBuilder(ModItemTags.FRUIT_LOGS)
                .addTag(ModItemTags.APPLE_LOGS)
                .addTag(ModItemTags.ORANGE_LOGS)
                .addTag(ModItemTags.LEMON_LOGS)
                .addTag(ModItemTags.PLUM_LOGS)
        ;
        getOrCreateTagBuilder(ModItemTags.DYEABLE_CERAMIC_BLOCKS)
                .add(ModBlocks.CERAMIC_TILES.asItem())
                .add(ModBlocks.CERAMIC_TILE_STAIRS.asItem())
                .add(ModBlocks.CERAMIC_TILE_SLAB.asItem())
                .add(ModBlocks.CHECKERED_CERAMIC_TILES.asItem())
                .add(ModBlocks.CHECKERED_CERAMIC_TILE_STAIRS.asItem())
                .add(ModBlocks.CHECKERED_CERAMIC_TILE_SLAB.asItem())
                .add(ModBlocks.CERAMIC_PRESSURE_PLATE.asItem())
                .add(ModBlocks.CERAMIC_BUTTON.asItem())
                .add(ModBlocks.CERAMIC_LEVER.asItem())
                .add(ModBlocks.CERAMIC_DISH.asItem())
        ;
        getOrCreateTagBuilder(ModItemTags.FELSIC_STONES)
                .add(Items.ANDESITE)
                .add(Items.GRANITE)
                .add(Items.DIORITE)
                .add(Items.TUFF)
        ;
        getOrCreateTagBuilder(ModItemTags.JACK_O_STRAW_LIGHTABLE)
                .addTag(ItemTags.CANDLES)
                .add(Items.TORCH)
        ;
        getOrCreateTagBuilder(ModItemTags.DYES)
                .add(Items.WHITE_DYE)
                .add(Items.LIGHT_GRAY_DYE)
                .add(Items.GRAY_DYE)
                .add(Items.BLACK_DYE)
                .add(Items.BROWN_DYE)
                .add(Items.RED_DYE)
                .add(Items.ORANGE_DYE)
                .add(Items.YELLOW_DYE)
                .add(Items.LIME_DYE)
                .add(Items.GREEN_DYE)
                .add(Items.CYAN_DYE)
                .add(Items.LIGHT_BLUE_DYE)
                .add(Items.BLUE_DYE)
                .add(Items.PURPLE_DYE)
                .add(Items.MAGENTA_DYE)
                .add(Items.PINK_DYE)
        ;
        getOrCreateTagBuilder(ModItemTags.EATABLE_ON_DISH)
                .add(Items.APPLE)
                .add(Items.GOLDEN_APPLE)
                .add(Items.ENCHANTED_GOLDEN_APPLE)
                .add(Items.MELON_SLICE)
                .add(Items.SWEET_BERRIES)
                .add(Items.GLOW_BERRIES)
                .add(Items.CHORUS_FRUIT)
                .add(Items.CARROT)
                .add(Items.GOLDEN_CARROT)
                .add(Items.POTATO)
                .add(Items.BAKED_POTATO)
                .add(Items.POISONOUS_POTATO)
                .add(Items.BEETROOT)
                .add(Items.DRIED_KELP)
                .add(Items.BEEF)
                .add(Items.COOKED_BEEF)
                .add(Items.PORKCHOP)
                .add(Items.COOKED_PORKCHOP)
                .add(Items.MUTTON)
                .add(Items.COOKED_MUTTON)
                .add(Items.RABBIT)
                .add(Items.COOKED_RABBIT)
                .add(Items.COD)
                .add(Items.COOKED_COD)
                .add(Items.SALMON)
                .add(Items.COOKED_SALMON)
                .add(Items.TROPICAL_FISH)
                .add(Items.PUFFERFISH)
                .add(Items.BREAD)
                .add(Items.COOKIE)
                .add(Items.PUMPKIN_PIE)
                .add(Items.ROTTEN_FLESH)
                .add(Items.SPIDER_EYE)
                .add(ModItems.MUSHROOM_STUFFED_POTATO)
                .add(ModItems.BERRY_STUFFED_POTATO)
                .add(ModItems.MAIZE_STUFFED_POTATO)
                .add(ModItems.FOREST_MEDLEY)
                .add(ModItems.ARID_MEDLEY)
                .add(ModItems.MEADOW_MEDLEY)
                .add(ModItems.COASTAL_MEDLEY)
                .add(ModItems.CANDIED_ORANGE)
                .add(ModItems.CANDIED_LEMON)
                .add(ModItems.CANDY)
                .add(ModItems.PIQUANT_CANDY)
                .add(ModItems.SOUR_CANDY)
                .add(ModItems.BITTER_CANDY)
                .add(ModItems.SPONGEKIN_SLICE)
                .add(ModItems.PASSION_FRUIT)
                .add(ModItems.ELDERBERRIES)
                .add(ModItems.LAPISBERRIES)
                .add(ModItems.ORANGE)
                .add(ModItems.LEMON)
                .add(ModItems.PLUM)
                .add(ModItems.HOARY_APPLE)
                .add(ModItems.WALNUT)
                .add(ModItems.MAIZE)
                .add(ModItems.LEEK)
                .add(ModItems.CITRIC_ACID)
                .add(ModItems.MAIZE_BREAD)
                .add(ModItems.WALNUT_COOKIE)
                .add(ModItems.BERRY_STUFFED_POTATO)
                .add(ModItems.MAIZE_STUFFED_POTATO)
                .add(ModItems.CANDIED_APPLE)
                .add(ModItems.CANDIED_PLUM)
        ;
        getOrCreateTagBuilder(ModItemTags.VINE_CROP_SEEDS)
                .add(ModItems.PASSION_FRUIT)
                .add(ModItems.ELDERBERRIES)
                .add(Items.GLOW_BERRIES)
                .add(ModItems.LAPISBERRY_SEEDS)
        ;
        getOrCreateTagBuilder(ModItemTags.PLANTABLE_ON_TRELLIS)
                .add(Items.ROSE_BUSH)
                .add(Items.LILAC)
                .add(Items.PEONY)
                .add(Items.SUNFLOWER)
                .add(Items.VINE)
        ;
        getOrCreateTagBuilder(ModItemTags.COOKED_FISHES)
                .add(Items.COOKED_COD)
                .add(Items.COOKED_SALMON)
        ;
        getOrCreateTagBuilder(ModItemTags.MEALS)
                .add(ModItems.MUSHROOM_STUFFED_POTATO)
                .add(ModItems.BERRY_STUFFED_POTATO)
                .add(ModItems.MAIZE_STUFFED_POTATO)
                .add(ModItems.LEEK_STEW)
                .add(ModItems.FISH_STEW)
                .add(ModItems.APPLE_STEW)
                .add(ModItems.STONE_STEW)
                .add(ModItems.BOUNTIFUL_STEW)
                .add(ModItems.FOREST_MEDLEY)
                .add(ModItems.ARID_MEDLEY)
                .add(ModItems.MEADOW_MEDLEY)
                .add(ModItems.COASTAL_MEDLEY)
                .add(ModItems.CRUSTED_BEEF)
                .add(ModItems.CRIMSON_CHOW)
                .add(ModItems.WARPED_CHOW)
                .add(ModItems.CUSTARD)
                .add(ModItems.PIQUANT_CUSTARD)
                .add(ModItems.PASSION_CUSTARD)
                .add(ModItems.COCOA_CUSTARD)
                .add(ModItems.GLOWING_CUSTARD)
                .add(ModItems.ANCIENT_CUSTARD)
        ;
        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.APPLE_SAPLING.asItem())
                .add(ModBlocks.ORANGE_SAPLING.asItem())
                .add(ModBlocks.LEMON_SAPLING.asItem())
                .add(ModBlocks.PLUM_SAPLING.asItem())
                .add(ModBlocks.HOARY_APPLE_SAPLING.asItem())
                .add(ModBlocks.WALNUT_SAPLING.asItem())
        ;
    }
}
