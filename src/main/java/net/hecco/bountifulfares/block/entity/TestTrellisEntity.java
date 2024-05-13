package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.block.ModBlocks;
import net.mehvahdjukaar.moonlight.api.block.ItemDisplayTile;
import net.mehvahdjukaar.moonlight.api.client.model.ExtraModelData;
import net.mehvahdjukaar.moonlight.api.client.model.IExtraModelDataProvider;
import net.mehvahdjukaar.moonlight.api.client.model.ModelDataKey;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class TestTrellisEntity extends ItemDisplayTile implements IExtraModelDataProvider {

    public static final ModelDataKey<BlockState> FACING = new ModelDataKey<>(BlockState.class);

    public TestTrellisEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TEST_TRELLIS_BLOCK_ENTITY, pos, state, 3);
    }
    @Override
    public void addExtraModelData(ExtraModelData.Builder builder) {
        builder.with(FACING, ModBlocks.TRELLIS.getDefaultState());
    }

    @Override
    public void updateClientVisualsOnLoad() {
        this.requestModelReload();
    }

    @Override
    public Text getName() {
        return Text.translatable("block.bountifulfares.trellis");
    }

    @Override
    protected Text getContainerName() {
        return getName();
    }

    @Override
    public void afterDataPacket(ExtraModelData oldData) {
        IExtraModelDataProvider.super.afterDataPacket(oldData);
    }
}
