package net.hecco.bountifulcuisine.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.random.Random;

public class GorgingEffect extends StatusEffect {
    protected GorgingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if (entity instanceof  PlayerEntity) {
            ((PlayerEntity) entity).getHungerManager().setFoodLevel(20);
        }
        super.onApplied(entity, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).getHungerManager().setExhaustion(0f);
        }
        for (StatusEffectInstance thisEffect : entity.getStatusEffects()) {
            if (thisEffect.getEffectType() == this) {
                if (thisEffect.getDuration() <= 1) {
                    if (entity instanceof  PlayerEntity) {
                        ((PlayerEntity) entity).getHungerManager().setFoodLevel(1 + Random.create().nextBetween(0, 5));
                    }
                }
            }
        }
    }

    @Override
    public void onRemoved(AttributeContainer attributes) {
        super.onRemoved(attributes);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
