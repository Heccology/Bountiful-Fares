package net.hecco.bountifulfares.registry.content;

import com.mojang.serialization.Codec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.item.component.TiffinContents;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BFComponents {

    public static final Supplier<DataComponentType<TiffinContents>> TIFFIN_CONTENTS = registerComponent("tiffin_contents", (builder) -> builder.persistent(TiffinContents.CODEC).networkSynchronized(TiffinContents.STREAM_CODEC).cacheEncoding());
    public static final Supplier<DataComponentType<Boolean>> TIFFIN_INTERACTABLE = registerComponent("interactable", (builder) -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).cacheEncoding());

    private static <T> Supplier<DataComponentType<T>> registerComponent(String name, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return HLServices.REGISTRY.registerComponentType(BountifulFares.MOD_ID, name, builder);
    }

    public static void registerComponents() {

    }
}
