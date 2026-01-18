package de.srr.createvehiclesadditional.datagen;

import de.srr.createvehiclesadditional.CreateVehiclesAdditional;
import de.srr.createvehiclesadditional.Items.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateVehiclesAdditional.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        handheldItem(ModItems.CARBON_SWORD.get());
        handheldItem(ModItems.CARBON_AXE.get());
        handheldItem(ModItems.CARBON_PICKAXE.get());
        handheldItem(ModItems.CARBON_HOE.get());
        handheldItem(ModItems.CARBON_SHOVEL.get());

        basicItem(ModItems.CARBON.get());
        basicItem(ModItems.BUCKET_OF_ACRYLONITRILE.get());
        basicItem(ModItems.POLYACRYLONITRILE_POWDER.get());
        basicItem(ModItems.CARBON_ALLOY.get());
        basicItem(ModItems.CARBON_SHEET.get());
        basicItem(ModItems.CARBON_FIBER_MASS.get());
        basicItem(ModItems.FORGED_CARBON.get());
    }
}
