package net.hecco.bountifulfares.definition.screen.gristmill.recipebook;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.recipebook.GhostRecipe;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GristmillGhostRecipe extends GhostRecipe {
    private final List<Integer> results = new ArrayList<>();

    @Override
    public void render(GuiGraphics guiGraphics, Minecraft minecraft, int leftPos, int topPos, boolean offset, float partialTick) {
        if (!Screen.hasControlDown()) this.time += partialTick;

        for (int i = 0; i < this.ingredients.size(); ++i) {
            GhostIngredient ghost = this.ingredients.get(i);
            int j = ghost.getX() + leftPos;
            int k = ghost.getY() + topPos;
            if (this.results.contains(i) && offset) {
                guiGraphics.fill(j - 4, k - 4, j + 20, k + 20, 822018048);
            } else {
                guiGraphics.fill(j, k, j + 16, k + 16, 822018048);
            }

            ItemStack itemstack = ghost.getItem();
            guiGraphics.renderFakeItem(itemstack, j, k);
            guiGraphics.fill(RenderType.guiGhostRecipeOverlay(), j, k, j + 16, k + 16, 822083583);
            if (i == 0) {
                guiGraphics.renderItemDecorations(minecraft.font, itemstack, j, k);
            }
        }
    }

    public void addResult(int i) { this.results.add(i); }
}