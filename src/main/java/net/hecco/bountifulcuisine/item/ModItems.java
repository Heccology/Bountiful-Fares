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
    public static final Item ORANGE = registerItem("orange", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0).build())));
    public static final Item LEMON = registerItem("lemon", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0).build())));
    public static final Item PLUM = registerItem("plum", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0).build())));
    public static final Item HOARY_APPLE = registerItem("hoary_apple", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0).build())));
    public static final Item HOARY_SEEDS = registerItem("hoary_seeds", new AliasedPlantItem(ModBlocks.HOARY_APPLE_SAPLING_CROP, new FabricItemSettings()));
    public static final Item HOARY_SIGN = registerItem("hoary_sign", new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.HOARY_SIGN, ModBlocks.HOARY_WALL_SIGN));
    public static final Item HOARY_HANGING_SIGN = registerItem("hoary_hanging_sign", new HangingSignItem(ModBlocks.HOARY_HANGING_SIGN, ModBlocks.HOARY_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item HOARY_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.HOARY_BOAT_ID, ModBoats.HOARY_BOAT_KEY, false);
    public static final Item HOARY_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.HOARY_CHEST_BOAT_ID, ModBoats.HOARY_BOAT_KEY, true);
    public static final Item PASSION_FRUIT = registerItem("passion_fruit", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0).snack().build())));
    public static final Item ELDERBERRIES = registerItem("elderberries", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0).snack().statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1), 0.3f).build())));
    public static final Item LAPISBERRIES = registerItem("lapisberries", new PlantItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0).snack().build())));
    public static final Item LAPISBERRY_SEEDS = registerItem("lapisberry_seeds", new PlantItem(new FabricItemSettings()));
    public static final Item WILD_CARROT = registerItem("wild_carrot", new AliasedPlantItem(Blocks.CARROTS, new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0), 0.3F).build())));
    public static final Item WILD_POTATO = registerItem("wild_potato", new AliasedPlantItem(Blocks.POTATOES, new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0), 0.3F).build())));
    public static final Item WILD_WHEAT_SEEDS = registerItem("wild_wheat_seeds", new AliasedPlantItem(Blocks.WHEAT, new FabricItemSettings()));
    public static final Item WILD_BEETROOT_SEEDS = registerItem("wild_beetroot_seeds", new AliasedPlantItem(Blocks.BEETROOTS, new FabricItemSettings()));
    public static final Item CITRUS_JUICE_BOTTLE = registerItem("citrus_juice_bottle", new CitrusJuiceBottleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).alwaysEdible().build()).maxCount(16).recipeRemainder(Items.GLASS_BOTTLE)));
    public static final Item CITRIC_ACID = registerItem("citric_acid", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(0).saturationModifier(0).snack().alwaysEdible().statusEffect(new StatusEffectInstance(ModEffects.ACIDIC, 300, 0),1).build())));
    public static final Item CANDIED_ORANGE = registerItem("candied_orange", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).snack().build())));
    public static final Item CANDIED_LEMON = registerItem("candied_lemon", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.1f).snack().build())));
    public static final Item ELDERBERRY_WINE_BOTTLE = registerItem("elderberry_wine_bottle", new LiquidBottleItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1 ), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 0), 0.3f).alwaysEdible().build()).maxCount(16)));
    public static final Item FELDSPAR = registerItem("feldspar", new Item(new FabricItemSettings()));
    public static final Item CERAMIC_CLAY = registerItem("ceramic_clay", new Item(new FabricItemSettings()));
    public static final Item CERAMIC_TILE = registerItem("ceramic_tile", new Item(new FabricItemSettings()));
    public static final Item TEA_BERRIES = registerItem("tea_berries", new TeaBerriesItem(ModBlocks.TEA_SHRUB, new FabricItemSettings()));
    public static final Item TEA_LEAVES = registerItem("tea_leaves", new PlantItem(new FabricItemSettings()));
    public static final Item DRIED_TEA_LEAVES = registerItem("dried_tea_leaves", new Item(new FabricItemSettings()));
    public static final Item SUN_HAT = registerItem("sun_hat", new FarmersHatItem(new FabricItemSettings().maxCount(1)));
//    public static final Item RED_JACK_O_STRAW = registerBlockItem("red_jack_o_straw", ModBlocks.RED_JACK_O_STRAW);

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), item);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), new TallBlockItem(block, new FabricItemSettings()));
    }
    public static void registerModItems() {
        BountifulCuisine.LOGGER.info("Registering Mod Items for ", BountifulCuisine.MOD_ID);
    }
}
