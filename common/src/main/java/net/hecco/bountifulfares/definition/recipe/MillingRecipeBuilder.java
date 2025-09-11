package net.hecco.bountifulfares.definition.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MillingRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final int count;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap();
    private final MillingRecipe.RecipeFactory<?> recipeFactory;

    public MillingRecipeBuilder(ItemLike ingredient, ItemLike output, int count, MillingRecipe.RecipeFactory<?> recipeFactory) {
        this.ingredient = Ingredient.of(ingredient);
        this.result = output.asItem();
        this.count = count;
        this.recipeFactory = recipeFactory;
    }

    public static <T extends MillingRecipe> MillingRecipeBuilder create(Item input, ItemLike output, int count) {
        return new MillingRecipeBuilder(input, output, count, MillingRecipe::new);
    }

    public MillingRecipeBuilder unlockedBy(String string, Criterion<?> advancementCriterion) {
        this.criteria.put(string, advancementCriterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String group) {
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(RecipeOutput exporter, ResourceLocation recipeId) {
        Advancement.Builder builder = exporter.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
        Objects.requireNonNull(builder);
        MillingRecipe millingRecipe = this.recipeFactory.create(this.ingredient, new ItemStack(this.result), this.count);
        exporter.accept(recipeId, millingRecipe, builder.build(recipeId.withPrefix("recipes/")));
    }

    @Override
    public void save(RecipeOutput exporter) {
        this.save(exporter, ResourceLocation.fromNamespaceAndPath(BuiltInRegistries.ITEM.getKey(getResult()).getNamespace(),BuiltInRegistries.ITEM.getKey(getResult()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(this.ingredient.getItems()[0].getItem()).getPath() + "_milling"));
    }
}
