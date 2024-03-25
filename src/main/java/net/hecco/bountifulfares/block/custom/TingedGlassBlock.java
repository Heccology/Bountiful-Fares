package net.hecco.bountifulfares.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class TingedGlassBlock extends GlassBlock {
    public TingedGlassBlock(Settings settings) {
        super(settings);
    }

    public int getOpacity(BlockState state, BlockView world, BlockPos pos) {
        return world.getMaxLightLevel() / 5;
    }
}
