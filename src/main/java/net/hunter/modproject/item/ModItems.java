package net.hunter.modproject.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hunter.modproject.ModProject;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings()));
    public static final Item SAPPHIRESWORD = registerItem("sapphire_sword", new SwordItem(
            ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 2, -2.4F
    ))));
    public static final Item SAPPHIREPICKAXE = registerItem("sapphire_pickaxe", new PickaxeItem(
            ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 1.5F, -2.8F
    ))));
    public static final Item SAPPHIRESHOVEL = registerItem("sapphire_shovel", new ShovelItem(
            ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 1, -3.0F
    ))));
    public static final Item SAPPHIREAXE = registerItem("sapphire_axe", new AxeItem(
            ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 3, -3.0F
    ))));
    public static final Item SAPPHIREHOE = registerItem("sapphire_hoe", new HoeItem(
            ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, -3, 0F
    ))));
    public static final Item SAPPHIREHELMET = registerItem("sapphire_helmet", new ArmorItem(
            ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(30)
    )));
    public static final Item SAPPHIRELEGGINGS = registerItem("sapphire_leggings", new ArmorItem(
            ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(30)
    )));
    public static final Item SAPPHIREBOOTS = registerItem("sapphire_boots", new ArmorItem(
            ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(30)
    )));
    public static final Item SAPPHIRECHESTPLATE= registerItem("sapphire_chestplate", new ArmorItem(
            ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(30)
    )));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ModProject.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ModProject.LOGGER.info("Registering Mod items for " + ModProject.MOD_ID);
    }
}
