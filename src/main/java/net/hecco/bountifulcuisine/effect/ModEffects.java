package net.hecco.bountifulcuisine.effect;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect ACIDIC = registerStatusEffect("acidic", new AcidicEffect(StatusEffectCategory.NEUTRAL, 0xE7FF6D));
    public static final StatusEffect STUPOR = registerStatusEffect("stupor", new StuporEffect(StatusEffectCategory.NEUTRAL, 0x4539B3));
    public static final StatusEffect EBULLIENCE = registerStatusEffect("ebullience", new EbullienceEffect(StatusEffectCategory.BENEFICIAL, 0xE9DEE2));
    public static final StatusEffect GORGING = registerStatusEffect("gorging", new GorgingEffect(StatusEffectCategory.NEUTRAL, 0xFFCC00).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.13, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(BountifulCuisine.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        BountifulCuisine.LOGGER.info("Registring Mod Effects for " + BountifulCuisine.MOD_ID);
    }
}
