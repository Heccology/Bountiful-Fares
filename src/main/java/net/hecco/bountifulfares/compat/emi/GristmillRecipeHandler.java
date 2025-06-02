package net.hecco.bountifulfares.compat.emi;

import com.google.common.collect.Lists;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.handler.StandardRecipeHandler;
import net.hecco.bountifulfares.screen.GristmillScreenHandler;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GristmillRecipeHandler implements StandardRecipeHandler<GristmillScreenHandler> {

    @Override
    public List<Slot> getInputSources(GristmillScreenHandler handler) {
        List<Slot> list = Lists.newArrayList();
        list.add(handler.getSlot(0));
        int invStart = 2;
        for (int i = invStart; i < invStart + 36; i++) {
            list.add(handler.getSlot(i));
        }
        return list;
    }

    @Override
    public List<Slot> getCraftingSlots(GristmillScreenHandler handler) {
        List<Slot> list = Lists.newArrayList();
        list.add(handler.getSlot(0));
        return list;
    }

    @Override
    public @Nullable Slot getOutputSlot(GristmillScreenHandler handler) {
        return handler.slots.get(1);
    }

    @Override
    public boolean supportsRecipe(EmiRecipe recipe) {
        return recipe.getCategory() == BFEmiRecipeCategories.MILLING && recipe.supportsRecipeTree();
    }
}