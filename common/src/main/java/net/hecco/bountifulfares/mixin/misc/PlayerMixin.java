package net.hecco.bountifulfares.mixin.misc;

import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(method = "causeFoodExhaustion", at = @At("HEAD"), cancellable = true)
    private void bountifulfares$ebullienceNegation(float exhaustion, CallbackInfo ci) {
        if (((Player)(Object)this).hasEffect(BFEffects.EBULLIENCE)) {
            ci.cancel();
        }
    }
}
