package net.hecco.bountifulfares.util;

import net.hecco.bountifulfares.sounds.ModSounds;
import net.minecraft.block.BlockSetType;

public class ModBlockSetTypes {
    public static final BlockSetType HOARY = ModBlockSetTypes.register(new BlockSetType("hoary"));
    public static final BlockSetType WALNUT = ModBlockSetTypes.register(new BlockSetType("walnut"));
    public static final BlockSetType CERAMIC = ModBlockSetTypes.register(new BlockSetType("ceramic",
            true,
            ModSounds.CERAMIC_DECORATION,
            ModSounds.CERAMIC_DECORATION_PLACE,
            ModSounds.CERAMIC_DECORATION_PLACE,
            ModSounds.CERAMIC_DECORATION_PLACE,
            ModSounds.CERAMIC_DECORATION_PLACE,
            ModSounds.CERAMIC_PRESSURE_PLATE_OFF,
            ModSounds.CERAMIC_PRESSURE_PLATE_ON,
            ModSounds.CERAMIC_BUTTON_OFF,
            ModSounds.CERAMIC_BUTTON_ON));


    private static BlockSetType register(BlockSetType blockSetType) {
        return blockSetType;
    }
}