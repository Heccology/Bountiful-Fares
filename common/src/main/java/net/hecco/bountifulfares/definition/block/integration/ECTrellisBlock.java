package net.hecco.bountifulfares.definition.block.integration;

import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.registry.integration.everycompat.EveryCompatIntegration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ECTrellisBlock extends TrellisBlock {

    public ECTrellisBlock(Properties settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return EveryCompatIntegration.EC_TRELLIS_BLOCK_ENTITY.get().create(blockPos, blockState);
    }

}
