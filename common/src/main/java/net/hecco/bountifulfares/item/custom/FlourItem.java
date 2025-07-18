package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
//import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FlourItem extends Item {
    public FlourItem(Properties settings) {
        super(settings);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        if (BountifulFares.CONFIG.isEnableFlourThrowing()) {
            ItemStack itemStack = user.getItemInHand(hand);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), BFSounds.FLOUR_THROW.get(), SoundSource.NEUTRAL, 0.6f, 0.9f + world.random.nextFloat() / 4);
            if (!world.isClientSide) {
//                FlourProjectileEntity flourProjectileEntity = new FlourProjectileEntity(user, world);
//                flourProjectileEntity.setItem(itemStack);
//                flourProjectileEntity.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0f, 0.35f, 7.5f);
//                world.addFreshEntity(flourProjectileEntity); //TODO: THIS TOO
            }
            if (BountifulFares.CONFIG.getFlourThrowingCooldown() != 0) {
                user.getCooldowns().addCooldown(this, BountifulFares.CONFIG.getFlourThrowingCooldown());
            }
            user.awardStat(Stats.ITEM_USED.get(this));
            if (!user.isCreative()) {
                itemStack.shrink(1);
            }
            return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide());
        }
        return super.use(world, user, hand);
    }
}
