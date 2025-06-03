package net.hecco.bountifulfares.compat.twigs;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;


public class TwigsSounds {
    public static SoundEvent LAMP_PLACE = registerSoundEvent("block.lamp.place");
    public static SoundEvent LAMP_BREAK = registerSoundEvent("block.lamp.break");
    public static SoundEvent LAMP_HIT = registerSoundEvent("block.lamp.hit");
    public static SoundEvent LAMP_STEP = registerSoundEvent("block.lamp.step");
    public static SoundEvent LAMP_FALL = registerSoundEvent("block.lamp.fall");
    public static SoundEvent LAMP_ON = registerSoundEvent("block.lamp.on");
    public static SoundEvent LAMP_OFF = registerSoundEvent("block.lamp.off");
    public static SoundType LAMP = new SoundType(1, 0.7f, LAMP_BREAK, LAMP_STEP, LAMP_PLACE, LAMP_HIT, LAMP_FALL);
    public static SoundEvent registerSoundEvent(String name) {
        ResourceLocation identifier = ResourceLocation.fromNamespaceAndPath(BountifulFares.TWIGS_MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }
    public static void registerSounds() {
    }
}
