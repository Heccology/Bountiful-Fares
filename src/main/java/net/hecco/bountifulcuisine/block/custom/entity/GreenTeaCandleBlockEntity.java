package net.hecco.bountifulcuisine.block.custom.entity;

import net.hecco.bountifulcuisine.block.custom.GreenTeaCandleBlock;
import net.minecraft.block.AbstractBannerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class GreenTeaCandleBlockEntity extends BlockEntity {
    private static BooleanProperty isLit;
    public GreenTeaCandleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GREEN_TEA_CANDLE_BLOCK_ENTITY, pos, state);
        isLit = ((GreenTeaCandleBlock)state.getBlock()).getLit();
    }
    public static void tick(World world, BlockPos pos, BlockState state, GreenTeaCandleBlockEntity blockEntity) {
        Box box = new Box(pos).expand(5);
        List<PlayerEntity> list = world.getNonSpectatingEntities(PlayerEntity.class, box);
        if (state.get(isLit)) {
            if (!world.isClient() && !list.isEmpty()) {
                for (PlayerEntity playerEntity : list) {
                    playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 50, 0, true, false));
                }
            }
        }
    }
}
