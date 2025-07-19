package net.hecco.bountifulfares.datagen.spawn;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.SPAWN_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;

public class SpawnRecipeProvider extends FabricRecipeProvider {
    public SpawnRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
//        TrellisUtil.registerCompatTrellisRecipe(exporter, SpawnBlocks.ROTTEN);
//        offerPicketsRecipe(exporter, SpawnBlocks.ROTTEN_PICKETS, ResourceLocation.fromNamespaceAndPath(SPAWN_MOD_ID, "rotten_planks"));
    }
}
