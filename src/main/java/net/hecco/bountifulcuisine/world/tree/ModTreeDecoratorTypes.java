package net.hecco.bountifulcuisine.world.tree;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.mixin.TreeDecoratorTypeInvoker;
import net.hecco.bountifulcuisine.world.tree.custom.ElderberryTreeDecorator;
import net.hecco.bountifulcuisine.world.tree.custom.PassionFruitTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecoratorTypes {
    public static final TreeDecoratorType<?> PASSION_FRUIT = TreeDecoratorTypeInvoker.callRegister("passion_fruit", PassionFruitTreeDecorator.CODEC);
    public static final TreeDecoratorType<?> ELDERBERRIES = TreeDecoratorTypeInvoker.callRegister("elderberries", ElderberryTreeDecorator.CODEC);
    public static void register() {
        BountifulCuisine.LOGGER.info("Registering Tree Decorators for " + BountifulCuisine.MOD_ID);
    }
}
