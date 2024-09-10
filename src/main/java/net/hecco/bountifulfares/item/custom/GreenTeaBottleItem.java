package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.effect.BFEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;

public class GreenTeaBottleItem extends TeaBottleItem{
    public GreenTeaBottleItem(Settings settings) {
        super(settings);
    }
    public ArrayList<RegistryEntry<StatusEffect>> getStatusEffectsToRemove() {
        ArrayList<RegistryEntry<StatusEffect>> list = new ArrayList<>();
        list.add(BFEffects.STUPOR);
        list.add(StatusEffects.HUNGER);
        list.add(BFEffects.ACIDIC);
        return list;
    }
}
