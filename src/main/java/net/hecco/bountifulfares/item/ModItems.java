package net.hecco.bountifulfares.item;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.effect.ModEffects;
import net.hecco.bountifulfares.entity.ModBoats;
import net.hecco.bountifulfares.item.custom.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class ModItems {
    public static final Item PASSION_FRUIT = registerItem("passion_fruit", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).snack().build())));
    public static final Item ELDERBERRIES = registerItem("elderberries", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).snack().statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1), 0.3f).build())));
    public static final Item LAPISBERRIES = registerItem("lapisberries", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).snack().build())));
    public static final Item LAPISBERRY_SEEDS = registerItem("lapisberry_seeds", new Item(new FabricItemSettings()));

    public static final Item ORANGE = registerItem("orange", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build())));
    public static final Item LEMON = registerItem("lemon", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build())));
    public static final Item PLUM = registerItem("plum", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build())));
    public static final Item HOARY_APPLE = registerItem("hoary_apple", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6F).build())));
    public static final Item HOARY_SEEDS = registerItem("hoary_seeds", new AliasedBlockItem(ModBlocks.HOARY_APPLE_SAPLING_CROP, new FabricItemSettings()));
    public static final Item HOARY_SIGN = registerItem("hoary_sign", new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.HOARY_SIGN, ModBlocks.HOARY_WALL_SIGN));
    public static final Item HOARY_HANGING_SIGN = registerItem("hoary_hanging_sign", new HangingSignItem(ModBlocks.HOARY_HANGING_SIGN, ModBlocks.HOARY_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item HOARY_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.HOARY_BOAT_ID, ModBoats.HOARY_BOAT_KEY, false);
    public static final Item HOARY_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.HOARY_CHEST_BOAT_ID, ModBoats.HOARY_BOAT_KEY, true);

    public static final Item WALNUT = registerItem("walnut", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0).snack().build())));
    public static final Item WALNUT_SIGN = registerItem("walnut_sign", new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.WALNUT_SIGN, ModBlocks.WALNUT_WALL_SIGN));
    public static final Item WALNUT_HANGING_SIGN = registerItem("walnut_hanging_sign", new HangingSignItem(ModBlocks.WALNUT_HANGING_SIGN, ModBlocks.WALNUT_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item WALNUT_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.WALNUT_BOAT_ID, ModBoats.WALNUT_BOAT_KEY, false);
    public static final Item WALNUT_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.WALNUT_CHEST_BOAT_ID, ModBoats.WALNUT_BOAT_KEY, true);
    public static final Item CITRUS_ESSENCE = registerItem("citrus_essence", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(1).snack().alwaysEdible().statusEffect(new StatusEffectInstance(ModEffects.ACIDIC, 300, 0),1).build())));
    public static final Item CANDIED_ORANGE = registerItem("candied_orange", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).snack().build())));
    public static final Item CANDIED_LEMON = registerItem("candied_lemon", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).snack().build())));
    public static final Item ELDERBERRY_WINE_BOTTLE = registerItem("elderberry_wine_bottle", new LiquidBottleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1, true, false), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).alwaysEdible().build()).maxCount(16)));
    public static final Item LAPISBERRY_WINE_BOTTLE = registerItem("lapisberry_wine_bottle", new LiquidBottleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600, 0), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).alwaysEdible().build()).maxCount(16)));
    public static final Item MEAD_BOTTLE = registerItem("mead_bottle", new MeadBottleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).alwaysEdible().build()).maxCount(16)));
    public static final Item FELDSPAR = registerItem("feldspar", new Item(new FabricItemSettings()));
    public static final Item CERAMIC_CLAY = registerItem("ceramic_clay", new Item(new FabricItemSettings()));
    public static final Item CERAMIC_TILE = registerItem("ceramic_tile", new Item(new FabricItemSettings()));
    public static final Item TEA_BERRIES = registerItem("tea_berries", new TeaBerriesItem(ModBlocks.TEA_SHRUB, new FabricItemSettings()));
    public static final Item TEA_LEAVES = registerItem("tea_leaves", new Item(new FabricItemSettings()));
    public static final Item DRIED_TEA_LEAVES = registerItem("dried_tea_leaves", new Item(new FabricItemSettings()));
    public static final Item GREEN_TEA_BLEND = registerItem("green_tea_blend", new Item(new FabricItemSettings()));
    public static final Item BLACK_TEA_BLEND = registerItem("black_tea_blend", new Item(new FabricItemSettings()));
    public static final Item CHAMOMILE_TEA_BLEND = registerItem("chamomile_tea_blend", new Item(new FabricItemSettings()));
    public static final Item HONEYSUCKLE_TEA_BLEND = registerItem("honeysuckle_tea_blend", new Item(new FabricItemSettings()));
    public static final Item BELLFLOWER_TEA_BLEND = registerItem("bellflower_tea_blend", new Item(new FabricItemSettings()));
    public static final Item TORCHFLOWER_TEA_BLEND = registerItem("torchflower_tea_blend", new Item(new FabricItemSettings()));
    public static final Item GREEN_TEA_BOTTLE = registerItem("green_tea_bottle", new GreenTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 1800, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item BLACK_TEA_BOTTLE = registerItem("black_tea_bottle", new BlackTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 1800, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item CHAMOMILE_TEA_BOTTLE = registerItem("chamomile_tea_bottle", new ChamomileTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 1800, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item HONEYSUCKLE_TEA_BOTTLE = registerItem("honeysuckle_tea_bottle", new HoneysuckleTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 1800, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item BELLFLOWER_TEA_BOTTLE = registerItem("bellflower_tea_bottle", new BellflowerTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 1800, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item TORCHFLOWER_TEA_BOTTLE = registerItem("torchflower_tea_bottle", new TorchflowerTeaBottleItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.EBULLIENCE, 1800, 0, true, true), 1f).alwaysEdible().build())));
    public static final Item MAIZE = registerItem("maize", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build())));
