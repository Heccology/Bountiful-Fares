package net.hecco.bountifulfares.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.ArrayList;
import java.util.List;

public class HoneyCandyItem extends EffectClearingItem {
    public HoneyCandyItem(Properties settings) {
        super(List.of(new MobEffectInstance(MobEffects.POISON)), settings);
    }

    @Override
    public ArrayList<Holder<MobEffect>> getStatusEffectsToRemove() {
        ArrayList<Holder<MobEffect>> list = new ArrayList<>();
        list.add(MobEffects.POISON);
        return list;
    }
}
