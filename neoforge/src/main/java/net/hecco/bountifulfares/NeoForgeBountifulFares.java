package net.hecco.bountifulfares;


import net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import oshi.util.tuples.Pair;

@Mod(BountifulFares.MOD_ID)
public class NeoForgeBountifulFares {


    public NeoForgeBountifulFares(IEventBus eventBus) {
        BountifulFares.init();
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::creativeModeTabSetup);
    }

    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {
        BountifulFaresClient.onInitializeClient();
    }

    @SubscribeEvent
    public void creativeModeTabSetup(BuildCreativeModeTabContentsEvent event) {
        BFItemGroupAdditions.registerItemGroupAdditions();

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            for (Pair<ItemLike, ItemLike> entry : BFItemGroupAdditions.BUILDING_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            for (Pair<ItemLike, ItemLike> entry : BFItemGroupAdditions.NATURAL_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (Pair<ItemLike, ItemLike> entry : BFItemGroupAdditions.FUNCTIONAL_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            for (Pair<ItemLike, ItemLike> entry : BFItemGroupAdditions.REDSTONE_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            for (Pair<ItemLike, ItemLike> entry : BFItemGroupAdditions.TOOLS_AND_UTILITIES) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            for (Pair<ItemLike, ItemLike> entry : BFItemGroupAdditions.COMBAT) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            for (Pair<ItemLike, ItemLike> entry : BFItemGroupAdditions.COLORED_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            for (Pair<ItemLike, ItemLike> entry : BFItemGroupAdditions.INGREDIENTS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            for (Pair<ItemLike, ItemLike> entry : BFItemGroupAdditions.FOOD_AND_DRINKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.OP_BLOCKS && Minecraft.getInstance().options.operatorItemsTab().get()) {
            for (Pair<ItemLike, ItemLike> entry : BFItemGroupAdditions.OP_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

    }
}