package net.hecco.bountifulfares.definition.block.custom;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class PalmFrondParentBlock extends Block {
    public static final IntegerProperty SIZE = IntegerProperty.create("size", 0, 2);
    public PalmFrondParentBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(SIZE, 0));
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return !context.isSecondaryUseActive() && context.getItemInHand().getItem() == this.asItem() && state.getValue(SIZE) != 2 || super.canBeReplaced(state, context);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState blockState = ctx.getLevel().getBlockState(ctx.getClickedPos());
        if (blockState.getBlock() instanceof PalmFrondBlock) {

            return super.withPropertiesOf(blockState).setValue(SIZE, blockState.getValue(SIZE) + 1);
        }
        if (blockState.getBlock() instanceof WallPalmFrondBlock) {

            return super.withPropertiesOf(blockState).setValue(SIZE, blockState.getValue(SIZE) + 1);
        }
        return super.getStateForPlacement(ctx);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SIZE);
        super.createBlockStateDefinition(builder);
    }
}
