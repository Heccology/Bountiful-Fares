package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.GristmillBlock;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.hecco.bountifulfares.screen.GristmillScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeInputProvider;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GristmillBlockEntity extends BlockEntity implements SidedInventory, ImplementedInventory, NamedScreenHandlerFactory, RecipeInputProvider {
    private static BooleanProperty millingState;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    private static final int[] TOP_SLOTS = new int[]{0};
    private static final int[] BOTTOM_SLOTS = new int[]{1};
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    public final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 80;
    public GristmillBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.GRISTMILL_BLOCK_ENTITY, pos, state);
        millingState = ((GristmillBlock) state.getBlock()).getMillingState();
        this.propertyDelegate = new PropertyDelegate() {
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
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

//
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("milling.progress", progress);
    }
    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("milling.progress");
        super.readNbt(nbt, registryLookup);
    }

    public void tick(World world, BlockPos pos, BlockState state, GristmillBlockEntity blockEntity) {
        if (BountifulFares.CONFIG.getMillingTime() * 20 != this.maxProgress) {
            this.maxProgress = BountifulFares.CONFIG.getMillingTime() * 20;
        }
        //BountifulFares.LOGGER.info(state.get(millingState) + "" + !blockEntity.hasRecipe() + (blockEntity.progress != 0));
        if (!state.get(millingState) && !blockEntity.inventory.get(0).isEmpty() && blockEntity.hasRecipe() && blockEntity.canInsertOutputSlot()) {
            world.setBlockState(pos, state.with(millingState, true));
        }
        if (state.get(millingState) && !blockEntity.hasRecipe()) {
            world.setBlockState(pos, state.with(millingState, false));
        }

        if (this.progress == -1) {
            this.progress = 20;
        }
        if (!world.isClient()) {
            if (this.canInsertOutputSlot() && this.hasRecipe()) {
                this.increaseCraftingProgress();
                markDirty(world, pos, state);
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
        Optional<RecipeEntry<MillingRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) return false;
        ItemStack output = recipe.get().value().getOutput();
        return canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output);
    }

    private void craftItem() {
        Optional<RecipeEntry<MillingRecipe>> recipe = getCurrentRecipe();
        this.removeStack(INPUT_SLOT, 1);
        ItemStack i = recipe.get().value().getOutput();
        i.increment(inventory.get(OUTPUT_SLOT).getCount());
        this.setStack(OUTPUT_SLOT, i);
        this.markDirty();
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getMaxCount() >= this.getStack(OUTPUT_SLOT).getCount() + count;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) {
            return BOTTOM_SLOTS;
        }
        if (side == Direction.UP) {
            return TOP_SLOTS;
        }
        return TOP_SLOTS;
    }

    private Optional<RecipeEntry<MillingRecipe>> getCurrentRecipe() {
        if (this.getWorld() != null) {
            return this.getWorld()
                    .getRecipeManager()
                    .getFirstMatch(BFRecipes.MILLING, new SingleStackRecipeInput(this.inventory.get(INPUT_SLOT)), this.world);
        } else {
            return Optional.empty();
        }
    }

    private boolean canInsertOutputSlot() {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
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
    public Text getDisplayName() {
        return Text.translatable("bountifulfares.milling");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GristmillScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public void provideRecipeInputs(RecipeMatcher finder) {
        for(ItemStack itemStack : this.inventory) {
            finder.addInput(itemStack);
        }
    }
}
