package de.srr.createvehiclesadditional.Items;

import de.srr.createvehiclesadditional.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier CARBON = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_CARBON_TOOL,
            3184, 4f, 3f, 14,()-> Ingredient.of(ModItems.CARBON));

}