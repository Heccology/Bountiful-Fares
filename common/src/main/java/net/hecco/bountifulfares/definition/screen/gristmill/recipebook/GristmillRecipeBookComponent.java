package net.hecco.bountifulfares.definition.screen.gristmill.recipebook;

import net.hecco.bountifulfares.definition.block.entity.GristmillBlockEntity;
import net.hecco.bountifulfares.definition.recipe.MillingRecipe;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;

public class GristmillRecipeBookComponent extends RecipeBookComponent {
    @Override
    public void setupGhostRecipe(RecipeHolder<?> recipe, List<Slot> slots) {
        if (recipe.value() instanceof MillingRecipe mill && this.ghostRecipe instanceof GristmillGhostRecipe ghost) {
            ItemStack primary = mill.getPrimary();
            ItemStack secondary = mill.getSecondary();
            ghost.setRecipe(recipe);

            ghost.addIngredient(Ingredient.of(primary), slots.get(GristmillBlockEntity.PRIMARY_SLOT).x, slots.get(GristmillBlockEntity.PRIMARY_SLOT).y);
            ghost.addResult(0);

            if (!secondary.isEmpty()) {
                ghost.addIngredient(Ingredient.of(secondary), slots.get(GristmillBlockEntity.SECONDARY_SLOT).x, slots.get(GristmillBlockEntity.SECONDARY_SLOT).y);
                ghost.addResult(1);
            }

            ghost.addIngredient(mill.getIngredient(), slots.get(GristmillBlockEntity.INPUT_SLOT).x, slots.get(GristmillBlockEntity.INPUT_SLOT).y);
        }
        else super.setupGhostRecipe(recipe, slots);
    }
}