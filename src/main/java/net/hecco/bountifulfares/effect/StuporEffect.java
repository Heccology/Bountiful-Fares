package net.hecco.bountifulfares.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.ArrayList;
import java.util.List;

public class StuporEffect extends StatusEffect {
    protected StuporEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        List<StatusEffectInstance> effectsToRemove = new ArrayList<>();

        for (StatusEffectInstance effect : entity.getStatusEffects()) {
            // goes through each effect that shouldn't be affected, and adds it to a list to be removed
            if (effect.getEffectType() != this) {
                if (effect.getEffectType() != StatusEffects.HERO_OF_THE_VILLAGE && effect.getEffectType() != StatusEffects.BAD_OMEN) {
                    effectsToRemove.add(effect);
                }
            }
        }
        for (StatusEffectInstance effect : effectsToRemove) {
            // Remove the specified effects
            entity.removeStatusEffect(effect.getEffectType());
        }
        super.applyUpdateEffect(entity, amplifier);
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
