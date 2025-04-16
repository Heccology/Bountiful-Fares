package net.hecco.bountifulfares.block.custom;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.block.entity.DyeableBlockEntity;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.compat.CompatUtil;
import net.hecco.bountifulfares.networking.payload.CeramicBlockColorPayload;
import net.hecco.bountifulfares.networking.payload.CeramicDishEmptyPayload;
import net.hecco.bountifulfares.networking.payload.CeramicDishItemPayload;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.apache.logging.log4j.core.jmx.Server;

import static net.hecco.bountifulfares.registry.content.BFBlockEntities.CERAMIC_TILES_BLOCK_ENTITY;

public class DyeableCeramicBlock {

    private static final EnumProperty<DoubleBlockHalf> HALF = CeramicDoorBlock.HALF;
    private static final DirectionProperty FACING = CeramicDoorBlock.FACING;
    private static final BooleanProperty OPEN = CeramicDoorBlock.OPEN;
    private static final EnumProperty<DoorHinge> HINGE = CeramicDoorBlock.HINGE;

    public static BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DyeableCeramicBlockEntity(pos, state);
    }

    public static ItemStack getPickStack(WorldView world, BlockPos pos, Block block) {
        if (DyeableCeramicBlockEntity.getColor(world, pos) != DyeableCeramicBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = new ItemStack(block);
            DyeableCeramicBlockEntity blockEntity = CERAMIC_TILES_BLOCK_ENTITY.get(world,pos);
            int color;
            if(blockEntity != null){
                color = blockEntity.color;
            } else {
                color = DyeableCeramicBlockEntity.DEFAULT_COLOR;
            }
            stack.set(DataComponentTypes.DYED_COLOR, new DyedColorComponent(color, true));
            return stack;
        } else {
            return new ItemStack(block);
        }
    }

    /** Sends a color payload update to all listening clients. */
    public static void sendColorPayload(ServerWorld world, BlockEntity entity, int color)
    {
        for (ServerPlayerEntity targeter : PlayerLookup.tracking(world, entity.getPos())) {
            ServerPlayNetworking.send(targeter, new CeramicBlockColorPayload(entity.getPos(), color));
        }

        /*
        if (!world.isClient() && world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity) {
                sendColorPayload((ServerWorld) world, dyeableCeramicBlockEntity, brushColor);
            }
         */
    }

    /** Sends a ceramic dish payload update to all listening clients. */
    public static void sendDishPayload(ServerWorld world, BlockEntity entity, ItemStack stack)
    {
        for (ServerPlayerEntity targeter : PlayerLookup.tracking(world, entity.getPos())) {
            ServerPlayNetworking.send(targeter, new CeramicDishItemPayload(entity.getPos(), stack));
        }
    }

    /** Sends a ceramic dish clear payload update to all listening clients. */
    public static void sendDishClearPayload(ServerWorld world, BlockEntity entity)
    {
        for (ServerPlayerEntity targeter : PlayerLookup.tracking(world, entity.getPos())) {
            ServerPlayNetworking.send(targeter, new CeramicDishEmptyPayload(entity.getPos()));
        }
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
    public static ItemActionResult onUse(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, Block block) {
        if (stack.isOf(Items.WET_SPONGE) && !player.isSneaking())
        {
            world.removeBlock(pos, false);
            Block reverterCheck = DyeableCeramicBlock.tryRevertCheckered(block);
            world.setBlockState(pos, reverterCheck.getStateWithProperties(state), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_SPONGE_ABSORB, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof DyeableBlockEntity ceramicTilesBlockEntity) {
                ceramicTilesBlockEntity.color = DyeableCeramicBlockEntity.DEFAULT_COLOR;
                ceramicTilesBlockEntity.markDirty();
                return ItemActionResult.SUCCESS;
            }
        }
        if (stack.isOf(BFItems.ARTISAN_BRUSH) && !player.isSneaking() && stack.get(DataComponentTypes.DYED_COLOR) != null) {
            int brushColor = stack.getComponents().get(DataComponentTypes.DYED_COLOR).rgb();
            world.removeBlock(pos, false);
            world.setBlockState(pos, block.getStateWithProperties(state), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof DyeableBlockEntity ceramicTilesBlockEntity) {
                ceramicTilesBlockEntity.color = brushColor;
                ceramicTilesBlockEntity.markDirty();
                return ItemActionResult.SUCCESS;
            }
        }
        if (BountifulFares.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
            Item item = stack.getItem();
            if (CompatUtil.isItemPaintbrush(item)) {
                int brushColor = CompatUtil.getIntColorFromPaintbrush(item);
                if (brushColor != 1) {
                    world.removeBlock(pos, false);
                    world.setBlockState(pos, block.getStateWithProperties(state), 2);
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
                    if (world.getBlockEntity(pos) instanceof DyeableBlockEntity ceramicTilesBlockEntity) {
                        ceramicTilesBlockEntity.color = brushColor;
                        ceramicTilesBlockEntity.markDirty();
                        return ItemActionResult.SUCCESS;
                    }
                }
            }
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    /** Attempts to dye the provided dish with the ceramic coloring, while keeping its contents intact. Meant for ceramic dishes. */
    public static ItemActionResult onUseForDish(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, Block block, CeramicDishBlockEntity dish) {
        ItemStack stackEntity = dish.getStack(0).copy();
        if (stack.isOf(Items.WET_SPONGE) && !player.isSneaking())
        {
            dish.setStack(0, ItemStack.EMPTY);
            world.removeBlock(pos, false);
            world.setBlockState(pos, block.getStateWithProperties(state), 2);

            CeramicDishBlockEntity newDish = (CeramicDishBlockEntity) world.getBlockEntity(pos);
            if (newDish != null)
            {
                newDish.insertItem(stackEntity);
            }

            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_SPONGE_ABSORB, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            return ItemActionResult.SUCCESS;
        }
        if (stack.isOf(BFItems.ARTISAN_BRUSH) && !player.isSneaking() && stack.get(DataComponentTypes.DYED_COLOR) != null) {
            int brushColor = stack.getComponents().get(DataComponentTypes.DYED_COLOR).rgb();
            dish.setStack(0, ItemStack.EMPTY);
            world.removeBlock(pos, false);
            world.setBlockState(pos, block.getStateWithProperties(state), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity ceramicDishBlockEntity) {
                ceramicDishBlockEntity.color = brushColor;
                ceramicDishBlockEntity.markDirty();
            }

            CeramicDishBlockEntity newDish = (CeramicDishBlockEntity) world.getBlockEntity(pos);
            if (newDish != null)
            {
                newDish.insertItem(stackEntity);
            }

            return ItemActionResult.SUCCESS;
        }
        if (BountifulFares.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
            Item item = stack.getItem();
            if (CompatUtil.isItemPaintbrush(item)) {
                int brushColor = CompatUtil.getIntColorFromPaintbrush(item);
                if (brushColor != 1) {
                    dish.setStack(0, ItemStack.EMPTY);
                    world.removeBlock(pos, false);
                    world.setBlockState(pos, block.getStateWithProperties(state), 2);
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
                    if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity ceramicDishBlockEntity) {
                        ceramicDishBlockEntity.color = brushColor;
                        ceramicDishBlockEntity.markDirty();
                    }

                    CeramicDishBlockEntity newDish = (CeramicDishBlockEntity) world.getBlockEntity(pos);
                    if (newDish != null)
                    {
                        newDish.insertItem(stackEntity);
                    }

                    return ItemActionResult.SUCCESS;
                }
            }
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    /** Attempts to dye the provided door with the ceramic coloring, and then dye its opposite piece. Meant for ceramic doors. */
    public static ItemActionResult onUseForDoor(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, Block block, CeramicDoorBlock door) {
        int brushColor = DyeableCeramicBlockEntity.DEFAULT_COLOR;
        SoundEvent playedSFX = SoundEvents.ITEM_DYE_USE;
        boolean changes_made = false;

        if (stack.isOf(Items.WET_SPONGE) && !player.isSneaking())
        {
            brushColor = DyeableCeramicBlockEntity.DEFAULT_COLOR;
            playedSFX = SoundEvents.BLOCK_SPONGE_ABSORB;
            changes_made = true;
        }
        else if (stack.isOf(BFItems.ARTISAN_BRUSH) && !player.isSneaking() && stack.get(DataComponentTypes.DYED_COLOR) != null) {
            brushColor = stack.getComponents().get(DataComponentTypes.DYED_COLOR).rgb();
            changes_made = true;
        }
        else if (BountifulFares.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
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
            if (state.get(HALF) == DoubleBlockHalf.LOWER && world.getBlockState(pos.up()).isOf(door)) {
                world.removeBlock(pos.up(), false);
                world.setBlockState(pos.up(), door.getDefaultState().with(FACING, state.get(FACING)).with(HALF, DoubleBlockHalf.UPPER).with(OPEN, state.get(OPEN)).with(HINGE, state.get(HINGE)), 2);
                if (world.getBlockEntity(pos.up()) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity) {
                    dyeableCeramicBlockEntity.color = brushColor;
                    dyeableCeramicBlockEntity.markDirty();
                }
            }
            if (state.get(HALF) == DoubleBlockHalf.UPPER && world.getBlockState(pos.down()).isOf(door)) {
                world.removeBlock(pos.down(), false);
                world.setBlockState(pos.down(), door.getDefaultState().with(FACING, state.get(FACING)).with(HALF, DoubleBlockHalf.LOWER).with(OPEN, state.get(OPEN)).with(HINGE, state.get(HINGE)), 2);
                if (world.getBlockEntity(pos.down()) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity) {
                    dyeableCeramicBlockEntity.color = brushColor;
                    dyeableCeramicBlockEntity.markDirty();
                }
            }
            world.removeBlock(pos, false);
            world.setBlockState(pos, door.getStateWithProperties(state), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), playedSFX, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));

            if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity) {
                dyeableCeramicBlockEntity.color = brushColor;
                dyeableCeramicBlockEntity.markDirty();
            }
            return ItemActionResult.SUCCESS;
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
