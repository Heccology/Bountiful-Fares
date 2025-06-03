package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.BellflowerCandleBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BellflowerCandleBlock extends InfusedCandleBlock {
    public BellflowerCandleBlock(Properties settings) {
        super(MobEffects.MOVEMENT_SPEED, settings);
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BellflowerCandleBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, BFBlockEntities.BELLFLOWER_CANDLE_BLOCK_ENTITY, BellflowerCandleBlockEntity::tick);
    }
}
