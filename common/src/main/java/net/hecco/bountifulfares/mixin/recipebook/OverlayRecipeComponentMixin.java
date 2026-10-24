package net.hecco.bountifulfares.mixin.recipebook;

import net.hecco.bountifulfares.definition.screen.gristmill.GristmillMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.recipebook.OverlayRecipeComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OverlayRecipeComponent.class)
public class OverlayRecipeComponentMixin {
    @Shadow private Minecraft minecraft;

    @Shadow private boolean isFurnaceMenu;

    @Inject(method = "init",at = @At(value = "INVOKE", target = "Ljava/util/List;clear()V"))
    private void bountifulfares$useCorrectCraftingOverlay(CallbackInfo ci) {
        if (this.minecraft.player.containerMenu instanceof GristmillMenu) {
            this.isFurnaceMenu = true;
        }
    }
}
