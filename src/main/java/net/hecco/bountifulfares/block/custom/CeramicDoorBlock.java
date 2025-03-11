package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.compat.CompatUtil;
import net.hecco.bountifulfares.item.custom.DyeableCeramicBlockItem;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class CeramicDoorBlock extends DoorBlock implements BlockEntityProvider {
    private final BlockSetType blockSetType;

    public CeramicDoorBlock(Settings settings, BlockSetType blockSetType) {
        super(blockSetType, settings);
        this.blockSetType = blockSetType;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.createBlockEntity(pos, state);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(player.getActiveHand());
        int brushColor = 1;
        if (BountifulFares.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
            Item item = player.getStackInHand(player.getActiveHand()).getItem();
            if (CompatUtil.isItemPaintbrush(item)) {
                brushColor = CompatUtil.getIntColorFromPaintbrush(item);
            } else if (itemStack.isOf(BFItems.ARTISAN_BRUSH) && !player.isSneaking() && itemStack.getComponents().contains(DataComponentTypes.DYED_COLOR)) {
                brushColor = itemStack.getComponents().get(DataComponentTypes.DYED_COLOR).rgb();
            }
        } else if (itemStack.isOf(BFItems.ARTISAN_BRUSH) && !player.isSneaking() && itemStack.getComponents().contains(DataComponentTypes.DYED_COLOR)) {
            brushColor = itemStack.getComponents().get(DataComponentTypes.DYED_COLOR).rgb();
        }
        if (brushColor != 1 && !player.isSneaking()) {
            if (state.get(HALF) == DoubleBlockHalf.LOWER && world.getBlockState(pos.up()).isOf(this)) {
                world.setBlockState(pos.up(), this.getDefaultState().with(FACING, state.get(FACING)).with(HALF, DoubleBlockHalf.UPPER).with(OPEN, state.get(OPEN)).with(HINGE, state.get(HINGE)), 0);
                if (world.getBlockEntity(pos.up()) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                    dyeableCeramicBlockEntity.color = brushColor;
                    dyeableCeramicBlockEntity.markDirty();
                }
            }
            if (state.get(HALF) == DoubleBlockHalf.UPPER && world.getBlockState(pos.down()).isOf(this)) {
                world.setBlockState(pos.down(), this.getDefaultState().with(FACING, state.get(FACING)).with(HALF, DoubleBlockHalf.LOWER).with(OPEN, state.get(OPEN)).with(HINGE, state.get(HINGE)), 0);
                if (world.getBlockEntity(pos.down()) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                    dyeableCeramicBlockEntity.color = brushColor;
                    dyeableCeramicBlockEntity.markDirty();
                }
            }
            world.removeBlock(pos, false);
            world.setBlockState(pos, this.getStateWithProperties(state), 0);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                dyeableCeramicBlockEntity.color = brushColor;
                dyeableCeramicBlockEntity.markDirty();
                return ActionResult.SUCCESS;
            }
        }
        if (BountifulFares.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
            Item item = player.getStackInHand(player.getActiveHand()).getItem();
            if (CompatUtil.isItemPaintbrush(item)) {
                return ActionResult.SUCCESS;
            }
        }
        if (!state.get(POWERED)) {
            if (!this.blockSetType.canOpenByHand()) {
                return ActionResult.PASS;
            } else {
                state = state.cycle(OPEN);
                world.setBlockState(pos, state, 10);
                this.playOpenCloseSound(player, world, pos, state.get(OPEN));
                world.emitGameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
                return ActionResult.success(world.isClient);
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        DyeableCeramicBlockEntity entity = (DyeableCeramicBlockEntity) world.getBlockEntity(pos);
        DyeableCeramicBlockEntity topentity = (DyeableCeramicBlockEntity) world.getBlockEntity(pos.up());
        DyeableCeramicBlockEntity bottomentity = (DyeableCeramicBlockEntity) world.getBlockEntity(pos.down());
        if (doubleBlockHalf == DoubleBlockHalf.LOWER && world.getBlockState(pos.up()).isOf(this) && entity.color == topentity.color) {
            if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
                return neighborState.isOf(this) && neighborState.get(HALF) != doubleBlockHalf ? state.with(FACING, neighborState.get(FACING)).with(OPEN, neighborState.get(OPEN)).with(HINGE, neighborState.get(HINGE)).with(POWERED, neighborState.get(POWERED)) : Blocks.AIR.getDefaultState();
            } else {
                if (direction == Direction.DOWN && !state.canPlaceAt(world, pos)) {
                    world.scheduleBlockTick(pos.up(), this, 1);
                    return Blocks.AIR.getDefaultState();
                } else {
                    return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
                }
            }
        }
        if (doubleBlockHalf == DoubleBlockHalf.UPPER && world.getBlockState(pos.down()).isOf(this) && entity.color == bottomentity.color) {
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
        return state;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (!this.getDefaultState().isOf(sourceBlock) && bl != state.get(POWERED)) {
            if (bl != state.get(POWERED)) {
                if (!state.get(POWERED)) {
                    state = state.cycle(OPEN);
                    this.playOpenCloseSound(null, world, pos, bl);
                }
                world.setBlockState(pos, state.with(POWERED, bl), 2);
            }
//            if (!state.get(POWERED)) {
//                if (bl != state.get(OPEN)) {
//                    this.playOpenCloseSound(null, world, pos, bl);
//                    world.emitGameEvent(null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
//                }
//
//                world.setBlockState(pos, (state.with(POWERED, bl)).cycle(OPEN), 2);
//            }
        }

    }

    private void playOpenCloseSound(@Nullable Entity entity, World world, BlockPos pos, boolean open) {
        world.playSound(entity, pos, open ? this.blockSetType.doorOpen() : this.blockSetType.doorClose(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
        if (world.getBlockEntity(pos.up()) instanceof DyeableCeramicBlockEntity entity) {
            DyeableCeramicBlockItem thisEntity = (DyeableCeramicBlockItem) itemStack.getItem();
            if (thisEntity.getComponents().get(DataComponentTypes.DYED_COLOR) != null) {
                entity.color = thisEntity.getComponents().get(DataComponentTypes.DYED_COLOR).rgb();
            }
            entity.markDirty();
        }
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (state.get(HALF) == DoubleBlockHalf.LOWER && world.getBlockState(pos.up()).isOf(this)) {
            world.scheduleBlockTick(pos.up(), this, 1);
        }
        if (state.get(HALF) == DoubleBlockHalf.UPPER && world.getBlockState(pos.down()).isOf(this)) {
            world.scheduleBlockTick(pos.down(), this, 1);
        }
        return super.onBreak(world, pos, state, player);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.breakBlock(pos, true);
        super.scheduledTick(state, world, pos, random);
    }
}

