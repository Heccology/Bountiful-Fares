package net.hecco.bountifulfares.compat.excessive_building;


import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.BlockPos;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CompatVerticalStairsBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;


    private final String modId;

    public CompatVerticalStairsBlock(String modId, Properties settings) {
        super(settings);
        this.modId = modId;
    }

    public CompatVerticalStairsBlock(Properties settings) {
        super(settings);
        this.modId = BountifulFares.EXCESSIVE_BUILDING_MOD_ID;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH -> {
                return Shapes.join(Block.box(0, 0, 8, 8, 16, 16), Block.box(8, 0, 0, 16, 16, 16), BooleanOp.OR);
            }
            case EAST -> {
                return Shapes.join(Block.box(0, 0, 0, 8, 16, 8), Block.box(0, 0, 8, 16, 16, 16), BooleanOp.OR);
            }
            case SOUTH -> {
                return Shapes.join(Block.box(8, 0, 0, 16, 16, 8), Block.box(0, 0, 0, 8, 16, 16), BooleanOp.OR);
            }
            case WEST -> {
                return Shapes.join(Block.box(8, 0, 8, 16, 16, 16), Block.box(0, 0, 0, 16, 16, 8), BooleanOp.OR);
            }
        }
        return Shapes.join(Block.box(0, 0, 8, 8, 16, 16), Block.box(8, 0, 0, 16, 16, 16), BooleanOp.OR);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
        super.createBlockStateDefinition(builder);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        return this.defaultBlockState().setValue(WATERLOGGED, world.getFluidState(pos).getType() == Fluids.WATER)
                .setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }
    public static final MapCodec<CompatVerticalStairsBlock> CODEC = CompatVerticalStairsBlock.simpleCodec(CompatVerticalStairsBlock::new);

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}