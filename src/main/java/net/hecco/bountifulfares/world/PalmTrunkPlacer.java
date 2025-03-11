package net.hecco.bountifulfares.world;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.block.custom.CoconutBlock;
import net.hecco.bountifulfares.block.custom.PalmFrondParentBlock;
import net.hecco.bountifulfares.block.custom.WallPalmFrondBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.misc.BFTrunkPlacerTypes;
import net.minecraft.block.BlockState;
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

public class PalmTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec((instance) -> fillTrunkPlacerFields(instance).apply(instance, PalmTrunkPlacer::new));

    public PalmTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return BFTrunkPlacerTypes.PALM_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        int firstHeight = random.nextBetween(2, 3);
        int secondHeight = random.nextBetween(2, 3);
        int thirdHeight = random.nextBetween(3, 4);
        Direction direction = Direction.Type.HORIZONTAL.random(random);
        BlockPos secondPos = startPos;
        for (int i = 0; i < firstHeight; i++) {
            getAndSetState(world, replacer, random, startPos.up(i), config);
            secondPos = startPos.up(i).offset(direction);
        }
        BlockPos thridPos = startPos;
        for (int i = 0; i < secondHeight; i++) {
            getAndSetState(world, replacer, random, secondPos.up(i), config);
            thridPos = secondPos.up(i).offset(direction);
        }
        BlockPos crownPos = startPos;
        for (int i = 0; i < thirdHeight; i++) {
            getAndSetState(world, replacer, random, thridPos.up(i), config);
            crownPos = thridPos.up(i);
        }
        BlockPos frondPos = crownPos;
        for (int i = 0; i < 2; i++) {
            BlockState crownState = BFBlocks.PALM_CROWN.getDefaultState();
            replacer.accept(crownPos.up(i), crownState);
            frondPos = crownPos.up(i);
        }
        replacer.accept(frondPos.up(), BFBlocks.PALM_FROND.getDefaultState().with(PalmFrondParentBlock.SIZE, random.nextBetween(1, 2)));
        replacer.accept(frondPos.north(), BFBlocks.WALL_PALM_FROND.getDefaultState().with(WallPalmFrondBlock.FACING, Direction.NORTH).with(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(frondPos.east(), BFBlocks.WALL_PALM_FROND.getDefaultState().with(WallPalmFrondBlock.FACING, Direction.EAST).with(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(frondPos.south(), BFBlocks.WALL_PALM_FROND.getDefaultState().with(WallPalmFrondBlock.FACING, Direction.SOUTH).with(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(frondPos.west(), BFBlocks.WALL_PALM_FROND.getDefaultState().with(WallPalmFrondBlock.FACING, Direction.WEST).with(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(frondPos.north().down(), BFBlocks.COCONUT.getDefaultState().with(CoconutBlock.FACING, Direction.NORTH).with(CoconutBlock.AGE, random.nextBetween(1, 5)));
        replacer.accept(frondPos.east().down(), BFBlocks.COCONUT.getDefaultState().with(CoconutBlock.FACING, Direction.EAST).with(CoconutBlock.AGE, random.nextBetween(1, 5)));
        replacer.accept(frondPos.south().down(), BFBlocks.COCONUT.getDefaultState().with(CoconutBlock.FACING, Direction.SOUTH).with(CoconutBlock.AGE, random.nextBetween(1, 5)));
        replacer.accept(frondPos.west().down(), BFBlocks.COCONUT.getDefaultState().with(CoconutBlock.FACING, Direction.WEST).with(CoconutBlock.AGE, random.nextBetween(1, 5)));
        return ImmutableList.of();
    }
}