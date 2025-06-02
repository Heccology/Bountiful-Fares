package net.hecco.bountifulfares.networking.payload;

import net.hecco.bountifulfares.networking.BFMessages;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record CeramicDishEmptyPayload(BlockPos pos) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<CeramicDishEmptyPayload> ID = new CustomPacketPayload.Type<>(BFMessages.CERAMIC_DISH_EMPTY);
    public static final StreamCodec<RegistryFriendlyByteBuf, CeramicDishEmptyPayload> CODEC =
            StreamCodec.composite(
                    BlockPos.STREAM_CODEC, CeramicDishEmptyPayload::pos,
                    CeramicDishEmptyPayload::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return ID;
    }
}
