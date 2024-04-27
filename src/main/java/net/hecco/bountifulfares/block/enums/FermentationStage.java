package net.hecco.bountifulfares.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum FermentationStage implements StringIdentifiable {
    EMPTY,
    WATER,
    FERMENTING,
    FERMENTED;

    @Override
    public String asString() {
        switch (this) {
            case WATER -> {
                return "water";
            }
            case FERMENTING -> {
                return "fermenting";
            }
            case FERMENTED -> {
                return "fermented";
            }
            default -> {
                return "empty";
            }
        }
    }
}
