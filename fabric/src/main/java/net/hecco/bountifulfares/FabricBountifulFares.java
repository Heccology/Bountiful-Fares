package net.hecco.bountifulfares;

import com.mojang.serialization.Codec;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.hecco.bountifulfares.datagen.DatagenOnlyItems;
import net.hecco.bountifulfares.item.component.TiffinContents;
import net.hecco.bountifulfares.registry.BFMessages;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions;
import net.hecco.bountifulfares.trellis.FabricTrellisCropResourceLoader;
import net.hecco.bountifulfares.trellis.FabricTrellisPlantResourceLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;

import java.util.function.UnaryOperator;

public class FabricBountifulFares implements ModInitializer {

    @Override
    public void onInitialize() {
//        BFComponents.TIFFIN_CONTENTS = () -> registerComponentType(BountifulFares.MOD_ID, "tiffin_contents", (builder) ->
//                builder.persistent(TiffinContents.CODEC).networkSynchronized(TiffinContents.STREAM_CODEC).cacheEncoding());
//        BFComponents.TIFFIN_INTERACTABLE = () -> registerComponentType(BountifulFares.MOD_ID, "interactable", (builder) ->
//                builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).cacheEncoding());
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricTrellisPlantResourceLoader());
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricTrellisCropResourceLoader());
        BountifulFares.init();
////        BFLootTableModifiers.modifyLootTables();
        BFItemGroupAdditions.registerItemGroupAdditions();
        BFMessages.registerPayloads();
        DatagenOnlyItems.registerDatagenItems();
    }


    public <T> DataComponentType<T> registerComponentType(String modId, String name, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, ResourceLocation.fromNamespaceAndPath(modId, name), (builder.apply(DataComponentType.builder())).build());
    }
}
