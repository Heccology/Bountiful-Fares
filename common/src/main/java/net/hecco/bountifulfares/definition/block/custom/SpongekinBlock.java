package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class SpongekinBlock extends Block {
    public SpongekinBlock(Properties settings) {
        super(settings);
        this.registerDefaultState((this.stateDefinition.any()));
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if (stack.is(Items.SHEARS) || stack.is(ItemTags.AXES)) {
            shearAtPosition(player, world, pos);
            player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
            player.getItemInHand(hand).hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            return ItemInteractionResult.sidedSuccess(world.isClientSide);
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public static void shearAtPosition(@Nullable Player player, Level level, BlockPos blockPos) {
        if (!level.isClientSide()) {
            BlockParticleOption spong = new BlockParticleOption(ParticleTypes.BLOCK, BFBlocks.SPONGEKIN.get().defaultBlockState());
            for (int i = 0; i < 32 + level.random.nextIntBetweenInclusive(0, 16); i++) {
                ((ServerLevel)level).sendParticles(
                        spong,
                        (blockPos.getX() - 0.2) + (level.random.nextFloat() * 1.4),
                        blockPos.getY() + (level.random.nextFloat() * 1.2),
                        (blockPos.getZ() - 0.2) + (level.random.nextFloat() * 1.4),
                        1,
                        0.0F,
                        0.0F,
                        0.0F,
                        0.0F
                );
            }
        }
        level.setBlock(blockPos, Blocks.WET_SPONGE.defaultBlockState(), 3);
        level.gameEvent(player, GameEvent.SHEAR, blockPos);

        double xP = (player != null) ? player.getX() : blockPos.getCenter().x;
        double yP = (player != null) ? player.getY() : blockPos.getCenter().y;
        double zP = (player != null) ? player.getZ() : blockPos.getCenter().z;
        level.playSound(player, xP, yP, zP, BFSounds.SPONGEKIN_SHEAR.get(), SoundSource.BLOCKS, 1.0F, 0.8f + level.random.nextFloat() / 4);
    }
}
