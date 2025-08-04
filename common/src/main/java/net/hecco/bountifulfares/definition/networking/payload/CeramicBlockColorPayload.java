package net.hecco.bountifulfares.definition.networking.payload;

import net.hecco.bountifulfares.definition.networking.BFMessages;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record CeramicBlockColorPayload(BlockPos pos, int color) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<CeramicBlockColorPayload> ID = new CustomPacketPayload.Type<>(BFMessages.CERAMIC_BLOCK_COLOR);
    public static final StreamCodec<RegistryFriendlyByteBuf, CeramicBlockColorPayload> CODEC =
            StreamCodec.composite(
                    BlockPos.STREAM_CODEC, CeramicBlockColorPayload::pos,
                    ByteBufCodecs.INT, CeramicBlockColorPayload::color,
                    CeramicBlockColorPayload::new
            );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type()
    {
        return ID;
    }
}
