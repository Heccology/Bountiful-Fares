package net.hecco.bountifulfares.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.minecraft.util.Identifier;

public class BountifulFaresJEIPlugin implements IModPlugin {
    public static final RecipeType<MillingRecipe> MILLING_RECIPE_TYPE =
            RecipeType.create(BountifulFares.MOD_ID, "milling", MillingRecipe.class);
    @Override
    public Identifier getPluginUid() {
        return Identifier.of(BountifulFares.MOD_ID);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IModPlugin.super.registerCategories(registration);
    }
}
