package net.hunter.modproject.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hunter.modproject.ModProject;
import net.hunter.modproject.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SAPPHIRE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ModProject.MOD_ID, "sapphire"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.sapphire"))
                    .icon(() -> new ItemStack(ModItems.SAPPHIRE)).entries((displayContext, entries) -> {
                     entries.add(ModItems.SAPPHIRE);
                     entries.add(ModItems.SAPPHIRESWORD);
                     entries.add(ModItems.SAPPHIREHELMET);
                     entries.add(ModItems.SAPPHIREBOOTS);
                     entries.add(ModItems.SAPPHIRECHESTPLATE);
                     entries.add(ModItems.SAPPHIRELEGGINGS);
                     entries.add(ModBlocks.SAPPHIREBLOCK);
                     entries.add(ModBlocks.SAPPHIREORE);
                     entries.add(ModBlocks.DEEPSLATESAPPHIREORE);
                     entries.add(ModItems.SAPPHIREAXE);
                     entries.add(ModItems.SAPPHIREHOE);
                     entries.add(ModItems.SAPPHIRESHOVEL);
                     entries.add(ModItems.SAPPHIREPICKAXE);
                    }).build());

    public static void registerItemGroups() {


        ModProject.LOGGER.info("Registering Item groups for " + ModProject.MOD_ID);
    }
}
