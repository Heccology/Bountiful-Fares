package net.hecco.bountifulfares.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class RestorationEffect extends MobEffect {
    private float regenMax;
    public RestorationEffect(MobEffectCategory category, int color) {
        super(category, color);
        this.regenMax = 0;
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        regenMax = health;
        super.onEffectStarted(entity, amplifier);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        if (health < regenMax && health < maxHealth) {
            entity.heal(0.1f * (amplifier + 1));
        }
        super.applyEffectTick(entity, amplifier);
        return true;
    }

    @Override
    public void removeAttributeModifiers(AttributeMap attributeContainer) {
        regenMax = 0;
        super.removeAttributeModifiers(attributeContainer);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
