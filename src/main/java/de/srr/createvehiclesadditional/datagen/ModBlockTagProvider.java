package de.srr.createvehiclesadditional.datagen;

import de.srr.createvehiclesadditional.Blocks.ModBlocks;
import de.srr.createvehiclesadditional.CreateVehiclesAdditional;
import de.srr.createvehiclesadditional.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreateVehiclesAdditional.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOCK_OF_CARBON.get())
                .add(ModBlocks.TEMPERATURE_OVEN.get())
                .add(ModBlocks.CARBON_FIBER_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLOCK_OF_CARBON.get())
                .add(ModBlocks.TEMPERATURE_OVEN.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CARBON_FIBER_BLOCK.get());

        tag(ModTags.Blocks.NEEDS_CARBON_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_CARBON_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_CARBON_TOOL);
    }
}
