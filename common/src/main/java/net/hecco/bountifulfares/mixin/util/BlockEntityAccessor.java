package net.hecco.bountifulfares.mixin.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(BlockEntityType.class)
public interface BlockEntityAccessor {
    @Accessor("validBlocks")
    Set<Block> getValidBlocks();

    @Accessor("validBlocks")
    void setValidBlocks(Set<Block> blocks);
}
