package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.HoneysuckleCandleBlockEntity;
import net.hecco.bountifulfares.block.entity.BFBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class HoneysuckleCandleBlock extends InfusedCandleBlock {
    public HoneysuckleCandleBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HoneysuckleCandleBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, BFBlockEntities.HONEYSUCKLE_CANDLE_BLOCK_ENTITY, HoneysuckleCandleBlockEntity::tick);
    }
}
