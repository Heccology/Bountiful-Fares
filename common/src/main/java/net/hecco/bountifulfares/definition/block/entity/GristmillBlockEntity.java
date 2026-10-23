package net.hecco.bountifulfares.definition.block.entity;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.hecco.bountifulfares.definition.block.custom.GristmillBlock;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.definition.recipe.MillingRecipe;
import net.hecco.bountifulfares.definition.screen.gristmill.GristmillMenu;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class GristmillBlockEntity extends BlockEntity implements MenuProvider, WorldlyContainer, RecipeCraftingHolder, ImplementedInventory, StackedContentsCompatible {
    private static BooleanProperty millingState;
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(3, ItemStack.EMPTY);

    public static final int INPUT_SLOT = 0;
    public static final int PRIMARY_SLOT = 1;
    public static final int SECONDARY_SLOT = 2;
    private static final int[] TOP_SLOTS = new int[]{INPUT_SLOT};
    private static final int[] BOTTOM_SLOTS = new int[]{PRIMARY_SLOT, SECONDARY_SLOT};

    private static final String PROGRESS_NBT = "Progress";
    private static final String RECIPES_NBT = "RecipesUsed";

    public final ContainerData propertyDelegate;
    private int progress = 0;
    private int maxProgress = 80;

    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed;
    private final RecipeManager.CachedCheck<SingleRecipeInput, MillingRecipe> quickCheck;

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

        this.recipesUsed = new Object2IntOpenHashMap<>();
        this.quickCheck = RecipeManager.createCheck(BFRecipes.MILLING.get());
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
    public void loadAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        super.loadAdditional(nbt, registryLookup);
        ContainerHelper.loadAllItems(nbt, inventory, registryLookup);
        progress = nbt.getInt(PROGRESS_NBT);

        CompoundTag compoundtag = nbt.getCompound(RECIPES_NBT);
        for (String key : compoundtag.getAllKeys()) {
            this.recipesUsed.put(ResourceLocation.parse(key), compoundtag.getInt(key));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        super.saveAdditional(nbt, registryLookup);
        ContainerHelper.saveAllItems(nbt, inventory, registryLookup);
        nbt.putInt(PROGRESS_NBT, progress);

        CompoundTag tag1 = new CompoundTag();
        this.recipesUsed.forEach((rsc, ing) -> tag1.putInt(rsc.toString(), ing));
        nbt.put(RECIPES_NBT, tag1);
    }

    public void tick(Level world, BlockPos pos, BlockState state, GristmillBlockEntity blockEntity) {
        RecipeHolder<MillingRecipe> rec = blockEntity.quickCheck.getRecipeFor(new SingleRecipeInput(blockEntity.getItem(INPUT_SLOT)), level).orElse(null);

        if (Services.PLATFORM.get().getIntConfigValue("millingTime") * 20 != this.maxProgress) {
            this.maxProgress = Services.PLATFORM.get().getIntConfigValue("millingTime") * 20;
        }
        if (!state.getValue(millingState) && !blockEntity.inventory.get(INPUT_SLOT).isEmpty() && blockEntity.hasRecipe(rec)) {
            world.setBlockAndUpdate(pos, state.setValue(millingState, true));
        }
        if (state.getValue(millingState) && !blockEntity.hasRecipe(rec)) {
            world.setBlockAndUpdate(pos, state.setValue(millingState, false));
        }

        if (this.hasRecipe(rec)) {
            this.increaseCraftingProgress();
            setChanged(world, pos, state);
            if (this.hasCraftingFinished()) {
                this.craftItem(rec);
                this.resetCraftingProgress();
            }
        } else {
            this.decreaseCraftingProgress();
        }
    }

    private boolean hasRecipe(RecipeHolder<MillingRecipe> recipe) {
        if (recipe == null) return false;
        ItemStack primary = recipe.value().getPrimary();
        ItemStack secondary = recipe.value().getSecondary();

        if (secondary.isEmpty()) {
            return (
                    canInsertAmountIntoOutputSlot(PRIMARY_SLOT, primary.getCount()) && canInsertItemIntoOutputSlot(PRIMARY_SLOT, primary)
            );
        }
        else {
            return (
                    (canInsertAmountIntoOutputSlot(PRIMARY_SLOT, primary.getCount()) && canInsertItemIntoOutputSlot(PRIMARY_SLOT, primary))
                    && (canInsertAmountIntoOutputSlot(SECONDARY_SLOT, secondary.getCount()) && canInsertItemIntoOutputSlot(SECONDARY_SLOT, secondary))
            );
        }
    }

    private void craftItem(RecipeHolder<MillingRecipe> recipe) {
        if (recipe == null) throw new IllegalArgumentException("Provided a null recipe holder?!");

        this.removeItem(INPUT_SLOT, 1);

        ItemStack i = recipe.value().getPrimary();
        i.grow(inventory.get(PRIMARY_SLOT).getCount());
        this.setItem(PRIMARY_SLOT, i);

        i = recipe.value().getSecondary();
        if (!i.isEmpty()) {
            i.grow(inventory.get(SECONDARY_SLOT).getCount());
            this.setItem(SECONDARY_SLOT, i);
        }

        this.setRecipeUsed(recipe);
        this.setChanged();
    }

    private boolean canInsertItemIntoOutputSlot(int slot, ItemStack output) {
        return this.getItem(slot).isEmpty() || this.getItem(slot).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int slot, int count) {
        return this.getItem(slot).isEmpty() || this.getItem(slot).getMaxStackSize() >= this.getItem(slot).getCount() + count;
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
        if (this.progress > 0) this.progress -= 2;
        if (this.progress < 0) this.progress = 0;
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

    @Override
    public void setRecipeUsed(@Nullable RecipeHolder<?> recipe) {
        if (recipe != null) {
            ResourceLocation resourcelocation = recipe.id();
            this.recipesUsed.addTo(resourcelocation, 1);
        }
    }

    @Override
    public @Nullable RecipeHolder<?> getRecipeUsed() {
        return null;
    }

    public void awardUsedRecipes(Player player, List<ItemStack> items) {
    }
}
