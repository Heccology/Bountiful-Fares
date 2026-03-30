package net.hecco.bountifulfares.definition.item.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.definition.item.custom.TiffinItem;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public class TiffinContents implements TooltipComponent {
    public static final Codec<TiffinContents> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ItemStack.OPTIONAL_CODEC.fieldOf("item").forGetter(t -> t.item)
    ).apply(instance, TiffinContents::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, TiffinContents> STREAM_CODEC = StreamCodec.composite(ItemStack.STREAM_CODEC, contents -> contents.item, TiffinContents::new);
    public final int CAPACITY = 64;
    final ItemStack item;

    public TiffinContents(ItemStack item) {
        this.item = item == null ? ItemStack.EMPTY : item;
//        this.CAPACITY = !item.isEmpty() ? item.getItem().getDefaultMaxStackSize() == 1 ? 1 : Math.min(item.getItem().getDefaultMaxStackSize() * 2, 64) : 32;
    }

    public TiffinContents() {
        this.item = ItemStack.EMPTY;
//        this.CAPACITY = !item.isEmpty() ? item.getItem().getDefaultMaxStackSize() == 1 ? 1 : Math.min(item.getItem().getDefaultMaxStackSize() * 2, 64) : 32;
    }

    public boolean isFull() {
        return item.getCount() >= CAPACITY;
    }

    public ItemStack getItemStack() {
        return this.item;
    }

    public int getCount() {
        return this.item.getCount();
    }

    public String toString() {
        return "TiffinContents" + this.item;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.item);
    }

    @Override
    public boolean equals(Object other) {
        boolean var10000;
        if (other instanceof TiffinContents contents) {
            var10000 = this.getItemStack().is(contents.getItemStack().getItem());
        } else {
            var10000 = false;
        }

        return var10000;
    }

    public static class Mutable {
        public ItemStack item;
        public Mutable(TiffinContents contents) {
            this.item = contents.item;
        }

        public int getCapacity() {
//            return !item.isEmpty() ? item.getItem().getDefaultMaxStackSize() == 1 ? 1 : Math.min(item.getItem().getDefaultMaxStackSize() * 2, 64) : 64;
            return 64;
        }

        public ItemStack getItemStack() {
            return this.item;
        }

        public int getCount() {
            return this.item.getCount();
        }

        public void decrement() {
            this.item.shrink(1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.item);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            } else {
                return obj instanceof TiffinContents ex
                        && this.item == ex.item;
            }
        }

        public boolean tryRemove(ItemStack stack, Slot slot, Player player) {
            if (TiffinItem.getRemainderItem(item.getItem()) != null && stack.getCount() > item.getCount()) { //cannot replace held stack, too many containers
                slot.set(stack.copyWithCount(stack.getCount() - item.getCount()));
                player.addItem(item);
                item = ItemStack.EMPTY;
                return true;
            } else {
                if (TiffinItem.getRemainderItem(item.getItem()) != null) {
                    if (item.getItem().getDefaultMaxStackSize() >= stack.getCount()) {
                        slot.set(item.copyWithCount(stack.getCount()));
                    } else {
                        slot.set(item.copyWithCount(item.getItem().getDefaultMaxStackSize()));
                        player.addItem(item.copyWithCount(stack.getCount() - item.getItem().getDefaultMaxStackSize()));
                    }
                    item.shrink(stack.getCount());
                } else {
                    if (stack.isEmpty()) {
                        slot.set(item.copyWithCount(Math.min(item.getCount(), item.getItem().getDefaultMaxStackSize())));
                        item.shrink(item.getItem().getDefaultMaxStackSize());
                    } else {
                        return false;
                    }
                }
                if (item.getCount() == 0) {
                    item = ItemStack.EMPTY;
                }
                return true;
            }
        }

        public int tryFill(ItemStack stack, Slot slot, Player player) {
            if (item.getCount() < getCapacity()) {
                if (!item.isEmpty()) { //putting items in full tiffin
                    if (stack.is(item.getItem())) {
                        int i = item.getCount() + stack.getCount();
                        if (i > getCapacity()) { //cannot fit all
                            slot.set(stack.copyWithCount(i - getCapacity()));
                            if (TiffinItem.getRemainderItem(stack.getItem()) != null) {
                                player.addItem(new ItemStack(TiffinItem.getRemainderItem(item.getItem()), getCapacity() - item.getCount()));
                            }
                            item = item.copyWithCount(getCapacity());
                            return getCapacity() - (i - stack.getCount());
                        } else {
                            item = item.copyWithCount(i);
                            if (TiffinItem.getRemainderItem(stack.getItem()) != null) {
                                slot.set(new ItemStack(TiffinItem.getRemainderItem(item.getItem()), stack.getCount()));
                            } else {
                                slot.set(ItemStack.EMPTY);
                            }
                            return stack.getCount();
                        }
                    }
                } else { //putting items in empty tiffin
                    if (TiffinItem.getRemainderItem(stack.getItem()) != null) {
                        if (stack.getCount() > getCapacity()) { //cannot fit all of stack
                            item = stack.copyWithCount(getCapacity());
                            slot.set(new ItemStack(TiffinItem.getRemainderItem(item.getItem()), stack.getCount() - getCapacity()));
                            player.addItem(new ItemStack(TiffinItem.getRemainderItem(item.getItem()), getCapacity()));
                            return getCapacity();
                        } else {
                            item = stack.copy();
                            slot.set(new ItemStack(TiffinItem.getRemainderItem(item.getItem()), stack.getCount()));
                            return item.getCount();
                        }
                    } else {
                        item = ItemStack.EMPTY;
                        if (stack.getCount() > getCapacity()) {
                            item = stack.copyWithCount(getCapacity());
                            slot.set(stack.copyWithCount(stack.getCount() - getCapacity()));
                            return getCapacity();
                        } else {
                            item = stack.copy();
                            slot.set(ItemStack.EMPTY);
                            return item.getCount();
                        }
                    }
                }
            }
            return 0;
        }

        public boolean tryRemove(ItemStack stack, SlotAccess slot, Player player) {
            if (TiffinItem.getRemainderItem(item.getItem()) != null && stack.getCount() > item.getCount()) { //cannot replace held stack, too many containers
                slot.set(stack.copyWithCount(stack.getCount() - item.getCount()));
                player.addItem(item);
                item = ItemStack.EMPTY;
                return true;
            } else {
                if (TiffinItem.getRemainderItem(item.getItem()) != null) {
                    if (item.getItem().getDefaultMaxStackSize() >= stack.getCount()) {
                        slot.set(item.copyWithCount(stack.getCount()));
                    } else {
                        slot.set(item.copyWithCount(item.getItem().getDefaultMaxStackSize()));
                        player.addItem(item.copyWithCount(stack.getCount() - item.getItem().getDefaultMaxStackSize()));
                    }
                    item.shrink(stack.getCount());
                } else {
                    if (stack.isEmpty()) {
                        slot.set(item.copyWithCount(Math.min(item.getCount(), item.getItem().getDefaultMaxStackSize())));
                        item.shrink(item.getItem().getDefaultMaxStackSize());
                    } else {
                        return false;
                    }
                }
                if (item.getCount() == 0) {
                    item = ItemStack.EMPTY;
                }
                return true;
            }
        }

        public int tryFill(ItemStack stack, SlotAccess slot, Player player) {
            if (item.getCount() < getCapacity()) {
                if (!item.isEmpty()) { //putting items in full tiffin
                    if (stack.is(item.getItem())) {
                        int i = item.getCount() + stack.getCount();
                        if (i > getCapacity()) { //cannot fit all
                            slot.set(stack.copyWithCount(i - getCapacity()));
                            if (TiffinItem.getRemainderItem(stack.getItem()) != null) {
                                player.addItem(new ItemStack(TiffinItem.getRemainderItem(item.getItem()), getCapacity() - item.getCount()));
                            }
                            item = item.copyWithCount(getCapacity());
                            return getCapacity() - (i - stack.getCount());
                        } else {
                            item = item.copyWithCount(i);
                            if (TiffinItem.getRemainderItem(stack.getItem()) != null) {
                                slot.set(new ItemStack(TiffinItem.getRemainderItem(item.getItem()), stack.getCount()));
                            } else {
                                slot.set(ItemStack.EMPTY);
                            }
                            return stack.getCount();
                        }
                    }
                } else { //putting items in empty tiffin
                    if (TiffinItem.getRemainderItem(stack.getItem()) != null) {
                        if (stack.getCount() > getCapacity()) { //cannot fit all of stack
                            item = stack.copyWithCount(getCapacity());
                            slot.set(new ItemStack(TiffinItem.getRemainderItem(item.getItem()), stack.getCount() - getCapacity()));
                            player.addItem(new ItemStack(TiffinItem.getRemainderItem(item.getItem()), getCapacity()));
                            return getCapacity();
                        } else {
                            item = stack.copy();
                            slot.set(new ItemStack(TiffinItem.getRemainderItem(item.getItem()), stack.getCount()));
                            return item.getCount();
                        }
                    } else {
                        item = ItemStack.EMPTY;
                        if (stack.getCount() > getCapacity()) {
                            item = stack.copyWithCount(getCapacity());
                            slot.set(stack.copyWithCount(stack.getCount() - getCapacity()));
                            return getCapacity();
                        } else {
                            item = stack.copy();
                            slot.set(ItemStack.EMPTY);
                            return item.getCount();
                        }
                    }
                }
            }
            return 0;
        }

        public TiffinContents toImmutable() {
            return new TiffinContents(this.item);
        }
    }
}
