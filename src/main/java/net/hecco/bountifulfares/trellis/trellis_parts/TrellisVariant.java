package net.hecco.bountifulfares.trellis.trellis_parts;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.trellis.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.block.custom.CropTrellisBlock;
import net.hecco.bountifulfares.block.custom.DecorativeTrellisBlock;
import net.hecco.bountifulfares.block.custom.TrellisBlock;
import net.hecco.bountifulfares.sounds.BFSounds;
import net.minecraft.block.Block;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Objects;

import static net.hecco.bountifulfares.trellis.TrellisUtil.registerBlock;
import static net.hecco.bountifulfares.trellis.TrellisUtil.registerBlockNoItem;

public class TrellisVariant {
    private final String MOD_ID;
    private final String VARIANT_ID;

//    Used for crafting recipes, can be ignored if there is no planks to craft it with
    private final Item PLANKS;
    private final BlockSoundGroup SOUND_GROUP;
    private final BlockSoundGroup PLANTED_SOUND_GROUP;
    private final float HARDNESS;


    public TrellisVariant(String modId, String id, @Nullable Item planks, ArrayList<Block> renderCutoutList) {
        this.MOD_ID = modId;
        this.VARIANT_ID = id;
        this.PLANKS = planks;
        this.SOUND_GROUP = BFSounds.LIGHT_WOOD;
        this.PLANTED_SOUND_GROUP = BFSounds.PLANTED_TRELLIS;
        this.HARDNESS = 0.5F;
        TrellisUtil.TrellisVariants.add(this);
        registerTrellisBlocks(renderCutoutList);
    }

    public TrellisVariant(String modId, String id, @Nullable Item planks, BlockSoundGroup soundGroup, BlockSoundGroup plantedSoundGroup, float hardness, ArrayList<Block> renderCutoutList) {
        this.MOD_ID = modId;
        this.VARIANT_ID = id;
        this.PLANKS = planks;
        this.SOUND_GROUP = soundGroup;
        this.PLANTED_SOUND_GROUP = plantedSoundGroup;
        this.HARDNESS = hardness;
        TrellisUtil.TrellisVariants.add(this);
        registerTrellisBlocks(renderCutoutList);
    }
    
    private void registerTrellisBlocks(ArrayList<Block> renderCutoutList) {
        BFTrellises.TRELLISES.put(this.getBlockName(), registerBlock(this.getModId(), this.getBlockName(), new TrellisBlock(this, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).sounds(this.SOUND_GROUP).instrument(Instrument.BASS).nonOpaque())));
        renderCutoutList.add(BFTrellises.TRELLISES.get(this.getBlockName()));

