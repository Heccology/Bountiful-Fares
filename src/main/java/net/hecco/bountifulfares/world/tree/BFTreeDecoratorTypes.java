package net.hecco.bountifulfares.world.tree;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.world.tree.custom.ElderberryTreeDecorator;
import net.hecco.bountifulfares.world.tree.custom.PassionFruitTreeDecorator;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class BFTreeDecoratorTypes {
    public static final TreeDecoratorType<?> PASSION_FRUIT = registerTrunkPlacer("passion_fruit", PassionFruitTreeDecorator.CODEC);
    public static final TreeDecoratorType<?> ELDERBERRIES = registerTrunkPlacer("elderberries", ElderberryTreeDecorator.CODEC);

    private static <P extends TreeDecorator> TreeDecoratorType registerTrunkPlacer(String id, MapCodec<P> codec) {
        return Registry.register(Registries.TREE_DECORATOR_TYPE,  Identifier.of (BountifulFares.MOD_ID, id), new TreeDecoratorType(codec));
    }
    public static void register() {
//        BountifulFares.LOGGER.info("Registering Tree Decorators for " + BountifulFares.MOD_ID);
    }
}
