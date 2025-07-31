package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CoirBedBlockEntity extends BlockEntity {
    public CoirBedBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.COIR_BED_BLOCK_ENTITY.get(), pos, state);
    }
}
