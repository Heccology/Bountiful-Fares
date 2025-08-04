package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;

import java.util.function.Supplier;

public class BFSounds {

    public static final Supplier<SoundEvent> CERAMIC_TILES_PLACE = registerSoundEvent("ceramic_tiles_place");
    public static final Supplier<SoundEvent> CERAMIC_TILES_BREAK = registerSoundEvent("ceramic_tiles_break");
    public static final Supplier<SoundEvent> CERAMIC_TILES_HIT = registerSoundEvent("ceramic_tiles_hit");
    public static final Supplier<SoundEvent> CERAMIC_TILES_STEP = registerSoundEvent("ceramic_tiles_step");
    public static final Supplier<SoundEvent> CERAMIC_TILES_FALL = registerSoundEvent("ceramic_tiles_fall");

    public static final Supplier<SoundEvent> CERAMIC_DECORATION_PLACE = registerSoundEvent("ceramic_decoration_place");
    public static final Supplier<SoundEvent> CERAMIC_DECORATION_BREAK = registerSoundEvent("ceramic_decoration_break");
    public static final Supplier<SoundEvent> CERAMIC_DECORATION_HIT = registerSoundEvent("ceramic_decoration_hit");
    public static final Supplier<SoundEvent> CERAMIC_DECORATION_STEP = registerSoundEvent("ceramic_decoration_step");
    public static final Supplier<SoundEvent> CERAMIC_DECORATION_FALL = registerSoundEvent("ceramic_decoration_fall");
    public static final Supplier<SoundEvent> CERAMIC_DOOR_TOGGLE = registerSoundEvent("ceramic_door_toggle");
    public static final Supplier<SoundEvent> CERAMIC_DISH_INTERACT = registerSoundEvent("ceramic_dish_interact");
    public static final Supplier<SoundEvent> FERMENTATION_VESSEL_FILL = registerSoundEvent("fermentation_vessel_fill");
    public static final Supplier<SoundEvent> FERMENTATION_VESSEL_SPLASH = registerSoundEvent("fermentation_vessel_splash");
    public static final Supplier<SoundEvent> FERMENTATION_VESSEL_FERMENT = registerSoundEvent("fermentation_vessel_ferment");
    public static final Supplier<SoundEvent> FERMENTATION_VESSEL_EMPTY = registerSoundEvent("fermentation_vessel_empty");

    public static final Supplier<SoundEvent> GRISTMILL_GRIND = registerSoundEvent("gristmill_grind");

    public static final Supplier<SoundEvent> GOLDEN_APPLE_WITHER = registerSoundEvent("golden_apple_wither");

    public static final Supplier<SoundEvent> LIGHT_WOOD_PLACE = registerSoundEvent("light_wood_place");
    public static final Supplier<SoundEvent> LIGHT_WOOD_BREAK = registerSoundEvent("light_wood_break");
    public static final Supplier<SoundEvent> LIGHT_WOOD_HIT = registerSoundEvent("light_wood_hit");
    public static final Supplier<SoundEvent> LIGHT_WOOD_STEP = registerSoundEvent("light_wood_step");
    public static final Supplier<SoundEvent> LIGHT_WOOD_FALL = registerSoundEvent("light_wood_fall");
    public static final Supplier<SoundEvent> PLANTED_TRELLIS_BREAK = registerSoundEvent("planted_trellis_break");
    public static final Supplier<SoundEvent> JACK_O_STRAW_BREAK = registerSoundEvent("jack_o_straw_break");
    public static final Supplier<SoundEvent> CERAMIC_LEVER_ON = registerSoundEvent("ceramic_lever_on");
    public static final Supplier<SoundEvent> CERAMIC_LEVER_OFF = registerSoundEvent("ceramic_lever_off");
    public static final Supplier<SoundEvent> CERAMIC_BUTTON_ON = registerSoundEvent("ceramic_button_on");
    public static final Supplier<SoundEvent> CERAMIC_BUTTON_OFF = registerSoundEvent("ceramic_button_off");
    public static final Supplier<SoundEvent> CERAMIC_PRESSURE_PLATE_ON = registerSoundEvent("ceramic_pressure_plate_on");
    public static final Supplier<SoundEvent> CERAMIC_PRESSURE_PLATE_OFF = registerSoundEvent("ceramic_pressure_plate_off");

    public static final Supplier<SoundEvent> SPONGEKIN_PLACE = registerSoundEvent("spongekin_place");
    public static final Supplier<SoundEvent> SPONGEKIN_BREAK = registerSoundEvent("spongekin_break");
    public static final Supplier<SoundEvent> SPONGEKIN_STEP = registerSoundEvent("spongekin_step");
    public static final Supplier<SoundEvent> SPONGEKIN_SHEAR = registerSoundEvent("spongekin_shear");
    public static final Supplier<SoundEvent> FLOUR_THROW = registerSoundEvent("flour_throw");
    public static final Supplier<SoundEvent> FLOUR_LAND = registerSoundEvent("flour_land");
    public static final Supplier<SoundEvent> HANGING_FRUIT_PICK = registerSoundEvent("hanging_fruit_pick");
    public static final Supplier<SoundEvent> COCONUT_LAND = registerSoundEvent("coconut_land");
    public static final Supplier<SoundEvent> COCONUT_BONK = registerSoundEvent("coconut_bonk");
    public static final Supplier<SoundEvent> COIR_PLACE = registerSoundEvent("coir_place");
    public static final Supplier<SoundEvent> COIR_BREAK = registerSoundEvent("coir_break");
    public static final Supplier<SoundEvent> COIR_HIT = registerSoundEvent("coir_hit");
    public static final Supplier<SoundEvent> COIR_STEP = registerSoundEvent("coir_step");
    public static final Supplier<SoundEvent> COIR_FALL = registerSoundEvent("coir_fall");

    public static final Supplier<SoundEvent> POPPED_MAIZE_POP = registerSoundEvent("popped_maize_pop");

    public static final Supplier<SoundEvent> TIFFIN_INSERT = registerSoundEvent("tiffin_insert");
    public static final Supplier<SoundEvent> TIFFIN_REMOVE = registerSoundEvent("tiffin_remove");

    // Fallback sounds for FD sounds
    public static SoundEvent CABINET_OPEN = SoundEvents.BARREL_OPEN;
    public static SoundEvent CABINET_CLOSE = SoundEvents.BARREL_CLOSE;

    // Note Block sounds MUST be registered as a RegistryEntry<SoundEvent>! Using registerSoundReference() will do this.
    // The below sound is used in the example in NoteBlockInstrumentMixin. It can be deleted if necessary.
//     public static final Holder<SoundEvent> NOTE_BLOCK_OCARINA = registerSoundReference("ocarina");
//     public static final Holder<SoundEvent> NOTE_BLOCK_OLD_PIANO = registerSoundReference("old_piano");
//     public static final Holder<SoundEvent> NOTE_BLOCK_STEEL_DRUM = registerSoundReference("steel_drum"); //TODO: FIX
    //TODO: fix this stupid ass shit I wrote

//    private static Holder<SoundEvent> registerSoundReference(String id) {
//        return HLServices.REGISTRY.registerHolder(BountifulFares.MOD_ID, id, BuiltInRegistries.SOUND_EVENT.key(), SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, id)));
//        //TODO
//    }

    private static Supplier<SoundEvent> registerSoundEvent(String id) {
        return HLServices.REGISTRY.register(BountifulFares.MOD_ID, id, BuiltInRegistries.SOUND_EVENT, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, id)));
        //TODO: FIX??
    }

    public static void registerSounds() {
    }
}

