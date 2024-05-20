package net.hecco.bountifulfares.world.tree;

import net.hecco.bountifulfares.world.BFConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class BFSaplingGenerators {
    public static final SaplingGenerator APPLE = new SaplingGenerator("apple", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.APPLE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final SaplingGenerator ORANGE = new SaplingGenerator("orange", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.ORANGE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final SaplingGenerator LEMON = new SaplingGenerator("lemon", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.LEMON_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final SaplingGenerator PLUM = new SaplingGenerator("plum", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.PLUM_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final SaplingGenerator WALNUT = new SaplingGenerator("walnut", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.WALNUT_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
    public static final SaplingGenerator HOARY = new SaplingGenerator("hoary", 0f,
            Optional.empty(),
            Optional.empty(),
            Optional.of(BFConfiguredFeatures.HOARY_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());
}
