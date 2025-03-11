package net.hecco.bountifulfares.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

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
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).getHungerManager().setExhaustion(0f);
        }
        return true;
    }

//    @Override
//    public void onRemoved(AttributeContainer attributeContainer) {
//        if (entity instanceof  PlayerEntity) {
//            ((PlayerEntity) entity).getHungerManager().setFoodLevel(1 + Random.create().nextBetween(0, 5));
//        }
//        super.onRemoved(attributeContainer);
//    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
