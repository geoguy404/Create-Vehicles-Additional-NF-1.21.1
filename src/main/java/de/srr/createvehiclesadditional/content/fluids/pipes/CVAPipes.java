package de.srr.createvehiclesadditional.content.fluids.pipes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.data.CreateRegistrate;
import de.srr.createvehiclesadditional.CVACreativeModeTabs;
import de.srr.createvehiclesadditional.CVASpriteShifts;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static de.srr.createvehiclesadditional.CreateVehiclesAdditional.REGISTRATE;


public class CVAPipes {

    public static final CreateRegistrate registrate = (CreateRegistrate) REGISTRATE.setCreativeTab(CVACreativeModeTabs.PIPE_TAB);

    public static final Map<PipeMaterial, CVAPipeEntry> PIPES = new HashMap<>();

    static {
        PIPES.put(PipeMaterial.CARBON, createEntry(PipeMaterial.CARBON, CVASpriteShifts.CARBON_FLUID_CASING));
        PIPES.put(PipeMaterial.STEEL, createEntry(PipeMaterial.STEEL, CVASpriteShifts.STEEL_FLUID_CASING));
    }

    private static CVAPipeEntry createEntry(PipeMaterial material, CTSpriteShiftEntry spriteShiftEntry) {
        return new CVAPipeEntry(material, registrate).encasedSpriteShift(spriteShiftEntry);
    }

    public static void init() {
    }

    public static void addCreativeTabItems(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
        for (CVAPipeEntry entry : PIPES.values()) {
            output.accept(entry.getPipe());
            output.accept(entry.getPump());
            output.accept(entry.getValve());
            output.accept(entry.getSmart());
        }
    }

    public enum PipeMaterial {
        CARBON("carbon"),
        STEEL("steel");

        public final String name;

        PipeMaterial(String name) {
            this.name = name;
        }
    }


}