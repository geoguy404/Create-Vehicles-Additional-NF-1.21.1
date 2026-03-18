package de.srr.createvehiclesadditional.datagen;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;

/**
 * Data generation helpers for Steel Pipe blocks.
 *
 * This shows how to generate blockstates and models for the steel pipe.
 * You can use these methods with Registrate's .blockstate() transform.
 */
public class SteelPipeDataGen {

    /**
     * Generate blockstate for the steel pipe with axis rotation.
     * Use this in your block registration like:
     *
     * REGISTRATE.block("steel_pipe", SteelPipeBlock::new)
     *     .blockstate((ctx, prov) -> SteelPipeDataGen.pipeBlockstate(ctx, prov))
     *     ...
     */
    public static <T extends Block> void pipeBlockstate(DataGenContext<Block, T> ctx,
                                                        RegistrateBlockstateProvider prov) {
        String name = ctx.getName();

        // Create models for each axis orientation
        ModelFile modelY = prov.models().getExistingFile(prov.modLoc("block/" + name + "_y"));
        ModelFile modelX = prov.models().getExistingFile(prov.modLoc("block/" + name + "_x"));
        ModelFile modelZ = prov.models().getExistingFile(prov.modLoc("block/" + name + "_z"));

        // Or if you want to generate the models programmatically:
        // ModelFile modelY = createPipeModel(prov, name, Direction.Axis.Y);
        // ModelFile modelX = createPipeModel(prov, name, Direction.Axis.X);
        // ModelFile modelZ = createPipeModel(prov, name, Direction.Axis.Z);

        // Apply models based on axis property
        prov.getVariantBuilder(ctx.get())
                .partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y)
                .modelForState().modelFile(modelY).addModel()
                .partialState().with(BlockStateProperties.AXIS, Direction.Axis.X)
                .modelForState().modelFile(modelX).rotationY(90).addModel()
                .partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(modelZ).rotationX(90).addModel();
    }

    /**
     * Simple blockstate that uses the same model for all axes.
     * Easier to set up initially.
     */
    public static <T extends Block> void simplePipeBlockstate(DataGenContext<Block, T> ctx,
                                                              RegistrateBlockstateProvider prov) {
        String name = ctx.getName();
        ModelFile model = prov.models().getExistingFile(prov.modLoc("block/" + name));

        prov.getVariantBuilder(ctx.get())
                .partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y)
                .modelForState().modelFile(model).addModel()
                .partialState().with(BlockStateProperties.AXIS, Direction.Axis.X)
                .modelForState().modelFile(model).rotationY(90).addModel()
                .partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(model).rotationX(90).addModel();
    }

    /**
     * Create a simple pipe model programmatically.
     * This creates a basic pipe core - you'll need to add connection pieces separately.
     */
    public static ModelFile createPipeModel(RegistrateBlockstateProvider prov,
                                            String name,
                                            Direction.Axis axis) {
        String modelName = name + (axis == Direction.Axis.Y ? "_y" :
                axis == Direction.Axis.X ? "_x" : "_z");

        // Create a simple cube model as the pipe core
        // For more complex models, you'll want to use a JSON model file or blockbench
        return prov.models().withExistingParent(modelName, "block/block")
                .texture("particle", prov.modLoc("block/" + name))
                .texture("texture", prov.modLoc("block/" + name));
    }
}

/**
 * Example JSON model file that you would place in:
 * src/main/resources/assets/yourmod/models/block/steel_pipe_y.json
 *
 * {
 *   "parent": "block/block",
 *   "textures": {
 *     "particle": "yourmod:block/steel_pipe",
 *     "texture": "yourmod:block/steel_pipe",
 *     "end": "yourmod:block/steel_pipe_end"
 *   },
 *   "elements": [
 *     {
 *       "from": [4, 0, 4],
 *       "to": [12, 16, 12],
 *       "faces": {
 *         "down": {"uv": [4, 4, 12, 12], "texture": "#end"},
 *         "up": {"uv": [4, 4, 12, 12], "texture": "#end"},
 *         "north": {"uv": [4, 0, 12, 16], "texture": "#texture"},
 *         "south": {"uv": [4, 0, 12, 16], "texture": "#texture"},
 *         "west": {"uv": [4, 0, 12, 16], "texture": "#texture"},
 *         "east": {"uv": [4, 0, 12, 16], "texture": "#texture"}
 *       }
 *     }
 *   ]
 * }
 */

/**
 * Loot table generation example.
 *
 * In your data generator class:
 *
 * @Override
 * protected void generate() {
 *     this.dropSelf(ModBlocks.STEEL_PIPE.get());
 * }
 *
 * Or with Registrate:
 *
 * REGISTRATE.block("steel_pipe", SteelPipeBlock::new)
 *     .loot((lt, block) -> lt.dropOther(block, block)) // Drops itself
 *     ...
 */

/**
 * Recipe generation example.
 *
 * In your recipe provider:
 *
 * ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_PIPE.get(), 4)
 *     .pattern("S S")
 *     .pattern("S S")
 *     .pattern("S S")
 *     .define('S', Items.IRON_INGOT)
 *     .unlockedBy("has_iron", has(Items.IRON_INGOT))
 *     .save(output);
 *
 * Or with Create's recipe builders for custom recipes:
 *
 * new ProcessingRecipeBuilder<>(MechanicalCraftingRecipe::new, modLoc("steel_pipe"))
 *     .require(Tags.Items.INGOTS_IRON, 6)
 *     .output(ModBlocks.STEEL_PIPE.get(), 4)
 *     .save(output);
 */

/**
 * Lang (localization) generation example.
 *
 * In your language provider:
 *
 * add(ModBlocks.STEEL_PIPE.get(), "Steel Pipe");
 *
 * Or with Registrate:
 *
 * REGISTRATE.block("steel_pipe", SteelPipeBlock::new)
 *     .lang("Steel Pipe")
 *     ...
 */