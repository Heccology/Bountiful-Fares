package net.hecco.bountifulfares.networking.payload;

import net.hecco.bountifulfares.networking.BFMessages;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.BlockPos;

public record CeramicBlockColorPayload(BlockPos pos, int color) implements CustomPayload
{
    public static final CustomPayload.Id<CeramicBlockColorPayload> ID = new CustomPayload.Id<>(BFMessages.CERAMIC_BLOCK_COLOR);
    public static final PacketCodec<RegistryByteBuf, CeramicBlockColorPayload> CODEC =
            PacketCodec.tuple(
                    BlockPos.PACKET_CODEC, CeramicBlockColorPayload::pos,
                    PacketCodecs.INTEGER, CeramicBlockColorPayload::color,
                    CeramicBlockColorPayload::new
            );

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId()
    {
        return ID;
    }
}
