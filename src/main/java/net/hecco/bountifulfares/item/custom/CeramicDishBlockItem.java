package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;

import java.util.List;

public class CeramicDishBlockItem extends BlockItem {
    public int DefColor = CeramicDishBlockEntity.DEFAULT_COLOR;
    public CeramicDishBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult place(ItemPlacementContext context) {
        ActionResult result = super.place(context);
        BlockEntity blockEntity = context.getWorld().getBlockEntity(context.getBlockPos());
        if(blockEntity instanceof CeramicDishBlockEntity ceramicDishBlockEntity){
            ceramicDishBlockEntity.color = DyedColorComponent.getColor(context.getStack(), DefColor);
        }
        return result;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (!stack.getComponents().contains(DataComponentTypes.DYED_COLOR)) {
            tooltip.add(Text.translatable("tooltip." + BountifulFares.MOD_ID + ".dyeable").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
