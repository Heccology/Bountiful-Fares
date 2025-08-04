package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.definition.block.entity.BlackTeaCandleBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BlackTeaCandleBlock extends InfusedCandleBlock{

    public BlackTeaCandleBlock(Properties settings) {
        super(MobEffects.DAMAGE_RESISTANCE, settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BlackTeaCandleBlockEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, BFBlockEntities.BLACK_TEA_CANDLE_BLOCK_ENTITY.get(), BlackTeaCandleBlockEntity::tick);
    }
}
