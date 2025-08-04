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

import java.util.stream.Stream;

public class LemonBlock extends FruitBlock {
    private static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.box(8, 0, 0, 16, 16, 16),
                    Block.box(0, 0, 8, 8, 16, 16),
                    Block.box(8, -3, 4, 12, 19, 12),
                    Block.box(4, -3, 8, 8, 19, 12)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
            Shapes.join(Block.box(0, 0, 8, 16, 16, 16), Block.box(4, -3, 8, 12, 19, 12), BooleanOp.OR),
            Shapes.join(Block.box(0, 0, 8, 8, 16, 16), Block.box(4, -3, 8, 8, 19, 12), BooleanOp.OR)
    };
    private static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.box(0, 0, 8, 16, 16, 16),
                    Block.box(0, 0, 0, 8, 16, 8),
                    Block.box(4, -3, 8, 12, 19, 12),
                    Block.box(4, -3, 4, 8, 19, 8)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
            Shapes.join(Block.box(0, 0, 0, 8, 16, 16), Block.box(4, -3, 4, 8, 19, 12), BooleanOp.OR),
            Shapes.join(Block.box(0, 0, 0, 8, 16, 8), Block.box(4, -3, 4, 8, 19, 8), BooleanOp.OR)
    };
    private static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.box(0, 0, 0, 8, 16, 16),
                    Block.box(8, 0, 0, 16, 16, 8),
                    Block.box(4, -3, 4, 8, 19, 12),
                    Block.box(8, -3, 4, 12, 19, 8)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
            Shapes.join(Block.box(0, 0, 0, 16, 16, 8), Block.box(4, -3, 4, 12, 19, 8), BooleanOp.OR),
            Shapes.join(Block.box(8, 0, 0, 16, 16, 8), Block.box(8, -3, 4, 12, 19, 8), BooleanOp.OR)
    };
    private static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.box(0, 0, 0, 16, 16, 8),
                    Block.box(8, 0, 8, 16, 16, 16),
                    Block.box(4, -3, 4, 12, 19, 8),
                    Block.box(8, -3, 8, 12, 19, 12)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
            Shapes.join(Block.box(8, 0, 0, 16, 16, 16), Block.box(8, -3, 4, 12, 19, 12), BooleanOp.OR),
            Shapes.join(Block.box(8, 0, 8, 16, 16, 16), Block.box(8, -3, 8, 12, 19, 12), BooleanOp.OR)
    };
    public LemonBlock(Properties settings) {
        super(settings);
    }

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
        return Shapes.join(Block.box(0, 0, 0, 16, 16, 16),
                Block.box(4, -3, 4, 12, 19, 12),
                BooleanOp.OR);
    }

    @Override
    public Item getFruitItem() {
        return BFItems.LEMON.get();
    }
}
