package net.hecco.bountifulfares.definition.block.interfaces;

import net.hecco.bountifulfares.definition.block.entity.CeramicDishBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static net.hecco.bountifulfares.registry.content.BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY;

public interface CeramicDishBlockInterface extends EntityBlock {
    @Override
    default BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CeramicDishBlockEntity(pos, state);
    }

    default ItemStack pickBlock(BlockGetter world, BlockPos pos, ItemStack stack){
        CeramicDishBlockEntity blockEntity = CERAMIC_DISH_BLOCK_ENTITY.get().getBlockEntity(world,pos);
        int color;
        if(blockEntity != null){
            color = blockEntity.color;
        } else {
            color = CeramicDishBlockEntity.DEFAULT_COLOR;
        }
        stack.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));
        return stack;
    }

}