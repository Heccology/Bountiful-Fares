package net.hecco.bountifulfares.definition.block.entity.renderer.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class TrellisBlockEntityModel {

    public static LayerDefinition createDefaultLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("vines", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -16.0F, 6.975F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition foliage_bottom_r1 = bone.addOrReplaceChild("foliage_bottom_r1", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 6.975F, -0.3927F, 0.0F, 0.0F));

        PartDefinition foliage_top_r1 = bone.addOrReplaceChild("foliage_top_r1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 6.975F, -0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public static LayerDefinition createInvertedLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("vines", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -16.0F, 6.975F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition foliage_bottom_r1 = bone.addOrReplaceChild("foliage_bottom_r1", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-8.0F, -8.0F, 0.0F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 6.975F, 0.3927F, 0.0F, 0.0F));

        PartDefinition foliage_top_r1 = bone.addOrReplaceChild("foliage_top_r1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -8.0F, 0.0F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -8.0F, 6.975F, 0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }
}
