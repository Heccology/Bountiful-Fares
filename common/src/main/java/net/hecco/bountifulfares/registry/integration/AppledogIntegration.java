package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.definition.block.integration.AppledogBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.*;

public class AppledogIntegration implements BFIntegration {

    @Override
    public List<String> modIds() {
        return List.of(AEU_MOD_ID, APPLEDOG_MOD_ID);
    }

    public static Supplier<Block> APPLEDOG_BLOCK;

    @Override
    public void registerContent() {
        APPLEDOG_BLOCK = registerBlock("appledog_block", () -> new AppledogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_BLOCK.get()).strength(1f, 1000f)));

        //DATAGEN DUMMY ITEMS
        if (NLServices.PLATFORM.isDatagen()) {
            NLServices.REGISTRY.registerItem(AEU_MOD_ID,  "dogapple", () -> new Item(new Item.Properties()));
        }
    }

    @SuppressWarnings("unchecked")
    private Supplier<net.minecraft.world.level.block.Block> registerBlock(String id, Supplier<Block> supplier) {
        Supplier<Block> block = (Supplier<Block>) registerContent(NLServices.REGISTRY.registerBlockNoItem(AEU_MOD_ID, id, supplier));
        registerContent(NLServices.REGISTRY.registerItem(AEU_MOD_ID, id, () -> new BlockItem(block.get(), new Item.Properties().rarity(Rarity.EPIC))));
        return block;
    }

    @Override
    public boolean shouldCreateDatapack() {
        return true;
    }

    @Override
    public String getDatapackName() {
        return "Bountiful Appledogs";
    }

    @Override
    public void recipeGeneration(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, APPLEDOG_BLOCK.get()).requires(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(AEU_MOD_ID, "dogapple")), 9).unlockedBy("has_dogapple",
                CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(AEU_MOD_ID, "dogapple"))).build())))
        ).save(output);
    }
}
