package net.hecco.bountifulfares.definition.entity.villager;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.definition.block.entity.TrellisBlockEntity;
import net.hecco.bountifulfares.definition.data.trellis.TrellisCropDefinition;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BlockPosTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HarvestTrellis extends Behavior<Villager> {
    @Nullable
    private BlockPos inTrellisPos;
    private long nextOkStartTime;
    private int timeWorkedSoFar;
    private final List<BlockPos> validTrellisesAroundVillager = Lists.newArrayList();

    public HarvestTrellis() {
        super(ImmutableMap.of(MemoryModuleType.LOOK_TARGET, MemoryStatus.VALUE_ABSENT, MemoryModuleType.WALK_TARGET, MemoryStatus.VALUE_ABSENT, MemoryModuleType.SECONDARY_JOB_SITE, MemoryStatus.VALUE_PRESENT));
    }

    protected boolean checkExtraStartConditions(ServerLevel level, @NotNull Villager owner) {
        if (!level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            return false;
        } else if (owner.getVillagerData().getProfession() != VillagerProfession.FARMER) {
            return false;
        } else {
            BlockPos.MutableBlockPos blockpos$mutableblockpos = owner.blockPosition().mutable();
            this.validTrellisesAroundVillager.clear();

            for(int i = -1; i <= 1; ++i) {
                for(int j = -1; j <= 3; ++j) {
                    for(int k = -1; k <= 1; ++k) {
                        blockpos$mutableblockpos.set(owner.getX() + (double)i, owner.getY() + (double)j, owner.getZ() + (double)k);
                        if (this.validPos(blockpos$mutableblockpos, level)) {
                            this.validTrellisesAroundVillager.add(new BlockPos(blockpos$mutableblockpos));
                        }
                    }
                }
            }

            this.inTrellisPos = this.getValidTrellis(level);
            return this.inTrellisPos != null;
        }
    }

    @Nullable
    private BlockPos getValidTrellis(ServerLevel serverLevel) {
        return this.validTrellisesAroundVillager.isEmpty() ? null : this.validTrellisesAroundVillager.get(serverLevel.getRandom().nextInt(this.validTrellisesAroundVillager.size()));
    }

    private boolean validPos(BlockPos pos, ServerLevel serverLevel) {
        BlockEntity entity = serverLevel.getBlockEntity(pos);
        return entity instanceof TrellisBlockEntity entity1 && TrellisBlock.CROPS.containsKey(entity1.getPlant()) && entity1.getStage() == TrellisBlock.CROPS.get(entity1.getPlant()).stages();
    }

    protected void start(@NotNull ServerLevel level, @NotNull Villager entity, long gameTime) {
        if (gameTime > this.nextOkStartTime && this.inTrellisPos != null) {
            entity.getBrain().setMemory(MemoryModuleType.LOOK_TARGET, new BlockPosTracker(this.inTrellisPos));
            entity.getBrain().setMemory(MemoryModuleType.WALK_TARGET, new WalkTarget(new BlockPosTracker(this.inTrellisPos), 0.5F, 1));
        }

    }

    protected void stop(@NotNull ServerLevel level, Villager entity, long gameTime) {
        entity.getBrain().eraseMemory(MemoryModuleType.LOOK_TARGET);
        entity.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
        this.timeWorkedSoFar = 0;
        this.nextOkStartTime = gameTime + 40L;
    }

    protected void tick(@NotNull ServerLevel level, @NotNull Villager owner, long gameTime) {
        if (this.inTrellisPos == null || this.inTrellisPos.closerToCenterThan(owner.position(), 1.0F) || this.inTrellisPos.closerToCenterThan(owner.position().add(0, 1, 0), 1.5F) || this.inTrellisPos.closerToCenterThan(owner.position().add(0, 2, 0), 1.5F)) {
            if (this.inTrellisPos != null && gameTime > this.nextOkStartTime) {
                BlockEntity entity1 = level.getBlockEntity(this.inTrellisPos);

                if (entity1 instanceof TrellisBlockEntity entity) {
                    if (validPos(this.inTrellisPos, level)) {
                        TrellisCropDefinition crop = TrellisBlock.CROPS.get(entity.getPlant());
                        if (entity.getStage() >= crop.stages()) {
                            entity.setStage(Math.max(entity.getStage() - 2, 0));
                            TrellisBlock.popResource(level, this.inTrellisPos, new ItemStack(crop.produce(), crop.minDrops() != crop.maxDrops() ? level.random.nextInt(Math.min(crop.minDrops(), crop.maxDrops()), Math.max(crop.minDrops(), crop.maxDrops())) : crop.minDrops()));
                            level.playSound(null, this.inTrellisPos, BFSounds.HANGING_FRUIT_PICK.get(), SoundSource.BLOCKS, 1.0f, 1.0f + (level.random.nextFloat() / 5));
                        }
                    }

                    if (TrellisBlock.CROPS.containsKey(entity.getPlant()) && entity.getStage() != TrellisBlock.CROPS.get(entity.getPlant()).stages()) {
                        this.validTrellisesAroundVillager.remove(this.inTrellisPos);
                        this.inTrellisPos = this.getValidTrellis(level);
                        if (this.inTrellisPos != null) {
                            this.nextOkStartTime = gameTime + 20L;
                            owner.getBrain().setMemory(MemoryModuleType.WALK_TARGET, new WalkTarget(new BlockPosTracker(this.inTrellisPos), 0.5F, 1));
                            owner.getBrain().setMemory(MemoryModuleType.LOOK_TARGET, new BlockPosTracker(this.inTrellisPos));
                        }
                    }
                }
            }

            ++this.timeWorkedSoFar;
        }

    }

    protected boolean canStillUse(@NotNull ServerLevel level, @NotNull Villager entity, long gameTime) {
        return this.timeWorkedSoFar < 200;
    }
}
