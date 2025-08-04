package net.hecco.bountifulfares.definition.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FeldsparLanternBlock extends LanternBlock {
    public FeldsparLanternBlock(Properties settings) {
        super(settings);
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.or(Block.box(5, 1, 5, 11, 9, 11), Block.box(4, 0, 4, 12, 1, 12), Block.box(4, 9, 4, 12, 10, 12), Block.box(6, 10, 6, 10, 13, 10));
    }
}
