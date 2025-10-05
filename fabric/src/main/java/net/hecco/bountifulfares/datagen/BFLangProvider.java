package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFaresUtil.toSentenceCase;

public class BFLangProvider extends FabricLanguageProvider {
    Set<String> usedTranslationKeys = new HashSet<>();

    public BFLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
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
        generate(translationBuilder, block.getDescriptionId(), translation);
    }

    private void generate(TranslationBuilder translationBuilder, Block block) {
        generate(translationBuilder, block.getDescriptionId(), toSentenceCase(BuiltInRegistries.BLOCK.getKey(block).getPath()));
    }

    private void generate(TranslationBuilder translationBuilder, Item item, String translation) {
        generate(translationBuilder, item.getDescriptionId(), translation);
    }

    private void generateJackOStraw(TranslationBuilder translationBuilder, Block block, String color) {
        generate(translationBuilder, block, color + " Jack o' Straw");
    }

    private void generateTag(TranslationBuilder translationBuilder, TagKey<Item> itemTag, String translation) {
        generate(translationBuilder, itemTag.getTranslationKey(), translation);
    }


    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        generate(translationBuilder, "itemgroup.bountiful_fares", "Bountiful Fares");
        generate(translationBuilder, "itemgroup.bountiful_fares_compatibility", "Bountiful Fares Compatibility");
        generate(translationBuilder, BFBlocks.HANGING_APPLE.get(), "Apple");
        generate(translationBuilder, BFBlocks.HANGING_ORANGE.get(), "Orange");
        generate(translationBuilder, BFBlocks.HANGING_LEMON.get(), "Lemon");
        generate(translationBuilder, BFBlocks.HANGING_PLUM.get(), "Plum");
        generate(translationBuilder, BFBlocks.HANGING_GOLDEN_APPLE.get(), "Golden Apple");
        generate(translationBuilder, BFBlocks.HANGING_WITHERED_GOLDEN_APPLE.get(), "Withered Golden Apple");



        generate(translationBuilder, BFBlocks.HOARY_APPLE_SAPLING_CROP.get(), "Hoary Apple Sapling");
        generate(translationBuilder, BFItems.HOARY_CHEST_BOAT.get(), "Hoary Boat with Chest");
        generate(translationBuilder, BFBlocks.HANGING_HOARY_APPLE.get(), "Hoary Apple");

        generate(translationBuilder, BFBlocks.CERAMIC_CLAY_BLOCK.get(), "Block of Ceramic Clay");
        generate(translationBuilder, BFBlocks.FLOUR_BLOCK.get(), "Block of Flour");
        //generate(translationBuilder, BFBlocks.CERAMIC_MOSAIC_WALL, "Ceramic Mosaic Wall");
        //generate(translationBuilder, BFBlocks.CERAMIC_TILE_WALL, "Ceramic Tile Wall");
        //generate(translationBuilder, BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL, "Checkered Ceramic Mosaic Wall");
        //generate(translationBuilder, BFBlocks.CHECKERED_CERAMIC_TILE_WALL, "Checkered Ceramic Tile Wall");

        generate(translationBuilder, BFItems.WALNUT_CHEST_BOAT.get(), "Walnut Boat with Chest");

        generate(translationBuilder, BFBlocks.HANGING_WALNUTS.get(), "Walnuts");

        generate(translationBuilder, BFBlocks.FELDSPAR_BRICK_WALL.get(), "Feldspar Brick Wall");

        generate(translationBuilder, BFBlocks.WALL_PALM_FROND.get(), "Palm Frond");

        generate(translationBuilder, BFBlocks.HOARY_SIGN.get(), "Hoary Sign");
        generate(translationBuilder, BFBlocks.HOARY_WALL_SIGN.get(), "Hoary Sign");
        generate(translationBuilder, BFItems.HOARY_SIGN.get(), "Hoary Sign");
        generate(translationBuilder, BFBlocks.HOARY_HANGING_SIGN.get(), "Hoary Hanging Sign");
        generate(translationBuilder, BFBlocks.HOARY_WALL_HANGING_SIGN.get(), "Hoary Hanging Sign");
        generate(translationBuilder, BFItems.HOARY_HANGING_SIGN.get(), "Hoary Hanging Sign");

        generate(translationBuilder, BFBlocks.WALNUT_SIGN.get(), "Walnut Sign");
        generate(translationBuilder, BFBlocks.WALNUT_WALL_SIGN.get(), "Walnut Sign");
        generate(translationBuilder, BFItems.WALNUT_SIGN.get(), "Walnut Sign");
        generate(translationBuilder, BFBlocks.WALNUT_HANGING_SIGN.get(), "Walnut Hanging Sign");
        generate(translationBuilder, BFBlocks.WALNUT_WALL_HANGING_SIGN.get(), "Walnut Hanging Sign");
        generate(translationBuilder, BFItems.WALNUT_HANGING_SIGN.get(), "Walnut Hanging Sign");

        generate(translationBuilder, BFItems.CUP.get(), "Cup");
        generate(translationBuilder, BFItems.APPLE_CIDER_JAR.get(), "Apple Cider Cup");
        generate(translationBuilder, BFItems.PLUM_CIDER_JAR.get(), "Plum Cider Cup");
        generate(translationBuilder, BFItems.HOARY_CIDER_JAR.get(), "Hoary Cider Cup");
        generate(translationBuilder, BFItems.APPLE_COMPOTE_JAR.get(), "Apple Compote Cup");
        generate(translationBuilder, BFItems.ORANGE_COMPOTE_JAR.get(), "Orange Compote Cup");
        generate(translationBuilder, BFItems.LEMON_COMPOTE_JAR.get(), "Lemon Compote Cup");
        generate(translationBuilder, BFItems.PLUM_COMPOTE_JAR.get(), "Plum Compote Cup");
        generate(translationBuilder, BFItems.HOARY_COMPOTE_JAR.get(), "Hoary Compote Cup");
        generate(translationBuilder, BFItems.GREEN_TEA_CUP.get(), "Green Tea Cup");
        generate(translationBuilder, BFItems.BLACK_TEA_CUP.get(), "Black Tea Cup");
        generate(translationBuilder, BFItems.CHAMOMILE_TEA_CUP.get(), "Chamomile Tea Cup");
        generate(translationBuilder, BFItems.HONEYSUCKLE_TEA_CUP.get(), "Honeysuckle Tea Cup");
        generate(translationBuilder, BFItems.BELLFLOWER_TEA_CUP.get(), "Bellflower Tea Cup");
        generate(translationBuilder, BFItems.TORCHFLOWER_TEA_CUP.get(), "Torchflower Tea Cup");

        for (DyeColor color : DyeColor.values()) {
            usedTranslationKeys.add("item.bountifulfares." + color.getName() + "_shulker_tiffin_back");
            usedTranslationKeys.add("item.bountifulfares." + color.getName() + "_shulker_tiffin_front");
        }

        generate(translationBuilder, "entity.bountifulfares.flour", "Flour");

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
        generate(translationBuilder, "effect.bountifulfares.restoration.description", "Regenerates health up to the health the player or mob had when this was applied.");
        generate(translationBuilder, "effect.bountifulfares.enrichment", "Enrichment");
        generate(translationBuilder, "effect.bountifulfares.enrichment.description", "Minor buffs to most stats.");



