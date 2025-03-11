package net.hecco.bountifulfares.compat.twigs;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.block.CompatBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//This class is only included for ease of use and in order to not use Twigs as a dependency.
// The original code was grabbed from here: https://github.com/N1nn1/twigs/blob/main/src/main/java/com/ninni/twigs/block/LampBlock.java

public class TwigsLampBlock extends CompatBlock {
    public static final BooleanProperty LIT;

    public TwigsLampBlock(String modId, AbstractBlock.Settings properties) {
        super(modId, properties);
        this.setDefaultState(this.getDefaultState().with(LIT, true));
    }

    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand interactionHand, BlockHitResult blockHitResult) {
        if (!player.isSneaking()) {
            boolean wasLit = state.get(LIT);
            level.setBlockState(pos, state.with(LIT, !wasLit));
            level.playSound(null, pos, !wasLit ? TwigsSounds.LAMP_ON : TwigsSounds.LAMP_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID) || BountifulFares.isDatagen();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    static {
        LIT = Properties.LIT;
    }
}
