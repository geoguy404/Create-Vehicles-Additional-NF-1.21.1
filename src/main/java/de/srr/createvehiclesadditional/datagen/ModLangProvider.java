package de.srr.createvehiclesadditional.datagen;

import de.srr.createvehiclesadditional.Blocks.ModBlocks;
import de.srr.createvehiclesadditional.CreateVehiclesAdditional;
import de.srr.createvehiclesadditional.Items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLangProvider extends LanguageProvider {

    public ModLangProvider(PackOutput output) {
        super(output, CreateVehiclesAdditional.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        ModItems.ITEMS.getEntries().forEach(deferredItem -> {
            Item item = deferredItem.get();
            String name = deferredItem.getId().getPath();
            add(item, prettyName(name));
        });


        ModBlocks.ALL_BLOCKS.forEach(blockEntry -> {
            Block block = blockEntry.get();
            String name = blockEntry.getId().getPath();
            add(block, prettyName(name));
        });

    }


    private static String prettyName(String id) {
        String[] parts = id.split("_");
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1))
                    .append(" ");
        }
        return result.toString().trim();
    }
}
