package net.hecco.bountifulcuisine.effect;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class RestorationEffect extends StatusEffect {
    private float highestHealth;
    protected RestorationEffect(StatusEffectCategory category, int color) {
        super(category, color);
        this.highestHealth = 0;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        if (health > highestHealth && health <= maxHealth) {
            highestHealth = health;
        } else if (health < highestHealth && health < maxHealth) {
            BountifulCuisine.LOGGER.info(String.valueOf(highestHealth));
            entity.heal(0.5f);
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        highestHealth = 0;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
