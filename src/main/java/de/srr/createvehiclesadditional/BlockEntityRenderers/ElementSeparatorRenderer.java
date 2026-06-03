package de.srr.createvehiclesadditional.BlockEntityRenderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.foundation.blockEntity.renderer.SafeBlockEntityRenderer;
import de.srr.createvehiclesadditional.BlockEntities.ElementSeparatorBlockEntity;
import de.srr.createvehiclesadditional.registry.ModPartialModels;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.platform.NeoForgeCatnipServices;
import net.createmod.catnip.render.CachedBuffers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.fluids.FluidStack;


public class ElementSeparatorRenderer extends SafeBlockEntityRenderer<ElementSeparatorBlockEntity> {

    public ElementSeparatorRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected void renderSafe(ElementSeparatorBlockEntity be, float partialTicks, PoseStack ms,
                              MultiBufferSource buffer, int light, int overlay) {

        // Block-Ausrichtung berücksichtigen
        Direction facing = be.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);

        ms.pushPose();
        ms.translate(0.5, 0.5, 0.5);

        // Je nach facing rotieren
        switch (facing) {
            case NORTH -> {} // Standardausrichtung
            case SOUTH -> ms.mulPose(Axis.YP.rotationDegrees(180));
            case EAST  -> ms.mulPose(Axis.YP.rotationDegrees(-90));
            case WEST  -> ms.mulPose(Axis.YP.rotationDegrees(90));
        }

        ms.translate(-0.5, -0.5, -0.5);

        renderShaft(be, ms, buffer, light, partialTicks);
        renderLid(be, ms, buffer, light, partialTicks);
        renderFluid(be, ms, buffer, light);

        ms.popPose();
    }

        // --- Achse ---
        protected void renderShaft(ElementSeparatorBlockEntity be, PoseStack ms,
                                   MultiBufferSource buffer, int light, float partialTicks) {

            Direction facing = be.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
            Direction.Axis rotationAxis = facing.getAxis();

            // Rotationswinkel aus dem Kinetic-System holen
            float time = AnimationTickHolder.getRenderTime(be.getLevel());
            float speed = be.getSpeed();
            float angle = KineticBlockEntityRenderer.getAngleForBe(
                    be, be.getBlockPos(), rotationAxis);


            ms.pushPose();
            ms.translate(0.5, 0.5, 0.969);

            switch (facing) {
                case NORTH, WEST -> ms.mulPose(Axis.ZP.rotation(angle));
                case SOUTH, EAST -> ms.mulPose(Axis.ZN.rotation(angle));
            }

            ms.translate(-0.5, -0.5, -0.969);

            CachedBuffers.partial(ModPartialModels.SEPARATOR_SHAFT, be.getBlockState())
                    .light(light)
                    .renderInto(ms, buffer.getBuffer(RenderType.solid()));

            ms.popPose();
        }

        // --- Klappe ---
        protected void renderLid(ElementSeparatorBlockEntity be, PoseStack ms,
                                 MultiBufferSource buffer, int light, float partialTicks) {

            float angle = Mth.lerp(partialTicks, be.prevLidAngle, be.lidAngle);

            //HATCH 1
            ms.pushPose();
            ms.translate(0.5D, 0.9375D, 0.75D); // Pivot: oben vorne
            ms.mulPose(Axis.XP.rotationDegrees(-angle)); // nach vorne weg
            ms.translate(-0.5D, -0.9375D, -0.75D);
            CachedBuffers.partial(ModPartialModels.SEPARATOR_LID1, be.getBlockState())
                    .light(light)
                    .renderInto(ms, buffer.getBuffer(RenderType.cutout()));
            ms.popPose();

            //HATCH 2
            ms.pushPose();
            ms.translate(0.5D, 0.9375D, 0.25D); // Pivot: oben hinten
            ms.mulPose(Axis.XP.rotationDegrees(angle)); // nach hinten weg
            ms.translate(-0.5D, -0.9375D, -0.25D);
            CachedBuffers.partial(ModPartialModels.SEPARATOR_LID2, be.getBlockState())
                    .light(light)
                    .renderInto(ms, buffer.getBuffer(RenderType.cutout()));
            ms.popPose();

        }

        // --- Fluid ---
        private void renderFluid(ElementSeparatorBlockEntity be, PoseStack ms,
                MultiBufferSource buffer, int light) {

            FluidStack fluidStack = be.getTank().getFluid();

            if (fluidStack.isEmpty()) return;

            float fillLevel = (float) fluidStack.getAmount() / be.getTank().getCapacity();
            float minX = 2f /16f;
            float maxX = 14f/16f;
            float minY = 2f / 16f;
            float maxY = minY + (12f / 16f) * fillLevel;
            float minZ = 4f / 16f;
            float maxZ = 12f / 16f;
            NeoForgeCatnipServices.FLUID_RENDERER.renderFluidBox(fluidStack, minX,  minY, minZ, maxX, maxY, maxZ,
                    buffer, ms, light, false, false);
        }
    }
