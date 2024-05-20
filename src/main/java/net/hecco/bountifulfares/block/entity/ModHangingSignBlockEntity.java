package net.hecco.bountifulfares.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class ModHangingSignBlockEntity extends HangingSignBlockEntity {
    public ModHangingSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }
    @Override
    public BlockEntityType<?> getType() {
        return BFBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY;
    }
}
