package net.hecco.bountifulcuisine;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hecco.bountifulcuisine.datagen.*;
import net.hecco.bountifulcuisine.datagen.lang.ModEnUsProvider;
import net.hecco.bountifulcuisine.datagen.lang.ModEsEsProvider;
import net.hecco.bountifulcuisine.world.ModConfiguredFeatures;
import net.hecco.bountifulcuisine.world.ModPlacedFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class BountifulCuisineDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModAdvancementProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModEnUsProvider::new);
        pack.addProvider(ModEsEsProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
