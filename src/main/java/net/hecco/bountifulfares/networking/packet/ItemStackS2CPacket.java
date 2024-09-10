package net.hecco.bountifulfares.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class ItemStackS2CPacket {
//    public static void receive(MinecraftClient client, PacketByteBuf buf, PacketSender responseSender) {
//        int size = buf.readInt();
//        DefaultedList<ItemStack> list = DefaultedList.ofSize(size, ItemStack.EMPTY);
//        list.set(0, buf.readItemStack());
//        BlockPos position = buf.readBlockPos();
//
//        client.execute(() -> {
//            if (client.world != null && client.world.getBlockEntity(position) instanceof CeramicDishBlockEntity blockEntity) {
//                blockEntity.setInventory(list);
//            }
//        });
//    }
}
