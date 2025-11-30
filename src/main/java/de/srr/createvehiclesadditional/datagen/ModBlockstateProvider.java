package de.srr.createvehiclesadditional.datagen;


import de.srr.createvehiclesadditional.Blocks.ModBlocks;
import de.srr.createvehiclesadditional.CreateVehiclesAdditional;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockstateProvider extends BlockStateProvider {
    public ModBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CreateVehiclesAdditional.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLOCK_OF_CARBON);
        blockWithItem(ModBlocks.CARBON_FIBER_BLOCK);
        blockFrontTopBottomAndSides(ModBlocks.TEMPERATURE_OVEN, "front","top","bottom","side");
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));


    }

    private void fancyBlock(DeferredBlock<?> block) {
        simpleBlockWithItem(
                block.get(),
                models().cube(
                        name(block),
                        modLoc("block/" + name(block) + "_down"),
                        modLoc("block/" + name(block) + "_up"),
                        modLoc("block/" + name(block) + "_north"),
                        modLoc("block/" + name(block) + "_south"),
                        modLoc("block/" + name(block) + "_west"),
                        modLoc("block/" + name(block) + "_east")
                )
        );
    }

    private void blockFrontTopBottomAndSides(DeferredBlock<?> block,
                                             String front,
                                             String top,
                                             String bottom,
                                             String side) {

        simpleBlockWithItem(
                block.get(),
                models().cube(
                        name(block),
                        modLoc("block/" + name(block)+ "_" + bottom),  // down
                        modLoc("block/" + name(block)+ "_" + top),     // up
                        modLoc("block/" + name(block)+ "_" + front),   // north
                        modLoc("block/" + name(block)+ "_" + side),    // south
                        modLoc("block/" + name(block)+ "_" + side),    // west
                        modLoc("block/" + name(block)+ "_" + side)     // east
                )
        );
    }

    private String name(DeferredBlock<?> block) {
        return block.getId().getPath();
    }

}
