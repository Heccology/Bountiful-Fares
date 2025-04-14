package net.hecco.bountifulfares.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public abstract class DyeableBlockEntity extends BlockEntity {
    public DyeableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static final int DEFAULT_COLOR = 16777215;
    public int color = DEFAULT_COLOR;

    @Override
    public void writeNbt(NbtCompound nbt) {
        if (color != DEFAULT_COLOR) {
            nbt.putInt("color", color);
            super.writeNbt(nbt);
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        if (nbt.getInt("color") == 0) {
            color = DEFAULT_COLOR;
        } else {
            super.readNbt(nbt);
            color = nbt.getInt("color");
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public static int getColor(BlockView world, BlockPos pos){
        if(world==null){
            return DyeableBlockEntity.DEFAULT_COLOR;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof DyeableBlockEntity ceramicTilesBlockEntity){
            return ceramicTilesBlockEntity.color;
        } else {
            return DyeableBlockEntity.DEFAULT_COLOR;
        }
    }


    @Override
    public void markDirty() {
        PacketByteBuf data = PacketByteBufs.create();
        data.writeInt(color);
        data.writeBlockPos(getPos());
        super.markDirty();
    }

//    @Override
////        if (!world.isClient()) {
//            PacketByteBuf data = PacketByteBufs.create();
//            data.writeInt(color);
//            data.writeBlockPos(getPos());
////            for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
////                ServerPlayNetworking.send(player, BFMessages.CERAMIC_COLOR_SYNC, data);
////            }
//        }
//        super.markDirty();
////    }
//
}
