package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.DyeableBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.definition.compat.CompatUtil;
import net.hecco.bountifulfares.definition.networking.payload.CeramicBlockColorPayload;
import net.hecco.bountifulfares.definition.networking.payload.CeramicDishEmptyPayload;
import net.hecco.bountifulfares.definition.networking.payload.CeramicDishItemPayload;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;

import static net.hecco.bountifulfares.registry.content.BFBlockEntities.CERAMIC_TILES_BLOCK_ENTITY;

public class DyeableCeramicBlock {

    private static final EnumProperty<DoubleBlockHalf> HALF = CeramicDoorBlock.HALF;
    private static final DirectionProperty FACING = CeramicDoorBlock.FACING;
    private static final BooleanProperty OPEN = CeramicDoorBlock.OPEN;
    private static final EnumProperty<DoorHingeSide> HINGE = CeramicDoorBlock.HINGE;

    public static BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DyeableCeramicBlockEntity(pos, state);
    }

    public static ItemStack getPickStack(LevelReader world, BlockPos pos, Block block) {
        if (DyeableCeramicBlockEntity.getColor(world, pos) != DyeableCeramicBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = new ItemStack(block);
            DyeableCeramicBlockEntity blockEntity = CERAMIC_TILES_BLOCK_ENTITY.get().getBlockEntity(world,pos);
            int color;
            if(blockEntity != null){
                color = blockEntity.color;
            } else {
                color = DyeableCeramicBlockEntity.DEFAULT_COLOR;
            }
            stack.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));
            return stack;
        } else {
            return new ItemStack(block);
        }
    }

    /** Sends a color payload update to all listening clients. */
    public static void sendColorPayload(ServerLevel world, BlockEntity entity, int color) {
        HLServices.NETWORK.sendToPlayersTrackingChunk(world, entity.getBlockPos(), new CeramicBlockColorPayload(entity.getBlockPos(), color));

        /*
        if (!world.isClient() && world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity) {
                sendColorPayload((ServerWorld) world, dyeableCeramicBlockEntity, brushColor);
            }
         */
    }

    /** Sends a ceramic dish payload update to all listening clients. */
    public static void sendDishPayload(ServerLevel world, BlockEntity entity, ItemStack stack) {
        HLServices.NETWORK.sendToPlayersTrackingChunk(world, entity.getBlockPos(), new CeramicDishItemPayload(entity.getBlockPos(), stack));
    }

    /** Sends a ceramic dish clear payload update to all listening clients. */
    public static void sendDishClearPayload(ServerLevel world, BlockEntity entity) {
        HLServices.NETWORK.sendToPlayersTrackingChunk(world, entity.getBlockPos(), new CeramicDishEmptyPayload(entity.getBlockPos()));
    }

    public static Block tryRevertCheckered(Block block)
    {
        if (BFBlocks.REVERT_CHECKERED_CERAMIC.containsKey(block))
        {
            return BFBlocks.REVERT_CHECKERED_CERAMIC.get(block);
        }
        return block;
    }

    /** Attempts to dye the provided block with the ceramic coloring. Meant for most single-block ceramics. */
    public static ItemInteractionResult onUse(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, Block block) {
        if (stack.is(Items.WET_SPONGE) && !player.isShiftKeyDown())
        {
            world.removeBlock(pos, false);
            Block reverterCheck = DyeableCeramicBlock.tryRevertCheckered(block);
            world.setBlock(pos, reverterCheck.withPropertiesOf(state), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SPONGE_ABSORB, SoundSource.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof DyeableBlockEntity ceramicTilesBlockEntity) {
                ceramicTilesBlockEntity.color = DyeableCeramicBlockEntity.DEFAULT_COLOR;
                ceramicTilesBlockEntity.setChanged();
                return ItemInteractionResult.SUCCESS;
            }
        }
        if (stack.is(BFItems.ARTISAN_BRUSH.get()) && !player.isShiftKeyDown() && stack.get(DataComponents.DYED_COLOR) != null) {
            int brushColor = stack.getComponents().get(DataComponents.DYED_COLOR).rgb();
            world.removeBlock(pos, false);
            world.setBlock(pos, block.withPropertiesOf(state), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof DyeableBlockEntity ceramicTilesBlockEntity) {
                ceramicTilesBlockEntity.color = brushColor;
                ceramicTilesBlockEntity.setChanged();
                return ItemInteractionResult.SUCCESS;
            }
        }
        if (HLServices.PLATFORM.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
            Item item = stack.getItem();
            if (CompatUtil.isItemPaintbrush(item)) {
                int brushColor = CompatUtil.getIntColorFromPaintbrush(item);
                if (brushColor != 1) {
                    world.removeBlock(pos, false);
                    world.setBlock(pos, block.withPropertiesOf(state), 2);
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
                    if (world.getBlockEntity(pos) instanceof DyeableBlockEntity ceramicTilesBlockEntity) {
                        ceramicTilesBlockEntity.color = brushColor;
                        ceramicTilesBlockEntity.setChanged();
                        return ItemInteractionResult.SUCCESS;
                    }
                }
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    /** Attempts to dye the provided dish with the ceramic coloring, while keeping its contents intact. Meant for ceramic dishes. */
    public static ItemInteractionResult onUseForDish(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, Block block, CeramicDishBlockEntity dish) {
        ItemStack stackEntity = dish.getItem(0).copy();
        if (stack.is(Items.WET_SPONGE) && !player.isShiftKeyDown()) {
            dish.setItem(0, ItemStack.EMPTY);
            world.removeBlock(pos, false);
            world.setBlock(pos, block.withPropertiesOf(state), 2);

            CeramicDishBlockEntity newDish = (CeramicDishBlockEntity) world.getBlockEntity(pos);
            if (newDish != null)
            {
                newDish.insertItem(stackEntity);
            }

            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SPONGE_ABSORB, SoundSource.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            return ItemInteractionResult.SUCCESS;
        }
        if (stack.is(BFItems.ARTISAN_BRUSH.get()) && !player.isShiftKeyDown() && stack.get(DataComponents.DYED_COLOR) != null) {
            int brushColor = stack.getComponents().get(DataComponents.DYED_COLOR).rgb();
            dish.setItem(0, ItemStack.EMPTY);
            world.removeBlock(pos, false);
            world.setBlock(pos, block.withPropertiesOf(state), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity ceramicDishBlockEntity) {
                ceramicDishBlockEntity.color = brushColor;
                ceramicDishBlockEntity.setChanged();
            }

            CeramicDishBlockEntity newDish = (CeramicDishBlockEntity) world.getBlockEntity(pos);
            if (newDish != null)
            {
                newDish.insertItem(stackEntity);
            }

            return ItemInteractionResult.SUCCESS;
        }
        if (HLServices.PLATFORM.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
            Item item = stack.getItem();
            if (CompatUtil.isItemPaintbrush(item)) {
                int brushColor = CompatUtil.getIntColorFromPaintbrush(item);
                if (brushColor != 1) {
                    dish.setItem(0, ItemStack.EMPTY);
                    world.removeBlock(pos, false);
                    world.setBlock(pos, block.withPropertiesOf(state), 2);
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
                    if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity ceramicDishBlockEntity) {
                        ceramicDishBlockEntity.color = brushColor;
                        ceramicDishBlockEntity.setChanged();
                    }

                    CeramicDishBlockEntity newDish = (CeramicDishBlockEntity) world.getBlockEntity(pos);
                    if (newDish != null)
                    {
                        newDish.insertItem(stackEntity);
                    }

                    return ItemInteractionResult.SUCCESS;
                }
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    /** Attempts to dye the provided door with the ceramic coloring, and then dye its opposite piece. Meant for ceramic doors. */
    public static ItemInteractionResult onUseForDoor(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, Block block, CeramicDoorBlock door) {
        int brushColor = DyeableCeramicBlockEntity.DEFAULT_COLOR;
        SoundEvent playedSFX = SoundEvents.DYE_USE;
        boolean changes_made = false;

        if (stack.is(Items.WET_SPONGE) && !player.isShiftKeyDown())
        {
            brushColor = DyeableCeramicBlockEntity.DEFAULT_COLOR;
            playedSFX = SoundEvents.SPONGE_ABSORB;
            changes_made = true;
        }
        else if (stack.is(BFItems.ARTISAN_BRUSH.get()) && !player.isShiftKeyDown() && stack.get(DataComponents.DYED_COLOR) != null) {
            brushColor = stack.getComponents().get(DataComponents.DYED_COLOR).rgb();
            changes_made = true;
        }
        else if (HLServices.PLATFORM.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
            Item item = stack.getItem();
            if (CompatUtil.isItemPaintbrush(item)) {
                int compatGet = CompatUtil.getIntColorFromPaintbrush(item);
                if (compatGet != 1) {
                    brushColor = compatGet;
                    changes_made = true;
                }
            }
        }

        if (changes_made) {
            if (state.getValue(HALF) == DoubleBlockHalf.LOWER && world.getBlockState(pos.above()).is(door)) {
                world.removeBlock(pos.above(), false);
                world.setBlock(pos.above(), door.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(OPEN, state.getValue(OPEN)).setValue(HINGE, state.getValue(HINGE)), 2);
                if (world.getBlockEntity(pos.above()) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity) {
                    dyeableCeramicBlockEntity.color = brushColor;
                    dyeableCeramicBlockEntity.setChanged();
                }
            }
            if (state.getValue(HALF) == DoubleBlockHalf.UPPER && world.getBlockState(pos.below()).is(door)) {
                world.removeBlock(pos.below(), false);
                world.setBlock(pos.below(), door.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(OPEN, state.getValue(OPEN)).setValue(HINGE, state.getValue(HINGE)), 2);
                if (world.getBlockEntity(pos.below()) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity) {
                    dyeableCeramicBlockEntity.color = brushColor;
                    dyeableCeramicBlockEntity.setChanged();
                }
            }
            world.removeBlock(pos, false);
            world.setBlock(pos, door.withPropertiesOf(state), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), playedSFX, SoundSource.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));

            if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity) {
                dyeableCeramicBlockEntity.color = brushColor;
                dyeableCeramicBlockEntity.setChanged();
            }
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
