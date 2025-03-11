package net.hecco.bountifulfares.compat.excessive_building;


import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CompatVerticalStairsBlock extends HorizontalFacingBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;


    private final String modId;

    public CompatVerticalStairsBlock(String modId, Settings settings) {
        super(settings);
        this.modId = modId;
    }

    public CompatVerticalStairsBlock(Settings settings) {
        super(settings);
        this.modId = BountifulFares.EXCESSIVE_BUILDING_MOD_ID;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH -> {
                return VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 8, 8, 16, 16), Block.createCuboidShape(8, 0, 0, 16, 16, 16), BooleanBiFunction.OR);
            }
            case EAST -> {
                return VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 8, 16, 8), Block.createCuboidShape(0, 0, 8, 16, 16, 16), BooleanBiFunction.OR);
            }
            case SOUTH -> {
                return VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 0, 0, 16, 16, 8), Block.createCuboidShape(0, 0, 0, 8, 16, 16), BooleanBiFunction.OR);
            }
            case WEST -> {
                return VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 0, 8, 16, 16, 16), Block.createCuboidShape(0, 0, 0, 16, 16, 8), BooleanBiFunction.OR);
            }
        }
        return VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 8, 8, 16, 16), Block.createCuboidShape(8, 0, 0, 16, 16, 16), BooleanBiFunction.OR);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
        super.appendProperties(builder);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        return this.getDefaultState().with(WATERLOGGED, world.getFluidState(pos).getFluid() == Fluids.WATER)
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
    public static final MapCodec<CompatVerticalStairsBlock> CODEC = CompatVerticalStairsBlock.createCodec(CompatVerticalStairsBlock::new);

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }
}