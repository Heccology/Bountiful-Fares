package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.registry.util.BFDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CoconutBlock extends FallingBlock implements BonemealableBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    public static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            Block.box(5, 10, 10, 11, 16, 16),
            Block.box(4, 8, 8, 12, 16, 16),
            Block.box(6, 9, 10, 10, 14, 14),
            Block.box(5, 7, 8, 11, 14, 14),
            Block.box(3.5, 4, 6, 12.5, 14, 15),
            Block.box(3, 1, 5, 13, 13, 15)
    };
    public static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            Block.box(0, 10, 5, 6, 16, 11),
            Block.box(0, 8, 4, 8, 16, 12),
            Block.box(2, 9, 6, 6, 14, 10),
            Block.box(2, 7, 5, 8, 14, 11),
            Block.box(1, 4, 3.5, 10, 14, 12.5),
            Block.box(1, 1, 3, 11, 13, 13)
    };
    public static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            Block.box(5, 10, 0, 11, 16, 6),
            Block.box(4, 8, 0, 12, 16, 8),
            Block.box(6, 9, 2, 10, 14, 6),
            Block.box(5, 7, 2, 11, 14, 8),
            Block.box(3.5, 4, 1, 12.5, 14, 10),
            Block.box(3, 1, 1, 13, 13, 11)
    };
    public static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            Block.box(10, 10, 5, 16, 16, 11),
            Block.box(8, 8, 4, 16, 16, 12),
            Block.box(10, 9, 6, 14, 14, 10),
            Block.box(8, 7, 5, 14, 14, 11),
            Block.box(6, 4, 3.5, 15, 14, 12.5),
            Block.box(5, 1, 3, 15, 13, 13)
    };
    public CoconutBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AGE, 0));
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return null;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(FACING) == Direction.NORTH) {
            return NORTH_SHAPES[state.getValue(AGE)];
        }
        if (state.getValue(FACING) == Direction.EAST) {
            return EAST_SHAPES[state.getValue(AGE)];
        }
        if (state.getValue(FACING) == Direction.SOUTH) {
            return SOUTH_SHAPES[state.getValue(AGE)];
        }
        if (state.getValue(FACING) == Direction.WEST) {
            return WEST_SHAPES[state.getValue(AGE)];
        }
        return super.getShape(state, world, pos, context);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(AGE) > 2) {
            if (state.getValue(FACING) == Direction.NORTH) {
                return NORTH_SHAPES[state.getValue(AGE)];
            }
            if (state.getValue(FACING) == Direction.EAST) {
                return EAST_SHAPES[state.getValue(AGE)];
            }
            if (state.getValue(FACING) == Direction.SOUTH) {
                return SOUTH_SHAPES[state.getValue(AGE)];
            }
            if (state.getValue(FACING) == Direction.WEST) {
                return WEST_SHAPES[state.getValue(AGE)];
            }
        }
        return Shapes.empty();
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return new ItemStack(BFItems.COCONUT.get());
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!isFullyGrown(state) && random.nextFloat() < 0.2) {
            world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
        }
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {

    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify) {

    }

    private static boolean isFullyGrown(BlockState state) {
        return state.getValue(AGE) == 5;
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(AGE) == 5 && direction.getOpposite() == state.getValue(FACING) && !state.canSurvive(world, pos)) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.fall((Level) world, pos, state);
            this.falling(fallingBlockEntity);
            world.removeBlock(pos, false);
            return Blocks.AIR.defaultBlockState();
        }
        return direction.getOpposite() == state.getValue(FACING) && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : state;
    }

    @Override
    public BlockState playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if (!player.isCreative() && state.getValue(AGE) == 5 && (isFree(world.getBlockState(pos.below())) || world.getBlockState(pos.below()).is(BFBlockTags.SPLITS_COCONUTS))) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.fall(world, pos, state);
            this.falling(fallingBlockEntity);
            world.removeBlock(pos, false);
            return Blocks.AIR.defaultBlockState();
        } else {
            return super.playerWillDestroy(world, pos, state, player);
        }
    }

    @Override
    public void onProjectileHit(Level world, BlockState state, BlockHitResult hit, Projectile projectile) {
        if (state.getValue(AGE) == 5) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.fall(world, hit.getBlockPos(), state);
            this.falling(fallingBlockEntity);
            world.removeBlock(hit.getBlockPos(), false);
        }
        super.onProjectileHit(world, state, hit, projectile);
    }

    @Override
    public void attack(BlockState state, Level world, BlockPos pos, Player player) {
        if (state.getValue(AGE) < 2) {
            world.removeBlock(pos, false);
        } else {
            super.attack(state, world, pos, player);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
    }



    @Override
    public void onBrokenAfterFall(Level world, BlockPos pos, FallingBlockEntity fallingBlockEntity) {
        DamageSource damageSource = new DamageSource(
                world.registryAccess()
                        .registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(BFDamageTypes.FALLING_COCONUT));
        if (world.getBlockState(pos).is(BFBlockTags.SPLITS_COCONUTS) || world.getBlockState(pos.below()).is(BFBlockTags.SPLITS_COCONUTS)) {
            popResource(world, pos, new ItemStack(BFItems.COCONUT_HALF.get(), 2));
        } else {
            popResource(world, pos, new ItemStack(BFItems.COCONUT.get()));
        }
        if (!world.getEntities(fallingBlockEntity, fallingBlockEntity.getBoundingBox(), EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE)).isEmpty()) {
            world.getEntities(fallingBlockEntity, fallingBlockEntity.getBoundingBox(), EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE)).forEach((entity) ->
                    entity.hurt(damageSource, 4));
            world.playSound(null, pos, BFSounds.COCONUT_BONK.get(), SoundSource.BLOCKS, 1, 0.8f + world.random.nextFloat()/3);
        } else {
            world.playSound(null, pos, BFSounds.COCONUT_LAND.get(), SoundSource.BLOCKS, 1, 0.8f + world.random.nextFloat()/3);
        }
        fallingBlockEntity.discard();
        super.onBrokenAfterFall(world, pos, fallingBlockEntity);
    }

    @Override
    public void onLand(Level world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        DamageSource damageSource = new DamageSource(
                world.registryAccess()
                        .registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(BFDamageTypes.FALLING_COCONUT));
        if (world.getBlockState(pos).is(BFBlockTags.SPLITS_COCONUTS) || world.getBlockState(pos.below()).is(BFBlockTags.SPLITS_COCONUTS)) {
            popResource(world, pos, new ItemStack(BFItems.COCONUT_HALF.get(), 2));
        } else {
            popResource(world, pos, new ItemStack(BFItems.COCONUT.get()));
        }
        if (!world.getEntities(fallingBlockEntity, fallingBlockEntity.getBoundingBox(), EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE)).isEmpty()) {
            world.getEntities(fallingBlockEntity, fallingBlockEntity.getBoundingBox(), EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE)).forEach((entity) ->
                    entity.hurt(damageSource, 4));
            world.playSound(null, pos, BFSounds.COCONUT_BONK.get(), SoundSource.BLOCKS, 1, 0.8f + world.random.nextFloat()/3);
        } else {
            world.playSound(null, pos, BFSounds.COCONUT_LAND.get(), SoundSource.BLOCKS, 1, 0.8f + world.random.nextFloat()/3);
        }
        fallingBlockEntity.discard();
        world.removeBlock(pos, false);
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos blockPos = pos.relative(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isFaceSturdy(world, blockPos, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, AGE);
        super.createBlockStateDefinition(builder);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        if (!isFullyGrown(state)) {
            world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState blockState = super.getStateForPlacement(ctx);
        LevelReader worldView = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        Direction[] directions = ctx.getNearestLookingDirections();
        Direction[] var6 = directions;
        int var7 = directions.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            Direction direction = var6[var8];
            if (direction.getAxis().isHorizontal()) {
                blockState = blockState.setValue(FACING, direction.getOpposite());
                if (blockState.canSurvive(worldView, blockPos)) {
                    return blockState;
                }
            }
        }

        return null;
    }
}
