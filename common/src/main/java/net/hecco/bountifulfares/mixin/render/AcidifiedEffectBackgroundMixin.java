package net.hecco.bountifulfares.mixin.render;

import com.llamalad7.mixinextras.sugar.Local;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.tags.BFEffectTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Collection;
import java.util.stream.Collectors;

@Mixin(Gui.class)
public abstract class AcidifiedEffectBackgroundMixin {

    // Replaced via mixin into heart enum directly - >> see mixin/GuiHeartsMixin <<
    //@Inject(method = "drawHeart", at = @At("HEAD"), cancellable = true)
    //private void bountifulfares_renderHeart(DrawContext context, InGameHud.HeartType type, int x, int y, boolean hardcore, boolean blinking, boolean half, CallbackInfo ci) {
    //    if (BountifulFares.CONFIG.isRestorationHeartOverlay()) {
    //        if (type == InGameHud.HeartType.NORMAL && MinecraftClient.getInstance().cameraEntity instanceof PlayerEntity player
    //                && (player.hasStatusEffect(BFEffects.RESTORATION))) {
    //            RenderSystem.enableBlend();
    //            Identifier texture;
    //            Identifier halfBlinkingTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_half_blinking");
    //            Identifier halfTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_half");
    //            Identifier fullBlinkingTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_full_blinking");
    //            Identifier fullTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_full");
    //            Identifier hardcoreHalfBlinkingTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_half_blinking");
    //            Identifier hardcoreHalfTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_half");
    //            Identifier hardcoreFullBlinkingTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_full_blinking");
    //            Identifier hardcoreFullTexture = Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_full");
    //            if (!hardcore) {
    //                if (half) {
    //                    texture = blinking ? halfBlinkingTexture : halfTexture;
    //                } else {
    //                    texture = blinking ? fullBlinkingTexture : fullTexture;
    //                }
    //            } else if (half) {
    //                texture = blinking ? hardcoreHalfBlinkingTexture : hardcoreHalfTexture;
    //            } else {
    //                texture = blinking ? hardcoreFullBlinkingTexture : hardcoreFullTexture;
    //            }
    //            context.drawGuiTexture(texture, x, y, 9, 9);
    //            RenderSystem.disableBlend();
    //            ci.cancel();
    //        }
    //    }
    //}

    @Shadow @Final private Minecraft minecraft;
    @Shadow @Final private static ResourceLocation EFFECT_BACKGROUND_AMBIENT_SPRITE;
    @Shadow @Final private static ResourceLocation EFFECT_BACKGROUND_SPRITE;
    @Unique
    private static final ResourceLocation ACIDFIED_EFFECT_BACKGROUND_TEXTURE = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hud/acidified_effect_background");
    @Unique
    private static final ResourceLocation ACIDFIED_EFFECT_BACKGROUND_AMBIENT_TEXTURE = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hud/acidified_effect_background_ambient");

    @ModifyArg(method = "renderEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V"), index = 0)
    private ResourceLocation bountifulfares$renderAcidifiedBackgrounds(ResourceLocation sprite, @Local MobEffectInstance effect) {
        if (Services.PLATFORM.get().getBoolConfigValue("acidifiedEffectIconEffects")) {
            Collection<MobEffectInstance> collection = this.minecraft.player.getActiveEffects();
            if (collection.stream().map(MobEffectInstance::getEffect).collect(Collectors.toSet()).contains(BFEffects.ACIDIC) && effect.getEffect().value() != BFEffects.ACIDIC.value() && !effect.getEffect().is(BFEffectTags.ACIDIC_BLACKLIST)) {
                if (sprite.equals(EFFECT_BACKGROUND_AMBIENT_SPRITE)) {
                    return ACIDFIED_EFFECT_BACKGROUND_AMBIENT_TEXTURE;
                }
                if (sprite.equals(EFFECT_BACKGROUND_SPRITE)) {
                    return ACIDFIED_EFFECT_BACKGROUND_TEXTURE;
                }
            }
        }
        return sprite;
    }
}
