package net.hecco.bountifulfares.mixin.recipebook;

import net.hecco.bountifulfares.registry.misc.BFRecipeBookTypes;
import net.minecraft.world.inventory.RecipeBookType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(RecipeBookType.class)
public class RecipeBookTypeMixin {
    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static RecipeBookType newType(String internalName, int internalId) {
        throw new AssertionError();
    }

    @SuppressWarnings("ShadowTarget")
    @Shadow
    private static @Final
    @Mutable
    RecipeBookType[] $VALUES;

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At(
            value = "FIELD",
            opcode = 179, // PUTSTATIC
            target = "Lnet/minecraft/world/inventory/RecipeBookType;$VALUES:[Lnet/minecraft/world/inventory/RecipeBookType;",
            shift = At.Shift.AFTER))
    private static void bountifulfares$runCustomInjects(CallbackInfo ci) {
        var values = new ArrayList<>(Arrays.asList($VALUES));
        var last = values.get(values.size() - 1);
        int i = last.ordinal() + 1;

        // BF Gristmill
        var grist = newType(BFRecipeBookTypes.BF_GRIST_ID, i);
        BFRecipeBookTypes.BF_GRISTMILL = grist;
        values.add(grist);
        i++;

        $VALUES = values.toArray(new RecipeBookType[0]);
    }
}
