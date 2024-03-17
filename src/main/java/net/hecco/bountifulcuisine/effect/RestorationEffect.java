package net.hecco.bountifulcuisine.effect;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class RestorationEffect extends StatusEffect {
    private float regenMax;
    private float prevRegenMax;
    protected RestorationEffect(StatusEffectCategory category, int color) {
        super(category, color);
        this.regenMax = 0;
        this.prevRegenMax = 0;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        if (health > regenMax && health <= maxHealth && prevRegenMax < health) {
            regenMax = health;
        }
        super.onApplied(entity, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        if (health < regenMax && health < maxHealth) {
            entity.heal(0.1f * (amplifier + 1));
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void onRemoved(AttributeContainer attributes) {
        regenMax = 0;
        prevRegenMax = regenMax;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
