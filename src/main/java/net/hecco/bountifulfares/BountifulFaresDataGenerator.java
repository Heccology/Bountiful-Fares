package net.hecco.bountifulfares;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hecco.bountifulfares.datagen.*;
import net.hecco.bountifulfares.datagen.BFLangProvider;
import net.hecco.bountifulfares.world.BFConfiguredFeatures;
import net.hecco.bountifulfares.world.BFPlacedFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class BountifulFaresDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(BFRecipeProvider::new);
        pack.addProvider(BFBlockLootTableProvider::new);
        pack.addProvider(BFBlockTagProvider::new);
        pack.addProvider(BFItemTagProvider::new);
        pack.addProvider(BFAdvancementProvider::new);
        pack.addProvider(BFModelProvider::new);
        pack.addProvider(BFLangProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, BFConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, BFPlacedFeatures::bootstrap);
    }
}
