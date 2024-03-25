package net.hecco.bountifulfares.world.tree;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.mixin.TrunkPlacerTypeMixin;
import net.hecco.bountifulfares.world.tree.custom.HoaryTrunkPlacer;
import net.hecco.bountifulfares.world.tree.custom.WalnutTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> HOARY_TRUNK_PLACER = TrunkPlacerTypeMixin.callRegister("hoary_trunk_placer", HoaryTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> WALNUT_TRUNK_PLACER = TrunkPlacerTypeMixin.callRegister("walnut_trunk_placer", WalnutTrunkPlacer.CODEC);
    public static void register() {
        BountifulFares.LOGGER.info("Registering Trunk Placers for " + BountifulFares.MOD_ID);
    }

}