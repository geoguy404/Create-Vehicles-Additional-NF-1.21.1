package de.srr.createvehiclesadditional;

import com.simibubi.create.content.fluids.FluidTransportBehaviour;
import de.srr.createvehiclesadditional.content.fluids.pipes.CVAPipes;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.data.Couple;
import net.createmod.catnip.data.Iterate;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

import java.util.*;

public class CVAPartialModels {

    public static final List<PartialModel> SEGMENTS = new ArrayList<>();
    public static final Map<CVAPipes.PipeMaterial, PartialModel> PIPE_CASINGS = new HashMap<>();
    public static final Map<ResourceLocation, Couple<PartialModel>> FOLDING_DOORS = new HashMap<>();
    public static final Map<CVAPipes.PipeMaterial, Map<FluidTransportBehaviour.AttachmentTypes.ComponentPartials, Map<Direction, PartialModel>>> PIPE_ATTACHMENTS = new HashMap<>();

    static {

        for (int i = 0; i < 21; i++) {

            SEGMENTS.add(block("segmented_display/segments/" + i));

        }


    }

    static {

        for (CVAPipes.PipeMaterial material : CVAPipes.PipeMaterial.values()) {

            Map<FluidTransportBehaviour.AttachmentTypes.ComponentPartials, Map<Direction, PartialModel>> attachments = new EnumMap<>(FluidTransportBehaviour.AttachmentTypes.ComponentPartials.class);

            for (FluidTransportBehaviour.AttachmentTypes.ComponentPartials type : FluidTransportBehaviour.AttachmentTypes.ComponentPartials.values()) {
                Map<Direction, PartialModel> map = new HashMap<>();
                for (Direction d : Iterate.directions) {
                    String asId = CVALang.asId(type.name());
                    map.put(d, block(material.name + "_pipe/" + asId + "/" + CVALang.asId(d.getSerializedName())));
                }
                attachments.put(type, map);
            }

            PIPE_ATTACHMENTS.put(material, attachments);

            PIPE_CASINGS.put(material, block(material.name + "_pipe/casing"));

        }
        ////////////////
        putFoldingDoor("steel_door");

    }


    private static void putFoldingDoor(String path) {
        FOLDING_DOORS.put(CreateVehiclesAdditional.asResource(path),
                Couple.create(block(path + "/fold_left"), block(path + "/fold_right")));
    }

    private static PartialModel block(String path) {
        return PartialModel.of(CreateVehiclesAdditional.asResource("block/" + path));
    }

    public static void init() {
    }

}
