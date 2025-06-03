package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class BFDamageTypes {
    public static final ResourceKey<DamageType> FALLING_COCONUT = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "falling_coconut"));

    public static void registerDamageTypes() {}
}
