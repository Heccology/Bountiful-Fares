package net.hecco.bountifulfares.datagen.bountifulfares;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.compat.dye_depot.DyeDepotBlocks;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.registry.misc.BFCompat;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFaresUtil.toSentenceCase;

public class BFLangProvider extends FabricLanguageProvider {
    Set<String> usedTranslationKeys = new HashSet<>();

    public BFLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    private void generate(TranslationBuilder translationBuilder, String key, String translation) {
        if(usedTranslationKeys.contains(key)) {
            return;
        }
        translationBuilder.add(key, translation);
        usedTranslationKeys.add(key);
    }
    private void generate(TranslationBuilder translationBuilder, Block block, String translation) {
        generate(translationBuilder, block.getTranslationKey(), translation);
    }
    private void generate(TranslationBuilder translationBuilder, Item item, String translation) {
        generate(translationBuilder, item.getTranslationKey(), translation);
    }

    private void generateJackOStraw(TranslationBuilder translationBuilder, Block block, String color) {
        generate(translationBuilder, block, color + " Jack O' Straw");
    }


    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        generate(translationBuilder, "itemgroup.bountiful_fares", "Bountiful Fares");
        generate(translationBuilder, BFBlocks.HANGING_APPLE, "Apple");
        generate(translationBuilder, BFBlocks.HANGING_ORANGE, "Orange");
        generate(translationBuilder, BFBlocks.HANGING_LEMON, "Lemon");
        generate(translationBuilder, BFBlocks.HANGING_PLUM, "Plum");
        generate(translationBuilder, BFBlocks.HANGING_GOLDEN_APPLE, "Golden Apple");
        generate(translationBuilder, BFBlocks.HANGING_WITHERED_GOLDEN_APPLE, "Withered Golden Apple");



        generate(translationBuilder, BFBlocks.HOARY_APPLE_SAPLING_CROP, "Hoary Apple Sapling");
        generate(translationBuilder, BFItems.HOARY_CHEST_BOAT, "Hoary Boat with Chest");
        generate(translationBuilder, BFBlocks.HANGING_HOARY_APPLE, "Hoary Apple");

        generate(translationBuilder, BFBlocks.CERAMIC_CLAY_BLOCK, "Block of Ceramic Clay");


        generate(translationBuilder, BFItems.WALNUT_CHEST_BOAT, "Walnut Boat with Chest");

        generate(translationBuilder, BFBlocks.HANGING_WALNUTS, "Walnuts");


        generate(translationBuilder, BFBlocks.WALL_PALM_FROND, "Palm Frond");

        generate(translationBuilder, BFBlocks.HOARY_SIGN, "Hoary Sign");
        generate(translationBuilder, BFBlocks.HOARY_WALL_SIGN, "Hoary Sign");
        generate(translationBuilder, BFItems.HOARY_SIGN, "Hoary Sign");
        generate(translationBuilder, BFBlocks.HOARY_HANGING_SIGN, "Hoary Hanging Sign");
        generate(translationBuilder, BFBlocks.HOARY_WALL_HANGING_SIGN, "Hoary Hanging Sign");
        generate(translationBuilder, BFItems.HOARY_HANGING_SIGN, "Hoary Hanging Sign");

        generate(translationBuilder, BFBlocks.WALNUT_SIGN, "Walnut Sign");
        generate(translationBuilder, BFBlocks.WALNUT_WALL_SIGN, "Walnut Sign");
        generate(translationBuilder, BFItems.WALNUT_SIGN, "Walnut Sign");
        generate(translationBuilder, BFBlocks.WALNUT_HANGING_SIGN, "Walnut Hanging Sign");
        generate(translationBuilder, BFBlocks.WALNUT_WALL_HANGING_SIGN, "Walnut Hanging Sign");
        generate(translationBuilder, BFItems.WALNUT_HANGING_SIGN, "Walnut Hanging Sign");




