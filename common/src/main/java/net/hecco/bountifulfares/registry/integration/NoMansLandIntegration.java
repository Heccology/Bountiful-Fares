package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.definition.block.custom.PicketsBlock;
import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.definition.item.custom.TrellisBlockItem;
import net.hecco.bountifulfares.definition.item.integration.MapleMeadBottleItem;
import net.hecco.bountifulfares.definition.recipe.FermentingRecipeBuilder;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFSoundTypes;
import net.hecco.bountifulfares.registry.integration.interfaces.HasWoodTypes;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.NO_MANS_LAND_MOD_ID;

public class NoMansLandIntegration implements BFIntegration, HasWoodTypes {
    private static final List<String> WOOD_TYPES = new ArrayList<>(List.of("pine", "maple", "walnut", "willow"));

    @Override
    public List<String> modIds() {
        return List.of(NO_MANS_LAND_MOD_ID);
    }

    public static Supplier<Item> CANDIED_PEAR;
    public static Supplier<Item> MAPLE_MEAD_BOTTLE;

    @Override
    @SuppressWarnings("unchecked")
    public void registerContent() {
        for (String wood : WOOD_TYPES) {
            String key = NO_MANS_LAND_MOD_ID + "_" + wood;
            BFBlocks.TRELLISES.put(key, (Supplier<Block>) registerContent(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, wood + "_trellis"), NLServices.REGISTRY.registerBlockNoItem(NO_MANS_LAND_MOD_ID, wood + "_trellis", () -> new TrellisBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0f).sound(BFSoundTypes.LIGHT_WOOD).mapColor(MapColor.NONE).instrument(NoteBlockInstrument.BASS).randomTicks().noOcclusion()))));
            registerContent(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, wood + "_trellis"), NLServices.REGISTRY.registerItem(NO_MANS_LAND_MOD_ID, wood + "_trellis", () -> new TrellisBlockItem(BFBlocks.TRELLISES.get(key).get(), new Item.Properties())));
            if (NLServices.PLATFORM.isDatagen()) {
                NLServices.REGISTRY.registerItem(NO_MANS_LAND_MOD_ID, wood + "_planks", () -> new Item(new Item.Properties()));
            }
            BFBlocks.PICKETS.put(key, (Supplier<Block>) registerContent(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, wood + "_pickets"), NLServices.REGISTRY.registerBlockNoItem(NO_MANS_LAND_MOD_ID, wood + "_pickets", () -> new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSoundTypes.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()))));
            registerContent(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, wood + "_pickets"), NLServices.REGISTRY.registerItem(NO_MANS_LAND_MOD_ID, wood + "_pickets", () -> new BlockItem(BFBlocks.PICKETS.get(key).get(), new Item.Properties())));
        }

        CANDIED_PEAR = (Supplier<Item>) registerContent(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, "candied_pear"), NLServices.REGISTRY.registerItem(NO_MANS_LAND_MOD_ID, "candied_pear", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.5F).build()))));
        MAPLE_MEAD_BOTTLE = (Supplier<Item>) registerContent(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, "maple_mead_bottle"), NLServices.REGISTRY.registerItem(NO_MANS_LAND_MOD_ID, "maple_mead_bottle", () -> new MapleMeadBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.4f).effect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1).effect(new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 0.3f).alwaysEdible().build()).stacksTo(16))));


        //DATAGEN DUMMY ITEMS
        if (NLServices.PLATFORM.isDatagen()) {
            NLServices.REGISTRY.registerItem(NO_MANS_LAND_MOD_ID,  "pear", () -> new Item(new Item.Properties()));
            NLServices.REGISTRY.registerItem(NO_MANS_LAND_MOD_ID,  "maple_syrup_bottle", () -> new Item(new Item.Properties()));
            NLServices.REGISTRY.registerItem(NO_MANS_LAND_MOD_ID,  "grilled_mushrooms", () -> new Item(new Item.Properties()));
        }
    }

    @Override
    public boolean shouldCreateDatapack() {
        return true;
    }

    @Override
    public @Nullable String getDatapackName() {
        return "No Man's Land x Bountiful Fares";
    }

    @Override
    public void recipeGeneration(RecipeOutput exporter) {
        for (String wood : WOOD_TYPES) {
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BFBlocks.TRELLISES.get(NO_MANS_LAND_MOD_ID + "_" + wood).get())
                    .pattern("# #")
                    .pattern(" P ")
                    .pattern("# #")
                    .define('#', Items.STICK)
                    .define('P', BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, wood + "_planks")))
                    .unlockedBy("has_stick", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(Items.STICK).build()))))
                    .unlockedBy("has_planks", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, wood + "_planks"))).build()))))
                    .group("trellis")
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BFBlocks.PICKETS.get(NO_MANS_LAND_MOD_ID + "_" + wood).get(), 4).define('#', BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, wood + "_planks"))).define('S', Items.STICK)
                    .pattern("#S#").unlockedBy("has_planks", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, wood + "_planks"))).build())))).save(exporter);
        }

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CANDIED_PEAR.get(), 1)
                .requires(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, "pear")))
                .requires(BFItemTags.SUGAR_INGREDIENTS)
                .unlockedBy("has_pear", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, "pear"))).build()))))
                .save(exporter);

        FermentingRecipeBuilder.create(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, "maple_syrup_bottle")), MAPLE_MEAD_BOTTLE.get(), 1, 13529674)
                .unlockedBy("has_maple_syrup", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, "maple_syrup_bottle"))).build()))))
                .save(exporter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.MUSHROOM_STUFFED_POTATO.get())
                .requires(Items.BAKED_POTATO)
                .requires(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, "grilled_mushrooms")))
                .requires(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, "grilled_mushrooms")))
                .unlockedBy("has_baked_potato", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(Items.BAKED_POTATO).build()))))
                .unlockedBy("has_grilled_mushrooms", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(NO_MANS_LAND_MOD_ID, "grilled_mushrooms"))).build()))))
                .save(exporter, "mushroom_stuffed_potato_from_grilled_mushrooms");
    }

    @Override
    public List<String> getWoodTypes() {
        return WOOD_TYPES;
    }
}
