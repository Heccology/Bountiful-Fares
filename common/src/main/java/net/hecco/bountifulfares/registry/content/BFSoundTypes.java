package net.hecco.bountifulfares.registry.content;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

import static net.hecco.bountifulfares.registry.content.BFSounds.*;

public class BFSoundTypes {
    public static final SoundType CERAMIC_TILES = new SoundType(1f, 1f,  CERAMIC_TILES_BREAK.get(),  CERAMIC_TILES_STEP.get(),  CERAMIC_TILES_PLACE.get(),  CERAMIC_TILES_HIT.get(),  CERAMIC_TILES_FALL.get());
    public static final SoundType CERAMIC_DECORATION = new SoundType(1f, 1f,  CERAMIC_DECORATION_BREAK.get(),  CERAMIC_DECORATION_STEP.get(),  CERAMIC_DECORATION_PLACE.get(),  CERAMIC_DECORATION_HIT.get(),  CERAMIC_DECORATION_FALL.get());
    public static final SoundType LIGHT_WOOD = new SoundType(1f, 1.1f,  LIGHT_WOOD_BREAK.get(),  LIGHT_WOOD_STEP.get(),  LIGHT_WOOD_PLACE.get(),  LIGHT_WOOD_HIT.get(),  LIGHT_WOOD_FALL.get());
    public static final SoundType JACK_O_STRAW = new SoundType(1f, 1f,  JACK_O_STRAW_BREAK.get(),  LIGHT_WOOD_STEP.get(),  LIGHT_WOOD_PLACE.get(),  LIGHT_WOOD_HIT.get(),  LIGHT_WOOD_FALL.get());
    public static final SoundType SILENT = new SoundType(1f, 1f, SoundEvents.EMPTY,  LIGHT_WOOD_STEP.get(),  LIGHT_WOOD_PLACE.get(),  LIGHT_WOOD_HIT.get(),  LIGHT_WOOD_FALL.get());
    public static final SoundType PLANTED_TRELLIS = new SoundType(1f, 1.1f,  PLANTED_TRELLIS_BREAK.get(),  LIGHT_WOOD_STEP.get(),  LIGHT_WOOD_PLACE.get(),  LIGHT_WOOD_HIT.get(),  LIGHT_WOOD_FALL.get());
    public static final SoundType SPONGEKIN = new SoundType(1f, 1.1f,  SPONGEKIN_BREAK.get(),  SPONGEKIN_STEP.get(),  SPONGEKIN_PLACE.get(), SoundEvents.WOOD_HIT, SoundEvents.WOOD_FALL);
    public static final SoundType COIR = new SoundType(1f, 1f,  COIR_BREAK.get(),  COIR_STEP.get(),  COIR_PLACE.get(),  COIR_HIT.get(),  COIR_FALL.get());

    public static void register() {

    }
}
