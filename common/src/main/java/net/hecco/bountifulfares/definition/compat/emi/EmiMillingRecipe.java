package net.hecco.bountifulfares.compat.emi;

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
import net.hecco.bountifulfares.definition.recipe.MillingRecipe;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class EmiMillingRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final EmiIngredient input;
    private final EmiStack output;

    public EmiMillingRecipe(MillingRecipe recipe) {
        this.id = EmiPort.getId(recipe);
        input = EmiIngredient.of(recipe.getIngredient());
        output = EmiStack.of(EmiPort.getOutput(recipe));
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return BFEmiRecipeCategories.MILLING;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return List.of(input);
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of(output);
    }

    @Override
    public int getDisplayWidth() {
        return 105;
    }

    @Override
    public int getDisplayHeight() {
        return 36;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "textures/gui/gristmill.png"),  32, 10, 35, 14, 69, 37);
        widgets.addAnimatedTexture(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "textures/gui/gristmill_progress_arrow.png"),
                32, 10, 35, 14, 0, 0, Services.PLATFORM.get().getIntConfigValue("millingTime")*1000, true, false, false)
                .tooltip((mx, my) -> List.of(ClientTooltipComponent.create(EmiPort.ordered(EmiPort.translatable("emi.cooking.time", Services.PLATFORM.get().getIntConfigValue("millingTime"))))));
        widgets.addSlot(input, 6, 9);
        widgets.add(new SlotWidget(output, 74, 5).large(true)).recipeContext(this);
    }
}
