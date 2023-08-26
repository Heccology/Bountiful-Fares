package net.hecco.bountifulcuisine.block.custom.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class CheckeredCeramicTilesBlockEntity extends BlockEntity {
    public CheckeredCeramicTilesBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CHECKERED_CERAMIC_TILES_BLOCK_ENTITY, pos, state);
    }
    public static final int DEFAULT_COLOR = 16777215;
    public int color = DEFAULT_COLOR;


    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putInt("color", color);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        color = nbt.getInt("color");
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
            return CheckeredCeramicTilesBlockEntity.DEFAULT_COLOR;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof CheckeredCeramicTilesBlockEntity hexBlockEntity){
            return hexBlockEntity.color;
        } else {
            return CheckeredCeramicTilesBlockEntity.DEFAULT_COLOR;
        }
    }

    public void setColor(int color) {
        this.color = color;
    }
}
