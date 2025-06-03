package net.hecco.bountifulfares.block.custom;

import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModFenceGateBlock extends FenceGateBlock {
    public ModFenceGateBlock(Properties settings, WoodType type) {
        super(type, settings);
    }
}
