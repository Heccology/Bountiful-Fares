package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.ChamomileCandleBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ChamomileCandleBlock extends InfusedCandleBlock {
    public ChamomileCandleBlock(Properties settings) {
        super(BFEffects.EBULLIENCE, settings);
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChamomileCandleBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, BFBlockEntities.CHAMOMILE_CANDLE_BLOCK_ENTITY.get(), ChamomileCandleBlockEntity::tick);
    }
}
