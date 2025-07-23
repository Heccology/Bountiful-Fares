package net.hecco.bountifulfares.registry;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.hecco.bountifulfares.networking.payload.*;

public class BFMessages {
    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(CeramicDishEmptyPayload.ID, (payload, context) ->
                context.client().execute(() -> net.hecco.bountifulfares.networking.BFMessages.ceramicDishEmpty(payload)));

        ClientPlayNetworking.registerGlobalReceiver(CeramicDishItemPayload.ID, (payload, context) ->
                context.client().execute(() -> net.hecco.bountifulfares.networking.BFMessages.ceramicDishItem(payload)));

        ClientPlayNetworking.registerGlobalReceiver(CeramicBlockColorPayload.ID, (payload, context) ->
                context.client().execute(() -> net.hecco.bountifulfares.networking.BFMessages.ceramicBlockColor(payload)));

        ClientPlayNetworking.registerGlobalReceiver(TrellisPlantPayload.ID, (payload, context) ->
                context.client().execute(() -> net.hecco.bountifulfares.networking.BFMessages.trellisPlant(payload)));

        ClientPlayNetworking.registerGlobalReceiver(TrellisEmptyPayload.ID, (payload, context) ->
                context.client().execute(() -> net.hecco.bountifulfares.networking.BFMessages.trellisEmpty(payload)));
    }

    public static void registerPayloads() {
        PayloadTypeRegistry.playS2C().register(CeramicDishItemPayload.ID, CeramicDishItemPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(CeramicBlockColorPayload.ID, CeramicBlockColorPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(CeramicDishEmptyPayload.ID, CeramicDishEmptyPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(TrellisPlantPayload.ID, TrellisPlantPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(TrellisEmptyPayload.ID, TrellisEmptyPayload.CODEC);
    }
}
