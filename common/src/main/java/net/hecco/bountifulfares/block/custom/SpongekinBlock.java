package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SpongekinBlock extends Block {
    public SpongekinBlock(Properties settings) {
        super(settings);
        this.registerDefaultState((this.stateDefinition.any()));
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if (stack.is(Items.SHEARS)) {
            for (int i = 0; i < 32 + world.random.nextIntBetweenInclusive(0, 16); i++) {
                world.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, BFBlocks.SPONGEKIN.get().defaultBlockState()), (pos.getX() - 0.2) + (world.random.nextFloat() * 1.4), pos.getY() + (world.random.nextFloat() * 1.2), (pos.getZ() - 0.2) + (world.random.nextFloat() * 1.4), (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
            }
            world.setBlock(pos, Blocks.WET_SPONGE.defaultBlockState(), 2);
            player.getItemInHand(hand).hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), BFSounds.SPONGEKIN_SHEAR.get(), SoundSource.BLOCKS, 1.0F, 0.8f + world.random.nextFloat()/4);
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
