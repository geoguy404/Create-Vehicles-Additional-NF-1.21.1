package de.srr.createvehiclesadditional.BlockEntities;

import com.simibubi.create.content.fluids.FluidTransportBehaviour;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import java.util.List;

public class GasPipeBlockEntity extends SmartBlockEntity {

    protected FluidTransportBehaviour fluidBehaviour;

    public GasPipeBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        fluidBehaviour = new FluidTransportBehaviour(this) {
            @Override
            public boolean canHaveFlowToward(BlockState blockState, Direction direction) {
                return true;
            }
        };
        behaviours.add(fluidBehaviour);
    }
}
