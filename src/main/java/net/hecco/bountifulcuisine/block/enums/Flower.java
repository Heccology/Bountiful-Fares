package net.hecco.bountifulcuisine.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum Flower implements StringIdentifiable {
    ROSE("rose"),
    LILAC("lilac"),
    PEONY("peony"),
    SUNFLOWER("sunflower");
    private final String name;
    private Flower(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
    @Override
    public String asString() {
        return this.name;
    }
}