package net.hecco.bountifulfares.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.block.BFBlocks;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class MillingRecipe implements Recipe<RecipeInput> {

    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    public MillingRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(RecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return recipeItems.get(0).test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(RecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return null;
    }

    public ItemStack getOutput() {
        return output.copy();
    }

    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BFRecipes.MILLING_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return BFRecipes.MILLING;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BFBlocks.GRISTMILL);
    }

    public static class Type<T extends MillingRecipe> implements RecipeType<T> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "milling";
    }

    public static class Serializer implements RecipeSerializer<MillingRecipe> {
        public static final String ID = "milling";


//        @Override
//        public MillingRecipe read(Identifier id, JsonObject json) {
//            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
//
//            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
//            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1, Ingredient.EMPTY);
//
//            for (int i = 0; i < inputs.size(); i++) {
//                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
//            }
//
//            return new MillingRecipe(id, output, inputs);
//        }
//
//        @Override
//        public MillingRecipe read(Identifier id, PacketByteBuf buf) {
//            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
//
//            for (int i = 0; i < inputs.size(); i++) {
//                inputs.set(i, Ingredient.fromPacket(buf));
//            }
//
//            ItemStack output = buf.readItemStack();
//            return new MillingRecipe(id, output, inputs);
//        }
//
//
//
//        @Override
//        public void write(PacketByteBuf buf, MillingRecipe recipe) {
//            buf.writeInt(recipe.getIngredients().size());
//            for (Ingredient ing : recipe.getIngredients()) {
//                ing.write(buf);
//            }
//            buf.writeItemStack(recipe.getOutput(null));
//        }

        @Override
        public MapCodec<MillingRecipe> codec() {
            return null;
        }

        @Override
        public PacketCodec<RegistryByteBuf, MillingRecipe> packetCodec() {
            return null;
        }
    }
}
