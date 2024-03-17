package net.hecco.bountifulcuisine.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class HangingWalnutsBlock extends FallingBlock implements Fertilizable {

    public static final IntProperty AGE = Properties.AGE_3;

    public static final MapCodec<HangingWalnutsBlock> CODEC = HangingWalnutsBlock.createCodec(HangingWalnutsBlock::new);

    public HangingWalnutsBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return CODEC;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return Block.createCuboidShape(4, 12, 4, 12, 16, 12).offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }


    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!HangingWalnutsBlock.isFullyGrown(state) && random.nextFloat() < 0.2) {
            world.setBlockState(pos, state.cycle(AGE), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public void onDestroyedOnLanding(World world, BlockPos pos, FallingBlockEntity fallingBlockEntity) {
        if (world.getBlockState(pos).isAir() || world.getBlockState(pos).isIn(BlockTags.REPLACEABLE)) {
            if (world.getBlockState(pos.down()).isSideSolidFullSquare(world, pos, Direction.UP)) {
                world.setBlockState(pos, ModBlocks.FALLEN_WALNUTS.getDefaultState(), 2);
            }

        } else {
            if (world.getBlockState(pos).isSideSolidFullSquare(world, pos, Direction.UP)) {
                world.setBlockState(pos.up(), ModBlocks.FALLEN_WALNUTS.getDefaultState(), 2);
            }
            if (world.getBlockState(pos).isOf(ModBlocks.FALLEN_WALNUTS) && world.getBlockState(pos).get(FallenWalnutsBlock.COUNT) != 3) {
                world.setBlockState(pos, ModBlocks.FALLEN_WALNUTS.getDefaultState().with(FallenWalnutsBlock.COUNT, world.getBlockState(pos).get(FallenWalnutsBlock.COUNT) + 1), 2);
            } else if (world.getBlockState(pos).isOf(Blocks.FARMLAND) || world.getBlockState(pos).isOf(Blocks.DIRT_PATH)) {
                if (world.getBlockState(pos.up()).isOf(ModBlocks.FALLEN_WALNUTS) && world.getBlockState(pos.up()).get(FallenWalnutsBlock.COUNT) != 3) {
                    world.setBlockState(pos.up(), ModBlocks.FALLEN_WALNUTS.getDefaultState().with(FallenWalnutsBlock.COUNT, world.getBlockState(pos.up()).get(FallenWalnutsBlock.COUNT) + 1), 2);
                } else {
                    world.setBlockState(pos.up(), ModBlocks.FALLEN_WALNUTS.getDefaultState(), 2);
                }
            }
        }
        super.onDestroyedOnLanding(world, pos, fallingBlockEntity);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.up(), Direction.DOWN) && !world.isWater(pos)
                || world.getBlockState(pos.up()).isOf(ModBlocks.WALNUT_LEAVES) && !world.isWater(pos);
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (canFallThrough(state) && pos.getY() >= world.getBottomY()) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.spawnFromBlock(world, pos, state);
            this.configureFallingBlockEntity(fallingBlockEntity);
            world.setBlockState(pos, state.with(AGE, 0));
        }
    }

    public static boolean canFallThrough(BlockState walnutState) {
        if (!isFullyGrown(walnutState)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected int getFallDelay() {
        return 30;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {

    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (!isFullyGrown(state)) {
            world.setBlockState(pos, state.cycle(AGE), Block.NOTIFY_LISTENERS);
        }
    }

    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    private static boolean isFullyGrown(BlockState state) {
        return state.get(AGE) == 3;
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return type == NavigationType.AIR && !this.collidable || super.canPathfindThrough(state, world, pos, type);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return ModItems.WALNUT.getDefaultStack();
    }
}
