package net.hecco.bountifulcuisine.world.tree;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.mixin.TrunkPlacerTypeInvoker;
import net.hecco.bountifulcuisine.world.tree.custom.HoaryTrunkPlacer;
import net.hecco.bountifulcuisine.world.tree.custom.WalnutTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> HOARY_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("hoary_trunk_placer", HoaryTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> WALNUT_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("walnut_trunk_placer", WalnutTrunkPlacer.CODEC);
    public static void register() {
        BountifulCuisine.LOGGER.info("Registering Trunk Placers for " + BountifulCuisine.MOD_ID);
    }

}