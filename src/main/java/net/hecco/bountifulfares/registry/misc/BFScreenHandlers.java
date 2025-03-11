package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.screen.GristmillScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class BFScreenHandlers {
    public static final ScreenHandlerType<GristmillScreenHandler> GRISTMILL_SCREEN_HANDLER =
            register("gristmill_screen_handler", GristmillScreenHandler::new);

//    public static <T extends ScreenHandler, D extends PacketByteBuf> ExtendedScreenHandlerType<T, D> register (String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> factory, PacketCodec<? super RegistryByteBuf, D> codec) {
//        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BountifulFares.MOD_ID, name), new ExtendedScreenHandlerType<>(factory, codec));
//    }

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, id, new ScreenHandlerType<>(factory, FeatureFlags.VANILLA_FEATURES));
    }

    public static void registerScreenHandlers() {
    }
}
