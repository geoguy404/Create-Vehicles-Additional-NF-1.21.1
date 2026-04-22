package de.srr.createvehiclesadditional;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class CVAToolTiers {
    public static final Tier CARBON = new SimpleTier(CVATags.Blocks.INCORRECT_FOR_CARBON_TOOL,
            3184, 4f, 3f, 14,()-> Ingredient.of(CVAItems.CARBON));

}