package net.hecco.bountifulcuisine.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.recipe.QuernStoneRecipe;
import net.hecco.bountifulcuisine.screen.QuernStoneScreen;

public class BountifulCuisineREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new QuernStoneCategory());

        registry.addWorkstations(QuernStoneCategory.QUERN_STONE, EntryStacks.of(ModBlocks.QUERN_STONE));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(QuernStoneRecipe.class, QuernStoneRecipe.Type.INSTANCE, QuernStoneDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), QuernStoneScreen.class, QuernStoneCategory.QUERN_STONE);
    }
}
