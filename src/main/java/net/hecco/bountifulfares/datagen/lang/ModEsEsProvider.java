package net.hecco.bountifulfares.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ModEsEsProvider extends FabricLanguageProvider {
    public ModEsEsProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "es_es");
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
        translationBuilder.add(block, "Espantapájaros " + color);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        generate(translationBuilder, "itemgroup.bountiful_fares", "Bountiful Fares");
        generate(translationBuilder, ModBlocks.APPLE_LOG, "Tronco de manzano");
        generate(translationBuilder, ModBlocks.STRIPPED_APPLE_LOG, "Tronco de manzano sin corteza");
        generate(translationBuilder, ModBlocks.APPLE_WOOD, "Leño de manzano");
        generate(translationBuilder, ModBlocks.STRIPPED_APPLE_WOOD, "Leño de manzano sin corteza");
        generate(translationBuilder, ModBlocks.APPLE_LEAVES, "Hojas de manzano");
        generate(translationBuilder, ModBlocks.FLOWERING_APPLE_LEAVES, "Hojas de manzano florecida");
        generate(translationBuilder, ModBlocks.APPLE_SAPLING, "Brote de manzano");
        generate(translationBuilder, ModBlocks.HANGING_APPLE, "Manzana");
        generate(translationBuilder, ModBlocks.APPLE_BLOCK, "Bloque de manzana");
        generate(translationBuilder, ModBlocks.GOLDEN_APPLE_BLOCK, "Bloque de manzana dorada");

        generate(translationBuilder, ModItems.ORANGE, "Naranja");
        generate(translationBuilder, ModBlocks.ORANGE_LOG, "Tronco de naranjo");
        generate(translationBuilder, ModBlocks.STRIPPED_ORANGE_LOG, "Tronco de naranjo sin corteza");
        generate(translationBuilder, ModBlocks.ORANGE_WOOD, "Leño de naranjo");
        generate(translationBuilder, ModBlocks.STRIPPED_ORANGE_WOOD, "Leño de naranjo sun corteza");
        generate(translationBuilder, ModBlocks.ORANGE_LEAVES, "Hojas de naranjo");
        generate(translationBuilder, ModBlocks.FLOWERING_ORANGE_LEAVES, "Hojas de naranjo florecida");
        generate(translationBuilder, ModBlocks.ORANGE_SAPLING, "Brote de naranjo");
        generate(translationBuilder, ModBlocks.HANGING_ORANGE, "Naranja");
        generate(translationBuilder, ModBlocks.ORANGE_BLOCK, "Bloque de naranja");

        generate(translationBuilder, ModItems.LEMON, "Limón");
        generate(translationBuilder, ModBlocks.LEMON_LOG, "Tronco de limonero");
        generate(translationBuilder, ModBlocks.STRIPPED_LEMON_LOG, "Tronco de limenero sin corteza");
        generate(translationBuilder, ModBlocks.LEMON_WOOD, "Leño de limonero");
        generate(translationBuilder, ModBlocks.STRIPPED_LEMON_WOOD, "Leño de limonero sin corteza");
        generate(translationBuilder, ModBlocks.LEMON_LEAVES, "Hojas de limonero");
        generate(translationBuilder, ModBlocks.FLOWERING_LEMON_LEAVES, "Hojas de limonero florecida");
        generate(translationBuilder, ModBlocks.LEMON_SAPLING, "Brote de limonero");
        generate(translationBuilder, ModBlocks.HANGING_LEMON, "Limón");
        generate(translationBuilder, ModBlocks.LEMON_BLOCK, "Bloque de limonero");

        generate(translationBuilder, ModItems.PLUM, "Ciruela");
        generate(translationBuilder, ModBlocks.PLUM_LOG, "Tronco de ciruelo");
        generate(translationBuilder, ModBlocks.STRIPPED_PLUM_LOG, "Tronco de ciruelo sin corteza");
        generate(translationBuilder, ModBlocks.PLUM_WOOD, "Leño de ciruelo");
        generate(translationBuilder, ModBlocks.STRIPPED_PLUM_WOOD, "Leño de ciruelo sin corteza");
        generate(translationBuilder, ModBlocks.PLUM_LEAVES, "Hojas de ciruelo");
        generate(translationBuilder, ModBlocks.FLOWERING_PLUM_LEAVES, "Hojas de ciruelo florecida");
        generate(translationBuilder, ModBlocks.PLUM_SAPLING, "Brote de ciruelo");
        generate(translationBuilder, ModBlocks.HANGING_PLUM, "Ciruela");
        generate(translationBuilder, ModBlocks.PLUM_BLOCK, "Bloque de ciruela");

        generate(translationBuilder, ModItems.HOARY_SEEDS, "Semillas vetusto");
        generate(translationBuilder, ModBlocks.HOARY_APPLE_SAPLING, "Brote de manzano vetusto");
        generate(translationBuilder, ModBlocks.HOARY_APPLE_SAPLING_CROP, "Brote de manzano vetusto");
        generate(translationBuilder, ModBlocks.HOARY_LOG, "Tronco vetusto");
        generate(translationBuilder, ModBlocks.STRIPPED_HOARY_LOG, "Tronco vetusto sin corteza");
        generate(translationBuilder, ModBlocks.HOARY_WOOD, "Leño vetusto");
        generate(translationBuilder, ModBlocks.STRIPPED_HOARY_WOOD, "Leño vetusto sin corteza");
        generate(translationBuilder, ModBlocks.HOARY_PLANKS, "Tablones vetusto");
        generate(translationBuilder, ModBlocks.HOARY_STAIRS, "Escaleras vetusto");
        generate(translationBuilder, ModBlocks.HOARY_SLAB, "Losa vetusto");
        generate(translationBuilder, ModBlocks.HOARY_FENCE, "Valla vetusto");
        generate(translationBuilder, ModBlocks.HOARY_FENCE_GATE, "Puerta de valla vetusto");
        generate(translationBuilder, ModBlocks.HOARY_DOOR, "Puerta vetusto");
        generate(translationBuilder, ModBlocks.HOARY_TRAPDOOR, "Trampilla vetusto");
        generate(translationBuilder, ModBlocks.HOARY_PRESSURE_PLATE, "Placa de presión vetusto");
        generate(translationBuilder, ModBlocks.HOARY_BUTTON, "Botón vetusto");
        generate(translationBuilder, ModBlocks.HOARY_LEAVES, "Hojas vetustos");
        generate(translationBuilder, ModBlocks.HOARY_SIGN, "Cartel vetusto");
        generate(translationBuilder, ModBlocks.HOARY_HANGING_SIGN, "Cartel colgande vetusto");
        generate(translationBuilder, ModItems.HOARY_BOAT, "Barca vetusta");
        generate(translationBuilder, ModItems.HOARY_CHEST_BOAT, "Barco vetusto con cofre");
        generate(translationBuilder, ModItems.HOARY_APPLE, "Manzana vetusto");
        generate(translationBuilder, ModBlocks.HOARY_APPLE_BLOCK, "Bloque de manzana vetusto");

        generate(translationBuilder, ModBlocks.WALNUT_SAPLING, "Brote de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_LOG, "Tronco de nogal");
        generate(translationBuilder, ModBlocks.STRIPPED_WALNUT_LOG, "Tronco de nogal sin corteza");
        generate(translationBuilder, ModBlocks.WALNUT_WOOD, "Leño de nogal");
        generate(translationBuilder, ModBlocks.STRIPPED_WALNUT_WOOD, "Leño de nogal sun corteza");
        generate(translationBuilder, ModBlocks.WALNUT_PLANKS, "Tablones de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_STAIRS, "Escaleras de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_SLAB, "Losa de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_FENCE, "Valla de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_FENCE_GATE, "Puerta de valla de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_DOOR, "Puerta de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_TRAPDOOR, "Trampilla de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_PRESSURE_PLATE, "Placa de presión de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_BUTTON, "Botón de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_LEAVES, "Hojas de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_SIGN, "Cartel de nogal");
        generate(translationBuilder, ModBlocks.WALNUT_HANGING_SIGN, "Cartel colgande de nogal");
        generate(translationBuilder, ModItems.WALNUT_BOAT, "Barca de nogal");
        generate(translationBuilder, ModItems.WALNUT_CHEST_BOAT, "Barca de nogal con cofre");
        generate(translationBuilder, ModItems.WALNUT, "Nuez");
        generate(translationBuilder, ModBlocks.WALNUT_MULCH, "Mantilla de nuez");
        generate(translationBuilder, ModBlocks.WALNUT_MULCH_BLOCK, "Bloque de mantilla de nuez");

        generate(translationBuilder, ModItems.CITRUS_ESSENCE, "Ácido cítrico");
        generate(translationBuilder, "effect.bountifulfares.acidic", "Ácidic");
        generate(translationBuilder, "item.minecraft.potion.effect.bountifulfares.acidic", "Poción de ácido");
        generate(translationBuilder, "item.minecraft.potion.effect.bountifulfares.long_acidic", "Poción de ácido");
        generate(translationBuilder, "item.minecraft.potion.effect.bountifulfares.strong_acidic", "Poción de ácido");
        generate(translationBuilder, "item.minecraft.splash_potion.effect.bountifulfares.acidic", "Splash Poción de ácido");
        generate(translationBuilder, "item.minecraft.splash_potion.effect.bountifulfares.long_acidic", "Splash Poción de ácido");
        generate(translationBuilder, "item.minecraft.splash_potion.effect.bountifulfares.strong_acidic", "Splash Poción de ácido");
        generate(translationBuilder, "item.minecraft.lingering_potion.effect.bountifulfares.acidic", "Lingering Poción de ácido");
        generate(translationBuilder, "item.minecraft.lingering_potion.effect.bountifulfares.long_acidic", "Lingering Poción de ácido");
        generate(translationBuilder, "item.minecraft.lingering_potion.effect.bountifulfares.strong_acidic", "Lingering Poción de ácido");
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

        generate(translationBuilder, ModItems.CANDIED_ORANGE, "Naranja confitado");
        generate(translationBuilder, ModItems.CANDIED_LEMON, "Limón confitado");

        generate(translationBuilder, ModBlocks.TRELLIS, "Espaldera");
        generate(translationBuilder, ModBlocks.PASSION_FRUIT_TRELLIS, "Espaldera de maracuyá");
        generate(translationBuilder, ModBlocks.ELDERBERRY_TRELLIS, "Espaldera de baya de saúco");
        generate(translationBuilder, ModBlocks.GLOW_BERRY_TRELLIS, "Espaldera de baya luminosa");
        generate(translationBuilder, ModBlocks.LAPISBERRY_TRELLIS, "Espaldera de baya azur");
        generate(translationBuilder, ModBlocks.ROSE_TRELLIS, "Espaldera de rosa");
        generate(translationBuilder, ModBlocks.LILAC_TRELLIS, "Espaldera de lila");
        generate(translationBuilder, ModBlocks.PEONY_TRELLIS, "Espaldera de peonía");
        generate(translationBuilder, ModBlocks.SUNFLOWER_TRELLIS, "Espaldera de girasol");
        generate(translationBuilder, ModBlocks.VINE_TRELLIS, "Espaldera de enredaderas");

        generate(translationBuilder, ModItems.PASSION_FRUIT, "Maracuyá");
        generate(translationBuilder, ModItems.ELDERBERRIES, "Bayas de saúco");
        generate(translationBuilder, ModItems.LAPISBERRIES, "Bayas azur");
        generate(translationBuilder, ModItems.LAPISBERRY_SEEDS, "Semillas de baya azur");

        generate(translationBuilder, ModBlocks.WILD_WHEAT, "Trigo salvaje");
        generate(translationBuilder, ModBlocks.WILD_CARROTS, "Zanahorias salvajes");
        generate(translationBuilder, ModBlocks.WILD_POTATOES, "Patatas salvajes");
        generate(translationBuilder, ModBlocks.WILD_BEETROOTS, "Remolachas salvajes");
        generate(translationBuilder, ModBlocks.WILD_LEEKS, "Puerros salvajes");
        generate(translationBuilder, ModBlocks.WILD_MAIZE, "Maíz salvaje");
        generate(translationBuilder, ModBlocks.WILD_PASSION_FRUIT_VINE, "Enredaderas de maracuvá salvaje");
        generate(translationBuilder, ModBlocks.WILD_ELDERBERRY_VINE, "Enredaderas de bayas de saúco salvaje");

        generate(translationBuilder, ModItems.MAIZE, "Maíz");
        generate(translationBuilder, ModBlocks.MAIZE_CROP, "Maíz");
        generate(translationBuilder, ModItems.MAIZE_SEEDS, "Semillas de maíz");
        generate(translationBuilder, ModItems.LEEK, "Puerro");
        generate(translationBuilder, ModBlocks.LEEKS, "Puerros");
        generate(translationBuilder, ModItems.LEEK_SEEDS, "Semillas de puerro");

        generate(translationBuilder, ModBlocks.SPONGEKIN_STEM, "Tallo de melón mullido");
        generate(translationBuilder, ModBlocks.SPONGEKIN_SPROUT, "Retoño de melón mullido");
        generate(translationBuilder, ModBlocks.SPONGEKIN, "Melón mullido");
        generate(translationBuilder, ModItems.SPONGEKIN_SEEDS, "Semillas de melón mullido");
        generate(translationBuilder, ModItems.SPONGEKIN_SLICE, "Rodaja de melón mullido");
        generate(translationBuilder, ModBlocks.PRISMARINE_BLOSSOM, "Flor de prismarina");

        generate(translationBuilder, ModItems.FLOUR, "Harina");

        generate(translationBuilder, ModItems.FELDSPAR, "Feldespato");
        generate(translationBuilder, ModBlocks.FELDSPAR_BLOCK, "Bloque de feldespato");
        generate(translationBuilder, ModBlocks.CUT_FELDSPAR_BLOCK, "Bloque de feldespato cortado");
        generate(translationBuilder, ModBlocks.FELDSPAR_BRICKS, "Ladrillos de feldespato");
        generate(translationBuilder, ModBlocks.FELDSPAR_BRICK_STAIRS, "Escaleras de ladrillos de feldespato");
        generate(translationBuilder, ModBlocks.FELDSPAR_BRICK_SLAB, "Losa de ladrillos de feldespato");
        generate(translationBuilder, ModBlocks.FELDSPAR_LANTERN, "Farol de feldespato");
        generate(translationBuilder, ModBlocks.TINGED_GLASS, "Cristal tintado");
        generate(translationBuilder, ModItems.CERAMIC_CLAY, "Arcilla cerámica");
        generate(translationBuilder, ModItems.CERAMIC_TILE, "Baldosa de cerámica");
        generate(translationBuilder, ModBlocks.CERAMIC_CLAY_BLOCK, "Bloque de arcilla cerámica");
        generate(translationBuilder, ModBlocks.FERMENTATION_VESSEL, "Vasija de fermentación");
        generate(translationBuilder, ModItems.ARTISAN_BRUSH, "Pincel artesano");
        generate(translationBuilder, ModBlocks.CERAMIC_TILES, "Baldosas de cerámica");
        generate(translationBuilder, ModBlocks.CERAMIC_TILE_STAIRS, "Escaleras de baldosas de cerámica");
        generate(translationBuilder, ModBlocks.CERAMIC_TILE_SLAB, "Losa de baldosas de cerámica");
        generate(translationBuilder, ModBlocks.CHECKERED_CERAMIC_TILES, "Baldosas de cerámica a cuadros");
        generate(translationBuilder, ModBlocks.CHECKERED_CERAMIC_TILE_STAIRS, "Escaleras de baldosas de cerámica a cuadros");
        generate(translationBuilder, ModBlocks.CHECKERED_CERAMIC_TILE_SLAB, "Losa de baldosas de cerámica a cuadros");
        generate(translationBuilder, ModBlocks.CERAMIC_PRESSURE_PLATE, "Placa de presión de cerámica");
        generate(translationBuilder, ModBlocks.CERAMIC_BUTTON, "Botón de cerámica");
        generate(translationBuilder, ModBlocks.CERAMIC_DISH, "Plato de cerámica");

        generate(translationBuilder, ModItems.ELDERBERRY_WINE_BOTTLE, "Frasco con vino de baya de saúco");
        generate(translationBuilder, ModItems.LAPISBERRY_WINE_BOTTLE, "Frasco con vino de baya azur");
        generate(translationBuilder, ModItems.MEAD_BOTTLE, "Frasco con aguamiel");
        generate(translationBuilder, ModItems.APPLE_CIDER_JAR, "Tarro con sidra de manzana");
        generate(translationBuilder, ModItems.PLUM_CIDER_JAR, "Tarro con sidra de ciruela");
        generate(translationBuilder, ModItems.HOARY_CIDER_JAR, "Tarro con sidra vetusto");

        generate(translationBuilder, ModItems.TEA_BERRIES, "Bayas de té");
        generate(translationBuilder, ModItems.TEA_LEAVES, "Hojas de té");
        generate(translationBuilder, ModItems.DRIED_TEA_LEAVES, "Hojas de té secas");
        generate(translationBuilder, ModBlocks.CHAMOMILE_FLOWERS, "Manzanillas");
        generate(translationBuilder, ModBlocks.HONEYSUCKLE, "Madreselva");
        generate(translationBuilder, ModBlocks.VIOLET_BELLFLOWER, "Campanilla violeta");

        generate(translationBuilder, ModItems.GREEN_TEA_BLEND, "Mezcla de té verde");
        generate(translationBuilder, ModItems.BLACK_TEA_BLEND, "Mezcla de té negro");
        generate(translationBuilder, ModItems.CHAMOMILE_TEA_BLEND, "Mezcla de té de manzanilla");
        generate(translationBuilder, ModItems.HONEYSUCKLE_TEA_BLEND, "Mezcla de té de madreselva");
        generate(translationBuilder, ModItems.BELLFLOWER_TEA_BLEND, "Mezcla de té de campanilla");
        generate(translationBuilder, ModItems.TORCHFLOWER_TEA_BLEND, "Mezcla de té de plantorcha");

        generate(translationBuilder, ModItems.GREEN_TEA_BOTTLE, "Frasco con té verde");
        generate(translationBuilder, ModItems.BLACK_TEA_BOTTLE, "Frasco con té negro");
        generate(translationBuilder, ModItems.CHAMOMILE_TEA_BOTTLE, "Frasco con té de manzanilla");
        generate(translationBuilder, ModItems.HONEYSUCKLE_TEA_BOTTLE, "Frasco con té de madreselva");
        generate(translationBuilder, ModItems.BELLFLOWER_TEA_BOTTLE, "Frasco con té de campanilla");
        generate(translationBuilder, ModItems.TORCHFLOWER_TEA_BOTTLE, "Frasco con té de plantorcha");

        generate(translationBuilder, ModBlocks.GREEN_TEA_CANDLE, "Vela de té verde");
        generate(translationBuilder, ModBlocks.BLACK_TEA_CANDLE, "Vela de té negro");
        generate(translationBuilder, ModBlocks.CHAMOMILE_CANDLE, "Vela de té de manzanilla");
        generate(translationBuilder, ModBlocks.HONEYSUCKLE_CANDLE, "Vela de té de madreselva");
        generate(translationBuilder, ModBlocks.BELLFLOWER_CANDLE, "Vela de té de campanilla");
        generate(translationBuilder, ModBlocks.TORCHFLOWER_CANDLE, "Vela de té de plantorcha");
        generate(translationBuilder, ModBlocks.WALNUT_CANDLE, "Vela de nuez");

        generate(translationBuilder, "effect.bountifulfares.ebullience", "Vitalidad");
        generate(translationBuilder, "effect.bountifulfares.gorging", "Atiborrarse");

        generate(translationBuilder, ModItems.SUN_HAT, "Sombrero de sol");

        generateJackOStraw(translationBuilder, ModBlocks.RED_JACK_O_STRAW, "rojo");
        generateJackOStraw(translationBuilder, ModBlocks.ORANGE_JACK_O_STRAW, "naranja");
        generateJackOStraw(translationBuilder, ModBlocks.YELLOW_JACK_O_STRAW, "amarillo");
        generateJackOStraw(translationBuilder, ModBlocks.LIME_JACK_O_STRAW, "verde lima");
        generateJackOStraw(translationBuilder, ModBlocks.GREEN_JACK_O_STRAW, "verde");
        generateJackOStraw(translationBuilder, ModBlocks.CYAN_JACK_O_STRAW, "cian");
        generateJackOStraw(translationBuilder, ModBlocks.LIGHT_BLUE_JACK_O_STRAW, "azul claro");
        generateJackOStraw(translationBuilder, ModBlocks.BLUE_JACK_O_STRAW, "azul");
        generateJackOStraw(translationBuilder, ModBlocks.PURPLE_JACK_O_STRAW, "morado");
        generateJackOStraw(translationBuilder, ModBlocks.MAGENTA_JACK_O_STRAW, "magenta");
        generateJackOStraw(translationBuilder, ModBlocks.PINK_JACK_O_STRAW, "rosa");
        generateJackOStraw(translationBuilder, ModBlocks.WHITE_JACK_O_STRAW, "blanco");
        generateJackOStraw(translationBuilder, ModBlocks.LIGHT_GRAY_JACK_O_STRAW, "gris claro");
        generateJackOStraw(translationBuilder, ModBlocks.GRAY_JACK_O_STRAW, "gris");
        generateJackOStraw(translationBuilder, ModBlocks.BLACK_JACK_O_STRAW, "negro");
        generateJackOStraw(translationBuilder, ModBlocks.BROWN_JACK_O_STRAW, "marrón");

//        generateJackOStraw(translationBuilder, ModBlocks.ACORN_JACK_O_STRAW, "bellota");
//        generateJackOStraw(translationBuilder, ModBlocks.AMBER_JACK_O_STRAW, "ámbar");
//        generateJackOStraw(translationBuilder, ModBlocks.ARTICHOKE_JACK_O_STRAW, "alcachofa");
//        generateJackOStraw(translationBuilder, ModBlocks.BANANA_JACK_O_STRAW, "plátano");
//        generateJackOStraw(translationBuilder, ModBlocks.CERULEAN_JACK_O_STRAW, "cerúleo");
//        generateJackOStraw(translationBuilder, ModBlocks.FUCHSIA_JACK_O_STRAW, "fucsia");
//        generateJackOStraw(translationBuilder, ModBlocks.GRAPE_JACK_O_STRAW, "uva");
//        generateJackOStraw(translationBuilder, ModBlocks.INDIGO_JACK_O_STRAW, "índigo");
//        generateJackOStraw(translationBuilder, ModBlocks.MAROON_JACK_O_STRAW, "granate");
//        generateJackOStraw(translationBuilder, ModBlocks.MAUVE_JACK_O_STRAW, "malva");
//        generateJackOStraw(translationBuilder, ModBlocks.MINT_JACK_O_STRAW, "menta");
//        generateJackOStraw(translationBuilder, ModBlocks.MOLD_JACK_O_STRAW, "moho");
//        generateJackOStraw(translationBuilder, ModBlocks.NAVY_JACK_O_STRAW, "Navy");
//        generateJackOStraw(translationBuilder, ModBlocks.PEACH_JACK_O_STRAW, "azul marino");
//        generateJackOStraw(translationBuilder, ModBlocks.PERIWINKLE_JACK_O_STRAW, "vincapervinca");
//        generateJackOStraw(translationBuilder, ModBlocks.SAGE_JACK_O_STRAW, "salvia");
//        generateJackOStraw(translationBuilder, ModBlocks.SAP_JACK_O_STRAW, "savia");
//        generateJackOStraw(translationBuilder, ModBlocks.SHAMROCK_JACK_O_STRAW, "trébol");
//        generateJackOStraw(translationBuilder, ModBlocks.VELVET_JACK_O_STRAW, "terciopelo");
//        generateJackOStraw(translationBuilder, ModBlocks.VERMILION_JACK_O_STRAW, "bermellón");
//        generate(translationBuilder, "tooltip.bountifulfares.els_and_ls_dye_mod_warning", "§7§oEl's and L's Dye Mod no está instalado!");
        generate(translationBuilder, "tooltip.bountifulfares.dyeable", "§7§oSe puede teñir");

        generate(translationBuilder, ModBlocks.GRISTMILL, "Molino");

        generate(translationBuilder, ModBlocks.OAK_PICKETS, "Estacas de roble");
        generate(translationBuilder, ModBlocks.SPRUCE_PICKETS, "Estacas de abeto");
        generate(translationBuilder, ModBlocks.BIRCH_PICKETS, "Estacas de abedul");
        generate(translationBuilder, ModBlocks.JUNGLE_PICKETS, "Estacas de jungla");
        generate(translationBuilder, ModBlocks.ACACIA_PICKETS, "Estacas de acacia");
        generate(translationBuilder, ModBlocks.DARK_OAK_PICKETS, "Estacas de roble oscuro");
        generate(translationBuilder, ModBlocks.MANGROVE_PICKETS, "Estacas de mangle");
        generate(translationBuilder, ModBlocks.CHERRY_PICKETS, "Estacas de cerezo");
        generate(translationBuilder, ModBlocks.BAMBOO_PICKETS, "Estacas de bambú");
        generate(translationBuilder, ModBlocks.WALNUT_PICKETS, "Estacas de nogal");
        generate(translationBuilder, ModBlocks.HOARY_PICKETS, "Estacas vetusto");
        generate(translationBuilder, ModBlocks.CRIMSON_PICKETS, "Estacas carmesí");
        generate(translationBuilder, ModBlocks.WARPED_PICKETS, "Estacas distorsionado");

        generate(translationBuilder, ModItems.JAR, "Tarro");
        generate(translationBuilder, ModItems.APPLE_COMPOTE_JAR, "Tarro con compota de manzana");
        generate(translationBuilder, ModItems.ORANGE_COMPOTE_JAR, "Tarro con compota de naranja");
        generate(translationBuilder, ModItems.LEMON_COMPOTE_JAR, "Tarro compota de limón");
        generate(translationBuilder, ModItems.PLUM_COMPOTE_JAR, "Tarro compota de ciruela");
        generate(translationBuilder, ModItems.HOARY_COMPOTE_JAR, "Tarro compota vetusto");
        generate(translationBuilder, ModBlocks.ARTISAN_BREAD, "Pan artesano");
        generate(translationBuilder, ModBlocks.ARTISAN_COOKIES, "Galletas artesanos");
        generate(translationBuilder, ModItems.ARTISAN_COOKIE, "Galleta artesano");
        generate(translationBuilder, ModBlocks.PASSION_FRUIT_TART, "Tartaleta de maracuyá");
        generate(translationBuilder, ModBlocks.ELDERBERRY_TART, "Tartaleta de baya de saúco");
        generate(translationBuilder, ModBlocks.GLOW_BERRY_TART, "Tartaleta de baya luminosa");
        generate(translationBuilder, ModBlocks.LAPISBERRY_TART, "Tartaleta de baya azur");
        generate(translationBuilder, ModBlocks.SWEET_BERRY_TART, "Tartaleta de baya dulce");
        generate(translationBuilder, ModBlocks.APPLE_PIE, "Tarta de manzana");
        generate(translationBuilder, ModBlocks.ORANGE_PIE, "Tarta de naranja");
        generate(translationBuilder, ModBlocks.LEMON_PIE, "Tarta de limón");
        generate(translationBuilder, ModBlocks.PLUM_PIE, "Tarta de ciruela");
        generate(translationBuilder, ModBlocks.HOARY_PIE, "Tarta vetusto");
        generate(translationBuilder, ModBlocks.COCOA_CAKE, "Tarta de cacao");
        generate(translationBuilder, ModItems.WALNUT_COOKIE, "Galleta de nuez");
        generate(translationBuilder, ModItems.CANDY, "Caramelo");
        generate(translationBuilder, ModItems.SOUR_CANDY, "Caramelo ácido");
        generate(translationBuilder, ModItems.PIQUANT_CANDY, "Caramelo dulce");
        generate(translationBuilder, ModItems.BITTER_CANDY, "Caramelo amargo");
        generate(translationBuilder, ModItems.MAIZE_BREAD, "Pan de maíz");
        generate(translationBuilder, ModItems.CANDIED_APPLE, "Manzana confitado");
        generate(translationBuilder, ModItems.CANDIED_PLUM, "Ciruela confitado");
        generate(translationBuilder, ModItems.MUSHROOM_STUFFED_POTATO, "Patata lleno con champiñónes");
        generate(translationBuilder, ModItems.BERRY_STUFFED_POTATO, "Patata lleno con bayas");
        generate(translationBuilder, ModItems.MAIZE_STUFFED_POTATO, "Patata lleno maíz");
        generate(translationBuilder, ModItems.PASSION_GLAZED_SALMON, "Salmón con claseadio maracuyá");
        generate(translationBuilder, ModItems.LEEK_STEW, "Estofado de puerro");
        generate(translationBuilder, ModItems.FISH_STEW, "Estofado de pescado");
        generate(translationBuilder, ModItems.STONE_STEW, "Estofado de piedra");
        generate(translationBuilder, ModItems.BOUNTIFUL_STEW, "Estofado copioso");
        generate(translationBuilder, ModItems.CRUSTED_BEEF, "Filete con corteza");
        generate(translationBuilder, ModItems.CUSTARD, "Natillas");
        generate(translationBuilder, ModItems.PIQUANT_CUSTARD, "Natillas dulces");
        generate(translationBuilder, ModItems.PASSION_CUSTARD, "Natillas de maracuyá");
        generate(translationBuilder, ModItems.COCOA_CUSTARD, "Natillas de cacao");
        generate(translationBuilder, ModItems.GLOWING_CUSTARD, "Natillas luminosas");
        generate(translationBuilder, ModItems.ANCIENT_CUSTARD, "Natillas vetustos");
        generate(translationBuilder, ModItems.CRIMSON_CHOW, "Comida carmesí");
        generate(translationBuilder, ModItems.WARPED_CHOW, "Comida distorsionado");

        generate(translationBuilder, "warning.bountifulfares.fermentation_vessel.glass_bottle", "¡Necesitas usar un frasco a obtener este!");

        generate(translationBuilder, "advancement.bountifulfares.bountiful_fares", "Comida copioso");
        generate(translationBuilder, "advancement.bountifulfares.bountiful_fares.description", "¡El mundo está lleno con mas comida!");

        generate(translationBuilder, "advancement.bountifulfares.place_gristmill", "En la molienda");
        generate(translationBuilder, "advancement.bountifulfares.place_gristmill.description", "Coloca el molino.");

        generate(translationBuilder, "advancement.bountifulfares.obtain_feldspar", "Forrajeador félsica");
        generate(translationBuilder, "advancement.bountifulfares.obtain_feldspar.description", "Obtén feldespato por moliendo piedras.");

        generate(translationBuilder, "advancement.bountifulfares.obtain_ceramic_tiles", "ROY G BIV");
        generate(translationBuilder, "advancement.bountifulfares.obtain_ceramic_tiles.description", "Haz baldosas de cerámica.");

        generate(translationBuilder, "advancement.bountifulfares.feed_wolf_mulch", "Máxador de mantillo");
        generate(translationBuilder, "advancement.bountifulfares.feed_wolf_mulch.description", "Alimenta el lobo mantillo de nuez. ¡Que rico!");

        generate(translationBuilder, "advancement.bountifulfares.obtain_fermentation_vessel", "Doble penuria y doble labor");
        generate(translationBuilder, "advancement.bountifulfares.obtain_fermentation_vessel.description", "Haz una vasija de fermentación.");

        generate(translationBuilder, "advancement.bountifulfares.eat_ancient_fruit", "¿Cuánto tiempo ha estado esto fuera?");
        generate(translationBuilder, "advancement.bountifulfares.eat_ancient_fruit.description", "Come un fruto de el pasado distante.");

        generate(translationBuilder, "advancement.bountifulfares.place_all_baked_goods", "Docena de panadero");
        generate(translationBuilder, "advancement.bountifulfares.place_all_baked_goods.description", "Coloca cada pasteles.");

        generate(translationBuilder, "advancement.bountifulfares.eat_citrus_essence", "Neccesito antiácido");
        generate(translationBuilder, "advancement.bountifulfares.eat_citrus_essence.description", "Come ácido cítrico.");

        generate(translationBuilder, "advancement.bountifulfares.throw_flour", "Great Escape");
        generate(translationBuilder, "advancement.bountifulfares.throw_flour.description", "Throw Flour");

        generate(translationBuilder, "advancement.bountifulfares.obtain_sun_hat", "Tiempo de cultivo");
        generate(translationBuilder, "advancement.bountifulfares.obtain_sun_hat.description", "Obtén el sombrero de sol.");

        generate(translationBuilder, "advancement.bountifulfares.eat_all_candy", "Estoy goloso");
        generate(translationBuilder, "advancement.bountifulfares.eat_all_candy.description", "Come cada caramelo.");

        generate(translationBuilder, "advancement.bountifulfares.gorge", "Quizá uno mas...");
        generate(translationBuilder, "advancement.bountifulfares.gorge.description", "Atibórrate.");

        generate(translationBuilder, "advancement.bountifulfares.obtain_tea_blends", "Té Té");
        generate(translationBuilder, "advancement.bountifulfares.obtain_tea_blends.description", "Obtén cada mezcla de té.");

        generate(translationBuilder, "advancement.bountifulfares.place_all_tea_candles", "¡Es fragante!");
        generate(translationBuilder, "advancement.bountifulfares.place_all_tea_candles.description", "Coloca cada vela de té.");

        generate(translationBuilder, "advancement.bountifulfares.obtain_walnut", "Deez");
        generate(translationBuilder, "advancement.bountifulfares.obtain_walnut.description", "Obtén una nuez.");

        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin_seeds", "A Spongy Place");
        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin_seeds.description", "Discover the source of all these Sponges...");

        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin", "Who Lives in a Loofah Under the Sea");
        generate(translationBuilder, "advancement.bountifulfares.obtain_spongekin.description", "Crece y junta un melón mullido.");


    }
}
