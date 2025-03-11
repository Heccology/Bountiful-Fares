package net.hecco.bountifulfares.registry.util;

import net.minecraft.block.enums.NoteBlockInstrument;

// Loads Note Block types
public class BFNoteBlockInstrument
{
    // This solely ensures the class remains loaded.
    static {
        NoteBlockInstrument.values();
    }

    // Here you can define new note block sound types.
    // When defining .instrument() on a block, you can use one of these instead of a sound from NoteBlockInstrument.
    // "BOUNTIFUL_FARES_BONK" is a commented-out example; see its registry code in NoteBlockInstrumentMixin.
    public static NoteBlockInstrument BOUNTIFUL_FARES_BONK;

    /*
        To add a new Note Block sound, simply create a new 'public static' like the commented out code shows.
        NoteBlockInstrumentMixin has more info on this process - you'll reference your new variable there.
    */
}