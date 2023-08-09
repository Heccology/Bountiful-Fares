package net.hecco.bountifulcuisine.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum ItemFermenting implements StringIdentifiable {
    SPIDER_EYE("spider_eye"),
    ELDERBERRIES("elderberries");
    private final String name;
    private ItemFermenting(String name) {
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