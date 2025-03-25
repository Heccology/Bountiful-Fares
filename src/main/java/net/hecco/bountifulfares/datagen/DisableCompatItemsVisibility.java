package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DisableCompatItemsVisibility extends FabricTagProvider.ItemTagProvider {
    public DisableCompatItemsVisibility(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        for (Identifier item : BountifulFaresUtil.allCompatItemIds()) {
            getOrCreateTagBuilder(BFItemTags.C_HIDDEN_FROM_RECIPE_VIEWERS).addOptional(item);
        }
    }
}
