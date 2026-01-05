package net.hecco.bountifulfares.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class NeoForgeBFConfig {

    public static final Map<String, ModConfigSpec.ConfigValue<?>> VALUES = new HashMap<>();


    public static class Common {
        public Common(ModConfigSpec.Builder builder) {
            VALUES.put("millingTime", builder.comment("Gristmill milling time, in seconds").defineInRange("milling_time", 4, 1, 10));
            VALUES.put("fermentationTime", builder.comment("Fermentation time, in seconds").defineInRange("fermentation_time", 300, 1, 600));
            VALUES.put("infusedCandleRadius", builder.comment("Size of area where Infused Candles give effects").defineInRange("infused_candle_radius", 3, 1, 16));
            VALUES.put("fruitReplaceWhenPicked", builder.comment("Fruits on trees replant when picked").define("fruit_replace_when_picked", true));
            VALUES.put("enableFlourThrowing", builder.comment("Flour can be thrown").define("flour_throwing", true));
            VALUES.put("flourThrowingCooldown", builder.comment("Flour throwing cooldown, in ticks").defineInRange("flour_throwing_cooldown", 0, 0, 20));
            VALUES.put("containerFoodsEatableOnDish", builder.comment("Foods with containers can be eaten on Ceramic Dishes").define("container_foods_eatable_on_dish", false));
            VALUES.put("enablePlaceablePumpkinPie", builder.comment("Pumpkin Pie can be placed as a block").define("placeable_pumpkin_pie", true));
            VALUES.put("cakeEatSounds", builder.comment("Cakes make eating sounds").define("cake_eating_sounds", true));
            VALUES.put("enableSweetBerryPips", builder.comment("Sweet Berries cannot place Sweet Berry Bushes").define("sweet_berry_pips", true));
            VALUES.put("enableHoarySeeds", builder.comment("Sniffers can dig up Hoary Seeds").define("hoary_seeds", true));
            VALUES.put("enableLapisberrySeeds", builder.comment("Sniffers can dig up Lapisberry Seeds").define("lapisberry_seeds", true));
            VALUES.put("grassLootTableOverride", builder.comment("Grass loot tables are overridden").define("grass_loot_table_override", true));
            VALUES.put("enableGuardianSpongekinSeeds", builder.comment("Guardians drop Spongekin Seeds").define("spongekin_seeds_guardian", true));
            VALUES.put("showCompatItemsInRecipeViewers", builder.comment("Show compatibility items in recipe viewers").define("show_compat_items_in_recipe_viewers", true));
            VALUES.put("addItemsToVanillaTabs", builder.comment("Add items to vanilla creative tabs").define("add_items_to_vanilla_tabs", true));
            VALUES.put("generateAppleTrees", builder.comment("Apple trees generate").define("generate_apple_trees", true));
            VALUES.put("generateOrangeTrees", builder.comment("Orange trees generate").define("generate_orange_trees", true));
            VALUES.put("generateLemonTrees", builder.comment("Lemon trees generate").define("generate_lemon_trees", true));
            VALUES.put("generatePlumTrees", builder.comment("Plum trees generate").define("generate_plum_trees", true));
            VALUES.put("generatePalmTrees", builder.comment("Palm trees generate").define("generate_palm_trees", true));
            VALUES.put("generateWalnutTrees", builder.comment("Walnut trees generate").define("generate_walnut_trees", true));
            VALUES.put("generateWildBeetroot", builder.comment("Wild Beetroot generates").define("generate_wild_beetroot", true));
            VALUES.put("generateWildCarrots", builder.comment("Wild Carrots generate").define("generate_wild_carrots", true));
            VALUES.put("generateWildLeeks", builder.comment("Wild Leeks generate").define("generate_wild_leeks", true));
            VALUES.put("generateWildMaize", builder.comment("Wild Maize generates").define("generate_wild_maize", true));
            VALUES.put("generateWildPotatoes", builder.comment("Wild Potatoes generate").define("generate_wild_potatoes", true));
            VALUES.put("generateWildWheat", builder.comment("Wild Wheat generates").define("generate_wild_wheat", true));
            VALUES.put("generateGrassyDirtPatches", builder.comment("Grassy dirt patches generate").define("generate_grassy_dirt_patches", true));
        }
    }

    public static class Client {
        public Client(ModConfigSpec.Builder builder) {
            VALUES.put("fermentationBubbleParticles", builder.comment("Fermentation Vessels emit bubble particles").define("fermentation_bubble_particles", true));
            VALUES.put("restorationHeartOverlay", builder.comment("Restoration effect changes health icons").define("restoration_overlay", true));
            VALUES.put("acidifiedEffectIconEffects", builder.comment("Status Effects modified by Acidity have visual effects").define("acidified_effect_icon_effects", true));
            VALUES.put("effectTooltips", builder.comment("Foods have effect tooltips").define("effect_tooltips", true));
            VALUES.put("tiffinCornerFoodIcon", builder.comment("Show food inside Shulker Tiffins in the corner of the slot").define("tiffin_corner_food_icon", false));
            VALUES.put("showTiffinFoodInHand", builder.comment("Show food inside Shulker Tiffins in players' hands").define("show_tiffin_food_in_hand", false));
        }
    }
    public static final Common COMMON;
    public static final ModConfigSpec COMMON_SPEC;
    public static final Client CLIENT;
    public static final ModConfigSpec CLIENT_SPEC;

    static {
        Pair<Common, ModConfigSpec> pair =
                new ModConfigSpec.Builder().configure(Common::new);

        COMMON = pair.getLeft();
        COMMON_SPEC = pair.getRight();

        Pair<Client, ModConfigSpec> pair2 =
                new ModConfigSpec.Builder().configure(Client::new);

        CLIENT = pair2.getLeft();
        CLIENT_SPEC = pair2.getRight();
    }

}
