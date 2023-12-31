package net.hecco.bountifulcuisine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

        Advancement obtainFeldspar = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.FELDSPAR),
                        Text.translatable("advancement.bountifulcuisine.obtain_feldspar"),
                        Text.translatable("advancement.bountifulcuisine.obtain_feldspar.description"), new Identifier("minecraft:textures/block/farmland_moist.png"), AdvancementFrame.TASK,
                        true,
                        true,
                        false))
                .parent(rootAdvancement)
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
    }
}
