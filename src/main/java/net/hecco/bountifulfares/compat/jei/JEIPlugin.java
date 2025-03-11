package net.hecco.bountifulfares.compat.jei;

import com.google.common.collect.ImmutableList;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.jei.category.FermentingRecipeCategory;
import net.hecco.bountifulfares.compat.jei.category.MillingRecipeCategory;
import net.hecco.bountifulfares.compat.jei.category.PrismarinePropagationCategory;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;

@JeiPlugin @MethodsReturnNonnullByDefault @SuppressWarnings("unused")
public class JEIPlugin implements IModPlugin {
    private static final Identifier ID = Identifier.of(BountifulFares.MOD_ID, "jei_plugin");

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        BFJEIRecipes bfRecipes = new BFJEIRecipes();

//        RECIPES
        registration.addRecipes(BFRecipeTypes.MILLING, bfRecipes.getMillingRecipes());
        registration.addRecipes(BFRecipeTypes.FERMENTING, bfRecipes.getFermentationRecipes());
        registration.addRecipes(BFRecipeTypes.PRISMARINE_PROPAGATION, ImmutableList.of(new PropagationRecipe()));

        //Example of information tooltip for JEI
//        registration.addIngredientInfo(new ItemStack(BFItems.CITRUS_ESSENCE), VanillaTypes.ITEM_STACK, Text.translatable("jei.info.citrus_essence"));
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new MillingRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new FermentingRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new PrismarinePropagationCategory(registry.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BFBlocks.GRISTMILL.asItem()), BFRecipeTypes.MILLING);
        registration.addRecipeCatalyst(new ItemStack(BFBlocks.FERMENTATION_VESSEL.asItem()), BFRecipeTypes.FERMENTING);
    }

    @Override
    public Identifier getPluginUid() {
        return ID;
    }
}
