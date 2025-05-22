package net.hecco.bountifulfares.item.custom;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;
import java.util.List;

public class HoneyCandyItem extends EffectClearingItem {
    public HoneyCandyItem(Settings settings) {
        super(List.of(new StatusEffectInstance(StatusEffects.POISON)), settings);
    }

    @Override
    public ArrayList<RegistryEntry<StatusEffect>> getStatusEffectsToRemove() {
        ArrayList<RegistryEntry<StatusEffect>> list = new ArrayList<>();
        list.add(StatusEffects.POISON);
        return list;
    }
}
