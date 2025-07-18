package net.hecco.bountifulfares.registry.misc;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class BFScreenHandlers {
//    public static final MenuType<GristmillScreenHandler> GRISTMILL_SCREEN_HANDLER =
//            register("gristmill_screen_handler", GristmillScreenHandler::new);
//
////    public static <T extends ScreenHandler, D extends PacketByteBuf> ExtendedScreenHandlerType<T, D> register (String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> factory, PacketCodec<? super RegistryByteBuf, D> codec) {
////        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(BountifulFares.MOD_ID, name), new ExtendedScreenHandlerType<>(factory, codec));
////    }
//
//    private static <T extends AbstractContainerMenu> MenuType<T> register(String id, MenuType.MenuSupplier<T> factory) {
//        return Registry.register(BuiltInRegistries.MENU, id, new MenuType<>(factory, FeatureFlags.VANILLA_SET));
//    } TODO: READD

    public static void registerScreenHandlers() {
    }
}
