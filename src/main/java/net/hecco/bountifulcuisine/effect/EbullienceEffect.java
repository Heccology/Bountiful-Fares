package net.hecco.bountifulcuisine.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class EbullienceEffect extends StatusEffect {
    protected EbullienceEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).getHungerManager().setExhaustion(0f);
//            int prevHunger = ((PlayerEntity) entity).getHungerManager().getPrevFoodLevel();
//            int hunger = ((PlayerEntity) entity).getHungerManager().getFoodLevel();
//            BountifulCuisine.LOGGER.info("prevhunger: " + prevHunger);
//            BountifulCuisine.LOGGER.info("hunger: " + hunger);
//            if (prevHunger < hunger) {
//                ((PlayerEntity) entity).getHungerManager().setFoodLevel(prevHunger);
//                BountifulCuisine.LOGGER.info("new hunger: " + hunger + 1);
//            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
