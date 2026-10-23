package de.srr.createvehiclesadditional.content.steelLadle;

import com.simibubi.create.api.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.content.redstone.link.LinkBehaviour;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.ValueBoxTransform;
import com.simibubi.create.foundation.blockEntity.behaviour.fluid.SmartFluidTankBehaviour;
import de.srr.createvehiclesadditional.CVABlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;



public class SteelLadleBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation {

    //Fluid
    protected SmartFluidTankBehaviour tank;
    public static final int TANK_CAPACITY = 4000;
    private static final int TICKS_UNTIL_SOURCE_BLOCK = 25; // 5sec
    private int drainTicks = 0; // wie lange ununterbrochen offen+draining

    //Redstone
    private LinkBehaviour link;
    private int transmittedSignal = 0;
    private int pulseTicksRemaining = 0;
    private static final int PULSE_DURATION = 10;

    //Lever
    public float leverAngle = 0;
    public float prevLeverAngle = 0;
    private static final float LEVER_OPEN_ANGLE = 45f; // Platzhalter
    private static final float LEVER_SPEED = 15f;      // Grad pro Tick


    public SteelLadleBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        tank = SmartFluidTankBehaviour.single(this, TANK_CAPACITY).forbidExtraction();
        behaviours.add(tank);

        Pair<ValueBoxTransform, ValueBoxTransform> slots =
                ValueBoxTransform.Dual.makeSlots(SteelLadleFrequencySlot::new);
        link = LinkBehaviour.transmitter(this, slots, this::getSignal);
        behaviours.add(link);
    }

    public int getSignal() {
        return transmittedSignal;
    }

    public void triggerArrivalPulse() {
        pulseTicksRemaining = PULSE_DURATION;
        transmittedSignal = 15;
        if (link != null)
            link.notifySignalChange();
        setChanged();
    }

    @Override
    protected void read(CompoundTag tag, HolderLookup.Provider registries, boolean clientPacket) {
        super.read(tag, registries, clientPacket);
        if (tag.getBoolean("PendingArrivalPulse")) {
            pulseTicksRemaining = PULSE_DURATION;
            transmittedSignal = 15;
        }
    }

    @Override
    public void tick() {
        super.tick();

        prevLeverAngle = leverAngle;
        float target = getBlockState().getValue(SteelLadleBlock.OPEN) ? LEVER_OPEN_ANGLE : 0;
        leverAngle = Mth.approach(leverAngle, target, LEVER_SPEED);

        if (level.isClientSide) return;

        if (pulseTicksRemaining > 0 && --pulseTicksRemaining == 0) {
            transmittedSignal = 0;
            if (link != null)
                link.notifySignalChange();
            setChanged();
        }

        if (!getBlockState().getValue(SteelLadleBlock.OPEN)) {
            drainTicks = 0;
            return;
        }

        FluidStack held = tank.getPrimaryHandler().getFluidInTank(0);
        if (held.isEmpty()) {
            drainTicks = 0;
            return;
        }

        BlockPos targetPos = getBlockPos().below();

        // 1. Priorität: Mold darunter befüllen
        var moldHandler = level.getCapability(Capabilities.FluidHandler.BLOCK, targetPos, Direction.UP);
        if (moldHandler != null) {
            drainIntoHandler(moldHandler);
            drainTicks = 0;
            return;
        }

        // 2. Priorität: nach einiger Zeit Fluid-Source unterhalb platzieren
        BlockState targetState = level.getBlockState(targetPos);
        if (targetState.isAir() || targetState.canBeReplaced()) {
            drainTicks++;
            if (drainTicks >= TICKS_UNTIL_SOURCE_BLOCK) {
                placeSourceBlock(targetPos, held.getFluid());
                drainTicks = 0;
            }
        } else {
            drainTicks = 0;
        }
    }

    private void drainIntoHandler(IFluidHandler target) {
        var source = tank.getPrimaryHandler();
        FluidStack drained = source.drain(1000, IFluidHandler.FluidAction.SIMULATE);
        if (drained.isEmpty()) return;
        int filled = target.fill(drained, IFluidHandler.FluidAction.SIMULATE);
        if (filled > 0) {
            FluidStack actual = source.drain(filled, IFluidHandler.FluidAction.EXECUTE);
            target.fill(actual, IFluidHandler.FluidAction.EXECUTE);
        }
    }

    private void placeSourceBlock(BlockPos pos, Fluid fluid) {
        var source = tank.getPrimaryHandler();
        FluidStack drained = source.drain(1000, IFluidHandler.FluidAction.EXECUTE);
        if (!drained.isEmpty() && fluid.isSource(fluid.defaultFluidState())) {
            level.setBlockAndUpdate(pos, fluid.defaultFluidState().createLegacyBlock());
        }
    }

    public SmartFluidTankBehaviour getTankBehaviour() {
        return tank;
    }

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.FluidHandler.BLOCK,
                CVABlockEntities.STEEL_LADLE.get(),
                (be, side) -> be.tank.getCapability());
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {

        return containedFluidTooltip(tooltip, isPlayerSneaking,
                level.getCapability(Capabilities.FluidHandler.BLOCK, getBlockPos(), null));

    }
}
