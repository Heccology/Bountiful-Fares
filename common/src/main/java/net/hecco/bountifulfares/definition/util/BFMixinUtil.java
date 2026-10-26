package net.hecco.bountifulfares.definition.util;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.hecco.bountifulfares.definition.screen.gristmill.recipebook.MillingRecipeHolderList;
import net.hecco.bountifulfares.definition.screen.gristmill.recipebook.SecondaryRecipeCollection;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;

public class BFMixinUtil {
    public static RecipeCollection clientRecipeBookCollections(RegistryAccess access, List<RecipeHolder<?>> recipes, Operation<RecipeCollection> original) {
        if (recipes instanceof MillingRecipeHolderList list) return new SecondaryRecipeCollection(access, list);
        return original.call(access, recipes);
    }
}
