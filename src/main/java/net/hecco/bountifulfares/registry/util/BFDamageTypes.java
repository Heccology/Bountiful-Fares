package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class BFDamageTypes {
    public static final RegistryKey<DamageType> FALLING_COCONUT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(BountifulFares.MOD_ID, "falling_coconut"));

    public static void registerDamageTypes() {}
}
