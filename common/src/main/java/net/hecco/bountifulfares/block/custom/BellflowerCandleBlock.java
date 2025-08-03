package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.BellflowerCandleBlockEntity;
import net.hecco.bountifulfares.block.entity.ChamomileCandleBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BellflowerCandleBlock extends InfusedCandleBlock{

    public BellflowerCandleBlock(Properties settings) {
        super(MobEffects.MOVEMENT_SPEED, settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BellflowerCandleBlockEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, BFBlockEntities.BELLFLOWER_CANDLE_BLOCK_ENTITY.get(), BellflowerCandleBlockEntity::tick);
    }
}
