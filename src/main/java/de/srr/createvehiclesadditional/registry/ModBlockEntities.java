package de.srr.createvehiclesadditional.registry;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import de.srr.createvehiclesadditional.BlockEntities.ElementSeparatorBlockEntity;
import de.srr.createvehiclesadditional.Blocks.ModBlocks;

import static de.srr.createvehiclesadditional.CreateVehiclesAdditional.REGISTRATE;

public class ModBlockEntities {

    public static final BlockEntityEntry<ElementSeparatorBlockEntity> ELEMENT_SEPARATOR = REGISTRATE
                    .blockEntity("element_separator", ElementSeparatorBlockEntity::new)
                    .validBlocks(ModBlocks.ELEMENT_SEPARATOR)
                    .register();

    public static void register() {
        // nur Classloading
    }
}