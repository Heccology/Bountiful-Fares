package net.hecco.bountifulfares.compat.emi;

import dev.emi.emi.EmiRenderHelper;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.EmiRecipeSorting;
import dev.emi.emi.api.render.EmiRenderable;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.runtime.EmiDrawContext;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.util.Identifier;

public class BFEmiRecipeCategories {
    public static EmiRecipeCategory FERMENTING = new EmiRecipeCategory(Identifier.of("bountifulfares:fermenting"),
            EmiStack.of(BFBlocks.FERMENTATION_VESSEL), simplifiedRenderer(0, 0), EmiRecipeSorting.compareOutputThenInput());
    public static EmiRecipeCategory MILLING = new EmiRecipeCategory(Identifier.of("bountifulfares:milling"),
            EmiStack.of(BFBlocks.GRISTMILL), simplifiedRenderer(0, 0), EmiRecipeSorting.compareOutputThenInput());
    public static EmiRecipeCategory PRISMARINE_PROPAGATION = new EmiRecipeCategory(Identifier.of("bountifulfares:prismarine_propagation"),
            EmiStack.of(BFBlocks.PRISMARINE_BLOSSOM), simplifiedRenderer(0, 0), EmiRecipeSorting.compareOutputThenInput());

    private static EmiRenderable simplifiedRenderer(int u, int v) {
        return (raw, x, y, delta) -> {
            EmiDrawContext context = EmiDrawContext.wrap(raw);
            context.drawTexture(EmiRenderHelper.WIDGETS, x, y, u, v, 16, 16);
        };
    }
}
