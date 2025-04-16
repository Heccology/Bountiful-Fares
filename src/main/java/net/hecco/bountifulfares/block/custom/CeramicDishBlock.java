package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.block.interfaces.CeramicDishBlockInterface;
import net.hecco.bountifulfares.compat.CompatUtil;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
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
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
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
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity blockEntity) {
            ItemStack stackEntity = blockEntity.getStack(0);
            ItemActionResult BRUSH_PASS = DyeableCeramicBlock.onUseForDish(stack, state, world, pos, player, hand, state.getBlock(), blockEntity);

            if (BRUSH_PASS.isAccepted())
            {
                return BRUSH_PASS;
            }
            else if (!stack.isEmpty() && blockEntity.canInsertItem()) {
                blockEntity.insertItem(stack);
                if (!player.isCreative()) {
                    stack.decrement(1);
                }
                world.playSoundAtBlockCenter(pos, BFSounds.CERAMIC_DISH_INTERACT, SoundCategory.PLAYERS, 1.0f, 0.8f + world.random.nextFloat() / 4, true);
                blockEntity.markDirty();
                return ItemActionResult.SUCCESS;
            }
            else if (!stackEntity.isEmpty()) {
                if (player.isSneaking() && stack.isEmpty()) {
                    player.setStackInHand(hand, stackEntity);
                    blockEntity.removeItem();
                    world.playSoundAtBlockCenter(pos, BFSounds.CERAMIC_DISH_INTERACT, SoundCategory.PLAYERS, 1.0f, 0.8f + world.random.nextFloat() / 4, true);
                    blockEntity.markDirty();
                    return ItemActionResult.SUCCESS;
                }
                else if (canEatOnDish(stackEntity)) {
                    FoodComponent check = stackEntity.getComponents().get(DataComponentTypes.FOOD);
                    boolean shouldIgnore = check != null && check.canAlwaysEat();
                    if (player.canConsume(shouldIgnore)) {
                        world.playSound(null, pos, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.BLOCKS, 0.3f, 1.0f);

                        for (int i = 0; i < 4 + world.random.nextBetween(0, 4); i++) {
                            world.addParticle(new ItemStackParticleEffect(
                                    ParticleTypes.ITEM, stackEntity),
                                    pos.getX() + world.random.nextGaussian() / 12 + 0.5,
                                    pos.getY() + 0.2,
                                    pos.getZ() + world.random.nextGaussian() / 12 + 0.5,
                                    (world.random.nextFloat() - 0.5) / 8,
                                    (world.random.nextFloat() - 0.5) / 8,
                                    (world.random.nextFloat() - 0.5) / 8);
                        }

                        stackEntity.getItem().finishUsing(stackEntity, world, player);

                        if (stackEntity.getRecipeRemainder().getItem() != Items.AIR) {
                            blockEntity.insertItem(stackEntity.getRecipeRemainder());
                        } else {
                            blockEntity.removeItem();
                        }
                        blockEntity.markDirty();
                        return ItemActionResult.SUCCESS;
                    }
                }
            }
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
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
