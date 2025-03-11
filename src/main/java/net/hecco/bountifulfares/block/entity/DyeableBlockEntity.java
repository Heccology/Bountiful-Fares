package net.hecco.bountifulfares.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public abstract class DyeableBlockEntity extends BlockEntity {
    public DyeableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static final int DEFAULT_COLOR = ColorHelper.Argb.fullAlpha(16777215);
    public int color = DEFAULT_COLOR;

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        if (color != DEFAULT_COLOR) {
            nbt.putInt("color", color);
            super.writeNbt(nbt, registryLookup);
        }
    }

    @Override
    protected void addComponents(ComponentMap.Builder componentMapBuilder) {
        if (color != DEFAULT_COLOR) {
            componentMapBuilder.add(DataComponentTypes.DYED_COLOR, new DyedColorComponent(color, true));
            super.addComponents(componentMapBuilder);
        }
    }

    @Override
    protected void readComponents(ComponentsAccess components) {
        if (components.get(DataComponentTypes.DYED_COLOR) == null) {
            color = DEFAULT_COLOR;
        } else {
            color = components.get(DataComponentTypes.DYED_COLOR).rgb();
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
