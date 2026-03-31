package net.hecco.bountifulfares.mixin.misc;

import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.sensing.SecondaryPoiSensor;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(SecondaryPoiSensor.class)
public class SecondaryPoiSensorMixin {

    @Inject(method = "doTick(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/npc/Villager;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/BlockPos;offset(III)Lnet/minecraft/core/BlockPos;"), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void bountifulfares$trellisSecondaryPoi(ServerLevel level, Villager entity, CallbackInfo ci, ResourceKey resourcekey, BlockPos blockpos, List list, int i, int j, int k, int l) {
        BlockPos blockpos1 = blockpos.offset(j, k, l);
        if (entity.getVillagerData().getProfession() == VillagerProfession.FARMER && level.getBlockState(blockpos1).getBlock() instanceof TrellisBlock) {
            list.add(GlobalPos.of(resourcekey, blockpos1));
        }
    }
}
