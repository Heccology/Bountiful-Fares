package net.hecco.bountifulfares.effect;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect ACIDIC = registerStatusEffect("acidic", new AcidicEffect(StatusEffectCategory.NEUTRAL, 0xD1FF00));
    public static final StatusEffect STUPOR = registerStatusEffect("stupor", new StuporEffect(StatusEffectCategory.NEUTRAL, 0x5F1ED8));
    public static final StatusEffect EBULLIENCE = registerStatusEffect("ebullience", new EbullienceEffect(StatusEffectCategory.BENEFICIAL, 0xE9DEE2));
//    public static final StatusEffect GORGING = registerStatusEffect("gorging", new GorgingEffect(StatusEffectCategory.NEUTRAL, 0x8d6f3a).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.13, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final StatusEffect ENRICHMENT = registerStatusEffect("enrichment", new EnrichmentEffect(StatusEffectCategory.BENEFICIAL, 0xffd48f)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.08, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 0.15, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 0.2, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_LUCK, "03C3C89D-7037-4B42-869F-B146BCB64D2E", 1.0, EntityAttributeModifier.Operation.ADDITION));
    public static final StatusEffect RESTORATION = registerStatusEffect("restoration", new RestorationEffect(StatusEffectCategory.BENEFICIAL, 0xFF4B19));
    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(BountifulFares.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        BountifulFares.LOGGER.info("Registring Mod Effects for " + BountifulFares.MOD_ID);
    }
}
