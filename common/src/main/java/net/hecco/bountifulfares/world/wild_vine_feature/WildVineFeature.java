package net.hecco.bountifulfares.world.wild_vine_feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Collection;

public class WildVineFeature extends Feature<WildVineFeatureConfig> {
    public WildVineFeature(Codec<WildVineFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<WildVineFeatureConfig> context) {
        RandomSource random = context.random();
        WorldGenLevel world = context.level();
        BlockPos startPos = context.origin();
        int patchSize = context.config().patchSize;

        for (int i = -patchSize; i <= patchSize; i++) {
            for (int j = -patchSize; j <= patchSize; j++) {
                for (int k = -patchSize; k <= patchSize; k++) {
                    if (random.nextFloat() < 0.25f) {
                        placeVine(random, world, startPos.offset(i, j, k), context);
                    }
                }
            }
        }
        return true;
    }

    private void placeVine(RandomSource random, WorldGenLevel world, BlockPos pos, FeaturePlaceContext<WildVineFeatureConfig> context) {
        Collection<Direction> dirs = Direction.allShuffled(random);
        dirs.remove(Direction.UP);
        dirs.remove(Direction.DOWN);
        if (world.isEmptyBlock(pos) || world.getBlockState(pos).is(Blocks.VINE)) {
            for (Direction direction : dirs) {
                if (world.getBlockState(pos.relative(direction.getOpposite())).is(context.config().canPlaceOn)) {
                    world.setBlock(pos, context.config().block.setValue(BlockStateProperties.HORIZONTAL_FACING, direction), 2);
                }
            }
        }
    }
}