        generate(translationBuilder, "effect.bountifulfares.acidic", "Acidic");
        generate(translationBuilder, "item.minecraft.potion.effect.bountifulfares.acidic", "Potion of Acidity");
        generate(translationBuilder, "item.minecraft.potion.effect.bountifulfares.long_acidic", "Potion of Acidity");
        generate(translationBuilder, "item.minecraft.potion.effect.bountifulfares.strong_acidic", "Potion of Acidity");
        generate(translationBuilder, "item.minecraft.splash_potion.effect.bountifulfares.acidic", "Splash Potion of Acidity");
        generate(translationBuilder, "item.minecraft.splash_potion.effect.bountifulfares.long_acidic", "Splash Potion of Acidity");
        generate(translationBuilder, "item.minecraft.splash_potion.effect.bountifulfares.strong_acidic", "Splash Potion of Acidity");
        generate(translationBuilder, "item.minecraft.lingering_potion.effect.bountifulfares.acidic", "Lingering Potion of Acidity");
        generate(translationBuilder, "item.minecraft.lingering_potion.effect.bountifulfares.long_acidic", "Lingering Potion of Acidity");
        generate(translationBuilder, "item.minecraft.lingering_potion.effect.bountifulfares.strong_acidic", "Lingering Potion of Acidity");
        generate(translationBuilder, "item.minecraft.tipped_arrow.effect.bountifulfares.acidic", "Arrow of Acidity");
        generate(translationBuilder, "item.minecraft.tipped_arrow.effect.bountifulfares.long_acidic", "Arrow of Acidity");
        generate(translationBuilder, "item.minecraft.tipped_arrow.effect.bountifulfares.strong_acidic", "Arrow of Acidity");
        generate(translationBuilder, "effect.bountifulfares.acidic.description", "Increases the amplifier of all other effects applied. Reverts after Acidic is removed.");
        generate(translationBuilder, "effect.bountifulfares.stupor", "Stupor");
        generate(translationBuilder, "item.minecraft.potion.effect.bountifulfares.stupor", "Potion of Stupor");
        generate(translationBuilder, "item.minecraft.potion.effect.bountifulfares.long_stupor", "Potion of Stupor");
        generate(translationBuilder, "item.minecraft.splash_potion.effect.bountifulfares.stupor", "Splash Potion of Stupor");
        generate(translationBuilder, "item.minecraft.splash_potion.effect.bountifulfares.long_stupor", "Splash Potion of Stupor");
        generate(translationBuilder, "item.minecraft.lingering_potion.effect.bountifulfares.stupor", "Lingering Potion of Stupor");
        generate(translationBuilder, "item.minecraft.lingering_potion.effect.bountifulfares.long_stupor", "Lingering Potion of Stupor");
        generate(translationBuilder, "item.minecraft.tipped_arrow.effect.bountifulfares.stupor", "Arrow of Stupor");
        generate(translationBuilder, "item.minecraft.tipped_arrow.effect.bountifulfares.long_stupor", "Arrow of Stupor");
        generate(translationBuilder, "effect.bountifulfares.stupor.description", "Removes all effects and stops effects from applying for its duration.");


        generate(translationBuilder, "effect.bountifulfares.restoration", "Restoration");
        generate(translationBuilder, "effect.bountifulfares.restoration.description", "Regenerates health up to the health when it was applied.");
        generate(translationBuilder, "effect.bountifulfares.enrichment", "Enrichment");
        generate(translationBuilder, "effect.bountifulfares.enrichment.description", "Minor buffs to most stats.");



        registerTrellisTranslations(translationBuilder, BFTrellises.OAK, "Oak Trellis");
        registerTrellisTranslations(translationBuilder, BFTrellises.SPRUCE);
        registerTrellisTranslations(translationBuilder, BFTrellises.BIRCH);
        registerTrellisTranslations(translationBuilder, BFTrellises.JUNGLE);
        registerTrellisTranslations(translationBuilder, BFTrellises.ACACIA);
        registerTrellisTranslations(translationBuilder, BFTrellises.DARK_OAK);
        registerTrellisTranslations(translationBuilder, BFTrellises.MANGROVE);
        registerTrellisTranslations(translationBuilder, BFTrellises.CHERRY);
        registerTrellisTranslations(translationBuilder, BFTrellises.BAMBOO);
        registerTrellisTranslations(translationBuilder, BFTrellises.WALNUT);
        registerTrellisTranslations(translationBuilder, BFTrellises.HOARY);
        registerTrellisTranslations(translationBuilder, BFTrellises.CRIMSON);
        registerTrellisTranslations(translationBuilder, BFTrellises.WARPED);

//        registerTrellisTranslations(translationBuilder, BFTrellises.BAOBAB);
//        registerTrellisTranslations(translationBuilder, BFTrellises.WW_CYPRESS);
//        registerTrellisTranslations(translationBuilder, BFTrellises.PALM);

        registerTrellisTranslations(translationBuilder, ExcessiveBuildingBlocks.ANCIENT);

