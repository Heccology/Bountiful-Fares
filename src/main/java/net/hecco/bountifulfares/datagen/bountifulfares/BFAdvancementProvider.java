package net.hecco.bountifulfares.datagen.bountifulfares;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.ItemCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BFAdvancementProvider extends FabricAdvancementProvider {


    public BFAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry root_advancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.PASSION_FRUIT),
                        Text.translatable("advancement.bountifulfares.bountiful_fares"),
                        Text.translatable("advancement.bountifulfares.bountiful_fares.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        false,
                        false,
                        false))
                .criterion("consume_item", ConsumeItemCriterion.Conditions.any())
                .build(consumer, BountifulFares.MOD_ID + ":bountiful_fares");
        AdvancementEntry make_first_food = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.BOUNTIFUL_STEW),
                        Text.translatable("advancement.bountifulfares.make_first_food"),
                        Text.translatable("advancement.bountifulfares.make_first_food.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("make_first_food", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().tag(BFItemTags.MEALS)))
                .build(consumer, BountifulFares.MOD_ID + ":make_first_food");

        Advancement.Builder eat_all_food = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.CRUSTED_BEEF),
                        Text.translatable("advancement.bountifulfares.eat_all_food"),
                        Text.translatable("advancement.bountifulfares.eat_all_food.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.GOAL,
                        true,
                        true,
                        false))
                .parent(make_first_food);
        for (Item i : Registries.ITEM) {
            if (Registries.ITEM.getId(i).getNamespace() == BountifulFares.MOD_ID && i.getComponents().contains(DataComponentTypes.FOOD) && i != BFItems.DIRT_STEW) {
                eat_all_food.criterion(Registries.ITEM.getId(i).getPath(), ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(i)));
            }
        }
        eat_all_food.build(consumer, BountifulFares.MOD_ID + ":eat_all_food");

        AdvancementEntry obtain_lemon_block = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.LEMON),
                        Text.translatable("advancement.bountifulfares.how_easy"),
                        Text.translatable("advancement.bountifulfares.how_easy.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true))
                .parent(root_advancement)
                .criterion("obtain_lemon_block", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.LEMON_BLOCK))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_lemon_block");
        AdvancementEntry place_gristmill = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.GRISTMILL),
                        Text.translatable("advancement.bountifulfares.place_gristmill"),
                        Text.translatable("advancement.bountifulfares.place_gristmill.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("place_gristmill", ItemCriterion.Conditions.createPlacedBlock(BFBlocks.GRISTMILL))
                .build(consumer, BountifulFares.MOD_ID + ":place_gristmill");

        AdvancementEntry obtain_feldspar = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.FELDSPAR),
                        Text.translatable("advancement.bountifulfares.obtain_feldspar"),
                        Text.translatable("advancement.bountifulfares.obtain_feldspar.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(place_gristmill)
                .criterion("obtain_feldspar", InventoryChangedCriterion.Conditions.items(BFItems.FELDSPAR))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_feldspar");

        AdvancementEntry obtain_ceramic_tiles = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.CERAMIC_TILES),
                        Text.translatable("advancement.bountifulfares.obtain_ceramic_tiles"),
                        Text.translatable("advancement.bountifulfares.obtain_ceramic_tiles.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(obtain_feldspar)
                .criterion("obtain_ceramic_tiles", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().tag(BFItemTags.DYEABLE_CERAMIC_BLOCKS)))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_ceramic_tiles");
        AdvancementEntry obtain_fermentation_vessel = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.FERMENTATION_VESSEL),
                        Text.translatable("advancement.bountifulfares.obtain_fermentation_vessel"),
                        Text.translatable("advancement.bountifulfares.obtain_fermentation_vessel.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(obtain_feldspar)
                .criterion("obtain_fermentation_vessel", InventoryChangedCriterion.Conditions.items(BFBlocks.FERMENTATION_VESSEL))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_fermentation_vessel");
        AdvancementEntry eat_ancient_fruit = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.HOARY_APPLE),
                        Text.translatable("advancement.bountifulfares.eat_ancient_fruit"),
                        Text.translatable("advancement.bountifulfares.eat_ancient_fruit.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("eat_ancient_fruit", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(BFItems.HOARY_APPLE, BFItems.LAPISBERRIES)))
                .build(consumer, BountifulFares.MOD_ID + ":eat_ancient_fruit");
        AdvancementEntry place_all_baked_goods = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.ARTISAN_BREAD),
                        Text.translatable("advancement.bountifulfares.place_all_baked_goods"),
                        Text.translatable("advancement.bountifulfares.place_all_baked_goods.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.CHALLENGE,
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
        AdvancementEntry eat_citrus_essence = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.CITRUS_ESSENCE),
                        Text.translatable("advancement.bountifulfares.eat_citrus_essence"),
                        Text.translatable("advancement.bountifulfares.eat_citrus_essence.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false
                ))
                .parent(obtain_fermentation_vessel)
                .criterion("eat_citrus_essence", ConsumeItemCriterion.Conditions.item(BFItems.CITRUS_ESSENCE))
                .build(consumer, BountifulFares.MOD_ID + ":eat_citrus_essence");
