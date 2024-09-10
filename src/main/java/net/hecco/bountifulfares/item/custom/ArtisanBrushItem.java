package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ArtisanBrushItem extends Item {
    public int DefColor = DyeableCeramicBlockEntity.DEFAULT_COLOR;
    public ArtisanBrushItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        BlockState current = world.getBlockState(pos);
        int oldColor = DyeableCeramicBlockEntity.getColor(world, pos);
        if (BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.containsKey(current.getBlock()) && DyeableCeramicBlockEntity.getColor(world, pos) != DyeableCeramicBlockEntity.DEFAULT_COLOR) {
            if (DyedColorComponent.getColor(context.getStack(), DefColor) == DyeableCeramicBlockEntity.getColor(world, pos)) {
                    world.setBlockState(pos, BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.get(current.getBlock()).getStateWithProperties(current));
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity ceramicTilesBlockEntity) {
                    ceramicTilesBlockEntity.color = oldColor;
                    ceramicTilesBlockEntity.markDirty();
                    return ActionResult.SUCCESS;
                }
            }
        }
        if ((world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity || world.getBlockEntity(pos) instanceof CeramicDishBlockEntity) && (DyeableCeramicBlockEntity.getColor(world, pos) != DyeableCeramicBlockEntity.DEFAULT_COLOR || CeramicDishBlockEntity.getColor(world, pos) != CeramicDishBlockEntity.DEFAULT_COLOR)) {
            if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity) {
                if (DyedColorComponent.getColor(context.getStack(), DefColor) != DyeableCeramicBlockEntity.getColor(world, pos)) {
                    context.getStack().set(DataComponentTypes.DYED_COLOR, new DyedColorComponent(DyeableCeramicBlockEntity.getColor(world, pos), true));
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    return ActionResult.SUCCESS;
                }
            }
            if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity) {
                if (DyedColorComponent.getColor(context.getStack(), DefColor) != CeramicDishBlockEntity.getColor(world, pos)) {
                    context.getStack().set(DataComponentTypes.DYED_COLOR, new DyedColorComponent(CeramicDishBlockEntity.getColor(world, pos), true));
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    return ActionResult.SUCCESS;
                }
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
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip." + BountifulFares.MOD_ID + ".dyeable").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
