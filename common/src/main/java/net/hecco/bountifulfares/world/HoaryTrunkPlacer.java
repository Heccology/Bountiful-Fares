package net.hecco.bountifulfares.world;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.misc.BFTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class HoaryTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<HoaryTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec((instance) -> trunkPlacerParts(instance).apply(instance, HoaryTrunkPlacer::new));

    public HoaryTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
//        return BFTrunkPlacerTypes.HOARY_TRUNK_PLACER; //TODO
        return TrunkPlacerType.BENDING_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, int height, BlockPos startPos, TreeConfiguration config) {

        setDirtAt(world, replacer, random, startPos.below(), config);
        if (random.nextBoolean()) {
            int firstVerticalLength = random.nextIntBetweenInclusive(1, 2);
            int eastHorizontalLength = random.nextIntBetweenInclusive(2, 4);
            int westHorizontalLength = random.nextIntBetweenInclusive(3, 6);
            int bendVerticalLength = 2;
            for (int i = 0; i < firstVerticalLength; i++) {
                placeLog(world, replacer, random, startPos.above(i), config);
            }
            for (int i = 0; i < eastHorizontalLength; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength).relative(Direction.EAST, i);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.X);
                replacer.accept(branchPos, branchState);
            }
            for (int i = 0; i < bendVerticalLength; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength + i).relative(Direction.EAST, eastHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            for (int i = 0; i < westHorizontalLength; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength + bendVerticalLength).relative(Direction.EAST, eastHorizontalLength - i);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.X);
                replacer.accept(branchPos, branchState);
            }
            for (int i = 0; i < bendVerticalLength; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength + bendVerticalLength + i).relative(Direction.EAST, eastHorizontalLength - westHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            for (int i = 0; i < eastHorizontalLength; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength + bendVerticalLength * 2).relative(Direction.EAST, eastHorizontalLength - westHorizontalLength + i);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.X);
                replacer.accept(branchPos, branchState);
            }
            for (int i = 0; i < bendVerticalLength + 1; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength + bendVerticalLength * 2 + i).relative(Direction.EAST, eastHorizontalLength - westHorizontalLength + eastHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            return ImmutableList.of(
                    new FoliagePlacer.FoliageAttachment(startPos.above(firstVerticalLength), 0, false),
                    new FoliagePlacer.FoliageAttachment(startPos.above(firstVerticalLength + bendVerticalLength).east(eastHorizontalLength), 0, false),
                    new FoliagePlacer.FoliageAttachment(startPos.above(firstVerticalLength + bendVerticalLength * 2).east(eastHorizontalLength - westHorizontalLength), 0, false),

                    new FoliagePlacer.FoliageAttachment(startPos.above(firstVerticalLength + bendVerticalLength * 3).east(eastHorizontalLength - westHorizontalLength + eastHorizontalLength), 1, false)
            );
        } else {
            int firstVerticalLength = random.nextIntBetweenInclusive(1, 2);
            int southHorizontalLength = random.nextIntBetweenInclusive(2, 4);
            int northHorizontalLength = random.nextIntBetweenInclusive(3, 6);
            int bendVerticalLength = 2;
            for(int i = 0; i < firstVerticalLength; i++) {
                placeLog(world, replacer, random, startPos.above(i), config);
            }
            for(int i = 0; i < southHorizontalLength; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength).relative(Direction.SOUTH, i);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Z);
                replacer.accept(branchPos, branchState);
            }
            for(int i = 0; i < bendVerticalLength; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength + i).relative(Direction.SOUTH, southHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            for(int i = 0; i < northHorizontalLength; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength + bendVerticalLength).relative(Direction.SOUTH, southHorizontalLength - i);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Z);
                replacer.accept(branchPos, branchState);
            }
            for(int i = 0; i < bendVerticalLength; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength + bendVerticalLength + i).relative(Direction.SOUTH, southHorizontalLength - northHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            for(int i = 0; i < southHorizontalLength; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength + bendVerticalLength * 2).relative(Direction.SOUTH, southHorizontalLength - northHorizontalLength + i);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Z);
                replacer.accept(branchPos, branchState);
            }
            for(int i = 0; i < bendVerticalLength + 1; i++) {
                BlockPos branchPos = startPos.above(firstVerticalLength + bendVerticalLength * 2 + i).relative(Direction.SOUTH, southHorizontalLength - northHorizontalLength + southHorizontalLength);
                BlockState branchState = BFBlocks.HOARY_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y);
                replacer.accept(branchPos, branchState);
            }
            return ImmutableList.of(
                    new FoliagePlacer.FoliageAttachment(startPos.above(firstVerticalLength), 0, false),
                    new FoliagePlacer.FoliageAttachment(startPos.above(firstVerticalLength + bendVerticalLength).south(southHorizontalLength), 0, false),
                    new FoliagePlacer.FoliageAttachment(startPos.above(firstVerticalLength + bendVerticalLength * 2).south(southHorizontalLength - northHorizontalLength), 0, false),

                    new FoliagePlacer.FoliageAttachment(startPos.above(firstVerticalLength + bendVerticalLength * 3).south(southHorizontalLength - northHorizontalLength + southHorizontalLength), 1, false)
            );
        }
    }
}
