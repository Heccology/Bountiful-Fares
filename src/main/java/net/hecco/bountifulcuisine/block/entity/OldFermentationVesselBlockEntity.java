package net.hecco.bountifulcuisine.block.entity;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.custom.OldFermentationVesselBlock;
import net.hecco.bountifulcuisine.recipe.FermentationRecipe;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Optional;

public class OldFermentationVesselBlockEntity extends BlockEntity implements ImplementedInventory {

    private static BooleanProperty fermentingState;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    private static final int[] SLOTS = new int[]{0};
    private int progress = 0;
    private int maxProgress = 72;
    public OldFermentationVesselBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OLD_FERMENTATION_VESSEL_BLOCK_ENTITY, pos, state);
        fermentingState = ((OldFermentationVesselBlock)state.getBlock()).getFermentingState();
    }


    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("oldfermenting.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        nbt.getInt("oldfermenting.progress");
        super.readNbt(nbt);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (!state.get(fermentingState) && !inventory.get(0).isEmpty()) {
            world.setBlockState(pos, state.with(fermentingState, true));
        }
        if (hasRecipe() && progress < maxProgress && world.getTime() % 20 == 0) {
            progress++;
            markDirty(world, pos, state);
            if (progress == maxProgress) {
                craftItem();
            }
        }
    }

    private void craftItem() {
        Optional<FermentationRecipe> recipe = getCurrentRecipe();
        this.setStack(0, new ItemStack(recipe.get().getOutput(null).getItem(),
                recipe.get().getOutput(null).getCount()));
    }
    private boolean hasRecipe() {
        Optional<FermentationRecipe> recipe = getCurrentRecipe();

        return recipe.isPresent();
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.UP) {
            return SLOTS;
        }
        return null;
    }

    private Optional<FermentationRecipe> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            inventory.setStack(i, this.getStack(i));
        }
        return this.getWorld().getRecipeManager().getFirstMatch(FermentationRecipe.Type.INSTANCE, inventory, this.getWorld());
    }

    public boolean canCollect() {
        Optional<FermentationRecipe> recipe = getCurrentRecipe();
        return recipe.isPresent() && inventory.get(0).getItem() == recipe.get().getOutput(null).getItem();
    }

    public boolean canInputItem(PlayerEntity player, Hand hand) {
        Optional<FermentationRecipe> recipe = getCurrentRecipe();
        BountifulCuisine.LOGGER.info("present " + this.hasRecipe());
        BountifulCuisine.LOGGER.info("recipe input" + recipe);
        return inventory.get(0).isEmpty() && this.hasRecipe() && recipe.get().getIngredients().contains(Ingredient.ofItems(player.getStackInHand(hand).getItem()));
    }

    public Item getCollector() {
        Optional<FermentationRecipe> recipe = getCurrentRecipe();
        return recipe.get().getCollector().getItem();
    }

    public ItemStack getOutput() {
        Optional<FermentationRecipe> recipe = getCurrentRecipe();
        return recipe.get().getOutput(null);
    }
}
