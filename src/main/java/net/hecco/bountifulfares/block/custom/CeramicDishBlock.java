package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.block.interfaces.CeramicDishBlockInterface;
import net.hecco.bountifulfares.compat.CompatUtil;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
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

public class CeramicDishBlock extends Block implements BlockEntityProvider, Waterloggable, CeramicDishBlockInterface {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public CeramicDishBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
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
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack item = player.getStackInHand(player.getActiveHand());
        if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity blockEntity) {
            ItemStack itemStack = player.getStackInHand(player.getActiveHand());
            ItemStack stack = blockEntity.getStack(0);
            if (itemStack.isOf(BFItems.ARTISAN_BRUSH) && itemStack.getComponents().contains(DataComponentTypes.DYED_COLOR) && blockEntity.getStack(0).isEmpty()) {
                int brushColor = itemStack.getComponents().get(DataComponentTypes.DYED_COLOR).rgb();
                world.removeBlock(pos, true);
                world.setBlockState(pos, this.getStateWithProperties(state));
                blockEntity.insertItem(stack);
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
                if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity ceramicDishBlockEntity && ceramicDishBlockEntity.color != brushColor) {
                    ceramicDishBlockEntity.color = brushColor;
                    ceramicDishBlockEntity.markDirty();
                    return ActionResult.SUCCESS;

                }
            } else if (BountifulFares.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
                if (CompatUtil.isItemPaintbrush(item.getItem()) && blockEntity.getStack(0).isEmpty()) {
                    int brushColor = CompatUtil.getIntColorFromPaintbrush(item.getItem());
                    if (brushColor != 1) {
                        world.removeBlock(pos, false);
                        world.setBlockState(pos, this.getStateWithProperties(state));
                        world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
                        if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity ceramicDishBlockEntity && ceramicDishBlockEntity.color != brushColor) {
                            ceramicDishBlockEntity.color = brushColor;
                            ceramicDishBlockEntity.markDirty();
                            return ActionResult.SUCCESS;

                        }
                    }
                }
            } else if (!item.isEmpty() && blockEntity.canInsertItem()) {
                blockEntity.insertItem(item);
                if (!player.isCreative()) {
                    item.decrement(1);
                }
                return ActionResult.SUCCESS;
            } else if (!stack.isEmpty()) {
                if (player.isSneaking() && item.isEmpty()) {
                    player.setStackInHand(player.getActiveHand(), stack);
                    blockEntity.removeItem();
                    blockEntity.markDirty();
                    return ActionResult.SUCCESS;
                } else if (canEatOnDish(stack)) {
                    boolean shouldIgnore = stack.getComponents().get(DataComponentTypes.FOOD).canAlwaysEat();
                    if (player.canConsume(shouldIgnore)) {
//                        int hunger = Objects.requireNonNull(stack.getComponents().get(DataComponentTypes.FOOD)).nutrition();
//                        float sat = Objects.requireNonNull(stack.getComponents().get(DataComponentTypes.FOOD)).saturation();
//                        List<FoodComponent.StatusEffectEntry> effects = Objects.requireNonNull(stack.getComponents().get(DataComponentTypes.FOOD)).effects();
//                        player.getHungerManager().add(hunger, sat);
                        world.playSound(null, pos, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.BLOCKS, 0.3f, 1.0f);
//                        if (stack.getItem() instanceof AirTimeIncreasingItem) {
//                            int air = player.getAir();
//                            int maxAir = player.getMaxAir();
//                            if (air < maxAir - AirTimeIncreasingItem.airTickIncrease){
//                                player.setAir(air + AirTimeIncreasingItem.airTickIncrease);
//                            } else {
//                                player.setAir(maxAir);
//                            }
//                        }
//                        if (stack.isOf(Items.CHORUS_FRUIT)) {
//                            chorusTeleport(world, player);
//                        }
//                        for (FoodComponent.StatusEffectEntry statusEffectEntry : effects) {
//                            StatusEffectInstance effect = statusEffectEntry.effect();
//                            int length = effect.getDuration();
//                            int amplifier = effect.getAmplifier();
//                            StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), length, amplifier);
//                            player.addStatusEffect(newEffect);
//                        }
                        for (int i = 0; i < 4 + world.random.nextBetween(0, 4); i++) {
                            world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, stack), pos.getX() + world.random.nextGaussian() / 12 + 0.5, pos.getY() + 0.2, pos.getZ() + world.random.nextGaussian() / 12 + 0.5, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
                        }

                        stack.getItem().finishUsing(stack, world, player);

                        if (stack.getRecipeRemainder().getItem() != Items.AIR) {
                            blockEntity.insertItem(stack.getRecipeRemainder());
                        } else {
                            blockEntity.removeItem();
                        }
                        blockEntity.markDirty();
                        return ActionResult.SUCCESS;
                    }
                }
            }

        }
        return ActionResult.PASS;
    }

    public static boolean canEatOnDish(ItemStack stack) {
        if (stack.getComponents().get(DataComponentTypes.FOOD) != null) {
            if (BountifulFares.CONFIG.isContainerFoodsEatableOnDish()) {
                return true;
            } else if (stack.getRecipeRemainder().getItem() == Items.AIR) {
                return true;
            }
        }
        return false;
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
