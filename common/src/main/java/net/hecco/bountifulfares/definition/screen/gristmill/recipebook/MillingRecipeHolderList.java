package net.hecco.bountifulfares.definition.screen.gristmill.recipebook;

import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.ArrayList;
import java.util.List;

public class MillingRecipeHolderList extends ArrayList<RecipeHolder<?>> {
    public final List<RecipeHolder<?>> secondaryOutputRecipes = new ArrayList<>();
    public void addRecipe(RecipeHolder<?> holder, boolean secondary) {
        if (!contains(holder)) {
            add(holder);
        }
        if (secondary) {
            secondaryOutputRecipes.add(holder);
        }
    }
}
