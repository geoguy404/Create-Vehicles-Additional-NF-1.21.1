package de.srr.createvehiclesadditional.content.fluids.steelLadle;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.foundation.blockEntity.behaviour.ValueBoxTransform;
import dev.engine_room.flywheel.lib.transform.TransformStack;
import net.createmod.catnip.math.AngleHelper;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SteelLadleFrequencySlot extends ValueBoxTransform.Dual {

    private static final double SLOT_Y = 9;
    private static final double SLOT_SPACING = 5;
    private static final int QUARTER_TURNS = 1; // 0 = vorn, 1 = rechts, 2 = hinten, 3 = links
    private static final double SURFACE = 14;


    public SteelLadleFrequencySlot(boolean first) {
        super(first);
    }

    private Direction getSide(BlockState state) {
        Direction side = state.hasProperty(SteelLadleBlock.FACING)
                ? state.getValue(SteelLadleBlock.FACING) : Direction.NORTH;
        for (int i = 0; i < QUARTER_TURNS; i++)
            side = side.getClockWise();
        return side;
    }

    @Override
    public Vec3 getLocalOffset(LevelAccessor level, BlockPos pos, BlockState state) {
        double y = SLOT_Y + (isFirst() ? SLOT_SPACING / 2 : -SLOT_SPACING / 2);// mittig auf der Südfläche
        Vec3 south = VecHelper.voxelSpace(8, y, SURFACE + 0.01);
        return VecHelper.rotateCentered(south, AngleHelper.horizontalAngle(getSide(state)), Direction.Axis.Y);
    }

    @Override
    public void rotate(LevelAccessor level, BlockPos pos, BlockState state, PoseStack ms) {
        TransformStack.of(ms).rotateYDegrees(AngleHelper.horizontalAngle(getSide(state)) + 180);
    }

    @Override
    public float getScale() {
        return 0.4975f;
    }
}

