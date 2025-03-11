package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BFTrellises {
    public static Map<String, Block> TRELLISES = new HashMap<>();
    public static Map<String, Block> CROP_TRELLISES = new HashMap<>();
    public static Map<String, Block> DECORATIVE_TRELLISES = new HashMap<>();
    public static final ArrayList<Block> TRELLIS_RENDER_CUTOUT = new ArrayList<>();


    public static final VineCrop PASSION_FRUIT = new VineCrop(BountifulFares.MOD_ID, "passion_fruit", BFItems.PASSION_FRUIT);
    public static final VineCrop ELDERBERRY = new VineCrop(BountifulFares.MOD_ID, "elderberry", BFItems.ELDERBERRIES);
    public static final VineCrop LAPISBERRY = new VineCrop(BountifulFares.MOD_ID, "lapisberry", BFItems.LAPISBERRIES, BFItems.LAPISBERRY_SEEDS);
    public static final VineCrop GLOW_BERRY = new VineCrop(BountifulFares.MOD_ID, "glow_berry", Items.GLOW_BERRIES);

    public static final DecorativeVine ROSE = new DecorativeVine(true, BountifulFares.MOD_ID, "rose", Items.ROSE_BUSH);
    public static final DecorativeVine LILAC = new DecorativeVine(true, BountifulFares.MOD_ID, "lilac", Items.LILAC);
    public static final DecorativeVine PEONY = new DecorativeVine(true, BountifulFares.MOD_ID, "peony", Items.PEONY);
    public static final DecorativeVine SUNFLOWER = new DecorativeVine(true, BountifulFares.MOD_ID, "sunflower", Items.SUNFLOWER);
    public static final DecorativeVine VINE = new DecorativeVine(false, BountifulFares.MOD_ID, "vine", Items.VINE);
    public static final DecorativeVine WEEPING = new DecorativeVine(false, BountifulFares.MOD_ID, "weeping", Items.WEEPING_VINES);
    public static final DecorativeVine TWISTING = new DecorativeVine(false, BountifulFares.MOD_ID, "twisting", Items.TWISTING_VINES);

//    Nature's Spirit
    public static DecorativeVine NS_LAVENDER;
    public static DecorativeVine NS_BLEEDING_HEART;
    public static DecorativeVine NS_BLUE_BULB;
    public static DecorativeVine NS_CARNATION;
    public static DecorativeVine NS_GARDENIA;
    public static DecorativeVine NS_MARIGOLD;
    public static DecorativeVine NS_FOXGLOVE;

//    Spawn
    public static VineCrop SPAWN_SUNFLOWER;

//    Base
    public static TrellisVariant OAK;
    public static TrellisVariant SPRUCE;
    public static TrellisVariant BIRCH;
    public static TrellisVariant JUNGLE;
    public static TrellisVariant ACACIA;
    public static TrellisVariant DARK_OAK;
    public static TrellisVariant MANGROVE;
    public static TrellisVariant CHERRY;
    public static TrellisVariant BAMBOO;

    public static TrellisVariant WALNUT;
    public static TrellisVariant HOARY;
    public static TrellisVariant CRIMSON;
    public static TrellisVariant WARPED;



//    Arts and crafts

//    Wilder Wild
//    public static TrellisVariant BAOBAB;
//    public static TrellisVariant WW_CYPRESS;
//    public static TrellisVariant PALM;

    public static void registerTrellisParts() {
        //        Compat Vine Crops
        if (BountifulFares.isDatagen()) {
            SPAWN_SUNFLOWER = new VineCrop(BountifulFares.SPAWN_MOD_ID, "spawn_sunflower", Items.WHEAT_SEEDS);
        } else if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
            SPAWN_SUNFLOWER = new VineCrop(BountifulFares.SPAWN_MOD_ID, "spawn_sunflower", Identifier.of(BountifulFares.SPAWN_MOD_ID, "sunflower_seeds"));

        }
//        Compat Decorative Vines
        if (BountifulFares.isDatagen()) {
            NS_LAVENDER = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_lavender", Items.POPPY);
            NS_BLEEDING_HEART = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_bleeding_heart", Items.POPPY);
            NS_BLUE_BULB = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_blue_bulb", Items.POPPY);
            NS_CARNATION = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_carnation", Items.POPPY);
            NS_GARDENIA = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_gardenia", Items.POPPY);
            NS_MARIGOLD = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_marigold", Items.POPPY);
            NS_FOXGLOVE = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_foxglove", Items.POPPY);
        } else if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
            NS_LAVENDER = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_lavender", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "lavender"));
            NS_BLEEDING_HEART = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_bleeding_heart", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "bleeding_heart"));
            NS_BLUE_BULB = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_blue_bulb", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "blue_bulbs"));
            NS_CARNATION = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_carnation", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "carnation"));
            NS_GARDENIA = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_gardenia", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "gardenia"));
            NS_MARIGOLD = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_marigold", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "marigold"));
            NS_FOXGLOVE = new DecorativeVine(true, BountifulFares.NATURES_SPIRIT_MOD_ID, "ns_foxglove", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "foxglove"));
        }


