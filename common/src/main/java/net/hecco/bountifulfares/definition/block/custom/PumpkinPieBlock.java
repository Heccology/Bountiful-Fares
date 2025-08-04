package net.hecco.bountifulfares.definition.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

public class PumpkinPieBlock extends PieBlock {
    public PumpkinPieBlock(Properties settings) {
        super(settings);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return new ItemStack(Items.PUMPKIN_PIE);
    }
}
