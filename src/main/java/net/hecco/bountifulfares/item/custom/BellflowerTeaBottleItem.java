package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

public class BellflowerTeaBottleItem extends TeaBottleItem{
    public BellflowerTeaBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public StatusEffect[] getStatusEffectsToRemove() {
        return new StatusEffect[] {StatusEffects.LEVITATION, StatusEffects.SLOWNESS, ModEffects.ACIDIC};
    }
}
