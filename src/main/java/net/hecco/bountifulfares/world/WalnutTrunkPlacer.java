package net.hecco.bountifulfares.world;

import com.google.common.collect.Lists;
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

public class WalnutTrunkPlacer extends TrunkPlacer {

    public static final MapCodec<WalnutTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec((instance) -> fillTrunkPlacerFields(instance).apply(instance, WalnutTrunkPlacer::new));

    public WalnutTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return BFTrunkPlacerTypes.WALNUT_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);
        int mainHeight = random.nextBetween(baseHeight, firstRandomHeight);
        int northBranchHeight = random.nextBetween(secondRandomHeight, mainHeight - 1);
        int eastBranchHeight = random.nextBetween(secondRandomHeight, mainHeight - 1);
        int southBranchHeight = random.nextBetween(secondRandomHeight, mainHeight - 1);
        int westBranchHeight = random.nextBetween(secondRandomHeight, mainHeight - 1);
        List<FoliagePlacer.TreeNode> list = Lists.newArrayList();
        for (int i = 0; i < mainHeight; i++) {
            getAndSetState(world, replacer, random, startPos.up(i), config);
        }
        for (int x = 1; x < 3; x++) {
            BlockPos branchPos = startPos.up(northBranchHeight).offset(Direction.NORTH, x);
            BlockState branchState = BFBlocks.WALNUT_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Z);
            replacer.accept(branchPos, branchState);
            list.add(new FoliagePlacer.TreeNode(branchPos, 0,true));
        }
        for (int x = 1; x < 3; x++) {
            BlockPos branchPos = startPos.up(eastBranchHeight).offset(Direction.EAST, x);
            BlockState branchState = BFBlocks.WALNUT_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.X);
            replacer.accept(branchPos, branchState);
            list.add(new FoliagePlacer.TreeNode(branchPos, 0,false));
        }
        for (int x = 1; x < 3; x++) {
            BlockPos branchPos = startPos.up(southBranchHeight).offset(Direction.SOUTH, x);
            BlockState branchState = BFBlocks.WALNUT_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Z);
            replacer.accept(branchPos, branchState);
            list.add(new FoliagePlacer.TreeNode(branchPos, 0,false));
        }
        for (int x = 1; x < 3; x++) {
            BlockPos branchPos = startPos.up(westBranchHeight).offset(Direction.WEST, x);
            BlockState branchState = BFBlocks.WALNUT_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.X);
            replacer.accept(branchPos, branchState);
            list.add(new FoliagePlacer.TreeNode(branchPos, 0,false));
        }
        getAndSetState(world, replacer, random, startPos.up(mainHeight), config);
        int stubDirChance = random.nextBetween(1, 4);
        if (stubDirChance == 1) {
            BlockPos stubPos = startPos.up(random.nextBetween(2, 3)).offset(Direction.NORTH, 1);
            BlockState branchState = BFBlocks.WALNUT_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Z);
            replacer.accept(stubPos, branchState);
        }
        if (stubDirChance == 2) {
            BlockPos stubPos = startPos.up(random.nextBetween(2, 3)).offset(Direction.EAST, 1);
            BlockState stubState = BFBlocks.WALNUT_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.X);
            replacer.accept(stubPos, stubState);
        }
        if (stubDirChance == 3) {
            BlockPos stubPos = startPos.up(random.nextBetween(2, 3)).offset(Direction.SOUTH, 1);
            BlockState branchState = BFBlocks.WALNUT_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.Z);
            replacer.accept(stubPos, branchState);
        }
        if (stubDirChance == 4) {
            BlockPos stubPos = startPos.up(random.nextBetween(2, 3)).offset(Direction.WEST, 1);
            BlockState stubState = BFBlocks.WALNUT_LOG.getDefaultState().with(Properties.AXIS, Direction.Axis.X);
            replacer.accept(stubPos, stubState);
        }
        list.add(new FoliagePlacer.TreeNode(startPos.up(mainHeight), 0,false));
        return list;
    }
}
