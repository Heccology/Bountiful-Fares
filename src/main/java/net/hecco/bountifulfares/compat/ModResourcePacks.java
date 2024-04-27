package net.hecco.bountifulfares.compat;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModResourcePacks {
    private static void registerBuiltinResourcePack(ModContainer modContainer, String forModID) {
        if (FabricLoader.getInstance().isModLoaded(forModID)) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    new Identifier(BountifulFares.MOD_ID, forModID + "_res"),
                    modContainer,
                    Text.translatable("pack." + BountifulFares.MOD_ID + "." + forModID),
                    ResourcePackActivationType.ALWAYS_ENABLED
            );
        }
    }

    private static void registerBuiltinDataPack(ModContainer modContainer, String packId, String nameId) {
        if (!FabricLoader.getInstance().isModLoaded(packId)) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    new Identifier(BountifulFares.MOD_ID, packId + "_dat"),
                    modContainer,
                    Text.translatable("pack." + BountifulFares.MOD_ID + "." + nameId),
                    ResourcePackActivationType.ALWAYS_ENABLED
            );
        }
    }

    public static void registerBuiltinResourcePacks() {
        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(BountifulFares.MOD_ID);
        if (modContainer.isPresent()) {
            registerBuiltinResourcePack(modContainer.get(), BountifulFares.AMENDMENTS_MOD_ID);
            registerBuiltinDataPack(modContainer.get(), BountifulFares.AMENDMENTS_MOD_ID, BountifulFares.AMENDMENTS_MOD_ID);
            registerBuiltinDataPack(modContainer.get(), BountifulFares.ELS_AND_LS_DYES_MOD_ID, BountifulFares.DYE_DEPOT_MOD_ID);
            registerBuiltinResourcePack(modContainer.get(), BountifulFares.DYE_DEPOT_MOD_ID);
            registerBuiltinResourcePack(modContainer.get(), BountifulFares.ELS_AND_LS_DYES_MOD_ID);
            registerBuiltinDataPack(modContainer.get(), BountifulFares.DYE_DEPOT_MOD_ID, BountifulFares.ELS_AND_LS_DYES_MOD_ID);
        }
    }
}
