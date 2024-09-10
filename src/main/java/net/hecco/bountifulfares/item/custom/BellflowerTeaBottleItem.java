package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.effect.BFEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;

public class BellflowerTeaBottleItem extends TeaBottleItem{
    public BellflowerTeaBottleItem(Settings settings) {
        super(settings);
    }
    public ArrayList<RegistryEntry<StatusEffect>> getStatusEffectsToRemove() {
        ArrayList<RegistryEntry<StatusEffect>> list = new ArrayList<>();
        list.add(StatusEffects.LEVITATION);
        list.add(StatusEffects.SLOWNESS);
        list.add(BFEffects.ACIDIC);
        return list;
    }
}
