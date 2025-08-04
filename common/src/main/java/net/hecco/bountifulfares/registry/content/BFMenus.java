package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.screen.GristmillMenu;
import net.hecco.heccolib.platform.HLServices;
import net.hecco.heccolib.platform.services.HLRegistryHelper;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class BFMenus {
    public static final Supplier<MenuType<GristmillMenu>> GRISTMILL_SCREEN_HANDLER =
            register("gristmill_screen_handler", GristmillMenu::new);

    private static <T extends AbstractContainerMenu> Supplier<MenuType<T>> register(String id, HLRegistryHelper.MenuSupplier<T> factory) {
        return HLServices.REGISTRY.registerMenu(BountifulFares.MOD_ID, id, factory);
    }

    public static void registerScreenHandlers() {
    }
}
