package net.hecco.bountifulfares.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class ModWoodTypes {
    public static final WoodType HOARY = WoodTypeRegistry.register(new Identifier(BountifulFares.MOD_ID, "hoary"), ModBlockSetTypes.HOARY);
    public static final WoodType WALNUT = WoodTypeRegistry.register(new Identifier(BountifulFares.MOD_ID, "walnut"), ModBlockSetTypes.WALNUT);
}

