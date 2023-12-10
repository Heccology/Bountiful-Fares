package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.entity.ModBlockEntities;
import net.hecco.bountifulcuisine.block.entity.GreenTeaCandleBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GreenTeaCandleBlock extends TeaCandleBlock {
    public GreenTeaCandleBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GreenTeaCandleBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.GREEN_TEA_CANDLE_BLOCK_ENTITY, GreenTeaCandleBlockEntity::tick);
    }


}
