package de.srr.createvehiclesadditional.BlockEntities;

import com.simibubi.create.Create;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ElementSeparatorBlockEntity extends KineticBlockEntity {

    public ElementSeparatorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        setLazyTickRate(10);
    }

    @Override
    public void tick() {
        super.tick();

        if (level == null)
            return;

        if (level.isClientSide)
            tickClient();
        else
            tickServer();
    }

    protected void tickServer() {
        // Debug: Rotation
        if (getSpeed() != 0)
            Create.LOGGER.debug("ElementSeparator Speed: {}", getSpeed());
    }

    protected void tickClient() {
        // later: Animation
    }

}