//        AdvancementEntry throw_flour = Advancement.Builder.create()
//                .display(new AdvancementDisplay(new ItemStack(ModItems.FLOUR),
//                        Text.translatable("advancement.bountifulfares.throw_flour"),
//                        Text.translatable("advancement.bountifulfares.throw_flour.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
//                        true,
//                        true,
//                        false))
//                .parent(place_gristmill)
////                .criterion("throw_flour", ItemCriterion.Conditions.createItemUsedOnBlock(LocationPredicate.Builder.create().block(BlockPredicate.ANY), ItemPredicate.Builder.create().items(ModItems.FLOUR)))
////                .criterion("throw_flour", SummonedEntityCriterion.Conditions.create(EntityPredicate.Builder.create().type(ModEntities.THROWN_FLOUR_PROJECTILE)))
//                .build(consumer, BountifulFares.MOD_ID + ":throw_flour");
        AdvancementEntry obtain_sun_hat = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.SUN_HAT),
                        Text.translatable("advancement.bountifulfares.obtain_sun_hat"),
                        Text.translatable("advancement.bountifulfares.obtain_sun_hat.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("obtain_sun_hat", InventoryChangedCriterion.Conditions.items(BFItems.SUN_HAT))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_sun_hat");
        AdvancementEntry eat_all_candy = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.CANDY),
                        Text.translatable("advancement.bountifulfares.eat_all_candy"),
                        Text.translatable("advancement.bountifulfares.eat_all_candy.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("candy", ConsumeItemCriterion.Conditions.item(BFItems.CANDY))
                .criterion("piquant", ConsumeItemCriterion.Conditions.item(BFItems.PIQUANT_CANDY))
                .criterion("sour", ConsumeItemCriterion.Conditions.item(BFItems.SOUR_CANDY))
                .criterion("bitter", ConsumeItemCriterion.Conditions.item(BFItems.BITTER_CANDY))
                .criterion("strange", ConsumeItemCriterion.Conditions.item(BFItems.STRANGE_CANDY))
                .criterion("candied_apple", ConsumeItemCriterion.Conditions.item(BFItems.CANDIED_APPLE))
                .criterion("candied_orange", ConsumeItemCriterion.Conditions.item(BFItems.CANDIED_ORANGE))
                .criterion("candied_lemon", ConsumeItemCriterion.Conditions.item(BFItems.CANDIED_LEMON))
                .criterion("candied_plum", ConsumeItemCriterion.Conditions.item(BFItems.CANDIED_PLUM))
                .build(consumer, BountifulFares.MOD_ID + ":eat_all_candy");
//        AdvancementEntry gorge = Advancement.Builder.create()
//                .display(new AdvancementDisplay(new ItemStack(ModItems.SOUR_CANDY),
//                        Text.translatable("advancement.bountifulfares.gorge"),
//                        Text.translatable("advancement.bountifulfares.gorge.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
//                        true,
//                        true,
//                        false))
//                .parent(eat_all_candy)
//                .criterion("gorge", EffectsChangedCriterion.Conditions.create(EntityEffectPredicate.create().withEffect(ModEffects.GORGING)))
//                .build(consumer, BountifulFares.MOD_ID + ":gorge");
        AdvancementEntry obtain_tea_blends = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.TEA_LEAVES),
                        Text.translatable("advancement.bountifulfares.obtain_tea_blends"),
                        Text.translatable("advancement.bountifulfares.obtain_tea_blends.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.CHALLENGE,
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
        AdvancementEntry place_all_tea_candles = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.GREEN_TEA_CANDLE),
                        Text.translatable("advancement.bountifulfares.place_all_tea_candles"),
                        Text.translatable("advancement.bountifulfares.place_all_tea_candles.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.CHALLENGE,
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
        AdvancementEntry obtain_walnut = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.WALNUT),
                        Text.translatable("advancement.bountifulfares.obtain_walnut"),
                        Text.translatable("advancement.bountifulfares.obtain_walnut.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("obtain_walnut", InventoryChangedCriterion.Conditions.items(BFItems.WALNUT))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_walnut");
        AdvancementEntry obtain_spongekin_seeds = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFItems.SPONGEKIN_SEEDS),
                        Text.translatable("advancement.bountifulfares.obtain_spongekin_seeds"),
                        Text.translatable("advancement.bountifulfares.obtain_spongekin_seeds.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .criterion("obtain_spongekin_seeds", InventoryChangedCriterion.Conditions.items(BFItems.SPONGEKIN_SEEDS))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_spongekin_seeds");
        AdvancementEntry obtain_spongekin = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(BFBlocks.SPONGEKIN),
                        Text.translatable("advancement.bountifulfares.obtain_spongekin"),
                        Text.translatable("advancement.bountifulfares.obtain_spongekin.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(obtain_spongekin_seeds)
                .criterion("obtain_spongekin", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().items(BFItems.SPONGEKIN_SLICE, BFBlocks.SPONGEKIN).build()))
                .build(consumer, BountifulFares.MOD_ID + ":obtain_spongekin");
//        AdvancementEntry breedWolvesWithMulch = Advancement.Builder.create()
//                .display(new AdvancementDisplay(new ItemStack(ModBlocks.WALNUT_MULCH),
//                        Text.translatable("advancement.bountifulfares.breed_wolves_with_mulch"),
//                        Text.translatable("advancement.bountifulfares.breed_wolves_with_mulch.description"), Optional.of(Identifier.of("minecraft:textures/block/farmland_moist.png")), AdvancementFrame.CHALLENGE,
//                        true,
//                        true,
//                        false))
//                .parent(obtain_feldspar)
//                .criterion("breed_wolves_with_mulch", PlayerInteractedWithEntityCriterion.Conditions.create(ItemPredicate.Builder.create().items(ModBlocks.WALNUT_MULCH), LootContextPredicate.create()))
//                .build(consumer, BountifulFares.MOD_ID + ":breed_wolves_with_mulch");
    }
}

//EntityPredicate.Builder.create().type(EntityType.WOLF