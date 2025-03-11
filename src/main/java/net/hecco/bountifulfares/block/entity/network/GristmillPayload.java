package net.hecco.bountifulfares.block.entity.network;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

//public record GristmillPayload(BlockPos pos, int progress) implements CustomPayload {
//    public static final Id<GristmillPayload> ID = new Id<>(Identifier.of(BountifulFares.MOD_ID, "gristmill"));
//    public static final PacketCodec<RegistryByteBuf, GristmillPayload> PACKET_CODEC = PacketCodec.tuple(
//            BlockPos.PACKET_CODEC, GristmillPayload::pos,
//            PacketCodecs.INTEGER, GristmillPayload::progress,
//            GristmillPayload::new);
//
//    @Override
//    public Id<? extends CustomPayload> getId() {
//        return ID;
//    }
//}
