package net.hecco.bountifulfares.definition.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

public class StrippableFruitLogBlock extends FruitLogBlock {

    private final Supplier<Block> stripped;

    public StrippableFruitLogBlock(Properties properties, Supplier<Block> stripped) {
        super(properties);
        this.stripped = stripped;
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide && stack.getItem() instanceof AxeItem) {
            BlockState strippedState = stripped.get().defaultBlockState();

            for (Property<?> prop : state.getProperties()) {
                if (strippedState.hasProperty(prop)) {
                    strippedState = copyProperty(strippedState, state, prop);
                }
            }

            level.playSound(null, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            level.setBlock(pos, strippedState, 11);
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    private <T extends Comparable<T>> BlockState copyProperty(BlockState target, BlockState source, Property<T> prop) {
        return target.setValue(prop, source.getValue(prop));
    }
}