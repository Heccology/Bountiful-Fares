package net.hecco.bountifulfares.compat.twigs;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.block.CompatBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

//This class is only included for ease of use and in order to not use Twigs as a dependency.
// The original code was grabbed from here: https://github.com/N1nn1/twigs/blob/main/src/main/java/com/ninni/twigs/block/LampBlock.java

public class TwigsLampBlock extends CompatBlock {
    public static final BooleanProperty LIT;

    public TwigsLampBlock(String modId, BlockBehaviour.Properties properties) {
        super(modId, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, true));
    }

    public InteractionResult onUse(BlockState state, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!player.isShiftKeyDown()) {
            boolean wasLit = state.getValue(LIT);
            level.setBlockAndUpdate(pos, state.setValue(LIT, !wasLit));
            level.playSound(null, pos, !wasLit ? TwigsSounds.LAMP_ON : TwigsSounds.LAMP_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID) || BountifulFares.isDatagen();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    static {
        LIT = BlockStateProperties.LIT;
    }
}
