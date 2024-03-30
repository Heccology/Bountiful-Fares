package net.hecco.bountifulfares.potion;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion ACIDIC = registerPotion("bountifulfares.acidic", new Potion(new StatusEffectInstance(ModEffects.ACIDIC, 2000, 0)));
    public static final Potion LONG_ACIDIC = registerPotion("bountifulfares.long_acidic", new Potion(new StatusEffectInstance(ModEffects.ACIDIC, 3600, 0)));
    public static final Potion STRONG_ACIDIC = registerPotion("bountifulfares.strong_acidic", new Potion(new StatusEffectInstance(ModEffects.ACIDIC, 1000, 1)));
    public static final Potion STUPOR = registerPotion("bountifulfares.stupor", new Potion(new StatusEffectInstance(ModEffects.STUPOR, 2000, 0)));
    public static final Potion LONG_STUPOR = registerPotion("bountifulfares.long_stupor", new Potion(new StatusEffectInstance(ModEffects.STUPOR, 3600, 0)));
    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(BountifulFares.MOD_ID, name), potion);
    }
    public static void registerPotions() {
//        BountifulFares.LOGGER.info("Registering Mod Potions for " + BountifulFares.MOD_ID);
    }
}
