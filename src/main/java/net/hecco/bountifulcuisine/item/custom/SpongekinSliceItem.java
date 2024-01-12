package net.hecco.bountifulcuisine.item.custom;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class SpongekinSliceItem extends Item {
    public static int airTickIncrease;
    public SpongekinSliceItem(int airTickIncrease, Settings settings) {
        super(settings);
        SpongekinSliceItem.airTickIncrease = airTickIncrease;
    }



    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        int air = user.getAir();
        int maxAir = user.getMaxAir();
        if (air < maxAir - airTickIncrease){
            user.setAir(air + airTickIncrease);
        } else {
            user.setAir(maxAir);
        }
        return super.finishUsing(stack, world, user);
    }
}
