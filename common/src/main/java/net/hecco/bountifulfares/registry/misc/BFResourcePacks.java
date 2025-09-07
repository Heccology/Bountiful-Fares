package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.heccolib.platform.HLServices;

import java.util.Calendar;

public class BFResourcePacks {
    public static void registerBuiltinResourcePacks() {
        if (!Services.PLATFORM.getBoolConfigValue("showCompatItemsInRecipeViewers")) {
            HLServices.REGISTRY.registerBuiltInResourcepack(BountifulFares.MOD_ID, "hide_compat_items", "Bountiful Fares - Hide Compatibility Items", true, true);
        }

        HLServices.REGISTRY.registerBuiltInResourcepack(BountifulFares.MOD_ID, "vanilla_item_override", "Vanilla Item Overrides", false, true);


        if ((Calendar.getInstance().get(Calendar.MONTH) == Calendar.APRIL && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 1)) {
            HLServices.REGISTRY.registerBuiltInResourcepack(BountifulFares.MOD_ID, "lime", "Lime", true, true);
        }
    }
}
