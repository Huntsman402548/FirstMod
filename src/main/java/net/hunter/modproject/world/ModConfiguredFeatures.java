package net.hunter.modproject.world;

import net.hunter.modproject.block.ModBlocks;
import net.hunter.modproject.ModProject;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_BURIED_KEY = registerKey("sapphire_ore_buried");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_SMALL_KEY = registerKey("sapphire_ore_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_MEDIUM_KEY = registerKey("sapphire_ore_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_LARGE_KEY = registerKey("sapphire_ore_large");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldSapphireOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SAPPHIRE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState()));


        register(context, SAPPHIRE_ORE_BURIED_KEY, Feature.ORE, new OreFeatureConfig(overworldSapphireOres, 8, 1.0f));
        register(context, SAPPHIRE_ORE_SMALL_KEY, Feature.ORE, new OreFeatureConfig(overworldSapphireOres, 2, 0.1f));
        register(context, SAPPHIRE_ORE_MEDIUM_KEY, Feature.ORE, new OreFeatureConfig(overworldSapphireOres, 6, 0.3f));
        register(context, SAPPHIRE_ORE_LARGE_KEY, Feature.ORE, new OreFeatureConfig(overworldSapphireOres, 8, 0.5f));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ModProject.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

