package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.WalnutCandleBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WalnutCandleBlock extends InfusedCandleBlock {
    public WalnutCandleBlock(Settings settings) {
        super(BFEffects.ENRICHMENT, settings);
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WalnutCandleBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, BFBlockEntities.WALNUT_CANDLE_BLOCK_ENTITY, WalnutCandleBlockEntity::tick);
    }
}
