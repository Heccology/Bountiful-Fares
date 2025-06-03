package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class DyeableCeramicBlockItem extends BlockItem {
    public int DEFAULT_COLOR = DyeableCeramicBlockEntity.DEFAULT_COLOR;
    public DyeableCeramicBlockItem(Block block, Properties settings) {
        super(block, settings);
    }

//    @Override
//    public ActionResult place(ItemPlacementContext context) {
//        ActionResult result = super.place(context);
//        BlockEntity blockEntity = context.getWorld().getBlockEntity(context.getBlockPos());
//        if(blockEntity instanceof DyeableCeramicBlockEntity ceramicTilesBlockEntity){
//            ceramicTilesBlockEntity.color = DyedColorComponent.getColor(context.getStack(), DEFAULT_COLOR);
//        }
//        return result;
//    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
        if (!stack.getComponents().has(DataComponents.DYED_COLOR)) {
            tooltip.add(Component.translatable("tooltip." + BountifulFares.MOD_ID + ".dyeable").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
        super.appendHoverText(stack, context, tooltip, type);
    }
}
