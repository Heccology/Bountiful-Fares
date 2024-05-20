package net.hecco.bountifulfares.world.tree.custom;

import net.hecco.bountifulfares.world.tree.BFFoliagePlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;

public class FruitTreeFoliagePlacer extends LargeOakFoliagePlacer {
    public FruitTreeFoliagePlacer(IntProvider intProvider, IntProvider intProvider2, int i) {
        super(intProvider, intProvider2, i);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return BFFoliagePlacerTypes.FRUIT_TREE_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        for(int i = offset; i >= offset - foliageHeight; --i) {
            int j = radius + (i != offset && i != offset - foliageHeight ? 1 : 0);
            this.generateSquare(world, placer, random, config, treeNode.getCenter(), j, i, treeNode.isGiantTrunk());
        }
        BlockPos blockPos = treeNode.getCenter();
        BlockPos.Mutable mutable = blockPos.mutableCopy();

        for(int i = 0; i < 50; ++i) {
            mutable.set(blockPos, random.nextInt(radius) - random.nextInt(radius), random.nextInt(foliageHeight) - random.nextInt(foliageHeight), random.nextInt(radius) - random.nextInt(radius));
            placeFloweringLeaves(world, placer, random, config, mutable);
        }

    }


    protected static void placeFloweringLeaves(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos pos) {
        if (!canFloweringLeavesReplace(world, pos)) {
        } else {
            BlockState blockState = config.foliageProvider.get(random, pos);
            if (blockState.contains(Properties.WATERLOGGED)) {
                blockState = blockState.with(Properties.WATERLOGGED, world.testFluidState(pos, (fluidState) -> {
                    return fluidState.isEqualAndStill(Fluids.WATER);
                }));
            }

            placer.placeBlock(pos, blockState);
        }
    }


    public static boolean canFloweringLeavesReplace(TestableWorld world, BlockPos pos) {
        return world.testBlockState(pos, (state) -> {
            return state.isIn(BlockTags.LEAVES);
        });
    }
}
