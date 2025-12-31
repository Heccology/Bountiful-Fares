package net.hecco.bountifulfares.registry.tags;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.Block;

public class BFEffectTags {
    public static final TagKey<MobEffect> ACIDIC_BLACKLIST = createEffectTag("acidic_blacklist");
    public static final TagKey<MobEffect> STUPOR_BLACKLIST = createEffectTag("stupor_blacklist");

    private static TagKey<MobEffect> createEffectTag(String name) {
        return TagKey.create(Registries.MOB_EFFECT,
                             ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name));
    }
}