//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.OAK), "Oak Trellis");
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.SPRUCE));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.BIRCH));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.JUNGLE));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.ACACIA));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.DARK_OAK));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.MANGROVE));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.CHERRY));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.BAMBOO));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.WALNUT));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.HOARY));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.CRIMSON));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(BFTrellises.WARPED));
//
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(ExcessiveBuildingBlocks.ANCIENT));
//
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(MintBlocks.WINTERGREEN));
//
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SAXAUL));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW));
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA));
//
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(SpawnBlocks.ROTTEN));
//
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(ArtsAndCraftsBlocks.CORK));
//
//        generate(translationBuilder, TrellisUtil.getTrellisFromVariant(DungeonsDelightBlocks.WORMWOOD));



        generate(translationBuilder, BFBlocks.MAIZE_CROP.get(), "Maize");



        generate(translationBuilder, "effect.bountifulfares.ebullience", "Ebullience");
        generate(translationBuilder, "effect.bountifulfares.ebullience.description", "Negates exhaustion from actions like mining or walking.");
//        generate(translationBuilder, "effect.bountifulfares.gorging", "Gorging");


        generateJackOStraw(translationBuilder, BFBlocks.RED_JACK_O_STRAW.get(), "Red");
        generateJackOStraw(translationBuilder, BFBlocks.ORANGE_JACK_O_STRAW.get(), "Orange");
        generateJackOStraw(translationBuilder, BFBlocks.YELLOW_JACK_O_STRAW.get(), "Yellow");
        generateJackOStraw(translationBuilder, BFBlocks.LIME_JACK_O_STRAW.get(), "Lime");
        generateJackOStraw(translationBuilder, BFBlocks.GREEN_JACK_O_STRAW.get(), "Green");
        generateJackOStraw(translationBuilder, BFBlocks.CYAN_JACK_O_STRAW.get(), "Cyan");
        generateJackOStraw(translationBuilder, BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get(), "Light Blue");
        generateJackOStraw(translationBuilder, BFBlocks.BLUE_JACK_O_STRAW.get(), "Blue");
        generateJackOStraw(translationBuilder, BFBlocks.PURPLE_JACK_O_STRAW.get(), "Purple");
        generateJackOStraw(translationBuilder, BFBlocks.MAGENTA_JACK_O_STRAW.get(), "Magenta");
        generateJackOStraw(translationBuilder, BFBlocks.PINK_JACK_O_STRAW.get(), "Pink");
        generateJackOStraw(translationBuilder, BFBlocks.WHITE_JACK_O_STRAW.get(), "White");
        generateJackOStraw(translationBuilder, BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get(), "Light Gray");
        generateJackOStraw(translationBuilder, BFBlocks.GRAY_JACK_O_STRAW.get(), "Gray");
        generateJackOStraw(translationBuilder, BFBlocks.BLACK_JACK_O_STRAW.get(), "Black");
        generateJackOStraw(translationBuilder, BFBlocks.BROWN_JACK_O_STRAW.get(), "Brown");

