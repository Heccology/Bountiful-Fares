package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.HoneysuckleCandleBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class HoneysuckleCandleBlock extends InfusedCandleBlock {
    public HoneysuckleCandleBlock(Properties settings) {
        super(MobEffects.REGENERATION, settings);
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HoneysuckleCandleBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, BFBlockEntities.HONEYSUCKLE_CANDLE_BLOCK_ENTITY, HoneysuckleCandleBlockEntity::tick);
    }
}
