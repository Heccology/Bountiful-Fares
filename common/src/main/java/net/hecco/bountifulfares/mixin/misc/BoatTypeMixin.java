package net.hecco.bountifulfares.mixin.misc;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Debug(export = true)
@Mixin(Boat.Type.class)
public abstract class BoatTypeMixin {
    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static Boat.Type newBoatType(String internalName, int ordinal, Block planks, String name) {
        throw new AssertionError();
    }

    @SuppressWarnings("ShadowTarget")
    @Shadow
    private static @Final
    @Mutable
    Boat.Type[] $VALUES;

    @Inject(method = "<clinit>", at = @At(
            value = "FIELD",
            opcode = 179,
            target = "Lnet/minecraft/world/entity/vehicle/Boat$Type;$VALUES:[Lnet/minecraft/world/entity/vehicle/Boat$Type;",
            shift = At.Shift.AFTER))
    private static void bountifulfares$addBoatTypes(CallbackInfo ci) {
        var notesounds = new ArrayList<>(Arrays.asList($VALUES));
        var last = notesounds.getLast();
        var i = 1;

        var bf_ocarina = newBoatType(
                "BOUNTIFUL_FARES_WALNUT",
                last.ordinal() + i,
                Blocks.OAK_PLANKS,
                "bountiful_fares_walnut"
        );
        notesounds.add(bf_ocarina);
        i++;

        var bf_ocarina1 = newBoatType(
                "BOUNTIFUL_FARES_HOARY",
                last.ordinal() + i,
                Blocks.OAK_PLANKS,
                "bountiful_fares_hoary"
        );
        notesounds.add(bf_ocarina1);
        i++;
        $VALUES = notesounds.toArray(new Boat.Type[0]);
    }
}
