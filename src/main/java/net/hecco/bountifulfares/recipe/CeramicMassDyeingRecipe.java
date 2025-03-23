package net.hecco.bountifulfares.recipe;

import com.google.common.collect.Lists;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.item.custom.CeramicDishBlockItem;
import net.hecco.bountifulfares.item.custom.DyeableCeramicBlockItem;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CeramicMassDyeingRecipe extends SpecialCraftingRecipe {
    public CeramicMassDyeingRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput inventory, World world) {
        boolean difference = false;
        Item dyeItem = null;
        int dyeCount = 0;
        ItemStack ceramicItemStack = ItemStack.EMPTY;
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack itemStack2 = inventory.getStackInSlot(i);
            if (itemStack2.isEmpty()) {
                continue;
            }
            if (itemStack2.getItem() instanceof DyeItem
            && !Registries.ITEM.getId(itemStack2.getItem()).equals(Identifier.of("unidye", "custom_dye"))) {
                dyeCount++;
                if (dyeItem == null) {
                    dyeItem = itemStack2.getItem();
                } else if (dyeItem != itemStack2.getItem()) {
                    difference = true;
                }
                continue;
            }
            if (itemStack2.getItem() instanceof DyeableCeramicBlockItem
                || itemStack2.getItem() instanceof CeramicDishBlockItem) {
                if (ceramicItemStack.isEmpty()) {
                    ceramicItemStack = itemStack2;
                    continue;
                } else if (ceramicItemStack.isOf(itemStack2.getItem())){
                    if(DyedColorComponent.getColor(ceramicItemStack, DyeableCeramicBlockEntity.DEFAULT_COLOR)
                    == DyedColorComponent.getColor(itemStack2, DyeableCeramicBlockEntity.DEFAULT_COLOR)){
                        continue;
                    }else{
                        return false;
                    }
                }
            }
            return false;
        }
        return difference || dyeCount == 1;
    }

    @Override
    public ItemStack craft(CraftingRecipeInput inventory, RegistryWrapper.WrapperLookup lookup) {
        ArrayList<DyeItem> list = Lists.newArrayList();
        ItemStack ceramicStack = ItemStack.EMPTY;
        int ceramicCount = 0;
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack itemStack2 = inventory.getStackInSlot(i);
            if (itemStack2.isEmpty()) continue;
            Item item = itemStack2.getItem();
            if (item instanceof DyeItem) {
                list.add((DyeItem) item);
            }
            if (item instanceof DyeableCeramicBlockItem
                    || item instanceof CeramicDishBlockItem){
                ceramicCount++;
                if(ceramicStack.isEmpty()){
                    ceramicStack = itemStack2;
                }
            }
        }
        if (list.isEmpty() || ceramicStack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        ItemStack itemStack = DyedColorComponent.setColor(ceramicStack, list);
        itemStack.setCount(ceramicCount);
        return itemStack;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BFSpecialRecipes.CERAMIC_MASS_DYEING;
    }
}
