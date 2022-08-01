package soulcollector.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import soulcollector.blocks.SoulCollectorBlocks;

import java.util.Arrays;

public class SoulCollectorConfiguredFeatures {
    private static final ConfiguredFeature<?, ?> OVERWORLD_SINGULARITY_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    SoulCollectorBlocks.SINGULARITY_ORE.getDefaultState(), 5));
    private static final ConfiguredFeature<?, ?> OVERWORLD_BEBROCK_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    SoulCollectorBlocks.BEBROCK_ORE.getDefaultState(), 3));
    private static final ConfiguredFeature<?, ?> DEEPSLATE_SINGULARITY_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    SoulCollectorBlocks.DEEPSLATE_SINGULARITY_ORE.getDefaultState(), 5));
    private static final ConfiguredFeature<?, ?> HELLSTONE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.NETHERRACK,
                    SoulCollectorBlocks.HELLSTONE_ORE.getDefaultState(), 3));

    public static PlacedFeature OVERWORLD_SINGULARITY_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_SINGULARITY_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(6),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.fixed(1), YOffset.fixed(16))));
    public static PlacedFeature OVERWORLD_BEBROCK_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_BEBROCK_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(3),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-63), YOffset.fixed(-60))));
    public static PlacedFeature DEEPSLATE_SINGULARITY_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(DEEPSLATE_SINGULARITY_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(4),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-63), YOffset.fixed(8))));
    public static PlacedFeature HELLSTONE_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(HELLSTONE_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(6),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.fixed(2), YOffset.fixed(127))));

    public static void register(){
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("soulcoll", "singularity_ore"), OVERWORLD_SINGULARITY_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("soulcoll", "singularity_ore"),
                OVERWORLD_SINGULARITY_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("soulcoll", "singularity_ore")));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("soulcoll", "bebrock_ore"), OVERWORLD_BEBROCK_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("soulcoll", "bebrock_ore"),
                OVERWORLD_BEBROCK_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("soulcoll", "bebrock_ore")));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("soulcoll", "deepslate_singularity_ore"), DEEPSLATE_SINGULARITY_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("soulcoll", "deepslate_singularity_ore"),
                DEEPSLATE_SINGULARITY_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("soulcoll", "deepslate_singularity_ore")));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("soulcoll", "hellstone_ore"), HELLSTONE_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("soulcoll", "hellstone_ore"),
                HELLSTONE_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("soulcoll", "hellstone_ore")));
    }
}
