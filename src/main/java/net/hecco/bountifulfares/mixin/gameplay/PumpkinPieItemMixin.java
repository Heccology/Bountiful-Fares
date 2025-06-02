package net.hecco.bountifulfares.mixin.gameplay;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class PumpkinPieItemMixin {

    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    public void bf_useOnBlock(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        if (context.getItemInHand().is(Items.PUMPKIN_PIE) && BountifulFares.CONFIG.enablePlaceablePumpkinPie) {
            InteractionResult ar = place(new BlockPlaceContext(context));
            cir.setReturnValue(ar);
        }
    }

    @ModifyVariable(method = "use", at = @At(
            value = "STORE",
            target = "Lnet/minecraft/item/ItemStack;get(Lnet/minecraft/component/ComponentType;)Ljava/lang/Object;",
            shift = At.Shift.AFTER)
    )
    private FoodProperties bf_pumpkinPiePass(FoodProperties original) {
        if (original == Foods.PUMPKIN_PIE && BountifulFares.CONFIG.enablePlaceablePumpkinPie) {
            return null;
        }
        return original;
    }

    @Unique
    public InteractionResult place(BlockPlaceContext context) {
        if (!BFBlocks.PUMPKIN_PIE.isEnabled(context.getLevel().enabledFeatures())) {
            return InteractionResult.FAIL;
        } else if (!context.canPlace()) {
            return InteractionResult.FAIL;
        } else {
            BlockPlaceContext itemPlacementContext = context;
            if (itemPlacementContext == null) {
                return InteractionResult.FAIL;
            } else {
                BlockState blockState = BFBlocks.PUMPKIN_PIE.getStateForPlacement(context);
                if (blockState == null) {
                    return InteractionResult.FAIL;
                } else if (!context.getLevel().setBlock(context.getClickedPos(), blockState, 11)) {
                    return InteractionResult.FAIL;
                } else {
                    BlockPos blockPos = itemPlacementContext.getClickedPos();
                    Level world = itemPlacementContext.getLevel();
                    Player playerEntity = itemPlacementContext.getPlayer();
                    ItemStack itemStack = itemPlacementContext.getItemInHand();
                    BlockState blockState2 = world.getBlockState(blockPos);
                    SoundType blockSoundGroup = blockState2.getSoundType();
                    world.playSound(playerEntity, blockPos, BFBlocks.PUMPKIN_PIE.defaultBlockState().getSoundType().getBreakSound(), SoundSource.BLOCKS, (blockSoundGroup.getVolume() + 1.0F) / 2.0F, blockSoundGroup.getPitch() * 0.8F);
                    world.gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(playerEntity, blockState2));
                    itemStack.consume(1, playerEntity);
                    return InteractionResult.sidedSuccess(world.isClientSide);
                }
            }
        }
    }
}