        registerTrellisTranslations(translationBuilder, MintBlocks.WINTERGREEN);

        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.ASPEN);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.CEDAR);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.COCONUT);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.CYPRESS);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.FIR);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.GHAF);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.JOSHUA);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.LARCH);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.MAHOGANY);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.MAPLE);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.OLIVE);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.PALO_VERDE);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.SAXAUL);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.SUGI);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.WILLOW);
        registerTrellisTranslations(translationBuilder, NaturesSpiritBlocks.WISTERIA);

        registerTrellisTranslations(translationBuilder, SpawnBlocks.ROTTEN);

        registerTrellisTranslations(translationBuilder, ArtsAndCraftsBlocks.CORK);




        generate(translationBuilder, BFBlocks.MAIZE_CROP, "Maize");



        generate(translationBuilder, "effect.bountifulfares.ebullience", "Ebullience");
        generate(translationBuilder, "effect.bountifulfares.ebullience.description", "Negates exhaustion from actions like mining or walking.");
//        generate(translationBuilder, "effect.bountifulfares.gorging", "Gorging");


        generateJackOStraw(translationBuilder, BFBlocks.RED_JACK_O_STRAW, "Red");
        generateJackOStraw(translationBuilder, BFBlocks.ORANGE_JACK_O_STRAW, "Orange");
        generateJackOStraw(translationBuilder, BFBlocks.YELLOW_JACK_O_STRAW, "Yellow");
        generateJackOStraw(translationBuilder, BFBlocks.LIME_JACK_O_STRAW, "Lime");
        generateJackOStraw(translationBuilder, BFBlocks.GREEN_JACK_O_STRAW, "Green");
        generateJackOStraw(translationBuilder, BFBlocks.CYAN_JACK_O_STRAW, "Cyan");
        generateJackOStraw(translationBuilder, BFBlocks.LIGHT_BLUE_JACK_O_STRAW, "Light Blue");
        generateJackOStraw(translationBuilder, BFBlocks.BLUE_JACK_O_STRAW, "Blue");
        generateJackOStraw(translationBuilder, BFBlocks.PURPLE_JACK_O_STRAW, "Purple");
        generateJackOStraw(translationBuilder, BFBlocks.MAGENTA_JACK_O_STRAW, "Magenta");
        generateJackOStraw(translationBuilder, BFBlocks.PINK_JACK_O_STRAW, "Pink");
        generateJackOStraw(translationBuilder, BFBlocks.WHITE_JACK_O_STRAW, "White");
        generateJackOStraw(translationBuilder, BFBlocks.LIGHT_GRAY_JACK_O_STRAW, "Light Gray");
        generateJackOStraw(translationBuilder, BFBlocks.GRAY_JACK_O_STRAW, "Gray");
        generateJackOStraw(translationBuilder, BFBlocks.BLACK_JACK_O_STRAW, "Black");
        generateJackOStraw(translationBuilder, BFBlocks.BROWN_JACK_O_STRAW, "Brown");

        generateJackOStraw(translationBuilder, MintBlocks.ACORN_JACK_O_STRAW, "Acorn");
        generateJackOStraw(translationBuilder, MintBlocks.AMBER_JACK_O_STRAW, "Amber");
        generateJackOStraw(translationBuilder, MintBlocks.ARTICHOKE_JACK_O_STRAW, "Artichoke");
        generateJackOStraw(translationBuilder, MintBlocks.BANANA_JACK_O_STRAW, "Banana");
        generateJackOStraw(translationBuilder, MintBlocks.CERULEAN_JACK_O_STRAW, "Cerulean");
        generateJackOStraw(translationBuilder, MintBlocks.FUCHSIA_JACK_O_STRAW, "Fuchsia");
        generateJackOStraw(translationBuilder, MintBlocks.GRAPE_JACK_O_STRAW, "Grape");
        generateJackOStraw(translationBuilder, MintBlocks.INDIGO_JACK_O_STRAW, "Indigo");
        generateJackOStraw(translationBuilder, MintBlocks.MAROON_JACK_O_STRAW, "Maroon");
        generateJackOStraw(translationBuilder, MintBlocks.MAUVE_JACK_O_STRAW, "Mauve");
        generateJackOStraw(translationBuilder, MintBlocks.MINT_JACK_O_STRAW, "Mint");
        generateJackOStraw(translationBuilder, MintBlocks.MOLD_JACK_O_STRAW, "Mold");
        generateJackOStraw(translationBuilder, MintBlocks.NAVY_JACK_O_STRAW, "Navy");
        generateJackOStraw(translationBuilder, MintBlocks.PEACH_JACK_O_STRAW, "Peach");
        generateJackOStraw(translationBuilder, MintBlocks.PERIWINKLE_JACK_O_STRAW, "Periwinkle");
        generateJackOStraw(translationBuilder, MintBlocks.SAGE_JACK_O_STRAW, "Sage");
        generateJackOStraw(translationBuilder, MintBlocks.SAP_JACK_O_STRAW, "Sap");
        generateJackOStraw(translationBuilder, MintBlocks.SHAMROCK_JACK_O_STRAW, "Shamrock");
        generateJackOStraw(translationBuilder, MintBlocks.VELVET_JACK_O_STRAW, "Velvet");
        generateJackOStraw(translationBuilder, MintBlocks.VERMILION_JACK_O_STRAW, "Vermilion");

        generateJackOStraw(translationBuilder, DyeDepotBlocks.MAROON_JACK_O_STRAW, "Maroon");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.ROSE_JACK_O_STRAW, "Rose");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.CORAL_JACK_O_STRAW, "Coral");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.GINGER_JACK_O_STRAW, "Ginger");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.TAN_JACK_O_STRAW, "Tan");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.BEIGE_JACK_O_STRAW, "Beige");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.AMBER_JACK_O_STRAW, "Amber");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.OLIVE_JACK_O_STRAW, "Olive");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.FOREST_JACK_O_STRAW, "Forest");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.VERDANT_JACK_O_STRAW, "Verdant");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.TEAL_JACK_O_STRAW, "Teal");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.MINT_JACK_O_STRAW, "Mint");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.AQUA_JACK_O_STRAW, "Aqua");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.SLATE_JACK_O_STRAW, "Slate");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.NAVY_JACK_O_STRAW, "Navy");
        generateJackOStraw(translationBuilder, DyeDepotBlocks.INDIGO_JACK_O_STRAW, "Indigo");



        generate(translationBuilder, "tooltip.bountifulfares.dyeable", "Dyeable");
        generate(translationBuilder, "tooltip.bountifulfares.when_lit", "When lit:");
        generate(translationBuilder, "tooltip.bountifulfares.removes", "Removes:");
        generate(translationBuilder, "tooltip.bountifulfares.when_eaten", "When eaten:");
        generate(translationBuilder, "tooltip.bountifulfares.when_drunk", "When drunk:");
        generate(translationBuilder, "tooltip.bountifulfares.air_time", "Oxygen");
        generate(translationBuilder, "tooltip.bountifulfares.removes_all_effects", "Removes all effects");


        generate(translationBuilder, "painting.bountifulfares.bountiful.title", "Bountiful");
        generate(translationBuilder, "painting.bountifulfares.bountiful.author", "Hecco");
