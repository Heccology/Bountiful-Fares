package net.hecco.bountifulfares.definition.block.entity;

import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.BlockState;

public class BFHangingSignBlockEntity extends BFSignBlockEntity {

    public BFHangingSignBlockEntity(BlockPos p_250603_, BlockState p_251674_) {
        super(BFBlockEntities.HANGING_SIGN_BLOCK_ENTITY.get(), p_250603_, p_251674_);
    }

    public int getTextLineHeight() {
        return 9;
    }

    public int getMaxTextLineWidth() {
        return 60;
    }

    public SoundEvent getSignInteractionFailedSoundEvent() {
        return SoundEvents.WAXED_HANGING_SIGN_INTERACT_FAIL;
    }
}
