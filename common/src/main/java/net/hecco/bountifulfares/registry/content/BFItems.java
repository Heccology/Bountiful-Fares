package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.definition.item.custom.*;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class BFItems {
    public static final Supplier<Item> PASSION_FRUIT = registerItem("passion_fruit", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).fast().build())));
    public static final Supplier<Item> ELDERBERRIES = registerItem("elderberries", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f).fast().effect(new MobEffectInstance(MobEffects.HEAL, 1, 0, true, false), 0.3f).build())));
    public static final Supplier<Item> LAPISBERRY_SEEDS = registerItem("lapisberry_seeds", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> LAPISBERRIES = registerItem("lapisberries", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.1f).fast().build())));

    public static final Supplier<Item> ORANGE = registerItem("orange", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final Supplier<Item> LEMON = registerItem("lemon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final Supplier<Item> PLUM = registerItem("plum", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build())));
    public static final Supplier<Item> HOARY_APPLE = registerItem("hoary_apple", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.6F).build())));
    public static final Supplier<Item> HOARY_SEEDS = registerItem("hoary_seeds", () -> new ItemNameBlockItem(BFBlocks.HOARY_APPLE_SAPLING_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> HOARY_SIGN = registerItem("hoary_sign", () -> new SignItem(new Item.Properties().stacksTo(16), BFBlocks.HOARY_SIGN.get(), BFBlocks.HOARY_WALL_SIGN.get()));
    public static final Supplier<Item> HOARY_HANGING_SIGN = registerItem("hoary_hanging_sign", () -> new HangingSignItem(BFBlocks.HOARY_HANGING_SIGN.get(), BFBlocks.HOARY_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    //public static final Supplier<Item> HOARY_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.HOARY_BOAT_ID, BFBoats.HOARY_BOAT_KEY, false);
    //public static final Supplier<Item> HOARY_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.HOARY_CHEST_BOAT_ID, BFBoats.HOARY_BOAT_KEY, true);

    public static final Supplier<Item> SWEET_BERRY_PIPS = registerItem("sweet_berry_pips", () -> new SweetBerryPipsItem(Blocks.SWEET_BERRY_BUSH, new Item.Properties()));

    public static final Supplier<Item> WALNUT = registerItem("walnut", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0).fast().build())));
    public static final Supplier<Item> WALNUT_SIGN = registerItem("walnut_sign", () -> new SignItem(new Item.Properties().stacksTo(16), BFBlocks.WALNUT_SIGN.get(), BFBlocks.WALNUT_WALL_SIGN.get()));
    public static final Supplier<Item> WALNUT_HANGING_SIGN = registerItem("walnut_hanging_sign", () -> new HangingSignItem(BFBlocks.WALNUT_HANGING_SIGN.get(), BFBlocks.WALNUT_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    //public static final Supplier<Item> WALNUT_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.WALNUT_BOAT_ID, BFBoats.WALNUT_BOAT_KEY, false);
    //public static final Supplier<Item> WALNUT_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BFBoats.WALNUT_CHEST_BOAT_ID, BFBoats.WALNUT_BOAT_KEY, true);
    public static final Supplier<Item> PALM_FROND = registerItem("palm_frond", () -> new StandingAndWallBlockItem(BFBlocks.PALM_FROND.get(), BFBlocks.WALL_PALM_FROND.get(), new Item.Properties(), Direction.DOWN));
    public static final Supplier<Item> COCONUT = registerItem("coconut", () -> new ItemNameBlockItem(BFBlocks.PALM_SAPLING.get(), new Item.Properties()));
    public static final Supplier<Item> COCONUT_COIR = registerItem("coconut_coir", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> COCONUT_HALF = registerItem("coconut_half", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.1f).build())));
    public static final Supplier<Item> COCONUT_MILK_BOTTLE = registerItem("coconut_milk_bottle", () -> new CoconutMilkBottleItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(1f).build()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final Supplier<Item> CITRUS_ESSENCE = registerItem("citrus_essence", () -> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ACIDIC, 300, 0)), new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).fast().alwaysEdible().effect(new MobEffectInstance(BFEffects.ACIDIC, 300, 0),1).build())));
    public static final Supplier<Item> CANDIED_ORANGE = registerItem("candied_orange", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).fast().build())));
    public static final Supplier<Item> CANDIED_LEMON = registerItem("candied_lemon", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).fast().build())));
    public static final Supplier<Item> ELDERBERRY_WINE_BOTTLE = registerItem("elderberry_wine_bottle", () -> new LiquidBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.2f).effect(new MobEffectInstance(MobEffects.HEAL, 1, 1, true, false), 1).effect(new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.3f).alwaysEdible().build()).stacksTo(16)));
    public static final Supplier<Item> LAPISBERRY_WINE_BOTTLE = registerItem("lapisberry_wine_bottle", () -> new LiquidBottleItem(List.of(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0)), new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.4f).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0), 1).effect(new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.3f).alwaysEdible().build()).stacksTo(16)));
    public static final Supplier<Item> MEAD_BOTTLE = registerItem("mead_bottle", () -> new MeadBottleItem(List.of(new MobEffectInstance(MobEffects.REGENERATION, 200, 0)), new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.4f).effect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1).effect(new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.3f).alwaysEdible().build()).stacksTo(16)));
    public static final Supplier<Item> FELDSPAR = registerItem("feldspar", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> CERAMIC_CLAY = registerItem("ceramic_clay", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> CERAMIC_TILE = registerItem("ceramic_tile", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> TEA_BERRIES = registerItem("tea_berries", () -> new TeaBerriesItem(BFBlocks.TEA_SHRUB.get(), new Item.Properties()));
    public static final Supplier<Item> TEA_LEAVES = registerItem("tea_leaves", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> DRIED_TEA_LEAVES = registerItem("dried_tea_leaves", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GREEN_TEA_BOTTLE = registerItem("green_tea_bottle", () -> new GreenTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationModifier(1f).effect(new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Supplier<Item> BLACK_TEA_BOTTLE = registerItem("black_tea_bottle", () -> new BlackTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationModifier(1f).effect(new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Supplier<Item> CHAMOMILE_TEA_BOTTLE = registerItem("chamomile_tea_bottle", () -> new ChamomileTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationModifier(1f).effect(new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Supplier<Item> HONEYSUCKLE_TEA_BOTTLE = registerItem("honeysuckle_tea_bottle", () -> new HoneysuckleTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationModifier(1f).effect(new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Supplier<Item> BELLFLOWER_TEA_BOTTLE = registerItem("bellflower_tea_bottle", () -> new BellflowerTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationModifier(1f).effect(new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Supplier<Item> TORCHFLOWER_TEA_BOTTLE = registerItem("torchflower_tea_bottle", () -> new TorchflowerTeaBottleItem(new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(4).saturationModifier(1f).effect(new MobEffectInstance(BFEffects.EBULLIENCE, 6000, 0, true, true), 1f).alwaysEdible().build())));
    public static final Supplier<Item> MAIZE = registerItem("maize", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.6f).build())));
    public static final Supplier<Item> GRASS_SEEDS = registerItem("grass_seeds", () -> new GrassSeedsItem(new Item.Properties()));
    public static final Supplier<Item> MAIZE_SEEDS = registerItem("maize_seeds", () -> new ItemNameBlockItem(BFBlocks.MAIZE_CROP.get(), new Item.Properties()));
    public static final Supplier<Item> POPPED_MAIZE = registerItem("popped_maize", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f).fast().build())));
    public static final Supplier<Item> COOKED_EGG = registerItem("cooked_egg", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(1.0f).fast().build())));
    public static final Supplier<Item> LEEK = registerItem("leek", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.6f).build())));
    public static final Supplier<Item> LEEK_SEEDS = registerItem("leek_seeds", () -> new ItemNameBlockItem(BFBlocks.LEEKS.get(), new Item.Properties()));
    public static final Supplier<Item> SPONGEKIN_SEEDS = registerItem("spongekin_seeds", () -> new ItemNameBlockItem(BFBlocks.SPONGEKIN_STEM.get(), new Item.Properties()));
    public static final Supplier<Item> SPONGEKIN_SLICE = registerItem("spongekin_slice", () -> new AirTimeIncreasingItem( 200, new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible().build())));
    public static final Supplier<Item> PICKLED_SPONGEKIN = registerItem("pickled_spongekin", () -> new AirTimeIncreasingItem( 250, new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.8f).alwaysEdible().build())));
    public static final Supplier<Item> SCORCHKIN_SEEDS = registerItem("scorchkin_seeds", () -> new ItemNameBlockItem(BFBlocks.SCORCHKIN_STEM.get(), new Item.Properties()));
    public static final Supplier<Item> FLOUR = registerItem("flour", () -> new FlourItem(new Item.Properties()));
    public static final Supplier<Item> ARTISAN_COOKIE = registerItem("artisan_cookie", () -> new ItemNameBlockItem(BFBlocks.ARTISAN_COOKIE.get(), new Item.Properties()));
    public static final Supplier<Item> SUN_HAT = registerItem("sun_hat", () -> new SunHatItem(new Item.Properties().stacksTo(1)));



    public static final Supplier<Item> ARTISAN_BRUSH = registerItem("artisan_brush", () -> new ArtisanBrushItem(new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> JAR = registerItem("jar", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final Supplier<Item> APPLE_COMPOTE_JAR = registerItem("apple_compote_jar", () -> new EdibleJarItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.HONEY_DRINK, new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.4f).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).craftRemainder(BFItems.JAR.get())));
    public static final Supplier<Item> ORANGE_COMPOTE_JAR = registerItem("orange_compote_jar", () -> new EdibleJarItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.HONEY_DRINK, new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.4f).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).craftRemainder(BFItems.JAR.get())));
    public static final Supplier<Item> LEMON_COMPOTE_JAR = registerItem("lemon_compote_jar", () -> new EdibleJarItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.HONEY_DRINK, new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.4f).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).craftRemainder(BFItems.JAR.get())));
    public static final Supplier<Item> PLUM_COMPOTE_JAR = registerItem("plum_compote_jar", () -> new EdibleJarItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.HONEY_DRINK, new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.4f).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).craftRemainder(BFItems.JAR.get())));
    public static final Supplier<Item> HOARY_COMPOTE_JAR = registerItem("hoary_compote_jar", () -> new EdibleJarItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0)), SoundEvents.HONEY_DRINK, new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.4f).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0), 1f).build()).craftRemainder(BFItems.JAR.get())));

    public static final Supplier<Item> APPLE_CIDER_JAR = registerItem("apple_cider_jar", () -> new LiquidJarItem(new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build())));
    public static final Supplier<Item> PLUM_CIDER_JAR = registerItem("plum_cider_jar", () -> new LiquidJarItem(new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build())));
    public static final Supplier<Item> HOARY_CIDER_JAR = registerItem("hoary_cider_jar", () -> new LiquidJarItem(new Item.Properties().stacksTo(16).craftRemainder(JAR.get()).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build())));

    public static final Supplier<Item> CANDY = registerItem("candy", () -> new EffectClearingItem(List.of(new MobEffectInstance(MobEffects.POISON)), new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.4F).fast().build())));
    public static final Supplier<Item> SOUR_CANDY = registerItem("sour_candy", () -> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ACIDIC, 200)), new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).effect(new MobEffectInstance(BFEffects.ACIDIC, 200), 0.2f).fast().build())));
    public static final Supplier<Item> PIQUANT_CANDY = registerItem("piquant_candy", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).fast().build())));
    public static final Supplier<Item> BITTER_CANDY = registerItem("bitter_candy", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).effect(new MobEffectInstance(MobEffects.HEAL, 1, 0, true, false), 0.75f).fast().build())));
    public static final Supplier<Item> STRANGE_CANDY = registerItem("strange_candy", () -> new EffectFoodItem(List.of(new MobEffectInstance(MobEffects.NIGHT_VISION, 20, 0)), new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 20, 0, true, false), 1f).fast().build())));



    public static final Supplier<Item> PASSION_GLAZED_SALMON = registerItem("passion_glazed_salmon", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.7F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> COCONUT_CRUSTED_COD = registerItem("coconut_crusted_cod", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.7F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> BOUNTIFUL_STEW = registerItem("bountiful_stew", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(10).saturationModifier(0.6F).effect(new MobEffectInstance(BFEffects.RESTORATION, 2400, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> CRUSTED_BEEF = registerItem("crusted_beef", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.7F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 2400, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> LEEK_STEW = registerItem("leek_stew", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> FISH_STEW = registerItem("fish_stew", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.6F).effect(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> STONE_STEW = registerItem("stone_stew", () -> new StackableBowlFoodItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.4F).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> APPLE_STEW = registerItem("apple_stew", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.5F).effect(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> COCONUT_STEW = registerItem("coconut_stew", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.6F).effect(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> SEA_SALAD = registerItem("sea_salad", () -> new StackableBowlFoodItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.5F).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> FOREST_MEDLEY = registerItem("forest_medley", () -> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.6F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Supplier<Item> ARID_MEDLEY = registerItem("arid_medley", () -> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(9).saturationModifier(0.5F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Supplier<Item> MEADOW_MEDLEY = registerItem("meadow_medley", () -> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(9).saturationModifier(0.5F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Supplier<Item> MIRE_MEDLEY = registerItem("mire_medley", () -> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Supplier<Item> COASTAL_MEDLEY = registerItem("coastal_medley", () -> new AirTimeIncreasingItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), 150, new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Supplier<Item> TROPICAL_MEDLEY = registerItem("tropical_medley", () -> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Supplier<Item> STUFFED_HOARY_APPLE = registerItem("stuffed_hoary_apple", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.5F).build())));
    public static final Supplier<Item> CRIMSON_CHOW = registerItem("crimson_chow", () -> new StackableBowlFoodItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.8F).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> WARPED_CHOW = registerItem("warped_chow", () -> new StackableBowlFoodItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.7F).build()).craftRemainder(Items.BOWL)));

    public static final Supplier<Item> CUSTARD = registerItem("custard", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(5).saturationModifier(1.2f).effect(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> PIQUANT_CUSTARD = registerItem("piquant_custard", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(7).saturationModifier(1.2f).effect(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> PASSION_CUSTARD = registerItem("passion_custard", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(7).saturationModifier(1.2f).effect(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> COCOA_CUSTARD = registerItem("cocoa_custard", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationModifier(1f).effect(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> ANCIENT_CUSTARD = registerItem("ancient_custard", () -> new StackableBowlFoodItem(List.of(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true)), new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationModifier(1f).effect(new MobEffectInstance(BFEffects.RESTORATION, 1800, 0, true, true), 1).build()).craftRemainder(Items.BOWL)));
    public static final Supplier<Item> MUSHROOM_STUFFED_POTATO = registerItem("mushroom_stuffed_potato", () -> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true)), new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1800, 0, true, true), 1).build())));
    public static final Supplier<Item> BERRY_STUFFED_POTATO = registerItem("berry_stuffed_potato", () -> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.5F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Supplier<Item> MAIZE_STUFFED_POTATO = registerItem("maize_stuffed_potato", () -> new EffectFoodItem(List.of(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true)), new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.6F).effect(new MobEffectInstance(BFEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Supplier<Item> MAIZE_BREAD = registerItem("maize_bread", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.5F).build())));
    public static final Supplier<Item> WALNUT_COOKIE = registerItem("walnut_cookie", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build())));
    public static final Supplier<Item> CANDIED_APPLE = registerItem("candied_apple", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.5F).build())));
    public static final Supplier<Item> CANDIED_PLUM = registerItem("candied_plum", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.5F).build())));
    public static final Supplier<Item> DIRT_STEW = registerItem("dirt_stew", () -> new OPStewItem(new Item.Properties().stacksTo(99).food(new FoodProperties.Builder().nutrition(1000).saturationModifier(1000)
            .effect(new MobEffectInstance(BFEffects.RESTORATION, 72000, 10, true, true), 1)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 72000, 10, true, true), 1)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 72000, 10, true, true), 1)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 72000, 25, true, true), 1)
            .build())));

    public static final Map<DyeColor, Supplier<Item>> TIFFINS = new HashMap<>();

    private static void registerTiffins() {
        TIFFINS.put(null, registerItem("shulker_tiffin", () -> new TiffinItem(createTiffinProperties())));
        for (DyeColor color : DyeColor.values()) {
            TIFFINS.put(color, registerItem(color.getName() + "_shulker_tiffin", () -> new TiffinItem(createTiffinProperties())));
        }
    }

    private static void registerTrellises() {
        for (String wood : BountifulFaresUtil.WOOD_TYPES) {
            if (!Objects.equals(wood, "oak")) {
                registerItem(wood + "_trellis", () -> new TrellisBlockItem(BFBlocks.TRELLISES.get(wood).get(), new Item.Properties()));
            } else {
                registerItem("trellis", () -> new TrellisBlockItem(BFBlocks.TRELLISES.get(wood).get(), new Item.Properties()));
            }
        }
    }

    private static Supplier<Item> registerItem(String id, Supplier<Item> registry) {
        return HLServices.REGISTRY.register(BountifulFares.MOD_ID, id, BuiltInRegistries.ITEM.key(), registry);
    }

    private static Item.Properties createTiffinProperties() {
        return new Item.Properties()
                .stacksTo(1)
                .food(new FoodProperties.Builder().nutrition(0).saturationModifier(0).build());
    }

    public static void registerModItems() {
        registerTiffins();
        registerTrellises();
    }
}