//        Trellis Variants
        OAK = new TrellisVariant(BountifulFares.MOD_ID, "oak", Items.OAK_PLANKS, TRELLIS_RENDER_CUTOUT);
        SPRUCE = new TrellisVariant(BountifulFares.MOD_ID, "spruce", Items.SPRUCE_PLANKS, TRELLIS_RENDER_CUTOUT);
        BIRCH = new TrellisVariant(BountifulFares.MOD_ID, "birch", Items.BIRCH_PLANKS, TRELLIS_RENDER_CUTOUT);
        JUNGLE = new TrellisVariant(BountifulFares.MOD_ID, "jungle", Items.JUNGLE_PLANKS, TRELLIS_RENDER_CUTOUT);
        ACACIA = new TrellisVariant(BountifulFares.MOD_ID, "acacia", Items.ACACIA_PLANKS, TRELLIS_RENDER_CUTOUT);
        DARK_OAK = new TrellisVariant(BountifulFares.MOD_ID, "dark_oak", Items.DARK_OAK_PLANKS, TRELLIS_RENDER_CUTOUT);
        MANGROVE = new TrellisVariant(BountifulFares.MOD_ID, "mangrove", Items.MANGROVE_PLANKS, TRELLIS_RENDER_CUTOUT);
        CHERRY = new TrellisVariant(BountifulFares.MOD_ID, "cherry", Items.CHERRY_PLANKS, TRELLIS_RENDER_CUTOUT);
        BAMBOO = new TrellisVariant(BountifulFares.MOD_ID, "bamboo", Items.BAMBOO_PLANKS, TRELLIS_RENDER_CUTOUT);
        WALNUT = new TrellisVariant(BountifulFares.MOD_ID, "walnut", BFBlocks.WALNUT_PLANKS.asItem(), TRELLIS_RENDER_CUTOUT);
        HOARY = new TrellisVariant(BountifulFares.MOD_ID, "hoary", BFBlocks.HOARY_PLANKS.asItem(), TRELLIS_RENDER_CUTOUT);
        CRIMSON = new TrellisVariant(BountifulFares.MOD_ID, "crimson", Items.CRIMSON_PLANKS, TRELLIS_RENDER_CUTOUT);
        WARPED = new TrellisVariant(BountifulFares.MOD_ID, "warped", Items.WARPED_PLANKS, TRELLIS_RENDER_CUTOUT);

//        if (BountifulFares.isModLoaded(BountifulFares.WILDER_WILD_MOD_ID)) {
//            BAOBAB = new TrellisVariant(BountifulFares.WILDER_WILD_MOD_ID, "baobab", null, TRELLIS_RENDER_CUTOUT);
//            WW_CYPRESS = new TrellisVariant(BountifulFares.WILDER_WILD_MOD_ID, "cypress", null, TRELLIS_RENDER_CUTOUT);
//            PALM = new TrellisVariant(BountifulFares.WILDER_WILD_MOD_ID, "palm", null, TRELLIS_RENDER_CUTOUT);
//        }
    }
}
