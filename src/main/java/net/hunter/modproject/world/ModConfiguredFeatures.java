package net.hunter.modproject.world;

import net.hunter.modproject.block.ModBlocks;
import net.hunter.modproject.ModProject;
import net.hunter.modproject.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_BURIED = registerKey("sapphire_ore_buried");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_SMALL = registerKey("sapphire_ore_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_MEDIUM = registerKey("sapphire_ore_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_LARGE = registerKey("sapphire_ore_large");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldSapphireOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SAPPHIREORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATESAPPHIREORE.getDefaultState()));


        register(context, SAPPHIRE_ORE_BURIED, Feature.ORE, new OreFeatureConfig(overworldSapphireOres, 12, 1.0f));
        register(context, SAPPHIRE_ORE_SMALL, Feature.ORE, new OreFeatureConfig(overworldSapphireOres, 6, 0.1f));
        register(context, SAPPHIRE_ORE_MEDIUM, Feature.ORE, new OreFeatureConfig(overworldSapphireOres, 10, 0.3f));
        register(context, SAPPHIRE_ORE_LARGE, Feature.ORE, new OreFeatureConfig(overworldSapphireOres, 12, 0.5f));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ModProject.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

