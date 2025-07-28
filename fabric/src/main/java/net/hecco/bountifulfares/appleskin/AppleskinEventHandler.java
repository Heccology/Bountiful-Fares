package net.hecco.bountifulfares.appleskin;

import net.hecco.bountifulfares.item.custom.TiffinItem;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import squeek.appleskin.api.AppleSkinApi;
import squeek.appleskin.api.event.FoodValuesEvent;

public class AppleskinEventHandler implements AppleSkinApi {
    @Override
    public void registerEvents() {
        FoodValuesEvent.EVENT.register(foodValuesEvent -> {
            ItemStack stack = foodValuesEvent.itemStack;
            if (stack.getItem() instanceof TiffinItem tiffinItem && tiffinItem.getDefaultInstance().has(BFComponents.TIFFIN_CONTENTS) && stack.get(BFComponents.TIFFIN_CONTENTS).getItem() != Items.AIR) {
                foodValuesEvent.modifiedFoodComponent = stack.get(BFComponents.TIFFIN_CONTENTS).getItem().getDefaultInstance().get(DataComponents.FOOD);
            }
        });
    }
}