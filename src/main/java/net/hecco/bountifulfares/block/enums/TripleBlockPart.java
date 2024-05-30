package net.hecco.bountifulfares.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum TripleBlockPart implements StringIdentifiable {
    UPPER,
    MIDDLE,
    LOWER;

    private TripleBlockPart() {
    }

    public String toString() {
        return this.asString();
    }

    public String asString() {
        return this == UPPER ? "upper" : (this == MIDDLE ? "middle" : "lower");
    }
}