        BFTrellises.CROP_TRELLISES.put(BFTrellises.PASSION_FRUIT.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), BFTrellises.PASSION_FRUIT.getName() + "_" + this.getBlockName(), new CropTrellisBlock(BFTrellises.PASSION_FRUIT.getSeedsItem(), BFTrellises.PASSION_FRUIT.getCropItem(), this, BFTrellises.PASSION_FRUIT, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(this.PLANTED_SOUND_GROUP))));
        renderCutoutList.add(BFTrellises.CROP_TRELLISES.get(BFTrellises.PASSION_FRUIT.getName() + this.getBlockName()));

        BFTrellises.CROP_TRELLISES.put(BFTrellises.ELDERBERRY.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), BFTrellises.ELDERBERRY.getName() + "_" + this.getBlockName(), new CropTrellisBlock(BFTrellises.ELDERBERRY.getSeedsItem(), BFTrellises.ELDERBERRY.getCropItem(), this, BFTrellises.ELDERBERRY, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(this.PLANTED_SOUND_GROUP))));
        renderCutoutList.add(BFTrellises.CROP_TRELLISES.get(BFTrellises.ELDERBERRY.getName() + this.getBlockName()));

        BFTrellises.CROP_TRELLISES.put(BFTrellises.LAPISBERRY.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), BFTrellises.LAPISBERRY.getName() + "_" + this.getBlockName(), new CropTrellisBlock(BFTrellises.LAPISBERRY.getSeedsItem(), BFTrellises.LAPISBERRY.getCropItem(), this, BFTrellises.LAPISBERRY, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(this.PLANTED_SOUND_GROUP))));
        renderCutoutList.add(BFTrellises.CROP_TRELLISES.get(BFTrellises.LAPISBERRY.getName() + this.getBlockName()));

        BFTrellises.CROP_TRELLISES.put(BFTrellises.GLOW_BERRY.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), BFTrellises.GLOW_BERRY.getName() + "_" + this.getBlockName(), new CropTrellisBlock(BFTrellises.GLOW_BERRY.getSeedsItem(), BFTrellises.GLOW_BERRY.getCropItem(), this, BFTrellises.GLOW_BERRY, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(this.PLANTED_SOUND_GROUP).luminance(BFBlocks.createLightLevelFromAgeBlockState(0, 6, 12)))));
        renderCutoutList.add(BFTrellises.CROP_TRELLISES.get(BFTrellises.GLOW_BERRY.getName() + this.getBlockName()));

        BFTrellises.DECORATIVE_TRELLISES.put(BFTrellises.ROSE.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), BFTrellises.ROSE.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(BFTrellises.ROSE.canDuplicate(), BFTrellises.ROSE.getPlantItem(), this, BFTrellises.ROSE, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(Instrument.BASS).nonOpaque().sounds(this.PLANTED_SOUND_GROUP))));
        renderCutoutList.add(BFTrellises.DECORATIVE_TRELLISES.get(BFTrellises.ROSE.getName() + this.getBlockName()));

        BFTrellises.DECORATIVE_TRELLISES.put(BFTrellises.LILAC.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), BFTrellises.LILAC.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(BFTrellises.LILAC.canDuplicate(), BFTrellises.LILAC.getPlantItem(), this, BFTrellises.LILAC, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(Instrument.BASS).nonOpaque().sounds(this.PLANTED_SOUND_GROUP))));
        renderCutoutList.add(BFTrellises.DECORATIVE_TRELLISES.get(BFTrellises.LILAC.getName() + this.getBlockName()));

        BFTrellises.DECORATIVE_TRELLISES.put(BFTrellises.PEONY.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), BFTrellises.PEONY.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(BFTrellises.PEONY.canDuplicate(), BFTrellises.PEONY.getPlantItem(), this, BFTrellises.PEONY, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(Instrument.BASS).nonOpaque().sounds(this.PLANTED_SOUND_GROUP))));
        renderCutoutList.add(BFTrellises.DECORATIVE_TRELLISES.get(BFTrellises.PEONY.getName() + this.getBlockName()));

        BFTrellises.DECORATIVE_TRELLISES.put(BFTrellises.SUNFLOWER.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), BFTrellises.SUNFLOWER.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(BFTrellises.SUNFLOWER.canDuplicate(), BFTrellises.SUNFLOWER.getPlantItem(), this, BFTrellises.SUNFLOWER, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(Instrument.BASS).nonOpaque().sounds(this.PLANTED_SOUND_GROUP))));
        renderCutoutList.add(BFTrellises.DECORATIVE_TRELLISES.get(BFTrellises.SUNFLOWER.getName() + this.getBlockName()));

        BFTrellises.DECORATIVE_TRELLISES.put(BFTrellises.VINE.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), BFTrellises.VINE.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(BFTrellises.VINE.canDuplicate(), BFTrellises.VINE.getPlantItem(), this, BFTrellises.VINE, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(Instrument.BASS).nonOpaque().sounds(this.PLANTED_SOUND_GROUP))));
        renderCutoutList.add(BFTrellises.DECORATIVE_TRELLISES.get(BFTrellises.VINE.getName() + this.getBlockName()));

        BFTrellises.DECORATIVE_TRELLISES.put(BFTrellises.WEEPING.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), BFTrellises.WEEPING.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(BFTrellises.WEEPING.canDuplicate(), BFTrellises.WEEPING.getPlantItem(), this, BFTrellises.WEEPING, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(Instrument.BASS).nonOpaque().sounds(this.PLANTED_SOUND_GROUP))));
        renderCutoutList.add(BFTrellises.DECORATIVE_TRELLISES.get(BFTrellises.WEEPING.getName() + this.getBlockName()));

        BFTrellises.DECORATIVE_TRELLISES.put(BFTrellises.TWISTING.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), BFTrellises.TWISTING.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(BFTrellises.TWISTING.canDuplicate(), BFTrellises.TWISTING.getPlantItem(), this, BFTrellises.TWISTING, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(Instrument.BASS).nonOpaque().sounds(this.PLANTED_SOUND_GROUP))));
        renderCutoutList.add(BFTrellises.DECORATIVE_TRELLISES.get(BFTrellises.TWISTING.getName() + this.getBlockName()));
    }

    public String getVariantName() {
        return this.VARIANT_ID;
    }

    public String getBlockName() {
        if (Objects.equals(VARIANT_ID, "oak")) {
            return "trellis";
        }
        return this.getVariantName() + "_trellis";
    }

    public String getModId() {
        return this.MOD_ID;
    }

    public Item getCraftingItem() {
        return this.PLANKS;
    }

    @Override
    public String toString() {
        return "[" + VARIANT_ID + "]";
    }
}
