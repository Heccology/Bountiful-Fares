package net.hecco.bountifulfares.world.tree;

import net.hecco.bountifulfares.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator APPLE = new SaplingGenerator("apple", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.APPLE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final SaplingGenerator ORANGE = new SaplingGenerator("orange", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.ORANGE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final SaplingGenerator LEMON = new SaplingGenerator("lemon", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.LEMON_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final SaplingGenerator PLUM = new SaplingGenerator("plum", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.PLUM_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final SaplingGenerator WALNUT = new SaplingGenerator("walnut", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.WALNUT_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final SaplingGenerator HOARY = new SaplingGenerator("hoary", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.HOARY_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
}
