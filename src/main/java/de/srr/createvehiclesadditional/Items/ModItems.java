package de.srr.createvehiclesadditional.Items;

import de.srr.createvehiclesadditional.CreateVehiclesAdditional;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems{

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateVehiclesAdditional.MOD_ID);

    public static final DeferredItem<Item> CARBON = ITEMS.registerItem(
            "carbon",
            Item::new,
            new Item.Properties()
    );

    public static final DeferredItem<Item> BUCKET_OF_ACRYLONITRILE = ITEMS.registerItem(
            "bucket_of_acrylonitrile",
            Item::new,
            new Item.Properties()
    );

    public static final DeferredItem<Item> POLYACRYLONITRILE_POWDER = ITEMS.registerItem(
            "polyacrylonitrile_powder",
            Item::new,
            new Item.Properties()
    );

    public static final DeferredItem<Item> CARBON_ALLOY = ITEMS.registerItem(
            "carbon_alloy",
            Item::new,
            new Item.Properties()
    );

    public static final DeferredItem<Item> CARBON_SHEET = ITEMS.registerItem(
            "carbon_sheet",
            Item::new,
            new Item.Properties()
    );

    public static final DeferredItem<Item> CARBON_FIBER_MASS = ITEMS.registerItem(
            "carbon_fiber_mass",
            Item::new,
            new Item.Properties()
    );



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}