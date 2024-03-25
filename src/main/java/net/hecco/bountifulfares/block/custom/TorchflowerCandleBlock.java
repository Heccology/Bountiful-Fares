package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.ModBlockEntities;
import net.hecco.bountifulfares.block.entity.TorchflowerCandleBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TorchflowerCandleBlock extends InfusedCandleBlock {
    public TorchflowerCandleBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TorchflowerCandleBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.TORCHFLOWER_CANDLE_BLOCK_ENTITY, TorchflowerCandleBlockEntity::tick);
    }
}
