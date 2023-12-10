package net.hecco.bountifulcuisine.block.custom;

import com.mojang.datafixers.util.Pair;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulcuisine.util.ModItemTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class CeramicDishBlock extends Block implements BlockEntityProvider, Waterloggable {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public CeramicDishBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(3, 0, 3, 13, 1, 13);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack item = player.getStackInHand(hand);
        if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity blockEntity) {
            ItemStack stack = blockEntity.getStack(0);
            if (!item.isEmpty() && blockEntity.canInsertItem()) {
                blockEntity.insertItem(item);
                if (!player.isCreative()) {
                    item.decrement(1);
                }
                return ActionResult.SUCCESS;
            } else if (!stack.isEmpty()) {
                if (player.isSneaking() && item.isEmpty()) {
                    player.setStackInHand(hand, stack);
                    blockEntity.removeItem();
                    blockEntity.markDirty();
                    return ActionResult.SUCCESS;
                } else if (stack.isIn(ModItemTags.EATABLE_ON_DISH)) {
                    boolean shouldIgnore = stack.getItem().getFoodComponent().isAlwaysEdible();
                    if (player.canConsume(shouldIgnore)) {
                        int hunger = Objects.requireNonNull(stack.getItem().getFoodComponent()).getHunger();
                        float sat = stack.getItem().getFoodComponent().getSaturationModifier();
                        List<Pair<StatusEffectInstance, Float>> effects = stack.getItem().getFoodComponent().getStatusEffects();
                        player.getHungerManager().add(hunger, sat);
                        world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 0.5f, 0.8f + world.random.nextFloat());
                        world.playSound(null, pos, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.BLOCKS, 0.4f, 1.0f);
                        for (int i = 0; i < effects.size(); i++) {
                            StatusEffectInstance effect = effects.get(i).getFirst();
                            int length = effect.getDuration();
                            int amplifier = effect.getAmplifier();
                            StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), length, amplifier);
                            player.addStatusEffect(newEffect);
                        }
                        for (int i = 0; i < 4 + world.random.nextBetween(0, 4); i++) {
                            world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, stack), pos.getX() + world.random.nextGaussian() / 12 + 0.5, pos.getY() + 0.2, pos.getZ() + world.random.nextGaussian() / 12 + 0.5, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
                        }
                        blockEntity.removeItem();
                        blockEntity.markDirty();
                        return ActionResult.SUCCESS;
                    }
                }
            }
//            else if (!item.isEmpty() && stack. == item.getItem().getDefaultStack()) {
//                if (!player.isCreative()) {
//                    item.decrement(1);
//                }
//                blockEntity.removeItem();
//                blockEntity.markDirty();
//                return ActionResult.SUCCESS;
//            }
        }
        return ActionResult.PASS;
    }

    public boolean canMobSpawnInside(BlockState state) {
        return true;
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return hasTopRim(world, blockPos) || sideCoversSmallSquare(world, blockPos, Direction.UP);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CeramicDishBlockEntity(pos, state);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = fluidState.getFluid() == Fluids.WATER;
        return super.getPlacementState(ctx).with(WATERLOGGED, bl).with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }
}
