package net.hecco.bountifulfares.block.block_models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.client.util.ModelIdentifier;

@Environment(EnvType.CLIENT)
public class TutorialModelLoadingPlugin implements ModelLoadingPlugin {
    public static final ModelIdentifier FOUR_SIDED_FURNACE_MODEL = new ModelIdentifier(BountifulFares.MOD_ID, "four_sided_furnace", "");

    @Override
    public void onInitializeModelLoader(Context pluginContext) {
        // We want to add our model when the models are loaded
        pluginContext.modifyModelOnLoad().register((original, context) -> {
            // This is called for every model that is loaded, so make sure we only target ours
            if(context.id().equals(FOUR_SIDED_FURNACE_MODEL)) {
                return new TrellisBakedModel();
            } else {
                // If we don't modify the model we just return the original as-is
                return original;
            }
        });
    }
}