package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.definition.item.custom.TrellisBlockItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFSoundTypes;
import net.hecco.heccolib.lib.compat.CompatManager;
import net.hecco.heccolib.lib.compat.ModIntegration;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.NATURES_SPIRIT_MOD_ID;

public class NaturesSpiritIntegration implements ModIntegration {
    public static final List<String> WOOD_TYPES = List.of("aspen", "cedar", "coconut", "cypress", "fir", "ghaf", "joshua", "larch", "mahogany", "maple", "olive", "palo_verde", "sugi", "willow", "wisteria");

    @Override
    public CompatManager getCompatManager() {
        return BountifulFares.COMPAT_MANAGER;
    }

    @Override
    public List<String> modIds() {
        return List.of(NATURES_SPIRIT_MOD_ID);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void registerContent() {
        for (String wood : WOOD_TYPES) {
            BFBlocks.TRELLISES.put(wood, (Supplier<Block>) registerContent(HLServices.REGISTRY.registerBlockNoItem(NATURES_SPIRIT_MOD_ID, wood + "_trellis", () -> new TrellisBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0f).sound(BFSoundTypes.LIGHT_WOOD).mapColor(MapColor.NONE).instrument(NoteBlockInstrument.BASS).randomTicks().noOcclusion()))));
            registerContent(HLServices.REGISTRY.registerItem(NATURES_SPIRIT_MOD_ID, wood + "_trellis", () -> new TrellisBlockItem(BFBlocks.TRELLISES.get(wood).get(), new Item.Properties())));
            if (HLServices.PLATFORM.isDatagen()) {
                HLServices.REGISTRY.registerItem(NATURES_SPIRIT_MOD_ID, wood + "_planks", () -> new Item(new Item.Properties()));
            }
        }
    }

    @Override
    public boolean shouldCreateDatapack() {
        return true;
    }

    @Override
    public @Nullable String getDatapackName() {
        return "Nature's Spirit x Bountiful Fares";
    }

    @Override
    public void recipeGeneration(RecipeOutput exporter) {
        for (String wood : WOOD_TYPES) {
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BFBlocks.TRELLISES.get(wood).get())
                    .pattern("# #")
                    .pattern(" P ")
                    .pattern("# #")
                    .define('#', Items.STICK)
                    .define('P', BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NATURES_SPIRIT_MOD_ID, wood + "_planks")))
                    .unlockedBy("has_stick", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(Items.STICK).build()))))
                    .unlockedBy("has_planks", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NATURES_SPIRIT_MOD_ID, wood + "_planks"))).build()))))
                    .group("trellis")
                    .save(exporter);
        }
    }
}
