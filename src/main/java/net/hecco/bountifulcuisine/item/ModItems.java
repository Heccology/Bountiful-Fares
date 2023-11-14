package net.hecco.bountifulcuisine.item;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.effect.ModEffects;
import net.hecco.bountifulcuisine.entity.ModBoats;
import net.hecco.bountifulcuisine.item.custom.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallFlowerBlock;
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
    public static final Item PASSION_FRUIT = registerItem("passion_fruit", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).snack().build())));
    public static final Item ELDERBERRIES = registerItem("elderberries", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).snack().statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1), 0.3f).build())));
    public static final Item LAPISBERRIES = registerItem("lapisberries", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).snack().build())));
    public static final Item LAPISBERRY_SEEDS = registerItem("lapisberry_seeds", new PlantItem(new FabricItemSettings()));
    public static final Item CITRIC_ACID = registerItem("citric_acid", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(0).saturationModifier(0).snack().alwaysEdible().statusEffect(new StatusEffectInstance(ModEffects.ACIDIC, 300, 0),1).build())));
    public static final Item CANDIED_ORANGE = registerItem("candied_orange", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).snack().build())));
    public static final Item CANDIED_LEMON = registerItem("candied_lemon", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).snack().build())));
    public static final Item ELDERBERRY_WINE_BOTTLE = registerItem("elderberry_wine_bottle", new LiquidBottleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).alwaysEdible().build()).maxCount(16)));
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
    public static final Item GOOSEBERRIES = registerItem("gooseberries", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build())));
    public static final Item GOOSEBERRY_SEEDS = registerItem("gooseberry_seeds", new AliasedPlantItem(ModBlocks.GOOSEBERRIES, new FabricItemSettings()));
    public static final Item SPONGEKIN_SEEDS = registerItem("spongekin_seeds", new AliasedPlantItem(ModBlocks.SPONGEKIN_STEM, new FabricItemSettings()));
    public static final Item SPONGEKIN_SLICE = registerItem("spongekin_slice", new SpongekinSliceItem( 100, new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).alwaysEdible().build())));
    public static final Item FLOUR = registerItem("flour", new FlourItem(new FabricItemSettings()));
    public static final Item SUN_HAT = registerItem("sun_hat", new FarmersHatItem(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), item);
    }
    public static void registerModItems() {
        BountifulCuisine.LOGGER.info("Registering Mod Items for ", BountifulCuisine.MOD_ID);
    }
}
