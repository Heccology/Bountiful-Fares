package net.hecco.bountifulfares.compat.emi;

import dev.emi.emi.EmiPort;
import dev.emi.emi.EmiUtil;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.registry.EmiTags;
import dev.emi.emi.runtime.EmiReloadLog;
import net.hecco.bountifulfares.recipe.CeramicMassDyeingRecipe;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.hecco.bountifulfares.registry.misc.BFScreenHandlers;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.item.Item;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BFEmiPlugin implements EmiPlugin {

    Set<Item> hiddenItems = Stream.concat(
            EmiUtil.values(TagKey.of(EmiPort.getItemRegistry().getKey(), EmiTags.HIDDEN_FROM_RECIPE_VIEWERS)).map(RegistryEntry::value),
            EmiPort.getDisabledItems()
    ).collect(Collectors.toSet());
    List<Item> dyeableCeramicItems = EmiUtil.values(BFItemTags.DYEABLE_CERAMIC_BLOCKS).map(RegistryEntry::value).collect(Collectors.toList());

    @Override
    public void register(EmiRegistry registry) {
        for (CraftingRecipe recipe : getRecipes(registry, RecipeType.CRAFTING)) {
            if (recipe instanceof CeramicMassDyeingRecipe) {
                for (Item i : dyeableCeramicItems) {
                    if (!hiddenItems.contains(i)) {
                        addRecipeSafe(registry, () -> new EmiCeramicMassDyeingRecipe(i, synthetic("crafting/ceramic_mass_dyeing", EmiUtil.subId(i))), recipe);
                    }
                }
            }
        }

        registry.addCategory(BFEmiRecipeCategories.FERMENTING);
        registry.addCategory(BFEmiRecipeCategories.MILLING);
        registry.addCategory(BFEmiRecipeCategories.PRISMARINE_PROPAGATION);

        registry.addWorkstation(BFEmiRecipeCategories.FERMENTING, EmiStack.of(BFBlocks.FERMENTATION_VESSEL));
        registry.addWorkstation(BFEmiRecipeCategories.MILLING, EmiStack.of(BFBlocks.GRISTMILL));

        registry.addRecipeHandler(BFScreenHandlers.GRISTMILL_SCREEN_HANDLER, new GristmillRecipeHandler());

        for (MillingRecipe recipe : getRecipes(registry, BFRecipes.MILLING)) {
            addRecipeSafe(registry, () -> new EmiMillingRecipe(recipe), recipe);
        }
        for (FermentationRecipe recipe : getRecipes(registry, BFRecipes.FERMENTING)) {
            addRecipeSafe(registry, () -> new EmiFermentationRecipe(recipe), recipe);
        }
        addRecipeSafePropagation(registry, EmiPropagationRecipe::new);
    }

    private static <C extends RecipeInput, T extends Recipe<C>> Iterable<T> getRecipes(EmiRegistry registry, RecipeType<T> type) {
        return registry.getRecipeManager().listAllOfType(type).stream().map(RecipeEntry::value)::iterator;
    }

    private static void addRecipeSafe(EmiRegistry registry, Supplier<EmiRecipe> supplier, Recipe<?> recipe) {
        try {
            registry.addRecipe(supplier.get());
        } catch (Throwable e) {
            EmiReloadLog.warn("Exception thrown when parsing bountifulfares recipe" + EmiPort.getId(recipe));
            EmiReloadLog.error(e);
        }
    }

    private static void addRecipeSafePropagation(EmiRegistry registry, Supplier<EmiRecipe> supplier) {
        try {
            registry.addRecipe(supplier.get());
        } catch (Throwable e) {
            EmiReloadLog.warn("Exception thrown when parsing bountifulfares prismarine propagation recipe");
            EmiReloadLog.error(e);
        }
    }

    private static Identifier synthetic(String type, String name) {
        return EmiPort.id("bountifulfares", "/" + type + "/" + name);
    }
}
