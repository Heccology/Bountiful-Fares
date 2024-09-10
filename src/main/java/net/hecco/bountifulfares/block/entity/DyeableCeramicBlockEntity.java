package net.hecco.bountifulfares.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.hecco.bountifulfares.networking.BFMessages;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class DyeableCeramicBlockEntity extends BlockEntity {
    public DyeableCeramicBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.CERAMIC_TILES_BLOCK_ENTITY, pos, state);
    }
    public static final int DEFAULT_COLOR = 16777215;
    public int color = DEFAULT_COLOR;

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        if (color != DEFAULT_COLOR) {
            nbt.putInt("color", color);
            super.writeNbt(nbt, registryLookup);
        }
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        if (nbt.getInt("color") == 0) {
            color = DEFAULT_COLOR;
        } else {
            super.readNbt(nbt, registryLookup);
            color = nbt.getInt("color");
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    public static int getColor(BlockView world, BlockPos pos){
        if(world==null){
            return DyeableCeramicBlockEntity.DEFAULT_COLOR;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof DyeableCeramicBlockEntity ceramicTilesBlockEntity){
            return ceramicTilesBlockEntity.color;
        } else {
            return DyeableCeramicBlockEntity.DEFAULT_COLOR;
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
