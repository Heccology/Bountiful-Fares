package net.hecco.bountifulfares.block.trellis_parts;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.block.TrellisVariants;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class VineCrop {
    public final String MOD_ID;
    public final String TYPE_ID;
    public final Item CROP_ITEM;
    public final Item SEEDS_ITEM;
    public VineCrop(String modId, String id, Item crop, Item seeds) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = crop;
        this.SEEDS_ITEM = seeds;
//        TrellisVariants.VineCrops.add(this);
        ModBlocks.CROPS_TO_VINE_CROPS.put(seeds, this);
    }

    public VineCrop(String modId, String id, Item crop) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = crop;
        this.SEEDS_ITEM = crop;
//        TrellisVariants.VineCrops.add(this);
        ModBlocks.CROPS_TO_VINE_CROPS.put(crop, this);
    }

    public String getName() {
        return this.TYPE_ID;
    }

    public String getId() {
        return this.MOD_ID;
    }

    public Item getCropItem() {
        return this.CROP_ITEM;
    }

    public Item getSeedsItem() {
        return this.SEEDS_ITEM;
    }

//    public Block getBlockClass() {
//        return this.BLOCK_CLASS;
//    }

    @Override
    public String toString() {
        return "[" + TYPE_ID + "]";
    }
}
