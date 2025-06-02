package net.hecco.bountifulfares.block.enums;

import net.minecraft.util.StringRepresentable;

public enum FermentationStage implements StringRepresentable {
    EMPTY,
    WATER,
    FERMENTING,
    FERMENTED;

    @Override
    public String getSerializedName() {
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
