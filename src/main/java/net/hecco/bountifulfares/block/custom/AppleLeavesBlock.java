package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class AppleLeavesBlock extends LeavesBlock implements Fertilizable {

    public AppleLeavesBlock(Block fruit, Settings settings) {
        super(settings);
    }
    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.down()).isAir();
    }
    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }
    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos.down(), ModBlocks.HANGING_APPLE.getDefaultState(), 2);
    }
}
