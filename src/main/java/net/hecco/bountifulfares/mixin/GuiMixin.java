package net.hecco.bountifulfares.mixin;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.mojang.blaze3d.systems.RenderSystem;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.tags.BFEffectTags;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.StatusEffectSpriteManager;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mixin(InGameHud.class)
public class GuiMixin {
    @Shadow @Final private MinecraftClient client;

    @Shadow @Final private static Identifier EFFECT_BACKGROUND_AMBIENT_TEXTURE;

    @Shadow @Final private static Identifier EFFECT_BACKGROUND_TEXTURE;

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

    @Unique
    private static final Identifier ACIDFIED_EFFECT_BACKGROUND_TEXTURE = Identifier.of(BountifulFares.MOD_ID, "hud/acidified_effect_background");
    @Unique
    private static final Identifier ACIDFIED_EFFECT_BACKGROUND_AMBIENT_TEXTURE = Identifier.of(BountifulFares.MOD_ID, "hud/acidified_effect_background_ambient");

//    @Inject(method = "renderStatusEffectOverlay",
//            at = @At(value = "INVOKE",
//                    target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Lnet/minecraft/util/Identifier;IIII)V"),
//            cancellable = true)
//    private void modifyEffectBackground(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
//    }
//    @Redirect(method = "renderStatusEffectOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Lnet/minecraft/util/Identifier;IIII)V"))
//    private void bountifulfares_acidicBackgroundOverlay(DrawContext instance, Identifier texture, int x, int y, int width, int height) {
//
//        if (texture.getPath() == "hud/effect_background_ambient") {
//            instance.drawGuiTexture(ACIDFIED_EFFECT_BACKGROUND_AMBIENT_TEXTURE, x, y, width, height);
//        } else {
//            instance.drawGuiTexture(ACIDFIED_EFFECT_BACKGROUND_TEXTURE, x, y, width, height);
//        }
//    }
    @Inject(method = "renderStatusEffectOverlay", at = @At(value = "HEAD"), cancellable = true)
    private void bountifulfares_acidicBackgroundOverlay(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        if (BountifulFares.CONFIG.isAcidifiedEffectIconEffects()) {
            Collection<StatusEffectInstance> collection = this.client.player.getStatusEffects();
            if (collection.stream().map(StatusEffectInstance::getEffectType).collect(Collectors.toSet()).contains(BFEffects.ACIDIC)) {
                Screen screen = this.client.currentScreen;
                if (screen instanceof AbstractInventoryScreen abstractInventoryScreen) {
                    if (abstractInventoryScreen.hideStatusEffectHud()) {
                        return;
                    }
                }

                RenderSystem.enableBlend();
                int i = 0;
                int j = 0;
                StatusEffectSpriteManager statusEffectSpriteManager = this.client.getStatusEffectSpriteManager();
                List<Runnable> list = Lists.newArrayListWithExpectedSize(collection.size());

                for (StatusEffectInstance statusEffectInstance : Ordering.natural().reverse().sortedCopy(collection)) {
                    RegistryEntry<StatusEffect> registryEntry = statusEffectInstance.getEffectType();
                    if (statusEffectInstance.shouldShowIcon()) {
                        int k = context.getScaledWindowWidth();
                        int l = 1;
                        if (this.client.isDemo()) {
                            l += 15;
                        }

                        if (registryEntry.value().isBeneficial()) {
                            ++i;
                            k -= 25 * i;
                        } else {
                            ++j;
                            k -= 25 * j;
                            l += 26;
                        }

                        float f;
                        Identifier ambientTexture = EFFECT_BACKGROUND_AMBIENT_TEXTURE;
                        Identifier texture = EFFECT_BACKGROUND_TEXTURE;
                        if (statusEffectInstance.getEffectType() != BFEffects.ACIDIC && !statusEffectInstance.getEffectType().isIn(BFEffectTags.ACIDIC_BLACKLIST)) {
                            ambientTexture = ACIDFIED_EFFECT_BACKGROUND_AMBIENT_TEXTURE;
                            texture = ACIDFIED_EFFECT_BACKGROUND_TEXTURE;
                        }
                        if (statusEffectInstance.isAmbient()) {
                            f = 1.0F;
                            context.drawGuiTexture(ambientTexture, k, l, 24, 24);
                        } else {
                            context.drawGuiTexture(texture, k, l, 24, 24);
                            if (statusEffectInstance.isDurationBelow(200)) {
                                int m = statusEffectInstance.getDuration();
                                int n = 10 - m / 20;
                                f = MathHelper.clamp((float) m / 10.0F / 5.0F * 0.5F, 0.0F, 0.5F) + MathHelper.cos((float) m * (float) Math.PI / 5.0F) * MathHelper.clamp((float) n / 10.0F * 0.25F, 0.0F, 0.25F);
                            } else {
                                f = 1.0F;
                            }
                        }

                        Sprite sprite = statusEffectSpriteManager.getSprite(registryEntry);
                        int finalK = k;
                        int finalL = l;
                        list.add(() -> {
                            context.setShaderColor(1.0F, 1.0F, 1.0F, f);
                            context.drawSprite(finalK + 3, finalL + 3, 0, 18, 18, sprite);
                            context.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                        });
                    }
                }

                list.forEach(Runnable::run);
                RenderSystem.disableBlend();

                ci.cancel();
            }
        }
    }
}
