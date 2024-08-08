package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.util.BFItemTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.*;

public class BFItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public BFItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(BFBlocks.FLOWERING_APPLE_LEAVES.asItem())
                .add(BFBlocks.FLOWERING_ORANGE_LEAVES.asItem())
                .add(BFBlocks.FLOWERING_LEMON_LEAVES.asItem())
                .add(BFBlocks.FLOWERING_PLUM_LEAVES.asItem())
        ;
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(BFBlocks.HOARY_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS).add(BFBlocks.HONEYSUCKLE.asItem(), BFBlocks.VIOLET_BELLFLOWER.asItem());
        getOrCreateTagBuilder(ItemTags.LEAVES)
                .addTag(BFItemTags.APPLE_LEAVES)
                .addTag(BFItemTags.ORANGE_LEAVES)
                .addTag(BFItemTags.LEMON_LEAVES)
                .addTag(BFItemTags.PLUM_LEAVES)
                .add(BFBlocks.HOARY_LEAVES.asItem())
                .add(BFBlocks.WALNUT_LEAVES.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .addTag(BFItemTags.APPLE_LOGS)
                .addTag(BFItemTags.ORANGE_LOGS)
                .addTag(BFItemTags.LEMON_LOGS)
                .addTag(BFItemTags.PLUM_LOGS)
                .addTag(BFItemTags.HOARY_LOGS)
                .addTag(BFItemTags.WALNUT_LOGS)
                .addTag(BFItemTags.PALM_LOGS);
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

        getOrCreateTagBuilder(BFItemTags.APPLE_LEAVES).add(BFBlocks.APPLE_LEAVES.asItem(), BFBlocks.FLOWERING_APPLE_LEAVES.asItem());
        getOrCreateTagBuilder(BFItemTags.ORANGE_LEAVES).add(BFBlocks.ORANGE_LEAVES.asItem(), BFBlocks.FLOWERING_ORANGE_LEAVES.asItem());
        getOrCreateTagBuilder(BFItemTags.LEMON_LEAVES).add(BFBlocks.LEMON_LEAVES.asItem(), BFBlocks.FLOWERING_LEMON_LEAVES.asItem());
        getOrCreateTagBuilder(BFItemTags.PLUM_LEAVES).add(BFBlocks.PLUM_LEAVES.asItem(), BFBlocks.FLOWERING_PLUM_LEAVES.asItem());
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
        getOrCreateTagBuilder(BFItemTags.WALNUT_LOGS)
                .add(BFBlocks.WALNUT_LOG.asItem())
                .add(BFBlocks.STRIPPED_WALNUT_LOG.asItem())
                .add(BFBlocks.WALNUT_WOOD.asItem())
                .add(BFBlocks.STRIPPED_WALNUT_WOOD.asItem())
        ;
        getOrCreateTagBuilder(BFItemTags.FRUIT_LOGS)
                .addTag(BFItemTags.APPLE_LOGS)
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
        getOrCreateTagBuilder(BFItemTags.EATABLE_ON_DISH)
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
                .add(BFItems.MUSHROOM_STUFFED_POTATO)
                .add(BFItems.BERRY_STUFFED_POTATO)
                .add(BFItems.MAIZE_STUFFED_POTATO)
                .add(BFItems.FOREST_MEDLEY)
                .add(BFItems.ARID_MEDLEY)
                .add(BFItems.MEADOW_MEDLEY)
                .add(BFItems.COASTAL_MEDLEY)
                .add(BFItems.CANDIED_ORANGE)
                .add(BFItems.CANDIED_LEMON)
                .add(BFItems.CANDY)
                .add(BFItems.PIQUANT_CANDY)
                .add(BFItems.SOUR_CANDY)
                .add(BFItems.BITTER_CANDY)
                .add(BFItems.SPONGEKIN_SLICE)
                .add(BFItems.PASSION_FRUIT)
                .add(BFItems.ELDERBERRIES)
                .add(BFItems.LAPISBERRIES)
                .add(BFItems.ORANGE)
                .add(BFItems.LEMON)
                .add(BFItems.PLUM)
                .add(BFItems.HOARY_APPLE)
                .add(BFItems.WALNUT)
                .add(BFItems.MAIZE)
                .add(BFItems.LEEK)
                .add(BFItems.CITRUS_ESSENCE)
                .add(BFItems.MAIZE_BREAD)
                .add(BFItems.WALNUT_COOKIE)
                .add(BFItems.BERRY_STUFFED_POTATO)
                .add(BFItems.MAIZE_STUFFED_POTATO)
                .add(BFItems.CANDIED_APPLE)
                .add(BFItems.CANDIED_PLUM)
        ;
        getOrCreateTagBuilder(BFItemTags.EATABLE_ON_DISH)
                .addOptional(new Identifier(EXCESSIVE_BUILDING_MOD_ID, "ancient_fruit"));

//        Mint
        getOrCreateTagBuilder(BFItemTags.EATABLE_ON_DISH)
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "mint_sprig"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "mint_cookie"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "wintergreen_berries"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "winter_medley"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "wintergreen_candy_cane"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "peppermint_candy_cane"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "lavender_bread"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "peach"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "peach_slice"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "golden_peach"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "peach_cobbler"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "cooked_anemone"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "artichoke"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "artichoke_heart"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "artichoke_lamb"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "breakfast_porkchop"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "pineapple_slices"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "pineapple_tart"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "pineapple_kebab"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "strawberry"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "chocolate_strawberry"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "golden_strawberry"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "strawberry_shortcake"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "strawberry_cheesecake"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "angel_food_cake"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "cherries"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "cherry_pie"))
            .addOptional(new Identifier(ELS_AND_LS_DYES_MOD_ID, "pokeberries"))
        ;

        //        Farmersdelight
        getOrCreateTagBuilder(BFItemTags.EATABLE_ON_DISH)
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "cabbage"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "tomato"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "onion"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "fried_egg"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "pumpkin_slice"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "cabbage_leaf"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "minced_beef"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "beef_patty"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "chicken_cuts"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "cooked_chicken_cuts"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "bacon"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "cooked_bacon"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "cod_slice"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "cooked_cod_slice"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "salmon_slice"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "cooked_salmon_slice"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "mutton_chops"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "cooked_mutton_chops"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "ham"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "smoked_ham"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "pie_crust"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "apple_pie"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "sweet_berry_cheesecake_slice"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "chocolate_pie_slice"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "sweet_berry_cookie"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "honey_cookie"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "melon_popsicle"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "egg_sandwich"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "chicken_sandwich"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "hamburger"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "bacon_sandwich"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "mutton_wrap"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "dumplings"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "stuffed_potato"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "cabbage_rolls"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "salmon_roll"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "cod_roll"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "kelp_roll"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "kelp_roll_slice"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "wheat_dough"))
                .addOptional(new Identifier(FARMERS_DELIGHT_MOD_ID, "raw_pasta"))
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
                .add(BFItems.LEEK_STEW)
                .add(BFItems.FISH_STEW)
                .add(BFItems.APPLE_STEW)
                .add(BFItems.STONE_STEW)
                .add(BFItems.BOUNTIFUL_STEW)
                .add(BFItems.FOREST_MEDLEY)
                .add(BFItems.ARID_MEDLEY)
                .add(BFItems.MEADOW_MEDLEY)
                .add(BFItems.COASTAL_MEDLEY)
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
    }
}
