package net.hecco.bountifulfares.mixin.render;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.mojang.blaze3d.systems.RenderSystem;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.tags.BFEffectTags;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.MobEffectTextureManager;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
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

@Mixin(Gui.class)
public class GuiMixin {

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
    @Inject(method = "renderEffects", at = @At(value = "HEAD"), cancellable = true)
    private void bountifulfares_acidicBackgroundOverlay(GuiGraphics context, DeltaTracker tickCounter, CallbackInfo ci) {
        if (BountifulFares.CONFIG.isAcidifiedEffectIconEffects()) {
            Collection<MobEffectInstance> collection = this.minecraft.player.getActiveEffects();
            if (collection.stream().map(MobEffectInstance::getEffect).collect(Collectors.toSet()).contains(BFEffects.ACIDIC)) {
                Screen screen = this.minecraft.screen;
                if (screen instanceof EffectRenderingInventoryScreen abstractInventoryScreen) {
                    if (abstractInventoryScreen.canSeeEffects()) {
                        return;
                    }
                }

                RenderSystem.enableBlend();
                int i = 0;
                int j = 0;
                MobEffectTextureManager statusEffectSpriteManager = this.minecraft.getMobEffectTextures();
                List<Runnable> list = Lists.newArrayListWithExpectedSize(collection.size());

                for (MobEffectInstance statusEffectInstance : Ordering.natural().reverse().sortedCopy(collection)) {
                    Holder<MobEffect> registryEntry = statusEffectInstance.getEffect();
                    if (statusEffectInstance.showIcon()) {
                        int k = context.guiWidth();
                        int l = 1;
                        if (this.minecraft.isDemo()) {
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
                        ResourceLocation ambientTexture = EFFECT_BACKGROUND_AMBIENT_SPRITE;
                        ResourceLocation texture = EFFECT_BACKGROUND_SPRITE;
                        if (statusEffectInstance.getEffect() != BFEffects.ACIDIC && !statusEffectInstance.getEffect().is(BFEffectTags.ACIDIC_BLACKLIST)) {
                            ambientTexture = ACIDFIED_EFFECT_BACKGROUND_AMBIENT_TEXTURE;
                            texture = ACIDFIED_EFFECT_BACKGROUND_TEXTURE;
                        }
                        if (statusEffectInstance.isAmbient()) {
                            f = 1.0F;
                            context.blitSprite(ambientTexture, k, l, 24, 24);
                        } else {
                            context.blitSprite(texture, k, l, 24, 24);
                            if (statusEffectInstance.endsWithin(200)) {
                                int m = statusEffectInstance.getDuration();
                                int n = 10 - m / 20;
                                f = Mth.clamp((float) m / 10.0F / 5.0F * 0.5F, 0.0F, 0.5F) + Mth.cos((float) m * (float) Math.PI / 5.0F) * Mth.clamp((float) n / 10.0F * 0.25F, 0.0F, 0.25F);
                            } else {
                                f = 1.0F;
                            }
                        }

                        TextureAtlasSprite sprite = statusEffectSpriteManager.get(registryEntry);
                        int finalK = k;
                        int finalL = l;
                        list.add(() -> {
                            context.setColor(1.0F, 1.0F, 1.0F, f);
                            context.blit(finalK + 3, finalL + 3, 0, 18, 18, sprite);
                            context.setColor(1.0F, 1.0F, 1.0F, 1.0F);
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
