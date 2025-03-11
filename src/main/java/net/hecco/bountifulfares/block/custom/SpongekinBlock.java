package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpongekinBlock extends Block {
    public SpongekinBlock(Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (player.getStackInHand(player.getActiveHand()).isOf(Items.SHEARS)) {
            for (int i = 0; i < 32 + world.random.nextBetween(0, 16); i++) {
                world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, BFBlocks.SPONGEKIN.getDefaultState()), (pos.getX() - 0.2) + (world.random.nextFloat() * 1.4), pos.getY() + (world.random.nextFloat() * 1.2), (pos.getZ() - 0.2) + (world.random.nextFloat() * 1.4), (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
            }
            world.setBlockState(pos, Blocks.WET_SPONGE.getDefaultState(), 2);
            player.getStackInHand(player.getActiveHand()).damage(1, player, LivingEntity.getSlotForHand(player.getActiveHand()));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), BFSounds.SPONGEKIN_SHEAR, SoundCategory.BLOCKS, 1.0F, 0.8f + world.random.nextFloat()/4);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
