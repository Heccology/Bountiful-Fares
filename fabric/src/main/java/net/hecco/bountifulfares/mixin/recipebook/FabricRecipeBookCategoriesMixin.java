package net.hecco.bountifulfares.mixin.recipebook;

import com.google.common.collect.ImmutableMap;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.misc.BFRecipeBookCategories;
import net.minecraft.client.RecipeBookCategories;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(RecipeBookCategories.class)
public class FabricRecipeBookCategoriesMixin {
    ///////// STATIC LIST
    //////// NF Side: net.hecco.bountifulfares.NeoForgeClientEvents
    @Shadow @Final @Mutable public static Map<RecipeBookCategories, List<RecipeBookCategories>> AGGREGATE_CATEGORIES;

    // Needed to make recipes register in the book properly
    static {
        Map<RecipeBookCategories, List<RecipeBookCategories>> preGo = new HashMap<>(Map.copyOf(AGGREGATE_CATEGORIES));
        preGo.put(
                BFRecipeBookCategories.BF_GRISTMILL_SEARCH,
                List.of(
                        BFRecipeBookCategories.BF_GRISTMILL_MATERIALS,
                        BFRecipeBookCategories.BF_GRISTMILL_MINERALS
                )
        );
        AGGREGATE_CATEGORIES = ImmutableMap.copyOf(preGo);
    }
}
