package net.hecco.bountifulcuisine.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.ArrayList;
import java.util.List;

public class AcidicEffect extends StatusEffect {
    protected AcidicEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        List<StatusEffectInstance> effectsToModify = new ArrayList<>();
            for (StatusEffectInstance effect : entity.getStatusEffects()) {
                if (effect.getEffectType() != this) {
                    // goes through each effect on the entity that isnt Acidic and increases the amplifier
                    int newAmplifier = effect.getAmplifier() + amplifier + 1;
                    if (newAmplifier > 255) {
                        newAmplifier = 255;
                    }
                    StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
                    effectsToModify.add(newEffect);
                }
            }

            for (StatusEffectInstance effect : effectsToModify) {
                //applies the new effects
                entity.removeStatusEffect(effect.getEffectType());
                entity.addStatusEffect(effect);
            }
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        List<StatusEffectInstance> effectsToModify = new ArrayList<>();

        for (StatusEffectInstance effect : entity.getStatusEffects()) {
            if (effect.getEffectType() != this) {
                // goes through each effect on the entity that isnt Acidic and reverts the amplifier
                int newAmplifier = effect.getAmplifier() - amplifier - 1;
                if (newAmplifier < 0) {
                    newAmplifier = 0;
                }
                StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
                effectsToModify.add(newEffect);
            }
        }
        for (StatusEffectInstance effect : effectsToModify) {
            //applies the new effects
            entity.removeStatusEffect(effect.getEffectType());
            entity.addStatusEffect(effect);
        }
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
