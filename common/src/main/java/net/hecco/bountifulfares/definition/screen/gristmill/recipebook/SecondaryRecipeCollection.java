package net.hecco.bountifulfares.definition.screen.gristmill.recipebook;

import net.hecco.bountifulfares.definition.recipe.MillingRecipe;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;


public class SecondaryRecipeCollection extends RecipeCollection {
    public final boolean singleResultItem;
    private final MillingRecipeHolderList recipes;

    public SecondaryRecipeCollection(RegistryAccess registryAccess, MillingRecipeHolderList recipes) {
        super(registryAccess, recipes);
        this.recipes = recipes;
        if (recipes.size() <= 1) {
            this.singleResultItem = true;
        } else {
            this.singleResultItem = allRecipesHaveSameResult(recipes);
        }
    }

    public MillingRecipeHolderList getMillingRecipes() {
        return recipes;
    }

    private static boolean allRecipesHaveSameResult(MillingRecipeHolderList recipes) {
        int i = recipes.size();
        RecipeHolder<?> first = recipes.getFirst();
        ItemStack itemstack = recipes.secondaryOutputRecipes.contains(first) ? ((MillingRecipe)first.value()).getSecondary() : ((MillingRecipe) first.value()).getPrimary();

        for(int j = 1; j < i; ++j) {
            RecipeHolder<?> jayth = recipes.get(j);
            ItemStack itemstack1 = recipes.secondaryOutputRecipes.contains(jayth) ? ((MillingRecipe) jayth.value()).getSecondary() : ((MillingRecipe) jayth.value()).getPrimary();
            if (!ItemStack.isSameItemSameComponents(itemstack, itemstack1)) {
                return false;
            }
        }

        return true;
    }


    @Override
    public boolean hasSingleResultItem() {
        return singleResultItem;
    }
}