//        generateJackOStraw(translationBuilder, MintBlocks.ACORN_JACK_O_STRAW, "Acorn");
//        generateJackOStraw(translationBuilder, MintBlocks.AMBER_JACK_O_STRAW, "Amber");
//        generateJackOStraw(translationBuilder, MintBlocks.ARTICHOKE_JACK_O_STRAW, "Artichoke");
//        generateJackOStraw(translationBuilder, MintBlocks.BANANA_JACK_O_STRAW, "Banana");
//        generateJackOStraw(translationBuilder, MintBlocks.CERULEAN_JACK_O_STRAW, "Cerulean");
//        generateJackOStraw(translationBuilder, MintBlocks.FUCHSIA_JACK_O_STRAW, "Fuchsia");
//        generateJackOStraw(translationBuilder, MintBlocks.GRAPE_JACK_O_STRAW, "Grape");
//        generateJackOStraw(translationBuilder, MintBlocks.INDIGO_JACK_O_STRAW, "Indigo");
//        generateJackOStraw(translationBuilder, MintBlocks.MAROON_JACK_O_STRAW, "Maroon");
//        generateJackOStraw(translationBuilder, MintBlocks.MAUVE_JACK_O_STRAW, "Mauve");
//        generateJackOStraw(translationBuilder, MintBlocks.MINT_JACK_O_STRAW, "Mint");
//        generateJackOStraw(translationBuilder, MintBlocks.MOLD_JACK_O_STRAW, "Mold");
//        generateJackOStraw(translationBuilder, MintBlocks.NAVY_JACK_O_STRAW, "Navy");
//        generateJackOStraw(translationBuilder, MintBlocks.PEACH_JACK_O_STRAW, "Peach");
//        generateJackOStraw(translationBuilder, MintBlocks.PERIWINKLE_JACK_O_STRAW, "Periwinkle");
//        generateJackOStraw(translationBuilder, MintBlocks.SAGE_JACK_O_STRAW, "Sage");
//        generateJackOStraw(translationBuilder, MintBlocks.SAP_JACK_O_STRAW, "Sap");
//        generateJackOStraw(translationBuilder, MintBlocks.SHAMROCK_JACK_O_STRAW, "Shamrock");
//        generateJackOStraw(translationBuilder, MintBlocks.VELVET_JACK_O_STRAW, "Velvet");
//        generateJackOStraw(translationBuilder, MintBlocks.VERMILION_JACK_O_STRAW, "Vermilion");
//
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.MAROON_JACK_O_STRAW, "Maroon");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.ROSE_JACK_O_STRAW, "Rose");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.CORAL_JACK_O_STRAW, "Coral");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.GINGER_JACK_O_STRAW, "Ginger");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.TAN_JACK_O_STRAW, "Tan");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.BEIGE_JACK_O_STRAW, "Beige");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.AMBER_JACK_O_STRAW, "Amber");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.OLIVE_JACK_O_STRAW, "Olive");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.FOREST_JACK_O_STRAW, "Forest");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.VERDANT_JACK_O_STRAW, "Verdant");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.TEAL_JACK_O_STRAW, "Teal");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.MINT_JACK_O_STRAW, "Mint");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.AQUA_JACK_O_STRAW, "Aqua");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.SLATE_JACK_O_STRAW, "Slate");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.NAVY_JACK_O_STRAW, "Navy");
//        generateJackOStraw(translationBuilder, DyeDepotBlocks.INDIGO_JACK_O_STRAW, "Indigo");
//
//        generateJackOStraw(translationBuilder, DelicateDyesBlocks.CORAL_JACK_O_STRAW, "Coral");
//        generateJackOStraw(translationBuilder, DelicateDyesBlocks.CANARY_JACK_O_STRAW, "Canary");
//        generateJackOStraw(translationBuilder, DelicateDyesBlocks.WASABI_JACK_O_STRAW, "Wasabi");
//        generateJackOStraw(translationBuilder, DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW, "Sacramento");
//        generateJackOStraw(translationBuilder, DelicateDyesBlocks.SKY_JACK_O_STRAW, "Sky");
//        generateJackOStraw(translationBuilder, DelicateDyesBlocks.BLURPLE_JACK_O_STRAW, "Blurple");
//        generateJackOStraw(translationBuilder, DelicateDyesBlocks.SANGRIA_JACK_O_STRAW, "Sangria");
//        generateJackOStraw(translationBuilder, DelicateDyesBlocks.ROSE_JACK_O_STRAW, "Rose");



        generate(translationBuilder, "tooltip.bountifulfares.dyeable", "Dyeable");
        generate(translationBuilder, "tooltip.bountifulfares.when_lit", "While lit:");
        generate(translationBuilder, "tooltip.bountifulfares.removes", "Removes:");
        generate(translationBuilder, "tooltip.bountifulfares.when_eaten", "When consumed:");
        generate(translationBuilder, "tooltip.bountifulfares.when_drunk", "When drunk:");
        generate(translationBuilder, "tooltip.bountifulfares.air_time", "Oxygen");
        generate(translationBuilder, "tooltip.bountifulfares.removes_all_effects", "Removes all effects");
        generate(translationBuilder, "tooltip.bountifulfares.dilutes_negative_effects", "Dilutes negative effects");
        generate(translationBuilder, "tooltip.bountifulfares.shulker_tiffin.empty", "Empty");
        generate(translationBuilder, "tooltip.bountifulfares.shulker_tiffin.full", "Full");


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
        generate(translationBuilder, "warning.bountifulfares.fermentation_vessel.bountifulfares:jar", "Use a Cup to collect this");
        generate(translationBuilder, "warning.bountifulfares.fermentation_vessel.minecraft:bucket", "Use a Bucket to collect this");
        generate(translationBuilder, "warning.bountifulfares.fermentation_vessel.minecraft:bowl", "Use a Bowl to collect this");

        generate(translationBuilder, "advancement.bountifulfares.bountiful_fares", "Bountiful Fares");
        generate(translationBuilder, "advancement.bountifulfares.bountiful_fares.description", "The world is filled with more food!");

        generate(translationBuilder, "advancement.bountifulfares.pick_fruit", "Green Thumb");
        generate(translationBuilder, "advancement.bountifulfares.pick_fruit.description", "Pick a ripe fruit from a fruit tree");

        generate(translationBuilder, "advancement.bountifulfares.obtain_all_fruit", "Exotic!");
        generate(translationBuilder, "advancement.bountifulfares.obtain_all_fruit.description", "Obtain every type of fruit from fruit trees");

        generate(translationBuilder, "advancement.bountifulfares.plant_on_trellis", "Trellising it");
        generate(translationBuilder, "advancement.bountifulfares.plant_on_trellis.description", "Plant a vine crop or decorative plant on a Trellis");

        generate(translationBuilder, "advancement.bountifulfares.place_gristmill", "On The Grind");
        generate(translationBuilder, "advancement.bountifulfares.place_gristmill.description", "Place a Gristmill, which is used to grind down materials");

        generate(translationBuilder, "advancement.bountifulfares.obtain_feldspar", "Felsic Forager");
        generate(translationBuilder, "advancement.bountifulfares.obtain_feldspar.description", "Collect Feldspar from milling stones");

        generate(translationBuilder, "advancement.bountifulfares.obtain_ceramic_clay", "It's Tofu!!!    ");
        generate(translationBuilder, "advancement.bountifulfares.obtain_ceramic_clay.description", "Craft Ceramic Clay from Feldspar and Clay Balls, which is used for many decorations and useful blocks");

        generate(translationBuilder, "advancement.bountifulfares.obtain_flour", "Stop and Smell the Flours");
        generate(translationBuilder, "advancement.bountifulfares.obtain_flour.description", "Mill grains into Flour, a basis for many baked goods");

        generate(translationBuilder, "advancement.bountifulfares.throw_flour_as_cover", "Poof!");
        generate(translationBuilder, "advancement.bountifulfares.throw_flour_as_cover.description", "Throw Flour at your feet to make a quick escape!");

        generate(translationBuilder, "advancement.bountifulfares.obtain_artisan_brush", "I'm Something of an Artist");
        generate(translationBuilder, "advancement.bountifulfares.obtain_artisan_brush.description", "Obtain an Artisan Brush, which is used to dye blocks and items");

        generate(translationBuilder, "advancement.bountifulfares.dye_leather_armor_on_armor_stand", "High Fashion");
        generate(translationBuilder, "advancement.bountifulfares.dye_leather_armor_on_armor_stand.description", "Dye a piece of leather armor on an Armor Stand using an Artisan Brush");

        generate(translationBuilder, "advancement.bountifulfares.dye_ceramic_block", "Roy G Biv");
        generate(translationBuilder, "advancement.bountifulfares.dye_ceramic_block.description", "Dye a ceramic block any color...§o any color");

        generate(translationBuilder, "advancement.bountifulfares.feed_wolf_mulch", "Mulchmaxxer");
        generate(translationBuilder, "advancement.bountifulfares.feed_wolf_mulch.description", "Feed a wolf mulch...delicious!");

        generate(translationBuilder, "advancement.bountifulfares.how_easy", "How Easy...");
        generate(translationBuilder, "advancement.bountifulfares.how_easy.description", "Threaten to squeeze a Lemon Block");

        generate(translationBuilder, "advancement.bountifulfares.obtain_fermentation_vessel", "Toil and Trouble");
        generate(translationBuilder, "advancement.bountifulfares.obtain_fermentation_vessel.description", "Craft a Fermentation Vessel - fill it with water and an item to ferment");

        generate(translationBuilder, "advancement.bountifulfares.eat_ancient_fruit", "How Long Has This Sat Out?");
        generate(translationBuilder, "advancement.bountifulfares.eat_ancient_fruit.description", "Eat a fruit from the distant past");

        generate(translationBuilder, "advancement.bountifulfares.place_all_baked_goods", "Baker's Dozen");
        generate(translationBuilder, "advancement.bountifulfares.place_all_baked_goods.description", "Place every baked good");

        generate(translationBuilder, "advancement.bountifulfares.eat_citrus_essence", "Agh, Heartburn!");
        generate(translationBuilder, "advancement.bountifulfares.eat_citrus_essence.description", "Eat Citric Essence, made from fermenting a citrus fruit");

        generate(translationBuilder, "advancement.bountifulfares.acidify_effect_2_levels", "This Can't be Good for You");
        generate(translationBuilder, "advancement.bountifulfares.acidify_effect_2_levels.description", "Acidify another effect enough to increase its amplifier by 2");

        generate(translationBuilder, "advancement.bountifulfares.obtain_sun_hat", "Who's The Farmer Now?");
        generate(translationBuilder, "advancement.bountifulfares.obtain_sun_hat.description", "Obtain a Sun Hat");

        generate(translationBuilder, "advancement.bountifulfares.eat_all_candy", "Sweet Tooth");
        generate(translationBuilder, "advancement.bountifulfares.eat_all_candy.description", "Eat every Candy");

        generate(translationBuilder, "advancement.bountifulfares.obtain_tea_blends", "Tea Tea");
        generate(translationBuilder, "advancement.bountifulfares.obtain_tea_blends.description", "Obtain every cup of tea");

        generate(translationBuilder, "advancement.bountifulfares.place_all_tea_candles", "Fragrant!");
        generate(translationBuilder, "advancement.bountifulfares.place_all_tea_candles.description", "Place every Infused Candle");

        generate(translationBuilder, "advancement.bountifulfares.obtain_walnut", "Insert Funny Nut Phrase");
        generate(translationBuilder, "advancement.bountifulfares.obtain_walnut.description", "Find a Walnut which has fallen from its tree");

        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin_seeds", "A Spongy Place");
        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin_seeds.description", "Discover the source of all these Sponges...");

        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin", "Loofah Under the Sea");
        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin.description", "Grow and collect a Spongekin underwater");

        generate(translationBuilder, "advancement.bountifulfares.obtain_prismarine_blossom", "Maribiogeological");
        generate(translationBuilder, "advancement.bountifulfares.obtain_prismarine_blossom.description", "Grow a Spongekin from a Sea Lantern to propagate its crystals");

        generate(translationBuilder, "advancement.bountifulfares.make_first_food", "Anyone Can Cook");
        generate(translationBuilder, "advancement.bountifulfares.make_first_food.description", "Make your first meal");

        generate(translationBuilder, "advancement.bountifulfares.eat_all_food", "Bountiful Cuisine");
        generate(translationBuilder, "advancement.bountifulfares.eat_all_food.description", "Eat every food - what a connoisseur!");

        generate(translationBuilder, "advancement.bountifulfares.eat_all_bad_foods", "An Aquired Taste");
        generate(translationBuilder, "advancement.bountifulfares.eat_all_bad_foods.description", "Eat every food that isn't exactly good for you...");

        generate(translationBuilder, "advancement.bountifulfares.obtain_golden_apple_sapling", "Money Does Grow On Trees!");
        generate(translationBuilder, "advancement.bountifulfares.obtain_golden_apple_sapling.description", "Find a Golden Apple Sapling, hidden away in the walls of Woodland Mansions");

        generate(translationBuilder, "advancement.bountifulfares.obtain_golden_apple", "Golden Thumb");
        generate(translationBuilder, "advancement.bountifulfares.obtain_golden_apple.description", "Cultivate a Golden Apple Tree in a dark environment and pick one of its golden fruit");

        generate(translationBuilder, "advancement.bountifulfares.obtain_tiffin", "Chef's Bundle");
        generate(translationBuilder, "advancement.bountifulfares.obtain_tiffin.description", "Craft a Shulker Tiffin");

        generate(translationBuilder, "advancement.bountifulfares.fill_tiffin", "Meal Prepping");
        generate(translationBuilder, "advancement.bountifulfares.fill_tiffin.description", "Completely fill a Shulker Tiffin with food");

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

        generate(translationBuilder, "subtitles.block.popped_maize.pop", "Maize pops");

        generate(translationBuilder, "subtitles.item.bountifulfares.shulker_tiffin.insert", "Shulker Tiffin fills");
        generate(translationBuilder, "subtitles.item.bountifulfares.shulker_tiffin.remove", "Shulker Tiffin empties");

        generate(translationBuilder, "subtitles.item.bountifulfares.golden_apple_sapling.ambient", "Something glistens");

        generate(translationBuilder, "jei.info.appledog_block", "appledog is full of joy, appledog is full of more joy when clicked!");
        generate(translationBuilder, "jei.info.golden_apple_sapling", "Golden Apple Trees are highly sensitive to light, and will wither and die if exposed to any higher than level 8. Additionally, no more fruit can be created after a tree is grown from a sapling.\n" +
                "\n" +
                "§o7 Golden Apple Trees are the Illagers’ most successful experiment throughout their endeavors into meddling with the world around them. Being able to convert a common Apple Tree into a living source of powerful foods was a revolution, however they were paranoid that their foes would discover their achievement. Now they can only be found growing in the darkness of the walls within Woodland Mansions, in secret, and guarded by troops of Illagers.");
        generate(translationBuilder, "jei.info.ceramic_dish", "Allows items to be placed and eaten ontop of it. Foods with containers normally cannot be eaten on dishes (can be changed in the mod's config)");
        generate(translationBuilder, "jei.info.artisian_brush", "While dyed this item can dye the color of ceramic blocks. If interacting with a dyeable ceramic block while crouching, the block's color will be copied to the brush. If both colors match, the ceramic block will become checkered (only applies to certain blocks)");
        generate(translationBuilder, "jei.info.prismarine_blossom", "Can be obtained when a spongekin grows from a sea lantern.");
        generate(translationBuilder, "jei.info.fermentation_vessel", "When ingredients are placed inside they will ferment over some time. The time taken to ferment can be changed in the config.");
        generate(translationBuilder, "jei.info.artisan_food", "Can be eaten when placed.");
        generate(translationBuilder, "jei.info.artisan_cookie", "Can be eaten when placed, up to 4 cookies can be stacked in a block.");
        generate(translationBuilder, "jei.info.fruit_leaves", "Can grow fruits underneath it when bonemealed.");
        generate(translationBuilder, "jei.info.chance_to_heal", "Has a chance to heal the user when consumed.");


        generate(translationBuilder, "bountifulfares.configuration.title", "Bountiful Fares Configuration");

