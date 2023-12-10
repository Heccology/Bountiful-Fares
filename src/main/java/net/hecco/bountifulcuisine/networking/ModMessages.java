package net.hecco.bountifulcuisine.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.networking.packet.ItemStackS2CPacket;
import net.minecraft.util.Identifier;

public class ModMessages {

    public static final Identifier CERAMIC_DISH_ITEM_SYNC = new Identifier(BountifulCuisine.MOD_ID, "ceramic_dish_item_sync");

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(CERAMIC_DISH_ITEM_SYNC, ItemStackS2CPacket::receive);
    }
}
