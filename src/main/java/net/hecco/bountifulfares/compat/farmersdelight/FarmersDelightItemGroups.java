package net.hecco.bountifulfares.compat.farmersdelight;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.misc.BFItemGroups;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class FarmersDelightItemGroups
{
    public static final RegistryKey<ItemGroup> BOUNTIFUL_FARES_TAB =
            RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(BountifulFares.MOD_ID, "bountiful_fares")
            );
    public static final RegistryKey<ItemGroup> FARMERS_DELIGHT_TAB =
            RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(BountifulFares.FARMERS_DELIGHT_MOD_ID, "farmersdelight")
            );

    public static void tabFarmersDelight(FabricItemGroupEntries tab)
    {
        Block warped_cabinet = Registries.BLOCK.get(Identifier.of(BountifulFares.FARMERS_DELIGHT_MOD_ID, "warped_cabinet"));

        tab.addAfter(warped_cabinet, FarmersDelightBlocks.HOARY_CABINET);
        tab.addAfter(FarmersDelightBlocks.HOARY_CABINET, FarmersDelightBlocks.WALNUT_CABINET);
    }

    public static void tabBountifulFares(FabricItemGroupEntries tab)
    {
        tab.addAfter(BFItems.HOARY_CHEST_BOAT, FarmersDelightBlocks.HOARY_CABINET);
        tab.addAfter(BFItems.WALNUT_CHEST_BOAT, FarmersDelightBlocks.WALNUT_CABINET);
    }

    public static void registerModItemTabs()
    {
        ItemGroupEvents.modifyEntriesEvent(BOUNTIFUL_FARES_TAB).register(FarmersDelightItemGroups::tabBountifulFares);
        ItemGroupEvents.modifyEntriesEvent(FARMERS_DELIGHT_TAB).register(FarmersDelightItemGroups::tabFarmersDelight);
    }
}
