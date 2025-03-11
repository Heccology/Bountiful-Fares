package net.hecco.bountifulfares.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class CoconutCandleBlock extends Block implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty LIT = AbstractCandleBlock.LIT;
    public static final IntProperty CANDLES = IntProperty.of("candles", 1, 3);
    public static boolean canBeLit;

    public static final VoxelShape[] SHAPES = new VoxelShape[] {
            Block.createCuboidShape(5.5, 0, 5.5, 10.5, 4, 10.5),
            Block.createCuboidShape(3, 0, 4, 13, 4, 12),
            Block.createCuboidShape(2.5, 0, 2.5, 13.5, 4, 13.5)
    };

    public CoconutCandleBlock(Settings settings) {
        super(settings);
        canBeLit = canBeLit(getDefaultState());
        this.setDefaultState(this.stateManager.getDefaultState().with(LIT, false).with(CANDLES, 1).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES[state.get(CANDLES) - 1];
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (player.getStackInHand(player.getActiveHand()).isEmpty() && state.get(LIT)) {
            extinguish(player, state, world, pos);
            return ActionResult.SUCCESS;
        }
        if ((player.getStackInHand(player.getActiveHand()).isOf(Items.FLINT_AND_STEEL) || player.getStackInHand(player.getActiveHand()).isOf(Items.FIRE_CHARGE)) && !canBeLit(state)) {
            return ActionResult.FAIL;
        } else if (player.getStackInHand(player.getActiveHand()).isOf(Items.FLINT_AND_STEEL)) {
            setLit(world, state, pos, true);
            world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            player.getStackInHand(player.getActiveHand()).damage(1, player, LivingEntity.getSlotForHand(player.getActiveHand()));
            return ActionResult.SUCCESS;
        } else if (player.getStackInHand(player.getActiveHand()).isOf(Items.FIRE_CHARGE)) {
            setLit(world, state, pos, true);
            world.playSound(null, pos, SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.BLOCKS, 1.0F, (world.random.nextFloat() - world.random.nextFloat()) * 0.2F + 1.0F);
            if (!player.isCreative()) {
                player.getStackInHand(player.getActiveHand()).decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    protected boolean canReplace(BlockState state, ItemPlacementContext context) {
        return !context.shouldCancelInteraction() && context.getStack().getItem() == this.asItem() && state.get(CANDLES) < 3 || super.canReplace(state, context);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CANDLES, LIT, WATERLOGGED);
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient && projectile.isOnFire() && !state.get(LIT)) {
            setLit(world, state, hit.getBlockPos(), true);
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }

    public static void extinguish(@Nullable PlayerEntity player, BlockState state, WorldAccess world, BlockPos pos) {
        setLit(world, state, pos, false);
        world.playSound(null, pos, SoundEvents.BLOCK_CANDLE_EXTINGUISH, SoundCategory.BLOCKS, 1.0f, 1.0f);
        world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.isOf(this)) {
            return blockState.cycle(CANDLES);
        } else {
            FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
            boolean bl = fluidState.getFluid() == Fluids.WATER;
            return super.getPlacementState(ctx).with(WATERLOGGED, bl);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!state.get(LIT)) {
            return;
        }
        if (state.get(CANDLES) == 1) {
            spawnCandleParticles(world, new Vec3d(pos.getX()+0.5, pos.getY()+0.3, pos.getZ()+0.5), random);
        } else if (state.get(CANDLES) == 2) {
            spawnCandleParticles(world, new Vec3d(pos.getX() + 0.65625, pos.getY() + 0.3, pos.getZ() + 0.59375), random);
            spawnCandleParticles(world, new Vec3d(pos.getX() + 0.3125, pos.getY() + 0.2375, pos.getZ() + 0.34375), random);
        } else {
            spawnCandleParticles(world, new Vec3d(pos.getX()+0.6875, pos.getY()+0.3, pos.getZ()+0.6875), random);
            spawnCandleParticles(world, new Vec3d(pos.getX()+0.625, pos.getY()+0.2375, pos.getZ()+0.28125), random);
            spawnCandleParticles(world, new Vec3d(pos.getX()+0.28125, pos.getY()+0.2375, pos.getZ()+0.53125), random);
        }
        if (random.nextFloat() < 0.17f) {
            world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.BLOCK_CANDLE_AMBIENT, SoundCategory.BLOCKS, 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f, false);
        }
    }

    public static boolean canBeLit(BlockState state) {
        return !state.get(LIT) || !state.get(WATERLOGGED);
    }

    static void setLit(WorldAccess world, BlockState state, BlockPos pos, boolean lit) {
        world.setBlockState(pos, state.with(LIT, lit), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
    }

    private static void spawnCandleParticles(World world, Vec3d vec3d, Random random) {
        float f = random.nextFloat();
        if (f < 0.3f) {
            world.addParticle(ParticleTypes.SMOKE, vec3d.x, vec3d.y, vec3d.z, 0.0, 0.0, 0.0);
        }
        world.addParticle(ParticleTypes.SMALL_FLAME, vec3d.x, vec3d.y, vec3d.z, 0.0, 0.0, 0.0);
    }
}
