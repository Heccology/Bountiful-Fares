package net.hecco.bountifulfares.mixin.recipebook;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.hecco.bountifulfares.registry.misc.BFRecipeBookCategories;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeBookTabButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(RecipeBookComponent.class)
public class RecipeBookComponentMixin {
    @WrapOperation(method = "updateTabs", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/screens/recipebook/RecipeBookTabButton;getCategory()Lnet/minecraft/client/RecipeBookCategories;",
            ordinal = 0)
    )
    // Masks the BF_GRISTMILL_SEARCH as CRAFTING_SEARCH so the upcoming "if" statement fails out, therefore making it appear even when there's no recipes
    // Method copied 1:1 from Dungeon's Delight, which this fixes that issue as well. Luckily there's not as much custom code :steamhappy:
    private RecipeBookCategories bountifulfares$gristUpdateTab(RecipeBookTabButton instance, Operation<RecipeBookCategories> original) {
        RecipeBookCategories cat = original.call(instance);
        if (cat == BFRecipeBookCategories.BF_GRISTMILL_SEARCH) cat = RecipeBookCategories.CRAFTING_SEARCH;
        return cat;
    }
}
