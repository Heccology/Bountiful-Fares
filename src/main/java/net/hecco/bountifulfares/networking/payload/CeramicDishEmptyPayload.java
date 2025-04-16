package net.hecco.bountifulfares.networking.payload;

import net.hecco.bountifulfares.networking.BFMessages;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.BlockPos;

public record CeramicDishEmptyPayload(BlockPos pos) implements CustomPayload
{
    public static final CustomPayload.Id<CeramicDishEmptyPayload> ID = new CustomPayload.Id<>(BFMessages.CERAMIC_DISH_EMPTY);
    public static final PacketCodec<RegistryByteBuf, CeramicDishEmptyPayload> CODEC =
            PacketCodec.tuple(
                    BlockPos.PACKET_CODEC, CeramicDishEmptyPayload::pos,
                    CeramicDishEmptyPayload::new
            );

    @Override
    public Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}
