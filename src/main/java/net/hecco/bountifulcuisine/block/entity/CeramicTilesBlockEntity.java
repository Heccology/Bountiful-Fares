package net.hecco.bountifulcuisine.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class CeramicTilesBlockEntity extends BlockEntity {
    public CeramicTilesBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CERAMIC_TILES_BLOCK_ENTITY, pos, state);
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

    @Override
    public void markDirty() {
        if (this.world != null) {
            markDirty(this.world, this.pos, this.getCachedState());
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
            return CeramicTilesBlockEntity.DEFAULT_COLOR;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof CeramicTilesBlockEntity ceramicTilesBlockEntity){
            return ceramicTilesBlockEntity.color;
        } else {
            return CeramicTilesBlockEntity.DEFAULT_COLOR;
        }
    }
}
