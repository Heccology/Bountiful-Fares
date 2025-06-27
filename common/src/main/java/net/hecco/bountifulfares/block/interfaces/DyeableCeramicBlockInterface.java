package net.hecco.bountifulfares.block.interfaces;

import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static net.hecco.bountifulfares.registry.content.BFBlockEntities.CERAMIC_TILES_BLOCK_ENTITY;

public interface DyeableCeramicBlockInterface extends EntityBlock {
    @Override
    default BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DyeableCeramicBlockEntity(pos, state);
    }

    default ItemStack pickBlock(BlockGetter world, BlockPos pos, ItemStack stack){
        DyeableCeramicBlockEntity blockEntity = CERAMIC_TILES_BLOCK_ENTITY.get().getBlockEntity(world,pos);
        int color;
        if(blockEntity != null){
            color = blockEntity.color;
        } else {
            color = DyeableCeramicBlockEntity.DEFAULT_COLOR;
        }
        stack.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));
        return stack;
    }

}