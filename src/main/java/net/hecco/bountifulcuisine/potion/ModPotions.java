package net.hecco.bountifulcuisine.potion;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion ACIDIC = registerPotion("bountifulcuisine.acidic", new Potion(new StatusEffectInstance(ModEffects.ACIDIC, 2000, 0)));
    public static final Potion LONG_ACIDIC = registerPotion("bountifulcuisine.long_acidic", new Potion(new StatusEffectInstance(ModEffects.ACIDIC, 3600, 0)));
    public static final Potion STRONG_ACIDIC = registerPotion("bountifulcuisine.strong_acidic", new Potion(new StatusEffectInstance(ModEffects.ACIDIC, 1000, 1)));
    public static final Potion STUPOR = registerPotion("bountifulcuisine.stupor", new Potion(new StatusEffectInstance(ModEffects.STUPOR, 2000, 0)));
    public static final Potion LONG_STUPOR = registerPotion("bountifulcuisine.long_stupor", new Potion(new StatusEffectInstance(ModEffects.STUPOR, 3600, 0)));
    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(BountifulCuisine.MOD_ID, name), potion);
    }
    public static void registerPotions() {
        BountifulCuisine.LOGGER.info("Registering Mod Potions for " + BountifulCuisine.MOD_ID);
    }
}
