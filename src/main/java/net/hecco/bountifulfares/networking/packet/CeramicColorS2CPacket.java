package net.hecco.bountifulfares.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;

public class CeramicColorS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        int color = buf.readInt();
        BlockPos position = buf.readBlockPos();
        if(client.world.getBlockEntity(position) instanceof DyeableCeramicBlockEntity entity) {
            entity.color = color;
        }
        if(client.world.getBlockEntity(position) instanceof CeramicDishBlockEntity entity) {
            entity.color = color;
        }
    }
}
