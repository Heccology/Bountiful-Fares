package net.hecco.bountifulfares.definition.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.entity.DyeableBlockEntity;
import net.hecco.bountifulfares.definition.networking.payload.EmptyPayload;
import net.hecco.bountifulfares.definition.trigger.UseArtisanBrushInInventoryTrigger;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.misc.BFCriteriaTriggers;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Optional;

public class ArtisanBrushItem extends Item {
    public static int DEFAULT_COLOR = DyeableBlockEntity.DEFAULT_COLOR;
    public ArtisanBrushItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level world = context.getLevel();
        Player player = context.getPlayer();
        BlockState current = world.getBlockState(pos);
        int oldColor = DyeableBlockEntity.getColor(world, pos);
        DyedItemColor component = context.getItemInHand().get(DataComponents.DYED_COLOR);
        if (BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.containsKey(current.getBlock()) && DyeableBlockEntity.getColor(world, pos) != DyeableBlockEntity.DEFAULT_COLOR) {
            if ((component != null ? component.rgb() : DEFAULT_COLOR) == DyeableBlockEntity.getColor(world, pos)) {
                    world.setBlockAndUpdate(pos, BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.get(current.getBlock()).withPropertiesOf(current));
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (world.getBlockEntity(pos) instanceof DyeableBlockEntity ceramicTilesBlockEntity) {
                    ceramicTilesBlockEntity.color = oldColor;
                    ceramicTilesBlockEntity.setChanged();
                    return InteractionResult.SUCCESS;
                }
            }
        }
        if (world.getBlockEntity(pos) instanceof DyeableBlockEntity && DyeableBlockEntity.getColor(world, pos) != DyeableBlockEntity.DEFAULT_COLOR) {
            if (world.getBlockEntity(pos) instanceof DyeableBlockEntity) {
                if (DyedItemColor.getOrDefault(context.getItemInHand(), DEFAULT_COLOR) != DyeableBlockEntity.getColor(world, pos)) {
                    context.getItemInHand().set(DataComponents.DYED_COLOR, new DyedItemColor(DyeableBlockEntity.getColor(world, pos), true));
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return super.useOn(context);
    }
//        if (ModBlocks.CERAMIC_TO_CHECKERED_CERAMIC.containsKey(current.getBlock()) && Objects.requireNonNull(context.getPlayer()).isSneaking()) {
//            if (world.getBlockEntity(pos) instanceof DyeableBlockEntity ceramicTilesBlockEntity && ceramicTilesBlockEntity.color != DyeableBlockEntity.DEFAULT_COLOR) {
//                int oldColor = DyeableBlockEntity.getColor(world, pos);
//                world.setBlockState(pos, ModBlocks.CERAMIC_TO_CHECKERED_CERAMIC.get(current.getBlock()).getStateWithProperties(current));
//                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat());
//                ceramicTilesBlockEntity.color = oldColor;
//                ceramicTilesBlockEntity.markDirty();
//                return ActionResult.SUCCESS;
//            }
//        }
//        return super.useOnBlock(context);
//    }


    @Override
    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction action, Player player) {
        if (action == ClickAction.SECONDARY && slot.allowModification(player)) {
            ItemStack other = slot.getItem();
            if ((other.has(DataComponents.DYED_COLOR) || (other.getItem() instanceof ArmorItem armorItem && (armorItem.getMaterial() == ArmorMaterials.LEATHER || armorItem.getMaterial() == ArmorMaterials.ARMADILLO)) || other.is(BFItemTags.DYEABLE_CERAMIC_BLOCKS)) && stack.has(DataComponents.DYED_COLOR)) {
                other.set(DataComponents.DYED_COLOR, stack.get(DataComponents.DYED_COLOR));
                player.playSound(SoundEvents.DYE_USE, 0.9F, 1.0f);
                if (other.is(BFItemTags.DYEABLE_CERAMIC_BLOCKS)) {
                    NLServices.NETWORK.sentToServer(new EmptyPayload());
                }
                return true;
            }
        }
        return super.overrideStackedOnOther(stack, slot, action, player);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
        if (!stack.getComponents().has(DataComponents.DYED_COLOR)) {
            tooltip.add(Component.translatable("tooltip." + BountifulFares.MOD_ID + ".dyeable").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
        super.appendHoverText(stack, context, tooltip, type);
    }
}
