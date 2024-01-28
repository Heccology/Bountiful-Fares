package net.hecco.bountifulcuisine.item.custom;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.entity.CeramicTilesBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArtisanBrushItem extends Item implements DyeableItem {
    public int DefColor = CeramicTilesBlockEntity.DEFAULT_COLOR;
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
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip." + BountifulCuisine.MOD_ID + ".dyeable"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