//        generate(translationBuilder, "painting.bountifulfares.sponge_house.title", "Sponge House");
//        generate(translationBuilder, "painting.bountifulfares.sponge_house.author", "Hecco");
        generate(translationBuilder, "painting.bountifulfares.citrus_dish.title", "Citrus Dish");
        generate(translationBuilder, "painting.bountifulfares.citrus_dish.author", "Hecco");
//        generate(translationBuilder, "painting.bountifulfares.mulcher.title", "Mulcher");
//        generate(translationBuilder, "painting.bountifulfares.mulcher.author", "Hecco");
        generate(translationBuilder, "painting.bountifulfares.ruminer.title", "Ruminer");
        generate(translationBuilder, "painting.bountifulfares.ruminer.author", "Hecco");
        generate(translationBuilder, "painting.bountifulfares.hazel_floret.title", "Hazel Floret");
        generate(translationBuilder, "painting.bountifulfares.hazel_floret.author", "Hecco");
        generate(translationBuilder, "painting.bountifulfares.violet_floret.title", "Violet Floret");
        generate(translationBuilder, "painting.bountifulfares.violet_floret.author", "Hecco");
        generate(translationBuilder, "painting.bountifulfares.why_blue.title", "Why Blue");
        generate(translationBuilder, "painting.bountifulfares.why_blue.author", "Hecco");
        generate(translationBuilder, "painting.bountifulfares.phylogenesis.title", "Phylogenesis");
        generate(translationBuilder, "painting.bountifulfares.phylogenesis.author", "Hecco");
        generate(translationBuilder, "painting.bountifulfares.escalade.title", "Escalade");
        generate(translationBuilder, "painting.bountifulfares.escalade.author", "Hecco");
        generate(translationBuilder, "painting.bountifulfares.aquaculture.title", "Aquaculture");
        generate(translationBuilder, "painting.bountifulfares.aquaculture.author", "Hecco");
        generate(translationBuilder, "painting.bountifulfares.unpleasant_tiles.title", "Unpleasant Tiles");
        generate(translationBuilder, "painting.bountifulfares.unpleasant_tiles.author", "Hecco");

        generate(translationBuilder, "warning.bountifulfares.fermentation_vessel.minecraft:glass_bottle", "Use a Glass Bottle to collect this");
        generate(translationBuilder, "warning.bountifulfares.fermentation_vessel.bountifulfares:jar", "Use a Jar to collect this");
        generate(translationBuilder, "warning.bountifulfares.fermentation_vessel.minecraft:bucket", "Use a Bucket to collect this");
        generate(translationBuilder, "warning.bountifulfares.fermentation_vessel.minecraft:bowl", "Use a Bowl to collect this");

        generate(translationBuilder, "advancement.bountifulfares.bountiful_fares", "Bountiful Fares");
        generate(translationBuilder, "advancement.bountifulfares.bountiful_fares.description", "The world is filled with more food!");

        generate(translationBuilder, "advancement.bountifulfares.place_gristmill", "On The Grind");
        generate(translationBuilder, "advancement.bountifulfares.place_gristmill.description", "Place a Gristmill");

        generate(translationBuilder, "advancement.bountifulfares.obtain_feldspar", "Felsic Forager");
        generate(translationBuilder, "advancement.bountifulfares.obtain_feldspar.description", "Collect Feldspar from milling stones");

        generate(translationBuilder, "advancement.bountifulfares.obtain_ceramic_tiles", "Roy G Biv");
        generate(translationBuilder, "advancement.bountifulfares.obtain_ceramic_tiles.description", "Craft any dyeable ceramic block");

        generate(translationBuilder, "advancement.bountifulfares.feed_wolf_mulch", "Mulchmaxxer");
        generate(translationBuilder, "advancement.bountifulfares.feed_wolf_mulch.description", "Feed a wolf mulch");

        generate(translationBuilder, "advancement.bountifulfares.how_easy", "How Easy...");
        generate(translationBuilder, "advancement.bountifulfares.how_easy.description", "Threaten to squeeze a Lemon Block");

        generate(translationBuilder, "advancement.bountifulfares.obtain_fermentation_vessel", "Toil And Trouble");
        generate(translationBuilder, "advancement.bountifulfares.obtain_fermentation_vessel.description", "Craft a Fermentation Vessel");

        generate(translationBuilder, "advancement.bountifulfares.eat_ancient_fruit", "How Long Has This Sat Out?");
        generate(translationBuilder, "advancement.bountifulfares.eat_ancient_fruit.description", "Eat a fruit from the distant past");

        generate(translationBuilder, "advancement.bountifulfares.place_all_baked_goods", "Baker's Dozen");
        generate(translationBuilder, "advancement.bountifulfares.place_all_baked_goods.description", "Place every baked good");

        generate(translationBuilder, "advancement.bountifulfares.eat_citrus_essence", "Pass The Antacid");
        generate(translationBuilder, "advancement.bountifulfares.eat_citrus_essence.description", "Eat Citric Essence");

