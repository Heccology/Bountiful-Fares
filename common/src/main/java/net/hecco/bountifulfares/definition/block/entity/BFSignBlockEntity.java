package net.hecco.bountifulfares.definition.block.entity;

import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BFSignBlockEntity extends SignBlockEntity {
    public BFSignBlockEntity(BlockPos pos, BlockState blockState) {
        super(BFBlockEntities.SIGN_BLOCK_ENTITY.get(), pos, blockState);
    }

    public BFSignBlockEntity(BlockEntityType type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
}
