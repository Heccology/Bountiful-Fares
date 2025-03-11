package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class CeramicDishBlockEntity extends DyeableBlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    public CeramicDishBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    public boolean canInsertItem() {
        return this.getStack(0).isEmpty();
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, inventory, registryLookup);
        super.writeNbt(nbt, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        super.readNbt(nbt, registryLookup);
    }

    public void insertItem(ItemStack item) {
        assert world != null;
        this.setStack(0, item.copyWithCount(1));
        markDirty();
    }

    public void removeItem() {
        assert world != null;
        this.setStack(0, Items.AIR.getDefaultStack());
        markDirty();
    }

    public static int getColor(BlockView world, BlockPos pos){
        if(world==null){
            return CeramicDishBlockEntity.DEFAULT_COLOR;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof CeramicDishBlockEntity ceramicDishBlockEntity){
            return ceramicDishBlockEntity.color;
        } else {
            return CeramicDishBlockEntity.DEFAULT_COLOR;
        }
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        return this.inventory.get(0).isEmpty();
    }

    public void setInventory(DefaultedList<ItemStack> list) {
        this.inventory.set(0, list.get(0));
    }

    public ItemStack getRenderStack() {
        return this.getStack(0);
    }

//    @Override
//    public void markDirty() {
//        if (!world.isClient()) {
//            PacketByteBuf data = PacketByteBufs.create();
//            data.writeInt(inventory.size());
//            for (int i = 0; i < inventory.size(); i++) {
//                data.writeItemStack(inventory.get(i));
//            }
//            data.writeBlockPos(getPos());
//            PacketByteBuf colorData = PacketByteBufs.create();
//            colorData.writeInt(color);
//            colorData.writeBlockPos(getPos());
//            for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
//                ServerPlayNetworking.send(player, BFMessages.CERAMIC_DISH_ITEM_SYNC, data);
//                ServerPlayNetworking.send(player, BFMessages.CERAMIC_COLOR_SYNC, colorData);
//            }
//        }
//        super.markDirty();
//    }
}
