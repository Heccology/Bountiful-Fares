package net.hecco.bountifulfares.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class RestorationEffect extends StatusEffect {
    private float regenMax;
    public RestorationEffect(StatusEffectCategory category, int color) {
        super(category, color);
        this.regenMax = 0;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        regenMax = health;
        super.onApplied(entity, amplifier);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        if (health < regenMax && health < maxHealth) {
            entity.heal(0.1f * (amplifier + 1));
        }
        super.applyUpdateEffect(entity, amplifier);
        return true;
    }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        regenMax = 0;
        super.onRemoved(attributeContainer);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
