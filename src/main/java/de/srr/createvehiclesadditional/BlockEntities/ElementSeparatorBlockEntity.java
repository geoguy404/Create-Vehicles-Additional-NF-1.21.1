package de.srr.createvehiclesadditional.BlockEntities;

import com.simibubi.create.Create;
import com.simibubi.create.api.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.fluid.SmartFluidTank;
import com.simibubi.create.foundation.utility.CreateLang;
import net.createmod.catnip.lang.Lang;
import net.createmod.catnip.lang.LangBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.capabilities.Capabilities;


import java.util.List;

public class ElementSeparatorBlockEntity extends KineticBlockEntity implements IHaveGoggleInformation {

    // FluidTank (4 Buckets = 4000mB wie Basin)
    protected SmartFluidTank tank;
    public static final int TANK_CAPACITY = 4000;

    public float lidAngle = 0f;
    public float prevLidAngle = 0f;


    // Server-seitiger Timer für CLOSING/OPENING
    private int transitionTimer = 0;
    private static final int TRANSITION_TICKS = 20;

    public enum SeparatorState {
        IDLE,    // empty/no energy -> hatch closed
        OPEN,      // empty or NOT full/energy -> hatch open
        CLOSING,   // process starting -> hatch closing
        RUNNING, // process running -> hatch closed
        OPENING,   // process done -> hatch opening
    }

    public SeparatorState separatorState = SeparatorState.IDLE;
    private SeparatorState lastState = null;


    public ElementSeparatorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        setLazyTickRate(10);

        // Tank initialisieren
        tank = createTank();
    }

    protected SmartFluidTank createTank() {
        return new SmartFluidTank(TANK_CAPACITY, this::onFluidStackChanged);
    }

    // Wenn Tank inhalt sich ändert
    protected void onFluidStackChanged(net.neoforged.neoforge.fluids.FluidStack newFluidStack) {
        if (!hasLevel()) return;
        if (level.isClientSide) return;
        // Nur syncen für Fluid-Rendering
        sendData();
    }

    // NBT Speicherung - Create's write/read Methoden
    @Override
    protected void write(CompoundTag tag, HolderLookup.Provider provider, boolean clientPacket) {
        super.write(tag, provider, clientPacket);
        tag.put("Tank", tank.writeToNBT(provider, new CompoundTag()));
        tag.putString("State", separatorState.name());
        tag.putInt("TransitionTimer", transitionTimer);
    }
    @Override
    protected void read(CompoundTag tag, HolderLookup.Provider provider, boolean clientPacket) {
        super.read(tag, provider, clientPacket);
        tank.readFromNBT(provider, tag.getCompound("Tank"));
        if (tag.contains("State"))
            separatorState = SeparatorState.valueOf(tag.getString("State"));
        if (tag.contains("LidAngle"))
            lidAngle = tag.getFloat("LidAngle");
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
            Create.LOGGER.debug("ElementSeparator Speed: {} | Tank: {}/{}",
                    getSpeed(), tank.getFluidAmount(), tank.getCapacity());

        boolean hasFluid = !tank.isEmpty();
        boolean isFull = tank.getFluidAmount() >= tank.getCapacity();
        boolean hasSpeed = getSpeed() != 0;

        SeparatorState newState = separatorState;

        switch (separatorState) {
            case IDLE -> {
                transitionTimer = 0;
                if (hasSpeed) newState = SeparatorState.OPENING;
            }
            case OPENING -> {
                transitionTimer++;
                if (!hasSpeed) {
                    transitionTimer = 0;
                    newState = SeparatorState.CLOSING;
                } else if (transitionTimer >= TRANSITION_TICKS) {
                    transitionTimer = 0;
                    newState = SeparatorState.OPEN;
                }
            }
            case OPEN -> {
                transitionTimer = 0;
                if (!hasSpeed) newState = SeparatorState.CLOSING;
                else if (isFull) newState = SeparatorState.CLOSING;
            }
            case CLOSING -> {
                transitionTimer++;
                if (!hasSpeed && transitionTimer >= TRANSITION_TICKS) {
                    transitionTimer = 0;
                    newState = SeparatorState.IDLE;
                } else if (hasSpeed && isFull && transitionTimer >= TRANSITION_TICKS) {
                    transitionTimer = 0;
                    newState = SeparatorState.RUNNING;
                } else if (hasSpeed && !isFull && transitionTimer >= TRANSITION_TICKS) {
                    transitionTimer = 0;
                    newState = SeparatorState.OPEN;
                }
            }
            case RUNNING -> {
                transitionTimer = 0;
                if (!hasSpeed) newState = SeparatorState.CLOSING;
                if (!hasFluid) newState = SeparatorState.OPENING;
            }
        }

        if (newState != separatorState) {
            separatorState = newState;
            notifyUpdate();
        }
    }


    protected void tickClient() {
        prevLidAngle = lidAngle;

        switch (separatorState) {
            case IDLE -> {
                // Sofort zu, keine Animation nötig wenn ohnehin geschlossen
                lidAngle += (0f - lidAngle) * 0.15f;
            }
            case OPENING -> {
                lidAngle += (85f - lidAngle) * 0.15f;
            }
            case OPEN -> {
                lidAngle += (85f - lidAngle) * 0.15f;
            }
            case CLOSING -> {
                lidAngle += (0f - lidAngle) * 0.15f;
            }
            case RUNNING -> {
                lidAngle += (0f - lidAngle) * 0.15f;
            }
        }

    }


    // Für Bucket Interakiton
    public SmartFluidTank getTank() {
        return tank;
    }


    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        super.addBehaviours(behaviours);
        // Hier könnten später weitere Behaviours hinzugefügt werden
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {

        // --- Kinetic Stress ---
        super.addToGoggleTooltip(tooltip, isPlayerSneaking);

        // --- Fluid Tank ---
        return containedFluidTooltip(tooltip, isPlayerSneaking,
                level.getCapability(Capabilities.FluidHandler.BLOCK, getBlockPos(), null));
    }
}