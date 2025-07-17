//package net.hecco.bountifulfares.compat.spawn;
//
//import net.hecco.bountifulfares.BountifulFares;
//import net.hecco.bountifulfares.compat.block.CompatBlockItem;
//import net.hecco.bountifulfares.compat.block.CompatPicketsBlock;
//import net.hecco.bountifulfares.registry.content.BFBlocks;
//import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
//import net.hecco.heccolib.platform.HLServices;
//import net.minecraft.core.Registry;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//
//import java.util.function.Supplier;
//
//import static net.hecco.bountifulfares.BountifulFares.APPLEDOG_MOD_ID;
//import static net.hecco.bountifulfares.BountifulFares.SPAWN_MOD_ID;
//import static net.hecco.bountifulfares.registry.content.BFTrellises.TRELLIS_RENDER_CUTOUT;
//import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;
//
//public class SpawnBlocks {
//    public static Supplier<Block> ROTTEN_PICKETS = registerBlock("rotten_pickets", () -> new CompatPicketsBlock(SPAWN_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.OAK_PICKETS.get())));
//
//    public static final TrellisVariant ROTTEN = new TrellisVariant(BountifulFares.SPAWN_MOD_ID, "rotten", ResourceLocation.fromNamespaceAndPath(SPAWN_MOD_ID, "rotten_planks"), TRELLIS_RENDER_CUTOUT);
//
//    public static Supplier<Block> registerBlock(String name, Supplier<Block> block) {
//        registerBlockItem(name, block);
//        compatBlocks.add(block);
//        return HLServices.REGISTRY.registerBlockNoItem(SPAWN_MOD_ID, name, block);
//    }
//
//    private static void registerBlockItem(String name, Supplier<Block> block) {
//        HLServices.REGISTRY.registerItem(SPAWN_MOD_ID, name, () -> new CompatBlockItem(SPAWN_MOD_ID, block.get(), new Item.Properties()));
//    }
//    public static void registerSpawnBlocks() {
//
//    }
//}
