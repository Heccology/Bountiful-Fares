package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.BlackTeaCandleBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlackTeaCandleBlock extends InfusedCandleBlock {
    public BlackTeaCandleBlock(Settings settings) {
        super(StatusEffects.RESISTANCE, settings);
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BlackTeaCandleBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, BFBlockEntities.BLACK_TEA_CANDLE_BLOCK_ENTITY, BlackTeaCandleBlockEntity::tick);
    }
}
