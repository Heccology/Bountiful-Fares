package net.hecco.bountifulfares;


import net.hecco.bountifulfares.definition.networking.BFPackets;
import net.hecco.bountifulfares.definition.networking.payload.*;
import net.hecco.bountifulfares.registry.BFNeoForgeLootTableModifiers;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import oshi.util.tuples.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Mod(BountifulFares.MOD_ID)
public class NeoForgeBountifulFares {

    public static final Map<ItemLike, Integer> FUELS = new HashMap<>();
    public static final Map<TagKey<Item>, Integer> TAG_FUELS = new HashMap<>();

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


        TAG_FUELS.put(BFItemTags.FRUIT_LOGS, 200);
        TAG_FUELS.put(BFItemTags.HOARY_LOGS, 300);
        TAG_FUELS.put(BFItemTags.WALNUT_LOGS, 300);
        TAG_FUELS.put(BFItemTags.PICKETS, 200);

        for (Supplier<Block> block : BFBlocks.TRELLISES.values()) {
            if (!(BuiltInRegistries.BLOCK.getKey(block.get()).getPath() == "crimson_trellis" || BuiltInRegistries.BLOCK.getKey(block.get()).getPath() == "warped_trellis")) {
                FUELS.put(block.get(), 300);
            }
        }

        FUELS.put(BFBlocks.GRISTMILL.get(), 300);
        FUELS.put(BFBlocks.WHITE_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.GRAY_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.BLACK_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.BROWN_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.RED_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.ORANGE_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.YELLOW_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.LIME_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.GREEN_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.CYAN_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.BLUE_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.PURPLE_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.MAGENTA_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.PINK_JACK_O_STRAW.get(), 400);
        FUELS.put(BFBlocks.PALM_FROND.get(), 100);
        FUELS.put(BFItems.COCONUT_COIR.get(), 100);
        FUELS.put(BFBlocks.PACKED_COCONUT_COIR.get(), 400);
        FUELS.put(BFBlocks.COIR_CARPET.get(), 200);
        FUELS.put(BFBlocks.COIR_BRICKS.get(), 400);
        FUELS.put(BFBlocks.COIR_BRICK_SLAB.get(), 400);
        FUELS.put(BFBlocks.COIR_BRICK_STAIRS.get(), 400);
        FUELS.put(BFBlocks.COIR_BRICK_WALL.get(), 400);
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
        }

    }
}