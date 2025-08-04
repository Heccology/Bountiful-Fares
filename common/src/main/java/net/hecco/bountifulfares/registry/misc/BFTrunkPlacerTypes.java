package net.hecco.bountifulfares.registry.misc;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.mixin.util.TrunkPlacerInvoker;
import net.hecco.bountifulfares.definition.world.GoldenAppleTrunkPlacer;
import net.hecco.bountifulfares.definition.world.HoaryTrunkPlacer;
import net.hecco.bountifulfares.definition.world.PalmTrunkPlacer;
import net.hecco.bountifulfares.definition.world.WalnutTrunkPlacer;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.function.Supplier;

public class BFTrunkPlacerTypes {
    public static final Supplier<TrunkPlacerType<?>> HOARY_TRUNK_PLACER = registerTrunkPlacer("hoary_trunk_placer", HoaryTrunkPlacer.CODEC);
    public static final Supplier<TrunkPlacerType<?>> WALNUT_TRUNK_PLACER = registerTrunkPlacer("walnut_trunk_placer", WalnutTrunkPlacer.CODEC);
    public static final Supplier<TrunkPlacerType<?>> PALM_TRUNK_PLACER = registerTrunkPlacer("palm_trunk_placer", PalmTrunkPlacer.CODEC);
    public static final Supplier<TrunkPlacerType<?>> GOLDEN_APPLE_TRUNK_PLACER = registerTrunkPlacer("golden_apple_trunk_placer", GoldenAppleTrunkPlacer.CODEC);

    private static <P extends TrunkPlacer> Supplier<TrunkPlacerType<?>> registerTrunkPlacer(String id, MapCodec<P> codec) {
        return HLServices.REGISTRY.register(BountifulFares.MOD_ID, id, BuiltInRegistries.TRUNK_PLACER_TYPE.key(), () -> TrunkPlacerInvoker.register(codec));
    }
    public static void register() {
    }

}