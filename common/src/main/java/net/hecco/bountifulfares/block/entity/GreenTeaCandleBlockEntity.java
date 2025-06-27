package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.GreenTeaCandleBlock;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class GreenTeaCandleBlockEntity extends BlockEntity {
    private static BooleanProperty isLit;
    public GreenTeaCandleBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.GREEN_TEA_CANDLE_BLOCK_ENTITY.get(), pos, state);
        isLit = ((GreenTeaCandleBlock)state.getBlock()).getLit();
    }
    public static void tick(Level world, BlockPos pos, BlockState state, GreenTeaCandleBlockEntity blockEntity) {
        if (world.getGameTime() % 25L == 0L) {
            AABB box = new AABB(pos).inflate(BountifulFares.CONFIG.getInfusedCandleRadius());
            List<Player> list = world.getEntitiesOfClass(Player.class, box);
            if (state.getValue(isLit)) {
                if (!world.isClientSide() && !list.isEmpty()) {
                    for (Player playerEntity : list) {
                        MobEffectInstance existingEffect = playerEntity.getEffect(MobEffects.DIG_SPEED);
                        if (existingEffect == null) {
                            playerEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 50, 0, true, false, true));
                        } else if (existingEffect.isAmbient() || existingEffect.getAmplifier() < 0 || existingEffect.endsWithin(50)) {
                            playerEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 50, 0, true, false, true));
                        }
                    }
                }
            }
        }
    }
}
