package net.hecco.bountifulcuisine.item.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;

public class TeaBerriesItem extends AliasedBlockItem {
    public TeaBerriesItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public Block getBlock() {
        return ModBlocks.TEA_SHRUB;
    }
}
