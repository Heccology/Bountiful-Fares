package net.hecco.bountifulfares;


import net.hecco.bountifulfares.item.component.TiffinContents;
import net.hecco.bountifulfares.registry.BFNeoForgeLootTableModifiers;
import net.hecco.bountifulfares.networking.BFMessages;
import net.hecco.bountifulfares.networking.payload.*;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredRegister;
import oshi.util.tuples.Pair;

import java.util.function.Supplier;

@Mod(BountifulFares.MOD_ID)
public class NeoForgeBountifulFares {
//TODO: ADD SNIFFER LOOT MODIFIERS (again cannot be bothered its like 8:30am and i have not slept)

    public NeoForgeBountifulFares(IEventBus eventBus) {
//        DeferredRegister.DataComponents registrar = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, BountifulFares.MOD_ID);
//        Supplier<DataComponentType<TiffinContents>> tiffinContents = registrar.registerComponentType("tiffin_contents",  (builder) ->
//                builder.persistent(TiffinContents.CODEC).networkSynchronized(TiffinContents.STREAM_CODEC).cacheEncoding());
//        BFComponents.TIFFIN_CONTENTS = tiffinContents.get();
        BountifulFares.init();
        BFNeoForgeLootTableModifiers.LOOT_MODIFIERS.register(eventBus); //dude the jsons for these need to be rewritten but i cannot be bothered rn - yirmiri

        eventBus.addListener(this::payloadHandlersSetup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::creativeModeTabSetup);
    }

    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {
        BountifulFaresClient.onInitializeClient();
    }

    @SubscribeEvent // on the mod event bus
    public void payloadHandlersSetup(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playBidirectional(
                CeramicDishEmptyPayload.ID,
                CeramicDishEmptyPayload.CODEC,
                new DirectionalPayloadHandler<>(
                        (payload, ctx) -> ctx.enqueueWork(() -> {
                            BFMessages.ceramicDishEmpty(payload);
                        }),
                        (payload, ctx) -> {}
                )
        );
        registrar.playBidirectional(
                CeramicDishItemPayload.ID,
                CeramicDishItemPayload.CODEC,
                new DirectionalPayloadHandler<>(
                        (payload, ctx) -> ctx.enqueueWork(() -> {
                            BFMessages.ceramicDishItem(payload);
                        }),
                        (payload, ctx) -> {}
                )
        );
        registrar.playBidirectional(
                CeramicBlockColorPayload.ID,
                CeramicBlockColorPayload.CODEC,
                new DirectionalPayloadHandler<>(
                        (payload, ctx) -> ctx.enqueueWork(() -> {
                            BFMessages.ceramicBlockColor(payload);
                        }),
                        (payload, ctx) -> {}
                )
        );
        registrar.playBidirectional(
                TrellisPlantPayload.ID,
                TrellisPlantPayload.CODEC,
                new DirectionalPayloadHandler<>(
                        (payload, ctx) -> ctx.enqueueWork(() -> {
                            BFMessages.trellisPlant(payload);
                        }),
                        (payload, ctx) -> {}
                )
        );
        registrar.playBidirectional(
                TrellisEmptyPayload.ID,
                TrellisEmptyPayload.CODEC,
                new DirectionalPayloadHandler<>(
                        (payload, ctx) -> ctx.enqueueWork(() -> {
                            BFMessages.trellisEmpty(payload);
                        }),
                        (payload, ctx) -> {}
                )
        );
    }

    @SubscribeEvent
    public void creativeModeTabSetup(BuildCreativeModeTabContentsEvent event) {
        BFItemGroupAdditions.registerItemGroupAdditions();

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            for (Pair<ItemLike, ItemStack> entry : BFItemGroupAdditions.BUILDING_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            for (Pair<ItemLike, ItemStack> entry : BFItemGroupAdditions.NATURAL_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (Pair<ItemLike, ItemStack> entry : BFItemGroupAdditions.FUNCTIONAL_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            for (Pair<ItemLike, ItemStack> entry : BFItemGroupAdditions.REDSTONE_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            for (Pair<ItemLike, ItemStack> entry : BFItemGroupAdditions.TOOLS_AND_UTILITIES) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            for (Pair<ItemStack, ItemStack> entry : BFItemGroupAdditions.TOOLS_AND_UTILITIES_FORGE) {
                try {
                    event.insertAfter(entry.getA(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                } catch (Exception ignored) {}
            }
        } else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            for (Pair<ItemLike, ItemStack> entry : BFItemGroupAdditions.COMBAT) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            for (Pair<ItemLike, ItemStack> entry : BFItemGroupAdditions.COLORED_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            for (Pair<ItemLike, ItemStack> entry : BFItemGroupAdditions.INGREDIENTS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        } else if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            for (Pair<ItemLike, ItemStack> entry : BFItemGroupAdditions.FOOD_AND_DRINKS) {
                BountifulFares.LOGGER.info(entry.getA() + " " + entry.getB());
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            for (Pair<ItemStack, ItemStack> entry : BFItemGroupAdditions.FOOD_AND_DRINKS_FORGE) {
                try {
                    BountifulFares.LOGGER.info(entry.getA() + " " + entry.getB());
                    event.insertAfter(entry.getA(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                } catch (Exception ignored) {}
            }
        } else if (event.getTabKey() == CreativeModeTabs.OP_BLOCKS && Minecraft.getInstance().options.operatorItemsTab().get()) {
            for (Pair<ItemLike, ItemStack> entry : BFItemGroupAdditions.OP_BLOCKS) {
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

    }
}