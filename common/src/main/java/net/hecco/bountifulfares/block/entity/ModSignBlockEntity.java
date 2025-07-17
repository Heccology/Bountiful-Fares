package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.MOD_SIGN_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return BFBlockEntities.MOD_SIGN_BLOCK_ENTITY.get();
    }
}