package net.hecco.bountifulfares.compat;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hecco.bountifulfares.BountifulFares.*;


public class DatagenOnlyItems {
    private static void registerDatagenOnlyItem(String modId, String name) {
        if (BountifulFares.isDatagen()) {
            Registry.register(Registries.ITEM, Identifier.of(modId, name), new Item(new Item.Settings()));
        }
    }

    public static void registerDatagenItems() {
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "wintergreen_planks");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "acorn_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "maroon_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "peach_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "vermilion_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "amber_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "banana_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "artichoke_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "mold_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "sage_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "sap_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "shamrock_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "mint_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "cerulean_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "navy_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "periwinkle_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "grape_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "indigo_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "mauve_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "velvet_wool");
        registerDatagenOnlyItem(ELS_AND_LS_DYES_MOD_ID, "fuchsia_wool");

        registerDatagenOnlyItem(EXCESSIVE_BUILDING_MOD_ID, "ancient_planks");

        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "maroon_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "rose_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "coral_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "ginger_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "tan_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "beige_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "amber_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "olive_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "forest_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "verdant_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "teal_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "mint_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "aqua_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "slate_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "navy_wool");
        registerDatagenOnlyItem(DYE_DEPOT_MOD_ID, "indigo_wool");

        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "redwood_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "sugi_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "wisteria_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "fir_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "willow_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "aspen_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "maple_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "cypress_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "olive_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "joshua_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "ghaf_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "palo_verde_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "coconut_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "cedar_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "larch_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "mahogany_planks");
        registerDatagenOnlyItem(NATURES_SPIRIT_MOD_ID, "saxaul_planks");

        registerDatagenOnlyItem(SPAWN_MOD_ID, "rotten_planks");

        registerDatagenOnlyItem(ARTS_AND_CRAFTS_MOD_ID, "cork_planks");

        registerDatagenOnlyItem(DELICATE_DYES_MOD_ID, "coral_wool");
        registerDatagenOnlyItem(DELICATE_DYES_MOD_ID, "canary_wool");
        registerDatagenOnlyItem(DELICATE_DYES_MOD_ID, "wasabi_wool");
        registerDatagenOnlyItem(DELICATE_DYES_MOD_ID, "sacramento_wool");
        registerDatagenOnlyItem(DELICATE_DYES_MOD_ID, "sky_wool");
        registerDatagenOnlyItem(DELICATE_DYES_MOD_ID, "blurple_wool");
        registerDatagenOnlyItem(DELICATE_DYES_MOD_ID, "sangria_wool");
        registerDatagenOnlyItem(DELICATE_DYES_MOD_ID, "rose_wool");

        registerDatagenOnlyItem(APPLEDOG_MOD_ID, "dogapple");

        registerDatagenOnlyItem(DUNGEONS_DELIGHT_MOD_ID, "wormwood_planks");
    }

}
