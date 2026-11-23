package net.hecco.bountifulfares.mixin.misc;

import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {
    @Inject(method = "isValid", at = @At("HEAD"), cancellable = true)
    private void bountifulfares$trellisValidBlocks(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (BFBlockEntities.TRELLIS_BLOCK_ENTITY.get().equals(this)) {
            cir.setReturnValue(state.getBlock() instanceof TrellisBlock);
            cir.cancel();
        }
    }
}
