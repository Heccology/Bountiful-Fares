package net.hecco.bountifulfares.mixin.misc;

import net.hecco.bountifulfares.definition.block.entity.CeramicChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBlockEntity.class)
public class ChestBlockEntityMixin {

    @Inject(method = "getOpenCount", at = @At("HEAD"), cancellable = true)
    private static void bountifulfares$ceramicChestOpenCount(BlockGetter level, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
        BlockState blockstate = level.getBlockState(pos);
        if (blockstate.hasBlockEntity()) {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof CeramicChestBlockEntity entity) {
                cir.setReturnValue(entity.openersCounter.getOpenerCount());
                cir.cancel();
            }
        }
    }
}
