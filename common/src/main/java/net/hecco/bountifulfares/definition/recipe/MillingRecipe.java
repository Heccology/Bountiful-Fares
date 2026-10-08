package net.hecco.bountifulfares.definition.recipe;

import com.mojang.serialization.Codec;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class MillingRecipe implements Recipe<SingleRecipeInput> {
    private final ResourceLocation id;
    private final Ingredient ingredient;

    private final ItemStack primary;
    private final String primaryGroup;
    private final GristmillBookCategory primaryCategory;

    private final ItemStack secondary;
    private final String secondaryGroup;
    private final GristmillBookCategory secondaryCategory;

    public MillingRecipe(ResourceLocation id, Ingredient input, ItemStack primaryResult, String primaryGroup, GristmillBookCategory primaryCategory, ItemStack secondaryResult, String secondaryGroup, GristmillBookCategory secondaryCategory) {
        this.id = id;
        this.ingredient = input;

        this.primary = primaryResult;
        this.primaryGroup = primaryGroup;
        this.primaryCategory = primaryCategory;

        this.secondary = secondaryResult;
        this.secondaryGroup = secondaryGroup;
        this.secondaryCategory = secondaryCategory;
    }

    public MillingRecipe(Ingredient input, ItemStack primaryResult, String primaryGroup, GristmillBookCategory primaryCategory, ItemStack secondaryResult, String secondaryGroup, GristmillBookCategory secondaryCategory) {
        this(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, Type.ID), input, primaryResult, primaryGroup, primaryCategory, secondaryResult, secondaryGroup, secondaryCategory);
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level world) {
        if (world.isClientSide()) { return false; }
        return ingredient.test(input.getItem(0));
    }

    public ResourceLocation getId() {
        return this.id;
    }
    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public ItemStack getPrimary() {
        return this.primary.copy();
    }
    public GristmillBookCategory getPrimaryRecipeTab() { return this.primaryCategory; }
    public String getPrimaryGroup() { return this.primaryGroup; }

    public ItemStack getSecondary() { return this.secondary.copy(); }
    public GristmillBookCategory getSecondaryRecipeTab() { return this.secondaryCategory; }
    public String getSecondaryGroup() { return this.secondaryGroup; }

    @Override public ItemStack assemble(SingleRecipeInput input, HolderLookup.Provider lookup) { return this.getPrimary(); }
    @Override public boolean canCraftInDimensions(int width, int height) {
        return true;
    }
    @Override public ItemStack getResultItem(HolderLookup.Provider registriesLookup) {
        return this.primary;
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

    @Override public String getGroup() { return this.primaryGroup; }

    public interface RecipeFactory<T extends MillingRecipe> {
        T create(
                Ingredient ingredient,
                ItemStack primary,
                String primaryGrp,
                GristmillBookCategory primaryCtgy,

                ItemStack secondary,
                String secondaryGrp,
                GristmillBookCategory secondaryCtgy
        );
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

        public MillingRecipe create(Ingredient ingredient, ItemStack primary, String primaryGrp, GristmillBookCategory primaryCtgy, ItemStack secondary, String secondaryGrp, GristmillBookCategory secondaryCtgy) {
            return this.recipeFactory.create(ingredient, primary, primaryGrp, primaryCtgy, secondary, secondaryGrp, secondaryCtgy);
        }

        public Serializer(MillingRecipe.RecipeFactory<MillingRecipe> recipeFactory) {
            this.CODEC = RecordCodecBuilder.mapCodec((instance) ->
                    instance.group(
                            Ingredient.CODEC_NONEMPTY.fieldOf("ingredient")
                                    .forGetter((recipe) -> recipe.ingredient),

                            ItemStack.CODEC.fieldOf("primary")
                                    .forGetter((recipe) -> recipe.primary),
                            Codec.STRING.lenientOptionalFieldOf("primary_group", "")
                                    .forGetter((recipe) -> recipe.primaryGroup),
                            GristmillBookCategory.CODEC.fieldOf("primary_category")
                                    .orElse(GristmillBookCategory.MATERIALS)
                                    .forGetter((recipe) -> recipe.primaryCategory),

                            ItemStack.CODEC.lenientOptionalFieldOf("secondary", ItemStack.EMPTY)
                                    .forGetter((recipe) -> recipe.secondary),
                            Codec.STRING.lenientOptionalFieldOf("secondary_group", "")
                                    .forGetter((recipe) -> recipe.secondaryGroup),
                            GristmillBookCategory.CODEC.lenientOptionalFieldOf("secondary_category", GristmillBookCategory.MATERIALS)
                                    .forGetter((recipe) -> recipe.secondaryCategory)
                            )
                            .apply(instance, recipeFactory::create));
            this.PACKET_CODEC = StreamCodec.of(this::write, this::read);
            this.recipeFactory = recipeFactory;
        }

        public MillingRecipe read(RegistryFriendlyByteBuf buf) {
            // Input
            Ingredient input = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
            // Primary
            ItemStack priStack = ItemStack.STREAM_CODEC.decode(buf);
            String priStr = ByteBufCodecs.STRING_UTF8.decode(buf);
            GristmillBookCategory priCat = GristmillBookCategory.STREAM_CODEC.decode(buf);
            // Bool
            boolean isEmpty = ByteBufCodecs.BOOL.decode(buf);
            // Secondary (ifEmpty)
            ItemStack secStack = ItemStack.EMPTY;
            String secStr = "";
            GristmillBookCategory secCat = GristmillBookCategory.MATERIALS;
            if (!isEmpty) {
                secStack = ItemStack.STREAM_CODEC.decode(buf);
                secStr = ByteBufCodecs.STRING_UTF8.decode(buf);
                secCat = GristmillBookCategory.STREAM_CODEC.decode(buf);
            }

            return this.recipeFactory.create(input, priStack, priStr, priCat, secStack, secStr, secCat);
        }

        public void write(RegistryFriendlyByteBuf buf, MillingRecipe recipe) {
            // Ingredients
            Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.ingredient);
            // Primary
            ItemStack.STREAM_CODEC.encode(buf, recipe.primary);
            ByteBufCodecs.STRING_UTF8.encode(buf, recipe.primaryGroup);
            GristmillBookCategory.STREAM_CODEC.encode(buf, recipe.primaryCategory);
            // IsEmpty
            boolean isEmpty = recipe.secondary.isEmpty();
            ByteBufCodecs.BOOL.encode(buf, isEmpty);
            // Secondary (ifEmpty)
            if (!isEmpty) {
                ItemStack.STREAM_CODEC.encode(buf, recipe.secondary);
                ByteBufCodecs.STRING_UTF8.encode(buf, recipe.secondaryGroup);
                GristmillBookCategory.STREAM_CODEC.encode(buf, recipe.secondaryCategory);
            }
        }

        @Override public MapCodec<MillingRecipe> codec() {
            return CODEC;
        }
        @Override public StreamCodec<RegistryFriendlyByteBuf, MillingRecipe> streamCodec() {
            return PACKET_CODEC;
        }
    }
}
