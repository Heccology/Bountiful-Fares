//package net.hecco.bountifulfares.screen;
//
//import net.hecco.bountifulfares.block.entity.slot.GristmillOutputSlot;
//import net.hecco.bountifulfares.registry.misc.BFScreenHandlers;
//import net.minecraft.world.Container;
//import net.minecraft.world.SimpleContainer;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.inventory.ContainerData;
//import net.minecraft.world.inventory.SimpleContainerData;
//import net.minecraft.world.inventory.Slot;
//import net.minecraft.world.item.ItemStack;
//
//public class GristmillScreenHandler extends AbstractContainerMenu { //TODO: FIX
//
//    private final Container inventory;
//    public final ContainerData propertyDelegate;
//
//
//    public boolean isCrafting() {
//        return this.propertyDelegate.get(0) > 0;
//    }
//
//    public int getScaledProgress() {
//        int progress = this.propertyDelegate.get(0);
//        int maxProgress = this.propertyDelegate.get(1);
//        int progressArrowSize = 35;
//
//        int scaledProgress = (int) (((float) progress / (float) maxProgress) * progressArrowSize);
//        return scaledProgress;
//    }
//
//    public GristmillScreenHandler(int syncId, Inventory playerInventory) {
//        this(syncId, playerInventory, new SimpleContainer(2), new SimpleContainerData(2));
//    }
//
//    public GristmillScreenHandler(int syncId, Inventory playerInventory, Container inventory, ContainerData propertyDelegate) {
//        super(BFScreenHandlers.GRISTMILL_SCREEN_HANDLER, syncId);
////        checkSize(((Inventory) blockEntity), 2);
//        this.inventory = inventory;
//        this.propertyDelegate = propertyDelegate;
//        this.addSlot(new Slot(inventory, 0, 44, 36));
//        this.addSlot(new GristmillOutputSlot(inventory, 1, 116, 36));
//
//        addPlayerInventory(playerInventory);
//        addPlayerHotbar(playerInventory);
//        addDataSlots(propertyDelegate);
//    }
//
//    @Override
//    public ItemStack quickMoveStack(Player player, int invSlot) {
//        ItemStack newStack = ItemStack.EMPTY;
//        Slot slot = this.slots.get(invSlot);
//        if (slot.hasItem()) {
//            ItemStack originalStack = slot.getItem();
//            newStack = originalStack.copy();
//            if (invSlot < this.inventory.getContainerSize()) {
//                if (!this.moveItemStackTo(originalStack, this.inventory.getContainerSize(), this.slots.size(), true)) {
//                    return ItemStack.EMPTY;
//                }
//            } else if (!this.moveItemStackTo(originalStack, 0, this.inventory.getContainerSize(), false)) {
//                return ItemStack.EMPTY;
//            }
//
//            if (originalStack.isEmpty()) {
//                slot.setByPlayer(ItemStack.EMPTY);
//            } else {
//                slot.setChanged();
//            }
//        }
//        return newStack;
//    }
//    @Override
//    public boolean stillValid(Player player) {
//        return this.inventory.stillValid(player);
//
//    }
//    private void addPlayerInventory(Inventory playerInventory) {
//        for (int i = 0; i < 3; ++i) {
//            for (int l = 0; l < 9; ++l) {
//                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
//            }
//        }
//    }
//
//    private void addPlayerHotbar(Inventory playerInventory) {
//        for (int i = 0; i < 9; ++i) {
//            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
//        }
//    }
//}