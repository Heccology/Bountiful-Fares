package net.hecco.bountifulfares.networking.payload;

import net.hecco.bountifulfares.networking.BFMessages;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.BlockPos;

public record CeramicDishItemPayload(BlockPos pos, ItemStack stack) implements CustomPayload
{
    public static final CustomPayload.Id<CeramicDishItemPayload> ID = new CustomPayload.Id<>(BFMessages.CERAMIC_DISH_ITEM);
    public static final PacketCodec<RegistryByteBuf, CeramicDishItemPayload> CODEC =
            PacketCodec.tuple(
                    BlockPos.PACKET_CODEC, CeramicDishItemPayload::pos,
                    ItemStack.PACKET_CODEC, CeramicDishItemPayload::stack,
                    CeramicDishItemPayload::new
            );

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}
