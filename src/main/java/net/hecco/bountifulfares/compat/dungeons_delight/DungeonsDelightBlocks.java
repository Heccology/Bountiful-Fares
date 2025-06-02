package net.hecco.bountifulfares.compat.dungeons_delight;

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

import static net.hecco.bountifulfares.BountifulFares.DUNGEONS_DELIGHT_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFTrellises.TRELLIS_RENDER_CUTOUT;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class DungeonsDelightBlocks {
    public static Block WORMWOOD_PICKETS = registerBlock("wormwood_pickets", new CompatPicketsBlock(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS)));

    public static final TrellisVariant WORMWOOD = new TrellisVariant(BountifulFares.DUNGEONS_DELIGHT_MOD_ID, "wormwood", ResourceLocation.fromNamespaceAndPath(DUNGEONS_DELIGHT_MOD_ID, "wormwood_planks"), TRELLIS_RENDER_CUTOUT);


    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(DUNGEONS_DELIGHT_MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(DUNGEONS_DELIGHT_MOD_ID, name), new CompatBlockItem(DUNGEONS_DELIGHT_MOD_ID, block, new Item.Properties()));
    }
    public static void registerDungeonsDelightBlocks() {
    }
}
