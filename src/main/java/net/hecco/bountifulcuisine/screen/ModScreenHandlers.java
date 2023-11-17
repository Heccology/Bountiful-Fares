package net.hecco.bountifulcuisine.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<MillScreenHandler> MILL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(BountifulCuisine.MOD_ID, "mill_screen_handler"), new ExtendedScreenHandlerType<>(MillScreenHandler::new));
    public static void registerScreenHandlers() {
        BountifulCuisine.LOGGER.info("Registering Screen Handlers for" + BountifulCuisine.MOD_ID);
    }
}
