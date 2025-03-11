package net.hecco.bountifulfares.compat.dye_depot;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatJackOStrawBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hecco.bountifulfares.BountifulFares.DYE_DEPOT_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFBlocks.createLightLevelFromLitBlockState;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class DyeDepotBlocks {

    public static final Block MAROON_JACK_O_STRAW = registerBlock("maroon_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ROSE_JACK_O_STRAW = registerBlock("rose_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CORAL_JACK_O_STRAW = registerBlock("coral_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GINGER_JACK_O_STRAW = registerBlock("ginger_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TAN_JACK_O_STRAW = registerBlock("tan_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BEIGE_JACK_O_STRAW = registerBlock("beige_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block AMBER_JACK_O_STRAW = registerBlock("amber_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block OLIVE_JACK_O_STRAW = registerBlock("olive_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FOREST_JACK_O_STRAW = registerBlock("forest_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block VERDANT_JACK_O_STRAW = registerBlock("verdant_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TEAL_JACK_O_STRAW = registerBlock("teal_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MINT_JACK_O_STRAW = registerBlock("mint_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block AQUA_JACK_O_STRAW = registerBlock("aqua_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SLATE_JACK_O_STRAW = registerBlock("slate_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block NAVY_JACK_O_STRAW = registerBlock("navy_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block INDIGO_JACK_O_STRAW = registerBlock("indigo_jack_o_straw", new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(Registries.BLOCK, Identifier.of(DYE_DEPOT_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(DYE_DEPOT_MOD_ID, name), new CompatBlockItem(DYE_DEPOT_MOD_ID, block, new Item.Settings()));
    }
    public static void registerDyeDepotBlocks() {

    }
}
