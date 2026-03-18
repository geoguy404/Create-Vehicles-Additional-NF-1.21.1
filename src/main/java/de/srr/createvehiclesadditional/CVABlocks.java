package de.srr.createvehiclesadditional;

import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import de.srr.createvehiclesadditional.content.fluids.pipes.gasPipe.GasPipeBlock;
import de.srr.createvehiclesadditional.content.kinectics.elementSeparator.ElementSeparatorBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

import static de.srr.createvehiclesadditional.CreateVehiclesAdditional.REGISTRATE;


public class CVABlocks {


    //------------------DECO BLOCKS------------------//
    public static final BlockEntry<Block> BLOCK_OF_CARBON = REGISTRATE
            .block("block_of_carbon", Block::new)
            .initialProperties(() -> Blocks.DEEPSLATE)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))
            .simpleItem()
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Block of Carbon")
            .register();

    public static final BlockEntry<Block> TEMPERATURE_OVEN = REGISTRATE
            .block("temperature_oven", Block::new)
            .initialProperties(() -> Blocks.CALCITE)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.CALCITE))
            .simpleItem()
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Temperature Oven")
            .register();

    public static final BlockEntry<Block> CARBON_FIBER_BLOCK = REGISTRATE
            .block("carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Carbon Fiber Block")
            .register();


////   ------------------SPECIAL BLOCKS------------------//
//    public static final BlockEntry<GasPipeBlock> GAS_PIPE = REGISTRATE
//            .block("gas_pipe", GasPipeBlock::new)
//            .initialProperties(() -> Blocks.COPPER_BLOCK)
//            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.COPPER))
//            .blockstate((ctx, prov) -> {})
//            .tag(BlockTags.NEEDS_STONE_TOOL)
//            .item()
//            .model((ctx, prov) -> {
//            }).build()
//            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
//            .loot(RegistrateBlockLootTables::dropSelf)
//            .lang("Gas Pipe")
//            .register();

//    //------------------KINETIC BLOCKS------------------//
public static final BlockEntry<ElementSeparatorBlock> ELEMENT_SEPARATOR = REGISTRATE
        .block("element_separator", ElementSeparatorBlock::new)
        .initialProperties(() -> Blocks.IRON_BLOCK)
        .properties(p -> p.strength(4f).noOcclusion().sound(SoundType.NETHERITE_BLOCK))
        .blockstate((ctx, prov) -> {})
        .simpleItem()
        .register();

    //------------------FORGED CARBON BLOCKS------------------//

    public static final BlockEntry<Block> GOLDEN_FORGED_CARBON_BLOCK = REGISTRATE
            .block("golden_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Golden Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> FORGED_CARBON_BLOCK = REGISTRATE
            .block("forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> BLACK_FORGED_CARBON_BLOCK = REGISTRATE
            .block("black_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Black Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> GRAY_FORGED_CARBON_BLOCK = REGISTRATE
            .block("gray_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Gray Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> LIGHT_GRAY_FORGED_CARBON_BLOCK = REGISTRATE
            .block("light_gray_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Light Gray Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> WHITE_FORGED_CARBON_BLOCK = REGISTRATE
            .block("white_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("White Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> BLUE_CARBON_FIBER_BLOCK = REGISTRATE
            .block("blue_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Blue Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> LIGHT_BLUE_FORGED_CARBON_BLOCK = REGISTRATE
            .block("light_blue_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Light Blue Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> CYAN_FORGED_CARBON_BLOCK = REGISTRATE
            .block("cyan_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Cyan Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> GREEN_FORGED_CARBON_BLOCK = REGISTRATE
            .block("green_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Green Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> LIME_FORGED_CARBON_BLOCK = REGISTRATE
            .block("lime_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Lime Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> YELLOW_FORGED_CARBON_BLOCK = REGISTRATE
            .block("yellow_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Yellow Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> ORANGE_FORGED_CARBON_BLOCK = REGISTRATE
            .block("orange_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Orange Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> RED_FORGED_CARBON_BLOCK = REGISTRATE
            .block("red_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Red Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> PINK_FORGED_CARBON_BLOCK = REGISTRATE
            .block("pink_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Pink Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> MAGENTA_FORGED_CARBON_BLOCK = REGISTRATE
            .block("magenta_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Magenta Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> PURPLE_FORGED_CARBON_BLOCK = REGISTRATE
            .block("purple_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Purple Forged Carbon Block")
            .register();

    public static final BlockEntry<Block> BROWN_FORGED_CARBON_BLOCK = REGISTRATE
            .block("brown_forged_carbon_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Brown Forged Carbon Block")
            .register();




    //------------------CARBON FIBER BLOCKS------------------//

    public static final BlockEntry<Block> GOLDEN_CARBON_FIBER_BLOCK = REGISTRATE
            .block("golden_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Golden Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> BLACK_CARBON_FIBER_BLOCK = REGISTRATE
            .block("black_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Black Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> GRAY_CARBON_FIBER_BLOCK = REGISTRATE
            .block("gray_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Gray Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> LIGHT_GRAY_CARBON_FIBER_BLOCK = REGISTRATE
            .block("light_gray_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Light Gray Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> WHITE_CARBON_FIBER_BLOCK = REGISTRATE
            .block("white_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("White Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> BLUE_FORGED_CARBON_BLOCK = REGISTRATE
            .block("blue_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Blue Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> LIGHT_BLUE_CARBON_FIBER_BLOCK = REGISTRATE
            .block("light_blue_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Light Blue Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> CYAN_CARBON_FIBER_BLOCK = REGISTRATE
            .block("cyan_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Cyan Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> GREEN_CARBON_FIBER_BLOCK = REGISTRATE
            .block("green_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Green Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> LIME_CARBON_FIBER_BLOCK = REGISTRATE
            .block("lime_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Lime Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> YELLOW_CARBON_FIBER_BLOCK = REGISTRATE
            .block("yellow_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Yellow Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> ORANGE_CARBON_FIBER_BLOCK = REGISTRATE
            .block("orange_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Orange Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> RED_CARBON_FIBER_BLOCK = REGISTRATE
            .block("red_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Red Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> PINK_CARBON_FIBER_BLOCK = REGISTRATE
            .block("pink_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Pink Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> MAGENTA_CARBON_FIBER_BLOCK = REGISTRATE
            .block("magenta_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Magenta Carbon Fiber Block")
            .register();

    public static final BlockEntry<Block> PURPLE_CARBON_FIBER_BLOCK = REGISTRATE
            .block("purple_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Purple Carbon Fiber Block")
            .item().tab(CVACreativeModeTabs.DECORATION_TAB.getKey()).build()
            .register();

    public static final BlockEntry<Block> BROWN_CARBON_FIBER_BLOCK = REGISTRATE
            .block("brown_carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Brown Carbon Fiber Block")
            .item().tab(CVACreativeModeTabs.DECORATION_TAB.getKey()).build()
            .register();



    public static void register() {
        // nur zum Classloading
    }
}