package net.hecco.bountifulfares.mixin.gameplay;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerEntityMixin {
    @Shadow
    private BlockPos respawnPosition;
    @Shadow
    private ResourceKey<Level> respawnDimension;
    @Shadow
    private float respawnAngle;
    @Shadow
    private boolean respawnForced;

    @Inject(method = "setRespawnPosition", at = @At("HEAD"), cancellable = true)
    private void bountifulfares$preventCustomBedSpawnPoint(ResourceKey<Level> dimension, @Nullable BlockPos pos, float angle, boolean forced, boolean sendMessage, CallbackInfo ci) {
        if (pos != null) {
            if (((ServerPlayer) (Object) this).level().getBlockState(pos).is(BFBlocks.COIR_BED.get())) {
                this.respawnPosition = null;
                this.respawnDimension = Level.OVERWORLD;
                this.respawnAngle = 0.0F;
                this.respawnForced = false;
                ci.cancel();
            }
        }
    }
}