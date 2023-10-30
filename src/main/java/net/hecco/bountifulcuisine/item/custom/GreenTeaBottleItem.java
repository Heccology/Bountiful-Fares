package net.hecco.bountifulcuisine.item.custom;

import net.hecco.bountifulcuisine.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;

public class GreenTeaBottleItem extends TeaBottleItem{
    public GreenTeaBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public StatusEffect[] getStatusEffectsToRemove() {
        return new StatusEffect[] {StatusEffects.POISON, StatusEffects.HUNGER, ModEffects.ACIDIC};
    }
}
