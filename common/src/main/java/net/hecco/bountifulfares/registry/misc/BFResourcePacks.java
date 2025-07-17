package net.hecco.bountifulfares.registry.misc;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.Calendar;
import java.util.Optional;

public class BFResourcePacks {
    //Yikes
    private static void registerBuiltinResourcePack(ModContainer modContainer, String forModID) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, forModID + "_res"),
                    modContainer,
                    Component.translatable("pack." + BountifulFares.MOD_ID + "." + forModID),
                    ResourcePackActivationType.ALWAYS_ENABLED
            );
    }

    private static void registerBuiltinResourcePack(ModContainer modContainer, String forModID, String additional) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, forModID + "_res_" + additional),
                modContainer,
                Component.translatable("pack." + BountifulFares.MOD_ID + "." + forModID),
                ResourcePackActivationType.ALWAYS_ENABLED
        );
    }

    private static void registerBuiltinDataPack(ModContainer modContainer, String packId) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, packId + "_dat"),
                    modContainer,
                    Component.translatable("pack." + BountifulFares.MOD_ID + "." + packId),
                    ResourcePackActivationType.ALWAYS_ENABLED
            );
    }

    private static void registerBuiltinDataPack(ModContainer modContainer, String packId, String additional) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, packId + "_dat_" + additional),
                modContainer,
                Component.translatable("pack." + BountifulFares.MOD_ID + "." + packId),
                ResourcePackActivationType.ALWAYS_ENABLED
        );
    }

    public static void registerBuiltinResourcePacks() {
        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(BountifulFares.MOD_ID);
        if (modContainer.isPresent()) {
            if (BountifulFares.isModLoaded(BountifulFares.AMENDMENTS_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.AMENDMENTS_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.ELS_AND_LS_DYES_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.ARTS_AND_CRAFTS_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.DYE_DEPOT_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.DYE_DEPOT_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.EXCESSIVE_BUILDING_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.FARMERS_DELIGHT_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.NATURES_SPIRIT_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.SPAWN_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.TWIGS_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.DELICATE_DYES_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.DELICATE_DYES_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.APPLEDOG_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.APPLEDOG_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.DUNGEONS_DELIGHT_MOD_ID)) {
                registerBuiltinDataPack(modContainer.get(), BountifulFares.DUNGEONS_DELIGHT_MOD_ID);
            }

            if (!BountifulFares.CONFIG.showCompatItemsInRecipeViewers) {
                ResourceManagerHelper.registerBuiltinResourcePack(
                        ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hide_compat_items"),
                        modContainer.get(),
                        ResourcePackActivationType.ALWAYS_ENABLED);
            }

            ResourceManagerHelper.registerBuiltinResourcePack(
                    ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "vanilla_item_override"),
                    modContainer.get(),
                    Component.translatable("pack." + BountifulFares.MOD_ID + "." + "vanilla_item_override"),
                    ResourcePackActivationType.DEFAULT_ENABLED);

            if ((Calendar.getInstance().get(Calendar.MONTH) == Calendar.APRIL && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 1)) {
                ResourceManagerHelper.registerBuiltinResourcePack(
                        ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "lime"),
                        modContainer.get(),
                        ResourcePackActivationType.ALWAYS_ENABLED);
            }
        }
    }
}
