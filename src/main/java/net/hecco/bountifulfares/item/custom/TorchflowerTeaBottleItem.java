package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.effect.BFEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

public class TorchflowerTeaBottleItem extends TeaBottleItem{
    public TorchflowerTeaBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public StatusEffect[] getStatusEffectsToRemove() {
        return new StatusEffect[] {StatusEffects.DARKNESS, StatusEffects.BLINDNESS, BFEffects.ACIDIC};
    }
}
