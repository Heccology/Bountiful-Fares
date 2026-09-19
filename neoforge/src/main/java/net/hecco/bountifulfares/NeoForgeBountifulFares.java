package net.hecco.bountifulfares;


import net.hecco.bountifulfares.config.NeoForgeBFConfig;
import net.hecco.bountifulfares.definition.networking.BFC2SPackets;
import net.hecco.bountifulfares.definition.networking.BFS2CPackets;
import net.hecco.bountifulfares.definition.networking.payload.*;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.mixin.util.BlockEntityAccessor;
import net.hecco.bountifulfares.registry.BFBiomeModifiers;
import net.hecco.bountifulfares.registry.BFNeoForgeLootTableModifiers;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions;
import net.hecco.bountifulfares.registry.misc.BFResourcePacks;
import net.hecco.bountifulfares.registry.util.BFNoteBlockInstruments;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.hecco.nexuslib.lib.util.ItemGroupAddition;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
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

import java.util.*;

@Mod(BountifulFares.MOD_ID)
public class NeoForgeBountifulFares {

    public static final Map<ItemLike, Integer> FUELS = new HashMap<>();
    public static final Map<TagKey<Item>, Integer> TAG_FUELS = new HashMap<>();

    public static ModContainer modContainer;

    public NeoForgeBountifulFares(IEventBus eventBus, ModContainer container) {
        container.registerConfig(ModConfig.Type.COMMON, NeoForgeBFConfig.COMMON_SPEC);
        container.registerConfig(ModConfig.Type.CLIENT, NeoForgeBFConfig.CLIENT_SPEC);
        BountifulFares.init(this.getClass());
        BFNeoForgeLootTableModifiers.LOOT_MODIFIERS.register(eventBus);

        eventBus.addListener(this::payloadHandlersSetup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::commonSetup);
        BFBiomeModifiers.BIOME_MODIFIERS.register(eventBus);
        modContainer = container;

        BFResourcePacks.registerBuiltinResourcePacks();
    }

    public void clientSetup(FMLClientSetupEvent event) {
        BountifulFaresClient.onInitializeClient();
    }

    public void commonSetup(FMLCommonSetupEvent event) {
        BFNoteBlockInstruments.OCARINA.soundEvent = BFSounds.NOTE_BLOCK_OCARINA;
        BFNoteBlockInstruments.OLD_PIANO.soundEvent = BFSounds.NOTE_BLOCK_OLD_PIANO;
        BFNoteBlockInstruments.STEEL_DRUM.soundEvent = BFSounds.NOTE_BLOCK_STEEL_DRUM;

        if (Services.PLATFORM.get().getBoolConfigValue("addItemsToVanillaTabs")) {
            BFItemGroupAdditions.registerItemGroupAdditions();
        }

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
                                BFS2CPackets.ceramicDishEmpty(payload);
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
                                BFS2CPackets.ceramicDishItem(payload);
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
                                BFS2CPackets.ceramicBlockColor(payload);
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
                                BFS2CPackets.trellisPlant(payload);
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
                                BFS2CPackets.trellisEmpty(payload);
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
                                BFS2CPackets.trellisSync(payload);
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
                                BFC2SPackets.tiffinFill(payload, (ServerPlayer) ctx.player());
                            }
                    )
            );
            registrar.playBidirectional(
                    UseArtisanBrushPayload.ID,
                    UseArtisanBrushPayload.CODEC,
                    new DirectionalPayloadHandler<>(
                            (payload, ctx) -> ctx.enqueueWork(() -> {
                            }),
                            (payload, ctx) -> {
                                BFC2SPackets.useArtisanBrushInInventory(payload, (ServerPlayer) ctx.player());
                            }
                    )
            );
        }
    }
}
