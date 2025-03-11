package net.hecco.bountifulfares.compat.twigs;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.block.CompatBlock;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

//This class is only included for ease of use and in order to not use Twigs as a dependency.
// The original code was grabbed from here: https://github.com/N1nn1/twigs/blob/main/src/main/java/com/ninni/twigs/block/TableBlock.java

public class TwigsTableBlock extends CompatBlock implements Waterloggable {
    private static final BooleanProperty WATERLOGGED;
    private static final BooleanProperty LEG1;
    private static final BooleanProperty LEG2;
    private static final BooleanProperty LEG3;
    private static final BooleanProperty LEG4;
    public static final BooleanProperty UPDATE;
    protected static final VoxelShape TOP;
    protected static final VoxelShape LEG_1;
    protected static final VoxelShape LEG_2;
    protected static final VoxelShape LEG_3;
    protected static final VoxelShape LEG_4;
    protected static final VoxelShape[] SHAPES;

    public TwigsTableBlock(String modId, AbstractBlock.Settings properties) {
        super(modId, properties);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false).with(LEG1, true).with(LEG2, true).with(LEG3, true).with(LEG4, true));
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID) || BountifulFares.isDatagen();
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        Boolean leg1 = state.get(LEG1);
        Boolean leg2 = state.get(LEG2);
        Boolean leg3 = state.get(LEG3);
        Boolean leg4 = state.get(LEG4);
        int shape = 0;
        if (leg2) {
            shape = 1;
        }
        if (leg3) {
            shape = 2;
        }
        if (leg1) {
            shape = 3;
        }
        if (leg4) {
            shape = 4;
        }
        if (leg2 && leg3) {
            shape = 5;
        }
        if (leg2 && leg1) {
            shape = 6;
        }
        if (leg2 && leg4) {
            shape = 7;
        }
        if (leg3 && leg1) {
            shape = 8;
        }
        if (leg3 && leg4) {
            shape = 9;
        }
        if (leg1 && leg4) {
            shape = 10;
        }
        if (leg2 && leg3 && leg1) {
            shape = 11;
        }
        if (leg2 && leg3 && leg4) {
            shape = 12;
        }
        if (leg2 && leg1 && leg4) {
            shape = 13;
        }
        if (leg3 && leg1 && leg4) {
            shape = 14;
        }
        if (leg2 && leg3 && leg1 && leg4) {
            shape = 15;
        }
        return SHAPES[shape];
    }

    public BlockState getConnections(BlockState state, WorldAccess level, BlockPos pos) {
        boolean north = this.canConnect(level.getBlockState(pos.north()));
        boolean south = this.canConnect(level.getBlockState(pos.south()));
        boolean east = this.canConnect(level.getBlockState(pos.east()));
        boolean west = this.canConnect(level.getBlockState(pos.west()));
        boolean update = ((north ? 1 : 0) + (east ? 1 : 0) + (south ? 1 : 0) + (west ? 1 : 0)) % 2 == 0;
        return state.with(LEG1, !north && !east || north && east && !this.canConnect(level.getBlockState(pos.north().east()))).with(LEG2, !east && !south || east && south && !this.canConnect(level.getBlockState(pos.south().east()))).with(LEG3, !west && !south || west && south && !this.canConnect(level.getBlockState(pos.south().west()))).with(LEG4, !west && !north || west && north && !this.canConnect(level.getBlockState(pos.north().west()))).with(UPDATE, update);
    }

    public boolean canConnect(BlockState state) {
        return state.isIn(TwigsBlockTags.TABLES);
    }

    public @Nullable BlockState getPlacementState(ItemPlacementContext context) {
        return this.getConnections(this.getDefaultState().with(WATERLOGGED, context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER), context.getWorld(), context.getBlockPos());
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            level.scheduleFluidTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(level));
        }

        return this.getConnections(state, level, currentPos);
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, UPDATE, LEG1, LEG2, LEG3, LEG4);
    }

    public boolean canPathfindThrough(BlockState state, BlockView level, BlockPos pos, NavigationType type) {
        return false;
    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;
        LEG1 = BooleanProperty.of("table_leg1");
        LEG2 = BooleanProperty.of("table_leg2");
        LEG3 = BooleanProperty.of("table_leg3");
        LEG4 = BooleanProperty.of("table_leg4");
        UPDATE = BooleanProperty.of("update");
        TOP = Block.createCuboidShape(0.0, 12.0, 0.0, 16.0, 16.0, 16.0);
        LEG_1 = Block.createCuboidShape(12.0, 0.0, 12.0, 15.0, 12.0, 15.0);
        LEG_2 = Block.createCuboidShape(1.0, 0.0, 12.0, 4.0, 12.0, 15.0);
        LEG_3 = Block.createCuboidShape(12.0, 0.0, 1.0, 15.0, 12.0, 4.0);
        LEG_4 = Block.createCuboidShape(1.0, 0.0, 1.0, 4.0, 12.0, 4.0);
        SHAPES = new VoxelShape[]{TOP, VoxelShapes.union(TOP, LEG_1), VoxelShapes.union(TOP, LEG_2), VoxelShapes.union(TOP, LEG_3), VoxelShapes.union(TOP, LEG_4), VoxelShapes.union(TOP, new VoxelShape[]{LEG_1, LEG_2}), VoxelShapes.union(TOP, new VoxelShape[]{LEG_1, LEG_3}), VoxelShapes.union(TOP, new VoxelShape[]{LEG_1, LEG_4}), VoxelShapes.union(TOP, new VoxelShape[]{LEG_2, LEG_3}), VoxelShapes.union(TOP, new VoxelShape[]{LEG_2, LEG_4}), VoxelShapes.union(TOP, new VoxelShape[]{LEG_3, LEG_4}), VoxelShapes.union(TOP, new VoxelShape[]{LEG_1, LEG_2, LEG_3}), VoxelShapes.union(TOP, new VoxelShape[]{LEG_1, LEG_2, LEG_4}), VoxelShapes.union(TOP, new VoxelShape[]{LEG_1, LEG_3, LEG_4}), VoxelShapes.union(TOP, new VoxelShape[]{LEG_2, LEG_3, LEG_4}), VoxelShapes.union(TOP, new VoxelShape[]{LEG_1, LEG_2, LEG_3, LEG_4})};
    }
}