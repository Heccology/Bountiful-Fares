package net.hecco.bountifulfares.mixin;

import com.google.common.collect.Lists;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.resource.SplashTextResourceSupplier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mixin(SplashTextResourceSupplier.class)
public abstract class SplashMixin
{
    @Unique private final List<String> bountifulFaresTexts = Lists.<String>newArrayList();
    @Unique private static final Identifier BOUNTIFUL_FARES_ID = Identifier.of(BountifulFares.MOD_ID,"texts/splashes.txt");

    @ModifyReturnValue(method = "prepare(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)Ljava/util/List;", at = @At(value = "RETURN", ordinal = 0))
    protected List<String> bountifulFaresSplashMix(List<String> original, @Local(argsOnly = true) ResourceManager resourceManager, @Local(argsOnly = true) Profiler profiler)
    {
        try {
            BufferedReader bufferedReader = MinecraftClient.getInstance().getResourceManager().openAsReader(BOUNTIFUL_FARES_ID);

            List<String> stringreader;
            try {
                stringreader = (List<String>)bufferedReader.lines().map(String::trim).filter(splashText -> splashText.hashCode() != 125780783).collect(Collectors.toList());
            } catch (Throwable var7) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            List<String> complete = original;
            boolean worked = complete.addAll(stringreader);

            if (worked)
            {
                //BountifulFares.LOGGER.info("Successfully mixed splash texts.");
                return complete;
            }
            else
            {
                //BountifulFares.LOGGER.error("Unable to mix splash texts.");
                return original;
            }
        } catch (IOException var8) {
            return original;
        }
    }

    @Inject(method = "apply(Ljava/util/List;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V", at = @At("TAIL"))
    protected void applyNewSplashes(List<String> list, ResourceManager resourceManager, Profiler profiler, CallbackInfo ci)
    {
        this.bountifulFaresTexts.addAll(list);
    }
}
