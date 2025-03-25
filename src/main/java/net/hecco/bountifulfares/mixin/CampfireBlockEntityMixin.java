package net.hecco.bountifulfares.mixin;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(CampfireBlockEntity.class)
public class CampfireBlockEntityMixin {

    @Unique @Final
    private static ItemStackParticleEffect POP = new ItemStackParticleEffect(ParticleTypes.ITEM, new ItemStack(BFItems.POPPED_MAIZE));

    @Inject(method = "litServerTick",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/ItemScatterer;spawn(Lnet/minecraft/world/World;DDDLnet/minecraft/item/ItemStack;)V"),
            locals = LocalCapture.CAPTURE_FAILSOFT)
    private static void bf_addMaizePoppingSound(World world, BlockPos pos, BlockState state, CampfireBlockEntity campfire, CallbackInfo ci, boolean bl, int i, ItemStack itemStack, SingleStackRecipeInput singleStackRecipeInput, ItemStack resultStack) {
        if (itemStack.isOf(BFItems.MAIZE_SEEDS)) {
            world.playSound(null, pos, BFSounds.POPPED_MAIZE_POP, SoundCategory.BLOCKS, 1.0f, 1.0f + world.random.nextFloat() / 3);
            ((ServerWorld)world).spawnParticles(
                    POP,
                    pos.toCenterPos().getX(),
                    pos.toCenterPos().getY() + 0.2D,
                    pos.toCenterPos().getZ(),
                    8,
                    ((double) world.random.nextFloat() - 0.5),
                    ((double) world.random.nextFloat() - 0.5),
                    ((double) world.random.nextFloat() - 0.5),
                    0.1
            );
        }
    }
}