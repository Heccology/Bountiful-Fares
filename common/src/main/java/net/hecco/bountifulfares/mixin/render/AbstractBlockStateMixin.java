package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.definition.block.entity.DyeableBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class AbstractBlockStateMixin {

    @Shadow @Final private MapColor mapColor;

    @Inject(method = "getMapColor", at = @At(value = "HEAD"), cancellable = true)
    private void bountifulfares$getMapColor(BlockGetter world, BlockPos pos, CallbackInfoReturnable<MapColor> cir) {
        if (!NLServices.PLATFORM.isModLoaded("antique_atlas")) {
            BlockState state = world.getBlockState(pos);
            if (state.is(BFBlockTags.DYEABLE_CERAMIC_BLOCKS) && this.mapColor != MapColor.NONE) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof DyeableCeramicBlockEntity) {
                    cir.setReturnValue(bountifulfares$findNearestMapColor(Integer.parseInt(String.format("%06X", DyeableBlockEntity.getColor(world, pos)).substring(0, 6), 16)));
                }
            }
        }
    }

    @Unique
    private static MapColor bountifulfares$findNearestMapColor(int color) {
        int r1 = (color >> 16) & 255;
        int g1 = (color >> 8) & 255;
        int b1 = color & 255;
        MapColor nearest = MapColor.NONE;
        double nearestDistance = 999999999;
        for (int i = 0; i < 64; i++) {
            MapColor mapColor = MapColor.byId(i);
            int r2 = (mapColor.col >> 16) & 255;
            int g2 = (mapColor.col >> 8) & 255;
            int b2 = mapColor.col & 255;
            double distance = Math.pow(r1 - r2, 2) + Math.pow(g1 - g2, 2) + Math.pow(b1 - b2, 2);
            if (distance < nearestDistance) {
                nearest = mapColor;
                nearestDistance = distance;
            }
        }
        return nearest;
    }
}
