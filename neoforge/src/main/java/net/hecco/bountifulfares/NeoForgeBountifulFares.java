package net.hecco.bountifulfares;


import net.hecco.bountifulfares.config.NeoForgeBFConfig;
import net.hecco.bountifulfares.definition.networking.BFPackets;
import net.hecco.bountifulfares.definition.networking.payload.*;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.mixin.util.BlockEntityAccessor;
import net.hecco.bountifulfares.registry.BFNeoForgeLootTableModifiers;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions;
import net.hecco.bountifulfares.registry.misc.BFResourcePacks;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import oshi.util.tuples.Pair;

import java.util.*;
import java.util.function.Supplier;

@Mod(BountifulFares.MOD_ID)
public class NeoForgeBountifulFares {

    public static final Map<ItemLike, Integer> FUELS = new HashMap<>();
    public static final Map<TagKey<Item>, Integer> TAG_FUELS = new HashMap<>();

    public static ModContainer modContainer;

    public NeoForgeBountifulFares(IEventBus eventBus, ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, NeoForgeBFConfig.COMMON_SPEC);
        container.registerConfig(ModConfig.Type.CLIENT, NeoForgeBFConfig.CLIENT_SPEC);
        BountifulFares.init();
        BFNeoForgeLootTableModifiers.LOOT_MODIFIERS.register(eventBus);

        eventBus.addListener(this::payloadHandlersSetup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::creativeModeTabSetup);
        eventBus.addListener(this::commonSetup);
        this.modContainer = container;

        BFResourcePacks.registerBuiltinResourcePacks();
    }

    public void clientSetup(FMLClientSetupEvent event) {
        BountifulFaresClient.onInitializeClient();
    }

    public void commonSetup(FMLCommonSetupEvent event) {
        if (!Services.PLATFORM.get().getBoolConfigValue("showCompatItemsInRecipeViewers")) {
            NLServices.REGISTRY.registerBuiltInDatapack(BountifulFares.MOD_ID, "hide_compat_items", "Bountiful Fares - Hide Compatibility Items", true, true);
        }

        BFRegistries.registerFlammables();
        BFRegistries.registerCeramicCheckeredConversions();
        BFRegistries.registerDispenserBehaviors();
        BFRegistries.registerCauldronBehaviors();

        BFRegistries.registerStrippables();
        BFRegistries.registerTillables();
        BFRegistries.registerPathables();
        BFRegistries.registerUntintedParticleBlocks();
        BFRegistries.registerFuels();

        for (ItemLike itemlike : BFBlocks.FUELS.keySet()) {
            FUELS.put(itemlike, BFBlocks.FUELS.get(itemlike));
        }

        for (TagKey<Item> tag : BFBlocks.TAG_FUELS.keySet()) {
            TAG_FUELS.put(tag, BFBlocks.TAG_FUELS.get(tag));
        }

        Set<Block> signs = new HashSet<>(((BlockEntityAccessor) BlockEntityType.SIGN).getValidBlocks());
        signs.add(BFBlocks.WALNUT_SIGN.get());
        signs.add(BFBlocks.WALNUT_WALL_SIGN.get());
        signs.add(BFBlocks.HOARY_SIGN.get());
        signs.add(BFBlocks.HOARY_WALL_SIGN.get());
        ((BlockEntityAccessor) BlockEntityType.SIGN).setValidBlocks(signs);

        Set<Block> hangingSigns = new HashSet<>(((BlockEntityAccessor) BlockEntityType.HANGING_SIGN).getValidBlocks());
        hangingSigns.add(BFBlocks.WALNUT_HANGING_SIGN.get());
        hangingSigns.add(BFBlocks.WALNUT_WALL_HANGING_SIGN.get());
        hangingSigns.add(BFBlocks.HOARY_HANGING_SIGN.get());
        hangingSigns.add(BFBlocks.HOARY_WALL_HANGING_SIGN.get());
        ((BlockEntityAccessor) BlockEntityType.HANGING_SIGN).setValidBlocks(hangingSigns);
    }

    @SubscribeEvent
    public void payloadHandlersSetup(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        if (true) {
            registrar.playBidirectional(
                    CeramicDishEmptyPayload.ID,
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
                    CeramicDishItemPayload.ID,
                    CeramicDishItemPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                                BFPackets.ceramicDishItem(payload);
                            }),
                            (payload, ctx) -> {
                            }
                    )
            );
            registrar.playBidirectional(
                    CeramicBlockColorPayload.ID,
                    CeramicBlockColorPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                                BFPackets.ceramicBlockColor(payload);
                            }),
                            (payload, ctx) -> {
                            }
                    )
            );
            registrar.playBidirectional(
                    TrellisPlantPayload.ID,
                    TrellisPlantPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                                BFPackets.trellisPlant(payload);
                            }),
                            (payload, ctx) -> {
                            }
                    )
            );
            registrar.playBidirectional(
                    TrellisEmptyPayload.ID,
                    TrellisEmptyPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                                BFPackets.trellisEmpty(payload);
                            }),
                            (payload, ctx) -> {
                            }
                    )
            );
            registrar.playBidirectional(
                    TrellisSyncPayload.ID,
                    TrellisSyncPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                                BFPackets.trellisSync(payload);
                            }),
                            (payload, ctx) -> {
                            }
                    )
            );
            registrar.playBidirectional(
                    TiffinFillPayload.ID,
                    TiffinFillPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                            }),
                            (payload, ctx) -> {
                                BFPackets.tiffinFill(payload, (ServerPlayer) ctx.player());
                            }
                    )
            );
            registrar.playBidirectional(
                    EmptyPayload.ID,
                    EmptyPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                            }),
                            (payload, ctx) -> {
                                BFPackets.useArtisanBrushInInventory(payload, (ServerPlayer) ctx.player());
                            }
                    )
            );
        }
    }

    @SubscribeEvent
    public void creativeModeTabSetup(BuildCreativeModeTabContentsEvent event) {
        if (Services.PLATFORM.get().getBoolConfigValue("addItemsToVanillaTabs")) {
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
                    } catch (Exception ignored) {
                    }
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
                    } catch (Exception ignored) {
                    }
                }
            }
        }

    }
}