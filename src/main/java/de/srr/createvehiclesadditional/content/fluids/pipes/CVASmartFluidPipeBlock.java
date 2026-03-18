package de.srr.createvehiclesadditional.content.fluids.pipes;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.content.fluids.pipes.IAxisPipe;
import com.simibubi.create.content.fluids.pipes.SmartFluidPipeBlock;
import com.simibubi.create.content.fluids.pipes.SmartFluidPipeBlockEntity;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.block.ProperWaterloggedBlock;
import de.srr.createvehiclesadditional.CVABlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CVASmartFluidPipeBlock extends SmartFluidPipeBlock
        implements IBE<SmartFluidPipeBlockEntity>, IAxisPipe, IWrenchable, ProperWaterloggedBlock {
    public CVASmartFluidPipeBlock(Properties p_i48339_1_) {
        super(p_i48339_1_);
    }

    @Override
    public Class<SmartFluidPipeBlockEntity> getBlockEntityClass() {
        return SmartFluidPipeBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends SmartFluidPipeBlockEntity> getBlockEntityType() {
        return CVABlockEntities.CVA_SMART_FLUID_PIPE.get();
    }

}