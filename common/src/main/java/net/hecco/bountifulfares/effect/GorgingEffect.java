package net.hecco.bountifulfares.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class GorgingEffect extends MobEffect {
    protected GorgingEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
        if (entity instanceof  Player) {
            ((Player) entity).getFoodData().setFoodLevel(20);
        }
        super.onEffectStarted(entity, amplifier);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        super.applyEffectTick(entity, amplifier);
        if (entity instanceof Player) {
            ((Player) entity).getFoodData().setExhaustion(0f);
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
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
