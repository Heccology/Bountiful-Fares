package net.hecco.bountifulfares.compat;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class BFResourcePacks {
    private static void registerBuiltinResourcePack(ModContainer modContainer, String forModID) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    new Identifier(BountifulFares.MOD_ID, forModID + "_res"),
                    modContainer,
                    Text.translatable("pack." + BountifulFares.MOD_ID + "." + forModID),
                    ResourcePackActivationType.ALWAYS_ENABLED
            );
    }

    private static void registerBuiltinResourcePack(ModContainer modContainer, String forModID, String additional) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier(BountifulFares.MOD_ID, forModID + "_res_" + additional),
                modContainer,
                Text.translatable("pack." + BountifulFares.MOD_ID + "." + forModID),
                ResourcePackActivationType.ALWAYS_ENABLED
        );
    }

    private static void registerBuiltinDataPack(ModContainer modContainer, String packId) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    new Identifier(BountifulFares.MOD_ID, packId + "_dat"),
                    modContainer,
                    Text.translatable("pack." + BountifulFares.MOD_ID + "." + packId),
                    ResourcePackActivationType.ALWAYS_ENABLED
            );
    }

    private static void registerBuiltinDataPack(ModContainer modContainer, String packId, String additional) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier(BountifulFares.MOD_ID, packId + "_dat_" + additional),
                modContainer,
                Text.translatable("pack." + BountifulFares.MOD_ID + "." + packId),
                ResourcePackActivationType.ALWAYS_ENABLED
        );
    }

    public static void registerBuiltinResourcePacks() {
        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(BountifulFares.MOD_ID);
        if (modContainer.isPresent()) {
            if (BountifulFares.isModLoaded(BountifulFares.AMENDMENTS_MOD_ID)) {
                registerBuiltinResourcePack(modContainer.get(), BountifulFares.AMENDMENTS_MOD_ID);
                registerBuiltinDataPack(modContainer.get(), BountifulFares.AMENDMENTS_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.DYE_DEPOT_MOD_ID)) {
                if (BountifulFares.CONFIG.isRenameItemsToMatchDyes()) {
                    registerBuiltinResourcePack(modContainer.get(), BountifulFares.DYE_DEPOT_MOD_ID, "rename");
                } else {
                    registerBuiltinResourcePack(modContainer.get(), BountifulFares.DYE_DEPOT_MOD_ID);
                }
                boolean amber = BountifulFares.CONFIG.isHoneysuckleToAmberDye();
                boolean beige = BountifulFares.CONFIG.isChamomileToBeigeDye();
                if (amber && beige) {
                    registerBuiltinDataPack(modContainer.get(), BountifulFares.DYE_DEPOT_MOD_ID, "htoa_ctob");
                } else if (amber) {
                    registerBuiltinDataPack(modContainer.get(), BountifulFares.DYE_DEPOT_MOD_ID, "htoa");
                } else if (beige) {
                    registerBuiltinDataPack(modContainer.get(), BountifulFares.DYE_DEPOT_MOD_ID, "ctob");
                } else {
                    registerBuiltinDataPack(modContainer.get(), BountifulFares.DYE_DEPOT_MOD_ID);
                }
            }
            if (BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
                registerBuiltinResourcePack(modContainer.get(), BountifulFares.ELS_AND_LS_DYES_MOD_ID);
                if (BountifulFares.CONFIG.isHoneysuckleToBananaDye()) {
                    registerBuiltinDataPack(modContainer.get(), BountifulFares.ELS_AND_LS_DYES_MOD_ID, "htob");
                } else {
                    registerBuiltinDataPack(modContainer.get(), BountifulFares.ELS_AND_LS_DYES_MOD_ID);

                }
            }
            if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                registerBuiltinResourcePack(modContainer.get(), BountifulFares.EXCESSIVE_BUILDING_MOD_ID);
                registerBuiltinDataPack(modContainer.get(), BountifulFares.EXCESSIVE_BUILDING_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
                registerBuiltinResourcePack(modContainer.get(), BountifulFares.NATURES_SPIRIT_MOD_ID);
                registerBuiltinDataPack(modContainer.get(), BountifulFares.NATURES_SPIRIT_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
                registerBuiltinResourcePack(modContainer.get(), BountifulFares.SPAWN_MOD_ID);
                registerBuiltinDataPack(modContainer.get(), BountifulFares.SPAWN_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID)) {
                registerBuiltinResourcePack(modContainer.get(), BountifulFares.FARMERS_DELIGHT_MOD_ID);
                registerBuiltinDataPack(modContainer.get(), BountifulFares.FARMERS_DELIGHT_MOD_ID);
            }
//            if (BountifulFares.isModLoaded(BountifulFares.DRAMATIC_DOORS_MOD_ID)) {
//                registerBuiltinResourcePack(modContainer.get(), BountifulFares.DRAMATIC_DOORS_MOD_ID);
////                registerBuiltinDataPack(modContainer.get(), BountifulFares.DRAMATIC_DOORS_MOD_ID);
//            }
            if (BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID)) {
                registerBuiltinResourcePack(modContainer.get(), BountifulFares.TWIGS_MOD_ID);
                registerBuiltinDataPack(modContainer.get(), BountifulFares.TWIGS_MOD_ID);
            }
            if (BountifulFares.isModLoaded(BountifulFares.WILDER_WILD_MOD_ID)) {
                registerBuiltinResourcePack(modContainer.get(), BountifulFares.WILDER_WILD_MOD_ID);
//                registerBuiltinDataPack(modContainer.get(), BountifulFares.WILDER_WILD_MOD_ID);
            }
            ResourceManagerHelper.registerBuiltinResourcePack(
                    new Identifier(BountifulFares.MOD_ID, "vanilla_item_override"),
                    modContainer.get(),
                    Text.translatable("pack." + BountifulFares.MOD_ID + "." + "vanilla_item_override"),
                    ResourcePackActivationType.DEFAULT_ENABLED);
        }
    }
}
