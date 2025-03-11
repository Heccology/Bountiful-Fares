package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
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
        if (BountifulFares.CONFIG.isEnableFlourThrowing()) {
            ItemStack itemStack = user.getStackInHand(hand);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), BFSounds.FLOUR_THROW, SoundCategory.NEUTRAL, 0.6f, 0.9f + world.random.nextFloat() / 4);
            if (!world.isClient) {
                FlourProjectileEntity flourProjectileEntity = new FlourProjectileEntity(user, world);
                flourProjectileEntity.setItem(itemStack);
                flourProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 0.35f, 7.5f);
                world.spawnEntity(flourProjectileEntity);
            }
            if (BountifulFares.CONFIG.getFlourThrowingCooldown() != 0) {
                user.getItemCooldownManager().set(this, BountifulFares.CONFIG.getFlourThrowingCooldown());
            }
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!user.isCreative()) {
                itemStack.decrement(1);
            }
            return TypedActionResult.success(itemStack, world.isClient());
        }
        return super.use(world, user, hand);
    }
}
