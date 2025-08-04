package net.hecco.bountifulfares;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.hecco.bountifulfares.data.FabricGrassSeedsInteractionResourceLoader;
import net.hecco.bountifulfares.datagen.DatagenOnlyItems;
import net.hecco.bountifulfares.registry.BFMessages;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions;
import net.hecco.bountifulfares.data.FabricTrellisCropResourceLoader;
import net.hecco.bountifulfares.data.FabricTrellisPlantResourceLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.DyeColor;

import java.util.function.UnaryOperator;

import static net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions.*;

public class FabricBountifulFares implements ModInitializer {

    @Override
    public void onInitialize() {
//        BFComponents.TIFFIN_CONTENTS = () -> registerComponentType(BountifulFares.MOD_ID, "tiffin_contents", (builder) ->
//                builder.persistent(TiffinContents.CODEC).networkSynchronized(TiffinContents.STREAM_CODEC).cacheEncoding());
//        BFComponents.TIFFIN_INTERACTABLE = () -> registerComponentType(BountifulFares.MOD_ID, "interactable", (builder) ->
//                builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).cacheEncoding());
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricTrellisPlantResourceLoader());
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricTrellisCropResourceLoader());
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricGrassSeedsInteractionResourceLoader());
        BountifulFares.init();
////        BFLootTableModifiers.modifyLootTables();
        addTiffin(TOOLS_AND_UTILITIES, BFItems.SUN_HAT.get(), null);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(null).get(), DyeColor.WHITE);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.WHITE).get(), DyeColor.LIGHT_GRAY);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.LIGHT_GRAY).get(), DyeColor.GRAY);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.GRAY).get(), DyeColor.BLACK);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.BLACK).get(), DyeColor.BROWN);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.BROWN).get(), DyeColor.RED);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.RED).get(), DyeColor.ORANGE);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.ORANGE).get(), DyeColor.YELLOW);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.YELLOW).get(), DyeColor.LIME);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.LIME).get(), DyeColor.GREEN);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.GREEN).get(), DyeColor.CYAN);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.CYAN).get(), DyeColor.LIGHT_BLUE);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.LIGHT_BLUE).get(), DyeColor.BLUE);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.BLUE).get(), DyeColor.PURPLE);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.PURPLE).get(), DyeColor.MAGENTA);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.MAGENTA).get(), DyeColor.PINK);
        addTiffin(FOOD_AND_DRINKS, BFItems.TORCHFLOWER_TEA_BOTTLE.get(), null);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(null).get(), DyeColor.WHITE);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.WHITE).get(), DyeColor.LIGHT_GRAY);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.LIGHT_GRAY).get(), DyeColor.GRAY);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.GRAY).get(), DyeColor.BLACK);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.BLACK).get(), DyeColor.BROWN);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.BROWN).get(), DyeColor.RED);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.RED).get(), DyeColor.ORANGE);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.ORANGE).get(), DyeColor.YELLOW);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.YELLOW).get(), DyeColor.LIME);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.LIME).get(), DyeColor.GREEN);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.GREEN).get(), DyeColor.CYAN);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.CYAN).get(), DyeColor.LIGHT_BLUE);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.LIGHT_BLUE).get(), DyeColor.BLUE);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.BLUE).get(), DyeColor.PURPLE);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.PURPLE).get(), DyeColor.MAGENTA);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.MAGENTA).get(), DyeColor.PINK);
        BFItemGroupAdditions.registerItemGroupAdditions();
        BFMessages.registerPayloads();
        DatagenOnlyItems.registerDatagenItems();
    }


    public <T> DataComponentType<T> registerComponentType(String modId, String name, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, ResourceLocation.fromNamespaceAndPath(modId, name), (builder.apply(DataComponentType.builder())).build());
    }
}
