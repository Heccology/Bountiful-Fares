package net.hecco.bountifulfares.mixin.recipebook;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.hecco.bountifulfares.definition.util.BFMixinUtil;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(ClientRecipeBook.class)
public class FabricClientRecipeBookMixin {
    @WrapOperation(method = "method_48464", at = @At(value = "NEW", target = "net/minecraft/client/gui/screens/recipebook/RecipeCollection"))
    private static RecipeCollection bountifulfares$secondaryCollections(RegistryAccess access, List<RecipeHolder<?>> recipes, Operation<RecipeCollection> original) {
        return BFMixinUtil.clientRecipeBookCollections(access, recipes, original);
    }
}
