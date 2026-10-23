package de.srr.createvehiclesadditional.content.steelLadle;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.blockEntity.renderer.SmartBlockEntityRenderer;
import de.srr.createvehiclesadditional.CVAPartialModels;
import net.createmod.catnip.platform.NeoForgeCatnipServices;
import net.createmod.catnip.render.CachedBuffers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

public class SteelLadleRenderer extends SmartBlockEntityRenderer<SteelLadleBlockEntity> {


    private static final double PIVOT_X = 4, PIVOT_Y = 2, PIVOT_Z = 8;

    public SteelLadleRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected void renderSafe(SteelLadleBlockEntity be, float partialTicks, PoseStack ms,
                              MultiBufferSource buffer, int light, int overlay) {
        super.renderSafe(be, partialTicks, ms, buffer, light, overlay);

        Direction facing = be.getBlockState().getValue(SteelLadleBlock.FACING);

        ms.pushPose();
        ms.translate(0.5, 0.5, 0.5);

        switch (facing) {
            case WEST  -> {}
            case NORTH -> ms.mulPose(Axis.YP.rotationDegrees(-90));
            case EAST  -> ms.mulPose(Axis.YP.rotationDegrees(180));
            case SOUTH -> ms.mulPose(Axis.YP.rotationDegrees(90));
        }

        ms.translate(-0.5, -0.5, -0.5);

        renderLever(be, ms, buffer, light, partialTicks);
        renderFluid(be, ms, buffer, light);

        ms.popPose();
    }

    protected void renderLever(SteelLadleBlockEntity be, PoseStack ms,
                               MultiBufferSource buffer, int light, float partialTicks) {

        float angle = Mth.lerp(partialTicks, be.prevLeverAngle, be.leverAngle);

        ms.pushPose();
        ms.translate(PIVOT_X / 16, PIVOT_Y / 16, PIVOT_Z / 16);
        ms.mulPose(Axis.XP.rotationDegrees(angle));
        ms.translate(-PIVOT_X / 16, -PIVOT_Y / 16, -PIVOT_Z / 16);

        CachedBuffers.partial(CVAPartialModels.STEEL_LADLE_LEVER, be.getBlockState())
                .light(light)
                .renderInto(ms, buffer.getBuffer(RenderType.cutout()));
        ms.popPose();
    }

    private void renderFluid(SteelLadleBlockEntity be, PoseStack ms,
                             MultiBufferSource buffer, int light) {

        IFluidHandler handler = be.getTankBehaviour().getPrimaryHandler();
        if (handler == null) return;

        FluidStack fluidStack = handler.getFluidInTank(0);
        if (fluidStack.isEmpty()) return;

        float fillLevel = (float) fluidStack.getAmount() / SteelLadleBlockEntity.TANK_CAPACITY;

        //Becken
        float minX = 4f / 16f, maxX = 12f / 16f;
        float minY = 7f / 16f, maxY = minY + (10f / 16f) * fillLevel;
        float minZ = 4f / 16f, maxZ = 12f / 16f;

        NeoForgeCatnipServices.FLUID_RENDERER.renderFluidBox(fluidStack, minX, minY, minZ, maxX, maxY, maxZ,
                buffer, ms, light, false, false);
    }
}
