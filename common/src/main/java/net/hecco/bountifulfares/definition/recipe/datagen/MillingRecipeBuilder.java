package net.hecco.bountifulfares.definition.recipe.datagen;

import net.hecco.bountifulfares.definition.recipe.MillingRecipe;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class MillingRecipeBuilder implements RecipeBuilder {
    private final Ingredient ingredient;

    private final ItemStack primary;
    private String primaryGroup;
    private final GristmillBookCategory primaryCat;

    private ItemStack secondary;
    private String secondaryGroup;
    private GristmillBookCategory secondaryCat;

    private final Map<String, Criterion<?>> criteria = new LinkedHashMap();
    private final MillingRecipe.RecipeFactory<?> recipeFactory;

    public MillingRecipeBuilder(ItemLike ingredient, ItemStack primary, String primaryGroup, GristmillBookCategory primaryCat, ItemStack secondary, String secondaryGroup, GristmillBookCategory secondaryCat, MillingRecipe.RecipeFactory<MillingRecipe> recipeFactory) {
        this.ingredient = Ingredient.of(ingredient);

        this.primary = primary;
        this.primaryGroup = primaryGroup;
        this.primaryCat = primaryCat;

        this.secondary = secondary;
        this.secondaryGroup = secondaryGroup;
        this.secondaryCat = secondaryCat;

        this.recipeFactory = recipeFactory;
    }

    public static <T extends MillingRecipe> MillingRecipeBuilder create(Item input, ItemLike output, int count, GristmillBookCategory category) {
        return new MillingRecipeBuilder(input, new ItemStack(output.asItem(), count), "", category, ItemStack.EMPTY, "", GristmillBookCategory.MATERIALS, MillingRecipe::new);
    }

    // UNIQUES

    public MillingRecipeBuilder secondaryResult(ItemLike output, int count, GristmillBookCategory category) {
        this.secondary = new ItemStack(output.asItem(), count);
        this.secondaryCat = category;
        return this;
    }

    public MillingRecipeBuilder secondaryGroup(@Nullable String group) {
        this.secondaryGroup = group;
        return this;
    }

    public MillingRecipeBuilder copyPrimaryToSecondary() {
        this.secondary = this.primary;
        this.secondaryCat = this.primaryCat;
        this.secondaryGroup = this.primaryGroup;
        return this;
    }

    public Item getSecondResult() { return this.secondary.getItem(); }

    // MAIN OVERRIDES

    @Override
    public MillingRecipeBuilder unlockedBy(String string, Criterion<?> advancementCriterion) {
        this.criteria.put(string, advancementCriterion);
        return this;
    }

    @Override
    public MillingRecipeBuilder group(@Nullable String group) {
        this.primaryGroup = group;
        return this;
    }

    @Override public Item getResult() { return this.primary.getItem(); }

    @Override
    public void save(RecipeOutput exporter, ResourceLocation recipeId) {
        Advancement.Builder builder = exporter.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
        Objects.requireNonNull(builder);
        this.criteria.forEach(builder::addCriterion);
        MillingRecipe millingRecipe = this.recipeFactory.create(
                this.ingredient,
                this.primary,
                this.primaryGroup,
                this.primaryCat,
                this.secondary,
                this.secondaryGroup,
                this.secondaryCat
        );
        exporter.accept(recipeId, millingRecipe, builder.build(recipeId.withPrefix("recipes/")));
    }

    @Override
    public void save(RecipeOutput exporter) {
        this.save(exporter, ResourceLocation.fromNamespaceAndPath(BuiltInRegistries.ITEM.getKey(getResult()).getNamespace(),BuiltInRegistries.ITEM.getKey(getResult()).getPath() + "_from_" + BuiltInRegistries.ITEM.getKey(this.ingredient.getItems()[0].getItem()).getPath() + "_milling"));
    }
}
