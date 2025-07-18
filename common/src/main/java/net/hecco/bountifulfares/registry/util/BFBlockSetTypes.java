package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class BFBlockSetTypes {
    public static final BlockSetType HOARY = BFBlockSetTypes.register(new BlockSetType("hoary"));
    public static final BlockSetType WALNUT = BFBlockSetTypes.register(new BlockSetType("walnut"));
    public static final BlockSetType CERAMIC = BFBlockSetTypes.register(new BlockSetType("ceramic"
//            ,
//            true,
//            true,
//            true,
//            BlockSetType.PressurePlateSensitivity.EVERYTHING,
//            BFSounds.CERAMIC_DECORATION,
//            BFSounds.CERAMIC_DOOR_TOGGLE.get(),
//            BFSounds.CERAMIC_DOOR_TOGGLE.get(),
//            BFSounds.CERAMIC_DOOR_TOGGLE.get(),
//            BFSounds.CERAMIC_DOOR_TOGGLE.get(),
//            BFSounds.CERAMIC_PRESSURE_PLATE_OFF.get(),
//            BFSounds.CERAMIC_PRESSURE_PLATE_ON.get(),
//            BFSounds.CERAMIC_BUTTON_OFF.get(),
//            BFSounds.CERAMIC_BUTTON_ON.get() //TODO: FIXXXXXXX
    ));


    private static BlockSetType register(BlockSetType blockSetType) {
        return blockSetType;
    }
}