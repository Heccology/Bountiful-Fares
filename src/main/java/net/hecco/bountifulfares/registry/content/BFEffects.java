package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.effect.*;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class BFEffects {
    public static final RegistryEntry<StatusEffect> ACIDIC = registerStatusEffect("acidic", new AcidicEffect(StatusEffectCategory.NEUTRAL, 0xD1FF00));
    public static final RegistryEntry<StatusEffect> STUPOR = registerStatusEffect("stupor", new StuporEffect(StatusEffectCategory.NEUTRAL, 0x5F1ED8));

    public static final RegistryEntry<StatusEffect> EBULLIENCE = registerStatusEffect("ebullience", new EbullienceEffect(StatusEffectCategory.BENEFICIAL, 0xE9DEE2));

    //    public static final StatusEffect GORGING = registerStatusEffect("gorging", new GorgingEffect(StatusEffectCategory.NEUTRAL, 0x8d6f3a).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.13, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

    public static final RegistryEntry<StatusEffect> ENRICHMENT = registerStatusEffect("enrichment", new EnrichmentEffect(StatusEffectCategory.BENEFICIAL, 0xffd48f)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.of(BountifulFares.MOD_ID, "effect.speed"), 0.08, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, Identifier.of(BountifulFares.MOD_ID, "effect.attack_speed"), 0.08, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, Identifier.of(BountifulFares.MOD_ID, "effect.attack"), 0.2, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_LUCK, Identifier.of(BountifulFares.MOD_ID, "effect.luck"), 1.0, EntityAttributeModifier.Operation.ADD_VALUE)
    );
    public static final RegistryEntry<StatusEffect> RESTORATION = registerStatusEffect("restoration", new RestorationEffect(StatusEffectCategory.BENEFICIAL, 0xFF4B19));
    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BountifulFares.MOD_ID, name), statusEffect);
    }
    public static void registerEffects() {
    }
}