//        generate(translationBuilder, "bountifulfares.configuration.category.client", "Client");
        generate(translationBuilder, "bountifulfares.configuration.category.gameplay", "Gameplay");
//        generate(translationBuilder, "bountifulfares.configuration.category.paintings", "Paintings");
//        generate(translationBuilder, "bountifulfares.configuration.category.world", "World");
        generate(translationBuilder, "bountifulfares.configuration.category.client", "Client");
//        generate(translationBuilder, "bountifulfares.configuration.category.compat", "Compatibility");
//        generate(translationBuilder, "bountifulfares.configuration.category.mint", "El's and L's Dye Mod");
//        generate(translationBuilder, "bountifulfares.configuration.category.dye_depot", "Dye Depot");

        generate(translationBuilder, "bountifulfares.configuration.restart_warning", "Requires a restart to apply changes");

//        generate(translationBuilder, "bountifulfares.configuration.item_guide_tooltips", "Show information in some items' tooltip");
        generate(translationBuilder, "bountifulfares.configuration.fruit_replace_when_picked", "Fruits on trees replant when picked");
        generate(translationBuilder, "bountifulfares.configuration.flour_throwing", "Flour can be thrown");
        generate(translationBuilder, "bountifulfares.configuration.flour_throwing_cooldown", "Flour throwing cooldown, in ticks");
        generate(translationBuilder, "bountifulfares.configuration.container_foods_eatable_on_dish", "Foods with containers can be eaten on Ceramic Dishes");
        generate(translationBuilder, "bountifulfares.configuration.restoration_overlay", "Restoration effect changes health icons");
        generate(translationBuilder, "bountifulfares.configuration.acidified_effect_icon_effects", "Status Effects modified by Acidity have visual effects");
        generate(translationBuilder, "bountifulfares.configuration.effect_tooltips", "Foods have effect tooltips");
        generate(translationBuilder, "bountifulfares.configuration.placeable_pumpkin_pie", "Pumpkin Pie can be placed as a block");
        generate(translationBuilder, "bountifulfares.configuration.cake_eating_sounds", "Cakes make eating sounds");
        generate(translationBuilder, "bountifulfares.configuration.sweet_berry_pips", "Sweet Berries cannot place Sweet Berry Bushes");
        generate(translationBuilder, "bountifulfares.configuration.lapisberry_seeds", "Sniffers can dig up Lapisberry Seeds");
        generate(translationBuilder, "bountifulfares.configuration.hoary_seeds", "Sniffers can dig up Hoary Seeds");
        generate(translationBuilder, "bountifulfares.configuration.grass_loot_table_override", "Grass loot tables are overridden");
        generate(translationBuilder, "bountifulfares.configuration.spongekin_seeds_guardian", "Guardians drop Spongekin Seeds");
        generate(translationBuilder, "bountifulfares.configuration.milling_time", "Gristmill milling time, in seconds");
        generate(translationBuilder, "bountifulfares.configuration.fermentation_time", "Fermentation time, in seconds");
        generate(translationBuilder, "bountifulfares.configuration.fermentation_bubble_particles", "Fermentation Vessels emit bubble particles");
        generate(translationBuilder, "bountifulfares.configuration.infused_candle_radius", "Size of area where Infused Candles give effects");
        generate(translationBuilder, "bountifulfares.configuration.show_compat_items_in_recipe_viewers", "Show compatibility items in recipe viewers");
        generate(translationBuilder, "bountifulfares.configuration.tiffin_corner_food_icon", "Show food inside Shulker Tiffins in the corner of the slot");
        generate(translationBuilder, "bountifulfares.configuration.show_tiffin_food_in_hand", "Show food inside Shulker Tiffins in players' hands");
