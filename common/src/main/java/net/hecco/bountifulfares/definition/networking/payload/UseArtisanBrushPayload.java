package net.hecco.bountifulfares.definition.networking.payload;

import net.hecco.bountifulfares.definition.networking.BFMessages;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record UseArtisanBrushPayload() implements CustomPacketPayload {
    public static final Type<UseArtisanBrushPayload> ID = new Type<>(BFMessages.USE_ARTISAN_BRUSH_IN_INVENTORY);

    public static final StreamCodec<FriendlyByteBuf, UseArtisanBrushPayload> CODEC =
            StreamCodec.ofMember(UseArtisanBrushPayload::encode, UseArtisanBrushPayload::decode);

    private void encode(FriendlyByteBuf buf) {
    }

    private static UseArtisanBrushPayload decode(FriendlyByteBuf buf) {
        return new UseArtisanBrushPayload();
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