//        generate(translationBuilder, "advancement.bountifulfares.throw_flour", "Great Escape");
//        generate(translationBuilder, "advancement.bountifulfares.throw_flour.description", "Throw Flour");

        generate(translationBuilder, "advancement.bountifulfares.obtain_sun_hat", "Who's the Farmer Now?");
        generate(translationBuilder, "advancement.bountifulfares.obtain_sun_hat.description", "Obtain a Sun Hat");

        generate(translationBuilder, "advancement.bountifulfares.eat_all_candy", "Sweet Tooth");
        generate(translationBuilder, "advancement.bountifulfares.eat_all_candy.description", "Eat every Candy");

        generate(translationBuilder, "advancement.bountifulfares.gorge", "Maybe One More...");
        generate(translationBuilder, "advancement.bountifulfares.gorge.description", "Gorge");

        generate(translationBuilder, "advancement.bountifulfares.obtain_tea_blends", "Tea Tea");
        generate(translationBuilder, "advancement.bountifulfares.obtain_tea_blends.description", "Obtain every Tea Blend");

        generate(translationBuilder, "advancement.bountifulfares.place_all_tea_candles", "Fragrant!");
        generate(translationBuilder, "advancement.bountifulfares.place_all_tea_candles.description", "Place every Tea Candle");

        generate(translationBuilder, "advancement.bountifulfares.obtain_walnut", "Insert Funny Nut Phrase");
        generate(translationBuilder, "advancement.bountifulfares.obtain_walnut.description", "Find a Walnut");

        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin_seeds", "A Spongy Place");
        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin_seeds.description", "Discover the source of all these Sponges...");

        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin", "Who Lives In A Loofah Under The Sea");
        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin.description", "Grow and collect a Spongekin");

        generate(translationBuilder, "advancement.bountifulfares.make_first_food", "Anyone Can Cook");
        generate(translationBuilder, "advancement.bountifulfares.make_first_food.description", "Make your first meal");

        generate(translationBuilder, "advancement.bountifulfares.eat_all_food", "Bountiful Fares");
        generate(translationBuilder, "advancement.bountifulfares.eat_all_food.description", "Eat every food");

        generate(translationBuilder, "subtitles.block.gristmill.grind", "Gristmill mills");
        generate(translationBuilder, "subtitles.entity.flour.throw", "Flour flies");
        generate(translationBuilder, "subtitles.entity.flour.land", "Flour billows");

        generate(translationBuilder, "subtitles.block.fermentation_vessel.fill", "Fermentation Vessel fills");
        generate(translationBuilder, "subtitles.block.fermentation_vessel.splash", "Fermentation Vessel splashes");
        generate(translationBuilder, "subtitles.block.fermentation_vessel.empty", "Fermentation Vessel empties");
        generate(translationBuilder, "subtitles.block.fermentation_vessel.ferment", "Fermentation Vessel ferments");
        generate(translationBuilder, "subtitles.block.hanging_fruit.pick", "Fruit pops");

        generate(translationBuilder, "subtitles.block.coconut.land", "Coconut thuds");
        generate(translationBuilder, "subtitles.block.coconut.bonk", "Coconut bonks");

        generate(translationBuilder, "subtitles.block.golden_apple.wither", "Golden Apple withers");



        generate(translationBuilder, "config.bountifulfares.title", "Bountiful Fares Configuration");

