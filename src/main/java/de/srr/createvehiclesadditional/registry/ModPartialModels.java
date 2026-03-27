package de.srr.createvehiclesadditional.registry;

import de.srr.createvehiclesadditional.CreateVehiclesAdditional;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.minecraft.resources.ResourceLocation;

public class ModPartialModels {

    // SEPARATOR
    public static PartialModel SEPARATOR_SHAFT;
    public static PartialModel SEPARATOR_LID1;
    public static PartialModel SEPARATOR_LID2;

    public static void init() {

        // SEPARATOR
        SEPARATOR_SHAFT = PartialModel.of(
                ResourceLocation.fromNamespaceAndPath(CreateVehiclesAdditional.MOD_ID, "block/separator_shaft"));
        SEPARATOR_LID1 = PartialModel.of(
                ResourceLocation.fromNamespaceAndPath(CreateVehiclesAdditional.MOD_ID, "block/separator_lid1"));
        SEPARATOR_LID2 = PartialModel.of(
                ResourceLocation.fromNamespaceAndPath(CreateVehiclesAdditional.MOD_ID, "block/separator_lid2"));

    }
}