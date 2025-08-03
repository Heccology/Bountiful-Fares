package net.hecco.bountifulfares.compat.dungeons_delight;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatPicketsBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.DUNGEONS_DELIGHT_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFTrellises.TRELLIS_RENDER_CUTOUT;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class DungeonsDelightBlocks {
    public static Supplier<Block> WORMWOOD_PICKETS = registerBlock("wormwood_pickets", () -> new CompatPicketsBlock(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));

//    public static final TrellisVariant WORMWOOD = new TrellisVariant(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, "wormwood", ResourceLocation.fromNamespaceAndPath(DUNGEONS_DELIGHT_MOD_ID, "wormwood_planks"), TRELLIS_RENDER_CUTOUT);
//

    public static Supplier<Block> registerBlock(String name, Supplier<Block> block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return HLServices.REGISTRY.registerBlockNoItem(DUNGEONS_DELIGHT_MOD_ID, name, block);
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        HLServices.REGISTRY.registerItem(DUNGEONS_DELIGHT_MOD_ID, name, () -> new CompatBlockItem(DUNGEONS_DELIGHT_MOD_ID, block.get(), new Item.Properties()));
    }
    public static void registerDungeonsDelightBlocks() {
    }
}
