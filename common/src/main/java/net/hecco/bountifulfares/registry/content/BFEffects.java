package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.effect.*;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.function.Supplier;

public class BFEffects {
    public static final Holder<MobEffect> ACIDIC = registerStatusEffect("acidic", () -> new AcidicEffect(MobEffectCategory.NEUTRAL, 0xD1FF00));
    public static final Holder<MobEffect> STUPOR = registerStatusEffect("stupor", () -> new StuporEffect(MobEffectCategory.NEUTRAL, 0x5F1ED8));

    public static final Holder<MobEffect> EBULLIENCE = registerStatusEffect("ebullience", () -> new EbullienceEffect(MobEffectCategory.BENEFICIAL, 0xE9DEE2));

    //    public static final StatusEffect GORGING = registerStatusEffect("gorging", new GorgingEffect(StatusEffectCategory.NEUTRAL, 0x8d6f3a).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.13, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

    public static final Holder<MobEffect> ENRICHMENT = registerStatusEffect("enrichment", () -> new EnrichmentEffect(MobEffectCategory.BENEFICIAL, 0xffd48f)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "effect.speed"), 0.08, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "effect.attack_speed"), 0.08, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "effect.attack"), 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.LUCK, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "effect.luck"), 1.0, AttributeModifier.Operation.ADD_VALUE)
    );
    public static final Holder<MobEffect> RESTORATION = registerStatusEffect("restoration", () -> new RestorationEffect(MobEffectCategory.BENEFICIAL, 0xFF4B19));
    private static Holder<MobEffect> registerStatusEffect(String name, Supplier<MobEffect> statusEffect) {
        return HLServices.REGISTRY.registerForHolder(BountifulFares.MOD_ID, name, BuiltInRegistries.MOB_EFFECT, statusEffect);
    }
    public static void registerEffects() {
    }
}
