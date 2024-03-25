package net.hecco.bountifulfares.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;

public class FarmersHatItem extends Item implements Equipment {
    public FarmersHatItem(Settings settings) {
        super(settings);
    }
    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }

}
