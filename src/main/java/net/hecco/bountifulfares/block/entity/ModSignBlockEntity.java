package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.MOD_SIGN_BLOCK_ENTITY, pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BFBlockEntities.MOD_SIGN_BLOCK_ENTITY;
    }
}