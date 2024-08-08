package net.hecco.bountifulfares.compat.spawn;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.block.custom.PicketsBlock;
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

import static net.hecco.bountifulfares.BountifulFares.ELS_AND_LS_DYES_MOD_ID;
import static net.hecco.bountifulfares.BountifulFares.SPAWN_MOD_ID;
import static net.hecco.bountifulfares.block.BFBlocks.createLightLevelFromLitBlockState;
import static net.hecco.bountifulfares.compat.BFCompat.compatBlocks;
import static net.hecco.bountifulfares.trellis.BFTrellises.TRELLIS_RENDER_CUTOUT;

public class SpawnBlocks {
    public static Block ROTTEN_PICKETS = registerBlock("rotten_pickets", new PicketsBlock(FabricBlockSettings.copyOf(BFBlocks.OAK_PICKETS)));

    public static final TrellisVariant ROTTEN = new TrellisVariant(BountifulFares.SPAWN_MOD_ID, "rotten", null, TRELLIS_RENDER_CUTOUT);

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(Registries.BLOCK, new Identifier(SPAWN_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(SPAWN_MOD_ID, name), new CompatBlockItem(SPAWN_MOD_ID, block, new FabricItemSettings()));
    }
    public static void registerSpawnBlocks() {

    }
}
