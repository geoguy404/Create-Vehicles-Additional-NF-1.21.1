package de.srr.createvehiclesadditional.content.fluids.pipes;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.simibubi.create.content.fluids.PipeAttachmentModel;
import com.simibubi.create.content.fluids.pipes.SmartFluidPipeGenerator;
import com.simibubi.create.content.fluids.pipes.valve.FluidValveBlock;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import de.srr.createvehiclesadditional.config.CVAStress;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
@SuppressWarnings("removal")
public class CVAPipeEntry {
    private final CVAPipes.PipeMaterial material;
    private final CreateRegistrate registrate;

    private final BlockEntry<? extends CVAPipeBlock> pipe;
    private final BlockEntry<? extends CVAEncasedPipeBlock> encased;
    private final BlockEntry<? extends CVAGlassPipeBlock> glass;
    private final BlockEntry<? extends CVAPumpBlock> pump;
    private final BlockEntry<? extends CVASmartFluidPipeBlock> smart;
    private final BlockEntry<? extends CVAFluidValveBlock> valve;

    @OnlyIn(Dist.CLIENT)
    private NonNullFunction<BakedModel, ? extends BakedModel> attachmentModel;

    private CTSpriteShiftEntry encasedSpriteShift;

    public CVAPipeEntry(CVAPipes.PipeMaterial material, CreateRegistrate registrate) {
        this.material = material;
        this.registrate = registrate;
        this.pipe = registerPipe();
        this.encased = registerEncasedPipe();
        this.glass = registerGlassPipe();
        this.pump = registerPump();
        this.smart = registerSmartPipe();
        this.valve = registerValve();
    }

    @OnlyIn(Dist.CLIENT)
    public CVAPipeEntry attachmentModel(NonNullFunction<BakedModel, ? extends BakedModel> attachmentModel) {
        this.attachmentModel = attachmentModel;
        return this;
    }

    public CVAPipeEntry encasedSpriteShift(CTSpriteShiftEntry encasedSpriteShift) {
        this.encasedSpriteShift = encasedSpriteShift;
        return this;
    }

    public BlockEntry<? extends CVAPipeBlock> getPipe() {
        return pipe;
    }

    public BlockEntry<? extends CVAEncasedPipeBlock> getEncased() {
        return encased;
    }

    public BlockEntry<? extends CVAGlassPipeBlock> getGlass() {
        return glass;
    }

    public BlockEntry<? extends CVAPumpBlock> getPump() {
        return pump;
    }

    public BlockEntry<? extends CVASmartFluidPipeBlock> getSmart() {
        return smart;
    }

    public BlockEntry<? extends CVAFluidValveBlock> getValve() {
        return valve;
    }

    protected BlockEntry<? extends CVAPipeBlock> registerPipe() {
        return this.registrate.block(this.material.name + "_pipe", p -> new CVAPipeBlock(p, this.material))
                .initialProperties(SharedProperties::copperMetal)
                .transform(pickaxeOnly())
                .blockstate(BlockStateGen.pipe())
                .onRegister(CreateRegistrate.blockModel(()->
                        switch (this.material){
                            case CARBON -> CVAPipeAttachmentModel::withAOCarbon;
                            case STEEL -> CVAPipeAttachmentModel::withAOSteel;
                        }))
                .item()
                .transform(customItemModel())
                .register();
    }

