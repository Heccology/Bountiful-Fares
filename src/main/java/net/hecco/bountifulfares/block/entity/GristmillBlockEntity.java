package net.hecco.bountifulfares.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.hecco.bountifulfares.block.custom.GristmillBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GristmillBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {

    private static BooleanProperty millingState;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    private static final int[] TOP_SLOTS = new int[]{0};
    private static final int[] BOTTOM_SLOTS = new int[]{1};
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 80;
    public GristmillBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.GRISTMILL_BLOCK_ENTITY, pos, state);
        millingState = ((GristmillBlock)state.getBlock()).getMillingState();
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
                    case 0: GristmillBlockEntity.this.progress = value;
                    case 1: GristmillBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

//    @Override
//    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
//        buf.writeBlockPos(this.pos);
//    }



    @Override
    public Text getDisplayName() {
        return Text.translatable("block.bountifulfares.gristmill");
    }

//    @Nullable
//    @Override
//    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
//        return new GristmillScreenHandler(syncId, playerInventory, this, propertyDelegate);
//    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }


    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("milling.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        nbt.getInt("milling.progress");
        super.readNbt(nbt, registryLookup);
    }

//    private boolean isCrafting() {
//        return hasRecipe() && canInsertOutputSlot();
//    }
//
//    public void tick(World world, BlockPos pos, BlockState state) {
//        if (!world.isClient) {
//            if (this.maxProgress != (BountifulFares.CONFIG.getMillingTime() * 20)) {
//                this.maxProgress = BountifulFares.CONFIG.getMillingTime() * 20;
//            }
////        Updates the block state based on if it is milling
//            if (!state.get(millingState) && !inventory.get(0).isEmpty() && isCrafting()) {
//                world.setBlockState(pos, state.with(millingState, true));
//            }
//            if (state.get(millingState) && !hasRecipe() && progress != 0) {
//                world.setBlockState(pos, state.with(millingState, false));
//            }
//            if (canInsertOutputSlot() && hasRecipe()) {
//                increaseCraftingProgress();
//                markDirty(world, pos, state);
//                if (hasCraftingFinished()) {
//                    craftItem();
//                    resetProgress();
//                }
//            } else {
//                decreaseCraftingProgress();
//            }
//        }
//    }
//
//    private void resetProgress() {
//        this.progress = 1;
//    }
//
//    private void craftItem() {
//        Optional<RecipeEntry<Recipe<?>>> recipe = getCurrentRecipe();
//
//        this.removeStack(INPUT_SLOT, 1);
//        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getOutput().getItem(),
//                this.getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getOutput().getCount()));
//    }
//
//    private boolean hasCraftingFinished() {
//        return this.progress >= this.maxProgress;
//    }
//
//    private void increaseCraftingProgress() {
//        this.progress++;
//    }
//    private void decreaseCraftingProgress() {
//        if (this.progress > 0) {
//            this.progress -= 2;
//        }
//    }
//    private boolean hasRecipe() {
//        Optional<RecipeEntry<Recipe<?>>> recipe = getCurrentRecipe();
//
//        if (recipe.isEmpty()) return false;
//        ItemStack output = recipe.get().value().getOutput();
//
//        return canInsertAmountIntoOutputSlot(output.getCount())
//                && canInsertItemIntoOutputSlot(output);
//    }
//
//    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
//        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
//    }
//
//    private boolean canInsertAmountIntoOutputSlot(int count) {
//        return this.getStack(OUTPUT_SLOT).getMaxCount() >= this.getStack(OUTPUT_SLOT).getCount() + count;
//    }
//
//    @Override
//    public int[] getAvailableSlots(Direction side) {
//        if (side == Direction.DOWN) {
//            return BOTTOM_SLOTS;
//        }
//        if (side == Direction.UP) {
//            return TOP_SLOTS;
//        }
//        return TOP_SLOTS;
//    }
//
//    private Optional<RecipeEntry<Recipe<?>>> getCurrentRecipe() {
//        SimpleInventory inventory = new SimpleInventory(this.size());
//        for (int i = 0; i < this.size(); i++) {
//            inventory.setStack(i, this.getStack(i));
//        }
//        return Objects.requireNonNull(this.getWorld()).getRecipeManager().getFirstMatch(BFRecipes.MILLING, inventory, this.getWorld());
//    }
//
//    private boolean canInsertOutputSlot() {
//        return this.getStack(OUTPUT_SLOT).isEmpty() ||
//                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
//    }
//
    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return null;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return null;
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, GristmillBlockEntity gristmillBlockEntity) {
    }
}
