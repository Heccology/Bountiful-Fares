package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;
import java.util.List;

public class BlackTeaBottleItem extends TeaBottleItem{
    public BlackTeaBottleItem(Settings settings) {
        super(List.of(new StatusEffectInstance(StatusEffects.WEAKNESS), new StatusEffectInstance(StatusEffects.SLOWNESS), new StatusEffectInstance(BFEffects.ACIDIC)), settings);
    }
    public ArrayList<RegistryEntry<StatusEffect>> getStatusEffectsToRemove() {
        ArrayList<RegistryEntry<StatusEffect>> list = new ArrayList<>();
        list.add(StatusEffects.WEAKNESS);
        list.add(StatusEffects.SLOWNESS);
        list.add(BFEffects.ACIDIC);
        return list;
    }
}
