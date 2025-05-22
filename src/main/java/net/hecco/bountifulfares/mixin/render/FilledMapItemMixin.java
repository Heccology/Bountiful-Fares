package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.block.entity.DyeableBlockEntity;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.FilledMapItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FilledMapItem.class)
public abstract class FilledMapItemMixin {

    @Redirect(method = "updateColors", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getMapColor(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/MapColor;"))
    private MapColor bountifulfares_findColorForCeramic(BlockState state, BlockView world, BlockPos pos) {
        if (state.isIn(BFBlockTags.DYEABLE_CERAMIC_BLOCKS) && state.getMapColor(world, pos) != MapColor.CLEAR) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DyeableCeramicBlockEntity) {
                return findNearestMapColor(Integer.parseInt(String.format("%06X", DyeableBlockEntity.getColor(world, pos)).substring(0, 6), 16));
            }
        }
        return state.getMapColor(world, pos);
    }

    @Unique
    private static MapColor findNearestMapColor(int color) {
        int r1 = (color >> 16) & 255;
        int g1 = (color >> 8) & 255;
        int b1 = color & 255;
        MapColor nearest = MapColor.CLEAR;
        double nearestDistance = 999999999;
        for (int i = 0; i < 64; i++) {
            MapColor mapColor = MapColor.get(i);
            int r2 = (mapColor.color >> 16) & 255;
            int g2 = (mapColor.color >> 8) & 255;
            int b2 = mapColor.color & 255;
            double distance = Math.pow(r1 - r2, 2) + Math.pow(g1 - g2, 2) + Math.pow(b1 - b2, 2);
            if (distance < nearestDistance) {
                nearest = mapColor;
                nearestDistance = distance;
            }
        }
        return nearest;
    }
}
