package net.hecco.bountifulfares.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.hecco.bountifulfares.item.ModItems;
import net.minecraft.item.Items;

public class ModTrellises {
    public static final TrellisVariant SPRUCE = new TrellisVariant(BountifulFares.MOD_ID, "spruce");
    public static final TrellisVariant BIRCH = new TrellisVariant(BountifulFares.MOD_ID, "birch");
    public static final TrellisVariant JUNGLE = new TrellisVariant(BountifulFares.MOD_ID, "jungle");

    public static final VineCrop PASSION_FRUIT = new VineCrop(BountifulFares.MOD_ID, "passion_fruit", ModItems.PASSION_FRUIT);
    public static final VineCrop ELDERBERRY = new VineCrop(BountifulFares.MOD_ID, "elderberry", ModItems.ELDERBERRIES);
    public static final VineCrop LAPISBERRY = new VineCrop(BountifulFares.MOD_ID, "lapisberry", ModItems.LAPISBERRIES);
    public static final VineCrop GLOW_BERRY = new VineCrop(BountifulFares.MOD_ID, "glow_berry", Items.GLOW_BERRIES);

    public static void registerTrellisParts() {}
}
