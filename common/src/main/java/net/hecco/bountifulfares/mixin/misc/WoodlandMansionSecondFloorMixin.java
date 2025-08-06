package net.hecco.bountifulfares.mixin.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.structures.WoodlandMansionPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WoodlandMansionPieces.SecondFloorRoomCollection.class)
public class WoodlandMansionSecondFloorMixin {
    @Inject(method = "get1x2Secret", at = @At("HEAD"), cancellable = true)
    public void addSaplingNurseryRoom(RandomSource random, CallbackInfoReturnable<String> cir) {
        if (BountifulFares.CONFIG.isGenerateGoldenAppleTreeRooms() && random.nextFloat() < 0.4) {
            cir.setReturnValue("bountifulfares_sapling_nursery");
            cir.cancel();
        }
    }
}