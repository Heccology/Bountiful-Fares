package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.trellis.BFTrellises;
import net.hecco.bountifulfares.item.BFItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

import static net.hecco.bountifulfares.trellis.TrellisUtil.registerTrellisTranslations;

public class BFLangProvider extends FabricLanguageProvider {
    public BFLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    // Lang gen capitalization code by Hibiscus Team's Natures Spirit
    public static String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for(int i = 0; i < chars.length; i++) {
            if(!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            }
            else if(Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') {
                found = false;
            }
        }
        return String.valueOf(chars);
    }
    private void generate(TranslationBuilder translationBuilder, Block block) {
        String temp = capitalizeString(Registries.BLOCK.getId(block).getPath().replace("_", " "));
        translationBuilder.add(block, temp);
    }
    private void generate(TranslationBuilder translationBuilder, Item item) {
        String temp = capitalizeString(Registries.ITEM.getId(item).getPath().replace("_", " "));
        translationBuilder.add(item, temp);
    }

    private void generate(TranslationBuilder translationBuilder, Block block, String display) {
        translationBuilder.add(block, display);
    }
    private void generate(TranslationBuilder translationBuilder, Item item, String display) {
        translationBuilder.add(item, display);
    }
    private void generate(TranslationBuilder translationBuilder, String id, String display) {
        translationBuilder.add(id, display);
    }

    private void generateJackOStraw(TranslationBuilder translationBuilder, Block block, String color) {
        translationBuilder.add(block, color + " Jack O' Straw");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        generate(translationBuilder, "itemgroup.bountiful_fares", "Bountiful Fares");
        generate(translationBuilder, BFBlocks.APPLE_LOG);
        generate(translationBuilder, BFBlocks.STRIPPED_APPLE_LOG);
        generate(translationBuilder, BFBlocks.APPLE_WOOD);
        generate(translationBuilder, BFBlocks.STRIPPED_APPLE_WOOD);
        generate(translationBuilder, BFBlocks.APPLE_LEAVES);
        generate(translationBuilder, BFBlocks.FLOWERING_APPLE_LEAVES);
        generate(translationBuilder, BFBlocks.APPLE_SAPLING);
        generate(translationBuilder, BFBlocks.APPLE_BLOCK);
        generate(translationBuilder, BFBlocks.GOLDEN_APPLE_BLOCK);
        generate(translationBuilder, BFBlocks.HANGING_APPLE, "Apple");

        generate(translationBuilder, BFItems.ORANGE);
        generate(translationBuilder, BFBlocks.ORANGE_LOG);
        generate(translationBuilder, BFBlocks.STRIPPED_ORANGE_LOG);
        generate(translationBuilder, BFBlocks.ORANGE_WOOD);
        generate(translationBuilder, BFBlocks.STRIPPED_ORANGE_WOOD);
        generate(translationBuilder, BFBlocks.ORANGE_LEAVES);
        generate(translationBuilder, BFBlocks.FLOWERING_ORANGE_LEAVES);
        generate(translationBuilder, BFBlocks.ORANGE_SAPLING);
        generate(translationBuilder, BFBlocks.ORANGE_BLOCK);
        generate(translationBuilder, BFBlocks.HANGING_ORANGE, "Orange");

        generate(translationBuilder, BFItems.LEMON);
        generate(translationBuilder, BFBlocks.LEMON_LOG);
        generate(translationBuilder, BFBlocks.STRIPPED_LEMON_LOG);
        generate(translationBuilder, BFBlocks.LEMON_WOOD);
        generate(translationBuilder, BFBlocks.STRIPPED_LEMON_WOOD);
        generate(translationBuilder, BFBlocks.LEMON_LEAVES);
        generate(translationBuilder, BFBlocks.FLOWERING_LEMON_LEAVES);
        generate(translationBuilder, BFBlocks.LEMON_SAPLING);
        generate(translationBuilder, BFBlocks.LEMON_BLOCK);
        generate(translationBuilder, BFBlocks.HANGING_LEMON, "Lemon");


        generate(translationBuilder, BFItems.PLUM);
        generate(translationBuilder, BFBlocks.PLUM_LOG);
        generate(translationBuilder, BFBlocks.STRIPPED_PLUM_LOG);
        generate(translationBuilder, BFBlocks.PLUM_WOOD);
        generate(translationBuilder, BFBlocks.STRIPPED_PLUM_WOOD);
        generate(translationBuilder, BFBlocks.PLUM_LEAVES);
        generate(translationBuilder, BFBlocks.FLOWERING_PLUM_LEAVES);
        generate(translationBuilder, BFBlocks.PLUM_SAPLING);
        generate(translationBuilder, BFBlocks.PLUM_BLOCK);
        generate(translationBuilder, BFBlocks.HANGING_PLUM, "Plum");


        generate(translationBuilder, BFItems.HOARY_SEEDS);
        generate(translationBuilder, BFBlocks.HOARY_APPLE_SAPLING);
        generate(translationBuilder, BFBlocks.HOARY_APPLE_SAPLING_CROP, "Hoary Apple Sapling");
        generate(translationBuilder, BFBlocks.HOARY_LOG);
        generate(translationBuilder, BFBlocks.STRIPPED_HOARY_LOG);
        generate(translationBuilder, BFBlocks.HOARY_WOOD);
        generate(translationBuilder, BFBlocks.STRIPPED_HOARY_WOOD);
        generate(translationBuilder, BFBlocks.HOARY_PLANKS);
        generate(translationBuilder, BFBlocks.HOARY_STAIRS);
        generate(translationBuilder, BFBlocks.HOARY_SLAB);
        generate(translationBuilder, BFBlocks.HOARY_FENCE);
        generate(translationBuilder, BFBlocks.HOARY_FENCE_GATE);
        generate(translationBuilder, BFBlocks.HOARY_DOOR);
        generate(translationBuilder, BFBlocks.HOARY_TRAPDOOR);
        generate(translationBuilder, BFBlocks.HOARY_PRESSURE_PLATE);
        generate(translationBuilder, BFBlocks.HOARY_BUTTON);
        generate(translationBuilder, BFBlocks.HOARY_LEAVES);
        generate(translationBuilder, BFBlocks.HOARY_SIGN);
        generate(translationBuilder, BFBlocks.HOARY_HANGING_SIGN);
        generate(translationBuilder, BFItems.HOARY_BOAT);
        generate(translationBuilder, BFItems.HOARY_CHEST_BOAT, "Hoary Boat with Chest");
        generate(translationBuilder, BFItems.HOARY_APPLE);
        generate(translationBuilder, BFBlocks.HOARY_APPLE_BLOCK);
        generate(translationBuilder, BFBlocks.HANGING_HOARY_APPLE, "Hoary Apple");


        generate(translationBuilder, BFBlocks.WALNUT_SAPLING);
        generate(translationBuilder, BFBlocks.WALNUT_LOG);
        generate(translationBuilder, BFBlocks.STRIPPED_WALNUT_LOG);
        generate(translationBuilder, BFBlocks.WALNUT_WOOD);
        generate(translationBuilder, BFBlocks.STRIPPED_WALNUT_WOOD);
        generate(translationBuilder, BFBlocks.WALNUT_PLANKS);
        generate(translationBuilder, BFBlocks.WALNUT_STAIRS);
        generate(translationBuilder, BFBlocks.WALNUT_SLAB);
        generate(translationBuilder, BFBlocks.WALNUT_FENCE);
        generate(translationBuilder, BFBlocks.WALNUT_FENCE_GATE);
        generate(translationBuilder, BFBlocks.WALNUT_DOOR);
        generate(translationBuilder, BFBlocks.WALNUT_TRAPDOOR);
        generate(translationBuilder, BFBlocks.WALNUT_PRESSURE_PLATE);
        generate(translationBuilder, BFBlocks.WALNUT_BUTTON);
        generate(translationBuilder, BFBlocks.WALNUT_LEAVES);
        generate(translationBuilder, BFBlocks.WALNUT_SIGN);
        generate(translationBuilder, BFBlocks.WALNUT_HANGING_SIGN);
        generate(translationBuilder, BFItems.WALNUT_BOAT);
        generate(translationBuilder, BFItems.WALNUT_CHEST_BOAT, "Walnut Boat with Chest");
        generate(translationBuilder, BFItems.WALNUT);
        generate(translationBuilder, BFBlocks.WALNUT_MULCH);
        generate(translationBuilder, BFBlocks.WALNUT_MULCH_BLOCK);
        generate(translationBuilder, BFBlocks.HANGING_WALNUTS, "Walnuts");

        generate(translationBuilder, BFBlocks.PALM_LOG);
        generate(translationBuilder, BFBlocks.STRIPPED_PALM_LOG);
        generate(translationBuilder, BFBlocks.PALM_WOOD);
        generate(translationBuilder, BFBlocks.STRIPPED_PALM_WOOD);
        generate(translationBuilder, BFBlocks.PALM_CROWN);
        generate(translationBuilder, BFBlocks.PALM_FROND);
        generate(translationBuilder, BFBlocks.WALL_PALM_FROND, "Palm Frond");
        generate(translationBuilder, BFBlocks.POTTED_PALM_FROND);
        generate(translationBuilder, BFBlocks.COCONUT);
        generate(translationBuilder, BFBlocks.PALM_SAPLING);
        generate(translationBuilder, BFItems.COCONUT);
        generate(translationBuilder, BFBlocks.COCONUT_MULCH);
        generate(translationBuilder, BFBlocks.COCONUT_MULCH_BLOCK);
        generate(translationBuilder, BFItems.COCONUT_COIR);
        generate(translationBuilder, BFItems.COCONUT_HALF);
        generate(translationBuilder, BFItems.COCONUT_STEW);
        generate(translationBuilder, BFItems.COCONUT_CRUSTED_COD);
        generate(translationBuilder, BFBlocks.COCONUT_CAKE);
        generate(translationBuilder, BFBlocks.PACKED_COCONUT_COIR);
        generate(translationBuilder, BFBlocks.COIR_CARPET);
        generate(translationBuilder, BFBlocks.COIR_BRICKS);
        generate(translationBuilder, BFBlocks.COIR_BRICK_SLAB);
        generate(translationBuilder, BFBlocks.COIR_BRICK_STAIRS);
        generate(translationBuilder, BFBlocks.COIR_BRICK_WALL);
        generate(translationBuilder, BFBlocks.COCONUT_CANDLE);


        generate(translationBuilder, BFItems.CITRUS_ESSENCE);
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

        generate(translationBuilder, BFItems.CANDIED_ORANGE);
        generate(translationBuilder, BFItems.CANDIED_LEMON);

//        generate(translationBuilder, ModBlocks.TRELLIS);
//        generate(translationBuilder, ModBlocks.PASSION_FRUIT_TRELLIS);
//        generate(translationBuilder, ModBlocks.ELDERBERRY_TRELLIS);
//        generate(translationBuilder, ModBlocks.GLOW_BERRY_TRELLIS);
//        generate(translationBuilder, ModBlocks.LAPISBERRY_TRELLIS);
//        for (TrellisVariant trellis : TrellisVariants.TrellisVariants) {
//            if (Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
//                String trellisName = trellis.getTrellisName();
//                if (Objects.equals(trellis.getName(), "oak")) {
//                    trellisName = "oak_trellis";
//                    generate(translationBuilder, ModTrellises.TRELLISES.get("trellis"), "Oak Trellis");
//                } else {
//                    generate(translationBuilder, ModTrellises.TRELLISES.get(trellisName));
//                }
//                for (VineCrop crop : TrellisVariants.VineCrops) {
//                    generate(translationBuilder,
//                            TrellisUtil.getCropTrellisFromVariant(trellis, crop),
//                            capitalizeString(Registries.BLOCK.getId(ModTrellises.TRELLISES.get(trellisName)).getPath().replace(crop.getId() + "_", "").replace("_", " ")));
//                }
//                for (DecorativeVine vine : TrellisVariants.DecorativeVines) {
//                    generate(translationBuilder,
//                            TrellisUtil.getDecorTrellisFromVariant(trellis, vine),
//                            capitalizeString(Registries.BLOCK.getId(ModTrellises.TRELLISES.get(trellisName)).getPath().replace(vine.getId() + "_", "").replace("_", " ")));
//                }
//            }
//        }
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

        generate(translationBuilder, BFItems.PASSION_FRUIT);
        generate(translationBuilder, BFItems.ELDERBERRIES);
        generate(translationBuilder, BFItems.LAPISBERRIES);
        generate(translationBuilder, BFItems.LAPISBERRY_SEEDS);

        generate(translationBuilder, BFBlocks.WILD_WHEAT);
        generate(translationBuilder, BFBlocks.WILD_CARROTS);
        generate(translationBuilder, BFBlocks.WILD_POTATOES);
        generate(translationBuilder, BFBlocks.WILD_BEETROOTS);
        generate(translationBuilder, BFBlocks.WILD_LEEKS);
        generate(translationBuilder, BFBlocks.WILD_MAIZE);
        generate(translationBuilder, BFBlocks.WILD_PASSION_FRUIT_VINE);
        generate(translationBuilder, BFBlocks.WILD_ELDERBERRY_VINE);

        generate(translationBuilder, BFItems.MAIZE);
        generate(translationBuilder, BFBlocks.MAIZE_CROP, "Maize");
        generate(translationBuilder, BFItems.MAIZE_SEEDS);
        generate(translationBuilder, BFItems.LEEK);
        generate(translationBuilder, BFBlocks.LEEKS);
        generate(translationBuilder, BFItems.LEEK_SEEDS);

        generate(translationBuilder, BFItems.GRASS_SEEDS);

        generate(translationBuilder, BFBlocks.SPONGEKIN_STEM);
        generate(translationBuilder, BFBlocks.SPONGEKIN_SPROUT);
        generate(translationBuilder, BFBlocks.SPONGEKIN);
        generate(translationBuilder, BFItems.SPONGEKIN_SEEDS);
        generate(translationBuilder, BFItems.SPONGEKIN_SLICE);
        generate(translationBuilder, BFBlocks.PRISMARINE_BLOSSOM);

        generate(translationBuilder, BFBlocks.SCORCHKIN_STEM);
        generate(translationBuilder, BFBlocks.SCORCHKIN);
        generate(translationBuilder, BFItems.SCORCHKIN_SEEDS);

        generate(translationBuilder, BFItems.FLOUR);

        generate(translationBuilder, BFItems.FELDSPAR);
        generate(translationBuilder, BFBlocks.FELDSPAR_BLOCK);
        generate(translationBuilder, BFBlocks.CUT_FELDSPAR_BLOCK);
        generate(translationBuilder, BFBlocks.FELDSPAR_BRICKS);
        generate(translationBuilder, BFBlocks.FELDSPAR_BRICK_STAIRS);
        generate(translationBuilder, BFBlocks.FELDSPAR_BRICK_SLAB);
        generate(translationBuilder, BFBlocks.FELDSPAR_LANTERN);
        generate(translationBuilder, BFBlocks.TINGED_GLASS);
        generate(translationBuilder, BFItems.CERAMIC_CLAY);
        generate(translationBuilder, BFItems.CERAMIC_TILE);
        generate(translationBuilder, BFBlocks.CERAMIC_CLAY_BLOCK);
        generate(translationBuilder, BFBlocks.FERMENTATION_VESSEL);
        generate(translationBuilder, BFItems.ARTISAN_BRUSH);
        generate(translationBuilder, BFBlocks.CERAMIC_TILES);
        generate(translationBuilder, BFBlocks.CERAMIC_TILE_STAIRS);
        generate(translationBuilder, BFBlocks.CERAMIC_TILE_SLAB);
        generate(translationBuilder, BFBlocks.CRACKED_CERAMIC_TILES);
        generate(translationBuilder, BFBlocks.CHECKERED_CERAMIC_TILES);
        generate(translationBuilder, BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS);
        generate(translationBuilder, BFBlocks.CHECKERED_CERAMIC_TILE_SLAB);
        generate(translationBuilder, BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES);
        generate(translationBuilder, BFBlocks.CERAMIC_TILE_PILLAR);
        generate(translationBuilder, BFBlocks.CERAMIC_MOSAIC);
        generate(translationBuilder, BFBlocks.CERAMIC_MOSAIC_STAIRS);
        generate(translationBuilder, BFBlocks.CERAMIC_MOSAIC_SLAB);
        generate(translationBuilder, BFBlocks.CHECKERED_CERAMIC_MOSAIC);
        generate(translationBuilder, BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS);
        generate(translationBuilder, BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB);
        generate(translationBuilder, BFBlocks.CERAMIC_PRESSURE_PLATE);
        generate(translationBuilder, BFBlocks.CERAMIC_BUTTON);
        generate(translationBuilder, BFBlocks.CERAMIC_LEVER);
        generate(translationBuilder, BFBlocks.CERAMIC_DOOR);
        generate(translationBuilder, BFBlocks.CERAMIC_TRAPDOOR);
        generate(translationBuilder, BFBlocks.CERAMIC_DISH);

        generate(translationBuilder, BFItems.ELDERBERRY_WINE_BOTTLE);
        generate(translationBuilder, BFItems.LAPISBERRY_WINE_BOTTLE);
        generate(translationBuilder, BFItems.MEAD_BOTTLE);
        generate(translationBuilder, BFItems.APPLE_CIDER_JAR);
        generate(translationBuilder, BFItems.PLUM_CIDER_JAR);
        generate(translationBuilder, BFItems.HOARY_CIDER_JAR);

        generate(translationBuilder, BFItems.TEA_BERRIES);
        generate(translationBuilder, BFItems.TEA_LEAVES);
        generate(translationBuilder, BFItems.DRIED_TEA_LEAVES);
        generate(translationBuilder, BFBlocks.CHAMOMILE_FLOWERS);
        generate(translationBuilder, BFBlocks.HONEYSUCKLE);
        generate(translationBuilder, BFBlocks.VIOLET_BELLFLOWER);

        generate(translationBuilder, BFItems.GREEN_TEA_BLEND);
        generate(translationBuilder, BFItems.BLACK_TEA_BLEND);
        generate(translationBuilder, BFItems.CHAMOMILE_TEA_BLEND);
        generate(translationBuilder, BFItems.HONEYSUCKLE_TEA_BLEND);
        generate(translationBuilder, BFItems.BELLFLOWER_TEA_BLEND);
        generate(translationBuilder, BFItems.TORCHFLOWER_TEA_BLEND);

        generate(translationBuilder, BFItems.GREEN_TEA_BOTTLE);
        generate(translationBuilder, BFItems.BLACK_TEA_BOTTLE);
        generate(translationBuilder, BFItems.CHAMOMILE_TEA_BOTTLE);
        generate(translationBuilder, BFItems.HONEYSUCKLE_TEA_BOTTLE);
        generate(translationBuilder, BFItems.BELLFLOWER_TEA_BOTTLE);
        generate(translationBuilder, BFItems.TORCHFLOWER_TEA_BOTTLE);

        generate(translationBuilder, BFBlocks.GREEN_TEA_CANDLE);
        generate(translationBuilder, BFBlocks.BLACK_TEA_CANDLE);
        generate(translationBuilder, BFBlocks.CHAMOMILE_CANDLE);
        generate(translationBuilder, BFBlocks.HONEYSUCKLE_CANDLE);
        generate(translationBuilder, BFBlocks.BELLFLOWER_CANDLE);
        generate(translationBuilder, BFBlocks.TORCHFLOWER_CANDLE);
        generate(translationBuilder, BFBlocks.WALNUT_CANDLE);

        generate(translationBuilder, "effect.bountifulfares.ebullience", "Ebullience");
        generate(translationBuilder, "effect.bountifulfares.ebullience.description", "Negates exhaustion from actions like mining or walking.");
//        generate(translationBuilder, "effect.bountifulfares.gorging", "Gorging");

        generate(translationBuilder, BFItems.SUN_HAT);

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

//        generateJackOStraw(translationBuilder, ModBlocks.ACORN_JACK_O_STRAW, "Acorn");
//        generateJackOStraw(translationBuilder, ModBlocks.AMBER_JACK_O_STRAW, "Amber");
//        generateJackOStraw(translationBuilder, ModBlocks.ARTICHOKE_JACK_O_STRAW, "Artichoke");
//        generateJackOStraw(translationBuilder, ModBlocks.BANANA_JACK_O_STRAW, "Banana");
//        generateJackOStraw(translationBuilder, ModBlocks.CERULEAN_JACK_O_STRAW, "Cerulean");
//        generateJackOStraw(translationBuilder, ModBlocks.FUCHSIA_JACK_O_STRAW, "Fuchsia");
//        generateJackOStraw(translationBuilder, ModBlocks.GRAPE_JACK_O_STRAW, "Grape");
//        generateJackOStraw(translationBuilder, ModBlocks.INDIGO_JACK_O_STRAW, "Indigo");
//        generateJackOStraw(translationBuilder, ModBlocks.MAROON_JACK_O_STRAW, "Maroon");
//        generateJackOStraw(translationBuilder, ModBlocks.MAUVE_JACK_O_STRAW, "Mauve");
//        generateJackOStraw(translationBuilder, ModBlocks.MINT_JACK_O_STRAW, "Mint");
//        generateJackOStraw(translationBuilder, ModBlocks.MOLD_JACK_O_STRAW, "Mold");
//        generateJackOStraw(translationBuilder, ModBlocks.NAVY_JACK_O_STRAW, "Navy");
//        generateJackOStraw(translationBuilder, ModBlocks.PEACH_JACK_O_STRAW, "Peach");
//        generateJackOStraw(translationBuilder, ModBlocks.PERIWINKLE_JACK_O_STRAW, "Periwinkle");
//        generateJackOStraw(translationBuilder, ModBlocks.SAGE_JACK_O_STRAW, "Sage");
//        generateJackOStraw(translationBuilder, ModBlocks.SAP_JACK_O_STRAW, "Sap");
//        generateJackOStraw(translationBuilder, ModBlocks.SHAMROCK_JACK_O_STRAW, "Shamrock");
//        generateJackOStraw(translationBuilder, ModBlocks.VELVET_JACK_O_STRAW, "Velvet");
//        generateJackOStraw(translationBuilder, ModBlocks.VERMILION_JACK_O_STRAW, "Vermilion");
//
//        generateJackOStraw(translationBuilder, ModBlocks.ROSE_JACK_O_STRAW, "Rose");
//        generateJackOStraw(translationBuilder, ModBlocks.CORAL_JACK_O_STRAW, "Coral");
//        generateJackOStraw(translationBuilder, ModBlocks.GINGER_JACK_O_STRAW, "Ginger");
//        generateJackOStraw(translationBuilder, ModBlocks.TAN_JACK_O_STRAW, "Tan");
//        generateJackOStraw(translationBuilder, ModBlocks.BEIGE_JACK_O_STRAW, "Beige");
//        generateJackOStraw(translationBuilder, ModBlocks.OLIVE_JACK_O_STRAW, "Olive");
//        generateJackOStraw(translationBuilder, ModBlocks.FOREST_JACK_O_STRAW, "Forest");
//        generateJackOStraw(translationBuilder, ModBlocks.VERDANT_JACK_O_STRAW, "Verdant");
//        generateJackOStraw(translationBuilder, ModBlocks.TEAL_JACK_O_STRAW, "Teal");
//        generateJackOStraw(translationBuilder, ModBlocks.AQUA_JACK_O_STRAW, "Aqua");
//        generateJackOStraw(translationBuilder, ModBlocks.SLATE_JACK_O_STRAW, "Slate");
//        generateJackOStraw(translationBuilder, ModBlocks.INDIGO2_JACK_O_STRAW, "Indigo");

        generate(translationBuilder, "block.bountifulfares.ash_jack_o_straw", "Ash Jack O' Straw");


        generate(translationBuilder, "tooltip.bountifulfares.dyeable", "Dyeable");

        generate(translationBuilder, BFBlocks.GRISTMILL);

        generate(translationBuilder, BFBlocks.OAK_PICKETS);
        generate(translationBuilder, BFBlocks.SPRUCE_PICKETS);
        generate(translationBuilder, BFBlocks.BIRCH_PICKETS);
        generate(translationBuilder, BFBlocks.JUNGLE_PICKETS);
        generate(translationBuilder, BFBlocks.ACACIA_PICKETS);
        generate(translationBuilder, BFBlocks.DARK_OAK_PICKETS);
        generate(translationBuilder, BFBlocks.MANGROVE_PICKETS);
        generate(translationBuilder, BFBlocks.CHERRY_PICKETS);
        generate(translationBuilder, BFBlocks.BAMBOO_PICKETS);
        generate(translationBuilder, BFBlocks.WALNUT_PICKETS);
        generate(translationBuilder, BFBlocks.HOARY_PICKETS);
        generate(translationBuilder, BFBlocks.CRIMSON_PICKETS);
        generate(translationBuilder, BFBlocks.WARPED_PICKETS);

        generate(translationBuilder, BFBlocks.GRASSY_DIRT);

        generate(translationBuilder, BFItems.JAR);
        generate(translationBuilder, BFItems.APPLE_COMPOTE_JAR);
        generate(translationBuilder, BFItems.ORANGE_COMPOTE_JAR);
        generate(translationBuilder, BFItems.LEMON_COMPOTE_JAR);
        generate(translationBuilder, BFItems.PLUM_COMPOTE_JAR);
        generate(translationBuilder, BFItems.HOARY_COMPOTE_JAR);
        generate(translationBuilder, BFBlocks.ARTISAN_BREAD);
        generate(translationBuilder, BFBlocks.ARTISAN_COOKIES);
        generate(translationBuilder, BFItems.ARTISAN_COOKIE);
        generate(translationBuilder, BFBlocks.PASSION_FRUIT_TART);
        generate(translationBuilder, BFBlocks.ELDERBERRY_TART);
        generate(translationBuilder, BFBlocks.GLOW_BERRY_TART);
        generate(translationBuilder, BFBlocks.LAPISBERRY_TART);
        generate(translationBuilder, BFBlocks.SWEET_BERRY_TART);
        generate(translationBuilder, BFBlocks.APPLE_PIE);
        generate(translationBuilder, BFBlocks.ORANGE_PIE);
        generate(translationBuilder, BFBlocks.LEMON_PIE);
        generate(translationBuilder, BFBlocks.PLUM_PIE);
        generate(translationBuilder, BFBlocks.HOARY_PIE);
        generate(translationBuilder, BFBlocks.COCOA_CAKE);
        generate(translationBuilder, BFItems.WALNUT_COOKIE);
        generate(translationBuilder, BFItems.CANDY);
        generate(translationBuilder, BFItems.SOUR_CANDY);
        generate(translationBuilder, BFItems.PIQUANT_CANDY);
        generate(translationBuilder, BFItems.BITTER_CANDY);
        generate(translationBuilder, BFItems.MAIZE_BREAD);
        generate(translationBuilder, BFItems.CANDIED_APPLE);
        generate(translationBuilder, BFItems.CANDIED_PLUM);
        generate(translationBuilder, BFItems.MUSHROOM_STUFFED_POTATO);
        generate(translationBuilder, BFItems.BERRY_STUFFED_POTATO);
        generate(translationBuilder, BFItems.MAIZE_STUFFED_POTATO);
        generate(translationBuilder, BFItems.PASSION_GLAZED_SALMON);
        generate(translationBuilder, BFItems.LEEK_STEW);
        generate(translationBuilder, BFItems.FISH_STEW);
        generate(translationBuilder, BFItems.APPLE_STEW);
        generate(translationBuilder, BFItems.STONE_STEW);
        generate(translationBuilder, BFItems.BOUNTIFUL_STEW);
        generate(translationBuilder, BFItems.CRUSTED_BEEF);
        generate(translationBuilder, BFItems.FOREST_MEDLEY);
        generate(translationBuilder, BFItems.ARID_MEDLEY);
        generate(translationBuilder, BFItems.MEADOW_MEDLEY);
        generate(translationBuilder, BFItems.COASTAL_MEDLEY);
        generate(translationBuilder, BFItems.CUSTARD);
        generate(translationBuilder, BFItems.PIQUANT_CUSTARD);
        generate(translationBuilder, BFItems.PASSION_CUSTARD);
        generate(translationBuilder, BFItems.COCOA_CUSTARD);
        generate(translationBuilder, BFItems.ANCIENT_CUSTARD);
        generate(translationBuilder, BFItems.CRIMSON_CHOW);
        generate(translationBuilder, BFItems.WARPED_CHOW);

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

        generate(translationBuilder, "warning.bountifulfares.fermentation_vessel.glass_bottle", "Use a Glass Bottle to Collect This");
        generate(translationBuilder, "warning.bountifulfares.fermentation_vessel.jar", "Use a Jar to Collect This");

        generate(translationBuilder, "advancement.bountifulfares.bountiful_fares", "Bountiful Fares");
        generate(translationBuilder, "advancement.bountifulfares.bountiful_fares.description", "The world is filled with more food!");

        generate(translationBuilder, "advancement.bountifulfares.place_gristmill", "On the Grind");
        generate(translationBuilder, "advancement.bountifulfares.place_gristmill.description", "Place a Gristmill");

        generate(translationBuilder, "advancement.bountifulfares.obtain_feldspar", "Felsic Forager");
        generate(translationBuilder, "advancement.bountifulfares.obtain_feldspar.description", "Collect Feldspar from milling stones");

        generate(translationBuilder, "advancement.bountifulfares.obtain_ceramic_tiles", "Roy G Biv");
        // More than 50 Shades,
        generate(translationBuilder, "advancement.bountifulfares.obtain_ceramic_tiles.description", "Craft Ceramic Tiles");

        generate(translationBuilder, "advancement.bountifulfares.feed_wolf_mulch", "Mulchmaxxer");
        generate(translationBuilder, "advancement.bountifulfares.feed_wolf_mulch.description", "Feed a wolf Walnut Mulch - Delicious!");

        generate(translationBuilder, "advancement.bountifulfares.obtain_fermentation_vessel", "Toil and Trouble");
        generate(translationBuilder, "advancement.bountifulfares.obtain_fermentation_vessel.description", "Craft a Fermentation Vessel");

        generate(translationBuilder, "advancement.bountifulfares.eat_ancient_fruit", "How Long Has This Sat Out?");
        generate(translationBuilder, "advancement.bountifulfares.eat_ancient_fruit.description", "Eat a fruit from the distant past");

        generate(translationBuilder, "advancement.bountifulfares.place_all_baked_goods", "Baker's Dozen");
        generate(translationBuilder, "advancement.bountifulfares.place_all_baked_goods.description", "Place every baked good");

        generate(translationBuilder, "advancement.bountifulfares.eat_citrus_essence", "Pass the Antacid");
        generate(translationBuilder, "advancement.bountifulfares.eat_citrus_essence.description", "Eat Citrus Essence");

        generate(translationBuilder, "advancement.bountifulfares.throw_flour", "Great Escape");
        generate(translationBuilder, "advancement.bountifulfares.throw_flour.description", "Throw Flour");

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

        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin", "Who Lives in a Loofah Under the Sea");
        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin.description", "Grow and collect a Spongekin");

        generate(translationBuilder, "advancement.bountifulfares.make_first_food", "Anyone can Cook");
        generate(translationBuilder, "advancement.bountifulfares.make_first_food.description", "Make your first meal");

        generate(translationBuilder, "advancement.bountifulfares.eat_all_food", "Bountiful Fares");
        generate(translationBuilder, "advancement.bountifulfares.eat_all_food.description", "Eat every meal");

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


        generate(translationBuilder, "config.bountifulfares.title", "Bountiful Fares Configuration");

//        generate(translationBuilder, "config.bountifulfares.category.client", "Client");
        generate(translationBuilder, "config.bountifulfares.category.gameplay", "Gameplay");
        generate(translationBuilder, "config.bountifulfares.category.paintings", "Paintings");
        generate(translationBuilder, "config.bountifulfares.category.world", "World");
//        generate(translationBuilder, "config.bountifulfares.category.compat", "Compatibility");
//        generate(translationBuilder, "config.bountifulfares.category.mint", "El's and L's Dye Mod");
//        generate(translationBuilder, "config.bountifulfares.category.dye_depot", "Dye Depot");

        generate(translationBuilder, "config.bountifulfares.restart_warning", "Requires a restart to apply changes");

//        generate(translationBuilder, "config.bountifulfares.item_guide_tooltips", "Show information in some items' tooltip");
        generate(translationBuilder, "config.bountifulfares.fruit_replace_when_picked", "Fruits on trees replant when picked");
        generate(translationBuilder, "config.bountifulfares.flour_throwing", "Flour can be thrown");
        generate(translationBuilder, "config.bountifulfares.restoration_overlay", "Restoration effect changes health icons");
        generate(translationBuilder, "config.bountifulfares.lapisberry_seeds", "Sniffers can dig up Lapisberry Seeds");
        generate(translationBuilder, "config.bountifulfares.hoary_seeds", "Sniffers can dig up Hoary Seeds");
        generate(translationBuilder, "config.bountifulfares.spongekin_seeds_elder_guardian", "Elder Guardians drop Spongekin Seeds");
        generate(translationBuilder, "config.bountifulfares.spongekin_seeds_guardian", "Guardians drop Spongekin Seeds");
        generate(translationBuilder, "config.bountifulfares.milling_time", "Gristmill milling time, in seconds");
        generate(translationBuilder, "config.bountifulfares.fermentation_time", "Fermentation time, in seconds");
        generate(translationBuilder, "config.bountifulfares.bountiful_painting", "Allow \"Bountiful\" painting to be placed");
        generate(translationBuilder, "config.bountifulfares.citrus_dish_painting", "Allow \"Citrus Dish\" painting to be placed");
        generate(translationBuilder, "config.bountifulfares.hazel_floret_painting", "Allow \"Hazel Floret\" painting to be placed");
        generate(translationBuilder, "config.bountifulfares.violet_floret_painting", "Allow \"Violet Floret\" painting to be placed");
        generate(translationBuilder, "config.bountifulfares.why_blue_painting", "Allow \"Why Blue\" painting to be placed");
        generate(translationBuilder, "config.bountifulfares.ruminer_painting", "Allow \"Ruminer\" painting to be placed");
        generate(translationBuilder, "config.bountifulfares.phylogenesis_painting", "Allow \"Phylogenesis\" painting to be placed");
        generate(translationBuilder, "config.bountifulfares.escalade_painting", "Allow \"Escalade\" painting to be placed");
        generate(translationBuilder, "config.bountifulfares.aquaculture_painting", "Allow \"Aquaculture\" painting to be placed");
        generate(translationBuilder, "config.bountifulfares.unpleasant_tiles_painting", "Allow \"Unpleasant Tiles\" painting to be placed");
        generate(translationBuilder, "config.bountifulfares.wild_wheat", "Generate Wild Wheat");
        generate(translationBuilder, "config.bountifulfares.wild_carrots", "Generate Wild Carrots");
        generate(translationBuilder, "config.bountifulfares.wild_potatoes", "Generate Wild Potatoes");
        generate(translationBuilder, "config.bountifulfares.wild_beetroot", "Generate Wild Beetroot");
        generate(translationBuilder, "config.bountifulfares.apple_trees", "Generate Apple Trees");
        generate(translationBuilder, "config.bountifulfares.orange_trees", "Generate Orange Trees");
        generate(translationBuilder, "config.bountifulfares.lemon_trees", "Generate Lemon Trees");
        generate(translationBuilder, "config.bountifulfares.plum_trees", "Generate Plum Trees");
        generate(translationBuilder, "config.bountifulfares.palm_trees", "Generate Palm Trees");
        generate(translationBuilder, "config.bountifulfares.flower_forest_fruit_trees", "Generate fruit trees in Flower Forests");
        generate(translationBuilder, "config.bountifulfares.forest_tea_shrubs", "Generate Tea Shrubs in Forests");
        generate(translationBuilder, "config.bountifulfares.forest_walnut_trees", "Generate Walnut Trees in Forests");
//        generate(translationBuilder, "config.bountifulfares.honeysuckle_to_banana_dye", "Honeysuckles craft into Banana Dye");
//        generate(translationBuilder, "config.bountifulfares.rename_items_to_match_dyes", "Rename dyed items to match Dye Depot's override pack");
//        generate(translationBuilder, "config.bountifulfares.honeysuckle_to_amber_dye", "Honeysuckles craft into Amber Dye");
//        generate(translationBuilder, "config.bountifulfares.chamomile_to_beige_dye", "Chamomile Flowers craft into Beige Dye");

        generate(translationBuilder, "pack.bountifulfares.vanilla_item_override", "Vanilla Item Texture Override");
        generate(translationBuilder, "pack.bountifulfares.amendments", "Bountiful Fares X Amendments");
//        generate(translationBuilder, "pack.bountifulfares.mint", "Bountiful Fares X El's and L's Dye Mod");
//        generate(translationBuilder, "pack.bountifulfares.dye_depot", "Bountiful Fares X Dye Depot");
    }
}
