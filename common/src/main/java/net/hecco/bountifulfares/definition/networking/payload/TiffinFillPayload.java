package net.hecco.bountifulfares.definition.networking.payload;

import net.hecco.bountifulfares.definition.networking.BFMessages;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;

public record TiffinFillPayload(double fullness) implements CustomPacketPayload
{
    public static final Type<TiffinFillPayload> ID = new Type<>(BFMessages.TIFFIN_FILL);
    public static final StreamCodec<FriendlyByteBuf, TiffinFillPayload> CODEC =
            StreamCodec.ofMember(TiffinFillPayload::encode, TiffinFillPayload::decode);

    private void encode(FriendlyByteBuf buf) {
        buf.writeDouble(fullness);
    }

    private static TiffinFillPayload decode(FriendlyByteBuf buf) {
        return new TiffinFillPayload(buf.readDouble());
    }

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return ID;
    }
}
