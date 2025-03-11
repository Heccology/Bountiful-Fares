package net.hecco.bountifulfares.compat.natures_spirit;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.PicketsBlock;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatPicketsBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hecco.bountifulfares.BountifulFares.NATURES_SPIRIT_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFTrellises.TRELLIS_RENDER_CUTOUT;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class NaturesSpiritBlocks {
    public static final Block ASPEN_PICKETS = registerBlock("aspen_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block CEDAR_PICKETS = registerBlock("cedar_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block COCONUT_PICKETS = registerBlock("coconut_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block CYPRESS_PICKETS = registerBlock("cypress_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block FIR_PICKETS = registerBlock("fir_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block GHAF_PICKETS = registerBlock("ghaf_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block JOSHUA_PICKETS = registerBlock("joshua_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block LARCH_PICKETS = registerBlock("larch_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block MAHOGANY_PICKETS = registerBlock("mahogany_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block MAPLE_PICKETS = registerBlock("maple_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block OLIVE_PICKETS = registerBlock("olive_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block PALO_VERDE_PICKETS = registerBlock("palo_verde_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block REDWOOD_PICKETS = registerBlock("redwood_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block SAXAUL_PICKETS = registerBlock("saxaul_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block SUGI_PICKETS = registerBlock("sugi_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block WILLOW_PICKETS = registerBlock("willow_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));
    public static final Block WISTERIA_PICKETS = registerBlock("wisteria_pickets", new CompatPicketsBlock(BountifulFares.NATURES_SPIRIT_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));

    public static final TrellisVariant REDWOOD = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "redwood", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "redwood_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant SUGI = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "sugi", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "sugi_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant WISTERIA = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "wisteria", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "wisteria_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant FIR = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "fir", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "fir_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant WILLOW = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "willow", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "willow_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant ASPEN = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "aspen", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "aspen_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant MAPLE = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "maple", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "maple_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant CYPRESS = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "cypress", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "cypress_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant OLIVE = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "olive", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "olive_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant JOSHUA = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "joshua", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "joshua_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant GHAF = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "ghaf", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "ghaf_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant PALO_VERDE = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "palo_verde", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "palo_verde_planks"), TRELLIS_RENDER_CUTOUT);

    public static final TrellisVariant COCONUT = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant CEDAR = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "cedar", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "cedar_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant LARCH = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "larch", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "larch_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant MAHOGANY = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "mahogany", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "mahogany_planks"), TRELLIS_RENDER_CUTOUT);
    public static final TrellisVariant SAXAUL = new TrellisVariant(BountifulFares.NATURES_SPIRIT_MOD_ID, "saxaul", Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "saxaul_planks"), TRELLIS_RENDER_CUTOUT);

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(Registries.BLOCK, Identifier.of(NATURES_SPIRIT_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(NATURES_SPIRIT_MOD_ID, name), new CompatBlockItem(NATURES_SPIRIT_MOD_ID, block, new Item.Settings()));
    }
    public static void registerNaturesSpiritBlocks() {

    }
}
