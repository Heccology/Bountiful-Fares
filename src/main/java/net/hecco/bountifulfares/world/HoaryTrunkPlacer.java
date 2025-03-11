package net.hecco.bountifulfares.world;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.misc.BFTrunkPlacerTypes;
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
    public static final MapCodec<HoaryTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec((instance) -> fillTrunkPlacerFields(instance).apply(instance, HoaryTrunkPlacer::new));

    public HoaryTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return BFTrunkPlacerTypes.HOARY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {

        setToDirt(world, replacer, random, startPos.down(), config);
        if (random.nextBoolean()) {
            int firstVerticalLength = random.nextBetween(1, 2);
            int eastHorizontalLength = random.nextBetween(2, 4);
            int westHorizontalLength = random.nextBetween(3, 6);
            int bendVerticalLength = 2;
            for (int i = 0; i < firstVerticalLength; i++) {
                getAndSetState(world, replacer, random, startPos.up(i), config);
            }
            for (int i = 0; i < eastHorizontalLength; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength).offset(Direction.EAST, i);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.X);
                replacer.accept(branchPos, branchState);
            }
            for (int i = 0; i < bendVerticalLength; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength + i).offset(Direction.EAST, eastHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            for (int i = 0; i < westHorizontalLength; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength).offset(Direction.EAST, eastHorizontalLength - i);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.X);
                replacer.accept(branchPos, branchState);
            }
            for (int i = 0; i < bendVerticalLength; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength + i).offset(Direction.EAST, eastHorizontalLength - westHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            for (int i = 0; i < eastHorizontalLength; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength * 2).offset(Direction.EAST, eastHorizontalLength - westHorizontalLength + i);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.X);
                replacer.accept(branchPos, branchState);
            }
            for (int i = 0; i < bendVerticalLength + 1; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength * 2 + i).offset(Direction.EAST, eastHorizontalLength - westHorizontalLength + eastHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            return ImmutableList.of(
                    new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength), 0, false),
                    new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength + bendVerticalLength).east(eastHorizontalLength), 0, false),
                    new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength + bendVerticalLength * 2).east(eastHorizontalLength - westHorizontalLength), 0, false),

                    new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength + bendVerticalLength * 3).east(eastHorizontalLength - westHorizontalLength + eastHorizontalLength), 1, false)
            );
        } else {
            int firstVerticalLength = random.nextBetween(1, 2);
            int southHorizontalLength = random.nextBetween(2, 4);
            int northHorizontalLength = random.nextBetween(3, 6);
            int bendVerticalLength = 2;
            for(int i = 0; i < firstVerticalLength; i++) {
                getAndSetState(world, replacer, random, startPos.up(i), config);
            }
            for(int i = 0; i < southHorizontalLength; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength).offset(Direction.SOUTH, i);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Z);
                replacer.accept(branchPos, branchState);
            }
            for(int i = 0; i < bendVerticalLength; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength + i).offset(Direction.SOUTH, southHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            for(int i = 0; i < northHorizontalLength; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength).offset(Direction.SOUTH, southHorizontalLength - i);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Z);
                replacer.accept(branchPos, branchState);
            }
            for(int i = 0; i < bendVerticalLength; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength + i).offset(Direction.SOUTH, southHorizontalLength - northHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            for(int i = 0; i < southHorizontalLength; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength * 2).offset(Direction.SOUTH, southHorizontalLength - northHorizontalLength + i);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Z);
                replacer.accept(branchPos, branchState);
            }
            for(int i = 0; i < bendVerticalLength + 1; i++) {
                BlockPos branchPos = startPos.up(firstVerticalLength + bendVerticalLength * 2 + i).offset(Direction.SOUTH, southHorizontalLength - northHorizontalLength + southHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            return ImmutableList.of(
                    new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength), 0, false),
                    new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength + bendVerticalLength).south(southHorizontalLength), 0, false),
                    new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength + bendVerticalLength * 2).south(southHorizontalLength - northHorizontalLength), 0, false),

                    new FoliagePlacer.TreeNode(startPos.up(firstVerticalLength + bendVerticalLength * 3).south(southHorizontalLength - northHorizontalLength + southHorizontalLength), 1, false)
            );
        }
    }
}
