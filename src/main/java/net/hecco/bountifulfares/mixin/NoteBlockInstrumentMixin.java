package net.hecco.bountifulfares.mixin;

import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.util.BFNoteBlockInstruments;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

// ID OF NOTEBLOCK FIELD: field_12652
// Similar to GuiHeartsMixin, if this ever breaks, the field number can be found in the bytecode, and looks like this:
// private final static synthetic [Lnet/minecraft/block/enums/NoteBlockInstrument; field_12652
@Debug(export = true)
@Mixin(NoteBlockInstrument.class)
public abstract class NoteBlockInstrumentMixin
{
    // Allows new entries.
    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static NoteBlockInstrument newNoteType(String internalName,
                                                   int ordinal,
                                                   String name,
                                                   RegistryEntry<SoundEvent> sound,
                                                   NoteBlockInstrument.Type type)
    {
        throw new AssertionError();
    }

    // Get note block field.
    @SuppressWarnings("ShadowTarget")
    @Shadow
    private static @Final
    @Mutable
    NoteBlockInstrument[] field_12652;

    // Injects data.
    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At(
            value = "FIELD",
            opcode = Opcodes.PUTSTATIC,
            target = "Lnet/minecraft/block/enums/NoteBlockInstrument;field_12652:[Lnet/minecraft/block/enums/NoteBlockInstrument;",
            shift = At.Shift.AFTER))
    private static void customNoteBlockSFX(CallbackInfo ci)
    {
        // Get list of current note block sfx.
        var notesounds = new ArrayList<>(Arrays.asList(field_12652));
        var last = notesounds.get(notesounds.size() - 1);
        var i = 1;

        /*
        The code section below is an example of how to implement a new Note Block sound.
        Adding a new sound is similar to adding new heart types:

            - Replace the var "bf_bonk" with a new one, then replace its usage in the last 2 lines with the new var.
            - Change the internalName to "BOUNTIFUL_FARES_<new name>".
            - Replace "bountiful_fares_bonk" with the ID for the sound.
                - This will be referenced internally, and will show up if you change a Note Block's sound with a Debug Stick.
            - Replace "BFSounds.NOTE_BLOCK_BONK_EXAMPLE" with any sound that's registered via RegistryEntry<SoundEvent>.
                - BFSounds has a commented-out example of a custom Note Block sound for reference.
            - Go to `BFNoteBlockInstrument` and define a new sound type. Replace "BOUNTIFUL_FARES_BONK" with your new one.

        Also, check the comment at the bottom of this file for a handy reference for adding sounds to sounds.json, if it makes it easier.
        ----------------------------------


         */

        // Bountiful Fares: Coconut Bonk
        var bf_ocarina = newNoteType(
                "BOUNTIFUL_FARES_OCARINA",
                last.ordinal() + i,
                "bountiful_fares_ocarina",
                BFSounds.NOTE_BLOCK_OCARINA,
                NoteBlockInstrument.Type.BASE_BLOCK
        );
        BFNoteBlockInstruments.OCARINA = bf_ocarina;
        notesounds.add(bf_ocarina);
        i++;
        var bf_old_piano = newNoteType(
                "BOUNTIFUL_FARES_OLD_PIANO",
                last.ordinal() + i,
                "bountiful_fares_old_piano",
                BFSounds.NOTE_BLOCK_OLD_PIANO,
                NoteBlockInstrument.Type.BASE_BLOCK
        );
        BFNoteBlockInstruments.OLD_PIANO = bf_old_piano;
        notesounds.add(bf_old_piano);
        i++;
        var bf_steel_drum = newNoteType(
                "BOUNTIFUL_FARES_STEEL_DRUM",
                last.ordinal() + i,
                "bountiful_fares_steel_drum",
                BFSounds.NOTE_BLOCK_STEEL_DRUM,
                NoteBlockInstrument.Type.BASE_BLOCK
        );
        BFNoteBlockInstruments.STEEL_DRUM = bf_steel_drum;
        notesounds.add(bf_steel_drum);
        i++;

        // Complete the injection.
        // This must ALWAYS be executed at the end of this method - no more code beyond this.
        field_12652 = notesounds.toArray(new NoteBlockInstrument[0]);
    }

    /*
        The sounds folder should have a "note" folder for adding note sounds, similarly to Vanilla.
        Below is a rough template for how you *could* register the notes in your sounds.json, including the common Vanilla subtitle.

        ---------------------

          "block.note_block.bountiful_fares.<NAME ID HERE>": {
            "sounds": [
              "frontiers:note/<SOUND NAME HERE>"
            ],
            "subtitle": "subtitles.block.note_block.note"
          }

        ---------------------

        Also, small music theory-ish thing that you *might* already know: every single note block sound base is in F# key.
        Recording your base sound in that key will make it match up with Vanilla sounds.

        - artyrian :}
     */
}
