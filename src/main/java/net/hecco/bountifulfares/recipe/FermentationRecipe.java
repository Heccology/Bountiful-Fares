package net.hecco.bountifulfares.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.minecraft.item.Item;
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

public class FermentationRecipe implements Recipe<RecipeInput> {

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

    public FermentationRecipe(Ingredient ingredient, ItemStack itemStack, int outputCount, int particleColor) {
        this.id = Identifier.of(BountifulFares.MOD_ID, "fermenting");
        this.output = new ItemStack(itemStack.getItem(), outputCount);
        this.ingredient = ingredient;
        this.particleColor = particleColor;
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
        return output.copy();
    }

    public ItemStack getOutput() {
        return output.copy();
    }

    public int getParticleColor() {
        return particleColor;
    }

    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BFRecipes.FERMENTING_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return BFRecipes.FERMENTING;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BFBlocks.FERMENTATION_VESSEL);
    }

    public interface RecipeFactory<T extends FermentationRecipe> {
        T create(Ingredient ingredient, ItemStack result, int resultCount, int ParticleColor);
    }

    public static class Serializer implements RecipeSerializer<FermentationRecipe> {
        private final FermentationRecipe.RecipeFactory<FermentationRecipe> recipeFactory;
        public final MapCodec<FermentationRecipe> CODEC;
        public final PacketCodec<RegistryByteBuf, FermentationRecipe> PACKET_CODEC;

        public FermentationRecipe create(Ingredient ingredient, ItemStack result, int resultCount, int particleColor) {
            return this.recipeFactory.create(ingredient, result, resultCount, particleColor);
        }

        public Serializer(FermentationRecipe.RecipeFactory<FermentationRecipe> recipeFactory) {
            this.CODEC = RecordCodecBuilder.mapCodec((instance) ->
                    instance.group(
                            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient")
                                .forGetter((recipe) -> recipe.ingredient),
                            ItemStack.VALIDATED_UNCOUNTED_CODEC.fieldOf("result")
                                    .forGetter((recipe) -> recipe.output),
                            Codecs.rangedInt(1, 99).fieldOf("result_count")
                                    .forGetter((recipe) -> recipe.output.getCount()),
                            Codec.INT.fieldOf("particle_color").forGetter(
                                    (recipe) -> recipe.particleColor)
                            )
                            .apply(instance, recipeFactory::create));
            this.PACKET_CODEC = PacketCodec.ofStatic(this::write, this::read);
            this.recipeFactory = recipeFactory;
        }

        public FermentationRecipe read(RegistryByteBuf buf) {
            Ingredient ingredient = Ingredient.PACKET_CODEC.decode(buf);
            ItemStack itemStack = ItemStack.PACKET_CODEC.decode(buf);
            int count = PacketCodecs.INTEGER.decode(buf);
            int particleColor = PacketCodecs.INTEGER.decode(buf);
            return this.recipeFactory.create(ingredient, itemStack, count, particleColor);
        }

        public void write(RegistryByteBuf buf, FermentationRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(buf, recipe.ingredient);
            ItemStack.PACKET_CODEC.encode(buf, recipe.output);
            PacketCodecs.INTEGER.encode(buf, recipe.output.getCount());
            PacketCodecs.INTEGER.encode(buf, recipe.particleColor);
        }
        @Override
        public MapCodec<FermentationRecipe> codec() {
            return CODEC;
        }


        @Override
        public PacketCodec<RegistryByteBuf, FermentationRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
