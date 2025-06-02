package net.hecco.bountifulfares.registry.tags;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;

public class BFEffectTags {
    public static final TagKey<MobEffect> ACIDIC_BLACKLIST = TagKey.create(Registries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "acidic_blacklist"));
    public static final TagKey<MobEffect> STUPOR_BLACKLIST = TagKey.create(Registries.MOB_EFFECT, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "stupor_blacklist"));
}
