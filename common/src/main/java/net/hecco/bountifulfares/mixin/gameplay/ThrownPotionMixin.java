package net.hecco.bountifulfares.mixin.gameplay;

import net.hecco.bountifulfares.definition.block.custom.CoconutCandleBlock;
import net.hecco.bountifulfares.definition.block.custom.InfusedCandleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownPotion.class)
public abstract class ThrownPotionMixin extends ThrowableItemProjectile {

    public ThrownPotionMixin(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "dowseFire", at = @At("TAIL"))
    private void bountifulfares$dowseFire(BlockPos pos, CallbackInfo ci) {
        BlockState blockState = this.level().getBlockState(pos);
        Block block = blockState.getBlock();

        if (block instanceof InfusedCandleBlock && blockState.getValue(InfusedCandleBlock.LIT)) {
            InfusedCandleBlock.extinguish(null, blockState, this.level(), pos);
        } else if (block instanceof CoconutCandleBlock && blockState.getValue(CoconutCandleBlock.LIT)) {
            CoconutCandleBlock.extinguish(null, blockState, this.level(), pos);
        }
    }
}
