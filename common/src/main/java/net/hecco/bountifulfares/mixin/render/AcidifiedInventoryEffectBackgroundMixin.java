package net.hecco.bountifulfares.mixin.render;

import com.llamalad7.mixinextras.sugar.Local;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.tags.BFEffectTags;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mixin(EffectRenderingInventoryScreen.class)
public class AcidifiedInventoryEffectBackgroundMixin {

    @Shadow private static final ResourceLocation EFFECT_BACKGROUND_LARGE_SPRITE = ResourceLocation.withDefaultNamespace("container/inventory/effect_background_large");
    @Shadow private static final ResourceLocation EFFECT_BACKGROUND_SMALL_SPRITE = ResourceLocation.withDefaultNamespace("container/inventory/effect_background_small");
    @Unique
    private static final ResourceLocation ACIDFIED_EFFECT_BACKGROUND_SMALL_TEXTURE = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "container/inventory/acidified_effect_background_small");
    @Unique
    private static final ResourceLocation ACIDFIED_EFFECT_BACKGROUND_LARGE_TEXTURE = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "container/inventory/acidified_effect_background_large");
//    @Inject(method = "renderBackgrounds", at = @At(value = "HEAD"), cancellable = true)
//    private void bountifulfares_acidicBackgroundOverlay(GuiGraphics guiGraphics, int renderX, int yOffset, Iterable<MobEffectInstance> effects, boolean isSmall, CallbackInfo ci) {
//        if (BountifulFares.CONFIG.isAcidifiedEffectIconEffects()) {
//            List<Holder<MobEffect>> effects2 = new ArrayList<>();
//            for (MobEffectInstance instance : effects) {
//                effects2.add(instance.getEffect());
//            }
//            if (effects2.contains(BFEffects.ACIDIC)) {
//                int i = ((HandledScreenMixin) this).getY();
//
//                for (Iterator<MobEffectInstance> var7 = effects.iterator(); var7.hasNext(); i += guiGraphics.guiHeight()) {
//                    ResourceLocation largeTexture = EFFECT_BACKGROUND_LARGE_SPRITE;
//                    ResourceLocation smallTexture = EFFECT_BACKGROUND_SMALL_SPRITE;
//                    MobEffectInstance effect = var7.next();
//                    if (effect.getEffect() != BFEffects.ACIDIC && !effect.getEffect().is(BFEffectTags.ACIDIC_BLACKLIST)) {
//                        largeTexture = ACIDFIED_EFFECT_BACKGROUND_LARGE_TEXTURE;
//                        smallTexture = ACIDFIED_EFFECT_BACKGROUND_SMALL_TEXTURE;
//                    }
//                    if (isSmall) {
//                        guiGraphics.blitSprite(largeTexture, renderX, i, 120, 32);
//                    } else {
//                        guiGraphics.blitSprite(smallTexture, renderX, i, 32, 32);
//                    }
//                }
//                ci.cancel();
//            }
//        }
//    }

    @ModifyArg(method = "renderBackgrounds", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V"), index = 0)
    private ResourceLocation bountifulfares$acidicBackgroundOverlay(ResourceLocation sprite, @Local MobEffectInstance effect, @Local(argsOnly = true) Iterable<MobEffectInstance> effects) {
        if (Services.PLATFORM.getBoolConfigValue("acidifiedEffectIconEffects")) {
            List<Holder<MobEffect>> effects2 = new ArrayList<>();
            for (MobEffectInstance instance : effects) {
                effects2.add(instance.getEffect());
            }
            if (effects2.contains(BFEffects.ACIDIC) && effect.getEffect().value() != BFEffects.ACIDIC.value() && !effect.getEffect().is(BFEffectTags.ACIDIC_BLACKLIST)) {
                if (sprite.equals(EFFECT_BACKGROUND_LARGE_SPRITE)) {
                    return ACIDFIED_EFFECT_BACKGROUND_LARGE_TEXTURE;
                }
                if (sprite.equals(EFFECT_BACKGROUND_SMALL_SPRITE)) {
                    return ACIDFIED_EFFECT_BACKGROUND_SMALL_TEXTURE;
                }
            }
        }
        return sprite;
    }


}
