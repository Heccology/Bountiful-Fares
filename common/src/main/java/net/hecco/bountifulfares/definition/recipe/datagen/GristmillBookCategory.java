package net.hecco.bountifulfares.definition.recipe.datagen;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.function.IntFunction;

public enum GristmillBookCategory implements StringRepresentable {
    MATERIALS("materials", 0),
    MINERALS("minerals", 1);

    public static final Codec<GristmillBookCategory> CODEC = StringRepresentable.fromEnum(GristmillBookCategory::values);
    public static final IntFunction<GristmillBookCategory> BY_ID = ByIdMap.continuous(GristmillBookCategory::id, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final StreamCodec<ByteBuf, GristmillBookCategory> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, GristmillBookCategory::id);
    private final String name;
    private final int id;

    private GristmillBookCategory(final String name, final int id) {
        this.name = name;
        this.id = id;
    }

    @Override public String getSerializedName() { return this.name; }
    private int id() {
        return this.id;
    }
}