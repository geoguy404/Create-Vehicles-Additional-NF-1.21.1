package de.srr.createvehiclesadditional.content.fluids.pipes;
import com.simibubi.create.content.fluids.pipes.IAxisPipe;
import com.simibubi.create.content.fluids.pipes.valve.FluidValveBlock;
import com.simibubi.create.content.fluids.pipes.valve.FluidValveBlockEntity;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.block.ProperWaterloggedBlock;
import de.srr.createvehiclesadditional.CVABlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CVAFluidValveBlock extends FluidValveBlock implements IAxisPipe, IBE<FluidValveBlockEntity>, ProperWaterloggedBlock {

    public CVAFluidValveBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(ENABLED, false)
                .setValue(WATERLOGGED, false));
    }

    @Override
    public Class<FluidValveBlockEntity> getBlockEntityClass() {
        return FluidValveBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends FluidValveBlockEntity> getBlockEntityType() {
        return CVABlockEntities.CVA_FLUID_VALVE.get();
    }
}