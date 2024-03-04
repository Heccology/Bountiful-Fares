package net.hecco.bountifulcuisine.util;

import com.google.common.collect.Maps;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class FermentationRecipes {
    private static final Map<Item, Item> INPUT_TO_OUTPUT = Maps.newHashMap();
    private static final Map<Item, Item> INPUT_TO_REMAINDER = Maps.newHashMap();
    private static final Map<Item, Item> OUTPUT_TO_COLLECTOR = Maps.newHashMap();
    private static final Map<Item, Integer> OUTPUT_TO_COUNT = Maps.newHashMap();

//    Remainders are items that are left behind when inputting an item into a Fermentation Vessel, for example, bottles from Honey Bottles.

//    Collectors are items needed to be used in order to collect a product from a Fermentation Vessel, for example, bottles or jars.
//    If the player is not using the correct collector, a message will show with the id "warning.bountifulcuisine.fermentation_vessel.[COLLECTOR ITEM ID]", you can add a translation to this in a lang file.
//    public static void addRecipeWithCollector(Item input, Item output, Item collector) {
//        INPUT_TO_OUTPUT.put(input, output);
//        OUTPUT_TO_COLLECTOR.put(output, collector);
//    }

//    public static void addRecipe(Item input, Item output) {
//        INPUT_TO_OUTPUT.put(input, output);
//    }

    public static void addRecipe(Item input, @Nullable Item remainder, Item output, @Nullable Item collector, @Nullable Integer resultCount) {
        INPUT_TO_OUTPUT.put(input, output);
        if (remainder != null) {
            INPUT_TO_REMAINDER.put(input, remainder);
        }
        if (collector != null) {
            OUTPUT_TO_COLLECTOR.put(output, collector);
        }
        if (resultCount != null) {
            OUTPUT_TO_COUNT.put(output, resultCount);
        }
    }
    public static Item getOutputFromInput(Item input) {
        return (INPUT_TO_OUTPUT.get(input));
    }
    public static Item getRemainderFromInput(Item input) {
        return (INPUT_TO_REMAINDER.get(input));
    }
    public static boolean isItemInput(PlayerEntity player, Hand hand) {
        return INPUT_TO_OUTPUT.containsKey(player.getStackInHand(hand).getItem());
    }
    public static Item getCollector(Item output) {
        return OUTPUT_TO_COLLECTOR.getOrDefault(output, null);
    }

    public static Integer getOutputCount(Item output) {
        return OUTPUT_TO_COUNT.getOrDefault(output, 1);
    }
}
