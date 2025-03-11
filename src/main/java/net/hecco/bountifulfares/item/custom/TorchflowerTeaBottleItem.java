package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;
import java.util.List;

public class TorchflowerTeaBottleItem extends TeaBottleItem{
    public TorchflowerTeaBottleItem(Settings settings) {
        super(List.of(new StatusEffectInstance(StatusEffects.DARKNESS), new StatusEffectInstance(StatusEffects.BLINDNESS), new StatusEffectInstance(BFEffects.ACIDIC)), settings);
    }
    public ArrayList<RegistryEntry<StatusEffect>> getStatusEffectsToRemove() {
        ArrayList<RegistryEntry<StatusEffect>> list = new ArrayList<>();
        list.add(StatusEffects.DARKNESS);
        list.add(StatusEffects.BLINDNESS);
        list.add(BFEffects.ACIDIC);
        return list;
    }
}
