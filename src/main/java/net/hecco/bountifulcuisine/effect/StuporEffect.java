package net.hecco.bountifulcuisine.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.ArrayList;
import java.util.List;

public class StuporEffect extends StatusEffect {
    protected StuporEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof net.minecraft.server.network.ServerPlayerEntity) {
            net.minecraft.server.network.ServerPlayerEntity player = (net.minecraft.server.network.ServerPlayerEntity) entity;

            List<StatusEffectInstance> modifiedEffects = new ArrayList<>();
            List<StatusEffectInstance> effectsToRemove = new ArrayList<>();

            for (StatusEffectInstance effect : player.getStatusEffects()) {
                if (effect.getEffectType() != this) {
                    int newAmplifier = effect.getAmplifier() - amplifier - 1;
                    if (newAmplifier >= 0) {
                        StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
                        modifiedEffects.add(newEffect);
                    } else {
                        effectsToRemove.add(effect);
                    }
                }
            }

            for (StatusEffectInstance effect : modifiedEffects) {
                player.removeStatusEffect(effect.getEffectType());
                player.addStatusEffect(effect);
            }
            for (StatusEffectInstance effect : effectsToRemove) {
                player.removeStatusEffect(effect.getEffectType());
            }
        }
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof net.minecraft.server.network.ServerPlayerEntity) {
            net.minecraft.server.network.ServerPlayerEntity player = (net.minecraft.server.network.ServerPlayerEntity) entity;

            List<StatusEffectInstance> modifiedEffects = new ArrayList<>();

            for (StatusEffectInstance effect : player.getStatusEffects()) {
                if (effect.getEffectType() != this) {
                    int newAmplifier = effect.getAmplifier() + amplifier + 1;
                    if (newAmplifier > 255) {
                        newAmplifier = 255;
                    }
                    StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
                    modifiedEffects.add(newEffect);
                }
            }

            for (StatusEffectInstance effect : modifiedEffects) {
                player.removeStatusEffect(effect.getEffectType());
                player.addStatusEffect(effect);
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
