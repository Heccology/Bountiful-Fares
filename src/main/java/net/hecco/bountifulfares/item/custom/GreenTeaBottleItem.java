package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;
import java.util.List;

public class GreenTeaBottleItem extends TeaBottleItem{
    public GreenTeaBottleItem(Settings settings) {
        super(List.of(new StatusEffectInstance(BFEffects.STUPOR), new StatusEffectInstance(StatusEffects.HUNGER), new StatusEffectInstance(BFEffects.ACIDIC)), settings);
    }
    public ArrayList<RegistryEntry<StatusEffect>> getStatusEffectsToRemove() {
        ArrayList<RegistryEntry<StatusEffect>> list = new ArrayList<>();
        list.add(BFEffects.STUPOR);
        list.add(StatusEffects.HUNGER);
        list.add(BFEffects.ACIDIC);
        return list;
    }
}
