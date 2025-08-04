package net.hecco.bountifulfares.mixin.misc;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OceanMonumentPieces.OceanMonumentSimpleTopRoom.class)
public abstract class OceanMonumentPiecesMixin extends StructurePiece {

    protected OceanMonumentPiecesMixin(StructurePieceType type, int genDepth, BoundingBox boundingBox) {
        super(type, genDepth, boundingBox);
    }

    @Inject(method = "postProcess", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/structure/structures/OceanMonumentPieces$OceanMonumentSimpleTopRoom;generateBox(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;IIIIIILnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/state/BlockState;Z)V"))
    private void bountifulfares$generateSpongekinSprouts(WorldGenLevel level, StructureManager structureManager, ChunkGenerator generator, RandomSource random, BoundingBox box, ChunkPos chunkPos, BlockPos pos, CallbackInfo ci) {
        BlockState blockstate = BFBlocks.SPONGEKIN_SPROUT.get().defaultBlockState();
        this.generateBox(level, box, 1, 1, 1, 1, 1, 1, blockstate, blockstate, false);
        this.generateBox(level, box, 2, 1, 1, 2, 1, 1, blockstate, blockstate, false);
        this.generateBox(level, box, 3, 1, 2, 3, 1, 2, blockstate, blockstate, false);
        this.generateBox(level, box, 5, 1, 1, 5, 1, 1, blockstate, blockstate, false);
        this.generateBox(level, box, 5, 1, 1, 5, 1, 1, blockstate, blockstate, false);
        this.generateBox(level, box, 5, 1, 2, 5, 1, 2, blockstate, blockstate, false);
        this.generateBox(level, box, 6, 1, 2, 6, 1, 2, blockstate, blockstate, false);
        this.generateBox(level, box, 5, 1, 4, 5, 1, 4, blockstate, blockstate, false);
        this.generateBox(level, box, 3, 1, 6, 5, 1, 6, blockstate, blockstate, false);
        this.generateBox(level, box, 3, 1, 5, 3, 1, 5, blockstate, blockstate, false);
        this.generateBox(level, box, 1, 1, 6, 1, 1, 6, blockstate, blockstate, false);
        this.generateBox(level, box, 1, 1, 4, 1, 1, 4, blockstate, blockstate, false);
    }
}
