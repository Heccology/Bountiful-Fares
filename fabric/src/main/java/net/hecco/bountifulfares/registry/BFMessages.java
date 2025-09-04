package net.hecco.bountifulfares.registry;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.hecco.bountifulfares.definition.networking.BFPackets;
import net.hecco.bountifulfares.definition.networking.payload.*;

public class BFMessages {
    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(CeramicDishEmptyPayload.ID, (payload, context) ->
                context.client().execute(() -> BFPackets.ceramicDishEmpty(payload)));

        ClientPlayNetworking.registerGlobalReceiver(CeramicDishItemPayload.ID, (payload, context) ->
                context.client().execute(() -> BFPackets.ceramicDishItem(payload)));

        ClientPlayNetworking.registerGlobalReceiver(CeramicBlockColorPayload.ID, (payload, context) ->
                context.client().execute(() -> BFPackets.ceramicBlockColor(payload)));

        ClientPlayNetworking.registerGlobalReceiver(TrellisPlantPayload.ID, (payload, context) ->
                context.client().execute(() -> BFPackets.trellisPlant(payload)));

        ClientPlayNetworking.registerGlobalReceiver(TrellisEmptyPayload.ID, (payload, context) ->
                context.client().execute(() -> BFPackets.trellisEmpty(payload)));

        ClientPlayNetworking.registerGlobalReceiver(TrellisSyncPayload.ID, (payload, context) ->
                context.client().execute(() -> BFPackets.trellisSync(payload)));

        ServerPlayNetworking.registerGlobalReceiver(TiffinFillPayload.ID, (payload, context) ->
                context.server().execute(() -> BFPackets.tiffinFill(payload, context.player())));
    }

    public static void registerPayloads() {
        PayloadTypeRegistry.playS2C().register(CeramicDishItemPayload.ID, CeramicDishItemPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(CeramicBlockColorPayload.ID, CeramicBlockColorPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(CeramicDishEmptyPayload.ID, CeramicDishEmptyPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(TrellisPlantPayload.ID, TrellisPlantPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(TrellisEmptyPayload.ID, TrellisEmptyPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(TrellisSyncPayload.ID, TrellisSyncPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(TiffinFillPayload.ID, TiffinFillPayload.CODEC);
    }
}
