package net.hecco.bountifulfares.datagen.dungeons_delight;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.dungeons_delight.DungeonsDelightBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;

public class DungeonsDelightRecipeProvider extends FabricRecipeProvider {
    public DungeonsDelightRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        TrellisUtil.registerCompatTrellisRecipe(exporter, DungeonsDelightBlocks.WORMWOOD);
        offerPicketsRecipe(exporter, DungeonsDelightBlocks.WORMWOOD_PICKETS, Identifier.of(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, "wormwood_planks"));
    }
}
