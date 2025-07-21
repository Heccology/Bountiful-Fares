package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TrellisBlockEntity extends BlockEntity {
    public TrellisBlockEntity(BlockPos pos, BlockState blockState) {
        super(BFBlockEntities.TRELLIS_BLOCK_ENTITY.get(), pos, blockState);
    }
}
