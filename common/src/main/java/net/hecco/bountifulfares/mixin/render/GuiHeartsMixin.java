package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.util.BFHeartTypes;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
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
@Mixin(targets = "net.minecraft.client.gui.Gui$HeartType")
public abstract class GuiHeartsMixin
{
    // Allows new entries.
    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static Gui.HeartType newHeartType(String internalName,
                                                    int ordinal,
                                                    ResourceLocation fullTex,
                                                    ResourceLocation fullBlinkTex,
                                                    ResourceLocation halfTex,
                                                    ResourceLocation halfBlinkTex,
                                                    ResourceLocation hardcoreFullTex,
                                                    ResourceLocation hardcoreFullBlinkTex,
                                                    ResourceLocation hardcoreHalfTex,
                                                    ResourceLocation hardcoreHalfBlinkTex)
    {
        throw new AssertionError();
    }

    // Get field.
    @SuppressWarnings("ShadowTarget")
    @Shadow
    private static @Final
    @Mutable
    Gui.HeartType[] $VALUES;

    // Injects data.
    @Inject(method = "<clinit>", at = @At(
            value = "FIELD",
            opcode = 179,
            target = "net/minecraft/client/gui/Gui$HeartType.$VALUES:[Lnet/minecraft/client/gui/Gui$HeartType;",
            shift = At.Shift.AFTER))
    private static void addCustomHearts(CallbackInfo ci) {

        // Get rarity list.
        var hearts = new ArrayList<>(Arrays.asList($VALUES));
        var last = hearts.getLast();
        int i = 1;

        // Bountiful Fares: Restoration
        var bf_restoration = newHeartType(
                "BOUNTIFUL_FARES_RESTORATION",
                last.ordinal() + i,
                ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hud/heart/restoration_full"),
                ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hud/heart/restoration_full_blinking"),
                ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hud/heart/restoration_half"),
                ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hud/heart/restoration_half_blinking"),
                ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_full"),
                ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_full_blinking"),
                ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_half"),
                ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "hud/heart/restoration_hardcore_half_blinking")
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
        $VALUES = hearts.toArray(new Gui.HeartType[0]);
    }

    // This will directly inject the new heart usage.
    @Inject(method = "forPlayer", at = @At("TAIL"), cancellable = true)
    private static void bfPlayerStateCheck(Player player, CallbackInfoReturnable<Gui.HeartType> cir) {
        // Prefetch config values.
        boolean useRestorationHeart = BountifulFares.CONFIG.isRestorationHeartOverlay();

        // Check for if the normal heart type is the candidate for return.
        boolean isNormal = (cir.getReturnValue() == Gui.HeartType.NORMAL);
        if (isNormal) {
            if (player.hasEffect(BFEffects.RESTORATION) && useRestorationHeart) {
                cir.setReturnValue(BFHeartTypes.BF_RESTORATION);
            }
        }
    }

    // artyrian was here blame him for everything ever
}
