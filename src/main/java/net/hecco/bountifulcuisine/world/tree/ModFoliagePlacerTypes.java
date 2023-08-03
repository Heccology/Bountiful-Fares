package net.hecco.bountifulcuisine.world.tree;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.mixin.FoliagePlacerTypeInvoker;
import net.hecco.bountifulcuisine.world.tree.custom.FruitTreeFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> FRUIT_TREE_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister(
            "fruit_tree_foliage_placer", FruitTreeFoliagePlacer.CODEC);

    public static void register() {
        BountifulCuisine.LOGGER.info("Registering Foliage Placers for bountifulcuisine");
    }
}
