package net.hecco.bountifulfares.mixin.recipebook;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.hecco.bountifulfares.definition.recipe.MillingRecipe;
import net.hecco.bountifulfares.definition.screen.gristmill.recipebook.SecondaryRecipeCollection;
import net.minecraft.client.gui.screens.recipebook.RecipeButton;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(RecipeButton.class)
public abstract class RecipeButtonMixin {
    @Shadow private RecipeCollection collection;

    @Shadow private int currentIndex;

    @Shadow protected abstract List<RecipeHolder<?>> getOrderedRecipes();

    @WrapOperation(method = "renderWidget", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/crafting/Recipe;getResultItem(Lnet/minecraft/core/HolderLookup$Provider;)Lnet/minecraft/world/item/ItemStack;"))
    private ItemStack bountifulfares$renderSecondaryButtonIcon(Recipe<?> instance, HolderLookup.Provider provider, Operation<ItemStack> original, @Local List<RecipeHolder<?>> list) {
        if (instance instanceof MillingRecipe recipe && this.collection instanceof SecondaryRecipeCollection secondaryRecipeCollection) {
            return secondaryRecipeCollection.getMillingRecipes().secondaryOutputRecipes.contains(list.get(this.currentIndex)) ? recipe.getSecondary() : recipe.getPrimary();
        }
        return original.call(instance, provider);
    }
    @WrapOperation(method = "getTooltipText", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/crafting/Recipe;getResultItem(Lnet/minecraft/core/HolderLookup$Provider;)Lnet/minecraft/world/item/ItemStack;"))
    private ItemStack bountifulfares$renderSecondaryButtonText(Recipe<?> instance, HolderLookup.Provider provider, Operation<ItemStack> original) {
        if (instance instanceof MillingRecipe recipe && this.collection instanceof SecondaryRecipeCollection secondaryRecipeCollection) {
            return secondaryRecipeCollection.getMillingRecipes().secondaryOutputRecipes.contains(getOrderedRecipes().get(this.currentIndex)) ? recipe.getSecondary() : recipe.getPrimary();
        }
        return original.call(instance, provider);
    }
}
