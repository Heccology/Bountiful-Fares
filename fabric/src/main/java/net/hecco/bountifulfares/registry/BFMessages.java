package net.hecco.bountifulfares.registry;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.hecco.bountifulfares.definition.networking.BFPackets;
import net.hecco.bountifulfares.definition.networking.payload.CeramicDishEmptyPayload;

public class BFMessages {
    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(net.hecco.bountifulfares.definition.networking.payload.CeramicDishEmptyPayload.ID, (payload, context) ->
                context.client().execute(() -> BFPackets.ceramicDishEmpty(payload)));

        ClientPlayNetworking.registerGlobalReceiver(net.hecco.bountifulfares.definition.networking.payload.CeramicDishItemPayload.ID, (payload, context) ->
                context.client().execute(() -> BFPackets.ceramicDishItem(payload)));

        ClientPlayNetworking.registerGlobalReceiver(net.hecco.bountifulfares.definition.networking.payload.CeramicBlockColorPayload.ID, (payload, context) ->
                context.client().execute(() -> BFPackets.ceramicBlockColor(payload)));

        ClientPlayNetworking.registerGlobalReceiver(net.hecco.bountifulfares.definition.networking.payload.TrellisPlantPayload.ID, (payload, context) ->
                context.client().execute(() -> BFPackets.trellisPlant(payload)));

        ClientPlayNetworking.registerGlobalReceiver(net.hecco.bountifulfares.definition.networking.payload.TrellisEmptyPayload.ID, (payload, context) ->
                context.client().execute(() -> BFPackets.trellisEmpty(payload)));
    }

    public static void registerPayloads() {
        PayloadTypeRegistry.playS2C().register(net.hecco.bountifulfares.definition.networking.payload.CeramicDishItemPayload.ID, net.hecco.bountifulfares.definition.networking.payload.CeramicDishItemPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(net.hecco.bountifulfares.definition.networking.payload.CeramicBlockColorPayload.ID, net.hecco.bountifulfares.definition.networking.payload.CeramicBlockColorPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(net.hecco.bountifulfares.definition.networking.payload.CeramicDishEmptyPayload.ID, CeramicDishEmptyPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(net.hecco.bountifulfares.definition.networking.payload.TrellisPlantPayload.ID, net.hecco.bountifulfares.definition.networking.payload.TrellisPlantPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(net.hecco.bountifulfares.definition.networking.payload.TrellisEmptyPayload.ID, net.hecco.bountifulfares.definition.networking.payload.TrellisEmptyPayload.CODEC);
    }
}
