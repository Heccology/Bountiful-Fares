package net.hecco.bountifulfares.datagen.natures_spirit;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.NATURES_SPIRIT_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;

public class NaturesSpiritRecipeProvider extends FabricRecipeProvider {
    public NaturesSpiritRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.REDWOOD);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.SUGI);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.WISTERIA);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.FIR);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.WILLOW);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.ASPEN);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.MAPLE);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.CYPRESS);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.OLIVE);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.JOSHUA);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.GHAF);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.PALO_VERDE);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.COCONUT);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.CEDAR);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.LARCH);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.MAHOGANY);
        TrellisUtil.registerCompatTrellisRecipe(exporter, NaturesSpiritBlocks.SAXAUL);

        offerPicketsRecipe(exporter, NaturesSpiritBlocks.REDWOOD_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "redwood_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.SUGI_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "sugi_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.WISTERIA_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "wisteria_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.FIR_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "fir_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.WILLOW_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "willow_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.ASPEN_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "aspen_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.MAPLE_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "maple_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.CYPRESS_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "cypress_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.OLIVE_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "olive_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.JOSHUA_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "joshua_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.GHAF_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "ghaf_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.PALO_VERDE_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "palo_verde_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.COCONUT_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "coconut_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.CEDAR_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "cedar_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.LARCH_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "larch_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.MAHOGANY_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "mahogany_planks"));
        offerPicketsRecipe(exporter, NaturesSpiritBlocks.SAXAUL_PICKETS, Identifier.of(NATURES_SPIRIT_MOD_ID, "saxaul_planks"));
    }
}
