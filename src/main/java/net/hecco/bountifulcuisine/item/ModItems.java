package net.hecco.bountifulcuisine.item;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.effect.ModEffects;
import net.hecco.bountifulcuisine.entity.ModBoats;
import net.hecco.bountifulcuisine.item.custom.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class ModItems {
    public static final Item ORANGE = registerItem("orange", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build())));
    public static final Item LEMON = registerItem("lemon", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build())));
    public static final Item PLUM = registerItem("plum", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build())));
    public static final Item HOARY_APPLE = registerItem("hoary_apple", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6F).build())));
    public static final Item HOARY_SEEDS = registerItem("hoary_seeds", new AliasedPlantItem(ModBlocks.HOARY_APPLE_SAPLING_CROP, new FabricItemSettings()));
    public static final Item HOARY_SIGN = registerItem("hoary_sign", new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.HOARY_SIGN, ModBlocks.HOARY_WALL_SIGN));
    public static final Item HOARY_HANGING_SIGN = registerItem("hoary_hanging_sign", new HangingSignItem(ModBlocks.HOARY_HANGING_SIGN, ModBlocks.HOARY_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item HOARY_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.HOARY_BOAT_ID, ModBoats.HOARY_BOAT_KEY, false);
    public static final Item HOARY_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.HOARY_CHEST_BOAT_ID, ModBoats.HOARY_BOAT_KEY, true);

    public static final Item WALNUT = registerItem("walnut", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0).snack().build())));
    public static final Item WALNUT_SIGN = registerItem("walnut_sign", new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.WALNUT_SIGN, ModBlocks.WALNUT_WALL_SIGN));
    public static final Item WALNUT_HANGING_SIGN = registerItem("walnut_hanging_sign", new HangingSignItem(ModBlocks.WALNUT_HANGING_SIGN, ModBlocks.WALNUT_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item WALNUT_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.WALNUT_BOAT_ID, ModBoats.WALNUT_BOAT_KEY, false);
    public static final Item WALNUT_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.WALNUT_CHEST_BOAT_ID, ModBoats.WALNUT_BOAT_KEY, true);
    public static final Item LAPISBERRY_SEEDS = registerItem("lapisberry_seeds", new Item(new FabricItemSettings()));
    public static final Item CITRIC_ACID = registerItem("citric_acid", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(0).saturationModifier(0).snack().alwaysEdible().statusEffect(new StatusEffectInstance(ModEffects.ACIDIC, 300, 0),1).build())));
    public static final Item CANDIED_ORANGE = registerItem("candied_orange", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).snack().build())));
    public static final Item CANDIED_LEMON = registerItem("candied_lemon", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).snack().build())));
    public static final Item ELDERBERRY_WINE_BOTTLE = registerItem("elderberry_wine_bottle", new LiquidBottleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).alwaysEdible().build()).maxCount(16)));
    public static final Item LAPISBERRY_WINE_BOTTLE = registerItem("lapisberry_wine_bottle", new LiquidBottleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600, 0), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).alwaysEdible().build()).maxCount(16)));
    public static final Item MEAD_BOTTLE = registerItem("mead_bottle", new MeadBottleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).alwaysEdible().build()).maxCount(16)));
    public static final Item FELDSPAR = registerItem("feldspar", new Item(new FabricItemSettings()));
    public static final Item CERAMIC_CLAY = registerItem("ceramic_clay", new Item(new FabricItemSettings()));
    public static final Item CERAMIC_TILE = registerItem("ceramic_tile", new Item(new FabricItemSettings()));
    public static final Item TEA_BERRIES = registerItem("tea_berries", new TeaBerriesItem(ModBlocks.TEA_SHRUB, new FabricItemSettings()));
    public static final Item TEA_LEAVES = registerItem("tea_leaves", new PlantItem(new FabricItemSettings()));
    public static final Item DRIED_TEA_LEAVES = registerItem("dried_tea_leaves", new Item(new FabricItemSettings()));
    public static final Item GREEN_TEA_BLEND = registerItem("green_tea_blend", new Item(new FabricItemSettings()));
    public static final Item BLACK_TEA_BLEND = registerItem("black_tea_blend", new Item(new FabricItemSettings()));
    public static final Item CHAMOMILE_TEA_BLEND = registerItem("chamomile_tea_blend", new Item(new FabricItemSettings()));
    public static final Item HONEYSUCKLE_TEA_BLEND = registerItem("honeysuckle_tea_blend", new Item(new FabricItemSettings()));
    public static final Item BELLFLOWER_TEA_BLEND = registerItem("bellflower_tea_blend", new Item(new FabricItemSettings()));
    public static final Item TORCHFLOWER_TEA_BLEND = registerItem("torchflower_tea_blend", new Item(new FabricItemSettings()));
    public static final Item GREEN_TEA_BOTTLE = registerItem("green_tea_bottle", new GreenTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 600, 0), 1f).alwaysEdible().build())));
    public static final Item BLACK_TEA_BOTTLE = registerItem("black_tea_bottle", new BlackTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 600, 0), 1f).alwaysEdible().build())));
    public static final Item CHAMOMILE_TEA_BOTTLE = registerItem("chamomile_tea_bottle", new ChamomileTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 600, 0), 1f).alwaysEdible().build())));
    public static final Item HONEYSUCKLE_TEA_BOTTLE = registerItem("honeysuckle_tea_bottle", new HoneysuckleTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 600, 0), 1f).alwaysEdible().build())));
    public static final Item BELLFLOWER_TEA_BOTTLE = registerItem("bellflower_tea_bottle", new BellflowerTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 600, 0), 1f).alwaysEdible().build())));
    public static final Item TORCHFLOWER_TEA_BOTTLE = registerItem("torchflower_tea_bottle", new TorchflowerTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 600, 0), 1f).alwaysEdible().build())));
    public static final Item MAIZE = registerItem("maize", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build())));
    public static final Item MAIZE_SEEDS = registerItem("maize_seeds", new AliasedPlantItem(ModBlocks.MAIZE_CROP, new FabricItemSettings()));
    public static final Item LEEK = registerItem("leek", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build())));
    public static final Item LEEK_SEEDS = registerItem("leek_seeds", new AliasedPlantItem(ModBlocks.LEEKS, new FabricItemSettings()));
    public static final Item SPONGEKIN_SEEDS = registerItem("spongekin_seeds", new AliasedPlantItem(ModBlocks.SPONGEKIN_STEM, new FabricItemSettings()));
    public static final Item SPONGEKIN_SLICE = registerItem("spongekin_slice", new SpongekinSliceItem( 100, new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).alwaysEdible().build())));
    public static final Item FLOUR = registerItem("flour", new FlourItem(new FabricItemSettings()));
    public static final Item ARTISAN_COOKIE = registerItem("artisan_cookie", new AliasedBlockItem(ModBlocks.ARTISAN_COOKIES, new FabricItemSettings()));
    public static final Item SUN_HAT = registerItem("sun_hat", new FarmersHatItem(new FabricItemSettings().maxCount(1)));


    public static final Item JAR = registerItem("jar", new Item(new FabricItemSettings().maxCount(16)));
    public static final Item APPLE_COMPOTE_JAR = registerItem("apple_compote_jar", new EdibleJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1f).build())));
    public static final Item ORANGE_COMPOTE_JAR = registerItem("orange_compote_jar", new EdibleJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1f).build())));
    public static final Item LEMON_COMPOTE_JAR = registerItem("lemon_compote_jar", new EdibleJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1f).build())));
    public static final Item PLUM_COMPOTE_JAR = registerItem("plum_compote_jar", new EdibleJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1f).build())));
    public static final Item HOARY_COMPOTE_JAR = registerItem("hoary_compote_jar", new EdibleJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1f).build())));

    public static final Item APPLE_CIDER_JAR = registerItem("apple_cider_jar", new DrinkableJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).build())));
    public static final Item PLUM_CIDER_JAR = registerItem("plum_cider_jar", new DrinkableJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).build())));
    public static final Item HOARY_CIDER_JAR = registerItem("hoary_cider_jar", new DrinkableJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).build())));

    public static final Item CANDY = registerItem("candy", new Item(new FabricItemSettings()));
    public static final Item SOUR_CANDY = registerItem("sour_candy", new Item(new FabricItemSettings()));
    public static final Item PIQUANT_CANDY = registerItem("piquant_candy", new Item(new FabricItemSettings()));
    public static final Item BITTER_CANDY = registerItem("bitter_candy", new Item(new FabricItemSettings()));



    public static final Item PASSION_GLAZED_SALMON = registerItem("passion_glazed_salmon", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.6F).build())));
    public static final Item BOUNTIFUL_STEW = registerItem("bountiful_stew", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(createStew(16))));
    public static final Item CRUSTED_BEEF = registerItem("crusted_beef", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(18).saturationModifier(0.6F).build())));
    public static final Item LEEK_STEW = registerItem("leek_stew", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(createStew(12))));
    public static final Item CRIMSON_CHOW = registerItem("crimson_chow", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(12).saturationModifier(0.8F).build())));
    public static final Item WARPED_CHOW = registerItem("warped_chow", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(10).saturationModifier(0.8F).build())));

    public static final Item DELICACY = registerItem("delicacy", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).build())));
    public static final Item PIQUANT_DELICACY = registerItem("piquant_delicacy", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).build())));
    public static final Item EXOTIC_DELICACY = registerItem("exotic_delicacy", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).build())));
    public static final Item APPLE_DELICACY = registerItem("apple_delicacy", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).build())));
    public static final Item GLOWING_DELICACY = registerItem("glowing_delicacy", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).build())));
    public static final Item ANCIENT_DELICACY = registerItem("ancient_delicacy", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).build())));
    public static final Item MUSHROOM_STUFFED_POTATO = registerItem("mushroom_stuffed_potato", new Item(new FabricItemSettings().maxCount(64).food(new FoodComponent.Builder().hunger(7).saturationModifier(0.8F).build())));


    private static FoodComponent createStew(int hunger) {
        return (new FoodComponent.Builder()).hunger(hunger).saturationModifier(0.6F).build();
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), item);
    }
    public static void registerModItems() {
        BountifulCuisine.LOGGER.info("Registering Mod Items for " + BountifulCuisine.MOD_ID);
    }
}