    protected BlockEntry<? extends CVAEncasedPipeBlock> registerEncasedPipe() {
        return this.registrate.block("encased_" + this.material.name + "_pipe", p -> new CVAEncasedPipeBlock(p, AllBlocks.COPPER_CASING::get, this.material))
                .initialProperties(SharedProperties::copperMetal)
                .properties(p -> p.noOcclusion().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
                .transform(axeOrPickaxe())
                .blockstate(BlockStateGen.encasedPipe())
                .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(this.encasedSpriteShift)))
                .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, this.encasedSpriteShift,
                        (s, f) -> !s.getValue(CVAEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
                .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withoutAO))
                .loot((p, b) -> p.dropOther(b, this.pipe.get()))
                .transform(EncasingRegistry.addVariantTo(this.pipe))
                .register();
    }

    protected BlockEntry<? extends CVAGlassPipeBlock> registerGlassPipe() {
        return this.registrate.block("glass_" + this.material.name + "_pipe", p -> new CVAGlassPipeBlock(p, this.material))
                .initialProperties(SharedProperties::copperMetal)
                .addLayer(() -> RenderType::cutoutMipped)
                .transform(pickaxeOnly())
                .blockstate((c, p) -> {
                    p.getVariantBuilder(c.getEntry())
                            .forAllStatesExcept(state -> {
                                Direction.Axis axis = state.getValue(BlockStateProperties.AXIS);
                                return ConfiguredModel.builder()
                                        .modelFile(p.models()
                                                .getExistingFile(p.modLoc("block/" + this.material.name + "_pipe/window")))
                                        .uvLock(false)
                                        .rotationX(axis == Direction.Axis.Y ? 0 : 90)
                                        .rotationY(axis == Direction.Axis.X ? 90 : 0)
                                        .build();
                            }, BlockStateProperties.WATERLOGGED);
                })
                .onRegister(CreateRegistrate.blockModel(()->
                        switch (this.material){
                            case CARBON -> CVAPipeAttachmentModel::withAOCarbon;
                            case STEEL -> CVAPipeAttachmentModel::withAOSteel;
                        }))
                .loot((p, b) -> p.dropOther(b, this.pipe.get()))
                .register();
    }

    protected BlockEntry<? extends CVAPumpBlock> registerPump() {
        return this.registrate.block(this.material.name + "_mechanical_pump", CVAPumpBlock::new)
                .initialProperties(SharedProperties::copperMetal)
                .transform(pickaxeOnly())
                .blockstate(BlockStateGen.directionalBlockProviderIgnoresWaterlogged(true))
                .onRegister(CreateRegistrate.blockModel(()->
                        switch (this.material){
                            case CARBON -> CVAPipeAttachmentModel::withAOCarbon;
                            case STEEL -> CVAPipeAttachmentModel::withAOSteel;
                        }))
                .transform(CVAStress.setImpact(4.0))
                .item()
                .transform(customItemModel())
                .register();
    }

    protected BlockEntry<? extends CVASmartFluidPipeBlock> registerSmartPipe() {
        return this.registrate.block(this.material.name + "_smart_fluid_pipe", CVASmartFluidPipeBlock::new)
                .initialProperties(SharedProperties::copperMetal)
                .transform(pickaxeOnly())
                .blockstate(new SmartFluidPipeGenerator()::generate)
                .onRegister(CreateRegistrate.blockModel(()->
                        switch (this.material){
                            case CARBON -> CVAPipeAttachmentModel::withAOCarbon;
                            case STEEL -> CVAPipeAttachmentModel::withAOSteel;
                        }))
                .item()
                .transform(customItemModel())
                .register();
    }

    protected BlockEntry<? extends CVAFluidValveBlock> registerValve() {
        return this.registrate.block(this.material.name + "_fluid_valve", CVAFluidValveBlock::new)
                .initialProperties(SharedProperties::copperMetal)
                .transform(pickaxeOnly())
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate((c, p) -> BlockStateGen.directionalAxisBlock(c, p,
                        (state, vertical) -> AssetLookup.partialBaseModel(c, p, vertical ? "vertical" : "horizontal",
                                state.getValue(FluidValveBlock.ENABLED) ? "open" : "closed")))
                .onRegister(CreateRegistrate.blockModel(()->
                        switch (this.material){
                            case CARBON -> CVAPipeAttachmentModel::withAOCarbon;
                            case STEEL -> CVAPipeAttachmentModel::withAOSteel;
                        }))
                .item()
                .transform(customItemModel())
                .register();
    }
}