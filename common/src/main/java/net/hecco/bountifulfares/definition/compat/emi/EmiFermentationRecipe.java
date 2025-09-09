package net.hecco.bountifulfares.definition.compat.emi;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.SlotWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.compat.emi.BFEmiRecipeCategories;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.definition.recipe.FermentationRecipe;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;

import java.util.List;

public class EmiFermentationRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiIngredient input;
    private final EmiStack output;

    public EmiFermentationRecipe(FermentationRecipe recipe) {
        this.id = EmiPort.getId(recipe);
        input = EmiIngredient.of(recipe.getIngredient());
        output = EmiStack.of(EmiPort.getOutput(recipe));
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return BFEmiRecipeCategories.FERMENTING;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return List.of(input, EmiIngredient.of(List.of(EmiStack.of(Items.WATER_BUCKET), EmiStack.of(EmiPort.setPotion(new ItemStack(Items.POTION), Potions.WATER.value())))));
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of(output);
    }

    @Override
    public int getDisplayWidth() {
        return 89;
    }

    @Override
    public int getDisplayHeight() {
        return 76;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "textures/gui/jei/fermenting.png"), 0, 0, 89, 76, 0, 0);
        widgets.addTexture(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "textures/gui/jei/fermenting.png"),
                        29, 54, 24, 8, 29, 54)
                .tooltip((mx, my) -> List.of(ClientTooltipComponent.create(EmiPort.ordered(EmiPort.translatable("emi.cooking.time", Services.PLATFORM.getIntConfigValue("fermentationTime"))))));
        widgets.addSlot(EmiIngredient.of(List.of(EmiStack.of(Items.WATER_BUCKET), EmiStack.of(EmiPort.setPotion(new ItemStack(Items.POTION), Potions.WATER.value())))), 6, 5);
        widgets.addSlot(input, 6, 49).drawBack(false);
        widgets.add(new SlotWidget(output, 58, 45).large(true)).recipeContext(this);
    }
}