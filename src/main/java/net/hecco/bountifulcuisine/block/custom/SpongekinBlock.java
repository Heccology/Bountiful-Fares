package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class SpongekinBlock extends Block {
    public static BooleanProperty PLANTED = BooleanProperty.of("planted");
    public SpongekinBlock(Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(PLANTED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getStackInHand(hand).isOf(Items.SHEARS)) {
            for (int i = 0; i < 32 + world.random.nextBetween(0, 16); i++) {
                world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, ModBlocks.SPONGEKIN.getDefaultState()), (pos.getX() - 0.2) + (world.random.nextFloat() * 1.4), pos.getY() + (world.random.nextFloat() * 1.2), (pos.getZ() - 0.2) + (world.random.nextFloat() * 1.4), (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
            }
            world.setBlockState(pos, Blocks.WET_SPONGE.getDefaultState(), 2);
            player.getStackInHand(hand).damage(1, player, playerx -> playerx.sendToolBreakStatus(hand));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSounds.SPONGEKIN_SHEAR, SoundCategory.BLOCKS, 1.0F, 0.8f + world.random.nextFloat()/4);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (state.get(PLANTED) && world.getBlockState(pos.down()).isOf(ModBlocks.SPONGEKIN_STEM.getDefaultState().with(SpongekinStemBlock.ATTACHED, true).getBlock())) {
            world.setBlockState(pos.down(), ModBlocks.SPONGEKIN_STEM.getDefaultState().with(SpongekinStemBlock.AGE, 3).with(SpongekinStemBlock.ATTACHED, false), 2);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PLANTED);
    }
}
