package net.hecco.bountifulfares.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.hecco.bountifulfares.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

public class ModTrellises {
    public static final TrellisVariant OAK = new TrellisVariant(BountifulFares.MOD_ID, "oak", Items.OAK_PLANKS);
    public static final TrellisVariant SPRUCE = new TrellisVariant(BountifulFares.MOD_ID, "spruce", Items.SPRUCE_PLANKS);
    public static final TrellisVariant BIRCH = new TrellisVariant(BountifulFares.MOD_ID, "birch", Items.BIRCH_PLANKS);
    public static final TrellisVariant JUNGLE = new TrellisVariant(BountifulFares.MOD_ID, "jungle", Items.JUNGLE_PLANKS);
    public static final TrellisVariant ACACIA = new TrellisVariant(BountifulFares.MOD_ID, "acacia", Items.ACACIA_PLANKS);
    public static final TrellisVariant DARK_OAK = new TrellisVariant(BountifulFares.MOD_ID, "dark_oak", Items.DARK_OAK_PLANKS);
    public static final TrellisVariant MANGROVE = new TrellisVariant(BountifulFares.MOD_ID, "mangrove", Items.MANGROVE_PLANKS);
    public static final TrellisVariant CHERRY = new TrellisVariant(BountifulFares.MOD_ID, "cherry", Items.CHERRY_PLANKS);
    public static final TrellisVariant BAMBOO = new TrellisVariant(BountifulFares.MOD_ID, "bamboo", Items.BAMBOO_PLANKS);

    public static final TrellisVariant WALNUT = new TrellisVariant(BountifulFares.MOD_ID, "walnut", ModBlocks.WALNUT_PLANKS.asItem());
    public static final TrellisVariant HOARY = new TrellisVariant(BountifulFares.MOD_ID, "hoary", ModBlocks.HOARY_PLANKS.asItem());
    public static final TrellisVariant CRIMSON = new TrellisVariant(BountifulFares.MOD_ID, "crimson", Items.CRIMSON_PLANKS);
    public static final TrellisVariant WARPED = new TrellisVariant(BountifulFares.MOD_ID, "warped", Items.WARPED_PLANKS);

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

    public static void registerTrellisParts() {}
}
