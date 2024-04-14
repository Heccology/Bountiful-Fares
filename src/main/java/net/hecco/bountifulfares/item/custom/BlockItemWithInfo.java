package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockItemWithInfo extends BlockItem {

    public BlockItemWithInfo(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (BountifulFares.CONFIG.isEnableItemGuideTooltips()) {
            if (Screen.hasShiftDown()) {
                writeInfo(tooltip);
            } else {
                tooltip.add(Text.literal("§8Hold Shift for More Info..."));
            }
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    public void writeInfo(List<Text> tooltip) {
        if (this == ModBlocks.FERMENTATION_VESSEL.asItem()) {
            tooltip.add(Text.literal("§7"+"Can be used to ferment ingredients."));
            tooltip.add(Text.literal("§7"+"Fill the vessel with a Water Bottle"));
            tooltip.add(Text.literal("§7"+"and an item to ferment it."));
        }
        if (this == ModBlocks.TRELLIS.asItem()) {
            tooltip.add(Text.literal("§7"+"Vine Crops and some plants can be"));
            tooltip.add(Text.literal("§7"+"grown on Trellises."));
        }
    }
}
