package net.hecco.bountifulfares.mixin.util;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TrunkPlacerType.class)
public interface TrunkPlacerInvoker {
    @Invoker("register")
    static <P extends TrunkPlacer> TrunkPlacerType<P> register(String name, MapCodec<P> codec) {
        throw new IllegalStateException();
    }
}