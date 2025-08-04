package net.hecco.bountifulfares.datagen.dungeons_delight;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.compat.dungeons_delight.DungeonsDelightBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;

public class DungeonsDelightRecipeProvider extends FabricRecipeProvider {
    public DungeonsDelightRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
//        TrellisUtil.registerCompatTrellisRecipe(exporter, DungeonsDelightBlocks.WORMWOOD);
        offerPicketsRecipe(exporter, DungeonsDelightBlocks.WORMWOOD_PICKETS.get(), ResourceLocation.fromNamespaceAndPath(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, "wormwood_planks"));
    }
}
