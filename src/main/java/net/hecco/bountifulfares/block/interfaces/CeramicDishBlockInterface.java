package net.hecco.bountifulfares.block.interfaces;

import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import static net.hecco.bountifulfares.block.entity.ModBlockEntities.CERAMIC_DISH_BLOCK_ENTITY;

public interface CeramicDishBlockInterface extends BlockEntityProvider {
    @Override
    default BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CeramicDishBlockEntity(pos, state);
    }

    default ItemStack pickBlock(BlockView world, BlockPos pos, ItemStack stack){
        CeramicDishBlockEntity blockEntity = CERAMIC_DISH_BLOCK_ENTITY.get(world,pos);
        int color = CeramicDishBlockEntity.DEFAULT_COLOR;
        if(blockEntity != null){
            color = blockEntity.color;
        }
        NbtCompound subNbt = stack.getOrCreateSubNbt("display");
        subNbt.putInt("color", color);
        return stack;
    }

}