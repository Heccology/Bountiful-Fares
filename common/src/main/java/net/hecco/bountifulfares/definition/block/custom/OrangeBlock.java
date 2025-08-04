package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OrangeBlock extends FruitBlock {
    private static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            Shapes.join(Block.box(8, 0, 0, 16, 16, 16), Block.box(0, 0, 8, 8, 16, 16), BooleanOp.OR),
            Block.box(0, 0, 8, 16, 16, 16),
            Block.box(0, 0, 8, 8, 16, 16)
    };
    private static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            Shapes.join(Block.box(0, 0, 8, 16, 16, 16), Block.box(0, 0, 0, 8, 16, 8), BooleanOp.OR),
            Block.box(0, 0, 0, 8, 16, 16),
            Block.box(0, 0, 0, 8, 16, 8)
    };
    private static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            Shapes.join(Block.box(0, 0, 0, 8, 16, 16), Block.box(8, 0, 0, 16, 16, 8), BooleanOp.OR),
            Block.box(0, 0, 0, 16, 16, 8),
            Block.box(8, 0, 0, 16, 16, 8)
    };
    private static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            Shapes.join(Block.box(0, 0, 0, 16, 16, 8), Block.box(8, 0, 8, 16, 16, 16), BooleanOp.OR),
            Block.box(8, 0, 0, 16, 16, 16),
            Block.box(8, 0, 8, 16, 16, 16)
    };

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(SLICES) != 0) {
            if (state.getValue(FACING) == Direction.NORTH) {
                return NORTH_SHAPES[state.getValue(SLICES) - 1];
            } else if (state.getValue(FACING) == Direction.EAST) {
                return EAST_SHAPES[state.getValue(SLICES) - 1];
            } else if (state.getValue(FACING) == Direction.SOUTH) {
                return SOUTH_SHAPES[state.getValue(SLICES) - 1];
            } else if (state.getValue(FACING) == Direction.WEST) {
                return WEST_SHAPES[state.getValue(SLICES) - 1];
            }
        }
        return super.getShape(state, world, pos, context);
    }
    public OrangeBlock(Properties settings) {
        super(settings);
    }

    @Override
    public Item getFruitItem() {
        return BFItems.ORANGE.get();
    }
}
