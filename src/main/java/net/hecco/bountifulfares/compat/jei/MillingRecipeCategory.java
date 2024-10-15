package net.hecco.bountifulfares.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.recipe.BFRecipes;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MillingRecipeCategory implements IRecipeCategory<MillingRecipe> {
    private final IDrawable icon;
    public MillingRecipeCategory(IGuiHelper guiHelper) {
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BFBlocks.GRISTMILL));
    }
    @Override
    public RecipeType<MillingRecipe> getRecipeType() {
        return BountifulFaresJEIPlugin.MILLING_RECIPE_TYPE;
    }

    @Override
    public @NotNull Text getTitle() {
        return Text.translatable("bountifulfares.milling");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public @Nullable Identifier getRegistryName(MillingRecipe recipe) {
        return Identifier.of(BountifulFares.MOD_ID, "milling");
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, MillingRecipe millingRecipe, IFocusGroup iFocusGroup) {

    }
}
