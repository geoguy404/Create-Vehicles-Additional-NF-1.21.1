package de.srr.createvehiclesadditional.datagen;


import com.tterrag.registrate.util.entry.BlockEntry;
import de.srr.createvehiclesadditional.Blocks.ModBlocks;
import de.srr.createvehiclesadditional.CreateVehiclesAdditional;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Set;

public class ModBlockstateProvider extends BlockStateProvider {

    // Alle manuellen Blöcke, die NICHT vom Provider generiert werden sollen
    private static final Set<BlockEntry<?>> MANUAL_BLOCKS = Set.of(
            ModBlocks.ELEMENT_SEPARATOR,
            ModBlocks.GAS_PIPE
            // Hier später weitere hinzufügen
    );

    public ModBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CreateVehiclesAdditional.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModBlocks.ALL_BLOCKS.stream()
                .filter(blockEntry -> !MANUAL_BLOCKS.contains(blockEntry)) // nur Deko-Blöcke
                .forEach(this::handleSimpleBlock);
    }

    private void handleSimpleBlock(BlockEntry<?> blockEntry) {
        // generisches Würfelmodell für alle automatischen Blöcke
        simpleBlockWithItem(blockEntry.get(), cubeAll(blockEntry.get()));
    }

    private String name(BlockEntry<?> blockEntry) {
        return blockEntry.getId().getPath();
    }
}
