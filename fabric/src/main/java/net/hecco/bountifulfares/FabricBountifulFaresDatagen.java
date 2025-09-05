package net.hecco.bountifulfares;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hecco.bountifulfares.config.FabricBFConfig;
import net.hecco.bountifulfares.datagen.DisableCompatItemsVisibility;
import net.hecco.bountifulfares.datagen.bountifulfares.*;
import net.hecco.heccolib.lib.compat.FabricHLCompatAPI;
import net.minecraft.resources.ResourceLocation;

public class FabricBountifulFaresDatagen implements DataGeneratorEntrypoint {
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

        FabricHLCompatAPI.generateCompatDatapacks(fabricDataGenerator, BountifulFares.COMPAT_MANAGER);
//        FabricDataGenerator.Pack mintDataPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, BountifulFares.ELS_AND_LS_DYES_MOD_ID + "_dat"));
//        mintDataPack.addProvider(MintBlockLootTableProvider::new);
//        mintDataPack.addProvider(MintBlockTagProvider::new);
//        mintDataPack.addProvider(MintRecipeProvider::new); //TODO: MOVE TO COMPATMODULES
//
//        FabricDataGenerator.Pack artsAndCraftsDataPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, BountifulFares.ARTS_AND_CRAFTS_MOD_ID + "_dat"));
//        artsAndCraftsDataPack.addProvider(ArtsAndCraftsBlockLootTableProvider::new);
//        artsAndCraftsDataPack.addProvider(ArtsAndCraftsBlockTagProvider::new);
//        artsAndCraftsDataPack.addProvider(ArtsAndCraftsRecipeProvider::new);
//
//        FabricDataGenerator.Pack dyeDepotDataPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, BountifulFares.DYE_DEPOT_MOD_ID + "_dat"));
//        dyeDepotDataPack.addProvider(DyeDepotBlockLootTableProvider::new);
//        dyeDepotDataPack.addProvider(DyeDepotBlockTagProvider::new);
//        dyeDepotDataPack.addProvider(DyeDepotRecipeProvider::new);
//
//        FabricDataGenerator.Pack excessiveBuildingPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, BountifulFares.EXCESSIVE_BUILDING_MOD_ID + "_dat"));
//        excessiveBuildingPack.addProvider(ExcessiveBuildingBlockLootTableProvider::new);
//        excessiveBuildingPack.addProvider(ExcessiveBuildingBlockTagProvider::new);
//        excessiveBuildingPack.addProvider(ExcessiveBuildingRecipeProvider::new);
//
//        FabricDataGenerator.Pack farmersDelightPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, BountifulFares.FARMERS_DELIGHT_MOD_ID + "_dat"));
//        farmersDelightPack.addProvider(FarmersDelightBlockLootTableProvider::new);
//        farmersDelightPack.addProvider(FarmersDelightBlockTagProvider::new);
//        farmersDelightPack.addProvider(FarmersDelightRecipeProvider::new);
//
//        FabricDataGenerator.Pack naturesSpiritPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, BountifulFares.NATURES_SPIRIT_MOD_ID + "_dat"));
//        naturesSpiritPack.addProvider(NaturesSpiritBlockLootTableProvider::new);
//        naturesSpiritPack.addProvider(NaturesSpiritBlockTagProvider::new);
//        naturesSpiritPack.addProvider(NaturesSpiritItemTagProvider::new);
//        naturesSpiritPack.addProvider(NaturesSpiritRecipeProvider::new);
//
//        FabricDataGenerator.Pack spawnPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, BountifulFares.SPAWN_MOD_ID + "_dat"));
//        spawnPack.addProvider(SpawnBlockLootTableProvider::new);
//        spawnPack.addProvider(SpawnBlockTagProvider::new);
//        spawnPack.addProvider(SpawnRecipeProvider::new);
//
//        FabricDataGenerator.Pack twigsPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, BountifulFares.TWIGS_MOD_ID + "_dat"));
//        twigsPack.addProvider(SpawnBlockLootTableProvider::new);
//        twigsPack.addProvider(SpawnBlockTagProvider::new);
//        twigsPack.addProvider(SpawnRecipeProvider::new);
//
//        FabricDataGenerator.Pack delicateDyesPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, BountifulFares.DELICATE_DYES_MOD_ID + "_dat"));
//        delicateDyesPack.addProvider(DelicateDyesBlockLootTableProvider::new);
//        delicateDyesPack.addProvider(DelicateDyesBlockTagProvider::new);
//        delicateDyesPack.addProvider(DelicateDyesRecipeProvider::new);
//
//        FabricDataGenerator.Pack appledogPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, BountifulFares.APPLEDOG_MOD_ID + "_dat"));
//        appledogPack.addProvider(AppledogBlockLootTableProvider::new);
//        appledogPack.addProvider(AppledogBlockTagProvider::new);
//        appledogPack.addProvider(AppledogRecipeProvider::new);
//
//        FabricDataGenerator.Pack dungeonsDelightPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, BountifulFares.DUNGEONS_DELIGHT_MOD_ID + "_dat"));
//        dungeonsDelightPack.addProvider(DungeonsDelightBlockLootTableProvider::new);
//        dungeonsDelightPack.addProvider(DungeonsDelightBlockTagProvider::new);
//        dungeonsDelightPack.addProvider(DungeonsDelightRecipeProvider::new);
//
        FabricDataGenerator.Pack disableCompatVisibilityPack = fabricDataGenerator.createBuiltinResourcePack(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hide_compat_items"));
        disableCompatVisibilityPack.addProvider(DisableCompatItemsVisibility::new);

    }
}