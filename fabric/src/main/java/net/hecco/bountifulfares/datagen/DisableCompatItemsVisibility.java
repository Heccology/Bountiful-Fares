package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class DisableCompatItemsVisibility extends FabricTagProvider.ItemTagProvider {
    public DisableCompatItemsVisibility(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        for (Object i : BountifulFares.COMPAT_MANAGER.CONTENT_TO_INTEGRATION.keySet().stream().map(Supplier::get).toList()) {
            if (i instanceof Item item) {
                tag(BFItemTags.C_HIDDEN_FROM_RECIPE_VIEWERS).addOptional(BuiltInRegistries.ITEM.getKey(item));
            }
        }
    }
}
