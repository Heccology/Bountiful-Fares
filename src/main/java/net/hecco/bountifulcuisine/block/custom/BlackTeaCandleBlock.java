package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.custom.entity.BlackTeaCandleBlockEntity;
import net.hecco.bountifulcuisine.block.custom.entity.GreenTeaCandleBlockEntity;
import net.hecco.bountifulcuisine.block.custom.entity.ModBlockEntities;
import net.hecco.bountifulcuisine.block.custom.template.InfusedCandleBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlackTeaCandleBlock extends InfusedCandleBlock {
    public BlackTeaCandleBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BlackTeaCandleBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.BLACK_TEA_CANDLE_BLOCK_ENTITY, BlackTeaCandleBlockEntity::tick);
    }
}
