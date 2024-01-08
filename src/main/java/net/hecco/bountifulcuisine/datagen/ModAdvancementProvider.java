package net.hecco.bountifulcuisine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionConsumingBuilder;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.predicate.entity.PlayerPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModBlocks.PASSION_FRUIT),
                        Text.translatable("advancement.bountifulcuisine.bountiful_cuisine"),
                        Text.translatable("advancement.bountifulcuisine.bountiful_cuisine.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        false,
                        false,
                        false)).criterion("consume_item", ConsumeItemCriterion.Conditions.any())
                .build(consumer, BountifulCuisine.MOD_ID + ":bountiful_cuisine");
        Advancement obtainGristmill = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModBlocks.GRISTMILL),
                        Text.translatable("advancement.bountifulcuisine.obtain_gristmill"),
                        Text.translatable("advancement.bountifulcuisine.obtain_gristmill.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(rootAdvancement)
                .criterion("obtain_gristmill", InventoryChangedCriterion.Conditions.items(ModBlocks.GRISTMILL))
                .build(consumer, BountifulCuisine.MOD_ID + ":obtain_gristmill");

        Advancement obtainFeldspar = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.FELDSPAR),
                        Text.translatable("advancement.bountifulcuisine.obtain_feldspar"),
                        Text.translatable("advancement.bountifulcuisine.obtain_feldspar.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(obtainGristmill)
                .criterion("obtain_feldspar", InventoryChangedCriterion.Conditions.items(ModItems.FELDSPAR))
                .build(consumer, BountifulCuisine.MOD_ID + ":obtain_feldspar");

        Advancement obtainCeramicTiles = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModBlocks.CERAMIC_TILES),
                        Text.translatable("advancement.bountifulcuisine.obtain_ceramic_tiles"),
                        Text.translatable("advancement.bountifulcuisine.obtain_ceramic_tiles.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(obtainFeldspar)
                .criterion("obtain_ceramic_tiles", InventoryChangedCriterion.Conditions.items(ModBlocks.CERAMIC_TILES))
                .build(consumer, BountifulCuisine.MOD_ID + ":obtain_ceramic_tiles");
        Advancement obtainFermentationVessel = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModBlocks.FERMENTATION_VESSEL),
                        Text.translatable("advancement.bountifulcuisine.obtain_fermentation_vessel"),
                        Text.translatable("advancement.bountifulcuisine.obtain_fermentation_vessel.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(obtainFeldspar)
                .criterion("obtain_fermentation_vessel", InventoryChangedCriterion.Conditions.items(ModBlocks.FERMENTATION_VESSEL))
                .build(consumer, BountifulCuisine.MOD_ID + ":obtain_fermentation_vessel");
        Advancement eatAncientFruit = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.HOARY_APPLE),
                        Text.translatable("advancement.bountifulcuisine.eat_ancient_fruit"),
                        Text.translatable("advancement.bountifulcuisine.eat_ancient_fruit.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(rootAdvancement)
                .criterion("eat_ancient_fruit", ConsumeItemCriterion.Conditions.predicate(ItemPredicate.Builder.create().items(ModItems.HOARY_APPLE, ModBlocks.LAPISBERRIES).build()))
                .build(consumer, BountifulCuisine.MOD_ID + ":eat_ancient_fruit");
//        Advancement throwFlour = Advancement.Builder.create()
//                .display(new AdvancementDisplay(new ItemStack(ModItems.FLOUR),
//                        Text.translatable("advancement.bountifulcuisine.throw_flour"),
//                        Text.translatable("advancement.bountifulcuisine.throw_flour.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
//                        true,
//                        true,
//                        false))
//                .parent(obtainFeldspar)
//                .criterion("throw_flour", UsingItemCriterion.Conditions.create(PlayerPredicate.Builder.create().stat(), ItemPredicate.Builder.create().items(ModItems.FLOUR)))
//                .build(consumer, BountifulCuisine.MOD_ID + ":throw_flour");
//        Advancement breedWolvesWithMulch = Advancement.Builder.create()
//                .display(new AdvancementDisplay(new ItemStack(ModBlocks.WALNUT_MULCH),
//                        Text.translatable("advancement.bountifulcuisine.breed_wolves_with_mulch"),
//                        Text.translatable("advancement.bountifulcuisine.breed_wolves_with_mulch.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.CHALLENGE,
//                        true,
//                        true,
//                        false))
//                .parent(obtainFeldspar)
//                .criterion("breed_wolves_with_mulch", PlayerInteractedWithEntityCriterion.Conditions.create(ItemPredicate.Builder.create().items(ModBlocks.WALNUT_MULCH), LootContextPredicate.create()))
//                .build(consumer, BountifulCuisine.MOD_ID + ":breed_wolves_with_mulch");
    }
}
//EntityPredicate.Builder.create().type(EntityType.WOLF