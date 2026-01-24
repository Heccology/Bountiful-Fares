package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.integration.CabinetBlockEntity;
import net.hecco.bountifulfares.definition.block.integration.FDCabinetBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.FARMERS_DELIGHT_MOD_ID;

public class FarmersDelightIntegration implements BFIntegration {


    @Override
    public List<String> modIds() {
        return List.of(FARMERS_DELIGHT_MOD_ID);
    }

    public static Supplier<BlockEntityType<CabinetBlockEntity>> CABINET_BLOCK_ENTITY;

    public static Supplier<Block> WALNUT_CABINET;
    public static Supplier<Block> HOARY_CABINET;

    @Override
    public void registerContent() {
        WALNUT_CABINET = registerBlock("walnut_cabinet", () -> new FDCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).mapColor(MapColor.COLOR_BROWN)));
        HOARY_CABINET = registerBlock("hoary_cabinet", () -> new FDCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).mapColor(MapColor.TERRACOTTA_GRAY)));

        CABINET_BLOCK_ENTITY = NLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "cabinet_block_entity",
                () -> NLServices.REGISTRY.createBlockEntity(CabinetBlockEntity::new, WALNUT_CABINET, HOARY_CABINET)
        );
    }

    @SuppressWarnings("unchecked")
    private Supplier<Block> registerBlock(String id, Supplier<Block> supplier) {
        Supplier<Block> block = (Supplier<Block>) registerContent(ResourceLocation.fromNamespaceAndPath(FARMERS_DELIGHT_MOD_ID, id), NLServices.REGISTRY.registerBlockNoItem(FARMERS_DELIGHT_MOD_ID, id, supplier));
        registerContent(ResourceLocation.fromNamespaceAndPath(FARMERS_DELIGHT_MOD_ID, id), NLServices.REGISTRY.registerItem(FARMERS_DELIGHT_MOD_ID, id, () -> new BlockItem(block.get(), new Item.Properties())));
        return block;
    }

    @Override
    public boolean shouldCreateDatapack() {
        return true;
    }

    @Override
    public @Nullable String getDatapackName() {
        return "Farmer's Delight x Bountiful Fares";
    }

    @Override
    public void recipeGeneration(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, HOARY_CABINET.get())
                .define('_', BFBlocks.HOARY_SLAB.get())
                .define('D', BFBlocks.HOARY_TRAPDOOR.get())
                .pattern("___")
                .pattern("D D")
                .pattern("___")
                .unlockedBy("has_trapdoor", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BFBlocks.HOARY_TRAPDOOR.get()).build()))))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WALNUT_CABINET.get())
                .define('_', BFBlocks.WALNUT_SLAB.get())
                .define('D', BFBlocks.WALNUT_TRAPDOOR.get())
                .pattern("___")
                .pattern("D D")
                .pattern("___")
                .unlockedBy("has_trapdoor", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BFBlocks.WALNUT_TRAPDOOR.get()).build()))))
                .save(output);
    }
}
