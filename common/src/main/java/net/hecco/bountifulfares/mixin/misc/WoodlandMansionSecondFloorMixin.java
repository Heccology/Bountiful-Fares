package net.hecco.bountifulfares.mixin.misc;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.structures.WoodlandMansionPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WoodlandMansionPieces.SecondFloorRoomCollection.class)
public abstract class WoodlandMansionSecondFloorMixin {
    @Inject(method = "get1x2Secret", at = @At("HEAD"), cancellable = true)
    public void bountifulfares$addSaplingNurseryRoom(RandomSource random, CallbackInfoReturnable<String> cir) {
        if (random.nextFloat() < 0.4) {
            cir.setReturnValue("bountifulfares_sapling_nursery");
            cir.cancel();
        }
    }
}