//        generate(translationBuilder, "config.bountifulfares.category.client", "Client");
        generate(translationBuilder, "config.bountifulfares.category.gameplay", "Gameplay");
        generate(translationBuilder, "config.bountifulfares.category.paintings", "Paintings");
        generate(translationBuilder, "config.bountifulfares.category.world", "World");
        generate(translationBuilder, "config.bountifulfares.category.client", "Client");
        generate(translationBuilder, "config.bountifulfares.category.compat", "Compatibility");
        generate(translationBuilder, "config.bountifulfares.category.mint", "El's and L's Dye Mod");
        generate(translationBuilder, "config.bountifulfares.category.dye_depot", "Dye Depot");

        generate(translationBuilder, "config.bountifulfares.restart_warning", "Requires a restart to apply changes");

//        generate(translationBuilder, "config.bountifulfares.item_guide_tooltips", "Show information in some items' tooltip");
        generate(translationBuilder, "config.bountifulfares.fruit_replace_when_picked", "Fruits on trees replant when picked");
        generate(translationBuilder, "config.bountifulfares.flour_throwing", "Flour can be thrown");
        generate(translationBuilder, "config.bountifulfares.flour_throwing_cooldown", "Flour throwing cooldown, in ticks");
        generate(translationBuilder, "config.bountifulfares.container_foods_eatable_on_dish", "Foods with containers can be eaten on Ceramic Dishes");
        generate(translationBuilder, "config.bountifulfares.restoration_overlay", "Restoration effect changes health icons");
        generate(translationBuilder, "config.bountifulfares.acidified_effect_icon_effects", "Status Effects modified by Acidity have visual effects");
        generate(translationBuilder, "config.bountifulfares.effect_tooltips", "Foods have effect tooltips");
        generate(translationBuilder, "config.subterrous.particle_tint_override_msg", "Disable this if it is causing issues.");
        generate(translationBuilder, "config.bountifulfares.sweet_berry_pips", "Sweet Berries cannot place Sweet Berry Bushes");
        generate(translationBuilder, "config.bountifulfares.lapisberry_seeds", "Sniffers can dig up Lapisberry Seeds");
        generate(translationBuilder, "config.bountifulfares.hoary_seeds", "Sniffers can dig up Hoary Seeds");
        generate(translationBuilder, "config.bountifulfares.grass_loot_table_override", "Grass loot tables are overridden");
        generate(translationBuilder, "config.bountifulfares.spongekin_seeds_elder_guardian", "Elder Guardians drop Spongekin Seeds");
        generate(translationBuilder, "config.bountifulfares.spongekin_seeds_guardian", "Guardians drop Spongekin Seeds");
        generate(translationBuilder, "config.bountifulfares.milling_time", "Gristmill milling time, in seconds");
        generate(translationBuilder, "config.bountifulfares.fermentation_time", "Fermentation time, in seconds");
        generate(translationBuilder, "config.bountifulfares.fermentation_bubble_particles", "Fermentation Vessels emit bubble particles");
        generate(translationBuilder, "config.bountifulfares.infused_candle_radius", "Size of area where Infused Candles give effects");
