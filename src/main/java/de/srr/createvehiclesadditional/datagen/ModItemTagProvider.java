package de.srr.createvehiclesadditional.datagen;

import de.srr.createvehiclesadditional.CreateVehiclesAdditional;
import de.srr.createvehiclesadditional.Items.ModItems;
import de.srr.createvehiclesadditional.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, CreateVehiclesAdditional.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    tag(ModTags.Items.TRANSFORMABLE_ITEMS)
            .add(ModItems.BUCKET_OF_ACRYLONITRILE.get());

    tag(ItemTags.SWORDS)
            .add(ModItems.CARBON_SWORD.get());
        tag(ItemTags.AXES)
                .add(ModItems.CARBON_AXE.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.CARBON_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.CARBON_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.CARBON_HOE.get());
    }
}
