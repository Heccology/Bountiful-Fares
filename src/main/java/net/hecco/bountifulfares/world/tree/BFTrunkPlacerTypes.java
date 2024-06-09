package net.hecco.bountifulfares.world.tree;

import net.hecco.bountifulfares.mixin.TrunkPlacerTypeMixin;
import net.hecco.bountifulfares.world.tree.custom.HoaryTrunkPlacer;
import net.hecco.bountifulfares.world.tree.custom.PalmTrunkPlacer;
import net.hecco.bountifulfares.world.tree.custom.WalnutTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class BFTrunkPlacerTypes {
    public static final TrunkPlacerType<?> HOARY_TRUNK_PLACER = TrunkPlacerTypeMixin.callRegister("hoary_trunk_placer", HoaryTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> WALNUT_TRUNK_PLACER = TrunkPlacerTypeMixin.callRegister("walnut_trunk_placer", WalnutTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> PALM_TRUNK_PLACER = TrunkPlacerTypeMixin.callRegister("palm_trunk_placer", PalmTrunkPlacer.CODEC);
    public static void register() {
//        BountifulFares.LOGGER.info("Registering Trunk Placers for " + BountifulFares.MOD_ID);
    }

}