package net.hecco.bountifulfares.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.block.custom.WildVineCropBlock;
import net.hecco.bountifulfares.world.tree.BFTreeDecoratorTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;

public class PassionFruitTreeDecorator extends TreeDecorator {
    public static final MapCodec<PassionFruitTreeDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(PassionFruitTreeDecorator::new, (decorator) -> decorator.probability);

    private final float probability;

    public PassionFruitTreeDecorator(float probability) {
        this.probability = probability;
    }

    protected TreeDecoratorType<?> getType() {
        return BFTreeDecoratorTypes.PASSION_FRUIT;
    }

    public void generate(TreeDecorator.Generator generator) {
        Random random = generator.getRandom();
        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> list = generator.getLogPositions();
            int i = list.get(0).getY();
            list.stream().filter((pos) -> pos.getY() - i <= 2).forEach((pos) -> {
                for (Direction direction : Direction.Type.HORIZONTAL) {
                    if (random.nextFloat() <= 1F) {
                        Direction direction2 = direction.getOpposite();
                        BlockPos blockPos = pos.add(direction2.getOffsetX(), 0, direction2.getOffsetZ());
                        if (generator.isAir(blockPos)) {
                            generator.replace(blockPos, (BFBlocks.WILD_PASSION_FRUIT_VINE.getDefaultState()).with(WildVineCropBlock.FACING, direction2));
                        }
                    }
                }

            });
        }
    }
}
