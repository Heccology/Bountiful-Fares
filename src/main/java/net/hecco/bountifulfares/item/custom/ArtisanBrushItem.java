package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class ArtisanBrushItem extends Item implements DyeableItem {
    public int DefColor = DyeableCeramicBlockEntity.DEFAULT_COLOR;
    public ArtisanBrushItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt(DISPLAY_KEY);
        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY, NbtElement.NUMBER_TYPE)) {
            return nbtCompound.getInt(COLOR_KEY);
        }
        return DefColor;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        BlockState current = world.getBlockState(pos);
        int oldColor = DyeableCeramicBlockEntity.getColor(world, pos);
        if (ModBlocks.CERAMIC_TO_CHECKERED_CERAMIC.containsKey(current.getBlock()) && DyeableCeramicBlockEntity.getColor(world, pos) != DyeableCeramicBlockEntity.DEFAULT_COLOR) {
            world.setBlockState(pos, ModBlocks.CERAMIC_TO_CHECKERED_CERAMIC.get(current.getBlock()).getStateWithProperties(current));
            BountifulFares.LOGGER.info("correct block!");
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_UP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity ceramicTilesBlockEntity) {
                ceramicTilesBlockEntity.color = oldColor;
                ceramicTilesBlockEntity.markDirty();
                return ActionResult.SUCCESS;
            }
        }
                return super.useOnBlock(context);
    }
//        if (ModBlocks.CERAMIC_TO_CHECKERED_CERAMIC.containsKey(current.getBlock()) && Objects.requireNonNull(context.getPlayer()).isSneaking()) {
//            if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity ceramicTilesBlockEntity && ceramicTilesBlockEntity.color != DyeableCeramicBlockEntity.DEFAULT_COLOR) {
//                int oldColor = DyeableCeramicBlockEntity.getColor(world, pos);
//                world.setBlockState(pos, ModBlocks.CERAMIC_TO_CHECKERED_CERAMIC.get(current.getBlock()).getStateWithProperties(current));
//                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat());
//                ceramicTilesBlockEntity.color = oldColor;
//                ceramicTilesBlockEntity.markDirty();
//                return ActionResult.SUCCESS;
//            }
//        }
//        return super.useOnBlock(context);
//    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip." + BountifulFares.MOD_ID + ".dyeable"));
        if (BountifulFares.CONFIG.isEnableItemGuideTooltips()) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.literal("§7Can be used to dye Ceramic blocks,"));
                tooltip.add(Text.literal("§7such as Ceramic Tiles."));
                tooltip.add(Text.literal("§7Interacting with a block while holding"));
                tooltip.add(Text.literal("§7a dyed Artisan Brush will apply"));
                tooltip.add(Text.literal("§7the corresponding color to the block."));
            } else {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.literal("§8Hold Shift for More Info..."));
            }
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
