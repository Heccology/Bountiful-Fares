package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class DyeableCeramicBlockEntity extends DyeableBlockEntity {
    public DyeableCeramicBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.CERAMIC_TILES_BLOCK_ENTITY, pos, state);
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
