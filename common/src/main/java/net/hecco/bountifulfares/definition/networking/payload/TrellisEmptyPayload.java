package net.hecco.bountifulfares.definition.networking.payload;

import net.hecco.bountifulfares.definition.networking.BFMessages;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record TrellisEmptyPayload(BlockPos pos) implements CustomPacketPayload
{
    public static final Type<TrellisEmptyPayload> ID = new Type<>(BFMessages.TRELLIS_EMPTY);
    public static final StreamCodec<RegistryFriendlyByteBuf, TrellisEmptyPayload> CODEC =
            StreamCodec.composite(
                    BlockPos.STREAM_CODEC, TrellisEmptyPayload::pos,
                    TrellisEmptyPayload::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return ID;
    }
}
