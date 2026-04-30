package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.definition.block.entity.CeramicChestBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.DyeableBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

import static net.hecco.bountifulfares.registry.content.BFBlockEntities.CERAMIC_CHEST_BLOCK_ENTITY;
import static net.hecco.bountifulfares.registry.content.BFBlockEntities.CERAMIC_TILES_BLOCK_ENTITY;

public class CeramicChestBlock extends ChestBlock implements EntityBlock {

    private static final DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>> MENU_PROVIDER_COMBINER = new DoubleBlockCombiner.Combiner<>() {
        public Optional<MenuProvider> acceptDouble(final ChestBlockEntity p_51604_, final ChestBlockEntity p_51605_) {
            final Container container = new CompoundContainer(p_51604_, p_51605_);
            return Optional.of(new MenuProvider() {
                @Override
                public AbstractContainerMenu createMenu(int p_51622_, Inventory p_51623_, Player p_51624_) {
                    if (p_51604_.canOpen(p_51624_) && p_51605_.canOpen(p_51624_)) {
                        p_51604_.unpackLootTable(p_51623_.player);
                        p_51605_.unpackLootTable(p_51623_.player);
                        return ChestMenu.sixRows(p_51622_, p_51623_, container);
                    } else {
                        return null;
                    }
                }

                @Override
                public Component getDisplayName() {
                    if (p_51604_.hasCustomName()) {
                        return p_51604_.getDisplayName();
                    } else {
                        return p_51605_.hasCustomName() ? p_51605_.getDisplayName() : Component.translatable("container.bountifulfares.large_ceramic_chest");
                    }
                }
            });
        }

        public Optional<MenuProvider> acceptSingle(ChestBlockEntity p_51602_) {
            return Optional.of(p_51602_);
        }

        public Optional<MenuProvider> acceptNone() {
            return Optional.empty();
        }
    };

    @Nullable
    public Direction candidatePartnerFacing(BlockPlaceContext context, Direction direction) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().relative(direction));
        ItemStack clickedStack = context.getItemInHand();
        return blockstate.is(this) && blockstate.getValue(TYPE) == ChestType.SINGLE && context.getLevel().getBlockEntity(context.getClickedPos().relative(direction)) instanceof CeramicChestBlockEntity entity && entity.color == Objects.requireNonNullElse(clickedStack.get(DataComponents.DYED_COLOR), new DyedItemColor(DyeableBlockEntity.DEFAULT_COLOR, false)).rgb() ? blockstate.getValue(FACING) : null;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return DyeableCeramicBlock.onUseForChest(stack, state, world, pos, player, hand, (CeramicChestBlock) state.getBlock(), this);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        ChestType chesttype = ChestType.SINGLE;
        Direction direction = context.getHorizontalDirection().getOpposite();
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean flag = context.isSecondaryUseActive();
        Direction direction1 = context.getClickedFace();
        if (direction1.getAxis().isHorizontal() && flag) {
            Direction direction2 = this.candidatePartnerFacing(context, direction1.getOpposite());
            if (direction2 != null && direction2.getAxis() != direction1.getAxis()) {
                direction = direction2;
                chesttype = direction2.getCounterClockWise() == direction1.getOpposite() ? ChestType.RIGHT : ChestType.LEFT;
            }
        }

        if (chesttype == ChestType.SINGLE && !flag) {
            if (direction == this.candidatePartnerFacing(context, direction.getClockWise())) {
                chesttype = ChestType.LEFT;
            } else if (direction == this.candidatePartnerFacing(context, direction.getCounterClockWise())) {
                chesttype = ChestType.RIGHT;
            }
        }

        return this.defaultBlockState().setValue(FACING, direction).setValue(TYPE, chesttype).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    public CeramicChestBlock(Properties properties) {
        super(properties, () -> BFBlockEntities.CERAMIC_CHEST_BLOCK_ENTITY.get());
    }

    @Override
    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return this.combine(state, level, pos, false).apply(MENU_PROVIDER_COMBINER).orElse(null);
    }

    public static BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CeramicChestBlockEntity(pos, state);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return CeramicChestBlock.createBlockEntity(pos, state);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        if (DyeableCeramicBlockEntity.getColor(world, pos) != CeramicChestBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = new ItemStack(state.getBlock());
            CeramicChestBlockEntity blockEntity = CERAMIC_CHEST_BLOCK_ENTITY.get().getBlockEntity(world,pos);
            int color;
            if(blockEntity != null){
                color = blockEntity.color;
            } else {
                color = CeramicChestBlockEntity.DEFAULT_COLOR;
            }
            stack.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));
            return stack;
        } else {
            return new ItemStack(state.getBlock());
        }
    }
}
