package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.SlabType;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class CeramicTileSlabBlock extends SlabBlock implements BlockEntityProvider {
    public CeramicTileSlabBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(TYPE, SlabType.BOTTOM).with(WATERLOGGED, false));
    }
    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.createBlockEntity(pos, state);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        return DyeableCeramicBlock.onUse(stack, state, world, pos, player, hand, state.getBlock());
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return super.canReplace(state, context) && DyedColorComponent.getColor(context.getStack(), DyeableCeramicBlockEntity.DEFAULT_COLOR) == ColorHelper.Argb.fullAlpha(DyeableCeramicBlockEntity.getColor(context.getWorld(), context.getBlockPos()));
    }
}
