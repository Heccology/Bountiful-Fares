package net.hecco.bountifulcuisine.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.recipe.MillingRecipe;
import net.hecco.bountifulcuisine.screen.MillScreen;

public class BountifulCuisineREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new MillingCategory());

        registry.addWorkstations(MillingCategory.MILLING, EntryStacks.of(ModBlocks.MILL));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(MillingRecipe.class, MillingRecipe.Type.INSTANCE, MillingDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), MillScreen.class, MillingCategory.MILLING);
    }
}
