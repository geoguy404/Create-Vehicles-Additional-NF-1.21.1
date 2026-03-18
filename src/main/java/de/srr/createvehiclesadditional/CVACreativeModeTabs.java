package de.srr.createvehiclesadditional;

import com.tterrag.registrate.util.entry.RegistryEntry;
import de.srr.createvehiclesadditional.content.fluids.pipes.CVAPipeEntry;
import de.srr.createvehiclesadditional.content.fluids.pipes.CVAPipes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.DisplayItemsGenerator;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

import static de.srr.createvehiclesadditional.content.fluids.pipes.CVAPipes.PIPES;

public class CVACreativeModeTabs {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateVehiclesAdditional.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB =
            CREATIVE_MODE_TAB.register("mod_items_tab",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("Create Vehicles Additional"))
                            // Use a lazy supplier for the icon
                            .icon(() -> new ItemStack(CVAItems.CARBON.get()))
                            .displayItems(new ModDisplayItemsGenerator())
                            .build());


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PIPE_TAB =
            CREATIVE_MODE_TAB.register("pipe_tab",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemgroup.pipes"))
                            // Use a lazy supplier for the icon
                            .icon(() -> new ItemStack(PIPES.get(CVAPipes.PipeMaterial.STEEL).getPipe().asItem()))
                            .displayItems(CVAPipes::addCreativeTabItems)
                            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DECORATION_TAB =
            CREATIVE_MODE_TAB.register("decoration_tab",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemgroup.decoration"))
                            .icon(() -> new ItemStack(CVABlocks.BLACK_FORGED_CARBON_BLOCK.asItem()))
                            .displayItems(new DecorationDisplayItemsGenerator())
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


    private static class ModDisplayItemsGenerator implements DisplayItemsGenerator {
        @Override
        public void accept(ItemDisplayParameters parameters, Output output) {
            // Collect all blocks first
            List<Item> blocks = collectBlocks();
            // Then collect all items
            List<Item> items = collectItems();

            // Output blocks first
            for (Item block : blocks) {
                output.accept(new ItemStack(block));
            }

            // Then output items
            for (Item item : items) {
                output.accept(new ItemStack(item));
            }
        }

        private List<Item> collectBlocks() {
            List<Item> blocks = new ArrayList<>();

            // Get all registered blocks from your Registrate
            for (RegistryEntry<Block, Block> entry : CreateVehiclesAdditional.REGISTRATE.getAll(Registries.BLOCK)) {
                Block block = entry.get();
                Item item = block.asItem();

                // Skip if block has no item form
                if (item == Items.AIR) {
                    continue;
                }

                blocks.add(item);
            }

            return blocks;
        }

        private List<Item> collectItems() {
            List<Item> items = new ArrayList<>();

            // Get all registered items from your Registrate
            for (RegistryEntry<Item, Item> entry : CreateVehiclesAdditional.REGISTRATE.getAll(Registries.ITEM)) {
                Item item = entry.get();

                // Skip block items (already added in blocks section)
                if (item instanceof BlockItem) {
                    continue;
                }

                items.add(item);
            }

            return items;
        }
    }

    private static class DecorationDisplayItemsGenerator implements DisplayItemsGenerator {
        @Override
        public void accept(ItemDisplayParameters parameters, Output output) {
            // Forged Carbon Blocks
            output.accept(CVABlocks.BLACK_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.WHITE_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.GRAY_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.LIGHT_GRAY_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.BROWN_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.RED_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.ORANGE_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.YELLOW_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.LIME_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.GREEN_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.CYAN_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.LIGHT_BLUE_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.BLUE_CARBON_FIBER_BLOCK.asItem()); // note: this is BLUE_FORGED in your field name
            output.accept(CVABlocks.PURPLE_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.MAGENTA_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.PINK_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.GOLDEN_FORGED_CARBON_BLOCK.asItem());
            output.accept(CVABlocks.FORGED_CARBON_BLOCK.asItem());

            // Carbon Fiber Blocks
            output.accept(CVABlocks.BLACK_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.WHITE_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.GRAY_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.LIGHT_GRAY_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.BROWN_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.RED_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.ORANGE_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.YELLOW_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.LIME_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.GREEN_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.CYAN_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.LIGHT_BLUE_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.BLUE_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.PURPLE_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.MAGENTA_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.PINK_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.GOLDEN_CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.CARBON_FIBER_BLOCK.asItem());
            output.accept(CVABlocks.BLOCK_OF_CARBON.asItem());
        }
    }
}