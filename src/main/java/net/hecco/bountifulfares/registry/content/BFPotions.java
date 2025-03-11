package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class BFPotions {
    public static final RegistryEntry<Potion> ACIDIC = Registry.registerReference(Registries.POTION, Identifier.of(BountifulFares.MOD_ID, "bountifulfares.acidic"),
            new Potion(new StatusEffectInstance(BFEffects.ACIDIC, 2000, 0)));
    public static final RegistryEntry<Potion> LONG_ACIDIC = Registry.registerReference(Registries.POTION, Identifier.of(BountifulFares.MOD_ID, "bountifulfares.long_acidic"),
            new Potion(new StatusEffectInstance(BFEffects.ACIDIC, 3600, 0)));
    public static final RegistryEntry<Potion> STRONG_ACIDIC = Registry.registerReference(Registries.POTION, Identifier.of(BountifulFares.MOD_ID, "bountifulfares.strong_acidic"),
            new Potion(new StatusEffectInstance(BFEffects.ACIDIC, 1000, 1)));
    public static final RegistryEntry<Potion> STUPOR = Registry.registerReference(Registries.POTION, Identifier.of(BountifulFares.MOD_ID, "bountifulfares.stupor"),
            new Potion(new StatusEffectInstance(BFEffects.STUPOR, 2000, 0)));
    public static final RegistryEntry<Potion> LONG_STUPOR = Registry.registerReference(Registries.POTION, Identifier.of(BountifulFares.MOD_ID, "bountifulfares.long_stupor"),
            new Potion(new StatusEffectInstance(BFEffects.STUPOR, 3600, 0)));
    public static void registerPotions() {
//        BountifulFares.LOGGER.info("Registering Mod Potions for " + BountifulFares.MOD_ID);
    }
}
