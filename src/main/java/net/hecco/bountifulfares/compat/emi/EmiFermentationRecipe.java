package net.hecco.bountifulfares.compat.emi;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.SlotWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresConfiguration;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;

import java.util.List;

public class EmiFermentationRecipe implements EmiRecipe {
    private final Identifier id;
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
    public Identifier getId() {
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
        widgets.addTexture(Identifier.of(BountifulFares.MOD_ID, "textures/gui/jei/fermenting.png"), 0, 0, 89, 76, 0, 0);
        widgets.addTexture(Identifier.of(BountifulFares.MOD_ID, "textures/gui/jei/fermenting.png"),
                        29, 54, 24, 8, 29, 54)
                .tooltip((mx, my) -> List.of(TooltipComponent.of(EmiPort.ordered(EmiPort.translatable("emi.cooking.time", BountifulFaresConfiguration.load().getFermentationTime())))));
        widgets.addSlot(EmiIngredient.of(List.of(EmiStack.of(Items.WATER_BUCKET), EmiStack.of(EmiPort.setPotion(new ItemStack(Items.POTION), Potions.WATER.value())))), 6, 5);
        widgets.addSlot(input, 6, 49).drawBack(false);
        widgets.add(new SlotWidget(output, 58, 45).large(true)).recipeContext(this);
    }
}