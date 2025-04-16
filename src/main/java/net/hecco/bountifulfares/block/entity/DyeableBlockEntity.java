package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.block.custom.DyeableCeramicBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class DyeableBlockEntity extends BlockEntity {
    public DyeableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static final int DEFAULT_COLOR = ColorHelper.Argb.fullAlpha(16777215);
    public int color = DEFAULT_COLOR;

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        if (color != DEFAULT_COLOR) {
            nbt.putInt("color", color);
        }
    }

    @Override
    protected void addComponents(ComponentMap.Builder componentMapBuilder) {
        if (color != DEFAULT_COLOR) {
            componentMapBuilder.add(DataComponentTypes.DYED_COLOR, new DyedColorComponent(color, true));
        }
        super.addComponents(componentMapBuilder);
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
        super.readNbt(nbt, registryLookup);
        if (!nbt.contains("color", NbtElement.INT_TYPE) || nbt.getInt("color") == 0) {
            color = DEFAULT_COLOR;
        } else {
            color = nbt.getInt("color");
        }
    }

    @Override
    public void markDirty()
    {
        if (
                this.getWorld() != null &&
                !this.getWorld().isClient &&
                this.getPos() != null
        )
        {
            World thisworld = this.getWorld();
            DyeableCeramicBlock.sendColorPayload(
                    (ServerWorld) thisworld, thisworld.getBlockEntity(this.getPos()), this.color);
        }
        super.markDirty();
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
