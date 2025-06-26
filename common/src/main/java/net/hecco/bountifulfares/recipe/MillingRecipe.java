package net.hecco.bountifulfares.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class MillingRecipe implements Recipe<RecipeInput> {

    private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient ingredient;

    public MillingRecipe(ResourceLocation id, ItemStack output, Ingredient input) {
        this.id = id;
        this.output = output;
        this.ingredient = input;
    }

    public MillingRecipe(Ingredient ingredient, ItemStack itemStack, int count) {
        this.id = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "milling");
        this.output = itemStack.copyWithCount(count);
        this.ingredient = ingredient;
    }

    @Override
    public boolean matches(RecipeInput input, Level world) {
        if (world.isClientSide()) {
            return false;
        }
        return ingredient.test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(RecipeInput input, HolderLookup.Provider lookup) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registriesLookup) {
        return output;
    }

    public ItemStack getOutput() {
        return output.copy();
    }

    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BFRecipes.MILLING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return BFRecipes.MILLING;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(BFBlocks.GRISTMILL.get());
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
        public final StreamCodec<RegistryFriendlyByteBuf, MillingRecipe> PACKET_CODEC;

        public MillingRecipe create(Ingredient ingredient, ItemStack result, int count) {
            return this.recipeFactory.create(ingredient, result, count);
        }

        public Serializer(MillingRecipe.RecipeFactory<MillingRecipe> recipeFactory) {
            this.CODEC = RecordCodecBuilder.mapCodec((instance) ->
                    instance.group(
                            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient")
                                    .forGetter((recipe) -> recipe.ingredient),
                            ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("result")
                                    .forGetter((recipe) -> recipe.output),
                            ExtraCodecs.intRange(1, 99).fieldOf("result_count")
                                    .forGetter((recipe) -> recipe.output.getCount())
                            )
                            .apply(instance, recipeFactory::create));
            this.PACKET_CODEC = StreamCodec.of(this::write, this::read);
            this.recipeFactory = recipeFactory;
        }

        public MillingRecipe read(RegistryFriendlyByteBuf buf) {
            Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
            ItemStack itemStack = ItemStack.STREAM_CODEC.decode(buf);
            int count = ByteBufCodecs.INT.decode(buf);
            return this.recipeFactory.create(ingredient, itemStack, count);
        }

        public void write(RegistryFriendlyByteBuf buf, MillingRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.ingredient);
            ItemStack.STREAM_CODEC.encode(buf, recipe.output);
            ByteBufCodecs.INT.encode(buf, recipe.output.getCount());
        }
        @Override
        public MapCodec<MillingRecipe> codec() {
            return CODEC;
        }


        @Override
        public StreamCodec<RegistryFriendlyByteBuf, MillingRecipe> streamCodec() {
            return PACKET_CODEC;
        }
    }
}
