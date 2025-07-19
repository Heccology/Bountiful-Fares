package net.hecco.bountifulfares.datagen.bountifulfares;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BFAdvancementProvider extends FabricAdvancementProvider {


    public BFAdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        AdvancementHolder root_advancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.PASSION_FRUIT.get()),
                        Component.translatable("advancement.bountifulfares.bountiful_fares"),
                        Component.translatable("advancement.bountifulfares.bountiful_fares.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        false,
                        false,
                        false))
                .addCriterion("consume_item", ConsumeItemTrigger.TriggerInstance.usedItem())
                .save(consumer, BountifulFares.MOD_ID + ":bountiful_fares");
        AdvancementHolder make_first_food = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.BOUNTIFUL_STEW.get()),
                        Component.translatable("advancement.bountifulfares.make_first_food"),
                        Component.translatable("advancement.bountifulfares.make_first_food.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .addCriterion("make_first_food", ConsumeItemTrigger.TriggerInstance.usedItem(ItemPredicate.Builder.item().of(BFItemTags.MEALS)))
                .save(consumer, BountifulFares.MOD_ID + ":make_first_food");

        Advancement.Builder eat_all_food = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.CRUSTED_BEEF.get()),
                        Component.translatable("advancement.bountifulfares.eat_all_food"),
                        Component.translatable("advancement.bountifulfares.eat_all_food.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.GOAL,
                        true,
                        true,
                        false))
                .parent(make_first_food);
        for (Item i : BuiltInRegistries.ITEM) {
            if (BuiltInRegistries.ITEM.getKey(i).getNamespace() == BountifulFares.MOD_ID && i.components().has(DataComponents.FOOD) && i != BFItems.DIRT_STEW.get()) {
                eat_all_food.addCriterion(BuiltInRegistries.ITEM.getKey(i).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(ItemPredicate.Builder.item().of(i)));
            }
        }
        eat_all_food.save(consumer, BountifulFares.MOD_ID + ":eat_all_food");

        AdvancementHolder obtain_lemon_block = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.LEMON.get()),
                        Component.translatable("advancement.bountifulfares.how_easy"),
                        Component.translatable("advancement.bountifulfares.how_easy.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.CHALLENGE,
                        true,
                        true,
                        true))
                .parent(root_advancement)
                .addCriterion("obtain_lemon_block", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.LEMON_BLOCK.get()))
                .save(consumer, BountifulFares.MOD_ID + ":obtain_lemon_block");
        AdvancementHolder place_gristmill = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFBlocks.GRISTMILL.get()),
                        Component.translatable("advancement.bountifulfares.place_gristmill"),
                        Component.translatable("advancement.bountifulfares.place_gristmill.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .addCriterion("place_gristmill", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.GRISTMILL.get()))
                .save(consumer, BountifulFares.MOD_ID + ":place_gristmill");

        AdvancementHolder obtain_feldspar = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.FELDSPAR.get()),
                        Component.translatable("advancement.bountifulfares.obtain_feldspar"),
                        Component.translatable("advancement.bountifulfares.obtain_feldspar.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false))
                .parent(place_gristmill)
                .addCriterion("obtain_feldspar", InventoryChangeTrigger.TriggerInstance.hasItems(BFItems.FELDSPAR.get()))
                .save(consumer, BountifulFares.MOD_ID + ":obtain_feldspar");

        AdvancementHolder obtain_ceramic_tiles = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFBlocks.CERAMIC_TILES.get()),
                        Component.translatable("advancement.bountifulfares.obtain_ceramic_tiles"),
                        Component.translatable("advancement.bountifulfares.obtain_ceramic_tiles.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false))
                .parent(obtain_feldspar)
                .addCriterion("obtain_ceramic_tiles", ConsumeItemTrigger.TriggerInstance.usedItem(ItemPredicate.Builder.item().of(BFItemTags.DYEABLE_CERAMIC_BLOCKS)))
                .save(consumer, BountifulFares.MOD_ID + ":obtain_ceramic_tiles");
        AdvancementHolder obtain_fermentation_vessel = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFBlocks.FERMENTATION_VESSEL.get()),
                        Component.translatable("advancement.bountifulfares.obtain_fermentation_vessel"),
                        Component.translatable("advancement.bountifulfares.obtain_fermentation_vessel.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false))
                .parent(obtain_feldspar)
                .addCriterion("obtain_fermentation_vessel", InventoryChangeTrigger.TriggerInstance.hasItems(BFBlocks.FERMENTATION_VESSEL.get()))
                .save(consumer, BountifulFares.MOD_ID + ":obtain_fermentation_vessel");
        AdvancementHolder eat_ancient_fruit = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.HOARY_APPLE.get()),
                        Component.translatable("advancement.bountifulfares.eat_ancient_fruit"),
                        Component.translatable("advancement.bountifulfares.eat_ancient_fruit.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .addCriterion("eat_ancient_fruit", ConsumeItemTrigger.TriggerInstance.usedItem(ItemPredicate.Builder.item().of(BFItems.HOARY_APPLE.get(), BFItems.LAPISBERRIES.get())))
                .save(consumer, BountifulFares.MOD_ID + ":eat_ancient_fruit");
        AdvancementHolder place_all_baked_goods = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFBlocks.ARTISAN_BREAD.get()),
                        Component.translatable("advancement.bountifulfares.place_all_baked_goods"),
                        Component.translatable("advancement.bountifulfares.place_all_baked_goods.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.CHALLENGE,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .addCriterion("cake", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(Blocks.CAKE))
                .addCriterion("cocoa_cake", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.COCOA_CAKE.get()))
                .addCriterion("artisan_bread", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.ARTISAN_BREAD.get()))
                .addCriterion("artisan_cookie", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.ARTISAN_COOKIE.get()))
                .addCriterion("apple_pie", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.APPLE_PIE.get()))
                .addCriterion("orange_pie", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.ORANGE_PIE.get()))
                .addCriterion("lemon_pie", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.LEMON_PIE.get()))
                .addCriterion("plum_pie", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.PLUM_PIE.get()))
                .addCriterion("hoary_pie", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.HOARY_PIE.get()))
                .addCriterion("passion_fruit_tart", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.PASSION_FRUIT_TART.get()))
                .addCriterion("elderberry_tart", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.ELDERBERRY_TART.get()))
                .addCriterion("glow_berry_tart", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.GLOW_BERRY_TART.get()))
                .addCriterion("sweet_berry_tart", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.SWEET_BERRY_TART.get()))
                .addCriterion("lapisberry_tart", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.LAPISBERRY_TART.get()))
                .save(consumer, BountifulFares.MOD_ID + ":place_all_baked_goods");
        AdvancementHolder eat_citrus_essence = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.CITRUS_ESSENCE.get()),
                        Component.translatable("advancement.bountifulfares.eat_citrus_essence"),
                        Component.translatable("advancement.bountifulfares.eat_citrus_essence.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false
                ))
                .parent(obtain_fermentation_vessel)
                .addCriterion("eat_citrus_essence", ConsumeItemTrigger.TriggerInstance.usedItem(BFItems.CITRUS_ESSENCE.get()))
                .save(consumer, BountifulFares.MOD_ID + ":eat_citrus_essence");
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
        AdvancementHolder obtain_sun_hat = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.SUN_HAT.get()),
                        Component.translatable("advancement.bountifulfares.obtain_sun_hat"),
                        Component.translatable("advancement.bountifulfares.obtain_sun_hat.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .addCriterion("obtain_sun_hat", InventoryChangeTrigger.TriggerInstance.hasItems(BFItems.SUN_HAT.get()))
                .save(consumer, BountifulFares.MOD_ID + ":obtain_sun_hat");
        AdvancementHolder eat_all_candy = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.CANDY.get()),
                        Component.translatable("advancement.bountifulfares.eat_all_candy"),
                        Component.translatable("advancement.bountifulfares.eat_all_candy.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .addCriterion("candy", ConsumeItemTrigger.TriggerInstance.usedItem(BFItems.CANDY.get()))
                .addCriterion("piquant", ConsumeItemTrigger.TriggerInstance.usedItem(BFItems.PIQUANT_CANDY.get()))
                .addCriterion("sour", ConsumeItemTrigger.TriggerInstance.usedItem(BFItems.SOUR_CANDY.get()))
                .addCriterion("bitter", ConsumeItemTrigger.TriggerInstance.usedItem(BFItems.BITTER_CANDY.get()))
                .addCriterion("strange", ConsumeItemTrigger.TriggerInstance.usedItem(BFItems.STRANGE_CANDY.get()))
                .addCriterion("candied_apple", ConsumeItemTrigger.TriggerInstance.usedItem(BFItems.CANDIED_APPLE.get()))
                .addCriterion("candied_orange", ConsumeItemTrigger.TriggerInstance.usedItem(BFItems.CANDIED_ORANGE.get()))
                .addCriterion("candied_lemon", ConsumeItemTrigger.TriggerInstance.usedItem(BFItems.CANDIED_LEMON.get()))
                .addCriterion("candied_plum", ConsumeItemTrigger.TriggerInstance.usedItem(BFItems.CANDIED_PLUM.get()))
                .save(consumer, BountifulFares.MOD_ID + ":eat_all_candy");
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
        AdvancementHolder obtain_tea_blends = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.TEA_LEAVES.get()),
                        Component.translatable("advancement.bountifulfares.obtain_tea_blends"),
                        Component.translatable("advancement.bountifulfares.obtain_tea_blends.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.CHALLENGE,
                        true,
                        true,
                        false))
                .parent(place_gristmill)
                .addCriterion("green", InventoryChangeTrigger.TriggerInstance.hasItems(BFItems.GREEN_TEA_BLEND.get()))
                .addCriterion("black", InventoryChangeTrigger.TriggerInstance.hasItems(BFItems.BLACK_TEA_BLEND.get()))
                .addCriterion("chamomile", InventoryChangeTrigger.TriggerInstance.hasItems(BFItems.CHAMOMILE_TEA_BLEND.get()))
                .addCriterion("honeysuckle", InventoryChangeTrigger.TriggerInstance.hasItems(BFItems.HONEYSUCKLE_TEA_BLEND.get()))
                .addCriterion("bellflower", InventoryChangeTrigger.TriggerInstance.hasItems(BFItems.BELLFLOWER_TEA_BLEND.get()))
                .addCriterion("torchflower", InventoryChangeTrigger.TriggerInstance.hasItems(BFItems.TORCHFLOWER_TEA_BLEND.get()))
                .save(consumer, BountifulFares.MOD_ID + ":obtain_tea_blends");
        AdvancementHolder place_all_tea_candles = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFBlocks.GREEN_TEA_CANDLE.get()),
                        Component.translatable("advancement.bountifulfares.place_all_tea_candles"),
                        Component.translatable("advancement.bountifulfares.place_all_tea_candles.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.CHALLENGE,
                        true,
                        true,
                        false))
                .parent(obtain_tea_blends)
                .addCriterion("green", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.GREEN_TEA_CANDLE.get()))
                .addCriterion("black", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.BLACK_TEA_CANDLE.get()))
                .addCriterion("chamomile", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.CHAMOMILE_CANDLE.get()))
                .addCriterion("honeysuckle", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.HONEYSUCKLE_CANDLE.get()))
                .addCriterion("bellflower", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.BELLFLOWER_CANDLE.get()))
                .addCriterion("torchflower", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.TORCHFLOWER_CANDLE.get()))
                .addCriterion("walnut", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(BFBlocks.WALNUT_CANDLE.get()))
                .save(consumer, BountifulFares.MOD_ID + ":place_all_tea_candles");
        AdvancementHolder obtain_walnut = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.WALNUT.get()),
                        Component.translatable("advancement.bountifulfares.obtain_walnut"),
                        Component.translatable("advancement.bountifulfares.obtain_walnut.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .addCriterion("obtain_walnut", InventoryChangeTrigger.TriggerInstance.hasItems(BFItems.WALNUT.get()))
                .save(consumer, BountifulFares.MOD_ID + ":obtain_walnut");
        AdvancementHolder obtain_spongekin_seeds = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFItems.SPONGEKIN_SEEDS.get()),
                        Component.translatable("advancement.bountifulfares.obtain_spongekin_seeds"),
                        Component.translatable("advancement.bountifulfares.obtain_spongekin_seeds.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false))
                .parent(root_advancement)
                .addCriterion("obtain_spongekin_seeds", InventoryChangeTrigger.TriggerInstance.hasItems(BFItems.SPONGEKIN_SEEDS.get()))
                .save(consumer, BountifulFares.MOD_ID + ":obtain_spongekin_seeds");
        AdvancementHolder obtain_spongekin = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(BFBlocks.SPONGEKIN.get()),
                        Component.translatable("advancement.bountifulfares.obtain_spongekin"),
                        Component.translatable("advancement.bountifulfares.obtain_spongekin.description"), Optional.of(ResourceLocation.parse("minecraft:textures/block/farmland_moist.png")), AdvancementType.TASK,
                        true,
                        true,
                        false))
                .parent(obtain_spongekin_seeds)
                .addCriterion("obtain_spongekin", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(BFItems.SPONGEKIN_SLICE.get(), BFBlocks.SPONGEKIN.get()).build()))
                .save(consumer, BountifulFares.MOD_ID + ":obtain_spongekin");
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