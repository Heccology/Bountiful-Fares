package net.hecco.bountifulfares.definition.world;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.definition.block.custom.CoconutBlock;
import net.hecco.bountifulfares.definition.block.custom.PalmFrondParentBlock;
import net.hecco.bountifulfares.definition.block.custom.WallPalmFrondBlock;
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

import java.util.List;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec((instance) -> trunkPlacerParts(instance).apply(instance, PalmTrunkPlacer::new));

    public PalmTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return BFTrunkPlacerTypes.PALM_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, int height, BlockPos startPos, TreeConfiguration config) {
        int firstHeight = random.nextIntBetweenInclusive(2, 3);
        int secondHeight = random.nextIntBetweenInclusive(2, 3);
        int thirdHeight = random.nextIntBetweenInclusive(3, 4);
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        BlockPos secondPos = startPos;
        for (int i = 0; i < firstHeight; i++) {
            placeLog(world, replacer, random, startPos.above(i), config);
            secondPos = startPos.above(i).relative(direction);
        }
        BlockPos thridPos = startPos;
        for (int i = 0; i < secondHeight; i++) {
            placeLog(world, replacer, random, secondPos.above(i), config);
            thridPos = secondPos.above(i).relative(direction);
        }
        BlockPos crownPos = startPos;
        for (int i = 0; i < thirdHeight; i++) {
            placeLog(world, replacer, random, thridPos.above(i), config);
            crownPos = thridPos.above(i);
        }
        BlockPos frondPos = crownPos;
        for (int i = 0; i < 2; i++) {
            BlockState crownState = BFBlocks.PALM_CROWN.get().defaultBlockState();
            replacer.accept(crownPos.above(i), crownState);
            frondPos = crownPos.above(i);
        }
        replacer.accept(frondPos.above(), BFBlocks.PALM_FROND.get().defaultBlockState().setValue(PalmFrondParentBlock.SIZE, random.nextIntBetweenInclusive(1, 2)));
        replacer.accept(frondPos.north(), BFBlocks.WALL_PALM_FROND.get().defaultBlockState().setValue(WallPalmFrondBlock.FACING, Direction.NORTH).setValue(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(frondPos.east(), BFBlocks.WALL_PALM_FROND.get().defaultBlockState().setValue(WallPalmFrondBlock.FACING, Direction.EAST).setValue(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(frondPos.south(), BFBlocks.WALL_PALM_FROND.get().defaultBlockState().setValue(WallPalmFrondBlock.FACING, Direction.SOUTH).setValue(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(frondPos.west(), BFBlocks.WALL_PALM_FROND.get().defaultBlockState().setValue(WallPalmFrondBlock.FACING, Direction.WEST).setValue(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(frondPos.north().below(), BFBlocks.COCONUT.get().defaultBlockState().setValue(CoconutBlock.FACING, Direction.NORTH).setValue(CoconutBlock.AGE, random.nextIntBetweenInclusive(1, 5)));
        replacer.accept(frondPos.east().below(), BFBlocks.COCONUT.get().defaultBlockState().setValue(CoconutBlock.FACING, Direction.EAST).setValue(CoconutBlock.AGE, random.nextIntBetweenInclusive(1, 5)));
        replacer.accept(frondPos.south().below(), BFBlocks.COCONUT.get().defaultBlockState().setValue(CoconutBlock.FACING, Direction.SOUTH).setValue(CoconutBlock.AGE, random.nextIntBetweenInclusive(1, 5)));
        replacer.accept(frondPos.west().below(), BFBlocks.COCONUT.get().defaultBlockState().setValue(CoconutBlock.FACING, Direction.WEST).setValue(CoconutBlock.AGE, random.nextIntBetweenInclusive(1, 5)));
        return ImmutableList.of();
    }
}