package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.BFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class OrangeLogBlock extends FruitLogBlock {
    public OrangeLogBlock(Settings settings) {
        super(settings);
    }

    @Override
    public Block getLeavesBlock() {
        return BFBlocks.ORANGE_LEAVES;
    }

    @Override
    public Block getFloweringLeavesBlock() {
        return BFBlocks.FLOWERING_ORANGE_LEAVES;
    }

}