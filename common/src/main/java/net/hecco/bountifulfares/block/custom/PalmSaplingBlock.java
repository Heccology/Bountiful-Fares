package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PalmSaplingBlock extends SaplingBlock {
    public static final BooleanProperty NATURAL = BooleanProperty.create("natural");
    public PalmSaplingBlock(TreeGrower generator, Properties settings) {
        super(generator, settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(NATURAL, true));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Block.box(4, 0, 4, 12, 4, 12);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(NATURAL);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        if (ctx.getPlayer() != null) {
            return BFBlocks.PALM_SAPLING.get().defaultBlockState().setValue(NATURAL, false);
        }
        return super.getStateForPlacement(ctx);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        if (this.mayPlaceOn(world.getBlockState(pos.below()), world, pos)) {
            if (state.getValue(NATURAL)) {
                BlockPos blockPos = pos.below();
                for (int k = 0; k < 2; k++) {
                    for (int i = 0; i < 11; i++) {
                        for (int j = 0; j < 11; j++) {
                            if (world.getBlockState(blockPos.offset(i - 5, -k, j - 5)).getFluidState().is(Fluids.WATER)) {
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
    protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
        return floor.is(BFBlockTags.PALM_SAPLINGS_PLANTABLE_ON) || super.mayPlaceOn(floor, world, pos);
    }
}
