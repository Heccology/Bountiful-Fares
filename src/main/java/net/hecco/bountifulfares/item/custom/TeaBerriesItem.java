package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;

public class TeaBerriesItem extends AliasedBlockItem {
    public TeaBerriesItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public Block getBlock() {
        return BFBlocks.TEA_SHRUB;
    }
}
