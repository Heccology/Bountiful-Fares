package net.hecco.bountifulfares.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.networking.packet.CeramicColorS2CPacket;
import net.hecco.bountifulfares.networking.packet.ItemStackS2CPacket;
import net.minecraft.util.Identifier;

public class BFMessages {

    public static final Identifier CERAMIC_DISH_ITEM_SYNC = Identifier.of(BountifulFares.MOD_ID, "ceramic_dish_item_sync");
    public static final Identifier CERAMIC_COLOR_SYNC = Identifier.of(BountifulFares.MOD_ID, "ceramic_color_sync");

    public static void registerS2CPackets() {
//        ClientPlayNetworking.registerGlobalReceiver(CERAMIC_DISH_ITEM_SYNC, ItemStackS2CPacket::receive);
//        ClientPlayNetworking.registerGlobalReceiver(CERAMIC_COLOR_SYNC, CeramicColorS2CPacket::receive);
    }
}
