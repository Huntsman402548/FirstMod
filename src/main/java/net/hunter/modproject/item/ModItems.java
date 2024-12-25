package net.hunter.modproject.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hunter.modproject.ModProject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings()));
    public static final Item SAPPHIRESWORD = registerItem("sapphire_sword", new Item(new Item.Settings()
            .maxCount(1)
    ));

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(SAPPHIRE);
        entries.add(SAPPHIRESWORD);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ModProject.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ModProject.LOGGER.info("Registering Mod items for " + ModProject.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
