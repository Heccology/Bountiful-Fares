package net.hecco.bountifulfares.mixin.recipebook;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.hecco.bountifulfares.definition.recipe.MillingRecipe;
import net.hecco.bountifulfares.definition.recipe.datagen.GristmillBookCategory;
import net.hecco.bountifulfares.registry.misc.BFRecipeBookCategories;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Map;

@Mixin(ClientRecipeBook.class)
public class ClientRecipeBookMixin {
    // If the recipe is a milling recipe, it will sort it into the map uniquely
    @WrapOperation(method = "categorizeAndGroupRecipes", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/crafting/Recipe;isSpecial()Z"))
    private static boolean bountifulfares$customCategorizeForMilling(
            Recipe<?> recipe,
            Operation<Boolean> original,
            @Local(ordinal = 0) RecipeHolder<?> recipeholder,
            @Local(ordinal = 0) Map<RecipeBookCategories, List<List<RecipeHolder<?>>>> map,
            @Local(ordinal = 0) Table<RecipeBookCategories, String, List<RecipeHolder<?>>> table
    ) {
        boolean og = original.call(recipe);
        if (!og && recipe instanceof MillingRecipe millingRecipe) {
            // Primary
            RecipeBookCategories primaryCat = bountifulfares$gristmillCategory(millingRecipe.getPrimaryRecipeTab());
            String primaryGroup = millingRecipe.getPrimaryGroup().isEmpty() ? recipeholder.id().toString() : millingRecipe.getPrimaryGroup();

            if (primaryGroup.isEmpty()) {
                map.computeIfAbsent(primaryCat, (category) -> Lists.newArrayList()).add(ImmutableList.of(recipeholder));
            }
            else {
                List<RecipeHolder<?>> list = table.get(primaryCat, primaryGroup);

                if (list == null) {
                    list = Lists.newArrayList();
                    table.put(primaryCat, primaryGroup, list);
                    map.computeIfAbsent(primaryCat, (category) -> Lists.newArrayList()).add(list);
                }

                list.add(recipeholder);
            }

            // Secondary
            ItemStack first = millingRecipe.getPrimary();
            ItemStack second = millingRecipe.getSecondary();
            if (!second.isEmpty() && !ItemStack.isSameItem(first, second)) {
                RecipeBookCategories secondaryCat = bountifulfares$gristmillCategory(millingRecipe.getSecondaryRecipeTab());
                String secondaryGroup = millingRecipe.getSecondaryGroup().isEmpty() ? recipeholder.id().toString() : millingRecipe.getSecondaryGroup();

                if (secondaryGroup.isEmpty()) {
                    map.computeIfAbsent(secondaryCat, (category) -> Lists.newArrayList()).add(ImmutableList.of(recipeholder));
                }
                else {
                    List<RecipeHolder<?>> list2 = table.get(secondaryCat, secondaryGroup);

                    if (list2 == null) {
                        list2 = Lists.newArrayList();
                        table.put(secondaryCat, secondaryGroup, list2);
                        map.computeIfAbsent(secondaryCat, (category) -> Lists.newArrayList()).add(list2);
                    }

                    list2.add(recipeholder);
                }
            }

            return true;
        }
        return og;
    }

    // Not necessary anyway since we, uh, do a mixin to sort anyway - but here for safety in case anything else uses this :sob:
    @Inject(method = "getCategory", at = @At("HEAD"), cancellable = true)
    private static void bountifulfares$onTheGrind(RecipeHolder<?> recipe1, CallbackInfoReturnable<RecipeBookCategories> cir) {
        if (recipe1.value() instanceof MillingRecipe rec) {
            switch (rec.getPrimaryRecipeTab()) {
                case MATERIALS:    cir.setReturnValue(BFRecipeBookCategories.BF_GRISTMILL_MATERIALS);      break;
                case MINERALS:     cir.setReturnValue(BFRecipeBookCategories.BF_GRISTMILL_MINERALS);       break;
                default:           throw new IncompatibleClassChangeError("...what?");
            }
        }
    }

    //////////////////////////////////////////////////

    @Unique
    private static RecipeBookCategories bountifulfares$gristmillCategory(GristmillBookCategory category) {
        return switch (category) {
            case MATERIALS -> BFRecipeBookCategories.BF_GRISTMILL_MATERIALS;
            case MINERALS -> BFRecipeBookCategories.BF_GRISTMILL_MINERALS;
        };
    }
}
