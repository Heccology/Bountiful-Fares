package net.hecco.bountifulfares.compat.arts_and_crafts;

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

import static net.hecco.bountifulfares.BountifulFares.ARTS_AND_CRAFTS_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFTrellises.TRELLIS_RENDER_CUTOUT;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class ArtsAndCraftsBlocks {
    public static Block CORK_PICKETS = registerBlock("cork_pickets", new CompatPicketsBlock(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.OAK_PICKETS)));

    public static final TrellisVariant CORK = new TrellisVariant(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "cork", Identifier.of(ARTS_AND_CRAFTS_MOD_ID, "cork_planks"), TRELLIS_RENDER_CUTOUT);


    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(Registries.BLOCK, Identifier.of(ARTS_AND_CRAFTS_MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ARTS_AND_CRAFTS_MOD_ID, name), new CompatBlockItem(ARTS_AND_CRAFTS_MOD_ID, block, new Item.Settings()));
    }
    public static void registerArtsAndCraftsBlocks() {
    }
}
