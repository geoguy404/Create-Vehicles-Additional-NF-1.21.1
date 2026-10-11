package de.srr.createvehiclesadditional;

import com.simibubi.create.AllFluids;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.createmod.catnip.theme.Color;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import org.joml.Vector3f;

import java.util.function.Supplier;

import static de.srr.createvehiclesadditional.CreateVehiclesAdditional.REGISTRATE;
import static net.createmod.catnip.config.ui.ConfigScreen.toHumanReadable;

public class CVAFluids {


//    public static final FluidEntry<BaseFlowingFluid.Flowing> INCA_COLA =
//            REGISTRATE.standardFluid("inca_kola",
//                            SolidRenderedPlaceableFluidType.create(0x3388FF, () -> 1f / 8f)) // Tintfarbe + Fog-Transparenz
//                    .lang("Inca Kola")
//                    .properties(b -> b.viscosity(1000)
//                            .density(1000))
//                    .fluidProperties(p -> p.levelDecreasePerBlock(1)
//                            .tickRate(5)
//                            .slopeFindDistance(4)
//                            .explosionResistance(100f))
//                    .source(BaseFlowingFluid.Source::new)
//                    .block()
//                    .properties(p -> p.mapColor(MapColor.COLOR_YELLOW))
//                    .build()
//                    .bucket()
//                    .build()
//                    .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing>
            INCA_KOLA = fluid("inca_kola", 0x010101);



    public static void register() {}



    @SafeVarargs
    private static FluidEntry<BaseFlowingFluid.Flowing> fluid(String name, int fogColor, TagKey<Fluid>... tags) {
        return REGISTRATE.fluid(name, getLocation(name), getLocationFlow(name),
                        SolidRenderedPlaceableFluidType.create(fogColor, () -> 1f / 32f))
                .lang(toHumanReadable(name))
                .properties(b -> b.viscosity(1000)
                        .density(1000))
                .fluidProperties(p -> p.levelDecreasePerBlock(1)
                        .tickRate(10)
                        .slopeFindDistance(5)
                        .explosionResistance(100f))
                .tag(tags)
                .source(BaseFlowingFluid.Source::new)
                .bucket()
                .tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "buckets/" + name)))
                .build()
                .register();
    }

    public static ResourceLocation getLocationFlow(String name) {
        return CreateVehiclesAdditional.asResource("fluid/" + name + "_flow");
    }

    public static ResourceLocation getLocation(String name) {
        return CreateVehiclesAdditional.asResource("fluid/" + name + "_still");
    }

    public static class SolidRenderedPlaceableFluidType extends AllFluids.TintedFluidType {

        private Vector3f fogColor;
        private Supplier<Float> fogDistance;


        public static FluidBuilder.FluidTypeFactory create(int fogColor, Supplier<Float> fogDistance) {
            return (p, s, f) -> {
                SolidRenderedPlaceableFluidType fluidType = new SolidRenderedPlaceableFluidType(p, s, f);
                fluidType.fogColor = new Color(fogColor, false).asVectorF();
                fluidType.fogDistance = fogDistance;
                return fluidType;
            };
        }

        public SolidRenderedPlaceableFluidType(Properties properties, ResourceLocation stillTexture,
                                               ResourceLocation flowingTexture) {
            super(properties, stillTexture, flowingTexture);
        }

        @Override
        protected int getTintColor(net.neoforged.neoforge.fluids.FluidStack stack) {
            return NO_TINT;
        }


        @Override
        public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
            return 0x00ffffff;
        }

        @Override
        protected Vector3f getCustomFogColor() {
            return fogColor;
        }

        @Override
        protected float getFogDistanceModifier() {
            return fogDistance.get();
        }

    }

    public static void init() {
    }
}
