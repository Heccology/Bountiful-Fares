package net.hecco.bountifulfares.mixin.recipebook;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.hecco.bountifulfares.definition.screen.gristmill.recipebook.GristmillGhostRecipe;
import net.hecco.bountifulfares.definition.screen.gristmill.recipebook.GristmillRecipeBookComponent;
import net.hecco.bountifulfares.registry.misc.BFRecipeBookCategories;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.client.gui.screens.recipebook.GhostRecipe;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeBookTabButton;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RecipeBookComponent.class)
public class RecipeBookComponentMixin {
    @Shadow @Final @Mutable protected GhostRecipe ghostRecipe;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void bountifulfares$hotswapGhostRecipe(CallbackInfo ci) {
        if ((Object)this instanceof GristmillRecipeBookComponent) {
            this.ghostRecipe = new GristmillGhostRecipe();
        }
    }

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
