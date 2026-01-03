package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.definition.block.custom.JackOStrawBlock;
import net.hecco.bountifulfares.registry.content.BFItems;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.DELICATE_DYES_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFBlocks.createLightLevelFromLitBlockState;

public class DelicateDyesIntegration implements BFIntegration {
    private static final ArrayList<String> DYES = new ArrayList<>(List.of("coral", "umber", "canary", "wasabi", "sacramento", "sky", "blurple", "lavender", "sangria", "rose"));

    @Override
    public List<String> modIds() {
        return List.of(DELICATE_DYES_MOD_ID);
    }

    public static final Map<String, Supplier<Block>> JACK_O_STRAWS = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public void registerContent() {
        for (String color : DYES) {
            if (NLServices.PLATFORM.isDatagen()) {
                NLServices.REGISTRY.registerItem(DELICATE_DYES_MOD_ID, color + "_wool", () -> new Item(new Item.Properties()));
            }
            JACK_O_STRAWS.put(color, (Supplier<Block>)registerContent(NLServices.REGISTRY.registerBlockNoItem(DELICATE_DYES_MOD_ID, color + "_jack_o_straw", () -> new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)))));
            registerContent(NLServices.REGISTRY.registerItem(DELICATE_DYES_MOD_ID, color + "_jack_o_straw", () -> new BlockItem(JACK_O_STRAWS.get(color).get(), new Item.Properties())));
        }
    }

    @Override
    public boolean shouldCreateDatapack() {
        return true;
    }

    @Override
    public @Nullable String getDatapackName() {
        return "Delicate Dyes x Bountiful Fares";
    }

    @Override
    public void recipeGeneration(RecipeOutput exporter) {
        for (String color : DYES) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, JACK_O_STRAWS.get(color).get())
                    .requires(BFItems.SUN_HAT.get())
                    .requires(Items.CARVED_PUMPKIN)
                    .requires(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, color + "_wool")))
                    .requires(Items.STICK)
                    .unlockedBy("has_"+color+"_wool", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, color + "_wool"))).build()))))
                    .unlockedBy("has_carved_pumpkin", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(Items.CARVED_PUMPKIN).build()))))
                    .unlockedBy("has_sun_hat", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BFItems.SUN_HAT.get()).build()))))
                    .save(exporter, color + "_jack_o_straw_with_carved_pumpkin");
            ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, JACK_O_STRAWS.get(color).get())
                    .requires(BFItems.SUN_HAT.get())
                    .requires(Items.PUMPKIN)
                    .requires(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, color + "_wool")))
                    .requires(Items.STICK)
                    .unlockedBy("has_"+color+"_wool", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, color + "_wool"))).build()))))
                    .unlockedBy("has_pumpkin", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(Items.PUMPKIN).build()))))
                    .unlockedBy("has_sun_hat", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BFItems.SUN_HAT.get()).build()))))
                    .save(exporter);
        }
    }
}
