package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class LemonBlock extends FruitBlock {
    private static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.createCuboidShape(8, 0, 0, 16, 16, 16),
                    Block.createCuboidShape(0, 0, 8, 8, 16, 16),
                    Block.createCuboidShape(8, -3, 4, 12, 19, 12),
                    Block.createCuboidShape(4, -3, 8, 8, 19, 12)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 8, 16, 16, 16), Block.createCuboidShape(4, -3, 8, 12, 19, 12), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 8, 8, 16, 16), Block.createCuboidShape(4, -3, 8, 8, 19, 12), BooleanBiFunction.OR)
    };
    private static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.createCuboidShape(0, 0, 8, 16, 16, 16),
                    Block.createCuboidShape(0, 0, 0, 8, 16, 8),
                    Block.createCuboidShape(4, -3, 8, 12, 19, 12),
                    Block.createCuboidShape(4, -3, 4, 8, 19, 8)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 8, 16, 16), Block.createCuboidShape(4, -3, 4, 8, 19, 12), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 8, 16, 8), Block.createCuboidShape(4, -3, 4, 8, 19, 8), BooleanBiFunction.OR)
    };
    private static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.createCuboidShape(0, 0, 0, 8, 16, 16),
                    Block.createCuboidShape(8, 0, 0, 16, 16, 8),
                    Block.createCuboidShape(4, -3, 4, 8, 19, 12),
                    Block.createCuboidShape(8, -3, 4, 12, 19, 8)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 16, 16, 8), Block.createCuboidShape(4, -3, 4, 12, 19, 8), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 0, 0, 16, 16, 8), Block.createCuboidShape(8, -3, 4, 12, 19, 8), BooleanBiFunction.OR)
    };
    private static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.createCuboidShape(0, 0, 0, 16, 16, 8),
                    Block.createCuboidShape(8, 0, 8, 16, 16, 16),
                    Block.createCuboidShape(4, -3, 4, 12, 19, 8),
                    Block.createCuboidShape(8, -3, 8, 12, 19, 12)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 0, 0, 16, 16, 16), Block.createCuboidShape(8, -3, 4, 12, 19, 12), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 0, 8, 16, 16, 16), Block.createCuboidShape(8, -3, 8, 12, 19, 12), BooleanBiFunction.OR)
    };
    public LemonBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(SLICES) != 0) {
            if (state.get(FACING) == Direction.NORTH) {
                return NORTH_SHAPES[state.get(SLICES) - 1];
            } else if (state.get(FACING) == Direction.EAST) {
                return EAST_SHAPES[state.get(SLICES) - 1];
            } else if (state.get(FACING) == Direction.SOUTH) {
                return SOUTH_SHAPES[state.get(SLICES) - 1];
            } else if (state.get(FACING) == Direction.WEST) {
                return WEST_SHAPES[state.get(SLICES) - 1];
            }
        }
        return VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 16, 16, 16),
                Block.createCuboidShape(4, -3, 4, 12, 19, 12),
                BooleanBiFunction.OR);
    }

    @Override
    public Item getFruitItem() {
        return BFItems.LEMON;
    }
}
