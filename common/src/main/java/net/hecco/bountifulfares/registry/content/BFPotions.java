package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class BFPotions {
    public static final Holder<Potion> ACIDIC = NLServices.REGISTRY.registerForHolder(BountifulFares.MOD_ID, "bountifulfares.acidic", BuiltInRegistries.POTION,
            () -> new Potion(new MobEffectInstance(BFEffects.ACIDIC, 2000, 0)));

    public static final Holder<Potion> LONG_ACIDIC = NLServices.REGISTRY.registerForHolder(BountifulFares.MOD_ID, "bountifulfares.long_acidic", BuiltInRegistries.POTION,
            () -> new Potion(new MobEffectInstance(BFEffects.ACIDIC, 3600, 0)));

    public static final Holder<Potion> STRONG_ACIDIC = NLServices.REGISTRY.registerForHolder(BountifulFares.MOD_ID, "bountifulfares.strong_acidic", BuiltInRegistries.POTION,
            () -> new Potion(new MobEffectInstance(BFEffects.ACIDIC, 1000, 1)));

    public static final Holder<Potion> STUPOR = NLServices.REGISTRY.registerForHolder(BountifulFares.MOD_ID, "bountifulfares.stupor", BuiltInRegistries.POTION,
            () -> new Potion(new MobEffectInstance(BFEffects.STUPOR, 2000, 0)));

    public static final Holder<Potion> LONG_STUPOR = NLServices.REGISTRY.registerForHolder(BountifulFares.MOD_ID, "bountifulfares.long_stupor", BuiltInRegistries.POTION,
            () -> new Potion(new MobEffectInstance(BFEffects.STUPOR, 3600, 0)));

    public static void registerPotions() {
    }
}
