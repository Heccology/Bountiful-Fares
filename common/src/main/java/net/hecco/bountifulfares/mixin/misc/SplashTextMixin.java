package net.hecco.bountifulfares.mixin.misc;

import com.google.common.collect.Lists;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SplashManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Mixin(SplashManager.class)
public abstract class SplashTextMixin
{
    @Unique private final List<String> bountifulFares$Texts = Lists.newArrayList();
    @Unique private static final ResourceLocation BOUNTIFUL_FARES_ID = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID,"texts/splashes.txt");

    @ModifyReturnValue(method = "prepare(Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)Ljava/util/List;", at = @At(value = "RETURN", ordinal = 0))
    protected List<String> bountifulFares$splashMix(List<String> original, @Local(argsOnly = true) ResourceManager resourceManager, @Local(argsOnly = true) ProfilerFiller profiler)
    {
        try {
            BufferedReader bufferedReader = Minecraft.getInstance().getResourceManager().openAsReader(BOUNTIFUL_FARES_ID);

            List<String> stringreader;
            try {
                stringreader = bufferedReader.lines().map(String::trim).filter(splashText -> splashText.hashCode() != 125780783).collect(Collectors.toList());
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

            if (worked) {
                return complete;
            }
            else {
                return original;
            }
        } catch (IOException var8) {
            return original;
        }
    }

    @Inject(method = "apply(Ljava/util/List;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("TAIL"))
    protected void bountifulfares$applyNewSplashes(List<String> list, ResourceManager resourceManager, ProfilerFiller profiler, CallbackInfo ci)
    {
        this.bountifulFares$Texts.addAll(list);
    }
}
