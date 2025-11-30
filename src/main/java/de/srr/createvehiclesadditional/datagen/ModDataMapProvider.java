package de.srr.createvehiclesadditional.datagen;

import de.srr.createvehiclesadditional.Items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {

    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    public void run() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.CARBON.getId(), new FurnaceFuel(800), false);
    }
}