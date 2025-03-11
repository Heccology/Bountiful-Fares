package net.hecco.bountifulfares.registry.misc;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.world.GoldenAppleTrunkPlacer;
import net.hecco.bountifulfares.world.HoaryTrunkPlacer;
import net.hecco.bountifulfares.world.PalmTrunkPlacer;
import net.hecco.bountifulfares.world.WalnutTrunkPlacer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class BFTrunkPlacerTypes {
    public static final TrunkPlacerType<?> HOARY_TRUNK_PLACER = registerTrunkPlacer("hoary_trunk_placer", HoaryTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> WALNUT_TRUNK_PLACER = registerTrunkPlacer("walnut_trunk_placer", WalnutTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> PALM_TRUNK_PLACER = registerTrunkPlacer("palm_trunk_placer", PalmTrunkPlacer.CODEC);
    public static final TrunkPlacerType<?> GOLDEN_APPLE_TRUNK_PLACER = registerTrunkPlacer("golden_apple_trunk_placer", GoldenAppleTrunkPlacer.CODEC);
    private static <P extends TrunkPlacer> TrunkPlacerType registerTrunkPlacer(String id, MapCodec<P> codec) {
        return Registry.register(Registries.TRUNK_PLACER_TYPE,  Identifier.of (BountifulFares.MOD_ID, id), new TrunkPlacerType(codec));
    }
    public static void register() {
    }

}