package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;
import java.util.List;

public class ChamomileTeaBottleItem extends TeaBottleItem{
    public ChamomileTeaBottleItem(Settings settings) {
        super(List.of(new StatusEffectInstance(StatusEffects.NAUSEA), new StatusEffectInstance(StatusEffects.POISON), new StatusEffectInstance(BFEffects.ACIDIC)), settings);
    }
    public ArrayList<RegistryEntry<StatusEffect>> getStatusEffectsToRemove() {
        ArrayList<RegistryEntry<StatusEffect>> list = new ArrayList<>();
        list.add(StatusEffects.NAUSEA);
        list.add(StatusEffects.POISON);
        list.add(BFEffects.ACIDIC);
        return list;
    }
}
