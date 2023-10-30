package net.hecco.bountifulcuisine.item.custom;

import net.hecco.bountifulcuisine.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

public class TorchflowerTeaBottleItem extends TeaBottleItem{
    public TorchflowerTeaBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public StatusEffect[] getStatusEffectsToRemove() {
        return new StatusEffect[] {StatusEffects.INVISIBILITY, StatusEffects.BLINDNESS, ModEffects.ACIDIC};
    }
}
