package de.srr.createvehiclesadditional;


import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.fluids.pipes.FluidPipeBlockEntity;
import com.simibubi.create.content.fluids.pipes.SmartFluidPipeBlockEntity;
import com.simibubi.create.content.fluids.pipes.StraightPipeBlockEntity;
import com.simibubi.create.content.fluids.pipes.TransparentStraightPipeRenderer;
import com.simibubi.create.content.fluids.pipes.valve.FluidValveBlockEntity;
import com.simibubi.create.content.fluids.pipes.valve.FluidValveRenderer;
import com.simibubi.create.content.fluids.pipes.valve.FluidValveVisual;
import com.simibubi.create.content.fluids.pump.PumpBlockEntity;
import com.simibubi.create.content.fluids.pump.PumpRenderer;
import com.simibubi.create.content.kinetics.base.SingleAxisRotatingVisual;
import com.simibubi.create.foundation.blockEntity.renderer.SmartBlockEntityRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import de.srr.createvehiclesadditional.content.fluids.pipes.CVAPipeBlockEntity;
import de.srr.createvehiclesadditional.content.fluids.pipes.CVAPipes;
import de.srr.createvehiclesadditional.content.kinectics.elementSeparator.ElementSeparatorBlockEntity;

import static de.srr.createvehiclesadditional.CreateVehiclesAdditional.REGISTRATE;

public class CVABlockEntities {

//    public static final BlockEntityEntry<GasPipeBlockEntity> GAS_PIPE = REGISTRATE
//            .blockEntity("gas_pipe", GasPipeBlockEntity::new)
//            .validBlocks(CVABlocks.GAS_PIPE)
//            .register();

    public static final BlockEntityEntry<ElementSeparatorBlockEntity> ELEMENT_SEPARATOR = REGISTRATE
            .blockEntity("element_separator", ElementSeparatorBlockEntity::new)
            .validBlocks(CVABlocks.ELEMENT_SEPARATOR)
            .register();

    public static final BlockEntityEntry<CVAPipeBlockEntity> CVA_PIPE = REGISTRATE
            .blockEntity("cva_pipe", CVAPipeBlockEntity::new)
            .validBlocks(
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.CARBON).getPipe(),
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.STEEL).getPipe()
            )
            .register();

    public static final BlockEntityEntry<StraightPipeBlockEntity> GLASS_CVA_PIPE = REGISTRATE
            .blockEntity("glass_cva_pipe", StraightPipeBlockEntity::new)
            .validBlocks(
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.CARBON).getGlass(),
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.STEEL).getGlass()
            )
            .renderer(() -> TransparentStraightPipeRenderer::new)
            .register();


    public static final BlockEntityEntry<FluidPipeBlockEntity> ENCASED_CVA_PIPE = REGISTRATE
            .blockEntity("encased_cva_pipe", FluidPipeBlockEntity::new)
            .validBlocks(
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.CARBON).getEncased(),
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.STEEL).getEncased()
            )
            .register();


    public static final BlockEntityEntry<PumpBlockEntity> CVA_MECHANICAL_PUMP = REGISTRATE
            .blockEntity("mechanical_pump", PumpBlockEntity::new)
            .visual(() -> SingleAxisRotatingVisual.ofZ(AllPartialModels.MECHANICAL_PUMP_COG))
            .validBlocks(
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.CARBON).getPump(),
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.STEEL).getPump()
            )
            .renderer(() -> PumpRenderer::new)
            .register();

    public static final BlockEntityEntry<SmartFluidPipeBlockEntity> CVA_SMART_FLUID_PIPE = REGISTRATE
            .blockEntity("smart_fluid_pipe", SmartFluidPipeBlockEntity::new)
            .validBlocks(
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.CARBON).getSmart(),
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.STEEL).getSmart()
            )
            .renderer(() -> SmartBlockEntityRenderer::new)
            .register();

    public static final BlockEntityEntry<FluidValveBlockEntity> CVA_FLUID_VALVE = REGISTRATE
            .blockEntity("fluid_valve", FluidValveBlockEntity::new)
            .visual(() -> FluidValveVisual::new)
            .validBlocks(
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.CARBON).getValve(),
                    CVAPipes.PIPES.get(CVAPipes.PipeMaterial.STEEL).getValve()
            )
            .renderer(() -> FluidValveRenderer::new)
            .register();

    public static void register() {}
}