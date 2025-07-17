package net.hecco.bountifulfares.datagen.arts_and_crafts;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.ARTS_AND_CRAFTS_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;

public class ArtsAndCraftsRecipeProvider extends FabricRecipeProvider {
    public ArtsAndCraftsRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        TrellisUtil.registerCompatTrellisRecipe(exporter, ArtsAndCraftsBlocks.CORK);
        offerPicketsRecipe(exporter, ArtsAndCraftsBlocks.CORK_PICKETS, ResourceLocation.fromNamespaceAndPath(ARTS_AND_CRAFTS_MOD_ID, "cork_planks"));
    }
}
