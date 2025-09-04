package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.definition.item.custom.TrellisBlockItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFSoundTypes;
import net.hecco.heccolib.lib.compat.CompatManager;
import net.hecco.heccolib.lib.compat.ModIntegration;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.List;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.NATURES_SPIRIT_MOD_ID;

public class NaturesSpiritIntegration implements ModIntegration {
    public static final List<String> WOOD_TYPES = List.of("aspen", "cedar", "coconut", "cypress", "fir", "ghaf", "joshua", "larch", "mahogany", "maple", "olive", "palo_verde", "sugi", "willow", "wisteria");
    @Override
    public CompatManager compatManager() {
        return BountifulFares.COMPAT_MANAGER;
    }

    @Override
    public List<String> modIds() {
        return List.of(NATURES_SPIRIT_MOD_ID);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void registerContent() {
        for (String wood : WOOD_TYPES) {
            BFBlocks.TRELLISES.put(wood, (Supplier<Block>) registerContent(HLServices.REGISTRY.registerBlockNoItem(NATURES_SPIRIT_MOD_ID, wood + "_trellis", () -> new TrellisBlock(BlockBehaviour.Properties.of().noOcclusion().strength(1.0f).sound(BFSoundTypes.LIGHT_WOOD).mapColor(MapColor.NONE).instrument(NoteBlockInstrument.BASS).randomTicks().noOcclusion()))));
            registerContent(HLServices.REGISTRY.registerItem(NATURES_SPIRIT_MOD_ID, wood + "_trellis", () -> new TrellisBlockItem(BFBlocks.TRELLISES.get(wood).get(), new Item.Properties())));
        }
    }
}
