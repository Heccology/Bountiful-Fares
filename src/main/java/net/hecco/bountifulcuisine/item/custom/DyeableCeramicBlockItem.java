package net.hecco.bountifulcuisine.item.custom;

import net.hecco.bountifulcuisine.block.entity.CeramicTilesBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.ActionResult;

public class DyeableCeramicBlockItem extends BlockItem implements DyeableItem {
    public int DefColor = CeramicTilesBlockEntity.DEFAULT_COLOR;
    public DyeableCeramicBlockItem(Block block, Settings settings) {
        super(block, settings);
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
    public ActionResult place(ItemPlacementContext context) {
        ActionResult result = super.place(context);
        BlockEntity blockEntity = context.getWorld().getBlockEntity(context.getBlockPos());
        if(blockEntity instanceof CeramicTilesBlockEntity ceramicTilesBlockEntity){
            ceramicTilesBlockEntity.color = getColor(context.getStack());
        }
        return result;
    }
}
