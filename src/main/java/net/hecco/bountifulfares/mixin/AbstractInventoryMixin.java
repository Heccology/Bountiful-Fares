package net.hecco.bountifulfares.mixin;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.mixin.util.HandledScreenMixin;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.tags.BFEffectTags;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mixin(AbstractInventoryScreen.class)
public class AbstractInventoryMixin {

    @Shadow @Final private static Identifier EFFECT_BACKGROUND_LARGE_TEXTURE = Identifier.ofVanilla("container/inventory/effect_background_large");
    @Shadow @Final private static Identifier EFFECT_BACKGROUND_SMALL_TEXTURE = Identifier.ofVanilla("container/inventory/effect_background_small");
    @Unique
    private static final Identifier ACIDFIED_EFFECT_BACKGROUND_SMALL_TEXTURE = Identifier.of(BountifulFares.MOD_ID, "container/inventory/acidified_effect_background_small");
    @Unique
    private static final Identifier ACIDFIED_EFFECT_BACKGROUND_LARGE_TEXTURE = Identifier.of(BountifulFares.MOD_ID, "container/inventory/acidified_effect_background_large");
    @Inject(method = "drawStatusEffectBackgrounds", at = @At(value = "HEAD"), cancellable = true)
    private void bountifulfares_acidicBackgroundOverlay(DrawContext context, int x, int height, Iterable<StatusEffectInstance> statusEffects, boolean wide, CallbackInfo ci) {
        if (BountifulFares.CONFIG.isAcidifiedEffectIconEffects()) {
            List<RegistryEntry<StatusEffect>> effects = new ArrayList<>();
            for (StatusEffectInstance instance : statusEffects) {
                effects.add(instance.getEffectType());
            }
            if (effects.contains(BFEffects.ACIDIC)) {
                int i = ((HandledScreenMixin) this).getY();

                for (Iterator<StatusEffectInstance> var7 = statusEffects.iterator(); var7.hasNext(); i += height) {
                    Identifier largeTexture = EFFECT_BACKGROUND_LARGE_TEXTURE;
                    Identifier smallTexture = EFFECT_BACKGROUND_SMALL_TEXTURE;
                    StatusEffectInstance effect = var7.next();
                    if (effect.getEffectType() != BFEffects.ACIDIC && !effect.getEffectType().isIn(BFEffectTags.ACIDIC_BLACKLIST)) {
                        largeTexture = ACIDFIED_EFFECT_BACKGROUND_LARGE_TEXTURE;
                        smallTexture = ACIDFIED_EFFECT_BACKGROUND_SMALL_TEXTURE;
                    }
                    if (wide) {
                        context.drawGuiTexture(largeTexture, x, i, 120, 32);
                    } else {
                        context.drawGuiTexture(smallTexture, x, i, 32, 32);
                    }
                }
                ci.cancel();
            }
        }
    }


}
