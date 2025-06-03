package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;

public class DisableCompatItemsVisibility extends FabricTagProvider.ItemTagProvider {
    public DisableCompatItemsVisibility(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        for (ResourceLocation item : BountifulFaresUtil.allCompatItemIds()) {
            tag(BFItemTags.C_HIDDEN_FROM_RECIPE_VIEWERS).addOptional(item);
        }
    }
}
