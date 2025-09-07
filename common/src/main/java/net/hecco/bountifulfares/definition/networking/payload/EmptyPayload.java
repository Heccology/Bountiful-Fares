package net.hecco.bountifulfares.definition.networking.payload;

import net.hecco.bountifulfares.definition.networking.BFMessages;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record EmptyPayload() implements CustomPacketPayload {
    public static final Type<EmptyPayload> ID = new Type<>(BFMessages.USE_ARTISAN_BRUSH_IN_INVENTORY);

    public static final StreamCodec<FriendlyByteBuf, EmptyPayload> CODEC =
            StreamCodec.ofMember(EmptyPayload::encode, EmptyPayload::decode);

    private void encode(FriendlyByteBuf buf) {
    }

    private static EmptyPayload decode(FriendlyByteBuf buf) {
        return new EmptyPayload();
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
