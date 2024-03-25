package net.hecco.bountifulfares.world.tree;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.mixin.FoliagePlacerTypeMixin;
import net.hecco.bountifulfares.world.tree.custom.FruitTreeFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> FRUIT_TREE_FOLIAGE_PLACER = FoliagePlacerTypeMixin.callRegister(
            "fruit_tree_foliage_placer", FruitTreeFoliagePlacer.CODEC);

    public static void register() {
        BountifulFares.LOGGER.info("Registering Foliage Placers for bountifulfares");
    }
}
