package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.BellflowerCandleBlockEntity;
import net.hecco.bountifulfares.block.entity.TorchflowerCandleBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class TorchflowerCandleBlock extends InfusedCandleBlock{

    public TorchflowerCandleBlock(Properties settings) {
        super(MobEffects.DAMAGE_BOOST, settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TorchflowerCandleBlockEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, BFBlockEntities.TORCHFLOWER_CANDLE_BLOCK_ENTITY.get(), TorchflowerCandleBlockEntity::tick);
    }
}
