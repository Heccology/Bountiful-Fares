package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.effect.BFEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;

public class BlackTeaBottleItem extends TeaBottleItem{
    public BlackTeaBottleItem(Settings settings) {
        super(settings);
    }
    public ArrayList<RegistryEntry<StatusEffect>> getStatusEffectsToRemove() {
        ArrayList<RegistryEntry<StatusEffect>> list = new ArrayList<>();
        list.add(StatusEffects.WEAKNESS);
        list.add(StatusEffects.SLOWNESS);
        list.add(BFEffects.ACIDIC);
        return list;
    }
}
