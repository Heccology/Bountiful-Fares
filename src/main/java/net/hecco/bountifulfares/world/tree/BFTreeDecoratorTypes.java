package net.hecco.bountifulfares.world.tree;

import net.hecco.bountifulfares.mixin.TreeDecoratorTypeMixin;
import net.hecco.bountifulfares.world.tree.custom.ElderberryTreeDecorator;
import net.hecco.bountifulfares.world.tree.custom.PassionFruitTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class BFTreeDecoratorTypes {
    public static final TreeDecoratorType<?> PASSION_FRUIT = TreeDecoratorTypeMixin.callRegister("passion_fruit", PassionFruitTreeDecorator.CODEC);
    public static final TreeDecoratorType<?> ELDERBERRIES = TreeDecoratorTypeMixin.callRegister("elderberries", ElderberryTreeDecorator.CODEC);
    public static void register() {
//        BountifulFares.LOGGER.info("Registering Tree Decorators for " + BountifulFares.MOD_ID);
    }
}
