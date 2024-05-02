package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemWithInfo extends Item {
    public ItemWithInfo(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
//        if (BountifulFares.CONFIG.isEnableItemGuideTooltips()) {
//            if (Screen.hasShiftDown()) {
//                tooltip.add(Text.literal(""));
//                writeInfo(tooltip);
//            } else {
//                tooltip.add(Text.literal(""));
//                tooltip.add(Text.literal("§8Hold Shift for More Info..."));
//            }
//        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    public void writeInfo(List<Text> tooltip) {
        if (this == ModBlocks.FERMENTATION_VESSEL.asItem()) {
            tooltip.add(Text.literal("§7"+"Can be used to ferment ingredients"));
            tooltip.add(Text.literal("§7"+"into new ones."));
            tooltip.add(Text.literal("§7"+"Fill the vessel with a Water Bottle"));
            tooltip.add(Text.literal("§7"+"and an item to ferment something."));
        }
    }
}