//    public static final Item GRASS_SEEDS = registerItem("grass_seeds", new GrassSeedsItem(new FabricItemSettings()));
    public static final Item MAIZE_SEEDS = registerItem("maize_seeds", new AliasedBlockItem(ModBlocks.MAIZE_CROP, new FabricItemSettings()));
    public static final Item LEEK = registerItem("leek", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build())));
    public static final Item LEEK_SEEDS = registerItem("leek_seeds", new AliasedBlockItem(ModBlocks.LEEKS, new FabricItemSettings()));
    public static final Item SPONGEKIN_SEEDS = registerItem("spongekin_seeds", new AliasedBlockItem(ModBlocks.SPONGEKIN_STEM, new FabricItemSettings()));
    public static final Item SPONGEKIN_SLICE = registerItem("spongekin_slice", new SpongekinSliceItem( 100, new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).alwaysEdible().build())));
    public static final Item FLOUR = registerItem("flour", new FlourItem(new FabricItemSettings()));
    public static final Item ARTISAN_COOKIE = registerItem("artisan_cookie", new AliasedBlockItem(ModBlocks.ARTISAN_COOKIES, new FabricItemSettings()));
    public static final Item SUN_HAT = registerItem("sun_hat", new FarmersHatItem(new FabricItemSettings().maxCount(1)));



    public static final Item ARTISAN_BRUSH = registerItem("artisan_brush", new ArtisanBrushItem(new FabricItemSettings().maxCount(1)));
    public static final Item JAR = registerItem("jar", new Item(new FabricItemSettings().maxCount(16)));
    public static final Item APPLE_COMPOTE_JAR = registerItem("apple_compote_jar", new EdibleJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1f).build())));
    public static final Item ORANGE_COMPOTE_JAR = registerItem("orange_compote_jar", new EdibleJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1f).build())));
    public static final Item LEMON_COMPOTE_JAR = registerItem("lemon_compote_jar", new EdibleJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1f).build())));
    public static final Item PLUM_COMPOTE_JAR = registerItem("plum_compote_jar", new EdibleJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1f).build())));
    public static final Item HOARY_COMPOTE_JAR = registerItem("hoary_compote_jar", new EdibleJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0), 1f).build())));

    public static final Item APPLE_CIDER_JAR = registerItem("apple_cider_jar", new DrinkableJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));
    public static final Item PLUM_CIDER_JAR = registerItem("plum_cider_jar", new DrinkableJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));
    public static final Item HOARY_CIDER_JAR = registerItem("hoary_cider_jar", new DrinkableJarItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item CANDY = registerItem("candy", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4F).snack().build())));
    public static final Item SOUR_CANDY = registerItem("sour_candy", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.4F).statusEffect(new StatusEffectInstance(ModEffects.ACIDIC, 200), 0.2f).snack().build())));
    public static final Item PIQUANT_CANDY = registerItem("piquant_candy", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.4F).snack().build())));
    public static final Item BITTER_CANDY = registerItem("bitter_candy", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1), 0.75f).snack().build())));



    public static final Item PASSION_GLAZED_SALMON = registerItem("passion_glazed_salmon", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(ModEffects.ENRICHMENT, 2400, 0, true, true), 1).build())));
    public static final Item BOUNTIFUL_STEW = registerItem("bountiful_stew", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food((new FoodComponent.Builder()).hunger(16).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(ModEffects.RESTORATION, 2400, 0, true, true), 1).build())));
    public static final Item CRUSTED_BEEF = registerItem("crusted_beef", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(18).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(ModEffects.ENRICHMENT, 2400, 0, true, true), 1).build())));
    public static final Item LEEK_STEW = registerItem("leek_stew", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(12).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(ModEffects.ENRICHMENT, 1800, 0, true, true), 1).build())));
    public static final Item FISH_STEW = registerItem("fish_stew", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(14).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(ModEffects.RESTORATION, 1800, 0, true, true), 1).build())));
    public static final Item STONE_STEW = registerItem("stone_stew", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(12).saturationModifier(0.5F).build())));
    public static final Item APPLE_STEW = registerItem("apple_stew", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(14).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(ModEffects.RESTORATION, 1800, 0, true, true), 1).build())));
    public static final Item FOREST_MEDLEY = registerItem("forest_medley", new Item(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(12).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(ModEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item ARID_MEDLEY = registerItem("arid_medley", new Item(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(12).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(ModEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item MEADOW_MEDLEY = registerItem("meadow_medley", new Item(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(12).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(ModEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item COASTAL_MEDLEY = registerItem("coastal_medley", new Item(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(12).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(ModEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item CRIMSON_CHOW = registerItem("crimson_chow", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(12).saturationModifier(0.8F).build())));
    public static final Item WARPED_CHOW = registerItem("warped_chow", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(10).saturationModifier(0.8F).build())));

    public static final Item CUSTARD = registerItem("custard", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.RESTORATION, 1800, 0, true, true), 1).build())));
    public static final Item PIQUANT_CUSTARD = registerItem("piquant_custard", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.RESTORATION, 1800, 0, true, true), 1).build())));
    public static final Item PASSION_CUSTARD = registerItem("passion_custard", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.RESTORATION, 1800, 0, true, true), 1).build())));
    public static final Item COCOA_CUSTARD = registerItem("cocoa_custard", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.RESTORATION, 1800, 0, true, true), 1).build())));
    public static final Item GLOWING_CUSTARD = registerItem("glowing_custard", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.RESTORATION, 1800, 0, true, true), 1).build())));
    public static final Item ANCIENT_CUSTARD = registerItem("ancient_custard", new StackableBowlFoodItem(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.RESTORATION, 1800, 0, true, true), 1).build())));
    public static final Item MUSHROOM_STUFFED_POTATO = registerItem("mushroom_stuffed_potato", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.ENRICHMENT, 1800, 0, true, true), 1).build())));
    public static final Item BERRY_STUFFED_POTATO = registerItem("berry_stuffed_potato", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item MAIZE_STUFFED_POTATO = registerItem("maize_stuffed_potato", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.ENRICHMENT, 1200, 0, true, true), 1).build())));
    public static final Item MAIZE_BREAD = registerItem("maize_bread", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6F).build())));
    public static final Item WALNUT_COOKIE = registerItem("walnut_cookie", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2F).build())));
    public static final Item CANDIED_APPLE = registerItem("candied_apple", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.5F).build())));
    public static final Item CANDIED_PLUM = registerItem("candied_plum", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6F).build())));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BountifulFares.MOD_ID, name), item);
    }
    public static void registerModItems() {
        BountifulFares.LOGGER.info("Registering Mod Items for " + BountifulFares.MOD_ID);
    }
}
