package net.hecco.bountifulcuisine.item.custom;

import net.hecco.bountifulcuisine.entity.FlourProjectileEntity;
import net.hecco.bountifulcuisine.particle.ModParticles;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FlourItem extends Item {
    public FlourItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient) {
            FlourProjectileEntity flourProjectileEntity = new FlourProjectileEntity(user, world);
            flourProjectileEntity.setItem(itemStack);
            flourProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 0.35f, 7.5f);
            world.spawnEntity(flourProjectileEntity);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.isCreative()) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
