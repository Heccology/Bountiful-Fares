package net.hecco.bountifulfares.mixin;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.structure.WoodlandMansionGenerator;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WoodlandMansionGenerator.FirstFloorRoomPool.class)
public class WoodlandMansionFirstFloorMixin {
    @Inject(method = "getBigRoom", at = @At("INVOKE"), cancellable = true)
    public void addGoldenTreeRoom(Random random, CallbackInfoReturnable<String> cir) {
        if (BountifulFares.CONFIG.isGenerateGoldenAppleTreeRooms() && random.nextFloat() < 0.3) {
            cir.setReturnValue("bountifulfares_golden_tree");
            cir.cancel();
        }
    }

    @Inject(method = "getMediumSecretRoom", at = @At("INVOKE"), cancellable = true)
    public void addSaplingNurseryRoom(Random random, CallbackInfoReturnable<String> cir) {
        if (BountifulFares.CONFIG.isGenerateGoldenAppleTreeRooms()) {
            cir.setReturnValue("bountifulfares_sapling_nursery");
            cir.cancel();
        }
    }

}