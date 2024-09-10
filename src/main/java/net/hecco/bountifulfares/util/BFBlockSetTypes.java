package net.hecco.bountifulfares.util;

import net.hecco.bountifulfares.sounds.BFSounds;
import net.minecraft.block.BlockSetType;

public class BFBlockSetTypes {
    public static final BlockSetType HOARY = BFBlockSetTypes.register(new BlockSetType("hoary"));
    public static final BlockSetType WALNUT = BFBlockSetTypes.register(new BlockSetType("walnut"));
    public static final BlockSetType CERAMIC = BFBlockSetTypes.register(new BlockSetType("ceramic"
    ));


    private static BlockSetType register(BlockSetType blockSetType) {
        return blockSetType;
    }
}