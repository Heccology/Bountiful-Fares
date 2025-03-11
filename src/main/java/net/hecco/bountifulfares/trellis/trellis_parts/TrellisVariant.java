package net.hecco.bountifulfares.trellis.trellis_parts;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.CropTrellisBlock;
import net.hecco.bountifulfares.block.custom.DecorativeTrellisBlock;
import net.hecco.bountifulfares.block.custom.TrellisBlock;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatCropTrellisBlock;
import net.hecco.bountifulfares.compat.block.CompatDecorativeTrellisBlock;
import net.hecco.bountifulfares.compat.block.CompatTrellisBlock;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
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
    private final Identifier CRAFTING_ITEM;
    private final BlockSoundGroup SOUND_GROUP;
    private final BlockSoundGroup PLANTED_SOUND_GROUP;
    private final float HARDNESS;


    public TrellisVariant(String modId, String id, @Nullable Item planks, ArrayList<Block> renderCutoutList) {
        this.MOD_ID = modId;
        this.VARIANT_ID = id;
        this.PLANKS = planks;
        this.CRAFTING_ITEM = null;
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
        this.CRAFTING_ITEM = null;
        this.SOUND_GROUP = soundGroup;
        this.PLANTED_SOUND_GROUP = plantedSoundGroup;
        this.HARDNESS = hardness;
        TrellisUtil.TrellisVariants.add(this);
        registerTrellisBlocks(renderCutoutList);
    }

    public TrellisVariant(String modId, String id, Identifier craftingItem, ArrayList<Block> renderCutoutList) {
        this.MOD_ID = modId;
        this.VARIANT_ID = id;
        this.PLANKS = null;
        this.CRAFTING_ITEM = craftingItem;
        this.SOUND_GROUP = BFSounds.LIGHT_WOOD;
        this.PLANTED_SOUND_GROUP = BFSounds.PLANTED_TRELLIS;
        this.HARDNESS = 0.5F;
        TrellisUtil.TrellisVariants.add(this);
        registerTrellisBlocks(renderCutoutList);
    }

    public TrellisVariant(String modId, String id, Identifier craftingItem, BlockSoundGroup soundGroup, BlockSoundGroup plantedSoundGroup, float hardness, ArrayList<Block> renderCutoutList) {
        this.MOD_ID = modId;
        this.VARIANT_ID = id;
        this.PLANKS = null;
        this.CRAFTING_ITEM = craftingItem;
        this.SOUND_GROUP = soundGroup;
        this.PLANTED_SOUND_GROUP = plantedSoundGroup;
        this.HARDNESS = hardness;
        TrellisUtil.TrellisVariants.add(this);
        registerTrellisBlocks(renderCutoutList);
    }
    
    private void registerTrellisBlocks(ArrayList<Block> renderCutoutList) {
        registerTrellis(renderCutoutList);

        registerCropTrellis(renderCutoutList, BFTrellises.PASSION_FRUIT);

        registerCropTrellis(renderCutoutList, BFTrellises.ELDERBERRY);

        registerCropTrellis(renderCutoutList, BFTrellises.LAPISBERRY);

        registerCropTrellis(renderCutoutList, BFTrellises.GLOW_BERRY);


        registerDecorativeTrellis(renderCutoutList, BFTrellises.ROSE);

        registerDecorativeTrellis(renderCutoutList, BFTrellises.LILAC);

        registerDecorativeTrellis(renderCutoutList, BFTrellises.PEONY);

        registerDecorativeTrellis(renderCutoutList, BFTrellises.SUNFLOWER);

        registerDecorativeTrellis(renderCutoutList, BFTrellises.VINE);

        registerDecorativeTrellis(renderCutoutList, BFTrellises.WEEPING);

        registerDecorativeTrellis(renderCutoutList, BFTrellises.TWISTING);


        if (BountifulFares.isDatagen() || BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
            registerDecorativeTrellis(renderCutoutList, BFTrellises.NS_LAVENDER);

            registerDecorativeTrellis(renderCutoutList, BFTrellises.NS_BLEEDING_HEART);

            registerDecorativeTrellis(renderCutoutList, BFTrellises.NS_BLUE_BULB);

            registerDecorativeTrellis(renderCutoutList, BFTrellises.NS_CARNATION);

            registerDecorativeTrellis(renderCutoutList, BFTrellises.NS_GARDENIA);

            registerDecorativeTrellis(renderCutoutList, BFTrellises.NS_MARIGOLD);

            registerDecorativeTrellis(renderCutoutList, BFTrellises.NS_FOXGLOVE);
        }

        if (BountifulFares.isDatagen() || BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
            registerCropTrellis(renderCutoutList, BFTrellises.SPAWN_SUNFLOWER);
        }
    }

    private void registerTrellis(ArrayList<Block> renderCutoutList) {
        if (Objects.equals(this.MOD_ID, BountifulFares.MOD_ID)) {
            BFTrellises.TRELLISES.put(this.getBlockName(), registerBlock(this.getModId(), this.getBlockName(), new TrellisBlock(this, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).sounds(this.SOUND_GROUP).instrument(NoteBlockInstrument.BASS).nonOpaque())));
        } else {
            BFTrellises.TRELLISES.put(this.getBlockName(), registerCompatBlock(this.getModId(), this.getBlockName(), new CompatTrellisBlock(this.MOD_ID, this, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).sounds(this.SOUND_GROUP).instrument(NoteBlockInstrument.BASS).nonOpaque())));
        }
        renderCutoutList.add(BFTrellises.TRELLISES.get(this.getBlockName()));
    }

    private void registerCropTrellis(ArrayList<Block> renderCutoutList, VineCrop crop) {
        if (Objects.equals(this.MOD_ID, BountifulFares.MOD_ID)) {
            BFTrellises.CROP_TRELLISES.put(crop.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), crop.getName() + "_" + this.getBlockName(), new CropTrellisBlock(crop.getSeedsItem(), crop.getCropItem(), this, crop, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(NoteBlockInstrument.BASS).nonOpaque().ticksRandomly().sounds(this.PLANTED_SOUND_GROUP))));
        } else {
            BFTrellises.CROP_TRELLISES.put(crop.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), crop.getName() + "_" + this.getBlockName(), new CompatCropTrellisBlock(this.MOD_ID, crop.getSeedsItem(), crop.getCropItem(), this, crop, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(NoteBlockInstrument.BASS).nonOpaque().ticksRandomly().sounds(this.PLANTED_SOUND_GROUP))));
        }
        renderCutoutList.add(BFTrellises.CROP_TRELLISES.get(crop.getName() + this.getBlockName()));
    }

    private void registerDecorativeTrellis(ArrayList<Block> renderCutoutList, DecorativeVine vine) {
        if (Objects.equals(this.MOD_ID, BountifulFares.MOD_ID)) {
            BFTrellises.DECORATIVE_TRELLISES.put(vine.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), vine.getName() + "_" + this.getBlockName(), new DecorativeTrellisBlock(vine.canDuplicate(), vine.getPlantItem(), this, vine, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(NoteBlockInstrument.BASS).nonOpaque().sounds(this.PLANTED_SOUND_GROUP))));
        } else {
            BFTrellises.DECORATIVE_TRELLISES.put(vine.getName() + this.getBlockName(), registerBlockNoItem(this.getModId(), vine.getName() + "_" + this.getBlockName(), new CompatDecorativeTrellisBlock(this.MOD_ID, vine.canDuplicate(), vine.getPlantItem(), this, vine, FabricBlockSettings.create().nonOpaque().strength(this.HARDNESS).instrument(NoteBlockInstrument.BASS).nonOpaque().sounds(this.PLANTED_SOUND_GROUP))));
        }
        renderCutoutList.add(BFTrellises.DECORATIVE_TRELLISES.get(vine.getName() + this.getBlockName()));
    }

    public Block registerCompatBlock(String id, String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(this.MOD_ID, name), new CompatBlockItem(this.MOD_ID, block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, Identifier.of(this.MOD_ID, name), block);
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
    public Identifier getCraftingItemIdentifier() {
        return this.CRAFTING_ITEM;
    }

    @Override
    public String toString() {
        return "[" + VARIANT_ID + "]";
    }
}
