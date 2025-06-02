package net.hecco.bountifulfares.compat.arts_and_crafts;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatPicketsBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static net.hecco.bountifulfares.BountifulFares.ARTS_AND_CRAFTS_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFTrellises.TRELLIS_RENDER_CUTOUT;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class ArtsAndCraftsBlocks {
    public static Block CORK_PICKETS = registerBlock("cork_pickets", new CompatPicketsBlock(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS)));

    public static final TrellisVariant CORK = new TrellisVariant(BountifulFares.ARTS_AND_CRAFTS_MOD_ID, "cork", ResourceLocation.fromNamespaceAndPath(ARTS_AND_CRAFTS_MOD_ID, "cork_planks"), TRELLIS_RENDER_CUTOUT);


    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(ARTS_AND_CRAFTS_MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(ARTS_AND_CRAFTS_MOD_ID, name), new CompatBlockItem(ARTS_AND_CRAFTS_MOD_ID, block, new Item.Properties()));
    }
    public static void registerArtsAndCraftsBlocks() {
    }
}
