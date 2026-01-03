package net.hecco.bountifulfares.registry.tags;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class BFItemTags {
    //Tags in the common 'c' namespace
    public static final TagKey<Item> C_MILKS = createCommonItemTag("foods/milk");
    public static final TagKey<Item> C_WALNUTS = createCommonItemTag("foods/walnuts");
    public static final TagKey<Item> C_ORANGES = createCommonItemTag("foods/oranges");
    public static final TagKey<Item> C_LEMONS = createCommonItemTag("foods/lemons");
    public static final TagKey<Item> C_PLUMS = createCommonItemTag("foods/plums");
    public static final TagKey<Item> C_PASSION_FRUIT = createCommonItemTag("foods/passion_fruit");
    public static final TagKey<Item> C_ELDERBERRIES = createCommonItemTag("foods/elderberries");
    public static final TagKey<Item> C_CORN = createCommonItemTag("foods/corn");
    public static final TagKey<Item> C_FLOUR = createCommonItemTag("flour");
    public static final TagKey<Item> C_COCONUT_HALVES = createCommonItemTag("coconut_halves");
    public static final TagKey<Item> C_DYES = createCommonItemTag( "dyes");

    public static final TagKey<Item> C_HIDDEN_FROM_RECIPE_VIEWERS = createCommonItemTag("hidden_from_recipe_viewers");

    //Log Tags
    public static final TagKey<Item> APPLE_LOGS = createItemTag("apple_logs");
    public static final TagKey<Item> ORANGE_LOGS = createItemTag("orange_logs");
    public static final TagKey<Item> LEMON_LOGS = createItemTag("lemon_logs");
    public static final TagKey<Item> PLUM_LOGS = createItemTag("plum_logs");
    public static final TagKey<Item> HOARY_LOGS = createItemTag("hoary_logs");
    public static final TagKey<Item> WALNUT_LOGS = createItemTag("walnut_logs");
    public static final TagKey<Item> PALM_LOGS = createItemTag("palm_logs");
    public static final TagKey<Item> GOLDEN_APPLE_LOGS = createItemTag("golden_apple_logs");
    public static final TagKey<Item> FRUIT_LOGS = createItemTag("fruit_logs");

    //Leaves Tags
    public static final TagKey<Item> APPLE_LEAVES = createItemTag("apple_leaves");
    public static final TagKey<Item> ORANGE_LEAVES = createItemTag("orange_leaves");
    public static final TagKey<Item> LEMON_LEAVES = createItemTag("lemon_leaves");
    public static final TagKey<Item> PLUM_LEAVES = createItemTag("plum_leaves");
    public static final TagKey<Item> GOLDEN_APPLE_LEAVES = createItemTag("golden_apple_leaves");

    //Item Group Tags
    public static final TagKey<Item> DYEABLE_CERAMIC_BLOCKS = createItemTag("dyeable_ceramic_blocks");
    public static final TagKey<Item> VINE_CROP_SEEDS = createItemTag("vine_crop_seeds");
    public static final TagKey<Item> COOKED_FISHES = createItemTag("cooked_fishes");
    public static final TagKey<Item> MEALS = createItemTag("meals");
    public static final TagKey<Item> PICKETS = createItemTag("pickets");
    public static final TagKey<Item> TIFFINS = createItemTag("tiffins");
    public static final TagKey<Item> MULCH = createItemTag("mulch");

    //Ingredient Tags
    public static final TagKey<Item> SPONGEKIN_INGREDIENTS = createItemTag("spongekin_ingredients");
    public static final TagKey<Item> BEETROOT_INGREDIENTS = createItemTag("beetroot_ingredients");
    public static final TagKey<Item> SUGAR_INGREDIENTS = createItemTag("sugar_ingredients");

    //Technical Tags
    public static final TagKey<Item> JACK_O_STRAW_LIGHTABLE = createItemTag("jack_o_straw_lightable");
    public static final TagKey<Item> PLANTABLE_ON_TRELLIS = createItemTag("plantable_on_trellis");
    public static final TagKey<Item> GRASS_SEEDS_PLANTABLE_ON = createItemTag("grass_seeds_plantable_on");
    public static final TagKey<Item> CERAMIC_DISH_BLACKLIST = createItemTag("ceramic_dish_blacklist");
    public static final TagKey<Item> FELSIC_STONES = createItemTag("felsic_stones");
    public static final TagKey<Item> FOOD_CONTAINERS_TIFFINS_CAN_HOLD = createItemTag("food_containers_tiffins_can_hold");
    public static final TagKey<Item> FERMENTATION_WATER_SOURCES = createItemTag("fermentation_water_sources");
    public static final TagKey<Item> TIFFIN_FOOD_WHITELIST = createItemTag("tiffin_food_whitelist");


    private static TagKey<Item> createItemTag(String name) {
        return TagKey.create(Registries.ITEM,
                             ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name));
    }

    private static TagKey<Item> createCommonItemTag(String name) {
        return TagKey.create(Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath("c", name));
    }
}
