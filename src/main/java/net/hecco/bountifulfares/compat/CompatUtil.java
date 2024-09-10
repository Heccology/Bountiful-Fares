package net.hecco.bountifulfares.compat;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class CompatUtil {
    public static boolean isItemPaintbrush(Item item) {
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "red_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "orange_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "yellow_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "lime_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "green_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "cyan_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "light_blue_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "blue_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "purple_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "magenta_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "pink_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "brown_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "white_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "light_gray_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "gray_paintbrush"))) {
            return true;
        }
        if (item == Registries.ITEM.get(Identifier.of(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "black_paintbrush"))) {
            return true;
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
