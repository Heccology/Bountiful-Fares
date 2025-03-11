package net.hecco.bountifulfares.registry.content;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.item.custom.*;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.List;

public class BFItems {
    public static final Item PASSION_FRUIT = registerItem("passion_fruit", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.1f).snack().build())));
    public static final Item ELDERBERRIES = registerItem("elderberries", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.1f).snack().statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0, true, false), 0.3f).build())));
    public static final Item LAPISBERRY_SEEDS = registerItem("lapisberry_seeds", new Item(new Item.Settings()));
    public static final Item LAPISBERRIES = registerItem("lapisberries", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.1f).snack().build())));

    public static final Item ORANGE = registerItem("orange", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final Item LEMON = registerItem("lemon", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final Item PLUM = registerItem("plum", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final Item HOARY_APPLE = registerItem("hoary_apple", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.6F).build())));
    public static final Item HOARY_SEEDS = registerItem("hoary_seeds", new AliasedBlockItem(BFBlocks.HOARY_APPLE_SAPLING_CROP, new Item.Settings()));
    public static final Item HOARY_SIGN = registerItem("hoary_sign", new SignItem(new Item.Settings().maxCount(16), BFBlocks.HOARY_SIGN, BFBlocks.HOARY_WALL_SIGN));
    public static final Item HOARY_HANGING_SIGN = registerItem("hoary_hanging_sign", new HangingSignItem(BFBlocks.HOARY_HANGING_SIGN, BFBlocks.HOARY_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));
    public static final Item HOARY_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.HOARY_BOAT_ID, BFBoats.HOARY_BOAT_KEY, false);
    public static final Item HOARY_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.HOARY_CHEST_BOAT_ID, BFBoats.HOARY_BOAT_KEY, true);

    public static final Item SWEET_BERRY_PIPS = registerItem("sweet_berry_pips", new SweetBerryPipsItem(Blocks.SWEET_BERRY_BUSH, new Item.Settings()));

    public static final Item WALNUT = registerItem("walnut", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(1).saturationModifier(0).snack().build())));
    public static final Item WALNUT_SIGN = registerItem("walnut_sign", new SignItem(new Item.Settings().maxCount(16), BFBlocks.WALNUT_SIGN, BFBlocks.WALNUT_WALL_SIGN));
    public static final Item WALNUT_HANGING_SIGN = registerItem("walnut_hanging_sign", new HangingSignItem(BFBlocks.WALNUT_HANGING_SIGN, BFBlocks.WALNUT_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));
    public static final Item WALNUT_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.WALNUT_BOAT_ID, BFBoats.WALNUT_BOAT_KEY, false);
    public static final Item WALNUT_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.WALNUT_CHEST_BOAT_ID, BFBoats.WALNUT_BOAT_KEY, true);
    public static final Item PALM_FROND = registerItem("palm_frond", new VerticallyAttachableBlockItem(BFBlocks.PALM_FROND, BFBlocks.WALL_PALM_FROND, new Item.Settings(), Direction.DOWN));
    public static final Item COCONUT = registerItem("coconut", new AliasedBlockItem(BFBlocks.PALM_SAPLING, new Item.Settings()));
    public static final Item COCONUT_COIR = registerItem("coconut_coir", new Item(new Item.Settings()));
    public static final Item COCONUT_HALF = registerItem("coconut_half", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.1f).build())));
    public static final Item COCONUT_MILK_BOTTLE = registerItem("coconut_milk_bottle", new CoconutMilkBottleItem(new Item.Settings().food(new FoodComponent.Builder().nutrition(3).saturationModifier(1f).build()).recipeRemainder(Items.GLASS_BOTTLE)));
    public static final Item CITRUS_ESSENCE = registerItem("citrus_essence", new EffectFoodItem(List.of(new StatusEffectInstance(BFEffects.ACIDIC, 300, 0)), new Item.Settings().food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f).snack().alwaysEdible().statusEffect(new StatusEffectInstance(BFEffects.ACIDIC, 300, 0),1).build())));
    public static final Item CANDIED_ORANGE = registerItem("candied_orange", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).snack().build())));
    public static final Item CANDIED_LEMON = registerItem("candied_lemon", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).snack().build())));
    public static final Item ELDERBERRY_WINE_BOTTLE = registerItem("elderberry_wine_bottle", new LiquidBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1, true, false), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).alwaysEdible().build()).maxCount(16)));
    public static final Item LAPISBERRY_WINE_BOTTLE = registerItem("lapisberry_wine_bottle", new LiquidBottleItem(List.of(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600, 0)), new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600, 0), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).alwaysEdible().build()).maxCount(16)));
    public static final Item MEAD_BOTTLE = registerItem("mead_bottle", new MeadBottleItem(List.of(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0)), new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).alwaysEdible().build()).maxCount(16)));
    public static final Item FELDSPAR = registerItem("feldspar", new Item(new Item.Settings()));
    public static final Item CERAMIC_CLAY = registerItem("ceramic_clay", new Item(new Item.Settings()));
    public static final Item CERAMIC_TILE = registerItem("ceramic_tile", new Item(new Item.Settings()));
    public static final Item TEA_BERRIES = registerItem("tea_berries", new TeaBerriesItem(BFBlocks.TEA_SHRUB, new Item.Settings()));
    public static final Item TEA_LEAVES = registerItem("tea_leaves", new Item(new Item.Settings()));
    public static final Item DRIED_TEA_LEAVES = registerItem("dried_tea_leaves", new Item(new Item.Settings()));
    public static final Item GREEN_TEA_BLEND = registerItem("green_tea_blend", new Item(new Item.Settings()));
    public static final Item BLACK_TEA_BLEND = registerItem("black_tea_blend", new Item(new Item.Settings()));
    public static final Item CHAMOMILE_TEA_BLEND = registerItem("chamomile_tea_blend", new Item(new Item.Settings()));
    public static final Item HONEYSUCKLE_TEA_BLEND = registerItem("honeysuckle_tea_blend", new Item(new Item.Settings()));
    public static final Item BELLFLOWER_TEA_BLEND = registerItem("bellflower_tea_blend", new Item(new Item.Settings()));
    public static final Item TORCHFLOWER_TEA_BLEND = registerItem("torchflower_tea_blend", new Item(new Item.Settings()));
    public static final Item GREEN_TEA_BOTTLE = registerItem("green_tea_bottle", new GreenTeaBottleItem(new Item.Settings().maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).food(new FoodComponent.Builder().nutrition(4).saturationModifier(1f).statusEffect(new StatusEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item BLACK_TEA_BOTTLE = registerItem("black_tea_bottle", new BlackTeaBottleItem(new Item.Settings().maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).food(new FoodComponent.Builder().nutrition(4).saturationModifier(1f).statusEffect(new StatusEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item CHAMOMILE_TEA_BOTTLE = registerItem("chamomile_tea_bottle", new ChamomileTeaBottleItem(new Item.Settings().maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).food(new FoodComponent.Builder().nutrition(4).saturationModifier(1f).statusEffect(new StatusEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item HONEYSUCKLE_TEA_BOTTLE = registerItem("honeysuckle_tea_bottle", new HoneysuckleTeaBottleItem(new Item.Settings().maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).food(new FoodComponent.Builder().nutrition(4).saturationModifier(1f).statusEffect(new StatusEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item BELLFLOWER_TEA_BOTTLE = registerItem("bellflower_tea_bottle", new BellflowerTeaBottleItem(new Item.Settings().maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).food(new FoodComponent.Builder().nutrition(4).saturationModifier(1f).statusEffect(new StatusEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item TORCHFLOWER_TEA_BOTTLE = registerItem("torchflower_tea_bottle", new TorchflowerTeaBottleItem(new Item.Settings().maxCount(16).recipeRemainder(Items.GLASS_BOTTLE).food(new FoodComponent.Builder().nutrition(4).saturationModifier(1f).statusEffect(new StatusEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item MAIZE = registerItem("maize", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build())));
    public static final Item GRASS_SEEDS = registerItem("grass_seeds", new GrassSeedsItem(new Item.Settings()));
    public static final Item MAIZE_SEEDS = registerItem("maize_seeds", new AliasedBlockItem(BFBlocks.MAIZE_CROP, new Item.Settings()));
    public static final Item LEEK = registerItem("leek", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build())));
    public static final Item LEEK_SEEDS = registerItem("leek_seeds", new AliasedBlockItem(BFBlocks.LEEKS, new Item.Settings()));
    public static final Item SPONGEKIN_SEEDS = registerItem("spongekin_seeds", new AliasedBlockItem(BFBlocks.SPONGEKIN_STEM, new Item.Settings()));
    public static final Item SPONGEKIN_SLICE = registerItem("spongekin_slice", new AirTimeIncreasingItem( 200, new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible().build())));
    public static final Item PICKLED_SPONGEKIN = registerItem("pickled_spongekin", new AirTimeIncreasingItem( 250, new Item.Settings().food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.8f).alwaysEdible().build())));
    public static final Item SCORCHKIN_SEEDS = registerItem("scorchkin_seeds", new AliasedBlockItem(BFBlocks.SCORCHKIN_STEM, new Item.Settings()));
    public static final Item FLOUR = registerItem("flour", new FlourItem(new Item.Settings()));
    public static final Item ARTISAN_COOKIE = registerItem("artisan_cookie", new AliasedBlockItem(BFBlocks.ARTISAN_COOKIES, new Item.Settings()));
    public static final Item SUN_HAT = registerItem("sun_hat", new SunHatItem(new Item.Settings().maxCount(1)));



    public static final Item ARTISAN_BRUSH = registerItem("artisan_brush", new ArtisanBrushItem(new Item.Settings().maxCount(1)));
    public static final Item JAR = registerItem("jar", new Item(new Item.Settings().maxCount(16)));
    public static final Item APPLE_COMPOTE_JAR = registerItem("apple_compote_jar", new EdibleJarItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.ITEM_HONEY_BOTTLE_DRINK, new Item.Settings().maxCount(16).recipeRemainder(JAR).food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).recipeRemainder(BFItems.JAR)));
    public static final Item ORANGE_COMPOTE_JAR = registerItem("orange_compote_jar", new EdibleJarItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.ITEM_HONEY_BOTTLE_DRINK, new Item.Settings().maxCount(16).recipeRemainder(JAR).food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).recipeRemainder(BFItems.JAR)));
    public static final Item LEMON_COMPOTE_JAR = registerItem("lemon_compote_jar", new EdibleJarItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.ITEM_HONEY_BOTTLE_DRINK, new Item.Settings().maxCount(16).recipeRemainder(JAR).food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).recipeRemainder(BFItems.JAR)));
    public static final Item PLUM_COMPOTE_JAR = registerItem("plum_compote_jar", new EdibleJarItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.ITEM_HONEY_BOTTLE_DRINK, new Item.Settings().maxCount(16).recipeRemainder(JAR).food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).recipeRemainder(BFItems.JAR)));
    public static final Item HOARY_COMPOTE_JAR = registerItem("hoary_compote_jar", new EdibleJarItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.ITEM_HONEY_BOTTLE_DRINK, new Item.Settings().maxCount(16).recipeRemainder(JAR).food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).recipeRemainder(BFItems.JAR)));

    public static final Item APPLE_CIDER_JAR = registerItem("apple_cider_jar", new LiquidJarItem(new Item.Settings().maxCount(16).recipeRemainder(JAR).food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).build())));
    public static final Item PLUM_CIDER_JAR = registerItem("plum_cider_jar", new LiquidJarItem(new Item.Settings().maxCount(16).recipeRemainder(JAR).food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).build())));
    public static final Item HOARY_CIDER_JAR = registerItem("hoary_cider_jar", new LiquidJarItem(new Item.Settings().maxCount(16).recipeRemainder(JAR).food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).build())));

    public static final Item CANDY = registerItem("candy", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.4F).snack().build())));
    public static final Item SOUR_CANDY = registerItem("sour_candy", new EffectFoodItem(List.of(new StatusEffectInstance(BFEffects.ACIDIC, 200)), new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(BFEffects.ACIDIC, 200), 0.2f).snack().build())));
    public static final Item PIQUANT_CANDY = registerItem("piquant_candy", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).snack().build())));
    public static final Item BITTER_CANDY = registerItem("bitter_candy", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0, true, false), 0.75f).snack().build())));
    public static final Item STRANGE_CANDY = registerItem("strange_candy", new EffectFoodItem(List.of(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20, 0)), new Item.Settings().food(new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20, 0, true, false), 1f).snack().build())));



    public static final Item PASSION_GLAZED_SALMON = registerItem("passion_glazed_salmon", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(8).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item COCONUT_CRUSTED_COD = registerItem("coconut_crusted_cod", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(8).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item BOUNTIFUL_STEW = registerItem("bountiful_stew", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Settings().maxCount(16).food((new FoodComponent.Builder()).nutrition(10).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(BFEffects.RESTORATION, 2400, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item CRUSTED_BEEF = registerItem("crusted_beef", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(10).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item LEEK_STEW = registerItem("leek_stew", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item FISH_STEW = registerItem("fish_stew", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(10).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item STONE_STEW = registerItem("stone_stew", new StackableBowlFoodItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.4F).build()).recipeRemainder(Items.BOWL)));
    public static final Item APPLE_STEW = registerItem("apple_stew", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(10).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item COCONUT_STEW = registerItem("coconut_stew", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(10).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item SEA_SALAD = registerItem("sea_salad", new StackableBowlFoodItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.5F).build()).recipeRemainder(Items.BOWL)));
    public static final Item FOREST_MEDLEY = registerItem("forest_medley", new EffectFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(10).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item ARID_MEDLEY = registerItem("arid_medley", new EffectFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(9).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item MEADOW_MEDLEY = registerItem("meadow_medley", new EffectFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(9).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item MIRE_MEDLEY = registerItem("mire_medley", new EffectFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(8).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item COASTAL_MEDLEY = registerItem("coastal_medley", new AirTimeIncreasingItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), 150, new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(8).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item TROPICAL_MEDLEY = registerItem("tropical_medley", new EffectFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(8).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item STUFFED_HOARY_APPLE = registerItem("stuffed_hoary_apple", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(8).saturationModifier(0.5F).build())));
    public static final Item CRIMSON_CHOW = registerItem("crimson_chow", new StackableBowlFoodItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(10).saturationModifier(0.8F).build()).recipeRemainder(Items.BOWL)));
    public static final Item WARPED_CHOW = registerItem("warped_chow", new StackableBowlFoodItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(8).saturationModifier(0.7F).build()).recipeRemainder(Items.BOWL)));

    public static final Item CUSTARD = registerItem("custard", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(5).saturationModifier(1.2f).statusEffect(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item PIQUANT_CUSTARD = registerItem("piquant_custard", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(7).saturationModifier(1.2f).statusEffect(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item PASSION_CUSTARD = registerItem("passion_custard", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(7).saturationModifier(1.2f).statusEffect(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item COCOA_CUSTARD = registerItem("cocoa_custard", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(8).saturationModifier(1f).statusEffect(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item ANCIENT_CUSTARD = registerItem("ancient_custard", new StackableBowlFoodItem(List.of(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Settings().maxCount(16).food(new FoodComponent.Builder().nutrition(8).saturationModifier(1f).statusEffect(new StatusEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).recipeRemainder(Items.BOWL)));
    public static final Item MUSHROOM_STUFFED_POTATO = registerItem("mushroom_stuffed_potato", new EffectFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true)), new Item.Settings().food(new FoodComponent.Builder().nutrition(8).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true), 1).build())));
    public static final Item BERRY_STUFFED_POTATO = registerItem("berry_stuffed_potato", new EffectFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Settings().food(new FoodComponent.Builder().nutrition(7).saturationModifier(0.5F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item MAIZE_STUFFED_POTATO = registerItem("maize_stuffed_potato", new EffectFoodItem(List.of(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Settings().food(new FoodComponent.Builder().nutrition(7).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item MAIZE_BREAD = registerItem("maize_bread", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.5F).build())));
    public static final Item WALNUT_COOKIE = registerItem("walnut_cookie", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final Item CANDIED_APPLE = registerItem("candied_apple", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.5F).build())));
    public static final Item CANDIED_PLUM = registerItem("candied_plum", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.5F).build())));
    public static final Item DIRT_STEW = registerItem("dirt_stew", new OPStewItem(new Item.Settings().maxCount(99).food(new FoodComponent.Builder().nutrition(1000).saturationModifier(1000)
            .statusEffect(new StatusEffectInstance(BFEffects.RESTORATION, 72000, 10, true, true), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 72000, 10, true, true), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 72000, 10, true, true), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 72000, 25, true, true), 1)
            .build())));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BountifulFares.MOD_ID, name), item);
    }

    private static Item registerTempRecipeItem(String name, String id) {
        return Registry.register(Registries.ITEM, Identifier.of(id, name), new Item(new Item.Settings()));
    }
    public static void registerModItems() {
//        BountifulFares.LOGGER.info("Registering Mod Items for " + BountifulFares.MOD_ID);
    }
}
