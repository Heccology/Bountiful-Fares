package net.hecco.bountifulfares.definition.recipe;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.item.custom.TiffinItem;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class TiffinColoringRecipe extends CustomRecipe {

    public TiffinColoringRecipe(CraftingBookCategory category) {
        super(category);
    }

    public boolean matches(CraftingInput input, Level level) {
        int i = 0;
        int j = 0;

        for(int k = 0; k < input.size(); ++k) {
            ItemStack itemstack = input.getItem(k);
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof TiffinItem) {
                    ++i;
                } else {
                    if (!(itemstack.getItem() instanceof DyeItem)) {
                        return false;
                    }

                    ++j;
                }

                if (j > 1 || i > 1) {
                    return false;
                }
            }
        }
        return i == 1 && j == 1;
    }

    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        ItemStack tiffinStack = ItemStack.EMPTY;
        DyeItem dyeItem = (DyeItem) Items.WHITE_DYE;
        BountifulFares.LOGGER.info("true");
        for (int i = 0; i < input.size(); ++i) {
            ItemStack stack = input.getItem(i);
            if (stack.isEmpty()) continue;
            Item item = stack.getItem();
            if (item instanceof TiffinItem) {
                tiffinStack = stack;
            } else if (item instanceof DyeItem) {
                dyeItem = (DyeItem) item;
            }
        }
        Item resultItem = TiffinItem.getItemFromDye(dyeItem.getDyeColor());
        if (resultItem == null) {
            return ItemStack.EMPTY;
        }

        return tiffinStack.transmuteCopy(resultItem, 1);
    }


    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    public @NotNull RecipeSerializer<?> getSerializer() {
        return BFRecipes.TIFFIN_COLORING.get();
    }
}
