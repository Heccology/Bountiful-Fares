package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

public class MaizeCropBlock extends TallPlantBlock implements Fertilizable {
    public static final IntProperty AGE;
    public static final VoxelShape[] LOWER_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 0, 0, 16, 6, 16),
            Block.createCuboidShape(0, 0, 0, 16, 12, 16),
            Block.createCuboidShape(0, 0, 0, 16, 16, 16)
    };
    public static final VoxelShape[] UPPER_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(0, 0, 0, 16, 4, 16),
            Block.createCuboidShape(0, 0, 0, 16, 8, 16),
            Block.createCuboidShape(0, 0, 0, 16, 16, 16),
    };

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            return switch (state.get(AGE)) {
                case 0 -> LOWER_SHAPES[0];
                case 1 -> LOWER_SHAPES[1];
                case 2 -> LOWER_SHAPES[2];
                default -> LOWER_SHAPES[3];
            };
        } else if (state.get(HALF) == DoubleBlockHalf.UPPER) {
            return switch (state.get(AGE)) {
                case 0, 1, 2, 3, 4 -> UPPER_SHAPES[0];
                case 5 -> UPPER_SHAPES[1];
                default -> UPPER_SHAPES[2];
            };
        }
        return LOWER_SHAPES[3];
    }

    public MaizeCropBlock(Settings settings) {
        super(settings);
    }

    private boolean isFullyGrown(BlockState state) {
        return state.get(AGE) >= 7;
    }

    public boolean hasRandomTicks(BlockState state) {
        return state.get(HALF) == DoubleBlockHalf.LOWER && !this.isFullyGrown(state);
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState();
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (!isLowerHalf(state)) {
            return super.canPlaceAt(state, world, pos);
        } else {
            return this.canPlantOnTop(world.getBlockState(pos.down()), world, pos.down()) && canPlaceAt(world, pos) && (state.get(AGE) < 4 || isUpperHalf(world.getBlockState(pos.up())));
        }
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.FARMLAND);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
        super.appendProperties(builder);
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof RavagerEntity && world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
            world.breakBlock(pos, true, entity);
        }

        super.onEntityCollision(state, world, pos, entity);
    }

    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return false;
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
    }

    protected static float getAvailableMoisture(Block block, BlockView world, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockPos = pos.down();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float g = 0.0F;
                BlockState blockState = world.getBlockState(blockPos.add(i, 0, j));
                if (blockState.isOf(Blocks.FARMLAND)) {
                    g = 1.0F;
                    if (blockState.get(FarmlandBlock.MOISTURE) > 0) {
                        g = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    g /= 4.0F;
                }

                f += g;
            }
        }

        BlockPos blockPos2 = pos.north();
        BlockPos blockPos3 = pos.south();
        BlockPos blockPos4 = pos.west();
        BlockPos blockPos5 = pos.east();
        boolean bl = world.getBlockState(blockPos4).isOf(block) || world.getBlockState(blockPos5).isOf(block);
        boolean bl2 = world.getBlockState(blockPos2).isOf(block) || world.getBlockState(blockPos3).isOf(block);
        if (bl && bl2) {
            f /= 2.0F;
        } else {
            boolean bl3 = world.getBlockState(blockPos4.north()).isOf(block) || world.getBlockState(blockPos5.north()).isOf(block) || world.getBlockState(blockPos5.south()).isOf(block) || world.getBlockState(blockPos4.south()).isOf(block);
            if (bl3) {
                f /= 2.0F;
            }
        }

        return f;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        float f = MaizeCropBlock.getAvailableMoisture(this, world, pos);
        boolean bl = random.nextInt((int)(25.0F / f) + 1) == 0;
        if (bl) {
            this.tryGrow(world, state, pos);
        }

    }

    private void tryGrow(ServerWorld world, BlockState state, BlockPos pos) {
        int i = Math.min(state.get(AGE) + 1, 7);
        if (this.canGrow(world, pos, state, i)) {
            world.setBlockState(pos, state.with(AGE, i), 2);
            if (i >= 4) {
                BlockPos blockPos = pos.up();
                world.setBlockState(blockPos, withWaterloggedState(world, pos, (this.getDefaultState().with(AGE, i)).with(HALF, DoubleBlockHalf.UPPER)), 3);
            }

        }
    }

    private static boolean canGrowAt(WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.isAir() || blockState.isOf(ModBlocks.MAIZE_CROP);
    }

    private static boolean canPlaceAt(WorldView world, BlockPos pos) {
        return world.getBaseLightLevel(pos, 0) >= 8 || world.isSkyVisible(pos);
    }

    private static boolean isLowerHalf(BlockState state) {
        return state.isOf(ModBlocks.MAIZE_CROP) && state.get(HALF) == DoubleBlockHalf.LOWER;
    }

    private static boolean isUpperHalf(BlockState state) {
        return state.isOf(ModBlocks.MAIZE_CROP) && state.get(HALF) == DoubleBlockHalf.UPPER;
    }

    private boolean canGrow(WorldView world, BlockPos pos, BlockState state, int age) {
        return !this.isFullyGrown(state) && canPlaceAt(world, pos) && (age < 3 || canGrowAt(world, pos.up()));
    }

    @Nullable
    private MaizeCropBlock.LowerHalfContext getLowerHalfContext(WorldView world, BlockPos pos, BlockState state) {
        if (isLowerHalf(state)) {
            return new MaizeCropBlock.LowerHalfContext(pos, state);
        } else {
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            return isLowerHalf(blockState) ? new MaizeCropBlock.LowerHalfContext(blockPos, blockState) : null;
        }
    }

    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        MaizeCropBlock.LowerHalfContext lowerHalfContext = this.getLowerHalfContext(world, pos, state);
        return lowerHalfContext != null && this.canGrow(world, lowerHalfContext.pos, lowerHalfContext.state, lowerHalfContext.state.get(AGE) + 1);
    }

    public boolean canGrow(World world, net.minecraft.util.math.random.Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        MaizeCropBlock.LowerHalfContext lowerHalfContext = this.getLowerHalfContext(world, pos, state);
        if (lowerHalfContext != null) {
            this.tryGrow(world, lowerHalfContext.state, lowerHalfContext.pos);
        }
    }

    static {
        AGE = Properties.AGE_7;
    }

    private record LowerHalfContext(BlockPos pos, BlockState state) {

        public BlockPos pos() {
            return this.pos;
        }

        public BlockState state() {
            return this.state;
        }
    }
}
