package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class BFPotions {
    public static final Holder<Potion> ACIDIC = Registry.registerForHolder(BuiltInRegistries.POTION, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "bountifulfares.acidic"),
            new Potion(new MobEffectInstance(BFEffects.ACIDIC, 2000, 0)));
    public static final Holder<Potion> LONG_ACIDIC = Registry.registerForHolder(BuiltInRegistries.POTION, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "bountifulfares.long_acidic"),
            new Potion(new MobEffectInstance(BFEffects.ACIDIC, 3600, 0)));
    public static final Holder<Potion> STRONG_ACIDIC = Registry.registerForHolder(BuiltInRegistries.POTION, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "bountifulfares.strong_acidic"),
            new Potion(new MobEffectInstance(BFEffects.ACIDIC, 1000, 1)));
    public static final Holder<Potion> STUPOR = Registry.registerForHolder(BuiltInRegistries.POTION, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "bountifulfares.stupor"),
            new Potion(new MobEffectInstance(BFEffects.STUPOR, 2000, 0)));
    public static final Holder<Potion> LONG_STUPOR = Registry.registerForHolder(BuiltInRegistries.POTION, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "bountifulfares.long_stupor"),
            new Potion(new MobEffectInstance(BFEffects.STUPOR, 3600, 0)));
    public static void registerPotions() {
//        BountifulFares.LOGGER.info("Registering Mod Potions for " + BountifulFares.MOD_ID);
    }
}
