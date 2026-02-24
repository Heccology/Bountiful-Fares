package net.hecco.bountifulfares.mixin.misc;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.custom.CoconutCandleBlock;
import net.hecco.bountifulfares.definition.block.custom.InfusedCandleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

// Flint & Steel -> Dispenser Action
@Mixin(targets = "net.minecraft.core.dispenser.DispenseItemBehavior$8")
public abstract class FlintSteelDispMixin {
    @ModifyExpressionValue(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/dispenser/DispenseItemBehavior$8;isSuccess()Z"))
    private boolean bountifulfares$actionable$lightCustomCandles(
            boolean original,
            @Local(argsOnly = true) BlockSource p_338494_,
            @Local(argsOnly = true) ItemStack p_338444_
    ) {
        ServerLevel serverLevel = p_338494_.level();
        Direction direction = p_338494_.state().getValue(DispenserBlock.FACING);
        BlockPos blockPos = p_338494_.pos().relative(direction);
        BlockState blockState = serverLevel.getBlockState(blockPos);
        boolean wrapRet = original;

        if (!wrapRet) {
            if (InfusedCandleBlock.canBeLit(blockState) || CoconutCandleBlock.canBeLit(blockState)) {
                serverLevel.setBlockAndUpdate(blockPos, blockState.setValue(BlockStateProperties.LIT, true));
                serverLevel.gameEvent(null, GameEvent.BLOCK_CHANGE, blockPos);
                ((OptionalDispenseItemBehavior)(Object)this).setSuccess(true);
                wrapRet = true;
            }
        }
        return wrapRet;
    }
}