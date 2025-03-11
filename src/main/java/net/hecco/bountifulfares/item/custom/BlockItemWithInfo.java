package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class BlockItemWithInfo extends BlockItem {

    public BlockItemWithInfo(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        //        if (BountifulFares.CONFIG.isEnableItemGuideTooltips()) {
//            if (Screen.hasShiftDown()) {
//                writeInfo(tooltip);
//            } else {
//                tooltip.add(Text.literal("§8Hold Shift for More Info..."));
//            }
//        }
        super.appendTooltip(stack, context, tooltip, type);
    }

    public void writeInfo(List<Text> tooltip) {
        if (this == BFBlocks.FERMENTATION_VESSEL.asItem()) {
            tooltip.add(Text.literal("§7"+"Can be used to ferment ingredients."));
            tooltip.add(Text.literal("§7"+"Fill the vessel with a Water Bottle"));
            tooltip.add(Text.literal("§7"+"and an item to ferment it."));
        }
//        if (this == ModBlocks.TRELLIS.asItem()) {
//            tooltip.add(Text.literal("§7"+"Vine Crops and some plants can be"));
//            tooltip.add(Text.literal("§7"+"grown on Trellises."));
//        }
    }
}
