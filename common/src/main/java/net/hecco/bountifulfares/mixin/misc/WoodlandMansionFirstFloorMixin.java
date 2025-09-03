package net.hecco.bountifulfares.mixin.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.structure.structures.WoodlandMansionPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WoodlandMansionPieces.FirstFloorRoomCollection.class)
public class WoodlandMansionFirstFloorMixin {
    @Inject(method = "get2x2", at = @At("HEAD"), cancellable = true)
    public void addGoldenTreeRoom(RandomSource random, CallbackInfoReturnable<String> cir) {
        if (random.nextFloat() < 0.3) {
            cir.setReturnValue("bountifulfares_golden_tree");
            cir.cancel();
        }
    }

    @Inject(method = "get1x2Secret", at = @At("HEAD"), cancellable = true)
    public void addSaplingNurseryRoom(RandomSource random, CallbackInfoReturnable<String> cir) {
        cir.setReturnValue("bountifulfares_sapling_nursery");
        cir.cancel();
    }
}