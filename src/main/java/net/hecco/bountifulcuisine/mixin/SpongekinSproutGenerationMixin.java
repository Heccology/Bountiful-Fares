package net.hecco.bountifulcuisine.mixin;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FluidState;
import net.minecraft.structure.OceanMonumentGenerator;
import net.minecraft.structure.StructurePiece;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.structure.OceanMonumentStructure;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OceanMonumentGenerator.SimpleRoomTop.class)
public class SpongekinSproutGenerationMixin {
    @Inject(method = "generate", at = @At("TAIL"))
    private void generateSpongekinSprouts(StructureWorldAccess world, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox chunkBox, ChunkPos chunkPos, BlockPos pivot, CallbackInfo ci) {

        for (int i = chunkBox.getMinX(); i <= 7 + chunkBox.getMaxX(); ++i) {
            for (int j = chunkBox.getMinY(); j <= 7 + chunkBox.getMaxY(); ++j) {
                for (int k = chunkBox.getMinZ(); k <= 7 + chunkBox.getMaxZ(); ++k) {
                    BlockPos.Mutable blockPos = new BlockPos.Mutable(i, j, k);
//                    if (!chunkBox.contains(blockPos)) {
//                        return;
//                    }
                    world.setBlockState(blockPos, Blocks.GOLD_BLOCK.getDefaultState(), 2);
                    BountifulCuisine.LOGGER.info("kljadfhljkashdflkjhsdflkjhsdf " + blockPos);
                }
            }
        }
//        world.setBlockState(new BlockPos(x, y, z), Blocks.GOLD_BLOCK.getDefaultState(), 2);
    }
}
