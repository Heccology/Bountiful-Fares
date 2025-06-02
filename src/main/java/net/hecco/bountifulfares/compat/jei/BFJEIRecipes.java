package net.hecco.bountifulfares.compat.jei;

import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

public class BFJEIRecipes {
    private final RecipeManager recipeManager;

    public BFJEIRecipes() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel world = minecraft.level;
        if (world != null) {
            this.recipeManager = world.getRecipeManager();
        } else {
            throw new NullPointerException("minecraft world must not be null.");
        }
    }
    public List<MillingRecipe> getMillingRecipes() {
        return this.recipeManager.getAllRecipesFor(BFRecipes.MILLING).stream().map(RecipeHolder::value).toList();
    }
    public List<FermentationRecipe> getFermentationRecipes() {
        return this.recipeManager.getAllRecipesFor(BFRecipes.FERMENTING).stream().map(RecipeHolder::value).toList();
    }
}
