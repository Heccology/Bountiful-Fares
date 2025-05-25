package net.hecco.bountifulfares.mixin.render;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Blocks;
import net.minecraft.client.particle.BlockDustParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BlockDustParticle.class)
public abstract class BlockDustParticleMixin {
    @ModifyArg(method = "<init>(Lnet/minecraft/client/world/ClientWorld;DDDDDDLnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/color/block/BlockColors;getColor(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/util/math/BlockPos;I)I"), index = 2)
    public @Nullable BlockPos bountifulfares$init(@Nullable BlockPos pos, @Local(argsOnly = true) ClientWorld world) {
        if (pos != null && world.getBlockState(pos).isOf(Blocks.AIR)) return pos.down();
        return pos;
    }
}
