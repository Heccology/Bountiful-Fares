package net.hecco.bountifulfares.definition.compat.emi;

import dev.emi.emi.EmiPort;
import dev.emi.emi.EmiUtil;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.registry.EmiTags;
import dev.emi.emi.runtime.EmiReloadLog;
import net.hecco.bountifulfares.compat.emi.EmiMillingRecipe;
import net.hecco.bountifulfares.definition.recipe.CeramicMassDyeingRecipe;
import net.hecco.bountifulfares.definition.recipe.FermentationRecipe;
import net.hecco.bountifulfares.definition.recipe.MillingRecipe;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFMenus;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.*;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EmiEntrypoint
public class BFEmiPlugin implements EmiPlugin {

    Set<Item> hiddenItems = Stream.concat(
            EmiUtil.values(TagKey.create(EmiPort.getItemRegistry().key(), EmiTags.HIDDEN_FROM_RECIPE_VIEWERS)).map(Holder::value),
            EmiPort.getDisabledItems()
    ).collect(Collectors.toSet());
    List<Item> dyeableCeramicItems = EmiUtil.values(BFItemTags.DYEABLE_CERAMIC_BLOCKS).map(Holder::value).collect(Collectors.toList());

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

        registry.addWorkstation(BFEmiRecipeCategories.FERMENTING, EmiStack.of(BFBlocks.FERMENTATION_VESSEL.get()));
        registry.addWorkstation(BFEmiRecipeCategories.MILLING, EmiStack.of(BFBlocks.GRISTMILL.get()));

        registry.addRecipeHandler(BFMenus.GRISTMILL_SCREEN_HANDLER.get(), new GristmillRecipeHandler());

        for (MillingRecipe recipe : getRecipes(registry, BFRecipes.MILLING.get())) {
            addRecipeSafe(registry, () -> new EmiMillingRecipe(recipe), recipe);
        }
        for (FermentationRecipe recipe : getRecipes(registry, BFRecipes.FERMENTING.get())) {
            addRecipeSafe(registry, () -> new EmiFermentationRecipe(recipe), recipe);
        }
        addRecipeSafePropagation(registry, EmiPropagationRecipe::new);
    }

    private static <C extends RecipeInput, T extends Recipe<C>> Iterable<T> getRecipes(EmiRegistry registry, RecipeType<T> type) {
        return registry.getRecipeManager().getAllRecipesFor(type).stream().map(RecipeHolder::value)::iterator;
    }

    private static void addRecipeSafe(EmiRegistry registry, Supplier<EmiRecipe> supplier, Recipe<?> recipe) {
        try {
            registry.addRecipe(supplier.get());
        } catch (Throwable e) {
            EmiReloadLog.warn("Exception thrown when parsing bountifulfares recipe" + EmiPort.getId(recipe));
        }
    }

    private static void addRecipeSafePropagation(EmiRegistry registry, Supplier<EmiRecipe> supplier) {
        try {
            registry.addRecipe(supplier.get());
        } catch (Throwable e) {
            EmiReloadLog.warn("Exception thrown when parsing bountifulfares prismarine propagation recipe");
        }
    }

    private static ResourceLocation synthetic(String type, String name) {
        return EmiPort.id("bountifulfares", "/" + type + "/" + name);
    }
}
