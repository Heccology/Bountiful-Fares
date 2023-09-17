package net.hecco.bountifulcuisine.item.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.Block;

public class TeaBerriesItem extends AliasedPlantItem {
    public TeaBerriesItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public Block getBlock() {
        return ModBlocks.TEA_SHRUB;
    }
}
