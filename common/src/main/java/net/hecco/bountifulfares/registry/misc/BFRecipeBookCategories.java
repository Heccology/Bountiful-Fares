package net.hecco.bountifulfares.registry.misc;

import com.google.common.collect.ImmutableList;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.function.Supplier;

public class BFRecipeBookCategories {
    private static boolean CATEGORIES_READIED = false;
    public static List<RecipeBookCategories> GRISTMILL_CAGTEGORIES = ImmutableList.of();

    public static RecipeBookCategories BF_GRISTMILL_SEARCH = RecipeBookCategories.FURNACE_SEARCH;
    public static RecipeBookCategories BF_GRISTMILL_MATERIALS = RecipeBookCategories.FURNACE_FOOD;
    public static RecipeBookCategories BF_GRISTMILL_MINERALS = RecipeBookCategories.FURNACE_BLOCKS;

    public static final String GRIST_SEARCH_ID = "BF_GRISTMILL_SEARCH";
    public static final String GRIST_MATERIALS_ID = "BF_GRISTMILL_MATERIALS";
    public static final String GRIST_MINERALS_ID = "BF_GRISTMILL_MINERALS";

    public static final Supplier<ItemStack[]> GRIST_SEARCH_ITEMS = () -> new ItemStack[] {
            Items.COMPASS.getDefaultInstance()
    };
    public static final Supplier<ItemStack[]> GRIST_MATERIALS_ITEMS = () -> new ItemStack[] {
            BFItems.FLOUR.get().getDefaultInstance(), BFItems.COCONUT_COIR.get().getDefaultInstance()
    };
    public static final Supplier<ItemStack[]> GRIST_MINERALS_ITEMS = () -> new ItemStack[] {
            BFItems.FELDSPAR.get().getDefaultInstance(), Items.DIAMOND.getDefaultInstance()
    };

    public static void readyUpCategories() {
        if (CATEGORIES_READIED) throw new IllegalArgumentException("Gristmill categories were already readied up");

        CATEGORIES_READIED = true;
        GRISTMILL_CAGTEGORIES = ImmutableList.of(
                BF_GRISTMILL_SEARCH,
                BF_GRISTMILL_MATERIALS,
                BF_GRISTMILL_MINERALS
        );
    }
}
