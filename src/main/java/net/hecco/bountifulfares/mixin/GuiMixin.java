package net.hecco.bountifulfares.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
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
            if (type == InGameHud.HeartType.NORMAL && MinecraftClient.getInstance().cameraEntity instanceof PlayerEntity player
                    && (player.hasStatusEffect(BFEffects.RESTORATION))) {
                RenderSystem.enableBlend();
                Identifier texture;
                Identifier halfBlinkingTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_half_blinking");
                Identifier halfTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_half");
                Identifier fullBlinkingTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_full_blinking");
                Identifier fullTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_full");
                Identifier hardcoreHalfBlinkingTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_half_blinking");
                Identifier hardcoreHalfTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_half");
                Identifier hardcoreFullBlinkingTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_full_blinking");
                Identifier hardcoreFullTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_full");
                if (!hardcore) {
                    if (half) {
                        texture = blinking ? halfBlinkingTexture : halfTexture;
                    } else {
                        texture = blinking ? fullBlinkingTexture : fullTexture;
                    }
                } else if (half) {
                    texture = blinking ? hardcoreHalfBlinkingTexture : hardcoreHalfTexture;
                } else {
                    texture = blinking ? hardcoreFullBlinkingTexture : hardcoreFullTexture;
                }
                context.drawGuiTexture(texture, x, y, 9, 9);
                RenderSystem.disableBlend();
                ci.cancel();
            }
        }
    }
}
