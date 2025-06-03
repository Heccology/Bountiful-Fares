package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PrismarineBlossomBlock extends BushBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public PrismarineBlossomBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false));
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return null;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Block.box(3, 0, 3, 13, 4, 13);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        return world.getBlockState(blockPos).isFaceSturdy(world, blockPos, Direction.UP);
    }

    @Override
    protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        return world.getBlockState(blockPos).isFaceSturdy(world, blockPos, Direction.UP);
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            for (int x = 0; x < world.random.nextIntBetweenInclusive(0, 1); ++x) {
                spawnPrismarineBlossomParticles(world, new Vec3(pos.getX()+0.5, pos.getY()+0.3, pos.getZ()+0.5));
            }
        }
    }

    private static void spawnPrismarineBlossomParticles(Level world, Vec3 vec3d) {
        world.addParticle(BFParticles.PRISMARINE_BLOSSOM, vec3d.x + world.random.nextGaussian()/8, vec3d.y + world.random.nextGaussian()/10, vec3d.z + world.random.nextGaussian()/8, world.random.nextGaussian()/60, world.random.nextFloat()/40, world.random.nextGaussian()/60);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        boolean bl = fluidState.getType() == Fluids.WATER;
        return super.getStateForPlacement(ctx).setValue(WATERLOGGED, bl);
    }


    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(state);
    }
}
