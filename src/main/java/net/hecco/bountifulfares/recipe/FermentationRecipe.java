package net.hecco.bountifulfares.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
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
    private final Ingredient ingredient;
    private final int particleColor;

    public FermentationRecipe(Identifier id, ItemStack output, int outputCount, Ingredient input, int particleColor) {
        this.id = id;
        this.output = new ItemStack(output.getItem(), outputCount);
        this.ingredient = input;
        this.particleColor = particleColor;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient()) {
            return false;
        }
        return ingredient.test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    public int getParticleColor() {
        return particleColor;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output.copy();
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return FermentationRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return FermentationRecipe.Type.INSTANCE;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(ingredient);
        return list;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BFBlocks.GRISTMILL);
    }

    public static class Type implements RecipeType<FermentationRecipe> {
        private Type() { }
        public static final FermentationRecipe.Type INSTANCE = new FermentationRecipe.Type();
        public static final String ID = "fermenting";
    }

    public static class Serializer implements RecipeSerializer<FermentationRecipe> {
        public static final FermentationRecipe.Serializer INSTANCE = new FermentationRecipe.Serializer();
        public static final String ID = "fermenting";

        @Override
        public FermentationRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));

            int outputCount = JsonHelper.asInt(json, "result_count");

            Ingredient ingredient = Ingredient.fromJson(JsonHelper.getObject(json, "ingredient"));

            int particleColor = JsonHelper.asInt(json, "particle_color");

            return new FermentationRecipe(id, output, outputCount, ingredient, particleColor);
        }

        @Override
        public FermentationRecipe read(Identifier id, PacketByteBuf buf) {
            ItemStack output = buf.readItemStack();

            int outputCount = buf.readInt();

            Ingredient ingredient = Ingredient.fromPacket(buf);

            int particleColor = buf.readInt();

            return new FermentationRecipe(id, output, outputCount, ingredient, particleColor);
        }

        @Override
        public void write(PacketByteBuf buf, FermentationRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput(null));
        }
    }
}
