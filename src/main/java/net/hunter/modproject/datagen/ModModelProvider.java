package net.hunter.modproject.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hunter.modproject.block.ModBlocks;
import net.hunter.modproject.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);;

        itemModelGenerator.register(ModItems.SAPPHIRESWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIREAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIREPICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRESHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIREHOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SAPPHIREHELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SAPPHIRECHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SAPPHIRELEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SAPPHIREBOOTS));


    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIREORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIREBLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATESAPPHIREORE);

        }


}