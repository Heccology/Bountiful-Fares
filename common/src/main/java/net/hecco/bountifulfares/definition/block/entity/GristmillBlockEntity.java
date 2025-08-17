package net.hecco.bountifulfares.definition.block.entity;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.custom.GristmillBlock;
import net.hecco.bountifulfares.definition.recipe.MillingRecipe;
import net.hecco.bountifulfares.definition.screen.GristmillMenu;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GristmillBlockEntity extends BlockEntity implements WorldlyContainer, ImplementedInventory, MenuProvider, StackedContentsCompatible {
    private static BooleanProperty millingState;
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(2, ItemStack.EMPTY);

    private static final int[] TOP_SLOTS = new int[]{0};
    private static final int[] BOTTOM_SLOTS = new int[]{1};
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    public final ContainerData propertyDelegate;
    private int progress = 0;
    private int maxProgress = 80;
    public GristmillBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.GRISTMILL_BLOCK_ENTITY.get(), pos, state);
        millingState = ((GristmillBlock) state.getBlock()).getMillingState();
        this.propertyDelegate = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> GristmillBlockEntity.this.progress;
                    case 1 -> GristmillBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> GristmillBlockEntity.this.progress = value;
                    case 1 -> GristmillBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.inventory;
    }


    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        super.saveAdditional(nbt, registryLookup);
        ContainerHelper.saveAllItems(nbt, inventory, registryLookup);
        nbt.putInt("milling.progress", progress);
    }
    @Override
    public void loadAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        ContainerHelper.loadAllItems(nbt, inventory, registryLookup);
        progress = nbt.getInt("milling.progress");
        super.loadAdditional(nbt, registryLookup);
    }

    public void tick(Level world, BlockPos pos, BlockState state, GristmillBlockEntity blockEntity) {
        if (BountifulFares.CONFIG.getMillingTime() * 20 != this.maxProgress) {
            this.maxProgress = BountifulFares.CONFIG.getMillingTime() * 20;
        }
        if (!state.getValue(millingState) && !blockEntity.inventory.get(0).isEmpty() && blockEntity.hasRecipe() && blockEntity.canInsertOutputSlot()) {
            world.setBlockAndUpdate(pos, state.setValue(millingState, true));
        }
        if (state.getValue(millingState) && !blockEntity.hasRecipe()) {
            world.setBlockAndUpdate(pos, state.setValue(millingState, false));
        }

        if (this.progress == -1) {
            this.progress = 20;
        }
        if (!world.isClientSide()) {
            if (this.canInsertOutputSlot() && this.hasRecipe()) {
                this.increaseCraftingProgress();
                setChanged(world, pos, state);
                if (this.hasCraftingFinished()) {
                    this.craftItem();
                    this.resetCraftingProgress();
                }
            } else {
                this.decreaseCraftingProgress();
            }
        }
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<MillingRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) return false;
        ItemStack output = recipe.get().value().getOutput();
        return canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output);
    }

    private void craftItem() {
        Optional<RecipeHolder<MillingRecipe>> recipe = getCurrentRecipe();
        this.removeItem(INPUT_SLOT, 1);
        ItemStack i = recipe.get().value().getOutput();
        i.grow(inventory.get(OUTPUT_SLOT).getCount());
        this.setItem(OUTPUT_SLOT, i);
        this.setChanged();
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getItem(OUTPUT_SLOT).isEmpty() || this.getItem(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getItem(OUTPUT_SLOT).isEmpty() || this.getItem(OUTPUT_SLOT).getMaxStackSize() >= this.getItem(OUTPUT_SLOT).getCount() + count;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return BOTTOM_SLOTS;
        }
        if (side == Direction.UP) {
            return TOP_SLOTS;
        }
        return TOP_SLOTS;
    }

    private Optional<RecipeHolder<MillingRecipe>> getCurrentRecipe() {
        if (this.getLevel() != null) {
            return this.getLevel()
                    .getRecipeManager()
                    .getRecipeFor(BFRecipes.MILLING.get(), new SingleRecipeInput(this.inventory.getFirst()), this.level);
        } else {
            return Optional.empty();
        }
    }

    private boolean canInsertOutputSlot() {
        return this.getItem(OUTPUT_SLOT).isEmpty() ||
                this.getItem(OUTPUT_SLOT).getCount() < this.getItem(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private void resetCraftingProgress() {
        this.progress = 0;
    }

    private void decreaseCraftingProgress() {
        if (this.progress > 0) {
            this.progress -= 2;
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("bountifulfares.milling");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int syncId, Inventory playerInventory, Player player) {
        return new GristmillMenu(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void fillStackedContents(StackedContents finder) {
        for(ItemStack itemStack : this.inventory) {
            finder.accountStack(itemStack);
        }
    }
}
