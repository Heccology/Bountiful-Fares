package net.hecco.bountifulcuisine.mixin;

import net.minecraft.item.*;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.List;

@Mixin(Items.class)
public class GlowBerriesTooltipMixin {
    @Unique
    protected void plantToolTips(ItemStack stack, List<Text> tooltip) {
        // Check if the item is Glow Berries
        if (stack.getItem() == Items.GLOW_BERRIES) {
            // Append your custom tooltip text
            tooltip.add(Text.translatable("tooltip.minecraft.glow_berries"));
        }
    }
}