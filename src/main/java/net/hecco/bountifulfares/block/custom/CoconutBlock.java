package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.registry.util.BFDamageTypes;
import net.minecraft.block.*;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class CoconutBlock extends FallingBlock implements Fertilizable {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty AGE = Properties.AGE_5;
    public static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(5, 10, 10, 11, 16, 16),
            Block.createCuboidShape(4, 8, 8, 12, 16, 16),
            Block.createCuboidShape(6, 9, 10, 10, 14, 14),
            Block.createCuboidShape(5, 7, 8, 11, 14, 14),
            Block.createCuboidShape(3.5, 4, 6, 12.5, 14, 15),
            Block.createCuboidShape(3, 1, 5, 13, 13, 15)
    };
    public static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(0, 10, 5, 6, 16, 11),
            Block.createCuboidShape(0, 8, 4, 8, 16, 12),
            Block.createCuboidShape(2, 9, 6, 6, 14, 10),
            Block.createCuboidShape(2, 7, 5, 8, 14, 11),
            Block.createCuboidShape(1, 4, 3.5, 10, 14, 12.5),
            Block.createCuboidShape(1, 1, 3, 11, 13, 13)
    };
    public static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(5, 10, 0, 11, 16, 6),
            Block.createCuboidShape(4, 8, 0, 12, 16, 8),
            Block.createCuboidShape(6, 9, 2, 10, 14, 6),
            Block.createCuboidShape(5, 7, 2, 11, 14, 8),
            Block.createCuboidShape(3.5, 4, 1, 12.5, 14, 10),
            Block.createCuboidShape(3, 1, 1, 13, 13, 11)
    };
    public static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(10, 10, 5, 16, 16, 11),
            Block.createCuboidShape(8, 8, 4, 16, 16, 12),
            Block.createCuboidShape(10, 9, 6, 14, 14, 10),
            Block.createCuboidShape(8, 7, 5, 14, 14, 11),
            Block.createCuboidShape(6, 4, 3.5, 15, 14, 12.5),
            Block.createCuboidShape(5, 1, 3, 15, 13, 13)
    };
    public CoconutBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(AGE, 0));
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return null;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(FACING) == Direction.NORTH) {
            return NORTH_SHAPES[state.get(AGE)];
        }
        if (state.get(FACING) == Direction.EAST) {
            return EAST_SHAPES[state.get(AGE)];
        }
        if (state.get(FACING) == Direction.SOUTH) {
            return SOUTH_SHAPES[state.get(AGE)];
        }
        if (state.get(FACING) == Direction.WEST) {
            return WEST_SHAPES[state.get(AGE)];
        }
        return super.getOutlineShape(state, world, pos, context);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(AGE) > 2) {
            if (state.get(FACING) == Direction.NORTH) {
                return NORTH_SHAPES[state.get(AGE)];
            }
            if (state.get(FACING) == Direction.EAST) {
                return EAST_SHAPES[state.get(AGE)];
            }
            if (state.get(FACING) == Direction.SOUTH) {
                return SOUTH_SHAPES[state.get(AGE)];
            }
            if (state.get(FACING) == Direction.WEST) {
                return WEST_SHAPES[state.get(AGE)];
            }
        }
        return VoxelShapes.empty();
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(BFItems.COCONUT);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!isFullyGrown(state) && random.nextFloat() < 0.2) {
            world.setBlockState(pos, state.cycle(AGE), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {

    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {

    }

    private static boolean isFullyGrown(BlockState state) {
        return state.get(AGE) == 5;
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(AGE) == 5 && direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos)) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.spawnFromBlock((World) world, pos, state);
            this.configureFallingBlockEntity(fallingBlockEntity);
            world.removeBlock(pos, false);
            return Blocks.AIR.getDefaultState();
        }
        return direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.isCreative() && state.get(AGE) == 5 && (canFallThrough(world.getBlockState(pos.down())) || world.getBlockState(pos.down()).isIn(BFBlockTags.SPLITS_COCONUTS))) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.spawnFromBlock(world, pos, state);
            this.configureFallingBlockEntity(fallingBlockEntity);
            world.removeBlock(pos, false);
            return Blocks.AIR.getDefaultState();
        } else {
            return super.onBreak(world, pos, state, player);
        }
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (state.get(AGE) == 5) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.spawnFromBlock(world, hit.getBlockPos(), state);
            this.configureFallingBlockEntity(fallingBlockEntity);
            world.removeBlock(hit.getBlockPos(), false);
        }
        super.onProjectileHit(world, state, hit, projectile);
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (state.get(AGE) < 2) {
            world.removeBlock(pos, false);
        } else {
            super.onBlockBreakStart(state, world, pos, player);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    }



    @Override
    public void onDestroyedOnLanding(World world, BlockPos pos, FallingBlockEntity fallingBlockEntity) {
        DamageSource damageSource = new DamageSource(
                world.getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .entryOf(BFDamageTypes.FALLING_COCONUT));
        if (world.getBlockState(pos).isIn(BFBlockTags.SPLITS_COCONUTS) || world.getBlockState(pos.down()).isIn(BFBlockTags.SPLITS_COCONUTS)) {
            dropStack(world, pos, new ItemStack(BFItems.COCONUT_HALF, 2));
        } else {
            dropStack(world, pos, new ItemStack(BFItems.COCONUT));
        }
        if (!world.getOtherEntities(fallingBlockEntity, fallingBlockEntity.getBoundingBox(), EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.and(EntityPredicates.VALID_LIVING_ENTITY)).isEmpty()) {
            world.getOtherEntities(fallingBlockEntity, fallingBlockEntity.getBoundingBox(), EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.and(EntityPredicates.VALID_LIVING_ENTITY)).forEach((entity) ->
                    entity.damage(damageSource, 4));
            world.playSound(null, pos, BFSounds.COCONUT_BONK, SoundCategory.BLOCKS, 1, 0.8f + world.random.nextFloat()/3);
        } else {
            world.playSound(null, pos, BFSounds.COCONUT_LAND, SoundCategory.BLOCKS, 1, 0.8f + world.random.nextFloat()/3);
        }
        fallingBlockEntity.discard();
        super.onDestroyedOnLanding(world, pos, fallingBlockEntity);
    }

    @Override
    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        DamageSource damageSource = new DamageSource(
                world.getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .entryOf(BFDamageTypes.FALLING_COCONUT));
        if (world.getBlockState(pos).isIn(BFBlockTags.SPLITS_COCONUTS) || world.getBlockState(pos.down()).isIn(BFBlockTags.SPLITS_COCONUTS)) {
            dropStack(world, pos, new ItemStack(BFItems.COCONUT_HALF, 2));
        } else {
            dropStack(world, pos, new ItemStack(BFItems.COCONUT));
        }
        if (!world.getOtherEntities(fallingBlockEntity, fallingBlockEntity.getBoundingBox(), EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.and(EntityPredicates.VALID_LIVING_ENTITY)).isEmpty()) {
            world.getOtherEntities(fallingBlockEntity, fallingBlockEntity.getBoundingBox(), EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.and(EntityPredicates.VALID_LIVING_ENTITY)).forEach((entity) ->
                    entity.damage(damageSource, 4));
            world.playSound(null, pos, BFSounds.COCONUT_BONK, SoundCategory.BLOCKS, 1, 0.8f + world.random.nextFloat()/3);
        } else {
            world.playSound(null, pos, BFSounds.COCONUT_LAND, SoundCategory.BLOCKS, 1, 0.8f + world.random.nextFloat()/3);
        }
        fallingBlockEntity.discard();
        world.removeBlock(pos, false);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isSideSolidFullSquare(world, blockPos, direction);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, AGE);
        super.appendProperties(builder);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (!isFullyGrown(state)) {
            world.setBlockState(pos, state.cycle(AGE), Block.NOTIFY_LISTENERS);
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = super.getPlacementState(ctx);
        WorldView worldView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction[] directions = ctx.getPlacementDirections();
        Direction[] var6 = directions;
        int var7 = directions.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            Direction direction = var6[var8];
            if (direction.getAxis().isHorizontal()) {
                blockState = blockState.with(FACING, direction.getOpposite());
                if (blockState.canPlaceAt(worldView, blockPos)) {
                    return blockState;
                }
            }
        }

        return null;
    }
}
