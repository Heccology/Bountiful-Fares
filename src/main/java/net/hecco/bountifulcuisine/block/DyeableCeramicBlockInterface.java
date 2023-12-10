package net.hecco.bountifulcuisine.block;

import net.hecco.bountifulcuisine.block.entity.CeramicTilesBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import static net.hecco.bountifulcuisine.block.entity.ModBlockEntities.CERAMIC_TILES_BLOCK_ENTITY;

public interface DyeableCeramicBlockInterface extends BlockEntityProvider {
    @Override
    default BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CeramicTilesBlockEntity(pos, state);
    }

    default ItemStack pickBlock(BlockView world, BlockPos pos, ItemStack stack){
        CeramicTilesBlockEntity blockEntity = CERAMIC_TILES_BLOCK_ENTITY.get(world,pos);
        int color = CeramicTilesBlockEntity.DEFAULT_COLOR;
        if(blockEntity != null){
            color = blockEntity.color;
        }
        NbtCompound subNbt = stack.getOrCreateSubNbt("display");
        subNbt.putInt("color", color);
        return stack;
    }

}