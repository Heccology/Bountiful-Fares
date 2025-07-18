package net.hecco.bountifulfares.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.block.custom.FruitLogBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.misc.BFTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class GoldenAppleTrunkPlacer extends TrunkPlacer {
    protected final int height;
    public static final MapCodec<GoldenAppleTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            (instance) -> instance.group(
                    Codec.intRange(0, 32)
                            .fieldOf("height")
                            .forGetter((placer) -> placer.height)
            ).apply(instance, GoldenAppleTrunkPlacer::new));

    public GoldenAppleTrunkPlacer(int height) {
        super(0, 0, 0);
        this.height = height;
    }

    @Override
    protected TrunkPlacerType<?> type() {
//        return BFTrunkPlacerTypes.GOLDEN_APPLE_TRUNK_PLACER; //TODO
        return TrunkPlacerType.CHERRY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, int height, BlockPos startPos, TreeConfiguration config) {
        List<FoliagePlacer.FoliageAttachment> nodes = new ArrayList<>();
        int baseHeight = this.height + random.nextIntBetweenInclusive(0, 1);
        Direction firstBranchDir = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        for (int i = 0; i <= baseHeight; i++) {
            replacer.accept(startPos.above(i), BFBlocks.GOLDEN_APPLE_LOG.get().defaultBlockState()
                    .setValue(FruitLogBlock.AXIS, Direction.Axis.Y)
                    .setValue(FruitLogBlock.UP, true)
                    .setValue(FruitLogBlock.DOWN, true)
                    .setValue(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir), true));
        }
        replacer.accept(startPos.above(baseHeight).relative(firstBranchDir), BFBlocks.GOLDEN_APPLE_LOG.get().defaultBlockState()
                .setValue(FruitLogBlock.AXIS, firstBranchDir.getAxis())
                .setValue(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir), true)
                .setValue(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir.getOpposite()), true));
        replacer.accept(startPos.above(baseHeight).relative(firstBranchDir, 2), BFBlocks.GOLDEN_APPLE_LOG.get().defaultBlockState()
                .setValue(FruitLogBlock.AXIS, Direction.Axis.Y)
                .setValue(FruitLogBlock.UP, true)
                .setValue(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir), true));
        replacer.accept(startPos.above(baseHeight + 1).relative(firstBranchDir, 2), BFBlocks.GOLDEN_APPLE_LOG.get().defaultBlockState()
                .setValue(FruitLogBlock.AXIS, Direction.Axis.Y)
                .setValue(FruitLogBlock.UP, true)
                .setValue(FruitLogBlock.DOWN, true));
        nodes.add(new FoliagePlacer.FoliageAttachment(startPos.above(baseHeight + 1).relative(firstBranchDir, 2), 2, false));
        replacer.accept(startPos.above(baseHeight + 1), BFBlocks.GOLDEN_APPLE_LOG.get().defaultBlockState()
                .setValue(FruitLogBlock.AXIS, Direction.Axis.Y)
                .setValue(FruitLogBlock.UP, true)
                .setValue(FruitLogBlock.DOWN, true)
                .setValue(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir.getOpposite()), true));
        replacer.accept(startPos.above(baseHeight + 1).relative(firstBranchDir.getOpposite()), BFBlocks.GOLDEN_APPLE_LOG.get().defaultBlockState()
                .setValue(FruitLogBlock.AXIS, firstBranchDir.getAxis())
                .setValue(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir), true)
                .setValue(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir.getOpposite()), true));
        replacer.accept(startPos.above(baseHeight + 1).relative(firstBranchDir.getOpposite(), 2), BFBlocks.GOLDEN_APPLE_LOG.get().defaultBlockState()
                .setValue(FruitLogBlock.AXIS, Direction.Axis.Y)
                .setValue(FruitLogBlock.UP, true)
                .setValue(FruitLogBlock.DIRECTION_TO_PROPERTY.get(firstBranchDir.getOpposite()), true));
        replacer.accept(startPos.above(baseHeight + 2).relative(firstBranchDir.getOpposite(), 2), BFBlocks.GOLDEN_APPLE_LOG.get().defaultBlockState()
                .setValue(FruitLogBlock.AXIS, Direction.Axis.Y)
                .setValue(FruitLogBlock.UP, true)
                .setValue(FruitLogBlock.DOWN, true));
        nodes.add(new FoliagePlacer.FoliageAttachment(startPos.above(baseHeight + 2).relative(firstBranchDir.getOpposite(), 2), 2, false));
        return nodes;
    }
}