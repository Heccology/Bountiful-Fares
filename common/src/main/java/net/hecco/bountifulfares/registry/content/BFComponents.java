package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.item.component.TiffinContents;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.component.DataComponentType;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BFComponents {

    public static DataComponentType<TiffinContents> TIFFIN_CONTENTS;

    private static <T> Supplier<DataComponentType<T>> registerComponent(String name, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return HLServices.REGISTRY.registerComponentType(BountifulFares.MOD_ID, name, builder);
    }

    public static void registerComponents() {

    }
}
