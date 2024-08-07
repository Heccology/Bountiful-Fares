package net.hecco.bountifulfares.compat.mint;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatJackOStrawBlock;
import net.hecco.bountifulfares.compat.block.CompatPicketsBlock;
import net.hecco.bountifulfares.sounds.BFSounds;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Set;

import static net.hecco.bountifulfares.BountifulFares.ELS_AND_LS_DYES_MOD_ID;
import static net.hecco.bountifulfares.block.BFBlocks.createLightLevelFromLitBlockState;
import static net.hecco.bountifulfares.compat.BFCompat.compatBlocks;
import static net.hecco.bountifulfares.trellis.BFTrellises.TRELLIS_RENDER_CUTOUT;

public class MintBlocks {
    public static Block ACORN_JACK_O_STRAW = registerBlock("acorn_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block AMBER_JACK_O_STRAW = registerBlock("amber_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block ARTICHOKE_JACK_O_STRAW = registerBlock("artichoke_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block BANANA_JACK_O_STRAW = registerBlock("banana_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block CERULEAN_JACK_O_STRAW = registerBlock("cerulean_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block FUCHSIA_JACK_O_STRAW = registerBlock("fuchsia_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block GRAPE_JACK_O_STRAW = registerBlock("grape_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block INDIGO_JACK_O_STRAW = registerBlock("indigo_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block MAROON_JACK_O_STRAW = registerBlock("maroon_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block MAUVE_JACK_O_STRAW = registerBlock("mauve_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block MINT_JACK_O_STRAW = registerBlock("mint_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block MOLD_JACK_O_STRAW = registerBlock("mold_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block NAVY_JACK_O_STRAW = registerBlock("navy_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block PEACH_JACK_O_STRAW = registerBlock("peach_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block PERIWINKLE_JACK_O_STRAW = registerBlock("periwinkle_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block SAGE_JACK_O_STRAW = registerBlock("sage_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block SAP_JACK_O_STRAW = registerBlock("sap_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block SHAMROCK_JACK_O_STRAW = registerBlock("shamrock_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block VELVET_JACK_O_STRAW = registerBlock("velvet_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static Block VERMILION_JACK_O_STRAW = registerBlock("vermilion_jack_o_straw", new CompatJackOStrawBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));

    public static Block WINTERGREEN_PICKETS = registerBlock("wintergreen_pickets", new CompatPicketsBlock(ELS_AND_LS_DYES_MOD_ID, FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));

    public static final TrellisVariant WINTERGREEN = new TrellisVariant(BountifulFares.ELS_AND_LS_DYES_MOD_ID, "wintergreen", null, TRELLIS_RENDER_CUTOUT);


    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(Registries.BLOCK, new Identifier(ELS_AND_LS_DYES_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(ELS_AND_LS_DYES_MOD_ID, name), new CompatBlockItem(ELS_AND_LS_DYES_MOD_ID, block, new FabricItemSettings()));
    }
    public static void registerMintBlocks() {

    }
}
