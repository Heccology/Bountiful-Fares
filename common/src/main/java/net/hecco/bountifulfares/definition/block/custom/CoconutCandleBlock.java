package net.hecco.bountifulfares.definition.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;

public class CoconutCandleBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty LIT = AbstractCandleBlock.LIT;
    public static final IntegerProperty CANDLES = IntegerProperty.create("candles", 1, 3);
    public static boolean canBeLit;

    public static final VoxelShape[] SHAPES = new VoxelShape[] {
            Block.box(5.5, 0, 5.5, 10.5, 4, 10.5),
            Block.box(3, 0, 4, 13, 4, 12),
            Block.box(2.5, 0, 2.5, 13.5, 4, 13.5)
    };

    public CoconutCandleBlock(Properties settings) {
        super(settings);
        canBeLit = canBeLit(defaultBlockState());
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false).setValue(CANDLES, 1).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(CANDLES) - 1];
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if (stack.isEmpty() && state.getValue(LIT)) {
            extinguish(player, state, world, pos);
            return ItemInteractionResult.SUCCESS;
        }
        if ((stack.is(Items.FLINT_AND_STEEL) || stack.is(Items.FIRE_CHARGE)) && !canBeLit(state)) {
            return ItemInteractionResult.FAIL;
        } else if (stack.is(Items.FLINT_AND_STEEL)) {
            setLit(world, state, pos, true);
            world.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            player.getItemInHand(hand).hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            return ItemInteractionResult.SUCCESS;
        } else if (stack.is(Items.FIRE_CHARGE)) {
            setLit(world, state, pos, true);
            world.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, (world.random.nextFloat() - world.random.nextFloat()) * 0.2F + 1.0F);
            if (!player.isCreative()) {
                stack.shrink(1);
            }
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return !context.isSecondaryUseActive() && context.getItemInHand().getItem() == this.asItem() && state.getValue(CANDLES) < 3 || super.canBeReplaced(state, context);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CANDLES, LIT, WATERLOGGED);
    }

    @Override
    public void onProjectileHit(Level world, BlockState state, BlockHitResult hit, Projectile projectile) {
        if (!world.isClientSide && projectile.isOnFire() && !state.getValue(LIT)) {
            setLit(world, state, hit.getBlockPos(), true);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return Block.canSupportCenter(world, pos.below(), Direction.UP);
    }

    public static void extinguish(@Nullable Player player, BlockState state, LevelAccessor world, BlockPos pos) {
        setLit(world, state, pos, false);
        world.playSound(null, pos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0f, 1.0f);
        world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
    }

    protected void onExplosionHit(BlockState state, Level level, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> dropConsumer) {
        if (explosion.canTriggerBlocks() && state.getValue(LIT)) {
            extinguish(null, state, level, pos);
        }

        super.onExplosionHit(state, level, pos, explosion, dropConsumer);
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState blockState = ctx.getLevel().getBlockState(ctx.getClickedPos());
        if (blockState.is(this)) {
            return blockState.cycle(CANDLES);
        } else {
            FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
            boolean bl = fluidState.getType() == Fluids.WATER;
            return super.getStateForPlacement(ctx).setValue(WATERLOGGED, bl);
        }
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

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if (!state.getValue(LIT)) {
            return;
        }
        if (state.getValue(CANDLES) == 1) {
            spawnCandleParticles(world, new Vec3(pos.getX()+0.5, pos.getY()+0.3, pos.getZ()+0.5), random);
        } else if (state.getValue(CANDLES) == 2) {
            spawnCandleParticles(world, new Vec3(pos.getX() + 0.65625, pos.getY() + 0.3, pos.getZ() + 0.59375), random);
            spawnCandleParticles(world, new Vec3(pos.getX() + 0.3125, pos.getY() + 0.2375, pos.getZ() + 0.34375), random);
        } else {
            spawnCandleParticles(world, new Vec3(pos.getX()+0.6875, pos.getY()+0.3, pos.getZ()+0.6875), random);
            spawnCandleParticles(world, new Vec3(pos.getX()+0.625, pos.getY()+0.2375, pos.getZ()+0.28125), random);
            spawnCandleParticles(world, new Vec3(pos.getX()+0.28125, pos.getY()+0.2375, pos.getZ()+0.53125), random);
        }
        if (random.nextFloat() < 0.17f) {
            world.playLocalSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f, false);
        }
    }

    public static boolean canBeLit(BlockState state) {
        return !state.getValue(LIT) && !state.getValue(WATERLOGGED);
    }

    static void setLit(LevelAccessor world, BlockState state, BlockPos pos, boolean lit) {
        world.setBlock(pos, state.setValue(LIT, lit), Block.UPDATE_ALL | Block.UPDATE_IMMEDIATE);
    }

    private static void spawnCandleParticles(Level world, Vec3 vec3d, RandomSource random) {
        float f = random.nextFloat();
        if (f < 0.3f) {
            world.addParticle(ParticleTypes.SMOKE, vec3d.x, vec3d.y, vec3d.z, 0.0, 0.0, 0.0);
        }
        world.addParticle(ParticleTypes.SMALL_FLAME, vec3d.x, vec3d.y, vec3d.z, 0.0, 0.0, 0.0);
    }
}
