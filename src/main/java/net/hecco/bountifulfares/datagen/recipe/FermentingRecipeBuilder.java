package net.hecco.bountifulfares.datagen.recipe;

import net.hecco.bountifulfares.recipe.FermentationRecipe;
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

public class FermentingRecipeBuilder implements CraftingRecipeJsonBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final int count;
    private final int particleColor;
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap();
    private final FermentationRecipe.RecipeFactory<?> recipeFactory;

    public FermentingRecipeBuilder(ItemConvertible ingredient, ItemConvertible output, int count, int particleColor, FermentationRecipe.RecipeFactory<?> recipeFactory) {
        this.ingredient = Ingredient.ofItems(ingredient);
        this.result = output.asItem();
        this.count = count;
        this.particleColor = particleColor;
        this.recipeFactory = recipeFactory;
    }

    public static <T extends FermentationRecipe> FermentingRecipeBuilder create(Item input, ItemConvertible output, int count, int particleColor) {
        return new FermentingRecipeBuilder(input, output, count, particleColor, FermentationRecipe::new);
    }

    public FermentingRecipeBuilder criterion(String string, AdvancementCriterion<?> advancementCriterion) {
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
        FermentationRecipe fermentationRecipe = this.recipeFactory.create(this.ingredient, new ItemStack(this.result), this.count, this.particleColor);
        exporter.accept(recipeId, fermentationRecipe, builder.build(recipeId.withPrefixedPath("recipes/")));
    }

    @Override
    public void offerTo(RecipeExporter exporter) {
        this.offerTo(exporter, Registries.ITEM.getId(getOutputItem()).getPath() + "_from_" + Registries.ITEM.getId(this.ingredient.getMatchingStacks()[0].getItem()).getPath() + "_fermenting");
    }
}
