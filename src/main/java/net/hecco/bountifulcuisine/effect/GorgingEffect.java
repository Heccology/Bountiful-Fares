package net.hecco.bountifulcuisine.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.random.Random;

public class GorgingEffect extends StatusEffect {
    protected GorgingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof  PlayerEntity) {
            ((PlayerEntity) entity).getHungerManager().setFoodLevel(20);
        }
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).getHungerManager().setExhaustion(0f);
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof  PlayerEntity) {
            ((PlayerEntity) entity).getHungerManager().setFoodLevel(1 + Random.create().nextBetween(0, 5));
        }
        super.onRemoved(entity, attributes, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
