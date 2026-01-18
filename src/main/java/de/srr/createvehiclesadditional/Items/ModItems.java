package de.srr.createvehiclesadditional.Items;

import com.simibubi.create.AllCreativeModeTabs;
import de.srr.createvehiclesadditional.CreateVehiclesAdditional;
import net.minecraft.world.item.*;
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

    public static final DeferredItem<Item> INCA_KOLA_BOTTLE = ITEMS.registerItem(
            "inca_kola_bottle",
            Item::new,
            new Item.Properties().food(ModFoodProperties.INCA_KOLA_BOTTLE)
    );

    public static final DeferredItem<Item> GAS_TANK = ITEMS.registerItem(
            "gas_tank",
            Item::new,
            new Item.Properties()

    );

    public static final DeferredItem<Item> HYDROGEN_TANK = ITEMS.registerItem(
            "hydrogen_tank",
            Item::new,
            new Item.Properties()

    );

    public static final DeferredItem<Item> NITROGEN_TANK = ITEMS.registerItem(
            "nitrogen_tank",
            Item::new,
            new Item.Properties()

    );

    public static final DeferredItem<Item> OXYGEN_TANK = ITEMS.registerItem(
            "oxygen_tank",
            Item::new,
            new Item.Properties()

    );

    public static final DeferredItem<Item> PROPYLENE_TANK = ITEMS.registerItem(
            "propylene_tank",
            Item::new,
            new Item.Properties()

    );

    public static final DeferredItem<Item> SULFUR_TANK = ITEMS.registerItem(
            "sulfur_tank",
            Item::new,
            new Item.Properties()

    );

    public static final DeferredItem<SwordItem> CARBON_SWORD = ITEMS.register("carbon_sword",
            () -> new SwordItem(ModToolTiers.CARBON, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.CARBON, 5, -2.4f))));

    public static final DeferredItem<AxeItem> CARBON_AXE = ITEMS.register("carbon_axe",
            () -> new AxeItem(ModToolTiers.CARBON, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CARBON, 6.0F, -3.2f))));

    public static final DeferredItem<PickaxeItem> CARBON_PICKAXE = ITEMS.register("carbon_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CARBON, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CARBON, 1.0F, -2.8f))));

    public static final DeferredItem<ShovelItem> CARBON_SHOVEL = ITEMS.register("carbon_shovel",
            () -> new ShovelItem(ModToolTiers.CARBON, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CARBON, 1.5F, -3.0f))));

    public static final DeferredItem<HoeItem> CARBON_HOE = ITEMS.register("carbon_hoe",
            () -> new HoeItem(ModToolTiers.CARBON, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CARBON, 0, -3.0f))));




    public static final DeferredItem<Item> FORGED_CARBON = ITEMS.registerItem(
            "forged_carbon",
            Item::new,
            new Item.Properties()

    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}