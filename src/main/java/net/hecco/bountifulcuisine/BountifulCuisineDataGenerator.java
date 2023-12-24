package net.hecco.bountifulcuisine;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hecco.bountifulcuisine.datagen.ModBlockLootTableProvider;
import net.hecco.bountifulcuisine.datagen.ModBlockTagProvider;
import net.hecco.bountifulcuisine.datagen.ModItemTagProvider;
import net.hecco.bountifulcuisine.datagen.ModRecipeProvider;

public class BountifulCuisineDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
    }
}
