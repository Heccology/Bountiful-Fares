package net.hecco.bountifulfares.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class NeoForgeBFConfig {

    public static final Map<String, ModConfigSpec.ConfigValue<?>> VALUES = new HashMap<>();

    public static class Common {
        public Common(ModConfigSpec.Builder builder) {
            VALUES.put("millingTime", builder.comment("Gristmill milling time, in seconds").defineInRange("millingTime", 4, 1, 10));
            VALUES.put("fermentationTime", builder.comment("Fermentation time, in seconds").defineInRange("fermentationTime", 300, 1, 600));
            VALUES.put("infusedCandleRadius", builder.comment("Size of area where Infused Candles give effects").defineInRange("infusedCandleRadius", 3, 1, 16));
            VALUES.put("fruitReplaceWhenPicked", builder.comment("Fruits on trees replant when picked").define("infusedCandleRadius", true));
            VALUES.put("enableFlourThrowing", builder.comment("Flour can be thrown").define("enableFlourThrowing", true));
            VALUES.put("flourThrowingCooldown", builder.comment("Flour throwing cooldown, in ticks").defineInRange("flourThrowingCooldown", 0, 0, 20));
            VALUES.put("containerFoodsEatableOnDish", builder.comment("Foods with containers can be eaten on Ceramic Dishes").define("containerFoodsEatableOnDish", false));
            VALUES.put("enablePlaceablePumpkinPie", builder.comment("Pumpkin Pie can be placed as a block").define("enablePlaceablePumpkinPie", true));
            VALUES.put("cakeEatSounds", builder.comment("Cakes make eating sounds").define("cakeEatSounds", true));
            VALUES.put("enableSweetBerryPips", builder.comment("Sweet Berries cannot place Sweet Berry Bushes").define("enableSweetBerryPips", true));
            VALUES.put("enableHoarySeeds", builder.comment("Sniffers can dig up Hoary Seeds").define("enableHoarySeeds", true));
            VALUES.put("enableLapisberrySeeds", builder.comment("Sniffers can dig up Lapisberry Seeds").define("enableLapisberrySeeds", true));
            VALUES.put("grassLootTableOverride", builder.comment("Grass loot tables are overridden").define("grassLootTableOverride", true));
            VALUES.put("enableGuardianSpongekinSeeds", builder.comment("Elder Guardians drop Spongekin Seeds").define("enableGuardianSpongekinSeeds", true));
            VALUES.put("showCompatItemsInRecipeViewers", builder.comment("Show compatibility items in recipe viewers").define("showCompatItemsInRecipeViewers", true));
        }
    }

    public static class Client {
        public Client(ModConfigSpec.Builder builder) {
            VALUES.put("fermentationBubbleParticles", builder.comment("Fermentation Vessels emit bubble particles").define("fermentationBubbleParticles", true));
            VALUES.put("restorationHeartOverlay", builder.comment("Restoration effect changes health icons").define("restorationHeartOverlay", true));
            VALUES.put("acidifiedEffectIconEffects", builder.comment("Status Effects modified by Acidity have visual effects").define("acidifiedEffectIconEffects", true));
            VALUES.put("effectTooltips", builder.comment("Foods have effect tooltips").define("effectTooltips", true));
            VALUES.put("tiffinCornerFoodIcon", builder.comment("Show food inside Shulker Tiffins in the corner of the slot").define("tiffinCornerFoodIcon", false));
            VALUES.put("showTiffinFoodInHand", builder.comment("Show food inside Shulker Tiffins in players' hands").define("showTiffinFoodInHand", false));
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
