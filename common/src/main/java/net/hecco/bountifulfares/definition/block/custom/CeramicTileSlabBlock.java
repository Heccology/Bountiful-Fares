package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.definition.block.entity.DyeableCeramicBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.FastColor;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class CeramicTileSlabBlock extends SlabBlock implements EntityBlock {
    public CeramicTileSlabBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, false));
    }
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.createBlockEntity(pos, state);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        return DyeableCeramicBlock.onUse(stack, state, world, pos, player, hand, state.getBlock());
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return super.canBeReplaced(state, context) && DyedItemColor.getOrDefault(context.getItemInHand(), DyeableCeramicBlockEntity.DEFAULT_COLOR) == FastColor.ARGB32.opaque(DyeableCeramicBlockEntity.getColor(context.getLevel(), context.getClickedPos()));
    }
}
