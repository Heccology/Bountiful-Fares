package net.hecco.bountifulfares.compat.spawn;

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

import static net.hecco.bountifulfares.BountifulFares.SPAWN_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFTrellises.TRELLIS_RENDER_CUTOUT;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class SpawnBlocks {
    public static Block ROTTEN_PICKETS = registerBlock("rotten_pickets", new CompatPicketsBlock(SPAWN_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS)));

    public static final TrellisVariant ROTTEN = new TrellisVariant(BountifulFares.SPAWN_MOD_ID, "rotten", ResourceLocation.fromNamespaceAndPath(SPAWN_MOD_ID, "rotten_planks"), TRELLIS_RENDER_CUTOUT);

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(SPAWN_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(SPAWN_MOD_ID, name), new CompatBlockItem(SPAWN_MOD_ID, block, new Item.Properties()));
    }
    public static void registerSpawnBlocks() {

    }
}
