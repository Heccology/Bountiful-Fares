package net.hecco.bountifulcuisine.item.custom;

import net.hecco.bountifulcuisine.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

public class BellflowerTeaBottleItem extends TeaBottleItem{
    public BellflowerTeaBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public StatusEffect[] getStatusEffectsToRemove() {
        return new StatusEffect[] {StatusEffects.LEVITATION, StatusEffects.MINING_FATIGUE, ModEffects.ACIDIC};
    }
}
