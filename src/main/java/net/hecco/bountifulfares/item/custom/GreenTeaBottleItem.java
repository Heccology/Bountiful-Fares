package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.ArrayList;
import java.util.List;

public class GreenTeaBottleItem extends TeaBottleItem{
    public GreenTeaBottleItem(Properties settings) {
        super(List.of(new MobEffectInstance(BFEffects.STUPOR), new MobEffectInstance(MobEffects.HUNGER), new MobEffectInstance(BFEffects.ACIDIC)), settings);
    }
    public ArrayList<Holder<MobEffect>> getStatusEffectsToRemove() {
        ArrayList<Holder<MobEffect>> list = new ArrayList<>();
        list.add(BFEffects.STUPOR);
        list.add(MobEffects.HUNGER);
        list.add(BFEffects.ACIDIC);
        return list;
    }
}
