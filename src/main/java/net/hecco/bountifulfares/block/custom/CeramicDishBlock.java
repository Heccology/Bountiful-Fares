package net.hecco.bountifulfares.block.custom;

import com.mojang.datafixers.util.Pair;
import net.hecco.bountifulfares.block.interfaces.CeramicDishBlockInterface;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.hecco.bountifulfares.item.custom.SpongekinSliceItem;
import net.hecco.bountifulfares.util.BFItemTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class CeramicDishBlock extends Block implements BlockEntityProvider, Waterloggable, CeramicDishBlockInterface {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public CeramicDishBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        if (CeramicDishBlockEntity.getColor(world, pos) != CeramicDishBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = super.getPickStack(world, pos, state);
            return pickBlock(world,pos,stack);
        } else {
            return new ItemStack(BFBlocks.CERAMIC_DISH);
        }
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
            ItemStack itemStack = player.getStackInHand(hand);
            ItemStack stack = blockEntity.getStack(0);
            if (itemStack.isOf(BFItems.ARTISAN_BRUSH) && itemStack.getSubNbt(ArtisanBrushItem.DISPLAY_KEY) != null) {
                int brushColor = itemStack.getSubNbt(ArtisanBrushItem.DISPLAY_KEY).getInt(ArtisanBrushItem.COLOR_KEY);
                world.removeBlock(pos, false);
                world.setBlockState(pos, this.getStateWithProperties(state));
                blockEntity.insertItem(stack);
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
                if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity ceramicDishBlockEntity && ceramicDishBlockEntity.color != brushColor) {
                    ceramicDishBlockEntity.color = brushColor;
                    ceramicDishBlockEntity.markDirty();
                    return ActionResult.SUCCESS;

                }
            } else if (!item.isEmpty() && blockEntity.canInsertItem()) {
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
                } else if (stack.isIn(BFItemTags.EATABLE_ON_DISH) && stack.isFood()) {
                    boolean shouldIgnore = stack.getItem().getFoodComponent().isAlwaysEdible();
                    if (player.canConsume(shouldIgnore)) {
                        int hunger = Objects.requireNonNull(stack.getItem().getFoodComponent()).getHunger();
                        float sat = stack.getItem().getFoodComponent().getSaturationModifier();
                        List<Pair<StatusEffectInstance, Float>> effects = stack.getItem().getFoodComponent().getStatusEffects();
                        player.getHungerManager().add(hunger, sat);
                        world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 0.5f, 0.8f + world.random.nextFloat());
                        world.playSound(null, pos, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.BLOCKS, 0.3f, 1.0f);
                        if (stack.isOf(BFItems.SPONGEKIN_SLICE)) {
                            int air = player.getAir();
                            int maxAir = player.getMaxAir();
                            if (air < maxAir - SpongekinSliceItem.airTickIncrease){
                                player.setAir(air + SpongekinSliceItem.airTickIncrease);
                            } else {
                                player.setAir(maxAir);
                            }
                        }
                        if (stack.isOf(Items.CHORUS_FRUIT)) {
                            chorusTeleport(world, player);
                        }
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

        }
        return ActionResult.PASS;
    }


    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CeramicDishBlockEntity entity) {
                dropStack(world, pos, entity.getStack(0));
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
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

    public void chorusTeleport(World world, LivingEntity user) {
        if (!world.isClient) {
            double d = user.getX();
            double e = user.getY();
            double f = user.getZ();

            for(int i = 0; i < 16; ++i) {
                double g = user.getX() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                double h = MathHelper.clamp(user.getY() + (double)(user.getRandom().nextInt(16) - 8), (double)world.getBottomY(), (double)(world.getBottomY() + ((ServerWorld)world).getLogicalHeight() - 1));
                double j = user.getZ() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                if (user.hasVehicle()) {
                    user.stopRiding();
                }

                Vec3d vec3d = user.getPos();
                if (user.teleport(g, h, j, true)) {
                    world.emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(user));
                    SoundEvent soundEvent = user instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                    world.playSound((PlayerEntity)null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    user.playSound(soundEvent, 1.0F, 1.0F);
                    break;
                }
            }
        }
    }
}
