package net.hecco.bountifulfares.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.block.custom.CoconutBlock;
import net.hecco.bountifulfares.block.custom.PalmFrondBlock;
import net.hecco.bountifulfares.block.custom.PalmFrondParentBlock;
import net.hecco.bountifulfares.block.custom.WallPalmFrondBlock;
import net.hecco.bountifulfares.world.tree.BFTrunkPlacerTypes;
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

public class PalmTrunkPlacer extends TrunkPlacer {
    public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.create(palmTrunkPlacerInstance ->
            fillTrunkPlacerFields(palmTrunkPlacerInstance).apply(palmTrunkPlacerInstance, PalmTrunkPlacer::new));
    public PalmTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return BFTrunkPlacerTypes.PALM_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        int trunkHeight = random.nextBetween(4, 6);
        for (int i = 0; i < trunkHeight; i++) {
            getAndSetState(world, replacer, random, startPos.up(i), config);
        }
        BlockPos topPos = startPos;
        for (int i = 0; i < 2; i++) {
            BlockPos crownPos = startPos.up(trunkHeight).up(i);
            BlockState crownState = BFBlocks.PALM_CROWN.getDefaultState();
            replacer.accept(crownPos, crownState);
            topPos = startPos.up(trunkHeight).up(i);
        }
        replacer.accept(topPos.up(), BFBlocks.PALM_FROND.getDefaultState().with(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(topPos.north(), BFBlocks.WALL_PALM_FROND.getDefaultState().with(WallPalmFrondBlock.FACING, Direction.NORTH).with(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(topPos.east(), BFBlocks.WALL_PALM_FROND.getDefaultState().with(WallPalmFrondBlock.FACING, Direction.EAST).with(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(topPos.south(), BFBlocks.WALL_PALM_FROND.getDefaultState().with(WallPalmFrondBlock.FACING, Direction.SOUTH).with(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(topPos.west(), BFBlocks.WALL_PALM_FROND.getDefaultState().with(WallPalmFrondBlock.FACING, Direction.WEST).with(PalmFrondParentBlock.SIZE, 2));
        replacer.accept(topPos.north().down(), BFBlocks.COCONUT.getDefaultState().with(CoconutBlock.FACING, Direction.NORTH).with(CoconutBlock.AGE, random.nextBetween(1, 5)));
        replacer.accept(topPos.east().down(), BFBlocks.COCONUT.getDefaultState().with(CoconutBlock.FACING, Direction.EAST).with(CoconutBlock.AGE, random.nextBetween(1, 5)));
        replacer.accept(topPos.south().down(), BFBlocks.COCONUT.getDefaultState().with(CoconutBlock.FACING, Direction.SOUTH).with(CoconutBlock.AGE, random.nextBetween(1, 5)));
        replacer.accept(topPos.west().down(), BFBlocks.COCONUT.getDefaultState().with(CoconutBlock.FACING, Direction.WEST).with(CoconutBlock.AGE, random.nextBetween(1, 5)));
        return ImmutableList.of();
    }
}