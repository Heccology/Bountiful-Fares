package net.hecco.bountifulfares.compat.twigs;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


public class TwigsSounds {
    public static SoundEvent LAMP_PLACE = registerSoundEvent("lamp_place");
    public static SoundEvent LAMP_BREAK = registerSoundEvent("lamp_break");
    public static SoundEvent LAMP_HIT = registerSoundEvent("lamp_hit");
    public static SoundEvent LAMP_STEP = registerSoundEvent("lamp_step");
    public static SoundEvent LAMP_FALL = registerSoundEvent("lamp_fall");
    public static SoundEvent LAMP_ON = registerSoundEvent("lamp_on");
    public static SoundEvent LAMP_OFF = registerSoundEvent("lamp_off");
    public static BlockSoundGroup LAMP = new BlockSoundGroup(1, 0.7f, LAMP_BREAK, LAMP_STEP, LAMP_PLACE, LAMP_HIT, LAMP_FALL);
    public static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(BountifulFares.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }
    public static void registerSounds() {
    }
}
