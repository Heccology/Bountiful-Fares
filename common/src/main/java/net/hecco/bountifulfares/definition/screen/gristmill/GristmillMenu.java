package net.hecco.bountifulfares.definition.screen.gristmill;

import net.hecco.bountifulfares.definition.block.entity.GristmillBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.slot.GristmillOutputSlot;
import net.hecco.bountifulfares.definition.recipe.MillingRecipe;
import net.hecco.bountifulfares.registry.content.BFMenus;
import net.hecco.bountifulfares.registry.misc.BFRecipeBookTypes;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class GristmillMenu extends RecipeBookMenu<SingleRecipeInput, MillingRecipe> {
    private static final int INVENTORY_SIZE = 2; // todo: set to 3 when adding new slot

    protected final Level level;
    protected final Player player;
    private final Container inventory;
    public final ContainerData propertyDelegate;

    public GristmillMenu(int syncId, Inventory playerInventory) {
        this(syncId, playerInventory, new SimpleContainer(INVENTORY_SIZE), new SimpleContainerData(INVENTORY_SIZE));
    }

    public boolean isCrafting() {
        return this.propertyDelegate.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 35;

        return (int) (((float) progress / (float) maxProgress) * progressArrowSize);
    }

    public GristmillMenu(int syncId, Inventory playerInventory, Container inventory, ContainerData propertyDelegate) {
        super(BFMenus.GRISTMILL_SCREEN_HANDLER.get(), syncId);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.player = playerInventory.player;
        this.level = this.player.level();
        this.addSlot(new Slot(inventory, 0, 44, 36));
        this.addSlot(new GristmillOutputSlot(inventory, 1, 116, 36));

        checkContainerSize(this.inventory, INVENTORY_SIZE);
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
        addDataSlots(propertyDelegate);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasItem()) {
            ItemStack originalStack = slot.getItem();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.getContainerSize()) {
                if (!this.moveItemStackTo(originalStack, this.inventory.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(originalStack, 0, this.inventory.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return newStack;
    }


    @Override
    public boolean stillValid(Player player) {
        return this.inventory.stillValid(player);
    }


    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    /////////// RECIPE BOOK METHODS BELOW ///////////

    @Override
    public void fillCraftSlotsStackedContents(StackedContents itemHelper) {
        if (this.inventory instanceof StackedContentsCompatible stacker) stacker.fillStackedContents(itemHelper);
    }

    @Override public void clearCraftingContent() { this.inventory.clearContent(); }
    @Override public boolean recipeMatches(RecipeHolder recipe) { return ((MillingRecipe)recipe.value()).matches(new SingleRecipeInput(this.inventory.getItem(0)), this.level); }
    @Override public int getResultSlotIndex() { return GristmillBlockEntity.PRIMARY_SLOT; }
    @Override public int getGridWidth() { return 1; }
    @Override public int getGridHeight() { return 1; }
    @Override public int getSize() { return INVENTORY_SIZE; }
    @Override public RecipeBookType getRecipeBookType() { return BFRecipeBookTypes.BF_GRISTMILL; }
    @Override public boolean shouldMoveToInventory(int i) { return true; }
}