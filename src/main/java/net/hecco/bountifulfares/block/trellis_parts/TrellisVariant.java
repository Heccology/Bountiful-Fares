package net.hecco.bountifulfares.block.trellis_parts;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.block.ModTrellises;
import net.hecco.bountifulfares.block.TrellisVariants;
import net.hecco.bountifulfares.block.custom.CropTrellisBlock;
import net.hecco.bountifulfares.block.custom.DecorativeTrellisBlock;
import net.hecco.bountifulfares.block.custom.TrellisBlock;
import net.hecco.bountifulfares.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Objects;

import static net.hecco.bountifulfares.block.TrellisVariants.registerBlock;
import static net.hecco.bountifulfares.block.TrellisVariants.registerBlockNoItem;

public class TrellisVariant {
    private final String MOD_ID;
    private final String VARIANT_ID;

//    Used for crafting recipes, can be ignored if there is no planks to craft it with
    private final Item PLANKS;


    public TrellisVariant(String modId, String id, @Nullable Item planks, ArrayList<Block> renderCutoutList) {
        this.MOD_ID = modId;
        this.VARIANT_ID = id;
        this.PLANKS = planks;
        TrellisVariants.TrellisVariants.add(this);
        ModTrellises.TRELLISES.put(this.getBlockName(), registerBlock(this.getModId(), this.getBlockName(), new TrellisBlock(this, FabricBlockSettings.create().nonOpaque().strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).nonOpaque())));
        renderCutoutList.add(ModTrellises.TRELLISES.get(this.getBlockName()));