//        generate(translationBuilder, "config.bountifulfares.bountiful_painting", "Allow \"Bountiful\" painting to be placed");
//        generate(translationBuilder, "config.bountifulfares.citrus_dish_painting", "Allow \"Citrus Dish\" painting to be placed");
//        generate(translationBuilder, "config.bountifulfares.hazel_floret_painting", "Allow \"Hazel Floret\" painting to be placed");
//        generate(translationBuilder, "config.bountifulfares.violet_floret_painting", "Allow \"Violet Floret\" painting to be placed");
//        generate(translationBuilder, "config.bountifulfares.why_blue_painting", "Allow \"Why Blue\" painting to be placed");
//        generate(translationBuilder, "config.bountifulfares.ruminer_painting", "Allow \"Ruminer\" painting to be placed");
//        generate(translationBuilder, "config.bountifulfares.phylogenesis_painting", "Allow \"Phylogenesis\" painting to be placed");
//        generate(translationBuilder, "config.bountifulfares.escalade_painting", "Allow \"Escalade\" painting to be placed");
//        generate(translationBuilder, "config.bountifulfares.aquaculture_painting", "Allow \"Aquaculture\" painting to be placed");
//        generate(translationBuilder, "config.bountifulfares.unpleasant_tiles_painting", "Allow \"Unpleasant Tiles\" painting to be placed");
        generate(translationBuilder, "config.bountifulfares.wild_wheat", "Generate Wild Wheat");
        generate(translationBuilder, "config.bountifulfares.wild_carrots", "Generate Wild Carrots");
        generate(translationBuilder, "config.bountifulfares.wild_potatoes", "Generate Wild Potatoes");
        generate(translationBuilder, "config.bountifulfares.wild_beetroot", "Generate Wild Beetroot");
        generate(translationBuilder, "config.bountifulfares.wild_leeks", "Generate Wild Leeks");
        generate(translationBuilder, "config.bountifulfares.wild_maize", "Generate Wild Maize");
        generate(translationBuilder, "config.bountifulfares.apple_trees", "Generate Apple Trees");
        generate(translationBuilder, "config.bountifulfares.orange_trees", "Generate Orange Trees");
        generate(translationBuilder, "config.bountifulfares.lemon_trees", "Generate Lemon Trees");
        generate(translationBuilder, "config.bountifulfares.plum_trees", "Generate Plum Trees");
        generate(translationBuilder, "config.bountifulfares.palm_trees", "Generate Palm Trees");
        generate(translationBuilder, "config.bountifulfares.grassy_dirt_patches", "Generate Patches of Grassy Dirt");
        generate(translationBuilder, "config.bountifulfares.wild_passion_fruit", "Generate Wild Passion Fruit");
        generate(translationBuilder, "config.bountifulfares.wild_elderberries", "Generate Wild Elderberries");
        generate(translationBuilder, "config.bountifulfares.golden_apple_tree_rooms", "Generate Golden Apple Trees in Woodland Mansions");
        generate(translationBuilder, "config.bountifulfares.flower_forest_fruit_trees", "Generate fruit trees in Flower Forests");
        generate(translationBuilder, "config.bountifulfares.forest_tea_shrubs", "Generate Tea Shrubs in Forests");
        generate(translationBuilder, "config.bountifulfares.forest_walnut_trees", "Generate Walnut Trees in Forests");
