package de.srr.createvehiclesadditional.content.fluids.pipes;
import com.simibubi.create.content.fluids.pump.PumpBlock;
import com.simibubi.create.content.fluids.pump.PumpBlockEntity;
import de.srr.createvehiclesadditional.CVABlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CVAPumpBlock extends PumpBlock {
    public CVAPumpBlock(Properties p_i48415_1_) {
        super(p_i48415_1_);
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource r) {
        super.tick(state, world, pos, r);
        this.getBlockEntity(world, pos).updatePressureChange();

    }

    @Override
    public Class<PumpBlockEntity> getBlockEntityClass() {
        return PumpBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends PumpBlockEntity> getBlockEntityType() {
        return CVABlockEntities.CVA_MECHANICAL_PUMP.get();
    }
}
