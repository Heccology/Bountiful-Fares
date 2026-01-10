package net.hecco.bountifulfares.mixin.misc;

import net.hecco.bountifulfares.definition.block.custom.SpongekinBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.dispenser.ShearsDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShearsDispenseItemBehavior.class)
public abstract class ShearsDispenseMixin {
    @Inject(method = "execute", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/core/dispenser/ShearsDispenseItemBehavior;setSuccess(Z)V",
            ordinal = 0,
            shift = At.Shift.AFTER)
    )
    private void bountifulfares$deployTheSpongebobSkinner(BlockSource blockSource, ItemStack item, CallbackInfoReturnable<ItemStack> cir) {
        ServerLevel serverlevel = blockSource.level();
        BlockPos blockpos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
        ((OptionalDispenseItemBehavior)(Object)this).setSuccess(bountifulfares$hecco$spongekinShearAttempt(serverlevel, blockpos));
    }

    @Unique
    private static boolean bountifulfares$hecco$spongekinShearAttempt(ServerLevel level, BlockPos pos) {
        BlockState blockstate = level.getBlockState(pos);
        if (blockstate.is(BFBlocks.SPONGEKIN.get())) {
            SpongekinBlock.shearAtPosition(null, level, pos);
            return true;
        }
        return false;
    }
}
