package net.hecco.bountifulfares.compat.dye_depot;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatJackOStrawBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import static net.hecco.bountifulfares.BountifulFares.DYE_DEPOT_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFBlocks.createLightLevelFromLitBlockState;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class DyeDepotBlocks {

    public static final Block MAROON_JACK_O_STRAW = registerBlock("maroon_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block ROSE_JACK_O_STRAW = registerBlock("rose_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block CORAL_JACK_O_STRAW = registerBlock("coral_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block GINGER_JACK_O_STRAW = registerBlock("ginger_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block TAN_JACK_O_STRAW = registerBlock("tan_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block BEIGE_JACK_O_STRAW = registerBlock("beige_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block AMBER_JACK_O_STRAW = registerBlock("amber_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block OLIVE_JACK_O_STRAW = registerBlock("olive_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block FOREST_JACK_O_STRAW = registerBlock("forest_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block VERDANT_JACK_O_STRAW = registerBlock("verdant_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block TEAL_JACK_O_STRAW = registerBlock("teal_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block MINT_JACK_O_STRAW = registerBlock("mint_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block AQUA_JACK_O_STRAW = registerBlock("aqua_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block SLATE_JACK_O_STRAW = registerBlock("slate_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block NAVY_JACK_O_STRAW = registerBlock("navy_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block INDIGO_JACK_O_STRAW = registerBlock("indigo_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, name), new CompatBlockItem(DYE_DEPOT_MOD_ID, block, new Item.Properties()));
    }
    public static void registerDyeDepotBlocks() {

    }
}
