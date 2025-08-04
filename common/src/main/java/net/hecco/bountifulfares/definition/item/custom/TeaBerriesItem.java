package net.hecco.bountifulfares.definition.item.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;

public class TeaBerriesItem extends ItemNameBlockItem {
    public TeaBerriesItem(Block block, Properties settings) {
        super(block, settings);
    }

    @Override
    public Block getBlock() {
        return BFBlocks.TEA_SHRUB.get();
    }
}
