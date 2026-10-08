package net.hecco.bountifulfares.mixin.recipebook;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.hecco.bountifulfares.registry.misc.BFRecipeBookTypes;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.inventory.RecipeBookType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.Map;

@Mixin(RecipeBookSettings.class)
public class RecipeBookSetMixin {
    @Shadow @Final @Mutable private static Map<RecipeBookType, Pair<String, String>> TAG_FIELDS;

    // This will put the necessary recipe type metadata into the tag fields on fabric
    static {
        Map<RecipeBookType, Pair<String, String>> preGo = new HashMap<>(Map.copyOf(TAG_FIELDS));
        preGo.put(BFRecipeBookTypes.BF_GRISTMILL, Pair.of(BFRecipeBookTypes.BF_GRIST_OPEN, BFRecipeBookTypes.BF_GRIST_FILTERING));
        TAG_FIELDS = ImmutableMap.copyOf(preGo);
    }
}
