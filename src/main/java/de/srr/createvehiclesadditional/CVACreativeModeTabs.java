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
}