package net.hecco.bountifulfares.definition.block.entity;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.custom.InfusedCandleBlock;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.function.Supplier;

public class ChamomileCandleBlockEntity extends BlockEntity {
    private static BooleanProperty isLit;
    public ChamomileCandleBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.CHAMOMILE_CANDLE_BLOCK_ENTITY.get(), pos, state);
        isLit = ((InfusedCandleBlock)state.getBlock()).getLit();
    }
    public static void tick(Level world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        if (world.getGameTime() % 25L == 0L) {
            AABB box = new AABB(pos).inflate(Services.PLATFORM.get().getIntConfigValue("infusedCandleRadius"));
            List<Player> list = world.getEntitiesOfClass(Player.class, box);
            if (state.getValue(isLit)) {
                if (!world.isClientSide() && !list.isEmpty()) {
                    for (Player playerEntity : list) {
                        MobEffectInstance existingEffect = playerEntity.getEffect(BFEffects.EBULLIENCE);
                        if (existingEffect == null) {
                            playerEntity.addEffect(new MobEffectInstance(BFEffects.EBULLIENCE, 50, 0, true, false, true));
                        } else if (existingEffect.isAmbient() || existingEffect.getAmplifier() < 0 || existingEffect.endsWithin(50)) {
                            playerEntity.addEffect(new MobEffectInstance(BFEffects.EBULLIENCE, 50, 0, true, false, true));
                        }
                    }
                }
            }
        }
    }


    public static Supplier<BlockEntityType<ChamomileCandleBlockEntity>> getEntityType() {
        return BFBlockEntities.CHAMOMILE_CANDLE_BLOCK_ENTITY;
    }
}
