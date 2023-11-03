package net.hecco.bountifulcuisine.sounds;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent CERAMIC_TILES_PLACE = registerSoundEvent("ceramic_tiles_place");
    public static final SoundEvent CERAMIC_TILES_BREAK = registerSoundEvent("ceramic_tiles_break");
    public static final SoundEvent CERAMIC_TILES_HIT = registerSoundEvent("ceramic_tiles_hit");
    public static final SoundEvent CERAMIC_TILES_STEP = registerSoundEvent("ceramic_tiles_step");
    public static final SoundEvent CERAMIC_TILES_FALL = registerSoundEvent("ceramic_tiles_fall");
    public static final SoundEvent GOLDEN_APPLE_BLOCK_PLACE = registerSoundEvent("golden_apple_block_place");
    public static final SoundEvent GOLDEN_APPLE_BLOCK_BREAK = registerSoundEvent("golden_apple_block_break");
    public static final SoundEvent GOLDEN_APPLE_BLOCK_HIT = registerSoundEvent("golden_apple_block_hit");
    public static final SoundEvent GOLDEN_APPLE_BLOCK_STEP = registerSoundEvent("golden_apple_block_step");
    public static final SoundEvent GOLDEN_APPLE_BLOCK_FALL = registerSoundEvent("golden_apple_block_fall");

    public static final BlockSoundGroup CERAMIC_TILES = new BlockSoundGroup(1f, 1f, CERAMIC_TILES_BREAK, CERAMIC_TILES_STEP, CERAMIC_TILES_PLACE, CERAMIC_TILES_HIT, CERAMIC_TILES_FALL);
    public static final BlockSoundGroup GOLDEN_APPLE_BLOCK = new BlockSoundGroup(1f, 1f, GOLDEN_APPLE_BLOCK_BREAK, GOLDEN_APPLE_BLOCK_STEP, GOLDEN_APPLE_BLOCK_PLACE, GOLDEN_APPLE_BLOCK_HIT, GOLDEN_APPLE_BLOCK_FALL);
    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(BountifulCuisine.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }
    public static void registerSounds() {
        BountifulCuisine.LOGGER.info("Registering Mod Sounds for " + BountifulCuisine.MOD_ID);
    }
}

