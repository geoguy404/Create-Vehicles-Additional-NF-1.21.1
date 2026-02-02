package de.srr.createvehiclesadditional.BlockEntities;


import com.tterrag.registrate.util.entry.BlockEntityEntry;
import de.srr.createvehiclesadditional.Blocks.ModBlocks;

import static de.srr.createvehiclesadditional.CreateVehiclesAdditional.REGISTRATE;

public class ModBlockEntities {

    public static final BlockEntityEntry<GasPipeBlockEntity> GAS_PIPE =
            REGISTRATE.blockEntity("gas_pipe", GasPipeBlockEntity::new)
                    .validBlocks(ModBlocks.GAS_PIPE)
                    .register();

    public static final BlockEntityEntry<ElementSeparatorBlockEntity> ELEMENT_SEPARATOR = REGISTRATE
            .blockEntity("element_separator", ElementSeparatorBlockEntity::new)
            .validBlocks(ModBlocks.ELEMENT_SEPARATOR)
            .register();

    public static void register() {}
}