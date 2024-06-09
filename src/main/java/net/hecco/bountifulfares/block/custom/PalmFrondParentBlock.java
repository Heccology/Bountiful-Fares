package net.hecco.bountifulfares.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import org.jetbrains.annotations.Nullable;

public class PalmFrondParentBlock extends Block {
    public static final IntProperty SIZE = IntProperty.of("size", 0, 2);
    public PalmFrondParentBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(SIZE, 0));
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return !context.shouldCancelInteraction() && context.getStack().getItem() == this.asItem() && state.get(SIZE) != 2 || super.canReplace(state, context);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.getBlock() instanceof PalmFrondBlock) {

            return super.getStateWithProperties(blockState).with(SIZE, blockState.get(SIZE) + 1);
        }
        if (blockState.getBlock() instanceof WallPalmFrondBlock) {

            return super.getStateWithProperties(blockState).with(SIZE, blockState.get(SIZE) + 1);
        }
        return super.getPlacementState(ctx);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SIZE);
        super.appendProperties(builder);
    }
}
