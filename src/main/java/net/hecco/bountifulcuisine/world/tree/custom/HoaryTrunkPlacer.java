package net.hecco.bountifulcuisine.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class HoaryTrunkPlacer extends TrunkPlacer {
    public static final Codec<HoaryTrunkPlacer> CODEC = RecordCodecBuilder.create(hoaryTrunkPlacerInstance ->
            fillTrunkPlacerFields(hoaryTrunkPlacerInstance).apply(hoaryTrunkPlacerInstance, HoaryTrunkPlacer::new));
    public HoaryTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.HOARY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {

        setToDirt(world, replacer, random, startPos.down(), config);
        int firstVerticalLength = random.nextBetween(1, 2);
        int eastHorizontalLength = random.nextBetween(2, 4);
        int westHorizontalLength = random.nextBetween(3, 6);
        int bendVerticalLength = 2;
        for(int i = 0; i < firstVerticalLength; i++) {
            getAndSetState(world, replacer, random, startPos.up(i), config);
        }
        for(int i = 0; i < eastHorizontalLength; i++) {
            BlockPos branchPos = startPos.up(firstVerticalLength).offset(Direction.EAST, i);
            BlockState branchState = ModBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.X);
            replacer.accept(branchPos, branchState);
        }
        for(int i = 0; i < bendVerticalLength; i++) {
            BlockPos branchPos = startPos.up(firstVerticalLength + i).offset(Direction.EAST, eastHorizontalLength);
            BlockState branchState = ModBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y);
            replacer.accept(branchPos, branchState);
        }
        for(int i = 0; i < westHorizontalLength; i++) {
            BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength).offset(Direction.EAST, eastHorizontalLength - i);
            BlockState branchState = ModBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.X);
            replacer.accept(branchPos, branchState);
        }
        for(int i = 0; i < bendVerticalLength; i++) {
            BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength + i).offset(Direction.EAST, eastHorizontalLength - westHorizontalLength);
            BlockState branchState = ModBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y);
            replacer.accept(branchPos, branchState);
        }
        for(int i = 0; i < eastHorizontalLength; i++) {
            BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength * 2).offset(Direction.EAST, eastHorizontalLength - westHorizontalLength + i);
            BlockState branchState = ModBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.X);
            replacer.accept(branchPos, branchState);
        }
        for(int i = 0; i < bendVerticalLength + 1; i++) {
            BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength * 2 + i).offset(Direction.EAST, eastHorizontalLength - westHorizontalLength + eastHorizontalLength);
            BlockState branchState = ModBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y);
            replacer.accept(branchPos, branchState);
        }
        return ImmutableList.of(
                new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength), 0, false),
                new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength + bendVerticalLength).east(eastHorizontalLength), 0, false),
                new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength + bendVerticalLength * 2).east(eastHorizontalLength - westHorizontalLength), 0, false),

                new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength + bendVerticalLength * 3).east(eastHorizontalLength - westHorizontalLength + eastHorizontalLength), 1, false)
        );
    }
}
