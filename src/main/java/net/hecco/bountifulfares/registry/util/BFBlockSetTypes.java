package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.block.BlockSetType;

public class BFBlockSetTypes {
    public static final BlockSetType HOARY = BFBlockSetTypes.register(new BlockSetType("hoary"));
    public static final BlockSetType WALNUT = BFBlockSetTypes.register(new BlockSetType("walnut"));
    public static final BlockSetType CERAMIC = BFBlockSetTypes.register(new BlockSetType("ceramic",
            true,
            true,
            true,
            BlockSetType.ActivationRule.EVERYTHING,
            BFSounds.CERAMIC_DECORATION,
            BFSounds.CERAMIC_DOOR_TOGGLE,
            BFSounds.CERAMIC_DOOR_TOGGLE,
            BFSounds.CERAMIC_DOOR_TOGGLE,
            BFSounds.CERAMIC_DOOR_TOGGLE,
            BFSounds.CERAMIC_PRESSURE_PLATE_OFF,
            BFSounds.CERAMIC_PRESSURE_PLATE_ON,
            BFSounds.CERAMIC_BUTTON_OFF,
            BFSounds.CERAMIC_BUTTON_ON
    ));


    private static BlockSetType register(BlockSetType blockSetType) {
        return blockSetType;
    }
}