package net.hecco.bountifulfares.block.trellis_parts;

import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.block.TrellisVariants;
import net.minecraft.item.Item;

public class DecorativeVine {
    public final String MOD_ID;
    public final String TYPE_ID;
    public final Item CROP_ITEM;
    public final boolean CAN_DUPLICATE;

    public DecorativeVine(boolean canDuplicate, String modId, String id, Item crop) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = crop;
        this.CAN_DUPLICATE = canDuplicate;
        TrellisVariants.DecorativeVines.add(this);
        ModBlocks.PLANTS_TO_DECORATIVE_VINES.put(crop, this);
    }

    public String getName() {
        return this.TYPE_ID;
    }

    public String getNameWithId() {
        return this.MOD_ID + "_" + this.TYPE_ID;
    }

    public String getId() {
        return this.MOD_ID;
    }

    public Item getPlantItem() {
        return this.CROP_ITEM;
    }

    public boolean canDuplicate() {
        return CAN_DUPLICATE;
    }

}
