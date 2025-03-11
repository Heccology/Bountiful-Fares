package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class PalmSaplingBlock extends SaplingBlock {
    public static final BooleanProperty NATURAL = BooleanProperty.of("natural");
    public PalmSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(NATURAL, true));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(4, 0, 4, 12, 4, 12);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(NATURAL);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getPlayer() != null) {
            return BFBlocks.PALM_SAPLING.getDefaultState().with(NATURAL, false);
        }
        return super.getPlacementState(ctx);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (this.canPlantOnTop(world.getBlockState(pos.down()), world, pos)) {
            if (state.get(NATURAL)) {
                BlockPos blockPos = pos.down();
                for (int k = 0; k < 2; k++) {
                    for (int i = 0; i < 11; i++) {
                        for (int j = 0; j < 11; j++) {
                            if (world.getBlockState(blockPos.add(i - 5, -k, j - 5)).getFluidState().isOf(Fluids.WATER)) {
                                return true;
                            }
                        }
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BFBlockTags.PALM_SAPLINGS_PLANTABLE_ON) || super.canPlantOnTop(floor, world, pos);
    }
}
