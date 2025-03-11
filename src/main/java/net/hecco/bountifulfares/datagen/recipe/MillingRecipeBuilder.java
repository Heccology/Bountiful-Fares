package net.hecco.bountifulfares.datagen.recipe;

import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MillingRecipeBuilder implements CraftingRecipeJsonBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final int count;
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap();
    private final MillingRecipe.RecipeFactory<?> recipeFactory;

    public MillingRecipeBuilder(ItemConvertible ingredient, ItemConvertible output, int count, MillingRecipe.RecipeFactory<?> recipeFactory) {
        this.ingredient = Ingredient.ofItems(ingredient);
        this.result = output.asItem();
        this.count = count;
        this.recipeFactory = recipeFactory;
    }

    public static <T extends MillingRecipe> MillingRecipeBuilder create(Item input, ItemConvertible output, int count) {
        return new MillingRecipeBuilder(input, output, count, MillingRecipe::new);
    }

    public MillingRecipeBuilder criterion(String string, AdvancementCriterion<?> advancementCriterion) {
        this.criteria.put(string, advancementCriterion);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String group) {
        return this;
    }

    @Override
    public Item getOutputItem() {
        return result;
    }

    @Override
    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        Advancement.Builder builder = exporter.getAdvancementBuilder().criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        Objects.requireNonNull(builder);
        MillingRecipe millingRecipe = this.recipeFactory.create(this.ingredient, new ItemStack(this.result), this.count);
        exporter.accept(recipeId, millingRecipe, builder.build(recipeId.withPrefixedPath("recipes/")));
    }

    @Override
    public void offerTo(RecipeExporter exporter) {
        this.offerTo(exporter, Registries.ITEM.getId(getOutputItem()).getPath() + "_from_" + Registries.ITEM.getId(this.ingredient.getMatchingStacks()[0].getItem()).getPath() + "_milling");
    }
}
