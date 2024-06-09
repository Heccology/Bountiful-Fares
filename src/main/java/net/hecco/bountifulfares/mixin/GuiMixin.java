package net.hecco.bountifulfares.mixin;

import dev.architectury.event.events.common.TickEvent;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.effect.BFEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class GuiMixin {
    @Inject(method = "drawHeart", at = @At("HEAD"), cancellable = true)
    private void bountifulfares_renderHeart(DrawContext context, InGameHud.HeartType type, int x, int y, boolean hardcore, boolean blinking, boolean half, CallbackInfo ci) {
        if (BountifulFares.CONFIG.isRestorationHeartOverlay()) {
            if (!blinking && type == InGameHud.HeartType.NORMAL && MinecraftClient.getInstance().cameraEntity instanceof PlayerEntity player
                    && (player.hasStatusEffect(BFEffects.RESTORATION))) {
                context.drawGuiTexture(getTexture(hardcore, half), x, y, 9, 9);
                ci.cancel();
            }
        }
    }

    @Unique
    public Identifier getTexture(boolean hardcore, boolean half) {
        if (!hardcore) {
            if (half) {
                return new Identifier(BountifulFares.MOD_ID, "hud/heart/restoring_half");
            } else {
                return new Identifier(BountifulFares.MOD_ID, "hud/heart/restoring_full");
            }
        } else if (half) {
            return new Identifier(BountifulFares.MOD_ID, "hud/heart/restoring_hardcore_half");
        } else {
            return new Identifier(BountifulFares.MOD_ID, "hud/heart/restoring_hardcore_full");
        }
    }
}
