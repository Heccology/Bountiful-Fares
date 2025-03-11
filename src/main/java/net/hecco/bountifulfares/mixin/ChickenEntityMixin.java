package net.hecco.bountifulfares.mixin;

import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChickenEntity.class)
public class ChickenEntityMixin extends PathAwareEntity {
    @Unique
    private static final Ingredient BF_BREEDING_INGREDIENT = Ingredient.ofItems(
            BFItems.GRASS_SEEDS,
            BFItems.SWEET_BERRY_PIPS,
            BFItems.HOARY_SEEDS,
            BFItems.LAPISBERRY_SEEDS,
            BFItems.LEEK_SEEDS,
            BFItems.MAIZE_SEEDS,
            BFItems.SPONGEKIN_SEEDS
    );

    protected ChickenEntityMixin(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "isBreedingItem", at = @At("TAIL"), cancellable = true)
    private void addSeeds(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            cir.setReturnValue(BF_BREEDING_INGREDIENT.test(stack));
        }
    }

    @Inject(method = "initGoals", at = @At("TAIL"))
    private void addTemptGoal(CallbackInfo ci) {
        this.goalSelector.add(3, new TemptGoal(this, 1.0, BF_BREEDING_INGREDIENT, false));
    }

    @Override
    public <A> @Nullable A getAttached(AttachmentType<A> type) {
        return super.getAttached(type);
    }
}
