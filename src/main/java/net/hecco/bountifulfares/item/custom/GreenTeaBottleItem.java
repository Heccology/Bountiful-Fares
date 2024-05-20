package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.effect.BFEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

public class GreenTeaBottleItem extends TeaBottleItem{
    public GreenTeaBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public StatusEffect[] getStatusEffectsToRemove() {
        return new StatusEffect[] {BFEffects.STUPOR, StatusEffects.HUNGER, BFEffects.ACIDIC};
    }
}