//        generate(translationBuilder, "bountifulfares.configuration.bountiful_painting", "Allow \"Bountiful\" painting to be placed");
//        generate(translationBuilder, "bountifulfares.configuration.citrus_dish_painting", "Allow \"Citrus Dish\" painting to be placed");
//        generate(translationBuilder, "bountifulfares.configuration.hazel_floret_painting", "Allow \"Hazel Floret\" painting to be placed");
//        generate(translationBuilder, "bountifulfares.configuration.violet_floret_painting", "Allow \"Violet Floret\" painting to be placed");
//        generate(translationBuilder, "bountifulfares.configuration.why_blue_painting", "Allow \"Why Blue\" painting to be placed");
//        generate(translationBuilder, "bountifulfares.configuration.ruminer_painting", "Allow \"Ruminer\" painting to be placed");
//        generate(translationBuilder, "bountifulfares.configuration.phylogenesis_painting", "Allow \"Phylogenesis\" painting to be placed");
//        generate(translationBuilder, "bountifulfares.configuration.escalade_painting", "Allow \"Escalade\" painting to be placed");
//        generate(translationBuilder, "bountifulfares.configuration.aquaculture_painting", "Allow \"Aquaculture\" painting to be placed");
//        generate(translationBuilder, "bountifulfares.configuration.unpleasant_tiles_painting", "Allow \"Unpleasant Tiles\" painting to be placed");
//        generate(translationBuilder, "bountifulfares.configuration.wild_wheat", "Generate Wild Wheat");
//        generate(translationBuilder, "bountifulfares.configuration.wild_carrots", "Generate Wild Carrots");
//        generate(translationBuilder, "bountifulfares.configuration.wild_potatoes", "Generate Wild Potatoes");
//        generate(translationBuilder, "bountifulfares.configuration.wild_beetroot", "Generate Wild Beetroot");
//        generate(translationBuilder, "bountifulfares.configuration.wild_leeks", "Generate Wild Leeks");
//        generate(translationBuilder, "bountifulfares.configuration.wild_maize", "Generate Wild Maize");
//        generate(translationBuilder, "bountifulfares.configuration.apple_trees", "Generate Apple Trees");
//        generate(translationBuilder, "bountifulfares.configuration.orange_trees", "Generate Orange Trees");
//        generate(translationBuilder, "bountifulfares.configuration.lemon_trees", "Generate Lemon Trees");
//        generate(translationBuilder, "bountifulfares.configuration.plum_trees", "Generate Plum Trees");
//        generate(translationBuilder, "bountifulfares.configuration.palm_trees", "Generate Palm Trees");
//        generate(translationBuilder, "bountifulfares.configuration.grassy_dirt_patches", "Generate Patches of Grassy Dirt");
//        generate(translationBuilder, "bountifulfares.configuration.wild_passion_fruit", "Generate Wild Passion Fruit");
//        generate(translationBuilder, "bountifulfares.configuration.wild_elderberries", "Generate Wild Elderberries");
//        generate(translationBuilder, "bountifulfares.configuration.golden_apple_tree_rooms", "Generate Golden Apple Trees in Woodland Mansions");
//        generate(translationBuilder, "bountifulfares.configuration.flower_forest_fruit_trees", "Generate fruit trees in Flower Forests");
//        generate(translationBuilder, "bountifulfares.configuration.forest_tea_shrubs", "Generate Tea Shrubs in Forests");
//        generate(translationBuilder, "bountifulfares.configuration.forest_walnut_trees", "Generate Walnut Trees in Forests");
//        generate(translationBuilder, "bountifulfares.configuration.honeysuckle_to_banana_dye", "Honeysuckles craft into Banana Dye");
//        generate(translationBuilder, "bountifulfares.configuration.rename_items_to_match_dyes", "Rename dyed items to match Dye Depot's override pack");
//        generate(translationBuilder, "bountifulfares.configuration.honeysuckle_to_amber_dye", "Honeysuckles craft into Amber Dye");
//        generate(translationBuilder, "bountifulfares.configuration.chamomile_to_beige_dye", "Chamomile Flowers craft into Beige Dye");

