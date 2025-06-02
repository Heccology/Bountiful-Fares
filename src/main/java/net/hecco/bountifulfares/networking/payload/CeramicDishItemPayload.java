package net.hecco.bountifulfares.networking.payload;

import net.hecco.bountifulfares.networking.BFMessages;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;

public record CeramicDishItemPayload(BlockPos pos, ItemStack stack) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type<CeramicDishItemPayload> ID = new CustomPacketPayload.Type<>(BFMessages.CERAMIC_DISH_ITEM);
    public static final StreamCodec<RegistryFriendlyByteBuf, CeramicDishItemPayload> CODEC =
            StreamCodec.composite(
                    BlockPos.STREAM_CODEC, CeramicDishItemPayload::pos,
                    ItemStack.STREAM_CODEC, CeramicDishItemPayload::stack,
                    CeramicDishItemPayload::new
            );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type()
    {
        return ID;
    }
}
