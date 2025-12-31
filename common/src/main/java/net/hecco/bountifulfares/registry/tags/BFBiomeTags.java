package net.hecco.bountifulfares.registry.tags;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class BFBiomeTags {
    public static final TagKey<Biome> HAS_APPLE_TREES = createBiomeTag("has_apple_trees");
    public static final TagKey<Biome> HAS_ORANGE_TREES = createBiomeTag("has_orange_trees");
    public static final TagKey<Biome> HAS_LEMON_TREES = createBiomeTag("has_lemon_trees");
    public static final TagKey<Biome> HAS_PLUM_TREES = createBiomeTag("has_plum_trees");
    public static final TagKey<Biome> HAS_WALNUT_TREES = createBiomeTag("has_walnut_trees");
    public static final TagKey<Biome> HAS_PALM_TREES = createBiomeTag("has_palm_trees");
    public static final TagKey<Biome> HAS_WILD_PASSION_FRUIT = createBiomeTag("has_wild_passion_fruit");
    public static final TagKey<Biome> HAS_WILD_ELDERBERRIES = createBiomeTag("has_wild_elderberries");
    public static final TagKey<Biome> HAS_HONEYSUCKLE = createBiomeTag("has_honeysuckle");
    public static final TagKey<Biome> HAS_VIOLET_BELLFLOWER = createBiomeTag("has_violet_bellflower");
    public static final TagKey<Biome> HAS_CHAMOMILE = createBiomeTag("has_chamomile");
    public static final TagKey<Biome> HAS_WILD_WHEAT = createBiomeTag("has_wild_wheat");
    public static final TagKey<Biome> HAS_LARGE_WILD_WHEAT = createBiomeTag("has_large_wild_wheat");
    public static final TagKey<Biome> HAS_WILD_CARROTS = createBiomeTag("has_wild_carrots");
    public static final TagKey<Biome> HAS_LARGE_WILD_CARROTS = createBiomeTag("has_large_wild_carrots");
    public static final TagKey<Biome> HAS_WILD_POTATOES = createBiomeTag("has_wild_potatoes");
    public static final TagKey<Biome> HAS_LARGE_WILD_POTATOES = createBiomeTag("has_large_wild_potatoes");
    public static final TagKey<Biome> HAS_WILD_BEETROOT = createBiomeTag("has_wild_beetroot");
    public static final TagKey<Biome> HAS_LARGE_WILD_BEETROOT = createBiomeTag("has_large_wild_beetroot");
    public static final TagKey<Biome> HAS_WILD_LEEKS = createBiomeTag("has_wild_leeks");
    public static final TagKey<Biome> HAS_LARGE_WILD_LEEKS = createBiomeTag("has_large_wild_leeks");
    public static final TagKey<Biome> HAS_WILD_MAIZE = createBiomeTag("has_wild_maize");
    public static final TagKey<Biome> HAS_LARGE_WILD_MAIZE = createBiomeTag("has_large_wild_maize");
    public static final TagKey<Biome> HAS_TEA_SHRUB = createBiomeTag("has_tea_shrub");
    public static final TagKey<Biome> HAS_GRASSY_DIRT_PATCHES = createBiomeTag("has_grassy_dirt_patches");

    private static TagKey<Biome> createBiomeTag(String name) {
        return TagKey.create(Registries.BIOME,
                             ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name));
    }
}