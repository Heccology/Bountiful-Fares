package net.hecco.bountifulfares.trellis.trellis_parts;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

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
        BFBlocks.CROPS_TO_VINE_CROPS.put(seeds, this);
    }

    public VineCrop(String modId, String id, Identifier crop) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = Registries.ITEM.get(crop);
        this.SEEDS_ITEM = Registries.ITEM.get(crop);
//        TrellisVariants.VineCrops.add(this);
        BFBlocks.CROPS_TO_VINE_CROPS.put(Registries.ITEM.get(crop), this);
    }

    public VineCrop(String modId, String id, Item crop) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = crop;
        this.SEEDS_ITEM = crop;
//        TrellisVariants.VineCrops.add(this);
        BFBlocks.CROPS_TO_VINE_CROPS.put(crop, this);
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
