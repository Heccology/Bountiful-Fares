package net.hecco.bountifulfares.mixin.recipebook;

import net.hecco.bountifulfares.registry.misc.BFRecipeBookCategories;
import net.hecco.bountifulfares.registry.misc.BFRecipeBookTypes;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(RecipeBookCategories.class)
public class RecipeBookCategoriesMixin {
    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static RecipeBookCategories newCat(String internalName, int internalId, ItemStack... stack) {
        throw new AssertionError();
    }

    @SuppressWarnings("ShadowTarget")
    @Shadow
    private static @Final
    @Mutable
    RecipeBookCategories[] $VALUES;

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At(
            value = "FIELD",
            opcode = 179, // PUTSTATIC
            target = "Lnet/minecraft/client/RecipeBookCategories;$VALUES:[Lnet/minecraft/client/RecipeBookCategories;",
            shift = At.Shift.AFTER))
    private static void bountifulfares$yesICopiedThisFromDungeonsDelightIArtyrianFuckingMADETHIS(CallbackInfo ci) {
        var values = new ArrayList<>(Arrays.asList($VALUES));
        var last = values.get(values.size() - 1);
        int i = last.ordinal() + 1;

        // BF Gristmill - Search
        var search = newCat(BFRecipeBookCategories.GRIST_SEARCH_ID, i, BFRecipeBookCategories.GRIST_SEARCH_ITEMS.get());
        BFRecipeBookCategories.BF_GRISTMILL_SEARCH = search;
        values.add(search);
        i++;

        // BF Gristmill - Materials
        var materials = newCat(BFRecipeBookCategories.GRIST_MATERIALS_ID, i, BFRecipeBookCategories.GRIST_MATERIALS_ITEMS.get());
        BFRecipeBookCategories.BF_GRISTMILL_MATERIALS = materials;
        values.add(materials);
        i++;

        // BF Gristmill - Minerals
        var minerals = newCat(BFRecipeBookCategories.GRIST_MINERALS_ID, i, BFRecipeBookCategories.GRIST_MINERALS_ITEMS.get());
        BFRecipeBookCategories.BF_GRISTMILL_MINERALS = minerals;
        values.add(minerals);
        i++;

        $VALUES = values.toArray(new RecipeBookCategories[0]);
        BFRecipeBookCategories.readyUpCategories();
    }

    @Inject(method = "getCategories", at = @At("HEAD"), cancellable = true)
    private static void bountifulfares$getCategories(RecipeBookType type, CallbackInfoReturnable<List<RecipeBookCategories>> cir) {
        if (type.equals(BFRecipeBookTypes.BF_GRISTMILL)) cir.setReturnValue(BFRecipeBookCategories.GRISTMILL_CATEGORIES);
    }
}
