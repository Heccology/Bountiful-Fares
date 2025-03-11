package net.hecco.bountifulfares.datagen.spawn;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.SPAWN_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;

public class SpawnRecipeProvider extends FabricRecipeProvider {
    public SpawnRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        TrellisUtil.registerCompatTrellisRecipe(exporter, SpawnBlocks.ROTTEN);
        offerPicketsRecipe(exporter, SpawnBlocks.ROTTEN_PICKETS, Identifier.of(SPAWN_MOD_ID, "rotten_planks"));
    }
}
