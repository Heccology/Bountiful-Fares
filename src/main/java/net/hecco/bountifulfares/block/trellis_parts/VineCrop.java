package net.hecco.bountifulfares.block.trellis_parts;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class VineCrop {
    public final String MOD_ID;
    public final String TYPE_ID;
    public final Item CROP_ITEM;
//    public final Block BLOCK_CLASS;
    public VineCrop(String modId, String id, Item item) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = item;
//        this.BLOCK_CLASS = new CropTrellisBlock(CROP_ITEM, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS));
        BountifulFares.VineCropIndex.add(this);
        ModBlocks.CROPS_TO_VINE_CROPS.put(item, this);
    }

    public VineCrop(String modId, String id, Item item, Block block) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.CROP_ITEM = item;
//        this.BLOCK_CLASS = block;
        BountifulFares.VineCropIndex.add(this);
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

    public Item getCropItem() {
        return this.CROP_ITEM;
    }

//    public Block getBlockClass() {
//        return this.BLOCK_CLASS;
//    }

}
