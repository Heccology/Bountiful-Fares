package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class BFSounds {

    public static final SoundEvent CERAMIC_TILES_PLACE = registerSoundEvent("ceramic_tiles_place");
    public static final SoundEvent CERAMIC_TILES_BREAK = registerSoundEvent("ceramic_tiles_break");
    public static final SoundEvent CERAMIC_TILES_HIT = registerSoundEvent("ceramic_tiles_hit");
    public static final SoundEvent CERAMIC_TILES_STEP = registerSoundEvent("ceramic_tiles_step");
    public static final SoundEvent CERAMIC_TILES_FALL = registerSoundEvent("ceramic_tiles_fall");

    public static final SoundEvent CERAMIC_DECORATION_PLACE = registerSoundEvent("ceramic_decoration_place");
    public static final SoundEvent CERAMIC_DECORATION_BREAK = registerSoundEvent("ceramic_decoration_break");
    public static final SoundEvent CERAMIC_DECORATION_HIT = registerSoundEvent("ceramic_decoration_hit");
    public static final SoundEvent CERAMIC_DECORATION_STEP = registerSoundEvent("ceramic_decoration_step");
    public static final SoundEvent CERAMIC_DECORATION_FALL = registerSoundEvent("ceramic_decoration_fall");
    public static final SoundEvent CERAMIC_DOOR_TOGGLE = registerSoundEvent("ceramic_door_toggle");
    public static final SoundEvent FERMENTATION_VESSEL_FILL = registerSoundEvent("fermentation_vessel_fill");
    public static final SoundEvent FERMENTATION_VESSEL_SPLASH = registerSoundEvent("fermentation_vessel_splash");
    public static final SoundEvent FERMENTATION_VESSEL_FERMENT = registerSoundEvent("fermentation_vessel_ferment");
    public static final SoundEvent FERMENTATION_VESSEL_EMPTY = registerSoundEvent("fermentation_vessel_empty");

    public static final SoundEvent GRISTMILL_GRIND = registerSoundEvent("gristmill_grind");

    public static final SoundEvent GOLDEN_APPLE_WITHER = registerSoundEvent("golden_apple_wither");

    public static final SoundEvent LIGHT_WOOD_PLACE = registerSoundEvent("light_wood_place");
    public static final SoundEvent LIGHT_WOOD_BREAK = registerSoundEvent("light_wood_break");
    public static final SoundEvent LIGHT_WOOD_HIT = registerSoundEvent("light_wood_hit");
    public static final SoundEvent LIGHT_WOOD_STEP = registerSoundEvent("light_wood_step");
    public static final SoundEvent LIGHT_WOOD_FALL = registerSoundEvent("light_wood_fall");
    public static final SoundEvent PLANTED_TRELLIS_BREAK = registerSoundEvent("planted_trellis_break");
    public static final SoundEvent JACK_O_STRAW_BREAK = registerSoundEvent("jack_o_straw_break");
    public static final SoundEvent CERAMIC_LEVER_ON = registerSoundEvent("ceramic_lever_on");
    public static final SoundEvent CERAMIC_LEVER_OFF = registerSoundEvent("ceramic_lever_off");
    public static final SoundEvent CERAMIC_BUTTON_ON = registerSoundEvent("ceramic_button_on");
    public static final SoundEvent CERAMIC_BUTTON_OFF = registerSoundEvent("ceramic_button_off");
    public static final SoundEvent CERAMIC_PRESSURE_PLATE_ON = registerSoundEvent("ceramic_pressure_plate_on");
    public static final SoundEvent CERAMIC_PRESSURE_PLATE_OFF = registerSoundEvent("ceramic_pressure_plate_off");

    public static final SoundEvent SPONGEKIN_PLACE = registerSoundEvent("spongekin_place");
    public static final SoundEvent SPONGEKIN_BREAK = registerSoundEvent("spongekin_break");
    public static final SoundEvent SPONGEKIN_STEP = registerSoundEvent("spongekin_step");
    public static final SoundEvent SPONGEKIN_SHEAR = registerSoundEvent("spongekin_shear");
    public static final SoundEvent FLOUR_THROW = registerSoundEvent("flour_throw");
    public static final SoundEvent FLOUR_LAND = registerSoundEvent("flour_land");
    public static final SoundEvent HANGING_FRUIT_PICK = registerSoundEvent("hanging_fruit_pick");
    public static final SoundEvent COCONUT_LAND = registerSoundEvent("coconut_land");
    public static final SoundEvent COCONUT_BONK = registerSoundEvent("coconut_bonk");
    public static final SoundEvent COIR_PLACE = registerSoundEvent("coir_place");
    public static final SoundEvent COIR_BREAK = registerSoundEvent("coir_break");
    public static final SoundEvent COIR_HIT = registerSoundEvent("coir_hit");
    public static final SoundEvent COIR_STEP = registerSoundEvent("coir_step");
    public static final SoundEvent COIR_FALL = registerSoundEvent("coir_fall");

    public static final SoundEvent CABINET_OPEN = registerSoundEvent("cabinet_open");
    public static final SoundEvent CABINET_CLOSE = registerSoundEvent("cabinet_close");

    // Note Block sounds MUST be registered as a RegistryEntry<SoundEvent>! Using registerSoundReference() will do this.
    // The below sound is used in the example in NoteBlockInstrumentMixin. It can be deleted if necessary.
    // public static final RegistryEntry<SoundEvent> NOTE_BLOCK_BONK_EXAMPLE = registerSoundReference("coconut_bonk");

    public static final BlockSoundGroup CERAMIC_TILES = new BlockSoundGroup(1f, 1f, CERAMIC_TILES_BREAK, CERAMIC_TILES_STEP, CERAMIC_TILES_PLACE, CERAMIC_TILES_HIT, CERAMIC_TILES_FALL);
    public static final BlockSoundGroup CERAMIC_DECORATION = new BlockSoundGroup(1f, 1f, CERAMIC_DECORATION_BREAK, CERAMIC_DECORATION_STEP, CERAMIC_DECORATION_PLACE, CERAMIC_DECORATION_HIT, CERAMIC_DECORATION_FALL);
    public static final BlockSoundGroup LIGHT_WOOD = new BlockSoundGroup(1f, 1.1f, LIGHT_WOOD_BREAK, LIGHT_WOOD_STEP, LIGHT_WOOD_PLACE, LIGHT_WOOD_HIT, LIGHT_WOOD_FALL);
    public static final BlockSoundGroup JACK_O_STRAW = new BlockSoundGroup(1f, 1f, JACK_O_STRAW_BREAK, LIGHT_WOOD_STEP, LIGHT_WOOD_PLACE, LIGHT_WOOD_HIT, LIGHT_WOOD_FALL);
    public static final BlockSoundGroup SILENT = new BlockSoundGroup(1f, 1f, SoundEvents.INTENTIONALLY_EMPTY, LIGHT_WOOD_STEP, LIGHT_WOOD_PLACE, LIGHT_WOOD_HIT, LIGHT_WOOD_FALL);
    public static final BlockSoundGroup PLANTED_TRELLIS = new BlockSoundGroup(1f, 1.1f, PLANTED_TRELLIS_BREAK, LIGHT_WOOD_STEP, LIGHT_WOOD_PLACE, LIGHT_WOOD_HIT, LIGHT_WOOD_FALL);
    public static final BlockSoundGroup SPONGEKIN = new BlockSoundGroup(1f, 1.1f, SPONGEKIN_BREAK, SPONGEKIN_STEP, SPONGEKIN_PLACE, SoundEvents.BLOCK_WOOD_HIT, SoundEvents.BLOCK_WOOD_FALL);
    public static final BlockSoundGroup COIR = new BlockSoundGroup(1f, 1f, COIR_BREAK, COIR_STEP, COIR_PLACE, COIR_HIT, COIR_FALL);

    private static RegistryEntry.Reference<SoundEvent> registerSoundReference(String name) {
        Identifier id = Identifier.of(BountifulFares.MOD_ID, name);
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = Identifier.of(BountifulFares.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }
    public static void registerSounds() {
    }
}

