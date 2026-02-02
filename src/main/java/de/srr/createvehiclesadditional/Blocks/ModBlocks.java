package de.srr.createvehiclesadditional.Blocks;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

import static de.srr.createvehiclesadditional.CreateVehiclesAdditional.REGISTRATE;

import net.neoforged.bus.api.IEventBus;

import java.util.List;

public class ModBlocks {


    //------------------DECO BLOCKS------------------//

    public static final BlockEntry<Block> BLOCK_OF_CARBON = REGISTRATE
            .block("block_of_carbon", Block::new)
            .initialProperties(() -> Blocks.DEEPSLATE)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))
            .simpleItem()
            .register();

//    public static final BlockEntry<Block> TEMPERATURE_OVEN = REGISTRATE
//            .block("temperature_oven", Block::new)
//            .initialProperties(() -> Blocks.CALCITE)
//            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.CALCITE))
//            .simpleItem()
//            .register();

    public static final BlockEntry<Block> CARBON_FIBER_BLOCK = REGISTRATE
            .block("carbon_fiber_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CONNECTOR = REGISTRATE
            .block("connector", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .blockstate((ctx, prov) -> {})
            .simpleItem()
            .register();

    //------------------SPECIAL BLOCKS------------------//

    public static final BlockEntry<GasPipeBlock> GAS_PIPE = REGISTRATE
            .block("gas_pipe", GasPipeBlock::new)
            .initialProperties(() -> Blocks.COPPER_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.COPPER))
            .blockstate((ctx, prov) -> {})
            .simpleItem()
            .register();


    //------------------KINETIC BLOCKS------------------//

    public static final BlockEntry<ElementSeparatorBlock> ELEMENT_SEPARATOR = REGISTRATE
            .block("element_separator", ElementSeparatorBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(p -> p.strength(4f).noOcclusion().sound(SoundType.NETHERITE_BLOCK))
            .blockstate((ctx, prov) -> {})
            .simpleItem()
            .register();


    public static void register(IEventBus modEventBus) {
        // nur zum Classloading
    }


    public static final List<BlockEntry<?>> ALL_BLOCKS = List.of(
            BLOCK_OF_CARBON,
            //TEMPERATURE_OVEN,
            CARBON_FIBER_BLOCK,
            //GAS_PIPE,
            ELEMENT_SEPARATOR
    );

}