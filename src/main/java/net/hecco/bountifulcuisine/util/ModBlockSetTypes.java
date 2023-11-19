package net.hecco.bountifulcuisine.util;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.hecco.bountifulcuisine.sounds.ModSounds;
import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

import java.util.Set;

public class ModBlockSetTypes {
    private static final Set<BlockSetType> VALUES = new ObjectArraySet<BlockSetType>();
    public static final BlockSetType HOARY = ModBlockSetTypes.register(new BlockSetType("hoary"));
    public static final BlockSetType CERAMIC = ModBlockSetTypes.register(new BlockSetType("ceramic", true, ModSounds.CERAMIC_TILES, ModSounds.CERAMIC_TILES_PLACE, ModSounds.CERAMIC_TILES_PLACE, ModSounds.CERAMIC_TILES_PLACE, ModSounds.CERAMIC_TILES_PLACE, ModSounds.CERAMIC_TILES_PLACE, ModSounds.CERAMIC_TILES_PLACE, ModSounds.CERAMIC_TILES_PLACE, ModSounds.CERAMIC_TILES_PLACE));


    private static BlockSetType register(BlockSetType blockSetType) {
        VALUES.add(blockSetType);
        return blockSetType;
    }
}