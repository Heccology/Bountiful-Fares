package net.hecco.bountifulfares.definition.recipe;

import com.mojang.serialization.Codec;
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

public class FermentationRecipe implements Recipe<RecipeInput> {

    private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient ingredient;
    private final int particleColor;

    public FermentationRecipe(ResourceLocation id, ItemStack output, int outputCount, Ingredient input, int particleColor) {
        this.id = id;
        this.output = new ItemStack(output.getItem(), outputCount);
        this.ingredient = input;
        this.particleColor = particleColor;
    }

    public FermentationRecipe(Ingredient ingredient, ItemStack itemStack, int outputCount, int particleColor) {
        this.id = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "fermenting");
        this.output = new ItemStack(itemStack.getItem(), outputCount);
        this.ingredient = ingredient;
        this.particleColor = particleColor;
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
        return output.copy();
    }

    public ItemStack getOutput() {
        return output.copy();
    }

    public int getParticleColor() {
        return particleColor;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BFRecipes.FERMENTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return BFRecipes.FERMENTING;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(BFBlocks.FERMENTATION_VESSEL.get());
    }

    public interface RecipeFactory<T extends FermentationRecipe> {
        T create(Ingredient ingredient, ItemStack result, int resultCount, int ParticleColor);
    }

    public static class Serializer implements RecipeSerializer<FermentationRecipe> {
        private final FermentationRecipe.RecipeFactory<FermentationRecipe> recipeFactory;
        public final MapCodec<FermentationRecipe> CODEC;
        public final StreamCodec<RegistryFriendlyByteBuf, FermentationRecipe> PACKET_CODEC;

        public FermentationRecipe create(Ingredient ingredient, ItemStack result, int resultCount, int particleColor) {
            return this.recipeFactory.create(ingredient, result, resultCount, particleColor);
        }

        public Serializer(FermentationRecipe.RecipeFactory<FermentationRecipe> recipeFactory) {
            this.CODEC = RecordCodecBuilder.mapCodec((instance) ->
                    instance.group(
                            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient")
                                .forGetter((recipe) -> recipe.ingredient),
                            ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("result")
                                    .forGetter((recipe) -> recipe.output),
                            ExtraCodecs.intRange(1, 99).fieldOf("result_count")
                                    .forGetter((recipe) -> recipe.output.getCount()),
                            Codec.INT.fieldOf("particle_color").forGetter(
                                    (recipe) -> recipe.particleColor)
                            )
                            .apply(instance, recipeFactory::create));
            this.PACKET_CODEC = StreamCodec.of(this::write, this::read);
            this.recipeFactory = recipeFactory;
        }

        public FermentationRecipe read(RegistryFriendlyByteBuf buf) {
            Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
            ItemStack itemStack = ItemStack.STREAM_CODEC.decode(buf);
            int count = ByteBufCodecs.INT.decode(buf);
            int particleColor = ByteBufCodecs.INT.decode(buf);
            return this.recipeFactory.create(ingredient, itemStack, count, particleColor);
        }

        public void write(RegistryFriendlyByteBuf buf, FermentationRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.ingredient);
            ItemStack.STREAM_CODEC.encode(buf, recipe.output);
            ByteBufCodecs.INT.encode(buf, recipe.output.getCount());
            ByteBufCodecs.INT.encode(buf, recipe.particleColor);
        }
        @Override
        public MapCodec<FermentationRecipe> codec() {
            return CODEC;
        }


        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FermentationRecipe> streamCodec() {
            return PACKET_CODEC;
        }
    }
}
