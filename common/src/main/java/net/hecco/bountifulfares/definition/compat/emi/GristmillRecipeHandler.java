package net.hecco.bountifulfares.definition.compat.emi;

import com.google.common.collect.Lists;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.handler.StandardRecipeHandler;
import net.hecco.bountifulfares.definition.screen.GristmillMenu;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GristmillRecipeHandler implements StandardRecipeHandler<GristmillMenu> {

    @Override
    public List<Slot> getInputSources(GristmillMenu handler) {
        List<Slot> list = Lists.newArrayList();
        list.add(handler.getSlot(0));
        int invStart = 2;
        for (int i = invStart; i < invStart + 36; i++) {
            list.add(handler.getSlot(i));
        }
        return list;
    }

    @Override
    public List<Slot> getCraftingSlots(GristmillMenu handler) {
        List<Slot> list = Lists.newArrayList();
        list.add(handler.getSlot(0));
        return list;
    }

    @Override
    public @Nullable Slot getOutputSlot(GristmillMenu handler) {
        return handler.slots.get(1);
    }

    @Override
    public boolean supportsRecipe(EmiRecipe recipe) {
        return recipe.getCategory() == BFEmiRecipeCategories.MILLING && recipe.supportsRecipeTree();
    }
}