package net.hecco.bountifulcuisine.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class FermentationRecipe implements Recipe<SimpleInventory> {

    private final Identifier id;
    private final ItemStack output;
    private final ItemStack collector;
    private final DefaultedList<Ingredient> recipeItems;

    public FermentationRecipe(Identifier id, ItemStack output, ItemStack collector, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.collector = collector;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient()) {
            return false;
        }
        return recipeItems.get(0).test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output.copy();
    }

    public ItemStack getCollector() {
        return collector.copy();
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    public static class Type implements RecipeType<FermentationRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "fermenting";
    }

    public static class Serializer implements RecipeSerializer<FermentationRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "fermenting";

        @Override
        public FermentationRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
            ItemStack collector = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "collector"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new FermentationRecipe(id, output, collector, inputs);
        }

        @Override
        public FermentationRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            ItemStack collector = buf.readItemStack();
            return new FermentationRecipe(id, output, collector, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, FermentationRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput(null));
            buf.writeItemStack(recipe.getCollector());
        }
    }
}
