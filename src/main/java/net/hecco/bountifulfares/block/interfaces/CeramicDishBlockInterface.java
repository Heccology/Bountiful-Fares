package net.hecco.bountifulfares.block.interfaces;

import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import static net.hecco.bountifulfares.registry.content.BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY;

public interface CeramicDishBlockInterface extends BlockEntityProvider {
    @Override
    default BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CeramicDishBlockEntity(pos, state);
    }

    default ItemStack pickBlock(BlockView world, BlockPos pos, ItemStack stack){
        CeramicDishBlockEntity blockEntity = CERAMIC_DISH_BLOCK_ENTITY.get(world,pos);
        int color;
        if(blockEntity != null){
            color = blockEntity.color;
        } else {
            color = CeramicDishBlockEntity.DEFAULT_COLOR;
        }
        stack.set(DataComponentTypes.DYED_COLOR, new DyedColorComponent(color, true));
        return stack;
    }

}