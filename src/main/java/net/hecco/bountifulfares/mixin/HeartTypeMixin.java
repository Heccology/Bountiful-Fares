package net.hecco.bountifulfares.mixin;

import dev.architectury.event.events.common.TickEvent;
import net.hecco.bountifulfares.effect.BFEffects;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InGameHud.HeartType.class)
public abstract class HeartTypeMixin {

    @Inject(method = "fromPlayerState", at = @At("HEAD"), cancellable = true)
    private static void tipsylib_forPlayer(PlayerEntity player, CallbackInfoReturnable<InGameHud.HeartType> cir) {
        if (player.hasStatusEffect(BFEffects.RESTORATION)) {
            cir.setReturnValue(InGameHud.HeartType.CONTAINER);
        }
    }
}
