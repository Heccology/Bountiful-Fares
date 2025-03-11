package net.hecco.bountifulfares.compat;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.List;

public class CompatUtil {
    public static final List<String> VANILLA_COLORS = List.of("red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown", "white", "light_gray", "gray", "black");
    public static boolean isItemPaintbrush(Item item) {
        for (String color : VANILLA_COLORS) {
            if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, color + "_paintbrush"))) {
                return true;
            }
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "bleachdew_paintbrush"))) {
            return true;
        }
        return false;
    }
    public static int getIntColorFromPaintbrush(Item item) {
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "red_paintbrush"))) {
            return 11546150;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "orange_paintbrush"))) {
            return 16351261;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "yellow_paintbrush"))) {
            return 16701501;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "lime_paintbrush"))) {
            return 8439583;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "green_paintbrush"))) {
            return 6192150;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "cyan_paintbrush"))) {
            return 1481884;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "light_blue_paintbrush"))) {
            return 3847130;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "blue_paintbrush"))) {
            return 3949738;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "purple_paintbrush"))) {
            return 8991416;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "magenta_paintbrush"))) {
            return 13061821;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "pink_paintbrush"))) {
            return 15961002;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "brown_paintbrush"))) {
            return 8606770;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "white_paintbrush"))) {
            return 16383998;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "light_gray_paintbrush"))) {
            return 10329495;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "gray_paintbrush"))) {
            return 4673362;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "black_paintbrush"))) {
            return 1908001;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "bleachdew_paintbrush"))) {
            return 14669249;
        }
        return 1;
    }
}
