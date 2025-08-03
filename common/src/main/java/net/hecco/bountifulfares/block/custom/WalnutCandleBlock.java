package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.WalnutCandleBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WalnutCandleBlock extends InfusedCandleBlock{

    public WalnutCandleBlock(Properties settings) {
        super(BFEffects.ENRICHMENT, settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new WalnutCandleBlockEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, BFBlockEntities.WALNUT_CANDLE_BLOCK_ENTITY.get(), WalnutCandleBlockEntity::tick);
    }
}
