package net.hecco.bountifulfares.mixin.gameplay;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class PumpkinPieItemMixin {

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    public void bf_useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        if (context.getStack().isOf(Items.PUMPKIN_PIE) && BountifulFares.CONFIG.enablePlaceablePumpkinPie) {
            ActionResult ar = place(new ItemPlacementContext(context));
            cir.setReturnValue(ar);
        }
    }

    @ModifyVariable(method = "use", at = @At(
            value = "STORE",
            target = "Lnet/minecraft/item/ItemStack;get(Lnet/minecraft/component/ComponentType;)Ljava/lang/Object;",
            shift = At.Shift.AFTER)
    )
    private FoodComponent bf_pumpkinPiePass(FoodComponent original) {
        if (original == FoodComponents.PUMPKIN_PIE && BountifulFares.CONFIG.enablePlaceablePumpkinPie) {
            return null;
        }
        return original;
    }

    @Unique
    public ActionResult place(ItemPlacementContext context) {
        if (!BFBlocks.PUMPKIN_PIE.isEnabled(context.getWorld().getEnabledFeatures())) {
            return ActionResult.FAIL;
        } else if (!context.canPlace()) {
            return ActionResult.FAIL;
        } else {
            ItemPlacementContext itemPlacementContext = context;
            if (itemPlacementContext == null) {
                return ActionResult.FAIL;
            } else {
                BlockState blockState = BFBlocks.PUMPKIN_PIE.getPlacementState(context);
                if (blockState == null) {
                    return ActionResult.FAIL;
                } else if (!context.getWorld().setBlockState(context.getBlockPos(), blockState, 11)) {
                    return ActionResult.FAIL;
                } else {
                    BlockPos blockPos = itemPlacementContext.getBlockPos();
                    World world = itemPlacementContext.getWorld();
                    PlayerEntity playerEntity = itemPlacementContext.getPlayer();
                    ItemStack itemStack = itemPlacementContext.getStack();
                    BlockState blockState2 = world.getBlockState(blockPos);
                    BlockSoundGroup blockSoundGroup = blockState2.getSoundGroup();
                    world.playSound(playerEntity, blockPos, BFBlocks.PUMPKIN_PIE.getDefaultState().getSoundGroup().getBreakSound(), SoundCategory.BLOCKS, (blockSoundGroup.getVolume() + 1.0F) / 2.0F, blockSoundGroup.getPitch() * 0.8F);
                    world.emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(playerEntity, blockState2));
                    itemStack.decrementUnlessCreative(1, playerEntity);
                    return ActionResult.success(world.isClient);
                }
            }
        }
    }
}
