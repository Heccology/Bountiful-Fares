package net.hecco.bountifulfares.definition.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WildCropBlock extends BushBlock {
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Block.box(2, 0, 2, 14, 14, 14);
    }

    public WildCropBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return null;
    }
}
