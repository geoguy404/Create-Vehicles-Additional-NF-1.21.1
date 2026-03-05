package de.srr.createvehiclesadditional.datagen;

import de.srr.createvehiclesadditional.Blocks.ModBlocks;
import de.srr.createvehiclesadditional.CreateVehiclesAdditional;
import de.srr.createvehiclesadditional.Items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {




        //List<ItemLike>

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARBON_HOE)
                .pattern("AA ")
                .pattern(" F ")
                .pattern(" F ")
                .define('A', ModItems.CARBON_ALLOY)
                .define('F', ModItems.CARBON_FIBER)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARBON_SHOVEL)
                .pattern(" A ")
                .pattern(" F ")
                .pattern(" F ")
                .define('A', ModItems.CARBON_ALLOY)
                .define('F', ModItems.CARBON_FIBER)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARBON_AXE)
                .pattern("AA")
                .pattern("AF")
                .pattern(" F")
                .define('A', ModItems.CARBON_ALLOY)
                .define('F', ModItems.CARBON_FIBER)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARBON_PICKAXE)
                .pattern("AAA")
                .pattern(" F ")
                .pattern(" F ")
                .define('A', ModItems.CARBON_ALLOY)
                .define('F', ModItems.CARBON_FIBER)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CARBON_SWORD)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" F ")
                .define('A', ModItems.CARBON_ALLOY)
                .define('F', ModItems.CARBON_FIBER)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_CARBON.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.CARBON)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput,"createvehiclesadditional:block_of_carbon_from_carbon");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.CARBON,9)
                .requires(ModBlocks.BLOCK_OF_CARBON)
                .unlockedBy("has_block_of_carbon", has(ModBlocks.BLOCK_OF_CARBON))
                .save(recipeOutput,"createvehiclesadditional:carbon_from_block_of_carbon");

        //FORGED CARBON BLOCKS//

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GOLDEN_FORGED_CARBON_BLOCK)
                .pattern("GGG")
                .pattern("GFG")
                .pattern("GGG")
                .define('F', ModBlocks.FORGED_CARBON_BLOCK)
                .define('G', Items.GOLD_NUGGET)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);


        //CARBON FIBER BLOCKS//

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GOLDEN_CARBON_FIBER_BLOCK)
                .pattern("GGG")
                .pattern("GCG")
                .pattern("GGG")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('G', Items.GOLD_NUGGET)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_CARBON_FIBER_BLOCK)
                .pattern("BBB")
                .pattern("BCB")
                .pattern("BBB")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('B', Items.BLACK_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAY_CARBON_FIBER_BLOCK)
                .pattern("GGG")
                .pattern("GCG")
                .pattern("GGG")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('G', Items.GRAY_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_CARBON_FIBER_BLOCK)
                .pattern("LLL")
                .pattern("LCL")
                .pattern("LLL")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('L', Items.LIGHT_GRAY_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_CARBON_FIBER_BLOCK)
                .pattern("WWW")
                .pattern("WCW")
                .pattern("WWW")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('W', Items.WHITE_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_CARBON_FIBER_BLOCK)
                .pattern("BBB")
                .pattern("BCB")
                .pattern("BBB")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('B', Items.BLUE_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_CARBON_FIBER_BLOCK)
                .pattern("LLL")
                .pattern("LCL")
                .pattern("LLL")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('L', Items.LIGHT_BLUE_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYAN_CARBON_FIBER_BLOCK)
                .pattern("ZZZ")
                .pattern("ZCZ")
                .pattern("ZZZ")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('Z', Items.CYAN_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_CARBON_FIBER_BLOCK)
                .pattern("GGG")
                .pattern("GCG")
                .pattern("GGG")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('G', Items.GREEN_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_CARBON_FIBER_BLOCK)
                .pattern("LLL")
                .pattern("LCL")
                .pattern("LLL")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('L', Items.LIME_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_CARBON_FIBER_BLOCK)
                .pattern("YYY")
                .pattern("YCY")
                .pattern("YYY")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('Y', Items.YELLOW_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGE_CARBON_FIBER_BLOCK)
                .pattern("OOO")
                .pattern("OCO")
                .pattern("OOO")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('O', Items.ORANGE_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_CARBON_FIBER_BLOCK)
                .pattern("RRR")
                .pattern("RCR")
                .pattern("RRR")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('R',Items.RED_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGENTA_CARBON_FIBER_BLOCK)
                .pattern("MMM")
                .pattern("MCM")
                .pattern("MMM")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('M', Items.MAGENTA_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_CARBON_FIBER_BLOCK)
                .pattern("PPP")
                .pattern("PCP")
                .pattern("PPP")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('P', Items.PINK_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_CARBON_FIBER_BLOCK)
                .pattern("PPP")
                .pattern("PCP")
                .pattern("PPP")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('P', Items.PURPLE_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BROWN_CARBON_FIBER_BLOCK)
                .pattern("BBB")
                .pattern("BCB")
                .pattern("BBB")
                .define('C', ModBlocks.CARBON_FIBER_BLOCK)
                .define('B', Items.BROWN_DYE)
                .unlockedBy("has_carbon", has(ModItems.CARBON))
                .save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected void createMixing(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, String group){

    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, CreateVehiclesAdditional.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }


}
