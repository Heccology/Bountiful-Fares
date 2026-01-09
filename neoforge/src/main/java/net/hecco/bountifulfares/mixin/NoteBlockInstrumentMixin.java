package net.hecco.bountifulfares.mixin;

import net.hecco.bountifulfares.registry.util.BFNoteBlockInstruments;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
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
public abstract class NoteBlockInstrumentMixin {
    // Allows new entries.
    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static NoteBlockInstrument newNoteType(String internalName,
                                                   int ordinal,
                                                   String name,
                                                   Holder<SoundEvent> sound,
                                                   NoteBlockInstrument.Type type)
    {
        throw new AssertionError();
    }

    // Get note block field.
    @SuppressWarnings("ShadowTarget")
    @Shadow
    private static @Final
    @Mutable
    NoteBlockInstrument[] $VALUES;

    // Injects data.
    @Inject(method = "<clinit>", at = @At(
            value = "FIELD",
            opcode = 179,
            target = "Lnet/minecraft/world/level/block/state/properties/NoteBlockInstrument;$VALUES:[Lnet/minecraft/world/level/block/state/properties/NoteBlockInstrument;",
            shift = At.Shift.AFTER))
    private static void customNoteBlockSFX(CallbackInfo ci)
    {
        var notesounds = new ArrayList<>(Arrays.asList($VALUES));
        var last = notesounds.get(notesounds.size() - 1);
        var i = 1;

        // Due to how sounds are registered in Neo we need temps until common setup
        var bf_ocarina = newNoteType(
                "BOUNTIFUL_FARES_OCARINA",
                last.ordinal() + i,
                "bountiful_fares_ocarina",
                SoundEvents.NOTE_BLOCK_FLUTE,
                NoteBlockInstrument.Type.BASE_BLOCK
        );
        BFNoteBlockInstruments.OCARINA = bf_ocarina;
        notesounds.add(bf_ocarina);
        i++;
        var bf_old_piano = newNoteType(
                "BOUNTIFUL_FARES_OLD_PIANO",
                last.ordinal() + i,
                "bountiful_fares_old_piano",
                SoundEvents.NOTE_BLOCK_HARP,
                NoteBlockInstrument.Type.BASE_BLOCK
        );
        BFNoteBlockInstruments.OLD_PIANO = bf_old_piano;
        notesounds.add(bf_old_piano);
        i++;
        var bf_steel_drum = newNoteType(
                "BOUNTIFUL_FARES_STEEL_DRUM",
                last.ordinal() + i,
                "bountiful_fares_steel_drum",
                SoundEvents.NOTE_BLOCK_BANJO,
                NoteBlockInstrument.Type.BASE_BLOCK
        );
        BFNoteBlockInstruments.STEEL_DRUM = bf_steel_drum;
        notesounds.add(bf_steel_drum);

        $VALUES = notesounds.toArray(new NoteBlockInstrument[0]);
    }
}
