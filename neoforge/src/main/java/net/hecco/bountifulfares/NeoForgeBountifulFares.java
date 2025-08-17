package net.hecco.bountifulfares;


import net.hecco.bountifulfares.definition.networking.BFPackets;
import net.hecco.bountifulfares.definition.networking.payload.CeramicDishEmptyPayload;
import net.hecco.bountifulfares.registry.BFNeoForgeLootTableModifiers;
import net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import oshi.util.tuples.Pair;

@Mod(BountifulFares.MOD_ID)
public class NeoForgeBountifulFares {

    public NeoForgeBountifulFares(IEventBus eventBus) {
        BountifulFares.init();
        BFNeoForgeLootTableModifiers.LOOT_MODIFIERS.register(eventBus);
        BountifulFares.CONFIG = BountifulFaresConfiguration.load();

        eventBus.addListener(this::payloadHandlersSetup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::creativeModeTabSetup);
        eventBus.addListener(this::commonSetup);
    }

    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {
        BountifulFaresClient.onInitializeClient();
    }

    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event) {
        BFRegistries.registerFlammables();
        BFRegistries.registerCeramicCheckeredConversions();
        BFRegistries.registerDispenserBehaviors();

        BFRegistries.registerStrippables();
        BFRegistries.registerTillables();
        BFRegistries.registerPathables();
    }

    @SubscribeEvent
    public void payloadHandlersSetup(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        if (true) {
            registrar.playBidirectional(
                    net.hecco.bountifulfares.definition.networking.payload.CeramicDishEmptyPayload.ID,
                    CeramicDishEmptyPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                                BFPackets.ceramicDishEmpty(payload);
                            }),
                            (payload, ctx) -> {
                            }
                    )
            );
            registrar.playBidirectional(
                    net.hecco.bountifulfares.definition.networking.payload.CeramicDishItemPayload.ID,
                    net.hecco.bountifulfares.definition.networking.payload.CeramicDishItemPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                                BFPackets.ceramicDishItem(payload);
                            }),
                            (payload, ctx) -> {
                            }
                    )
            );
            registrar.playBidirectional(
                    net.hecco.bountifulfares.definition.networking.payload.CeramicBlockColorPayload.ID,
                    net.hecco.bountifulfares.definition.networking.payload.CeramicBlockColorPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                                BFPackets.ceramicBlockColor(payload);
                            }),
                            (payload, ctx) -> {
                            }
                    )
            );
            registrar.playBidirectional(
                    net.hecco.bountifulfares.definition.networking.payload.TrellisPlantPayload.ID,
                    net.hecco.bountifulfares.definition.networking.payload.TrellisPlantPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                                BFPackets.trellisPlant(payload);
                            }),
                            (payload, ctx) -> {
                            }
                    )
            );
            registrar.playBidirectional(
                    net.hecco.bountifulfares.definition.networking.payload.TrellisEmptyPayload.ID,
                    net.hecco.bountifulfares.definition.networking.payload.TrellisEmptyPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                                BFPackets.trellisEmpty(payload);
                            }),
                            (payload, ctx) -> {
                            }
                    )
            );
        }
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
                event.insertAfter(entry.getA().asItem().getDefaultInstance(), entry.getB(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            for (Pair<ItemStack, ItemStack> entry : BFItemGroupAdditions.FOOD_AND_DRINKS_FORGE) {
                try {
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