package net.hecco.bountifulfares.definition.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;

public class GrassSeedsItem extends Item {

    public static final ArrayList<Triple<Block, Block, Boolean>> INTERACTIONS = new ArrayList<>();

    public GrassSeedsItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level world = context.getLevel();
        ItemStack stack = context.getItemInHand();
        for (Triple<Block, Block, Boolean> interaction : INTERACTIONS) {
            if (!interaction.getRight()) {
                if (world.getBlockState(pos).is(interaction.getLeft()) && !world.getBlockState(pos.above()).isFaceSturdy(world, pos.above(), Direction.UP)) {
                    world.setBlockAndUpdate(pos, interaction.getMiddle().defaultBlockState());
                    world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
                    for (int i = 0; i < 16; i++) {
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, (pos.getX() - 0.2) + (world.random.nextFloat() * 1.4), pos.getY() + (world.random.nextFloat() * 0.5) + 0.8, (pos.getZ() - 0.2) + (world.random.nextFloat() * 1.4), (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
                    }
                    if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                        stack.shrink(1);
                    }
                    return InteractionResult.sidedSuccess(true);
                }
            } else {
                if (world.getBlockState(pos).is(interaction.getLeft()) && context.getClickedFace() == Direction.UP && world.getBlockState(pos.above()).isAir()) {
                    pos = pos.above();
                    world.setBlockAndUpdate(pos, interaction.getMiddle().defaultBlockState());
                    world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
                    for (int i = 0; i < 16; i++) {
                        world.addParticle(ParticleTypes.HAPPY_VILLAGER, (pos.getX() - 0.2) + (world.random.nextFloat() * 1.4), pos.getY() + (world.random.nextFloat() * 0.5) + 0.8, (pos.getZ() - 0.2) + (world.random.nextFloat() * 1.4), (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
                    }
                    if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                        stack.shrink(1);
                    }
                    return InteractionResult.sidedSuccess(true);
                }
            }
        }
        return super.useOn(context);
    }
}
