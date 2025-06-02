package net.hecco.bountifulfares.block.custom;

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

public class TorchflowerCandleBlock extends InfusedCandleBlock {
    public TorchflowerCandleBlock(Properties settings) {
        super(MobEffects.DAMAGE_BOOST, settings);
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TorchflowerCandleBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, BFBlockEntities.TORCHFLOWER_CANDLE_BLOCK_ENTITY, TorchflowerCandleBlockEntity::tick);
    }
}
