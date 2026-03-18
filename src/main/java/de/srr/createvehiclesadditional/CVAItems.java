package de.srr.createvehiclesadditional;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.*;

import static de.srr.createvehiclesadditional.CreateVehiclesAdditional.REGISTRATE;

public class CVAItems {

    public static final ItemEntry<Item> CARBON = REGISTRATE
            .item("carbon", Item::new)
            .properties(p -> p.rarity(Rarity.COMMON))
            .burnTime(1000)
            .register();

    public static final ItemEntry<Item> BUCKET_OF_ACRYLONITRILE = REGISTRATE
            .item("bucket_of_acrylonitrile", Item::new)
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .tag(CVATags.Items.TRANSFORMABLE_ITEMS)
            .register();

    public static final ItemEntry<Item> POLYACRYLONITRILE_POWDER = REGISTRATE
            .item("polyacrylonitrile_powder", Item::new)
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .register();

    public static final ItemEntry<Item> CARBON_ALLOY = REGISTRATE
            .item("carbon_alloy", Item::new)
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .register();

    public static final ItemEntry<Item> CARBON_SHEET = REGISTRATE
            .item("carbon_sheet", Item::new)
            .register();

    public static final ItemEntry<Item> CARBON_NUGGET = REGISTRATE
            .item("carbon_nugget", Item::new)
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .register();

    public static final ItemEntry<Item> CARBON_FIBER_MASS = REGISTRATE
            .item("carbon_fiber_mass", Item::new)
            .register();

    public static final ItemEntry<Item> INCA_KOLA_BOTTLE = REGISTRATE
            .item("inca_kola_bottle", Item::new)
            .properties(p -> p.food(CVAFoodProperties.INCA_KOLA_BOTTLE))
            .register();

    public static final ItemEntry<Item> GAS_TANK = REGISTRATE
            .item("gas_tank", Item::new)
            .register();

    public static final ItemEntry<Item> HYDROGEN_TANK = REGISTRATE
            .item("hydrogen_tank", Item::new)
            .register();

    public static final ItemEntry<Item> NITROGEN_TANK = REGISTRATE
            .item("nitrogen_tank", Item::new)
            .register();

    public static final ItemEntry<Item> OXYGEN_TANK = REGISTRATE
            .item("oxygen_tank", Item::new)
            .register();

    public static final ItemEntry<Item> PROPYLENE_TANK = REGISTRATE
            .item("propylene_tank", Item::new)
            .register();

    public static final ItemEntry<Item> SULFUR_TANK = REGISTRATE
            .item("sulfur_tank", Item::new)
            .register();

    public static final ItemEntry<Item> CARBON_FIBER = REGISTRATE
            .item("carbon_fiber", Item::new)
            .lang("Carbon Fiber")
            .register();

    public static final ItemEntry<Item> FORGED_CARBON = REGISTRATE
            .item("forged_carbon", Item::new)
            .lang("Forged Carbon")
            .register();

    public static final ItemEntry<AxeItem> CARBON_AXE = REGISTRATE
            .item("carbon_axe", p -> new AxeItem(
                    CVAToolTiers.CARBON, p ))
            .properties(properties -> properties.attributes(SwordItem.createAttributes(CVAToolTiers.CARBON,6,-3.2f)))
            .lang("Carbon Axe")
            .register();

    public static final ItemEntry<PickaxeItem> CARBON_PICKAXE = REGISTRATE
            .item("carbon_pickaxe", p -> new PickaxeItem(
                    CVAToolTiers.CARBON, p ))
            .properties(properties -> properties.attributes(SwordItem.createAttributes(CVAToolTiers.CARBON,1,-2.8f)))
            .lang("Carbon Pickaxe")
            .register();

    public static final ItemEntry<SwordItem> CARBON_SWORD = REGISTRATE
            .item("carbon_sword", p -> new SwordItem(
                    CVAToolTiers.CARBON, p ))
            .properties(properties -> properties.attributes(SwordItem.createAttributes(CVAToolTiers.CARBON,5,-3.0f)))
            .lang("Carbon Sword")
            .register();

    public static final ItemEntry<HoeItem> CARBON_HOE = REGISTRATE
            .item("carbon_hoe", p -> new HoeItem(
                    CVAToolTiers.CARBON, p ))
            .properties(properties -> properties.attributes(HoeItem.createAttributes(CVAToolTiers.CARBON,0,-3.0f)))
            .lang("Carbon Hoe")
            .register();

        public static final ItemEntry<ShovelItem> CARBON_SHOVEL = REGISTRATE
                .item("carbon_shovel", p -> new ShovelItem(
                        CVAToolTiers.CARBON, p ))
                .properties(p -> p.attributes(ShovelItem.createAttributes(CVAToolTiers.CARBON,1.5f,-3.0f)))
                .lang("Carbon Shovel")
                .register();

    public static void register() {
        // Class loading
    }

}
