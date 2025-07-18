package net.hecco.bountifulfares.world;

import com.google.common.collect.Lists;
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

public class WalnutTrunkPlacer extends TrunkPlacer {

    public static final MapCodec<WalnutTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec((instance) -> trunkPlacerParts(instance).apply(instance, WalnutTrunkPlacer::new));

    public WalnutTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
//        return BFTrunkPlacerTypes.WALNUT_TRUNK_PLACER; //TODO
        return TrunkPlacerType.FANCY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, int height, BlockPos startPos, TreeConfiguration config) {
        setDirtAt(world, replacer, random, startPos.below(), config);
        int mainHeight = random.nextIntBetweenInclusive(baseHeight, heightRandA);
        int northBranchHeight = random.nextIntBetweenInclusive(heightRandB, mainHeight - 1);
        int eastBranchHeight = random.nextIntBetweenInclusive(heightRandB, mainHeight - 1);
        int southBranchHeight = random.nextIntBetweenInclusive(heightRandB, mainHeight - 1);
        int westBranchHeight = random.nextIntBetweenInclusive(heightRandB, mainHeight - 1);
        List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
        for (int i = 0; i < mainHeight; i++) {
            placeLog(world, replacer, random, startPos.above(i), config);
        }
        for (int x = 1; x < 3; x++) {
            BlockPos branchPos = startPos.above(northBranchHeight).relative(Direction.NORTH, x);
            BlockState branchState = BFBlocks.WALNUT_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Z);
            replacer.accept(branchPos, branchState);
            list.add(new FoliagePlacer.FoliageAttachment(branchPos, 0,true));
        }
        for (int x = 1; x < 3; x++) {
            BlockPos branchPos = startPos.above(eastBranchHeight).relative(Direction.EAST, x);
            BlockState branchState = BFBlocks.WALNUT_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.X);
            replacer.accept(branchPos, branchState);
            list.add(new FoliagePlacer.FoliageAttachment(branchPos, 0,false));
        }
        for (int x = 1; x < 3; x++) {
            BlockPos branchPos = startPos.above(southBranchHeight).relative(Direction.SOUTH, x);
            BlockState branchState = BFBlocks.WALNUT_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Z);
            replacer.accept(branchPos, branchState);
            list.add(new FoliagePlacer.FoliageAttachment(branchPos, 0,false));
        }
        for (int x = 1; x < 3; x++) {
            BlockPos branchPos = startPos.above(westBranchHeight).relative(Direction.WEST, x);
            BlockState branchState = BFBlocks.WALNUT_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.X);
            replacer.accept(branchPos, branchState);
            list.add(new FoliagePlacer.FoliageAttachment(branchPos, 0,false));
        }
        placeLog(world, replacer, random, startPos.above(mainHeight), config);
        int stubDirChance = random.nextIntBetweenInclusive(1, 4);
        if (stubDirChance == 1) {
            BlockPos stubPos = startPos.above(random.nextIntBetweenInclusive(2, 3)).relative(Direction.NORTH, 1);
            BlockState branchState = BFBlocks.WALNUT_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Z);
            replacer.accept(stubPos, branchState);
        }
        if (stubDirChance == 2) {
            BlockPos stubPos = startPos.above(random.nextIntBetweenInclusive(2, 3)).relative(Direction.EAST, 1);
            BlockState stubState = BFBlocks.WALNUT_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.X);
            replacer.accept(stubPos, stubState);
        }
        if (stubDirChance == 3) {
            BlockPos stubPos = startPos.above(random.nextIntBetweenInclusive(2, 3)).relative(Direction.SOUTH, 1);
            BlockState branchState = BFBlocks.WALNUT_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Z);
            replacer.accept(stubPos, branchState);
        }
        if (stubDirChance == 4) {
            BlockPos stubPos = startPos.above(random.nextIntBetweenInclusive(2, 3)).relative(Direction.WEST, 1);
            BlockState stubState = BFBlocks.WALNUT_LOG.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.X);
            replacer.accept(stubPos, stubState);
        }
        list.add(new FoliagePlacer.FoliageAttachment(startPos.above(mainHeight), 0,false));
        return list;
    }
}
