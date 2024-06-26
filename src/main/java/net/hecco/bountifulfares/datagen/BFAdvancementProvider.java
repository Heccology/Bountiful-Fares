package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.util.BFItemTags;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class BFAdvancementProvider extends FabricAdvancementProvider {
    public BFAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement root_advancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.PASSION_FRUIT),
                        Text.translatable("advancement.bountifulfares.bountiful_fares"),
                        Text.translatable("advancement.bountifulfares.bountiful_fares.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        false,
                        false,
                        false)).criterion("consume_item", ConsumeItemCriterion.Conditions.any())
                .build(consumer, BountifulFares.MOD_ID + ":bountiful_fares");
        Advancement make_first_food = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.BOUNTIFUL_STEW),
                        Text.translatable("advancement.bountifulfares.make_first_food"),
                        Text.translatable("advancement.bountifulfares.make_first_food.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("make_first_food", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().tag(BFItemTags.MEALS).build()))
                .build(consumer, BountifulFares.MOD_ID + ":make_first_food");
        Advancement eat_all_food = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.CRUSTED_BEEF),
                        Text.translatable("advancement.bountifulfares.eat_all_food"),
                        Text.translatable("advancement.bountifulfares.eat_all_food.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.GOAL,
                        true,
                        true,
                        false))
                .parent(make_first_food)
                .criterion("mushroom_stuffed_potato", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.MUSHROOM_STUFFED_POTATO).build()))
                .criterion("berry_stuffed_potato", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.BERRY_STUFFED_POTATO).build()))
                .criterion("maize_stuffed_potato", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.MAIZE_STUFFED_POTATO).build()))
                .criterion("passion_glazed_salmon", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.PASSION_GLAZED_SALMON).build()))
                .criterion("leek_stew", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.LEEK_STEW).build()))
                .criterion("fish_stew", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.FISH_STEW).build()))
                .criterion("apple_stew", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.APPLE_STEW).build()))
                .criterion("stone_stew", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.STONE_STEW).build()))
                .criterion("bountiful_stew", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.BOUNTIFUL_STEW).build()))
                .criterion("forest_medley", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.FOREST_MEDLEY).build()))
                .criterion("arid_medley", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.ARID_MEDLEY).build()))
                .criterion("meadow_medley", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.MEADOW_MEDLEY).build()))
                .criterion("coastal_medley", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.COASTAL_MEDLEY).build()))
                .criterion("crusted_beef", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.CRUSTED_BEEF).build()))
                .criterion("crimson_chow", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.CRIMSON_CHOW).build()))
                .criterion("warped_chow", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.WARPED_CHOW).build()))
                .criterion("custard", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.CUSTARD).build()))
                .criterion("piquant_custard", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.PIQUANT_CUSTARD).build()))
                .criterion("passion_custard", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.PASSION_CUSTARD).build()))
                .criterion("cocoa_custard", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.COCOA_CUSTARD).build()))
                .criterion("ancient_custard", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.ANCIENT_CUSTARD).build()))
                .build(consumer, BountifulFares.MOD_ID + ":eat_all_food");
        Advancement place_gristmill = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.GRISTMILL),
                        Text.translatable("advancement.bountifulfares.place_gristmill"),
                        Text.translatable("advancement.bountifulfares.place_gristmill.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("place_gristmill", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.GRISTMILL))
                .build(consumer, BountifulFares.MOD_ID + ":place_gristmill");

        Advancement obtain_feldspar = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.FELDSPAR),
                        Text.translatable("advancement.bountifulfares.obtain_feldspar"),
                        Text.translatable("advancement.bountifulfares.obtain_feldspar.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(place_gristmill)
                .criterion("obtain_feldspar", InventoryChangedCriterion.Conditions.items(BFItems.FELDSPAR))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_feldspar");

        Advancement obtain_ceramic_tiles = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.CERAMIC_TILES),
                        Text.translatable("advancement.bountifulfares.obtain_ceramic_tiles"),
                        Text.translatable("advancement.bountifulfares.obtain_ceramic_tiles.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(obtain_feldspar)
                .criterion("obtain_ceramic_tiles", InventoryChangedCriterion.Conditions.items(BFBlocks.CERAMIC_TILES))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_ceramic_tiles");
        Advancement obtain_fermentation_vessel = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.FERMENTATION_VESSEL),
                        Text.translatable("advancement.bountifulfares.obtain_fermentation_vessel"),
                        Text.translatable("advancement.bountifulfares.obtain_fermentation_vessel.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(obtain_feldspar)
                .criterion("obtain_fermentation_vessel", InventoryChangedCriterion.Conditions.items(BFBlocks.FERMENTATION_VESSEL))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_fermentation_vessel");
        Advancement eat_ancient_fruit = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.HOARY_APPLE),
                        Text.translatable("advancement.bountifulfares.eat_ancient_fruit"),
                        Text.translatable("advancement.bountifulfares.eat_ancient_fruit.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("eat_ancient_fruit", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.HOARY_APPLE, BFItems.LAPISBERRIES).build()))
                .build(consumer, BountifulFares.MOD_ID + ":eat_ancient_fruit");
        Advancement place_all_baked_goods = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.ARTISAN_BREAD),
                        Text.translatable("advancement.bountifulfares.place_all_baked_goods"),
                        Text.translatable("advancement.bountifulfares.place_all_baked_goods.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("cake", ItemCriterion.Conditions.createPlacedBlock(Blocks.CAKE))
                .criterion("cocoa_cake", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.COCOA_CAKE))
                .criterion("artisan_bread", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.ARTISAN_BREAD))
                .criterion("artisan_cookie", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.ARTISAN_COOKIES))
                .criterion("apple_pie", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.APPLE_PIE))
                .criterion("orange_pie", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.ORANGE_PIE))
                .criterion("lemon_pie", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.LEMON_PIE))
                .criterion("plum_pie", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.PLUM_PIE))
                .criterion("hoary_pie", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.HOARY_PIE))
                .criterion("passion_fruit_tart", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.PASSION_FRUIT_TART))
                .criterion("elderberry_tart", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.ELDERBERRY_TART))
                .criterion("glow_berry_tart", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.GLOW_BERRY_TART))
                .criterion("sweet_berry_tart", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.SWEET_BERRY_TART))
                .criterion("lapisberry_tart", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.LAPISBERRY_TART))
                .build(consumer, BountifulFares.MOD_ID + ":place_all_baked_goods");
        Advancement eat_citrus_essence = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.CITRUS_ESSENCE),
                        Text.translatable("advancement.bountifulfares.eat_citrus_essence"),
                        Text.translatable("advancement.bountifulfares.eat_citrus_essence.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false
                ))
                .parent(obtain_fermentation_vessel)
                .criterion("eat_citrus_essence", ConsumeItemCriterion.Conditions.item(BFItems.CITRUS_ESSENCE))
                .build(consumer, BountifulFares.MOD_ID + ":eat_citrus_essence");
