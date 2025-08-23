package net.hecco.bountifulfares.definition.block.custom;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

public class CakeWithToppingBlock extends NoCandleCakeBlock{
    public static final BooleanProperty TOPPING = BooleanProperty.create("topping");
    public final Supplier<Item> toppingItem;
    public CakeWithToppingBlock(Supplier<Item> toppingItem, Properties settings) {
        super(settings);
        this.toppingItem = toppingItem;
        this.registerDefaultState(this.getStateDefinition().any().setValue(TOPPING, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TOPPING);
        super.createBlockStateDefinition(builder);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (stack.is(toppingItem.get()) && state.getValue(BITES) == 0 && !state.getValue(TOPPING)) {
            stack.consume(1, player);
            level.playSound(null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.setBlockAndUpdate(pos, state.setValue(TOPPING, true));
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
            return ItemInteractionResult.SUCCESS;
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hit);
    }
}
