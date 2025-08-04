package net.hecco.bountifulfares.appleskin;

import net.hecco.bountifulfares.definition.item.custom.TiffinItem;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import squeek.appleskin.api.AppleSkinApi;
import squeek.appleskin.api.event.FoodValuesEvent;

public class AppleskinEventHandler implements AppleSkinApi {
    @Override
    public void registerEvents() {
        FoodValuesEvent.EVENT.register(foodValuesEvent -> {
            ItemStack stack = foodValuesEvent.itemStack;
            if (stack.getItem() instanceof TiffinItem && stack.has(BFComponents.TIFFIN_CONTENTS.get()) && !stack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack().isEmpty() && stack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack().has(DataComponents.FOOD)) {
                foodValuesEvent.modifiedFoodComponent = stack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack().get(DataComponents.FOOD);
            }
        });
    }
}