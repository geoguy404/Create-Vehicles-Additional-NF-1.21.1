package de.srr.createvehiclesadditional.Items;

import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.util.entry.ItemEntry;
import de.srr.createvehiclesadditional.util.ModTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;

import static de.srr.createvehiclesadditional.CreateVehiclesAdditional.REGISTRATE;

public class ModItems {

    public static final ItemEntry<Item> CARBON = REGISTRATE
            .item("carbon", Item::new)
            //.properties(p -> p.rarity(Rarity.COMMON))
            .burnTime(1000)
            .register();

    public static final ItemEntry<Item> BUCKET_OF_ACRYLONITRILE = REGISTRATE
            .item("bucket_of_acrylonitrile", Item::new)
            //.properties(p -> p.rarity(Rarity.UNCOMMON))
            //.tag(ModTags.Items.TRANSFORMABLE_ITEMS)
            //.model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<Item> POLYACRYLONITRILE_POWDER = REGISTRATE
            .item("polyacrylonitrile_powder", Item::new)
            //.properties(p -> p.rarity(Rarity.UNCOMMON))
            //.model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<Item> CARBON_ALLOY = REGISTRATE
            .item("carbon_alloy", Item::new)
            //.properties(p -> p.rarity(Rarity.UNCOMMON))
            //.model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<Item> CARBON_SHEET = REGISTRATE
            .item("carbon_sheet", Item::new)
            //.model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<Item> CARBON_FIBER_MASS = REGISTRATE
            .item("carbon_fiber_mass", Item::new)
            //.model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<Item> INCA_KOLA_BOTTLE = REGISTRATE
            .item("inca_kola_bottle", Item::new)
            //.properties(p -> p.food(ModFoodProperties.INCA_KOLA_BOTTLE))
            //.model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<Item> GAS_TANK = REGISTRATE
            .item("gas_tank", Item::new)
            //.model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<Item> HYDROGEN_TANK = REGISTRATE
            .item("hydrogen_tank", Item::new)
            //.model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<Item> NITROGEN_TANK = REGISTRATE
            .item("nitrogen_tank", Item::new)
            //.model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<Item> OXYGEN_TANK = REGISTRATE
            .item("oxygen_tank", Item::new)
            //.model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<Item> PROPYLENE_TANK = REGISTRATE
            .item("propylene_tank", Item::new)
            //.model(AssetLookup.existingItemModel())
            .register();

    public static final ItemEntry<Item> SULFUR_TANK = REGISTRATE
            .item("sulfur_tank", Item::new)
            //.model(AssetLookup.existingItemModel())
            .register();

    public static void register(IEventBus eventBus) {
        // Class loading
    }

}
