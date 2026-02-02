package de.srr.createvehiclesadditional.Blocks;

import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import de.srr.createvehiclesadditional.CreateVehiclesAdditional;
import de.srr.createvehiclesadditional.Items.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

import static de.srr.createvehiclesadditional.CreateVehiclesAdditional.REGISTRATE;


public class ModBlocks {


    //------------------DECO BLOCKS------------------//
    public static final BlockEntry<Block> BLOCK_OF_CARBON = REGISTRATE
            .block("block_of_carbon", Block::new)
            .initialProperties(() -> Blocks.DEEPSLATE)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))
            .simpleItem()
            //.blockstate((c, p) ->{})
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Block of Carbon")
            .register();

    public static final BlockEntry<Block> TEMPERATURE_OVEN = REGISTRATE
            .block("temperature_oven", Block::new)
            .initialProperties(() -> Blocks.CALCITE)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.CALCITE))
            //.blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.standardModel(c, p)))
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
            //.blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.standardModel(c, p)))
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Carbon Fiber Block")
            .register();

   //------------------SPECIAL BLOCKS------------------//
    public static final BlockEntry<GasPipeBlock> GAS_PIPE = REGISTRATE
            .block("gas_pipe", GasPipeBlock::new)
            .initialProperties(() -> Blocks.COPPER_BLOCK)
            .properties(p -> p.strength(4f).requiresCorrectToolForDrops().sound(SoundType.COPPER))
            .blockstate((ctx, prov) -> {})
            .tag(BlockTags.NEEDS_STONE_TOOL)
            .item()
            .model((ctx, prov) -> {
            }).build()
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Gas Pipe")
            .register();


//    //------------------KINETIC BLOCKS------------------//
    public static final BlockEntry<ElementSeparatorBlock> ELEMENT_SEPARATOR = REGISTRATE
            .block("element_separator", ElementSeparatorBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(p -> p.strength(4f).noOcclusion().sound(SoundType.NETHERITE_BLOCK))
            .blockstate((ctx, prov) -> {})
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .simpleItem()
            .loot(RegistrateBlockLootTables::dropSelf)
            .lang("Element Separator")
            .register();

    public static void register() {
        // nur zum Classloading
    }
}