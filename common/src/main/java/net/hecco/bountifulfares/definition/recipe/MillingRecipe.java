package net.hecco.bountifulfares.definition.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.recipe.datagen.GristmillBookCategory;
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

public class MillingRecipe implements Recipe<SingleRecipeInput> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final ItemStack extra;
    private final Ingredient ingredient;
    private final GristmillBookCategory category;

    public MillingRecipe(ResourceLocation id, ItemStack output, ItemStack extra, Ingredient input, GristmillBookCategory category) {
        this.id = id;
        this.output = output;
        this.ingredient = input;
        this.category = category;
        this.extra = (extra == null) ? ItemStack.EMPTY : extra;
    }

    public MillingRecipe(Ingredient ingredient, ItemStack itemStack, int count, ItemStack extra, int extraCount, GristmillBookCategory category) {
        this.id = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "milling");
        this.output = itemStack.copyWithCount(count);
        this.ingredient = ingredient;
        this.category = category;
        this.extra = extra.copyWithCount(extraCount);
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level world) {
        if (world.isClientSide()) { return false; }
        return ingredient.test(input.getItem(0));
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }
    public ItemStack getOutput() {
        return this.output.copy();
    }
    public ItemStack getExtra() { return this.extra.copy(); }
    public ResourceLocation getId() {
        return this.id;
    }
    public GristmillBookCategory getRecipeTab() { return this.category; }

    @Override public ItemStack assemble(SingleRecipeInput input, HolderLookup.Provider lookup) { return this.getOutput(); }
    @Override public boolean canCraftInDimensions(int width, int height) {
        return true;
    }
    @Override public ItemStack getResultItem(HolderLookup.Provider registriesLookup) {
        return this.output;
    }

    @Override public RecipeSerializer<?> getSerializer() {
        return BFRecipes.MILLING_SERIALIZER.get();
    }

    @Override public ItemStack getToastSymbol() {
        return new ItemStack(BFBlocks.GRISTMILL.get());
    }
    @Override public RecipeType<?> getType() {
        return BFRecipes.MILLING.get();
    }

    public interface RecipeFactory<T extends MillingRecipe> {
        T create(Ingredient ingredient, ItemStack result, int count, ItemStack extra, int extraCount, GristmillBookCategory category);
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

        public MillingRecipe create(Ingredient ingredient, ItemStack result, int count, ItemStack extra, int extraCount, GristmillBookCategory category) {
            return this.recipeFactory.create(ingredient, result, count, extra, extraCount, category);
        }

        public Serializer(MillingRecipe.RecipeFactory<MillingRecipe> recipeFactory) {
            this.CODEC = RecordCodecBuilder.mapCodec((instance) ->
                    instance.group(
                            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient")
                                    .forGetter((recipe) -> recipe.ingredient),
                            ItemStack.STRICT_SINGLE_ITEM_CODEC.fieldOf("result")
                                    .forGetter((recipe) -> recipe.output),
                            ExtraCodecs.intRange(1, 99).fieldOf("result_count")
                                    .forGetter((recipe) -> recipe.output.getCount()),
                            ItemStack.OPTIONAL_CODEC.lenientOptionalFieldOf("extra", ItemStack.EMPTY)
                                    .forGetter((recipe) -> recipe.extra),
                            ExtraCodecs.intRange(0, 99).lenientOptionalFieldOf("extra_count", 0)
                                    .forGetter((recipe) -> recipe.extra.getCount()),
                            GristmillBookCategory.CODEC.fieldOf("category")
                                    .orElse(GristmillBookCategory.MINERALS)
                                    .forGetter((recipe) -> recipe.category)
                            )
                            .apply(instance, recipeFactory::create));
            this.PACKET_CODEC = StreamCodec.of(this::write, this::read);
            this.recipeFactory = recipeFactory;
        }

        public MillingRecipe read(RegistryFriendlyByteBuf buf) {
            Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
            ItemStack itemStack = ItemStack.STREAM_CODEC.decode(buf);
            int count = ByteBufCodecs.INT.decode(buf);

            boolean isEmpty = ByteBufCodecs.BOOL.decode(buf);

            ItemStack itemStackEx = ItemStack.EMPTY;
            int countEx = 0;
            if (!isEmpty) {
                itemStackEx = ItemStack.STREAM_CODEC.decode(buf);
                countEx = ByteBufCodecs.INT.decode(buf);
            }

            GristmillBookCategory cat = GristmillBookCategory.STREAM_CODEC.decode(buf);
            return this.recipeFactory.create(ingredient, itemStack, count, itemStackEx, countEx, cat);
        }

        public void write(RegistryFriendlyByteBuf buf, MillingRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.ingredient);
            ItemStack.STREAM_CODEC.encode(buf, recipe.output);
            ByteBufCodecs.INT.encode(buf, recipe.output.getCount());

            boolean isEmpty = recipe.extra.isEmpty();
            ByteBufCodecs.BOOL.encode(buf, isEmpty);
            if (!isEmpty) {
                ItemStack.STREAM_CODEC.encode(buf, recipe.extra);
                ByteBufCodecs.INT.encode(buf, recipe.extra.getCount());
            }

            GristmillBookCategory.STREAM_CODEC.encode(buf, recipe.category);
        }

        @Override public MapCodec<MillingRecipe> codec() {
            return CODEC;
        }
        @Override public StreamCodec<RegistryFriendlyByteBuf, MillingRecipe> streamCodec() {
            return PACKET_CODEC;
        }
    }
}