        ModTrellises.CROP_TRELLISES.put(ModTrellises.PASSION_FRUIT.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.PASSION_FRUIT.getName() + "_" + this.getBlockName(), new CropTrellisBlock(ModTrellises.PASSION_FRUIT.getSeedsItem(), ModTrellises.PASSION_FRUIT.getCropItem(), this, ModTrellises.PASSION_FRUIT, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS))));
        renderCutoutList.add(ModTrellises.CROP_TRELLISES.get(ModTrellises.PASSION_FRUIT.getName() + this.getBlockName()));

        ModTrellises.CROP_TRELLISES.put(ModTrellises.ELDERBERRY.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.ELDERBERRY.getName() + "_" + this.getBlockName(), new CropTrellisBlock(ModTrellises.ELDERBERRY.getSeedsItem(), ModTrellises.ELDERBERRY.getCropItem(), this, ModTrellises.ELDERBERRY, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS))));
        renderCutoutList.add(ModTrellises.CROP_TRELLISES.get(ModTrellises.ELDERBERRY.getName() + this.getBlockName()));

        ModTrellises.CROP_TRELLISES.put(ModTrellises.LAPISBERRY.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.LAPISBERRY.getName() + "_" + this.getBlockName(), new CropTrellisBlock(ModTrellises.LAPISBERRY.getSeedsItem(), ModTrellises.LAPISBERRY.getCropItem(), this, ModTrellises.LAPISBERRY, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS))));
        renderCutoutList.add(ModTrellises.CROP_TRELLISES.get(ModTrellises.LAPISBERRY.getName() + this.getBlockName()));

        ModTrellises.CROP_TRELLISES.put(ModTrellises.GLOW_BERRY.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.GLOW_BERRY.getName() + "_" + this.getBlockName(), new CropTrellisBlock(ModTrellises.GLOW_BERRY.getSeedsItem(), ModTrellises.GLOW_BERRY.getCropItem(), this, ModTrellises.GLOW_BERRY, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS).luminance(ModBlocks.createLightLevelFromAgeBlockState(0, 6, 12)))));
        renderCutoutList.add(ModTrellises.CROP_TRELLISES.get(ModTrellises.GLOW_BERRY.getName() + this.getBlockName()));

        ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.ROSE.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.ROSE.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.ROSE.canDuplicate(), ModTrellises.ROSE.getPlantItem(), this, ModTrellises.ROSE, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
        renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.ROSE.getName() + this.getBlockName()));

        ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.LILAC.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.LILAC.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.LILAC.canDuplicate(), ModTrellises.LILAC.getPlantItem(), this, ModTrellises.LILAC, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
        renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.LILAC.getName() + this.getBlockName()));

        ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.PEONY.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.PEONY.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.PEONY.canDuplicate(), ModTrellises.PEONY.getPlantItem(), this, ModTrellises.PEONY, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
        renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.PEONY.getName() + this.getBlockName()));

        ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.SUNFLOWER.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.SUNFLOWER.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.SUNFLOWER.canDuplicate(), ModTrellises.SUNFLOWER.getPlantItem(), this, ModTrellises.SUNFLOWER, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
        renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.SUNFLOWER.getName() + this.getBlockName()));

        ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.VINE.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.VINE.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.VINE.canDuplicate(), ModTrellises.VINE.getPlantItem(), this, ModTrellises.VINE, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
        renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.VINE.getName() + this.getBlockName()));

        ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.WEEPING.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.WEEPING.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.WEEPING.canDuplicate(), ModTrellises.WEEPING.getPlantItem(), this, ModTrellises.WEEPING, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
        renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.WEEPING.getName() + this.getBlockName()));

        ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.TWISTING.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.TWISTING.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.TWISTING.canDuplicate(), ModTrellises.TWISTING.getPlantItem(), this, ModTrellises.TWISTING, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
        renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.TWISTING.getName() + this.getBlockName()));

        if (System.getProperty("fabric-api.datagen") != null || FabricLoader.getInstance().isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
            ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.NS_LAVENDER.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.NS_LAVENDER.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.NS_LAVENDER.canDuplicate(), ModTrellises.NS_LAVENDER.getPlantItem(), this, ModTrellises.NS_LAVENDER, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
            renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.NS_LAVENDER.getName() + this.getBlockName()));

            ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.NS_BLEEDING_HEART.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.NS_BLEEDING_HEART.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.NS_BLEEDING_HEART.canDuplicate(), ModTrellises.NS_BLEEDING_HEART.getPlantItem(), this, ModTrellises.NS_BLEEDING_HEART, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
            renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.NS_BLEEDING_HEART.getName() + this.getBlockName()));

            ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.NS_BLUE_BULB.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.NS_BLUE_BULB.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.NS_BLUE_BULB.canDuplicate(), ModTrellises.NS_BLUE_BULB.getPlantItem(), this, ModTrellises.NS_BLUE_BULB, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
            renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.NS_BLUE_BULB.getName() + this.getBlockName()));

            ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.NS_CARNATION.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.NS_CARNATION.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.NS_CARNATION.canDuplicate(), ModTrellises.NS_CARNATION.getPlantItem(), this, ModTrellises.NS_CARNATION, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
            renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.NS_CARNATION.getName() + this.getBlockName()));

            ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.NS_GARDENIA.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.NS_GARDENIA.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.NS_GARDENIA.canDuplicate(), ModTrellises.NS_GARDENIA.getPlantItem(), this, ModTrellises.NS_GARDENIA, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
            renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.NS_GARDENIA.getName() + this.getBlockName()));

            ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.NS_MARIGOLD.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.NS_MARIGOLD.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.NS_MARIGOLD.canDuplicate(), ModTrellises.NS_MARIGOLD.getPlantItem(), this, ModTrellises.NS_MARIGOLD, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
            renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.NS_MARIGOLD.getName() + this.getBlockName()));

            ModTrellises.DECORATIVE_TRELLISES.put(ModTrellises.NS_FOXGLOVE.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), ModTrellises.NS_FOXGLOVE.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(ModTrellises.NS_FOXGLOVE.canDuplicate(), ModTrellises.NS_FOXGLOVE.getPlantItem(), this, ModTrellises.NS_FOXGLOVE, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
            renderCutoutList.add(ModTrellises.DECORATIVE_TRELLISES.get(ModTrellises.NS_FOXGLOVE.getName() + this.getBlockName()));
        }

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
