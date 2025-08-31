package net.hecco.bountifulfares.definition.networking.payload;

import net.hecco.bountifulfares.definition.networking.BFMessages;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;

public record TrellisPlantPayload(BlockPos pos, ItemStack stack, int stage) implements CustomPacketPayload {
    public static final Type<TrellisPlantPayload> ID = new Type<>(BFMessages.TRELLIS_PLANT);
    public static final StreamCodec<RegistryFriendlyByteBuf, TrellisPlantPayload> CODEC =
            StreamCodec.composite(
                    BlockPos.STREAM_CODEC, TrellisPlantPayload::pos,
                    ItemStack.STREAM_CODEC, TrellisPlantPayload::stack,
                    ByteBufCodecs.INT, TrellisPlantPayload::stage,
                    TrellisPlantPayload::new
            );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type()
    {
        return ID;
    }
}