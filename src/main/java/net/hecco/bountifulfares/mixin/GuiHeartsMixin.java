package net.hecco.bountifulfares.mixin;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.util.BFHeartTypes;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Arrays;

// ID OF HEARTTYPE FIELD: field_33952 (<- )
// In case this ever fails, go to InGameHud.HeartType and view the Bytecode. The field should be defined sort of like this:
// private final static synthetic [Lnet/minecraft/client/gui/hud/InGameHud$HeartType; field_33952
// If the field is a different number, change the field ID here to match.
@Debug(export = true)
@Mixin(InGameHud.HeartType.class)
public abstract class GuiHeartsMixin
{
    // Allows new entries.
    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static InGameHud.HeartType newHeartType(String internalName,
                                                    int ordinal,
                                                    Identifier fullTex,
                                                    Identifier fullBlinkTex,
                                                    Identifier halfTex,
                                                    Identifier halfBlinkTex,
                                                    Identifier hardcoreFullTex,
                                                    Identifier hardcoreFullBlinkTex,
                                                    Identifier hardcoreHalfTex,
                                                    Identifier hardcoreHalfBlinkTex)
    {
        throw new AssertionError();
    }

    // Get field.
    @SuppressWarnings("ShadowTarget")
    @Shadow
    private static @Final
    @Mutable
    InGameHud.HeartType[] field_33952;

    // Injects data.
    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At(
            value = "FIELD",
            opcode = Opcodes.PUTSTATIC,
            target = "net/minecraft/client/gui/hud/InGameHud$HeartType.field_33952:[Lnet/minecraft/client/gui/hud/InGameHud$HeartType;",
            shift = At.Shift.AFTER))
    private static void addCustomHearts(CallbackInfo ci) {

        // Get rarity list.
        var hearts = new ArrayList<>(Arrays.asList(field_33952));
        var last = hearts.get(hearts.size() - 1);
        int i = 1;

        // Bountiful Fares: Restoration
        var bf_restoration = newHeartType(
                "BOUNTIFUL_FARES_RESTORATION",
                last.ordinal() + i,
                Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_full"),
                Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_full_blinking"),
                Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_half"),
                Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_half_blinking"),
                Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_full"),
                Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_full_blinking"),
                Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_half"),
                Identifier.of(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_half_blinking")
        );
        BFHeartTypes.BF_RESTORATION = bf_restoration;
        hearts.add(bf_restoration);
        i++;

        /*
            If need be, adding new heart types is simple.
            Copy the code above from `var bf_restoration` to `i++` and replace the values with unique ones:
                   - Replace the var "bf_restoration" with a new one, then replace its usage in the last 2 lines with the new var.
                   - Change the internalName to "BOUNTIFUL_FARES_<new name>" and change the file paths.
                   - Go to `BFHeartTypes` and define a new heart type. Replace "BF_RESTORATION" with your new one.

            After this, apply its usage in `bfPlayerStateCheck` below.
            This event directly modifies which heart sprites are being used and has direct access to the relevant player.
        */

        // Complete the injection.
        // This must ALWAYS be executed at the end of this method - no more code beyond this.
        field_33952 = hearts.toArray(new InGameHud.HeartType[0]);
    }

    // This will directly inject the new heart usage.
    // Order is set to 500 - this means will inject higher than most.
    @Inject(method = "fromPlayerState", at = @At("TAIL"), cancellable = true, order = 500)
    private static void bfPlayerStateCheck(PlayerEntity player, CallbackInfoReturnable<InGameHud.HeartType> cir) {
        // Prefetch config values.
        boolean useRestorationHeart = BountifulFares.CONFIG.isRestorationHeartOverlay();

        // Check for if the normal heart type is the candidate for return.
        boolean isNormal = (cir.getReturnValue() == InGameHud.HeartType.NORMAL);
        if (isNormal) {
            if (player.hasStatusEffect(BFEffects.RESTORATION) && useRestorationHeart) {
                cir.setReturnValue(BFHeartTypes.BF_RESTORATION);
            }
        }
    }

    // artyrian was here blame him for everything ever
}
