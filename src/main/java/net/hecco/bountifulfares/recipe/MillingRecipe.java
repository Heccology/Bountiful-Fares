package net.hecco.bountifulfares.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

public class MillingRecipe implements Recipe<RecipeInput> {

    private final Identifier id;
    private final ItemStack output;
    private final Ingredient ingredient;

    public MillingRecipe(Identifier id, ItemStack output, Ingredient input) {
        this.id = id;
        this.output = output;
        this.ingredient = input;
    }

    public MillingRecipe(Ingredient ingredient, ItemStack itemStack, int count) {
        this.id = Identifier.of(BountifulFares.MOD_ID, "milling");
        this.output = itemStack.copyWithCount(count);
        this.ingredient = ingredient;
    }

    @Override
    public boolean matches(RecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return ingredient.test(input.getStackInSlot(0));
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
        return output;
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

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BFBlocks.GRISTMILL);
    }

    public interface RecipeFactory<T extends MillingRecipe> {
        T create(Ingredient ingredient, ItemStack result, int count);
    }

    public static class Type<T extends MillingRecipe> implements RecipeType<T> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "milling";
    }

    public static class Serializer implements RecipeSerializer<MillingRecipe> {
        private final MillingRecipe.RecipeFactory<MillingRecipe> recipeFactory;
        public static final Serializer INSTANCE = new Serializer(MillingRecipe::new);
        public final MapCodec<MillingRecipe> CODEC;
        public final PacketCodec<RegistryByteBuf, MillingRecipe> PACKET_CODEC;

        public MillingRecipe create(Ingredient ingredient, ItemStack result, int count) {
            return this.recipeFactory.create(ingredient, result, count);
        }

        public Serializer(MillingRecipe.RecipeFactory<MillingRecipe> recipeFactory) {
            this.CODEC = RecordCodecBuilder.mapCodec((instance) ->
                    instance.group(
                            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient")
                                    .forGetter((recipe) -> recipe.ingredient),
                            ItemStack.VALIDATED_UNCOUNTED_CODEC.fieldOf("result")
                                    .forGetter((recipe) -> recipe.output),
                            Codecs.rangedInt(1, 99).fieldOf("result_count")
                                    .forGetter((recipe) -> recipe.output.getCount())
                            )
                            .apply(instance, recipeFactory::create));
            this.PACKET_CODEC = PacketCodec.ofStatic(this::write, this::read);
            this.recipeFactory = recipeFactory;
        }

        public MillingRecipe read(RegistryByteBuf buf) {
            Ingredient ingredient = Ingredient.PACKET_CODEC.decode(buf);
            ItemStack itemStack = ItemStack.PACKET_CODEC.decode(buf);
            int count = PacketCodecs.INTEGER.decode(buf);
            return this.recipeFactory.create(ingredient, itemStack, count);
        }

        public void write(RegistryByteBuf buf, MillingRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(buf, recipe.ingredient);
            ItemStack.PACKET_CODEC.encode(buf, recipe.output);
            PacketCodecs.INTEGER.encode(buf, recipe.output.getCount());
        }
        @Override
        public MapCodec<MillingRecipe> codec() {
            return CODEC;
        }


        @Override
        public PacketCodec<RegistryByteBuf, MillingRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
