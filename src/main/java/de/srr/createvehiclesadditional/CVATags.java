package de.srr.createvehiclesadditional;

import com.simibubi.create.foundation.blockEntity.IMultiBlockEntityContainer;
import static de.srr.createvehiclesadditional.CVATags.NameSpace.COMMON;
import static de.srr.createvehiclesadditional.CVATags.NameSpace.MOD;
import net.createmod.catnip.lang.Lang;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

import org.jetbrains.annotations.ApiStatus.ScheduledForRemoval;
import org.jetbrains.annotations.Nullable;

public class CVATags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CARBON_TOOL = createTag("needs_carbon_tool");
        public static final TagKey<Block> INCORRECT_FOR_CARBON_TOOL = createTag("incorrect_for_carbon_tool");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CreateVehiclesAdditional.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> VEHICLE_PARTS = createTag("vehicle_parts");



        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CreateVehiclesAdditional.MOD_ID, name));
        }
    }

    public enum NameSpace {
        MOD(CreateVehiclesAdditional.MOD_ID),
        COMMON("c");

        public final String id;

        NameSpace(String id) {
            this.id = id;
        }

        public ResourceLocation id(String path) {
            return ResourceLocation.fromNamespaceAndPath(this.id, path);
        }

        public ResourceLocation id(Enum<?> entry, @Nullable String pathOverride) {
            return this.id(pathOverride != null ? pathOverride : Lang.asId(entry.name()));
        }
    }

    public enum CVAFluidTags {
        BOTTOMLESS_ALLOW(MOD, "bottomless/allow"),
        BOTTOMLESS_DENY(MOD, "bottomless/deny"),
        FAN_PROCESSING_CATALYSTS_BLASTING(MOD, "fan_processing_catalysts/blasting"),
        FAN_PROCESSING_CATALYSTS_HAUNTING(MOD, "fan_processing_catalysts/haunting"),
        FAN_PROCESSING_CATALYSTS_SMOKING(MOD, "fan_processing_catalysts/smoking"),
        FAN_PROCESSING_CATALYSTS_SPLASHING(MOD, "fan_processing_catalysts/splashing"),

        TEA(COMMON),
        CHOCOLATE(COMMON),

        CREOSOTE(COMMON);

        public final TagKey<Fluid> tag;

        CVAFluidTags() {
            this(MOD);
        }

        CVAFluidTags(CVATags.NameSpace namespace) {
            this(namespace, null);
        }

        CVAFluidTags(CVATags.NameSpace namespace, @Nullable String pathOverride) {
            this.tag = TagKey.create(Registries.FLUID, namespace.id(this, pathOverride));
        }

        @SuppressWarnings("deprecation")
        public boolean matches(Fluid fluid) {
            return fluid.is(tag);
        }

        public boolean matches(FluidState state) {
            return state.is(tag);
        }
    }
}