//        generate(translationBuilder, "config.bountifulfares.honeysuckle_to_banana_dye", "Honeysuckles craft into Banana Dye");
//        generate(translationBuilder, "config.bountifulfares.rename_items_to_match_dyes", "Rename dyed items to match Dye Depot's override pack");
//        generate(translationBuilder, "config.bountifulfares.honeysuckle_to_amber_dye", "Honeysuckles craft into Amber Dye");
//        generate(translationBuilder, "config.bountifulfares.chamomile_to_beige_dye", "Chamomile Flowers craft into Beige Dye");

        generate(translationBuilder, "pack.bountifulfares.vanilla_item_override", "Vanilla Item Texture Override");
        generate(translationBuilder, "pack.bountifulfares.grass_loot_table_override", "Grass Loot Table Override");
        generate(translationBuilder, "pack.bountifulfares.amendments", "Bountiful Fares X Amendments");
        generate(translationBuilder, "pack.bountifulfares.mint", "Bountiful Fares X El's and L's Dye Mod");
        generate(translationBuilder, "pack.bountifulfares.dye_depot", "Bountiful Fares X Dye Depot");
        generate(translationBuilder, "pack.bountifulfares.natures_spirit", "Bountiful Fares X Nature's Spirit");
        generate(translationBuilder, "pack.bountifulfares.excessive_building", "Bountiful Fares X Excessive Building");
        generate(translationBuilder, "pack.bountifulfares.spawn", "Bountiful Fares X Spawn");
        generate(translationBuilder, "pack.bountifulfares.farmersdelight", "Bountiful Fares X Farmer's Delight");
        generate(translationBuilder, "pack.bountifulfares.twigs", "Bountiful Fares X Twigs");
        generate(translationBuilder, "pack.bountifulfares.delicate_dyes", "Bountiful Fares X Delicate Dyes");
        generate(translationBuilder, "pack.bountifulfares.appledog", "Bountiful Fares X Appledog!");
        generate(translationBuilder, "pack.bountifulfares.dungeons_delight", "Bountiful Fares X Dungeon's Delight");

        generate(translationBuilder, "death.attack.falling_coconut", "%1$s was bonked too hard");


        generate(translationBuilder, "bountifulfares.milling", "Milling");
        generate(translationBuilder, "bountifulfares.fermenting", "Fermenting");
        generate(translationBuilder, "bountifulfares.prismarine_propagation", "Prismarine Propagation");
        generate(translationBuilder, "jei.bountifulfares.collect_using", "Collect using ");
        generate(translationBuilder, "jei.bountifulfares.minutes", "minutes");
        generate(translationBuilder, "jei.bountifulfares.seconds", "seconds");

        for(Identifier id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.MOD_ID)) {
            String key = Registries.BLOCK.get(id).getTranslationKey();
            if(usedTranslationKeys.contains(key)) { continue; }
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentenceCase(id.getPath()));
        }
        for(Identifier id : BountifulFaresUtil.allItemIdsInNamespace(BountifulFares.MOD_ID)) {
            String key = Registries.ITEM.get(id).getTranslationKey();
            if (usedTranslationKeys.contains(key)) {
                continue;
            }
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentenceCase(id.getPath()));
        }

//      for compat
        for(Identifier id : BountifulFaresUtil.allCompatBlockIds()) {
            String key = Registries.BLOCK.get(id).getTranslationKey();
            if(usedTranslationKeys.contains(key)) { continue; }
            if (BFCompat.compatBlocks.contains(Registries.BLOCK.get(id))) {
                usedTranslationKeys.add(key);
                translationBuilder.add(key, toSentenceCase(id.getPath()));
            }
        }
    }
    public void registerTrellisTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder, TrellisVariant trellis) {
        String temp = toSentenceCase(Registries.ITEM.getId(TrellisUtil.getTrellisFromVariant(trellis).asItem()).getPath());
        translationBuilder.add(TrellisUtil.getTrellisFromVariant(trellis), temp);
        usedTranslationKeys.add(TrellisUtil.getTrellisFromVariant(trellis).getTranslationKey());
        for (VineCrop crop : TrellisUtil.VineCrops) {
            translationBuilder.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop), temp);
            usedTranslationKeys.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop).getTranslationKey());
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            translationBuilder.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), temp);
            usedTranslationKeys.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine).getTranslationKey());
        }
    }

    public void registerTrellisTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder, TrellisVariant trellis, String display) {
        translationBuilder.add(TrellisUtil.getTrellisFromVariant(trellis), display);
        usedTranslationKeys.add(TrellisUtil.getTrellisFromVariant(trellis).getTranslationKey());
        for (VineCrop crop : TrellisUtil.VineCrops) {
            translationBuilder.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop), display);
            usedTranslationKeys.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop).getTranslationKey());
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            translationBuilder.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), display);
            usedTranslationKeys.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine).getTranslationKey());
        }
    }
}