//        Advancement throw_flour = Advancement.Builder.create()
//                .display(new AdvancementDisplay(new ItemStack(ModItems.FLOUR),
//                        Text.translatable("advancement.bountifulfares.throw_flour"),
//                        Text.translatable("advancement.bountifulfares.throw_flour.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
//                        true,
//                        true,
//                        false))
//                .parent(place_gristmill)
////                .criterion("throw_flour", ItemCriterion.Conditions.createItemUsedOnBlock(LocationPredicate.Builder.create().block(BlockPredicate.ANY), ItemPredicate.Builder.create().items(ModItems.FLOUR)))
////                .criterion("throw_flour", SummonedEntityCriterion.Conditions.create(EntityPredicate.Builder.create().type(ModEntities.THROWN_FLOUR_PROJECTILE)))
//                .build(consumer, BountifulFares.MOD_ID + ":throw_flour");
        Advancement obtain_sun_hat = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.SUN_HAT),
                        Text.translatable("advancement.bountifulfares.obtain_sun_hat"),
                        Text.translatable("advancement.bountifulfares.obtain_sun_hat.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("obtain_sun_hat", InventoryChangedCriterion.Conditions.items(BFItems.SUN_HAT))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_sun_hat");
        Advancement eat_all_candy = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.CANDY),
                        Text.translatable("advancement.bountifulfares.eat_all_candy"),
                        Text.translatable("advancement.bountifulfares.eat_all_candy.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("candy", ConsumeItemCriterion.Conditions.item(BFItems.CANDY))
                .criterion("piquant", ConsumeItemCriterion.Conditions.item(BFItems.PIQUANT_CANDY))
                .criterion("sour", ConsumeItemCriterion.Conditions.item(BFItems.SOUR_CANDY))
                .criterion("bitter", ConsumeItemCriterion.Conditions.item(BFItems.BITTER_CANDY))
                .build(consumer, BountifulFares.MOD_ID + ":eat_all_candy");
//        Advancement gorge = Advancement.Builder.create()
//                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUR_CANDY),
//                        Text.translatable("advancement.bountifulfares.gorge"),
//                        Text.translatable("advancement.bountifulfares.gorge.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
//                        true,
//                        true,
//                        false))
//                .parent(eat_all_candy)
//                .criterion("gorge", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.create().withEffect(ModEffects.GORGING)))
//                .build(consumer, BountifulFares.MOD_ID + ":gorge");
        Advancement obtain_tea_blends = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.TEA_LEAVES),
                        Text.translatable("advancement.bountifulfares.obtain_tea_blends"),
                        Text.translatable("advancement.bountifulfares.obtain_tea_blends.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false))
                .parent(place_gristmill)
                .criterion("green", InventoryChangedCriterion.Conditions.items(BFItems.GREEN_TEA_BLEND))
                .criterion("black", InventoryChangedCriterion.Conditions.items(BFItems.BLACK_TEA_BLEND))
                .criterion("chamomile", InventoryChangedCriterion.Conditions.items(BFItems.CHAMOMILE_TEA_BLEND))
                .criterion("honeysuckle", InventoryChangedCriterion.Conditions.items(BFItems.HONEYSUCKLE_TEA_BLEND))
                .criterion("bellflower", InventoryChangedCriterion.Conditions.items(BFItems.BELLFLOWER_TEA_BLEND))
                .criterion("torchflower", InventoryChangedCriterion.Conditions.items(BFItems.TORCHFLOWER_TEA_BLEND))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_tea_blends");
        Advancement place_all_tea_candles = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.GREEN_TEA_CANDLE),
                        Text.translatable("advancement.bountifulfares.place_all_tea_candles"),
                        Text.translatable("advancement.bountifulfares.place_all_tea_candles.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false))
                .parent(obtain_tea_blends)
                .criterion("green", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.GREEN_TEA_CANDLE))
                .criterion("black", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.BLACK_TEA_CANDLE))
                .criterion("chamomile", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.CHAMOMILE_CANDLE))
                .criterion("honeysuckle", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.HONEYSUCKLE_CANDLE))
                .criterion("bellflower", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.BELLFLOWER_CANDLE))
                .criterion("torchflower", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.TORCHFLOWER_CANDLE))
                .criterion("walnut", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.WALNUT_CANDLE))
                .build(consumer, BountifulFares.MOD_ID + ":place_all_tea_candles");
        Advancement obtain_walnut = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.WALNUT),
                        Text.translatable("advancement.bountifulfares.obtain_walnut"),
                        Text.translatable("advancement.bountifulfares.obtain_walnut.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("obtain_walnut", InventoryChangedCriterion.Conditions.items(BFItems.WALNUT))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_walnut");
        Advancement obtain_spongekin_seeds = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.SPONGEKIN_SEEDS),
                        Text.translatable("advancement.bountifulfares.obtain_spongekin_seeds"),
                        Text.translatable("advancement.bountifulfares.obtain_spongekin_seeds.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("obtain_spongekin_seeds", InventoryChangedCriterion.Conditions.items(BFItems.SPONGEKIN_SEEDS))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_spongekin_seeds");
        Advancement obtain_spongekin = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.SPONGEKIN),
                        Text.translatable("advancement.bountifulfares.obtain_spongekin"),
                        Text.translatable("advancement.bountifulfares.obtain_spongekin.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(obtain_spongekin_seeds)
                .criterion("obtain_spongekin", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().items(BFItems.SPONGEKIN_SLICE, BFBlocks.SPONGEKIN).build()))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_spongekin");
//        Advancement breedWolvesWithMulch = Advancement.Builder.create()
//                .display(new AdvancementDisplay(new ItemStack(ModBlocks.WALNUT_MULCH),
//                        Text.translatable("advancement.bountifulfares.breed_wolves_with_mulch"),
//                        Text.translatable("advancement.bountifulfares.breed_wolves_with_mulch.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.CHALLENGE,
//                        true,
//                        true,
//                        false))
//                .parent(obtain_feldspar)
//                .criterion("breed_wolves_with_mulch", PlayerInteractedWithEntityCriterion.Conditions.create(ItemPredicate.Builder.create().items(ModBlocks.WALNUT_MULCH), LootContextPredicate.create()))
//                .build(consumer, BountifulFares.MOD_ID + ":breed_wolves_with_mulch");
    }
}
//EntityPredicate.Builder.create().type(EntityType.WOLF