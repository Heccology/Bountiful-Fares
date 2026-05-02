package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.custom.PicketsBlock;
import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.definition.item.custom.TrellisBlockItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFSoundTypes;
import net.hecco.bountifulfares.registry.integration.interfaces.HasWoodTypes;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class DungeonsDelightIntegration implements BFIntegration, HasWoodTypes {
    private static final List<String> WOOD_TYPES = List.of("wormwood");
    
    @Override
    public List<String> getWoodTypes() {
        return WOOD_TYPES;
    }

    @Override
    public List<String> modIds() {
        return List.of(BountifulFares.DUNGEONSDELIGHT_MOD_ID);
    }

    @SuppressWarnings("unchecked")
    private Supplier<Block> registerBlock(String id, Supplier<Block> supplier) {
        Supplier<Block> block = (Supplier<Block>) registerContent(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, id), NLServices.REGISTRY.registerBlockNoItem(BountifulFares.DUNGEONSDELIGHT_MOD_ID, id, supplier));
        registerContent(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, id), NLServices.REGISTRY.registerItem(BountifulFares.DUNGEONSDELIGHT_MOD_ID, id, () -> new BlockItem(block.get(), new Item.Properties().rarity(Rarity.UNCOMMON))));
        return block;
    }

    public static Supplier<Block> STAINED_SCRAP_RAILING;

    @Override @SuppressWarnings("unchecked")
    public void registerContent() {
        STAINED_SCRAP_RAILING = registerBlock("stained_scrap_railing", () -> new PicketsBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.NONE).strength(1.0F, 2.0F).sound(SoundType.METAL).forceSolidOff().noOcclusion()));

        for (String wood : WOOD_TYPES) {
            String key = BountifulFares.DUNGEONSDELIGHT_MOD_ID + "_" + wood;

            BFBlocks.TRELLISES.put(key, (Supplier<Block>) registerContent(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_trellis"),
                    NLServices.REGISTRY.registerBlockNoItem(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_trellis",
                            () -> new TrellisBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5F)
                                    .sound(BFSoundTypes.LIGHT_WOOD).mapColor(MapColor.NONE).instrument(NoteBlockInstrument.BASS).randomTicks().noOcclusion()))));
            registerContent(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_trellis"),

                    NLServices.REGISTRY.registerItem(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_trellis",
                            () -> new TrellisBlockItem(BFBlocks.TRELLISES.get(key).get(), new Item.Properties())));
            
            if (NLServices.PLATFORM.isDatagen()) {
                NLServices.REGISTRY.registerItem(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_planks", () -> new Item(new Item.Properties()));
            }

            BFBlocks.PICKETS.put(key, (Supplier<Block>) registerContent(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_pickets"),
                    NLServices.REGISTRY.registerBlockNoItem(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_pickets",
                            () -> new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.25F).sound(BFSoundTypes.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()))));
            registerContent(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_pickets"),

                    NLServices.REGISTRY.registerItem(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_pickets",
                            () -> new BlockItem(BFBlocks.PICKETS.get(key).get(), new Item.Properties())));

            //DATAGEN DUMMY ITEMS
            if (NLServices.PLATFORM.isDatagen()) {
                NLServices.REGISTRY.registerItem(BountifulFares.DUNGEONSDELIGHT_MOD_ID, "stained_scrap", () -> new Item(new Item.Properties()));
                NLServices.REGISTRY.registerItem(BountifulFares.DUNGEONSDELIGHT_MOD_ID, "stained_scrap_fragment", () -> new Item(new Item.Properties()));
            }
        }
    }

    @Override
    public boolean shouldCreateDatapack() {
        return true;
    }

    @Override
    public String getDatapackName() {
        return "Dungeon's Delight x Bountiful Fares";
    }

    @Override
    public void recipeGeneration(RecipeOutput exporter) {
        for (String wood : WOOD_TYPES) {
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BFBlocks.TRELLISES.get(BountifulFares.DUNGEONSDELIGHT_MOD_ID + "_" + wood).get())
                    .pattern("# #")
                    .pattern(" P ")
                    .pattern("# #")
                    .define('#', Items.STICK)
                    .define('P', BuiltInRegistries.ITEM.get(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_planks")))
                    .unlockedBy("has_stick", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(Items.STICK).build()))))
                    .unlockedBy("has_planks", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM.get(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_planks"))).build()))))
                    .group("trellis")
                    .save(exporter);
            
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BFBlocks.PICKETS.get(BountifulFares.DUNGEONSDELIGHT_MOD_ID + "_" + wood).get(), 4).define('#', BuiltInRegistries.ITEM.get(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_planks"))).define('S', Items.STICK)
                    .pattern("#S#").unlockedBy("has_planks", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item().of(BuiltInRegistries.ITEM.get(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, wood + "_planks"))).build())))).save(exporter);

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, STAINED_SCRAP_RAILING.get(), 8)
                    .define('#', BuiltInRegistries.ITEM.get(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, "stained_scrap")))
                    .define('S', BuiltInRegistries.ITEM.get(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, "stained_scrap_fragment")))
                    .pattern("#S#")
                    .unlockedBy("has_stained_scrap", CriteriaTriggers.INVENTORY_CHANGED.createCriterion(new InventoryChangeTrigger.TriggerInstance(Optional.empty(), InventoryChangeTrigger.TriggerInstance.Slots.ANY, List.of(ItemPredicate.Builder.item()
                            .of(BuiltInRegistries.ITEM.get(BountifulFares.id(BountifulFares.DUNGEONSDELIGHT_MOD_ID, "stained_scrap"))).build())))).save(exporter);
        }
    }
}
