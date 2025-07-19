package net.hecco.bountifulfares.datagen.appledog;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.appledog.AppledogBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.APPLEDOG_MOD_ID;

public class AppledogRecipeProvider extends FabricRecipeProvider {
    public AppledogRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
//        threeByThreePacker(exporter, RecipeCategory.MISC, AppledogBlocks.APPLEDOG_BLOCK, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(APPLEDOG_MOD_ID, "dogapple")));
    }
}