//        generate(translationBuilder, "pack.bountifulfares.vanilla_item_override", "Vanilla Item Texture Override");
//        generate(translationBuilder, "pack.bountifulfares.grass_loot_table_override", "Grass Loot Table Override");
//        generate(translationBuilder, "pack.bountifulfares.amendments", "Bountiful Fares X Amendments");
//        generate(translationBuilder, "pack.bountifulfares.mint", "Bountiful Fares X El's and L's Dye Mod");
//        generate(translationBuilder, "pack.bountifulfares.dye_depot", "Bountiful Fares X Dye Depot");
//        generate(translationBuilder, "pack.bountifulfares.natures_spirit", "Bountiful Fares X Nature's Spirit");
//        generate(translationBuilder, "pack.bountifulfares.excessive_building", "Bountiful Fares X Excessive Building");
//        generate(translationBuilder, "pack.bountifulfares.spawn", "Bountiful Fares X Spawn");
//        generate(translationBuilder, "pack.bountifulfares.farmersdelight", "Bountiful Fares X Farmer's Delight");
//        generate(translationBuilder, "pack.bountifulfares.twigs", "Bountiful Fares X Twigs");
//        generate(translationBuilder, "pack.bountifulfares.delicate_dyes", "Bountiful Fares X Delicate Dyes");
//        generate(translationBuilder, "pack.bountifulfares.appledog", "Bountiful Fares X Appledog!");
//        generate(translationBuilder, "pack.bountifulfares.dungeons_delight", "Bountiful Fares X Dungeon's Delight");

        generate(translationBuilder, "death.attack.falling_coconut", "%1$s was bonked too hard");

        generate(translationBuilder, "bountifulfares.milling", "Milling");
        generate(translationBuilder, "bountifulfares.fermenting", "Fermenting");
        generate(translationBuilder, "bountifulfares.prismarine_propagation", "Prismarine Propagation");
        generate(translationBuilder, "jei.bountifulfares.collect_using", "Collect using ");
        generate(translationBuilder, "jei.bountifulfares.minutes", "minutes");
        generate(translationBuilder, "jei.bountifulfares.seconds", "seconds");

        generateTag(translationBuilder, BFItemTags.C_MILKS, "Milks");
        generateTag(translationBuilder, BFItemTags.C_FLOUR, "Flours");
        generateTag(translationBuilder, BFItemTags.C_ORANGES, "Oranges");
        generateTag(translationBuilder, BFItemTags.C_LEMONS, "Lemons");
        generateTag(translationBuilder, BFItemTags.C_PLUMS, "Plums");
        generateTag(translationBuilder, BFItemTags.C_PASSION_FRUIT, "Passion Fruit");
        generateTag(translationBuilder, BFItemTags.C_ELDERBERRIES, "Elderberries");
        generateTag(translationBuilder, BFItemTags.C_WALNUTS, "Walnuts");
        generateTag(translationBuilder, BFItemTags.C_COCONUT_HALVES, "Coconut Halves");
        generateTag(translationBuilder, BFItemTags.C_CORN, "Corn");

        generateTag(translationBuilder, BFItemTags.APPLE_LOGS, "Apple Logs");
        generateTag(translationBuilder, BFItemTags.ORANGE_LOGS, "Orange Logs");
        generateTag(translationBuilder, BFItemTags.LEMON_LOGS, "Lemon Logs");
        generateTag(translationBuilder, BFItemTags.PLUM_LOGS, "Plum Logs");
        generateTag(translationBuilder, BFItemTags.HOARY_LOGS, "Hoary Logs");
        generateTag(translationBuilder, BFItemTags.WALNUT_LOGS, "Walnut Logs");
        generateTag(translationBuilder, BFItemTags.PALM_LOGS, "Palm Logs");
        generateTag(translationBuilder, BFItemTags.GOLDEN_APPLE_LOGS, "Golden Apple Logs");
        generateTag(translationBuilder, BFItemTags.APPLE_LEAVES, "Apple Leaves");
        generateTag(translationBuilder, BFItemTags.ORANGE_LEAVES, "Orange Leaves");
        generateTag(translationBuilder, BFItemTags.LEMON_LEAVES, "Lemon Leaves");
        generateTag(translationBuilder, BFItemTags.PLUM_LEAVES, "Plum Leaves");
        generateTag(translationBuilder, BFItemTags.GOLDEN_APPLE_LEAVES, "Golden Apple Leaves");
        generateTag(translationBuilder, BFItemTags.FRUIT_LOGS, "Fruit Logs");
        generateTag(translationBuilder, BFItemTags.JACK_O_STRAW_LIGHTABLE, "Can Light Jack O' Straws");
        generateTag(translationBuilder, BFItemTags.DYES, "Dyes");
        generateTag(translationBuilder, BFItemTags.DYEABLE_CERAMIC_BLOCKS, "Dyeable Ceramic Blocks");
        generateTag(translationBuilder, BFItemTags.FELSIC_STONES, "Felsic Stones");
        generateTag(translationBuilder, BFItemTags.VINE_CROP_SEEDS, "Vine Crop Seeds");
        generateTag(translationBuilder, BFItemTags.PLANTABLE_ON_TRELLIS, "Plantable On Trellis");
        generateTag(translationBuilder, BFItemTags.COOKED_FISHES, "Cooked Fishes");
        generateTag(translationBuilder, BFItemTags.MEALS, "Meals");
        generateTag(translationBuilder, BFItemTags.GRASS_SEEDS_PLANTABLE_ON, "Can Plant Grass Seeds On");
        generateTag(translationBuilder, BFItemTags.PICKETS, "Pickets");
        generateTag(translationBuilder, BFItemTags.MULCH, "Mulches");
        generateTag(translationBuilder, BFItemTags.SUGAR_INGREDIENTS, "Sugar Ingredients");
        generateTag(translationBuilder, BFItemTags.CERAMIC_DISH_BLACKLIST, "Inedible On Ceramic Dish");
        generateTag(translationBuilder, BFItemTags.TIFFINS, "Tiffins");
        generateTag(translationBuilder, BFItemTags.SPONGEKIN_INGREDIENTS, "Spongekin Ingredients");
        generateTag(translationBuilder, BFItemTags.BEETROOT_INGREDIENTS, "Beetroot Ingredient");

        generate(translationBuilder, "emi.category.bountifulfares.milling", "Milling");
        generate(translationBuilder, "emi.category.bountifulfares.fermenting", "Fermenting");
        generate(translationBuilder, "emi.category.bountifulfares.prismarine_propagation", "Prismarine Propagation");

        for(ResourceLocation id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.MOD_ID)) {
            String key = BuiltInRegistries.BLOCK.get(id).getDescriptionId();
            if(usedTranslationKeys.contains(key)) { continue; }
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentenceCase(id.getPath()));
        }
        for(ResourceLocation id : BountifulFaresUtil.allItemIdsInNamespace(BountifulFares.MOD_ID)) {
            String key = BuiltInRegistries.ITEM.get(id).getDescriptionId();
            if (usedTranslationKeys.contains(key)) {
                continue;
            }
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentenceCase(id.getPath()));
        }

        var compat_content = BountifulFares.COMPAT_MANAGER.CONTENT.keySet().stream().map(Supplier::get).toList();
        for (Object content : compat_content) {
            if (content instanceof Block block && !usedTranslationKeys.contains(block.getDescriptionId())) {
                translationBuilder.add(block.getDescriptionId(), toSentenceCase(BuiltInRegistries.BLOCK.getKey(block).getPath()));
                usedTranslationKeys.add(block.getDescriptionId());
            }
            if (content instanceof Item item && !usedTranslationKeys.contains(item.getDescriptionId())) {
                translationBuilder.add(item.getDescriptionId(), toSentenceCase(BuiltInRegistries.ITEM.getKey(item).getPath()));
                usedTranslationKeys.add(item.getDescriptionId());
            }
        }

    }
}
