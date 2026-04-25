package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.definition.block.entity.CeramicChestBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

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
        return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return DyeableCeramicBlock.onUse(stack, state, world, pos, player, hand, state.getBlock());
    }
}
