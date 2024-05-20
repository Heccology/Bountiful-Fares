package net.hecco.bountifulfares.trellis;

import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.hecco.bountifulfares.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModTrellises {
    public static Map<String, Block> TRELLISES = new HashMap<>();
    public static Map<String, Block> CROP_TRELLISES = new HashMap<>();
    public static Map<String, Block> DECORATIVE_TRELLISES = new HashMap<>();
    public static final ArrayList<Block> TRELLIS_RENDER_CUTOUT = new ArrayList<>();

    public static final VineCrop PASSION_FRUIT = new VineCrop(BountifulFares.MOD_ID, "passion_fruit", ModItems.PASSION_FRUIT);
    public static final VineCrop ELDERBERRY = new VineCrop(BountifulFares.MOD_ID, "elderberry", ModItems.ELDERBERRIES);
    public static final VineCrop LAPISBERRY = new VineCrop(BountifulFares.MOD_ID, "lapisberry", ModItems.LAPISBERRIES, ModItems.LAPISBERRY_SEEDS);
    public static final VineCrop GLOW_BERRY = new VineCrop(BountifulFares.MOD_ID, "glow_berry", Items.GLOW_BERRIES);
    public static final DecorativeVine ROSE = new DecorativeVine(true, BountifulFares.MOD_ID, "rose", Items.ROSE_BUSH);
    public static final DecorativeVine LILAC = new DecorativeVine(true, BountifulFares.MOD_ID, "lilac", Items.LILAC);
    public static final DecorativeVine PEONY = new DecorativeVine(true, BountifulFares.MOD_ID, "peony", Items.PEONY);
    public static final DecorativeVine SUNFLOWER = new DecorativeVine(true, BountifulFares.MOD_ID, "sunflower", Items.SUNFLOWER);
    public static final DecorativeVine VINE = new DecorativeVine(false, BountifulFares.MOD_ID, "vine", Items.VINE);
    public static final DecorativeVine WEEPING = new DecorativeVine(false, BountifulFares.MOD_ID, "weeping", Items.WEEPING_VINES);
    public static final DecorativeVine TWISTING = new DecorativeVine(false, BountifulFares.MOD_ID, "twisting", Items.TWISTING_VINES);


    public static DecorativeVine NS_LAVENDER;
    public static DecorativeVine NS_BLEEDING_HEART;
    public static DecorativeVine NS_BLUE_BULB;
    public static DecorativeVine NS_CARNATION;
    public static DecorativeVine NS_GARDENIA;
    public static DecorativeVine NS_MARIGOLD;
    public static DecorativeVine NS_FOXGLOVE;

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
//    El's and L's Dyes
    public static TrellisVariant WINTERGREEN;

//    Excessive Building
    public static TrellisVariant ANCIENT;

//    Nature's Spirit
    public static TrellisVariant ASPEN;
    public static TrellisVariant CEDAR;
    public static TrellisVariant COCONUT;
    public static TrellisVariant CYPRESS;
    public static TrellisVariant FIR;
    public static TrellisVariant GHAF;
    public static TrellisVariant JOSHUA;
    public static TrellisVariant LARCH;
    public static TrellisVariant MAHOGANY;
    public static TrellisVariant MAPLE;
    public static TrellisVariant OLIVE;
    public static TrellisVariant PALO_VERDE;
    public static TrellisVariant REDWOOD;
    public static TrellisVariant SAXAUL;
    public static TrellisVariant SUGI;
    public static TrellisVariant WILLOW;
    public static TrellisVariant WISTERIA;

    public static void registerTrellisParts() {
        if (System.getProperty("fabric-api.datagen") != null) {
            NS_LAVENDER = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_lavender", Items.POPPY);
            NS_BLEEDING_HEART = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_bleeding_heart", Items.POPPY);
            NS_BLUE_BULB = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_blue_bulb", Items.POPPY);
            NS_CARNATION = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_carnation", Items.POPPY);
            NS_GARDENIA = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_gardenia", Items.POPPY);
            NS_MARIGOLD = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_marigold", Items.POPPY);
            NS_FOXGLOVE = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_foxglove", Items.POPPY);
        }
        if (FabricLoader.getInstance().isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID) && System.getProperty("fabric-api.datagen") == null) {
            NS_LAVENDER = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_lavender", new Identifier(BountifulFares.NATURES_SPIRIT_MOD_ID, "lavender"));
            NS_BLEEDING_HEART = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_bleeding_heart", new Identifier(BountifulFares.NATURES_SPIRIT_MOD_ID, "bleeding_heart"));
            NS_BLUE_BULB = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_blue_bulb", new Identifier(BountifulFares.NATURES_SPIRIT_MOD_ID, "blue_bulbs"));
            NS_CARNATION = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_carnation", new Identifier(BountifulFares.NATURES_SPIRIT_MOD_ID, "carnation"));
            NS_GARDENIA = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_gardenia", new Identifier(BountifulFares.NATURES_SPIRIT_MOD_ID, "gardenia"));
            NS_MARIGOLD = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_marigold", new Identifier(BountifulFares.NATURES_SPIRIT_MOD_ID, "marigold"));
            NS_FOXGLOVE = new DecorativeVine(true, BountifulFares.MOD_ID, "ns_foxglove", new Identifier(BountifulFares.NATURES_SPIRIT_MOD_ID, "foxglove"));
        }
        if (FabricLoader.getInstance().isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
            WINTERGREEN = new TrellisVariant(BountifulFares.ELS_AND_LS_DYES_MOD_ID, "wintergreen", null, TRELLIS_RENDER_CUTOUT);
        }
        if (FabricLoader.getInstance().isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
            ANCIENT = new TrellisVariant(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "ancient", null, TRELLIS_RENDER_CUTOUT);
        }
        if (FabricLoader.getInstance().isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
            REDWOOD = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "redwood", null, TRELLIS_RENDER_CUTOUT);
            SUGI = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "sugi", null, TRELLIS_RENDER_CUTOUT);
            WISTERIA = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "wisteria", null, TRELLIS_RENDER_CUTOUT);
            FIR = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "fir", null, TRELLIS_RENDER_CUTOUT);
            WILLOW = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "willow", null, TRELLIS_RENDER_CUTOUT);
            ASPEN = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "aspen", null, TRELLIS_RENDER_CUTOUT);
            MAPLE = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "maple", null, TRELLIS_RENDER_CUTOUT);
            CYPRESS = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "cypress", null, TRELLIS_RENDER_CUTOUT);
            OLIVE = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "olive", null, TRELLIS_RENDER_CUTOUT);
            JOSHUA = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "joshua", null, TRELLIS_RENDER_CUTOUT);
            GHAF = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "ghaf", null, TRELLIS_RENDER_CUTOUT);
            PALO_VERDE = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "palo_verde", null, TRELLIS_RENDER_CUTOUT);
            COCONUT = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut", null, TRELLIS_RENDER_CUTOUT);
            CEDAR = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "cedar", null, TRELLIS_RENDER_CUTOUT);
            LARCH = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "larch", null, TRELLIS_RENDER_CUTOUT);
            MAHOGANY = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "mahogany", null, TRELLIS_RENDER_CUTOUT);
            SAXAUL = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "saxaul", null, TRELLIS_RENDER_CUTOUT);
        }
        OAK = new TrellisVariant(BountifulFares.MOD_ID, "oak", Items.OAK_PLANKS, TRELLIS_RENDER_CUTOUT);
        SPRUCE = new TrellisVariant(BountifulFares.MOD_ID, "spruce", Items.SPRUCE_PLANKS, TRELLIS_RENDER_CUTOUT);
        BIRCH = new TrellisVariant(BountifulFares.MOD_ID, "birch", Items.BIRCH_PLANKS, TRELLIS_RENDER_CUTOUT);
        JUNGLE = new TrellisVariant(BountifulFares.MOD_ID, "jungle", Items.JUNGLE_PLANKS, TRELLIS_RENDER_CUTOUT);
        ACACIA = new TrellisVariant(BountifulFares.MOD_ID, "acacia", Items.ACACIA_PLANKS, TRELLIS_RENDER_CUTOUT);
        DARK_OAK = new TrellisVariant(BountifulFares.MOD_ID, "dark_oak", Items.DARK_OAK_PLANKS, TRELLIS_RENDER_CUTOUT);
        MANGROVE = new TrellisVariant(BountifulFares.MOD_ID, "mangrove", Items.MANGROVE_PLANKS, TRELLIS_RENDER_CUTOUT);
        CHERRY = new TrellisVariant(BountifulFares.MOD_ID, "cherry", Items.CHERRY_PLANKS, TRELLIS_RENDER_CUTOUT);
        BAMBOO = new TrellisVariant(BountifulFares.MOD_ID, "bamboo", Items.BAMBOO_PLANKS, TRELLIS_RENDER_CUTOUT);
        WALNUT = new TrellisVariant(BountifulFares.MOD_ID, "walnut", ModBlocks.WALNUT_PLANKS.asItem(), TRELLIS_RENDER_CUTOUT);
        HOARY = new TrellisVariant(BountifulFares.MOD_ID, "hoary", ModBlocks.HOARY_PLANKS.asItem(), TRELLIS_RENDER_CUTOUT);
        CRIMSON = new TrellisVariant(BountifulFares.MOD_ID, "crimson", Items.CRIMSON_PLANKS, TRELLIS_RENDER_CUTOUT);
        WARPED = new TrellisVariant(BountifulFares.MOD_ID, "warped", Items.WARPED_PLANKS, TRELLIS_RENDER_CUTOUT);
    }
}
