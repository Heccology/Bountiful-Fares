package net.hecco.bountifulfares.mixin;

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
    @Unique
    private static final Identifier RESTORATION = Identifier.of(BountifulFares.MOD_ID, "textures/gui/restoration_hearts.png");
    @Inject(method = "drawHeart", at = @At("HEAD"), cancellable = true)
    private void bountifulfares_renderHeart(DrawContext context, InGameHud.HeartType type, int x, int y, int v, boolean blinking, boolean halfHeart, CallbackInfo ci) {
        if (BountifulFares.CONFIG.isRestorationHeartOverlay()) {
            if (!blinking && type == InGameHud.HeartType.NORMAL && MinecraftClient.getInstance().cameraEntity instanceof PlayerEntity player
                    && (player.hasStatusEffect(BFEffects.RESTORATION))) {
                context.drawTexture(RESTORATION, x, y, halfHeart ? 9 : 0, v, 9, 9);
                ci.cancel();
            }
        }
    }
}
