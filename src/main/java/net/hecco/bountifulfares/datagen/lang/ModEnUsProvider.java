package net.hecco.bountifulfares.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

public class ModEnUsProvider extends FabricLanguageProvider {
    public ModEnUsProvider(FabricDataOutput dataOutput) {
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
        generate(translationBuilder, ModBlocks.APPLE_LOG);
        generate(translationBuilder, ModBlocks.STRIPPED_APPLE_LOG);
        generate(translationBuilder, ModBlocks.APPLE_WOOD);
        generate(translationBuilder, ModBlocks.STRIPPED_APPLE_WOOD);
        generate(translationBuilder, ModBlocks.APPLE_LEAVES);
        generate(translationBuilder, ModBlocks.FLOWERING_APPLE_LEAVES);
        generate(translationBuilder, ModBlocks.APPLE_SAPLING);
        generate(translationBuilder, ModBlocks.APPLE_BLOCK);
        generate(translationBuilder, ModBlocks.GOLDEN_APPLE_BLOCK);
        generate(translationBuilder, ModBlocks.HANGING_APPLE, "Apple");

        generate(translationBuilder, ModItems.ORANGE);
        generate(translationBuilder, ModBlocks.ORANGE_LOG);
        generate(translationBuilder, ModBlocks.STRIPPED_ORANGE_LOG);
        generate(translationBuilder, ModBlocks.ORANGE_WOOD);
        generate(translationBuilder, ModBlocks.STRIPPED_ORANGE_WOOD);
        generate(translationBuilder, ModBlocks.ORANGE_LEAVES);
        generate(translationBuilder, ModBlocks.FLOWERING_ORANGE_LEAVES);
        generate(translationBuilder, ModBlocks.ORANGE_SAPLING);
        generate(translationBuilder, ModBlocks.ORANGE_BLOCK);
        generate(translationBuilder, ModBlocks.HANGING_ORANGE, "Orange");

        generate(translationBuilder, ModItems.LEMON);
        generate(translationBuilder, ModBlocks.LEMON_LOG);
        generate(translationBuilder, ModBlocks.STRIPPED_LEMON_LOG);
        generate(translationBuilder, ModBlocks.LEMON_WOOD);
        generate(translationBuilder, ModBlocks.STRIPPED_LEMON_WOOD);
        generate(translationBuilder, ModBlocks.LEMON_LEAVES);
        generate(translationBuilder, ModBlocks.FLOWERING_LEMON_LEAVES);
        generate(translationBuilder, ModBlocks.LEMON_SAPLING);
        generate(translationBuilder, ModBlocks.LEMON_BLOCK);
        generate(translationBuilder, ModBlocks.HANGING_LEMON, "Lemon");


        generate(translationBuilder, ModItems.PLUM);
        generate(translationBuilder, ModBlocks.PLUM_LOG);
        generate(translationBuilder, ModBlocks.STRIPPED_PLUM_LOG);
        generate(translationBuilder, ModBlocks.PLUM_WOOD);
        generate(translationBuilder, ModBlocks.STRIPPED_PLUM_WOOD);
        generate(translationBuilder, ModBlocks.PLUM_LEAVES);
        generate(translationBuilder, ModBlocks.FLOWERING_PLUM_LEAVES);
        generate(translationBuilder, ModBlocks.PLUM_SAPLING);
        generate(translationBuilder, ModBlocks.PLUM_BLOCK);
        generate(translationBuilder, ModBlocks.HANGING_PLUM, "Plum");


        generate(translationBuilder, ModItems.HOARY_SEEDS);
        generate(translationBuilder, ModBlocks.HOARY_APPLE_SAPLING);
        generate(translationBuilder, ModBlocks.HOARY_APPLE_SAPLING_CROP, "Hoary Apple Sapling");
        generate(translationBuilder, ModBlocks.HOARY_LOG);
        generate(translationBuilder, ModBlocks.STRIPPED_HOARY_LOG);
        generate(translationBuilder, ModBlocks.HOARY_WOOD);
        generate(translationBuilder, ModBlocks.STRIPPED_HOARY_WOOD);
        generate(translationBuilder, ModBlocks.HOARY_PLANKS);
        generate(translationBuilder, ModBlocks.HOARY_STAIRS);
        generate(translationBuilder, ModBlocks.HOARY_SLAB);
        generate(translationBuilder, ModBlocks.HOARY_FENCE);
        generate(translationBuilder, ModBlocks.HOARY_FENCE_GATE);
        generate(translationBuilder, ModBlocks.HOARY_DOOR);
        generate(translationBuilder, ModBlocks.HOARY_TRAPDOOR);
        generate(translationBuilder, ModBlocks.HOARY_PRESSURE_PLATE);
        generate(translationBuilder, ModBlocks.HOARY_BUTTON);
        generate(translationBuilder, ModBlocks.HOARY_LEAVES);
        generate(translationBuilder, ModBlocks.HOARY_SIGN);
        generate(translationBuilder, ModBlocks.HOARY_HANGING_SIGN);
        generate(translationBuilder, ModItems.HOARY_BOAT);
        generate(translationBuilder, ModItems.HOARY_CHEST_BOAT, "Hoary Boat with Chest");
        generate(translationBuilder, ModItems.HOARY_APPLE);
        generate(translationBuilder, ModBlocks.HOARY_APPLE_BLOCK);
        generate(translationBuilder, ModBlocks.HANGING_HOARY_APPLE, "Hoary Apple");


        generate(translationBuilder, ModBlocks.WALNUT_SAPLING);
        generate(translationBuilder, ModBlocks.WALNUT_LOG);
        generate(translationBuilder, ModBlocks.STRIPPED_WALNUT_LOG);
        generate(translationBuilder, ModBlocks.WALNUT_WOOD);
        generate(translationBuilder, ModBlocks.STRIPPED_WALNUT_WOOD);
        generate(translationBuilder, ModBlocks.WALNUT_PLANKS);
        generate(translationBuilder, ModBlocks.WALNUT_STAIRS);
        generate(translationBuilder, ModBlocks.WALNUT_SLAB);
        generate(translationBuilder, ModBlocks.WALNUT_FENCE);
        generate(translationBuilder, ModBlocks.WALNUT_FENCE_GATE);
        generate(translationBuilder, ModBlocks.WALNUT_DOOR);
        generate(translationBuilder, ModBlocks.WALNUT_TRAPDOOR);
        generate(translationBuilder, ModBlocks.WALNUT_PRESSURE_PLATE);
        generate(translationBuilder, ModBlocks.WALNUT_BUTTON);
        generate(translationBuilder, ModBlocks.WALNUT_LEAVES);
        generate(translationBuilder, ModBlocks.WALNUT_SIGN);
        generate(translationBuilder, ModBlocks.WALNUT_HANGING_SIGN);
        generate(translationBuilder, ModItems.WALNUT_BOAT);
        generate(translationBuilder, ModItems.WALNUT_CHEST_BOAT, "Walnut Boat with Chest");
        generate(translationBuilder, ModItems.WALNUT);
        generate(translationBuilder, ModBlocks.WALNUT_MULCH);
        generate(translationBuilder, ModBlocks.WALNUT_MULCH_BLOCK);
        generate(translationBuilder, ModBlocks.HANGING_WALNUTS, "Walnuts");


        generate(translationBuilder, ModItems.CITRUS_ESSENCE);
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
        generate(translationBuilder, "effect.bountifulfares.stupor", "Stupor");
        generate(translationBuilder, "item.minecraft.potion.effect.bountifulfares.stupor", "Potion of Stupor");
        generate(translationBuilder, "item.minecraft.potion.effect.bountifulfares.long_stupor", "Potion of Stupor");
        generate(translationBuilder, "item.minecraft.splash_potion.effect.bountifulfares.stupor", "Splash Potion of Stupor");
        generate(translationBuilder, "item.minecraft.splash_potion.effect.bountifulfares.long_stupor", "Splash Potion of Stupor");
        generate(translationBuilder, "item.minecraft.lingering_potion.effect.bountifulfares.stupor", "Lingering Potion of Stupor");
        generate(translationBuilder, "item.minecraft.lingering_potion.effect.bountifulfares.long_stupor", "Lingering Potion of Stupor");
        generate(translationBuilder, "item.minecraft.tipped_arrow.effect.bountifulfares.stupor", "Arrow of Stupor");
        generate(translationBuilder, "item.minecraft.tipped_arrow.effect.bountifulfares.long_stupor", "Arrow of Stupor");

        generate(translationBuilder, "effect.bountifulfares.restoration", "Restoration");
        generate(translationBuilder, "effect.bountifulfares.enrichment", "Enrichment");

        generate(translationBuilder, ModItems.CANDIED_ORANGE);
        generate(translationBuilder, ModItems.CANDIED_LEMON);

        generate(translationBuilder, ModBlocks.TRELLIS);
        generate(translationBuilder, ModBlocks.PASSION_FRUIT_TRELLIS);
        generate(translationBuilder, ModBlocks.ELDERBERRY_TRELLIS);
        generate(translationBuilder, ModBlocks.GLOW_BERRY_TRELLIS);
        generate(translationBuilder, ModBlocks.LAPISBERRY_TRELLIS);
        generate(translationBuilder, ModBlocks.ROSE_TRELLIS);
        generate(translationBuilder, ModBlocks.LILAC_TRELLIS);
        generate(translationBuilder, ModBlocks.PEONY_TRELLIS);
        generate(translationBuilder, ModBlocks.SUNFLOWER_TRELLIS);
        generate(translationBuilder, ModBlocks.VINE_TRELLIS);
        generate(translationBuilder, ModBlocks.TWISTING_TRELLIS);
        generate(translationBuilder, ModBlocks.WEEPING_TRELLIS);

        generate(translationBuilder, ModItems.PASSION_FRUIT);
        generate(translationBuilder, ModItems.ELDERBERRIES);
        generate(translationBuilder, ModItems.LAPISBERRIES);
        generate(translationBuilder, ModItems.LAPISBERRY_SEEDS);

        generate(translationBuilder, ModBlocks.WILD_WHEAT);
        generate(translationBuilder, ModBlocks.WILD_CARROTS);
        generate(translationBuilder, ModBlocks.WILD_POTATOES);
        generate(translationBuilder, ModBlocks.WILD_BEETROOTS);
        generate(translationBuilder, ModBlocks.WILD_LEEKS);
        generate(translationBuilder, ModBlocks.WILD_MAIZE);
        generate(translationBuilder, ModBlocks.WILD_PASSION_FRUIT_VINE);
        generate(translationBuilder, ModBlocks.WILD_ELDERBERRY_VINE);

        generate(translationBuilder, ModItems.MAIZE);
        generate(translationBuilder, ModBlocks.MAIZE_CROP, "Maize");
        generate(translationBuilder, ModItems.MAIZE_SEEDS);
        generate(translationBuilder, ModItems.LEEK);
        generate(translationBuilder, ModBlocks.LEEKS);
        generate(translationBuilder, ModItems.LEEK_SEEDS);

        generate(translationBuilder, ModItems.GRASS_SEEDS);

        generate(translationBuilder, ModBlocks.SPONGEKIN_STEM);
        generate(translationBuilder, ModBlocks.SPONGEKIN_SPROUT);
        generate(translationBuilder, ModBlocks.SPONGEKIN);
        generate(translationBuilder, ModItems.SPONGEKIN_SEEDS);
        generate(translationBuilder, ModItems.SPONGEKIN_SLICE);
        generate(translationBuilder, ModBlocks.PRISMARINE_BLOSSOM);

        generate(translationBuilder, ModItems.FLOUR);

        generate(translationBuilder, ModItems.FELDSPAR);
        generate(translationBuilder, ModBlocks.FELDSPAR_BLOCK);
        generate(translationBuilder, ModBlocks.CUT_FELDSPAR_BLOCK);
        generate(translationBuilder, ModBlocks.FELDSPAR_BRICKS);
        generate(translationBuilder, ModBlocks.FELDSPAR_BRICK_STAIRS);
        generate(translationBuilder, ModBlocks.FELDSPAR_BRICK_SLAB);
        generate(translationBuilder, ModBlocks.FELDSPAR_LANTERN);
        generate(translationBuilder, ModBlocks.TINGED_GLASS);
        generate(translationBuilder, ModItems.CERAMIC_CLAY);
        generate(translationBuilder, ModItems.CERAMIC_TILE);
        generate(translationBuilder, ModBlocks.CERAMIC_CLAY_BLOCK);
        generate(translationBuilder, ModBlocks.FERMENTATION_VESSEL);
        generate(translationBuilder, ModItems.ARTISAN_BRUSH);
        generate(translationBuilder, ModBlocks.CERAMIC_TILES);
        generate(translationBuilder, ModBlocks.CERAMIC_TILE_STAIRS);
        generate(translationBuilder, ModBlocks.CERAMIC_TILE_SLAB);
        generate(translationBuilder, ModBlocks.CRACKED_CERAMIC_TILES);
        generate(translationBuilder, ModBlocks.CHECKERED_CERAMIC_TILES);
        generate(translationBuilder, ModBlocks.CHECKERED_CERAMIC_TILE_STAIRS);
        generate(translationBuilder, ModBlocks.CHECKERED_CERAMIC_TILE_SLAB);
        generate(translationBuilder, ModBlocks.CRACKED_CHECKERED_CERAMIC_TILES);
        generate(translationBuilder, ModBlocks.CERAMIC_TILE_PILLAR);
        generate(translationBuilder, ModBlocks.CERAMIC_MOSAIC);
        generate(translationBuilder, ModBlocks.CERAMIC_MOSAIC_STAIRS);
        generate(translationBuilder, ModBlocks.CERAMIC_MOSAIC_SLAB);
        generate(translationBuilder, ModBlocks.CHECKERED_CERAMIC_MOSAIC);
        generate(translationBuilder, ModBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS);
        generate(translationBuilder, ModBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB);
        generate(translationBuilder, ModBlocks.CERAMIC_PRESSURE_PLATE);
        generate(translationBuilder, ModBlocks.CERAMIC_BUTTON);
        generate(translationBuilder, ModBlocks.CERAMIC_LEVER);
        generate(translationBuilder, ModBlocks.CERAMIC_DOOR);
        generate(translationBuilder, ModBlocks.CERAMIC_TRAPDOOR);
        generate(translationBuilder, ModBlocks.CERAMIC_DISH);

        generate(translationBuilder, ModItems.ELDERBERRY_WINE_BOTTLE);
        generate(translationBuilder, ModItems.LAPISBERRY_WINE_BOTTLE);
        generate(translationBuilder, ModItems.MEAD_BOTTLE);
        generate(translationBuilder, ModItems.APPLE_CIDER_JAR);
        generate(translationBuilder, ModItems.PLUM_CIDER_JAR);
        generate(translationBuilder, ModItems.HOARY_CIDER_JAR);

        generate(translationBuilder, ModItems.TEA_BERRIES);
        generate(translationBuilder, ModItems.TEA_LEAVES);
        generate(translationBuilder, ModItems.DRIED_TEA_LEAVES);
        generate(translationBuilder, ModBlocks.CHAMOMILE_FLOWERS);
        generate(translationBuilder, ModBlocks.HONEYSUCKLE);
        generate(translationBuilder, ModBlocks.VIOLET_BELLFLOWER);

        generate(translationBuilder, ModItems.GREEN_TEA_BLEND);
        generate(translationBuilder, ModItems.BLACK_TEA_BLEND);
        generate(translationBuilder, ModItems.CHAMOMILE_TEA_BLEND);
        generate(translationBuilder, ModItems.HONEYSUCKLE_TEA_BLEND);
        generate(translationBuilder, ModItems.BELLFLOWER_TEA_BLEND);
        generate(translationBuilder, ModItems.TORCHFLOWER_TEA_BLEND);

        generate(translationBuilder, ModItems.GREEN_TEA_BOTTLE);
        generate(translationBuilder, ModItems.BLACK_TEA_BOTTLE);
        generate(translationBuilder, ModItems.CHAMOMILE_TEA_BOTTLE);
        generate(translationBuilder, ModItems.HONEYSUCKLE_TEA_BOTTLE);
        generate(translationBuilder, ModItems.BELLFLOWER_TEA_BOTTLE);
        generate(translationBuilder, ModItems.TORCHFLOWER_TEA_BOTTLE);

        generate(translationBuilder, ModBlocks.GREEN_TEA_CANDLE);
        generate(translationBuilder, ModBlocks.BLACK_TEA_CANDLE);
        generate(translationBuilder, ModBlocks.CHAMOMILE_CANDLE);
        generate(translationBuilder, ModBlocks.HONEYSUCKLE_CANDLE);
        generate(translationBuilder, ModBlocks.BELLFLOWER_CANDLE);
        generate(translationBuilder, ModBlocks.TORCHFLOWER_CANDLE);
        generate(translationBuilder, ModBlocks.WALNUT_CANDLE);

        generate(translationBuilder, "effect.bountifulfares.ebullience", "Ebullience");
        generate(translationBuilder, "effect.bountifulfares.gorging", "Gorging");

        generate(translationBuilder, ModItems.SUN_HAT);

        generateJackOStraw(translationBuilder, ModBlocks.RED_JACK_O_STRAW, "Red");
        generateJackOStraw(translationBuilder, ModBlocks.ORANGE_JACK_O_STRAW, "Orange");
        generateJackOStraw(translationBuilder, ModBlocks.YELLOW_JACK_O_STRAW, "Yellow");
        generateJackOStraw(translationBuilder, ModBlocks.LIME_JACK_O_STRAW, "Lime");
        generateJackOStraw(translationBuilder, ModBlocks.GREEN_JACK_O_STRAW, "Green");
        generateJackOStraw(translationBuilder, ModBlocks.CYAN_JACK_O_STRAW, "Cyan");
        generateJackOStraw(translationBuilder, ModBlocks.LIGHT_BLUE_JACK_O_STRAW, "Light Blue");
        generateJackOStraw(translationBuilder, ModBlocks.BLUE_JACK_O_STRAW, "Blue");
        generateJackOStraw(translationBuilder, ModBlocks.PURPLE_JACK_O_STRAW, "Purple");
        generateJackOStraw(translationBuilder, ModBlocks.MAGENTA_JACK_O_STRAW, "Magenta");
        generateJackOStraw(translationBuilder, ModBlocks.PINK_JACK_O_STRAW, "Pink");
        generateJackOStraw(translationBuilder, ModBlocks.WHITE_JACK_O_STRAW, "White");
        generateJackOStraw(translationBuilder, ModBlocks.LIGHT_GRAY_JACK_O_STRAW, "Light Gray");
        generateJackOStraw(translationBuilder, ModBlocks.GRAY_JACK_O_STRAW, "Gray");
        generateJackOStraw(translationBuilder, ModBlocks.BLACK_JACK_O_STRAW, "Black");
        generateJackOStraw(translationBuilder, ModBlocks.BROWN_JACK_O_STRAW, "Brown");

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


        generate(translationBuilder, "tooltip.bountifulfares.dyeable", "§7§oDyeable");

        generate(translationBuilder, ModBlocks.GRISTMILL);

        generate(translationBuilder, ModBlocks.OAK_PICKETS);
        generate(translationBuilder, ModBlocks.SPRUCE_PICKETS);
        generate(translationBuilder, ModBlocks.BIRCH_PICKETS);
        generate(translationBuilder, ModBlocks.JUNGLE_PICKETS);
        generate(translationBuilder, ModBlocks.ACACIA_PICKETS);
        generate(translationBuilder, ModBlocks.DARK_OAK_PICKETS);
        generate(translationBuilder, ModBlocks.MANGROVE_PICKETS);
        generate(translationBuilder, ModBlocks.CHERRY_PICKETS);
        generate(translationBuilder, ModBlocks.BAMBOO_PICKETS);
        generate(translationBuilder, ModBlocks.WALNUT_PICKETS);
        generate(translationBuilder, ModBlocks.HOARY_PICKETS);
        generate(translationBuilder, ModBlocks.CRIMSON_PICKETS);
        generate(translationBuilder, ModBlocks.WARPED_PICKETS);

        generate(translationBuilder, ModBlocks.GRASSY_DIRT);

        generate(translationBuilder, ModItems.JAR);
        generate(translationBuilder, ModItems.APPLE_COMPOTE_JAR);
        generate(translationBuilder, ModItems.ORANGE_COMPOTE_JAR);
        generate(translationBuilder, ModItems.LEMON_COMPOTE_JAR);
        generate(translationBuilder, ModItems.PLUM_COMPOTE_JAR);
        generate(translationBuilder, ModItems.HOARY_COMPOTE_JAR);
        generate(translationBuilder, ModBlocks.ARTISAN_BREAD);
        generate(translationBuilder, ModBlocks.ARTISAN_COOKIES);
        generate(translationBuilder, ModItems.ARTISAN_COOKIE);
        generate(translationBuilder, ModBlocks.PASSION_FRUIT_TART);
        generate(translationBuilder, ModBlocks.ELDERBERRY_TART);
        generate(translationBuilder, ModBlocks.GLOW_BERRY_TART);
        generate(translationBuilder, ModBlocks.LAPISBERRY_TART);
        generate(translationBuilder, ModBlocks.SWEET_BERRY_TART);
        generate(translationBuilder, ModBlocks.APPLE_PIE);
        generate(translationBuilder, ModBlocks.ORANGE_PIE);
        generate(translationBuilder, ModBlocks.LEMON_PIE);
        generate(translationBuilder, ModBlocks.PLUM_PIE);
        generate(translationBuilder, ModBlocks.HOARY_PIE);
        generate(translationBuilder, ModBlocks.COCOA_CAKE);
        generate(translationBuilder, ModItems.WALNUT_COOKIE);
        generate(translationBuilder, ModItems.CANDY);
        generate(translationBuilder, ModItems.SOUR_CANDY);
        generate(translationBuilder, ModItems.PIQUANT_CANDY);
        generate(translationBuilder, ModItems.BITTER_CANDY);
        generate(translationBuilder, ModItems.MAIZE_BREAD);
        generate(translationBuilder, ModItems.CANDIED_APPLE);
        generate(translationBuilder, ModItems.CANDIED_PLUM);
        generate(translationBuilder, ModItems.MUSHROOM_STUFFED_POTATO);
        generate(translationBuilder, ModItems.BERRY_STUFFED_POTATO);
        generate(translationBuilder, ModItems.MAIZE_STUFFED_POTATO);
        generate(translationBuilder, ModItems.PASSION_GLAZED_SALMON);
        generate(translationBuilder, ModItems.LEEK_STEW);
        generate(translationBuilder, ModItems.FISH_STEW);
        generate(translationBuilder, ModItems.APPLE_STEW);
        generate(translationBuilder, ModItems.STONE_STEW);
        generate(translationBuilder, ModItems.BOUNTIFUL_STEW);
        generate(translationBuilder, ModItems.CRUSTED_BEEF);
        generate(translationBuilder, ModItems.FOREST_MEDLEY);
        generate(translationBuilder, ModItems.ARID_MEDLEY);
        generate(translationBuilder, ModItems.MEADOW_MEDLEY);
        generate(translationBuilder, ModItems.COASTAL_MEDLEY);
        generate(translationBuilder, ModItems.CUSTARD);
        generate(translationBuilder, ModItems.PIQUANT_CUSTARD);
        generate(translationBuilder, ModItems.PASSION_CUSTARD);
        generate(translationBuilder, ModItems.COCOA_CUSTARD);
        generate(translationBuilder, ModItems.GLOWING_CUSTARD);
        generate(translationBuilder, ModItems.ANCIENT_CUSTARD);
        generate(translationBuilder, ModItems.CRIMSON_CHOW);
        generate(translationBuilder, ModItems.WARPED_CHOW);

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
        generate(translationBuilder, "advancement.bountifulfares.eat_citrus_essence.description", "Eat Citric Acid");

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

        generate(translationBuilder, "subtitles.block.fermentation_vessel.ferment", "Fermentation Vessel Ferments");
        generate(translationBuilder, "subtitles.block.gristmill.grind", "Gristmill Mills");
        generate(translationBuilder, "subtitles.entity.flour.throw", "Flour Flies");
        generate(translationBuilder, "subtitles.entity.flour.land", "Flour Billows");

        generate(translationBuilder, "config.bountifulfares.restart_warning", "Requires a restart to apply changes");

        generate(translationBuilder, "config.bountifulfares.item_guide_tooltips", "Show information in some items' tooltip");
        generate(translationBuilder, "config.bountifulfares.fermentation_time", "Fermentation time, in seconds");
        generate(translationBuilder, "config.bountifulfares.wild_vanilla_crops", "Generate wild vanilla crops");
        generate(translationBuilder, "config.bountifulfares.apple_trees", "Generate Apple Trees");
        generate(translationBuilder, "config.bountifulfares.orange_trees", "Generate Orange Trees");
        generate(translationBuilder, "config.bountifulfares.lemon_trees", "Generate Lemon Trees");
        generate(translationBuilder, "config.bountifulfares.plum_trees", "Generate Plum Trees");
        generate(translationBuilder, "config.bountifulfares.flower_forest_fruit_trees", "Generate fruit trees in Flower Forests");
        generate(translationBuilder, "config.bountifulfares.forest_tea_shrubs", "Generate Tea Shrubs in Forests");
        generate(translationBuilder, "config.bountifulfares.forest_walnut_trees", "Generate Walnut Trees in Forests");

        generate(translationBuilder, "pack.bountifulfares.amendments", "Bountiful Fares X Amendments");
        generate(translationBuilder, "pack.bountifulfares.mint", "Bountiful Fares X El's and L's Dye Mod");
        generate(translationBuilder, "pack.bountifulfares.dye_depot", "Bountiful Fares X Dye Depot");
    }
}
