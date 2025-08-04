package net.hecco.bountifulfares.definition.block.entity;

import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class DyeableCeramicBlockEntity extends DyeableBlockEntity {
    public DyeableCeramicBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.CERAMIC_TILES_BLOCK_ENTITY.get(), pos, state);
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
