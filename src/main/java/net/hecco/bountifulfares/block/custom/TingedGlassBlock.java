package net.hecco.bountifulfares.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TingedGlassBlock extends TransparentBlock {
    public TingedGlassBlock(Properties settings) {
        super(settings);
    }

    public int getLightBlock(BlockState state, BlockGetter world, BlockPos pos) {
        return world.getMaxLightLevel() / 5;
    }
}
