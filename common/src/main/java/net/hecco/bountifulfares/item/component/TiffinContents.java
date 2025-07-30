package net.hecco.bountifulfares.item.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.item.custom.TiffinItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Objects;

public class TiffinContents implements TooltipComponent {
    public static final Codec<TiffinContents> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(t -> t.item.asItem()),
            Codec.INT.fieldOf("count").forGetter(t -> t.count)
    ).apply(instance, TiffinContents::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, TiffinContents> STREAM_CODEC = StreamCodec.composite(ResourceLocation.STREAM_CODEC.map(BuiltInRegistries.ITEM::get, BuiltInRegistries.ITEM::getKey), contents -> contents.item.asItem(), ByteBufCodecs.INT, contents -> contents.count, TiffinContents::new);
    public static final int CAPACITY = 32;
    final Item item;
    final int count;

    public TiffinContents(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    public TiffinContents(Item item) {
        this.item = item;
        this.count = 1;
    }

    public Item getItem() {
        return this.item;
    }

    public int getCount() {
        return this.count;
    }

    public String toString() {
        return "TiffinContents" + this.item;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.item, this.count);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof TiffinContents ex
                    && this.item == ex.item
                    && this.count == ex.count;
        }
    }

    public static class Mutable {
        private Item item;
        private int count;
        public Mutable(TiffinContents contents) {
            this.item = contents.item;
            this.count = contents.count;
        }

        public Item getItem() {
            return this.item;
        }

        public int getCount() {
            return this.getCount();
        }

        public void decrement() {
            this.count --;
            if (this.count <= 0) {
                this.count = 0;
                this.item = Items.AIR;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.item, this.count);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            } else {
                return obj instanceof TiffinContents ex
                        && this.item == ex.item
                        && this.count == ex.count;
            }
        }

        public boolean tryRemove(ItemStack stack, Slot slot, Player player) {
            if (item.hasCraftingRemainingItem() || TiffinItem.ITEM_WHITELIST.contains(item)) {
                if (stack.is(Items.BOWL)) {
                    if (stack.getCount() > count) { //cannot replace held stack, too many containers
                        player.addItem(new ItemStack(item, count));
                        slot.set(new ItemStack(stack.getItem(), stack.getCount() - count));
                        count = 0;
                        item = Items.AIR;
                        return true;
                    } else {
                        if (item.getDefaultMaxStackSize() >= stack.getCount()) {
                            slot.set(new ItemStack(item, stack.getCount()));
                        } else {
                            slot.set(new ItemStack(item, item.getDefaultMaxStackSize()));
                            player.addItem(new ItemStack(item, stack.getCount() - item.getDefaultMaxStackSize()));
                        }
                        count = count - stack.getCount();
                        if (count <= 0) {
                            count = 0;
                            item = Items.AIR;
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        public int tryFill(ItemStack stack, Slot slot, Player player) {
            if (count < CAPACITY) {
                if (item != Items.AIR) { //putting items in full tiffin
                    if (stack.getItem() == item) {
                        int i = count + stack.getCount();
                        if (i > CAPACITY) { //cannot fit all
                            slot.set(new ItemStack(stack.getItem(), i - CAPACITY));
                            if (stack.getItem().getCraftingRemainingItem() != null || TiffinItem.ITEM_WHITELIST.contains(stack.getItem())) {
                                player.addItem(new ItemStack(Items.BOWL, CAPACITY - count));
                            }
                            count = CAPACITY;
                            return CAPACITY - (i - stack.getCount());
                        } else {
                            count = i;
                            if (stack.getItem().getCraftingRemainingItem() != null || TiffinItem.ITEM_WHITELIST.contains(stack.getItem())) {
                                slot.set(new ItemStack(Items.BOWL, stack.getCount()));
                            } else {
                                slot.set(new ItemStack(Items.AIR));
                            }
                            return stack.getCount();
                        }
                    }
                } else { //putting items in empty tiffin
                    item = stack.getItem();
                    if (stack.getCount() > CAPACITY) { //cannot fit all of stack
                        count = CAPACITY;
                        if (stack.getItem().getCraftingRemainingItem() != null || TiffinItem.ITEM_WHITELIST.contains(stack.getItem())) {
                            slot.set(new ItemStack(Items.BOWL, stack.getCount() - CAPACITY));
                            player.addItem(new ItemStack(Items.BOWL, CAPACITY));
                        } else {
                            slot.set(new ItemStack(Items.AIR));
                        }
                        return CAPACITY;
                    } else {
                        count = stack.getCount();
                        if (stack.getItem().getCraftingRemainingItem() != null || TiffinItem.ITEM_WHITELIST.contains(stack.getItem())) {
                            slot.set(new ItemStack(Items.BOWL, stack.getCount()));
                        } else {
                            slot.set(new ItemStack(Items.AIR));
                        }
                        return count;
                    }
                }
            }
            return 0;
        }

        public boolean tryRemove(ItemStack stack, SlotAccess access, Player player) {
            if (item.hasCraftingRemainingItem() || TiffinItem.ITEM_WHITELIST.contains(item)) {
                if (stack.is(Items.BOWL)) {
                    if (stack.getCount() > count) { //cannot replace held stack, too many containers
                        player.addItem(new ItemStack(item, count));
                        access.set(new ItemStack(stack.getItem(), stack.getCount() - count));
                        count = 0;
                        item = Items.AIR;
                        return true;
                    } else {
                        if (item.getDefaultMaxStackSize() >= stack.getCount()) {
                            access.set(new ItemStack(item, stack.getCount()));
                        } else {
                            access.set(new ItemStack(item, item.getDefaultMaxStackSize()));
                            player.addItem(new ItemStack(item, stack.getCount() - item.getDefaultMaxStackSize()));
                        }
                        count = count - stack.getCount();
                        if (count <= 0) {
                            count = 0;
                            item = Items.AIR;
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        public int tryFill(ItemStack stack, SlotAccess access, Player player) {
            if (count < CAPACITY) {
                if (item != Items.AIR) { //putting items in full tiffin
                    if (stack.getItem() == item) {
                        int i = count + stack.getCount();
                        if (i > CAPACITY) { //cannot fit all
                            access.set(new ItemStack(stack.getItem(), i - CAPACITY));
                            if (stack.getItem().getCraftingRemainingItem() != null || TiffinItem.ITEM_WHITELIST.contains(stack.getItem())) {
                                player.addItem(new ItemStack(Items.BOWL, CAPACITY - count));
                            }
                            count = CAPACITY;
                            return CAPACITY - (i - stack.getCount());
                        } else {
                            count = i;
                            if (stack.getItem().getCraftingRemainingItem() != null || TiffinItem.ITEM_WHITELIST.contains(stack.getItem())) {
                                access.set(new ItemStack(Items.BOWL, stack.getCount()));
                            } else {
                                access.set(new ItemStack(Items.AIR));
                            }
                            return stack.getCount();
                        }
                    }
                } else { //putting items in empty tiffin
                    item = stack.getItem();
                    if (stack.getCount() > CAPACITY) { //cannot fit all of stack
                        count = CAPACITY;
                        if (stack.getItem().getCraftingRemainingItem() != null || TiffinItem.ITEM_WHITELIST.contains(stack.getItem())) {
                            access.set(new ItemStack(Items.BOWL, stack.getCount() - CAPACITY));
                            player.addItem(new ItemStack(Items.BOWL, CAPACITY));
                        } else {
                            access.set(new ItemStack(Items.AIR));
                        }
                        return CAPACITY;
                    } else {
                        count = stack.getCount();
                        if (stack.getItem().getCraftingRemainingItem() != null || TiffinItem.ITEM_WHITELIST.contains(stack.getItem())) {
                            access.set(new ItemStack(Items.BOWL, stack.getCount()));
                        } else {
                            access.set(new ItemStack(Items.AIR));
                        }
                        return count;
                    }
                }
            }
            return 0;
        }

        public TiffinContents toImmutable() {
            return new TiffinContents(this.item, this.count);
        }
    }
}
